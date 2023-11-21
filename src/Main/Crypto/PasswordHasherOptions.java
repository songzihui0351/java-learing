package Main.Crypto;

import java.security.SecureRandom;

public class PasswordHasherOptions {
    private static final SecureRandom defaultRng = new SecureRandom(); // secure PRNG

    private PasswordHasherCompatibilityMode compatibilityMode = PasswordHasherCompatibilityMode.IdentityV3;
    private int iterationCount = 10000;
    // for unit testing
    private SecureRandom rng = defaultRng;

    public PasswordHasherCompatibilityMode getCompatibilityMode() {
        return compatibilityMode;
    }

    public void setCompatibilityMode(PasswordHasherCompatibilityMode compatibilityMode) {
        this.compatibilityMode = compatibilityMode;
    }

    public int getIterationCount() {
        return iterationCount;
    }

    public void setIterationCount(int iterationCount) {
        this.iterationCount = iterationCount;
    }

    public SecureRandom getRng() {
        return rng;
    }

    public void setRng(SecureRandom rng) {
        this.rng = rng;
    }
}



