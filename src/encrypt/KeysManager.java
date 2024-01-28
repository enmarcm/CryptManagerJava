package encrypt;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.HashMap;
import java.util.Map;
import enums.GENERATION_TYPES;
import enums.KEYS_TYPES;
import java.util.Base64;

public class KeysManager {
    private Map<KEYS_TYPES, byte[]> generateEncodedKeyPair() throws Exception{
        Map<KEYS_TYPES, byte[]> map = new HashMap<>();

        KeyPairGenerator keyPairInitializer = KeyPairGenerator.getInstance("RSA");
        keyPairInitializer.initialize(4096);
        KeyPair keys = keyPairInitializer.generateKeyPair();

        byte[] privateKey = keys.getPrivate().getEncoded();
        byte[] publicKey = keys.getPublic().getEncoded();

        map.put(KEYS_TYPES.PUBLIC_KEY, publicKey);
        map.put(KEYS_TYPES.PRIVATE_KEY, privateKey);

        return map;
    }

    public KeyPairs generatePairKey() throws Exception{
        CryptManager cm = new CryptManager();
        Map<KEYS_TYPES, byte[]> encodedKeys = this.generateEncodedKeyPair();

        String publicKeyString = cm.parseString(encodedKeys.get(KEYS_TYPES.PUBLIC_KEY), GENERATION_TYPES.PUBLIC_KEY);
        String privateKeyString = cm.parseString(encodedKeys.get(KEYS_TYPES.PRIVATE_KEY), GENERATION_TYPES.PRIVATE_KEY);

        return new KeyPairs(publicKeyString, privateKeyString);
    }
}