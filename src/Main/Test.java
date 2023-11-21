package Main;

import Main.Crypto.PasswordHasher;
import Main.Crypto.PasswordHasherOptions;

class Test {
    public static void main(String[] args) {
        String encoded = "AQAAAAEAACcQAAAAENpdG4OqqcpPFTLDRC9tbUQ///H6NSd8xt55CxdIuja4Tunpnwktuew9SjKBfHV6iA==";
        PasswordHasher<String> hasher = new PasswordHasher<String>(new PasswordHasherOptions());
        System.out.println(hasher.hashPassword("123", "123456"));
        System.out.println(hasher.verifyHashedPassword(null, encoded, "qwe123"));
    }
}
