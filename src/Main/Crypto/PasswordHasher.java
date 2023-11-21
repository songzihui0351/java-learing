package Main.Crypto;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

public class PasswordHasher<T> {

    private final PasswordHasherCompatibilityMode compatibilityMode;
    private final SecureRandom rng;
    private int iterCount;

    public PasswordHasher(PasswordHasherOptions options) {
        this.compatibilityMode = options.getCompatibilityMode();
        switch (this.compatibilityMode) {
            case IdentityV2:
                // nothing else to do
                break;
            case IdentityV3:
                this.iterCount = options.getIterationCount();
                if (this.iterCount < 1) {
                    throw new IllegalStateException("InvalidPasswordHasherIterationCount");
                }
                break;
            default:
                throw new IllegalStateException("InvalidPasswordHasherCompatibilityMode");
        }
        this.rng = options.getRng();
    }

    private static boolean byteArraysEqual(byte[] a, byte[] b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null || a.length != b.length) {
            return false;
        }
        boolean areSame = true;
        for (int i = 0; i < a.length; i++) {
            areSame &= (a[i] == b[i]);
        }
        return areSame;
    }

    private static byte[] hashPasswordV2(String password, SecureRandom rng) {
        final int pbkdf2IterCount = 1000; // default for Rfc2898DeriveBytes
        final int pbkdf2SubkeyLength = 256 / 8; // 256 bits
        final int saltSize = 128 / 8; // 128 bits

        byte[] salt = new byte[saltSize];
        rng.nextBytes(salt);

        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, pbkdf2IterCount, pbkdf2SubkeyLength * 8);
        SecretKeyFactory factory;
        try {
            factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] subkey = factory.generateSecret(spec).getEncoded();

            byte[] outputBytes = new byte[1 + saltSize + pbkdf2SubkeyLength];
            outputBytes[0] = 0x00; // format marker
            System.arraycopy(salt, 0, outputBytes, 1, saltSize);
            System.arraycopy(subkey, 0, outputBytes, 1 + saltSize, pbkdf2SubkeyLength);
            return outputBytes;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static int readNetworkByteOrder(byte[] buffer, int offset) {
        return ((buffer[offset] & 0xff) << 24)
                | ((buffer[offset + 1] & 0xff) << 16)
                | ((buffer[offset + 2] & 0xff) << 8)
                | ((buffer[offset + 3] & 0xff));
    }

    private static boolean verifyHashedPasswordV2(byte[] hashedPassword, String password) {
        final int pbkdf2IterCount = 1000; // default for Rfc2898DeriveBytes
        final int pbkdf2SubkeyLength = 256 / 8; // 256 bits
        final int saltSize = 128 / 8; // 128 bits

        if (hashedPassword.length != 1 + saltSize + pbkdf2SubkeyLength) {
            return false;
        }

        byte[] salt = new byte[saltSize];
        System.arraycopy(hashedPassword, 1, salt, 0, salt.length);

        byte[] expectedSubkey = new byte[pbkdf2SubkeyLength];
        System.arraycopy(hashedPassword, 1 + salt.length, expectedSubkey, 0, expectedSubkey.length);

        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, pbkdf2IterCount, pbkdf2SubkeyLength * 8);
        SecretKeyFactory factory;
        try {
            factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] actualSubkey = factory.generateSecret(spec).getEncoded();
            return byteArraysEqual(actualSubkey, expectedSubkey);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean verifyHashedPasswordV3(byte[] hashedPassword, String password, int iterCount) {
        try {
            int prf = readNetworkByteOrder(hashedPassword, 1);
            iterCount = readNetworkByteOrder(hashedPassword, 5);
            int saltLength = readNetworkByteOrder(hashedPassword, 9);

            if (saltLength < 128 / 8) {
                return false;
            }

            byte[] salt = new byte[saltLength];
            System.arraycopy(hashedPassword, 13, salt, 0, salt.length);

            int subkeyLength = hashedPassword.length - 13 - salt.length;
            if (subkeyLength < 128 / 8) {
                return false;
            }

            byte[] expectedSubkey = new byte[subkeyLength];
            System.arraycopy(hashedPassword, 13 + salt.length, expectedSubkey, 0, expectedSubkey.length);

            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterCount, subkeyLength * 8);
            SecretKeyFactory factory;
            try {
                factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
                byte[] actualSubkey = factory.generateSecret(spec).getEncoded();
                return byteArraysEqual(actualSubkey, expectedSubkey);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            return false;
        }
    }

    private static void writeNetworkByteOrder(byte[] buffer, int offset, int value) {
        buffer[offset] = (byte) (value >> 24);
        buffer[offset + 1] = (byte) (value >> 16);
        buffer[offset + 2] = (byte) (value >> 8);
        buffer[offset + 3] = (byte) (value);
    }

    public String hashPassword(T user, String password) {
        if (password == null) {
            throw new IllegalArgumentException("password");
        }
        if (this.compatibilityMode == PasswordHasherCompatibilityMode.IdentityV2) {
            return Base64.getEncoder().encodeToString(hashPasswordV2(password, this.rng));
        } else {
            return Base64.getEncoder().encodeToString(hashPasswordV3(password, this.rng));
        }
    }

    private byte[] hashPasswordV3(String password, SecureRandom rng) {
        final int saltSize = 128 / 8; // 128 bits
        final int numBytesRequested = 256 / 8; // 256 bits

        byte[] salt = new byte[saltSize];
        rng.nextBytes(salt);

        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, this.iterCount, numBytesRequested * 8);
        SecretKeyFactory factory;
        try {
            factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] subkey = factory.generateSecret(spec).getEncoded();

            byte[] outputBytes = new byte[13 + salt.length + subkey.length];
            outputBytes[0] = 0x01; // format marker
            writeNetworkByteOrder(outputBytes, 1, 2); // prf
            writeNetworkByteOrder(outputBytes, 5, this.iterCount);
            writeNetworkByteOrder(outputBytes, 9, saltSize);
            System.arraycopy(salt, 0, outputBytes, 13, salt.length);
            System.arraycopy(subkey, 0, outputBytes, 13 + salt.length, subkey.length);
            return outputBytes;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public PasswordVerificationResult verifyHashedPassword(T user, String hashedPassword, String providedPassword) {
        if (hashedPassword == null) {
            throw new IllegalArgumentException("hashedPassword");
        }
        if (providedPassword == null) {
            throw new IllegalArgumentException("providedPassword");
        }

        byte[] decodedHashedPassword = Base64.getDecoder().decode(hashedPassword);

        if (decodedHashedPassword.length == 0) {
            return PasswordVerificationResult.Failed;
        }

        switch (decodedHashedPassword[0]) {
            case 0x00:
                if (verifyHashedPasswordV2(decodedHashedPassword, providedPassword)) {
                    return (this.compatibilityMode == PasswordHasherCompatibilityMode.IdentityV3)
                            ? PasswordVerificationResult.SuccessRehashNeeded
                            : PasswordVerificationResult.Success;
                } else {
                    return PasswordVerificationResult.Failed;
                }
            case 0x01:
                int embeddedIterCount = 0;
                if (verifyHashedPasswordV3(decodedHashedPassword, providedPassword, embeddedIterCount)) {
                    return (embeddedIterCount < this.iterCount)
                            ? PasswordVerificationResult.SuccessRehashNeeded
                            : PasswordVerificationResult.Success;
                } else {
                    return PasswordVerificationResult.Failed;
                }
            default:
                return PasswordVerificationResult.Failed;
        }
    }
}



