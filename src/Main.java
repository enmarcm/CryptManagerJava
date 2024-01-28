    import encrypt.CryptManager;
    import encrypt.KeysManager;
    import encrypt.KeyPairs;

    public class Main {
        public static void main(String[] args) {

            try {
//                KeysManager km = new KeysManager();
//                KeyPairs kp = km.generatePairKey();
////
//                System.out.println("Public Key: \n" + kp.getPublic());
//                System.out.println("Private Key: \n" + kp.getPrivate());

                String publicKey = "-----BEGIN PUBLIC KEY-----\\nMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDJHtCiANYIfGwCiGP5TSG2tJgs\\n2wvjp5QtXDzF5iKEGJF2vhWw0i+RlG3UCdfzvHfKflMs3+z7mSqRiAmATwhEMzjY\\n8WBYV4fydSBAqscu5J58Q+CIeNqHe/AOz7pGf8H/aCuKTdeCF8AGla8RGM4Vs7YI\\najWcKpnVqLtWpgmnUwIDAQAB\\n-----END PUBLIC KEY-----\\n";

                String privateKey = "-----BEGIN PRIVATE KEY-----\\nMIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAMke0KIA1gh8bAKI\\nY/lNIba0mCzbC+OnlC1cPMXmIoQYkXa+FbDSL5GUbdQJ1/O8d8p+Uyzf7PuZKpGI\\nCYBPCEQzONjxYFhXh/J1IECqxy7knnxD4Ih42od78A7PukZ/wf9oK4pN14IXwAaV\\nrxEYzhWztghqNZwqmdWou1amCadTAgMBAAECgYEAvC0X2ixcFm6MBMame9D+VVud\\n8oI1GplmHBbsSeHss5nlKKvr0Zinp1ewdy+KnePeVVli617M9g+2c5pMAYBw4u4j\\nq1ijv5XseVtN5z5uN8s6OBYW/Sxto926PifO8tl1d55KxW0Xa3pI8eR9EJ48LWAu\\n0JzpkCpu05ERkCMPuJECQQDo9CCr7JyvI922IT5xi4JVK+SlIt6igAzSSkKWJW20\\nEd5AFQYJZ5Ze3viwZCZOjyTehLe2mte5R6M7IJQxwwAZAkEA3QR3W9zMHuhNgkAa\\n/eXMwmgA4VjDfHCL38y3cB0Ha0rs++hcOxCxgS0Nn1v4m48WdJOZ8EksSfKfCuBP\\n98GgSwJALgf/ZLmOhHUb3F9ZTWp5yIax2Ye4YnfXEL6nxa+Dq+9T8Wm2FamoZvq8\\nPW6sux1B9c5X1vdl5TCoqohXgDW+EQJBAI/6adsBAkQcJunz4uGFgxcd83zZezek\\nhao8TT+O2ZdujuUnoHWl0UyKUfZ/TnvgAcvdn4ml0WE22Z6XM+D9VPMCQQCjHTjy\\nyi3YvxRa9PoA19lQshz88hF+imdbqpwBL6dwimxWUqqsghtE3izMp5VGTiGDsald\\neCGsiMLLRzG2wP25\\n-----END PRIVATE KEY-----\\n";


                String pathFile = "C:/Users/theen/Desktop/archivo.txt";
                String pathOut = "C:/Users/theen/Desktop/criptografias.txt";

                CryptManager cm = new CryptManager();
                cm.encryptFile(pathFile, publicKey, pathOut);
//                cm.decryptFile(pathOut, privateKey, "C:/Users/theen/Desktop/archivoDesencriptado.xlsx");
                System.out.println("EXITO");

//                KeyPairs km = new KeysManager().generatePairKey();
//                System.out.println(km.getPrivate());
//                System.out.println(km.getPublic());



            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
    }
