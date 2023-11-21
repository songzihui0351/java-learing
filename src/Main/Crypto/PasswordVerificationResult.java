package Main.Crypto;

/**
 * Specifies the results for password verification.
 */
public enum PasswordVerificationResult {
    /**
     * Indicates password verification failed.
     */
    Failed(0),
    /**
     * Indicates password verification was successful.
     */
    Success(1),
    /**
     * Indicates password verification was successful however the password was encoded using a deprecated algorithm
     * and should be rehashed and updated.
     */
    SuccessRehashNeeded(2);

    private final int value;

    PasswordVerificationResult(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}



