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

                String publicKey = "-----BEGIN PUBLIC KEY-----\\nMIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAvhuZfgE/HXeDrF2Xu9g5\\nMswRw1iSb4kc7/VUAyDhgFoWUqfWds2Pm1ETp3PkgN6HqqvTiNt4kr7HvEmub1tc\\neAfjFLWNClEE+6zemQbfM/pt4pHxcAxgBEkgYoX1btVHBHtBkM7SFV9TYkPcXEOo\\nqGl4vzZtOmwkB52a1MeMiN1pHA7yAkUMNFstikaVhIcACmQHC6OeHNkpCLCjEcpB\\nPFK5503T1x3EjO15HSUd5TGu9zpDJ63KKKGT4hXGairdEPI41I+XfchdazLyIUIs\\nQebsP+cfjj6TIXxmRwZGJPxMIUlq74i4v3NYNJHys+CvbQEh0NEjr3dXdkxGzfqj\\njPhFKevxzJTpjdp9AEmhZAucEcMBFSHAfKk7sw+I1ImruHt46FX+3She8g2wbCmc\\nBbPXxNOawGTnidpqYxB8IoWCd2S+dwIbeTdwTumNR3KSTzk0n/AqbVa+bkgh/4nY\\nlrNGOmXtg7k0jt1F4cergb2NvGC+q/S5BRhUBzrdYgmQ14faLUq4RSTvTg3hkS21\\nKNiK8Q/JaDUoyfE1KdIxQPgpiWagyKm0Y+nNRmkxbyiDGPCgWeprCU+WJn6+KpnC\\n3fmW5YwToGbBha13deC7EMiQWuC68WRC1VKxDZjtSjbfTXotFiYp3WwS2pRkfbZs\\n16qUDtkR6BD5AezXPCfXO68CAwEAAQ==\\n-----END PUBLIC KEY-----";

                String privateKey = "-----BEGIN PRIVATE KEY-----\\n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\\nHgVw06OwdVEkvgsROY+ZPDRDKTSZew==\\n-----END PRIVATE KEY-----";


                String pathFile = "C:/Users/theen/Desktop/excel-locura.xlsx";
                String pathOut = "C:/Users/theen/Desktop/cifradoNuevo.txt";

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
