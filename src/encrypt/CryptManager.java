package encrypt;

import enums.GENERATION_TYPES;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
            formattedString.append("\\n");
        }

        String beginString = "-----BEGIN " + type.getType() + "-----\\n";
        String endString = "-----END " + type.getType() + "-----";

        return beginString + formattedString + endString;
    }

    private PublicKey getPublicKeyFromString(String key) throws Exception {
        String publicKeyPEM = key
                .replace("-----BEGIN PUBLIC KEY-----\\n", "")
                .replace("-----END PUBLIC KEY-----", "")
                .replace("\\n", "");

        byte[] encoded = Base64.getMimeDecoder().decode(publicKeyPEM);

        KeyFactory kf = KeyFactory.getInstance(RSA);
        return kf.generatePublic(new X509EncodedKeySpec(encoded));
    }

    private PrivateKey getPrivateKeyFromString(String key) throws Exception {
        String privateKeyPEM = key
                .replace("-----BEGIN PRIVATE KEY-----\\n", "")
                .replace("-----END PRIVATE KEY-----", "")
                .replace("\\n", "");

        byte[] encoded = Base64.getMimeDecoder().decode(privateKeyPEM);
//        byte[] encoded = Base64.getMimeDecoder().decode(key);

        KeyFactory kf = KeyFactory.getInstance(RSA);
        return kf.generatePrivate(new PKCS8EncodedKeySpec(encoded));
    }
    public void encryptFile(String inputFile, String publicKeyString, String outputFile) throws Exception {
        PublicKey publicKey = getPublicKeyFromString(publicKeyString);

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile)) {

            byte[] buffer = new byte[117]; // Tamaño máximo para RSA con clave de 1024 bits
            int read;
            while ((read = fis.read(buffer)) != -1) {
                byte[] encryptedBlock = cipher.doFinal(buffer, 0, read);
                fos.write(encryptedBlock);
            }
        }
    }

    public void decryptFile(String inputFile, String privateKeyString, String outputFile) throws Exception {
        PrivateKey privateKey = getPrivateKeyFromString(privateKeyString);

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile)) {

            byte[] buffer = new byte[128]; // Tamaño de bloque cifrado para RSA con clave de 1024 bits
            int read;
            while ((read = fis.read(buffer)) != -1) {
                byte[] decryptedBlock = cipher.doFinal(buffer, 0, read);
                fos.write(decryptedBlock);
            }
        }
    }
}
