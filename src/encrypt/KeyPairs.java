package encrypt;

public class KeyPairs {
    private final String publicKey;
    private final String privateKey;

    public KeyPairs(String publicKey, String privateKey) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    public String getPublic() {
        return this.publicKey;
    }

    public String getPrivate() {
        return this.privateKey;
    }
}