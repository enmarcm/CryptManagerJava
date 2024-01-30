package encrypt;

import enums.GENERATION_TYPES;
import javax.crypto.Cipher;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class CryptManager {
    public static final String RSA = "RSA";

    public String parseString(byte[] Content, GENERATION_TYPES type) {
        String resultString = Base64.getEncoder().encodeToString(Content);

        StringBuilder formattedString = new StringBuilder();

        for (int i = 0; i < resultString.length(); i += 64) {
            formattedString.append(resultString, i, Math.min(i + 64, resultString.length()));
            formattedString.append("\\n");
        }

        String beginString = "-----BEGIN " + type.getType() + "-----\\n";
        String endString = "-----END " + type.getType() + "-----";

        return beginString + formattedString + endString;
    }

    @SuppressWarnings("unchecked")
    private <T extends Key> T getKeyFromString(GENERATION_TYPES type, String key) throws Exception {
        String formattedKey = key
                .replace("-----BEGIN " + type.getType() + "-----\\n", "")
                .replace("-----END " + type.getType() + "-----", "")
                .replace("\n", "")
                .replace("\\n", "");

        byte[] encoded = Base64.getMimeDecoder().decode(formattedKey);
        KeyFactory kf = KeyFactory.getInstance(RSA);


        if (type == GENERATION_TYPES.PUBLIC_KEY) return (T) kf.generatePublic(new X509EncodedKeySpec(encoded));
        else if (type == GENERATION_TYPES.PRIVATE_KEY) return (T) kf.generatePrivate(new PKCS8EncodedKeySpec(encoded));
        else return null;
    }

    public void encryptFile(String inputFile, String publicKeyString, String outputFile) throws Exception {
        PublicKey publicKey = (PublicKey) getKeyFromString(GENERATION_TYPES.PUBLIC_KEY, publicKeyString);

        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile)) {

            byte[] buffer = new byte[501];
            int read;
            while ((read = fis.read(buffer)) != -1) {
                byte[] encryptedBlock = cipher.doFinal(buffer, 0, read);
                fos.write(encryptedBlock);
            }
        }
    }

    public void decryptFile(String inputFile, String privateKeyString, String outputFile) throws Exception {
        PrivateKey privateKey = getKeyFromString(GENERATION_TYPES.PRIVATE_KEY, privateKeyString);

        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile)) {

            byte[] buffer = new byte[512];
            int read;
            while ((read = fis.read(buffer)) != -1) {
                byte[] decryptedBlock = cipher.doFinal(buffer, 0, read);
                fos.write(decryptedBlock);
            }
        }
    }
}
