package enums;

public enum GENERATION_TYPES {
    PUBLIC_KEY("PUBLIC KEY"),
    PRIVATE_KEY("PRIVATE KEY"),
    CERTIFICATE("CERTIFICATE");

    private String type;

    GENERATION_TYPES(String type){
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
