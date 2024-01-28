package encrypt;

import enums.GENERATION_TYPES;

import javax.crypto.Cipher;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;

public class CryptManager {
    public static final String RSA = "RSA";

    public String parseString(byte[] Content, GENERATION_TYPES type) {
        String resultString = Base64.getEncoder().encodeToString(Content);

        StringBuilder formattedString = new StringBuilder();

        for (int i = 0; i < resultString.length(); i += 64) {
            formattedString.append(resultString, i, Math.min(i + 64, resultString.length()));
            formattedString.append("\n");
        }

        String beginString = "-----BEGIN " + type.getType() + "-----\n";
        String endString = "-----END " + type.getType() + "-----";

        return beginString + formattedString + endString;
    }

    private PublicKey getPublicKeyFromString(String key) throws Exception {
        String publicKeyPEM = key
                .replace("-----BEGIN PUBLIC KEY-----\n", "")
                .replace("\n-----END PUBLIC KEY-----", "");

        byte[] encoded = Base64.getMimeDecoder().decode(publicKeyPEM);

        KeyFactory kf = KeyFactory.getInstance(RSA);
        return kf.generatePublic(new X509EncodedKeySpec(encoded));
    }

    private PrivateKey getPrivateKeyFromString(String key) throws Exception {
        String privateKeyPEM = key
                .replace("-----BEGIN PRIVATE KEY-----\n", "")
                .replace("\n-----END PRIVATE KEY-----", "");

        byte[] encoded = Base64.getMimeDecoder().decode(privateKeyPEM);

        KeyFactory kf = KeyFactory.getInstance(RSA);
        return kf.generatePrivate(new PKCS8EncodedKeySpec(encoded));
    }
    public void encryptFile(String filePath, String publicKeyString, String outputPath) throws Exception {
        PublicKey publicKey = getPublicKeyFromString(publicKeyString);

        Cipher encryptCipher = Cipher.getInstance(RSA);
        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] inputBytes = Files.readAllBytes(Paths.get(filePath));
        byte[] cipherText = encryptCipher.doFinal(inputBytes);

        Files.write(Paths.get(outputPath), cipherText, StandardOpenOption.CREATE);
    }

    public void decryptFile(String filePath, String privateKeyString, String outputPath) throws Exception {
        PrivateKey privateKey = getPrivateKeyFromString(privateKeyString);

        Cipher decryptCipher = Cipher.getInstance(RSA);
        decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);

        byte[] encryptedBytes = Files.readAllBytes(Paths.get(filePath));
        byte[] decryptedBytes = decryptCipher.doFinal(encryptedBytes);

        Files.write(Paths.get(outputPath), decryptedBytes, StandardOpenOption.CREATE);
    }
}
