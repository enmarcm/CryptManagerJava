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

                String pathFile = "C:/Users/theen/Desktop/archivo.txt";
                String pathOut = "C:/Users/theen/Desktop/archivoEncriptado";

                String publicKey = "-----BEGIN PUBLIC KEY-----\n" +
                        "MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAt7b3Nvb3erDSNrVAWk1s\n" +
                        "gZtEhI70a8Ik8/h8zV6MWAb2ch4gp1R8yTnin7NNPK6WTMyiKti2yOADH4jGXXzT\n" +
                        "eDMqyDxTjxIZBOe7U1/vDf6ZjuqvUEXx0Q0BDxl6YJR0SfucxD54jaKQHNatSQh0\n" +
                        "tN84e1nuGx7b6vDl2yzP+cmtME2PNl9pjcgQnD5idZ8ZBODKiI9AoMTvZj8FrrCR\n" +
                        "6oqvo4ZJdWj9kMErfoBR6HyH84GktUYK793z4LRvkBLin5MpeVtUwYqCcCUD713K\n" +
                        "lBbQKVFq+zuCE7CdO1KjEB0WcT4tfmJTqdHJyVvJ9Ha2kofQumo1gEV3Bzp7yBSn\n" +
                        "t+4i9VLNGONrvuMz+dAJJhIjwN5VtCgcPGw+OQAtOiyk4xVQxvl1hwHplqQ6vQXz\n" +
                        "TO0YM9Nh8Q3zR73SDvYVHqovyb6q4vVq9GzqqU+7Zw5oFGH99VS51eRADn0fTcpU\n" +
                        "uhK3pBoyHr97uqZ6ytuDmdf8HdaJRCoSSfSmH10LHvq3SVswqTAh9v5SLKwoZo10\n" +
                        "cZrpP0luc9mXkOYWDQVqIcay7UigC0M/L/squhAzUGBIQiE1QiJkDP1i8HnlNPxB\n" +
                        "QFOi6voWk4dEdLDG9CddATrloVOpQyLV1Pno00L8I1TAtPN4i4MKqE8K+PPjdir9\n" +
                        "6kgWdZFKkXgtZBb6Gr8mqZ8CAwEAAQ==\n" +
                        "-----END PUBLIC KEY-----";

                String privateKey = "-----BEGIN PRIVATE KEY-----\n" +
                        "MIIJQgIBADANBgkqhkiG9w0BAQEFAASCCSwwggkoAgEAAoICAQC3tvc29vd6sNI2\n" +
                        "tUBaTWyBm0SEjvRrwiTz+HzNXoxYBvZyHiCnVHzJOeKfs008rpZMzKIq2LbI4AMf\n" +
                        "iMZdfNN4MyrIPFOPEhkE57tTX+8N/pmO6q9QRfHRDQEPGXpglHRJ+5zEPniNopAc\n" +
                        "1q1JCHS03zh7We4bHtvq8OXbLM/5ya0wTY82X2mNyBCcPmJ1nxkE4MqIj0CgxO9m\n" +
                        "PwWusJHqiq+jhkl1aP2QwSt+gFHofIfzgaS1Rgrv3fPgtG+QEuKfkyl5W1TBioJw\n" +
                        "JQPvXcqUFtApUWr7O4ITsJ07UqMQHRZxPi1+YlOp0cnJW8n0draSh9C6ajWARXcH\n" +
                        "OnvIFKe37iL1Us0Y42u+4zP50AkmEiPA3lW0KBw8bD45AC06LKTjFVDG+XWHAemW\n" +
                        "pDq9BfNM7Rgz02HxDfNHvdIO9hUeqi/Jvqri9Wr0bOqpT7tnDmgUYf31VLnV5EAO\n" +
                        "fR9NylS6ErekGjIev3u6pnrK24OZ1/wd1olEKhJJ9KYfXQse+rdJWzCpMCH2/lIs\n" +
                        "rChmjXRxmuk/SW5z2ZeQ5hYNBWohxrLtSKALQz8v+yq6EDNQYEhCITVCImQM/WLw\n" +
                        "eeU0/EFAU6Lq+haTh0R0sMb0J10BOuWhU6lDItXU+ejTQvwjVMC083iLgwqoTwr4\n" +
                        "8+N2Kv3qSBZ1kUqReC1kFvoavyapnwIDAQABAoICABxI1SLnPw7qrlKx8Sh2ByCl\n" +
                        "MRVflQ4KI/pT5ZMQ3XaoC8ViEhDxFw08FkIULu4KyyUj1EvYdbvTkWeHfVLjZwN4\n" +
                        "jTuq3gqG9Mcmjla1zG5RJn80bq1jN2nCIMmcWJUKBiVl0ar9Gz5jKuDlxGQcIyu9\n" +
                        "ukpzfA883wr678igy5xfioSHTGdIpU2o4bXMfQgy6H0xxrzjoUWfTGRni45rrOt5\n" +
                        "UrVQdXrYIUHqG7IsO3AZzCyXZy5pjEGF4IhV/18lKTL8S0Rd5Vyu4Io3iLWPsSK/\n" +
                        "qGjUGi536PzzEiISBPz0HYJt2j89EDhzDigsM5mptU42DtLEi1wmVb8NKAWT+IY7\n" +
                        "8g2SLF7d5ivUTn/mAcd8t+x03dFqE8jqEI0937eU+aCjnTbGqM6E0pepdl7k279+\n" +
                        "yb0w1z7tG3NlcaNwYCVxX5ku4HBIyfAsKIIyJZdNzkTfncL8v+bXP5i7V210ZE24\n" +
                        "qtLZPfQCCpa8a40ToziztOOrHqvghV3xZvVBr5t76ocXE8tEKGORC9tGXPD+RzbZ\n" +
                        "DCR4zodlfbjhLrJ3J2bkMhLjk/VsXoWOZjww9heYAmgyWUPUsx1mmURW9JSPtLWK\n" +
                        "+HWoLTpMVnRgV0sPx2NF8hwBYanDGWFuYl1/QAL7VI1rI97rBE8W4fNTVo+ObDun\n" +
                        "QmYIfBWX20aVS/jyclYBAoIBAQDJIwJjTYpt/RcSN6eyWYN2/9bm+AJ3DALrwP1I\n" +
                        "MZxuXnbmjtkHS3I8MSGvYBcBWpv20tGjsaGeNeyJ61H/5Zmf8sRzkU6vxxfRFv2u\n" +
                        "DTNgtvM05bLdAqOuCKRbfvRFR22A2eBph0UYIRQjV1avB9RwyDMjMLQLV3Mt63jG\n" +
                        "zw6KQOKZnICF5KUWPEXxm2Xa0E5eczEKjEPSL45McdOmA4V8l+kIolbBfDkoDxL5\n" +
                        "eI2r1ThvSYzrRKQ4p2O0rx5UBtWDNU143CsVhK/wf6ZuuJVIgTQH1reCyaDHLTvH\n" +
                        "1so8sXVNNrZTifYUmIEYKCdMxceD/0whmhxSepsHAM6hrBiBAoIBAQDp02iagTRh\n" +
                        "66Soe+9bS+/6GJGAKbnQMHjiVfm92EMMIqiJIpXo1pQYwlbqP3dnh5TwJog6o2Bt\n" +
                        "MWS4Q61vERQL/OryDhTtCV/uEICvo+o3rH6l8v+tLS9KTLouNOfo+L7Esn4ejprv\n" +
                        "ZPt7URW11orSYg7uWg9aoEnXtIt5PP+nxb0HogDIL9RHzVSIG0CneO0wGvvNPm8N\n" +
                        "NqCkguUKgridTNGq77mspB02xe6oQRBj63JO/CTm+ZpaGp55YJ+oJSzDYxhwj9kB\n" +
                        "B3Njrizp9A/dWXe2I1m5pOCHRrueurr+mSZjF07ybWk6rKpdsCwvdvQ/Sz4Q/9Fz\n" +
                        "akMV5Y1PRrIfAoIBAHhlYV+JoawWzAGWmOX0GPJZUAzvNaKG6RSvb60QLUAPgYKe\n" +
                        "zSBFs/p9ulkc3ohr8WG8bcpbYI+wXYds+aeAiwWoLpmyx/QF66a36V+O/UsOF+R4\n" +
                        "/ii3FLzu5VrzUkpJ6C0xvdfNJbm8yy4gcH3S5QIhhCKzW4JSdVpuUdxHQr/U+Q7U\n" +
                        "FEaRR5RYvdFSoJRrDg4RS7Cxp0MgPkBZ/kOoZfXfhJkre1zT++6Tn1r/I2ZQ+jf7\n" +
                        "QcPuUZKr983G6ROJB7NDa71FpPB7fUkrT7eE+67rz/ZFO5GpGXlABUGou2O7Iaj3\n" +
                        "cAnvUgKgCt4n4uZcmQHVBoAynHNuem+ltwolVoECggEBAMERF0DjyD3GFToswxEu\n" +
                        "HWLyoEkjqtJVA6tW9BQmGg5OG7zHuuH7M2NSK/PVHaF1WKwGFNveBIOEkjZ3Yx/f\n" +
                        "CR9w4QmmSO8Dm5r1M1xTStRXcGdTwnraYT7HJb97XbWGlfXRr8NJWnKqfd9vry5q\n" +
                        "jEt0PgHeiOj6ip457CPaEvoTkqZXxK+GlpAG4XJUlkjx116uGRV6JLXTUkcj8TyB\n" +
                        "fTAcus6ajEQZainMuudgeckXIlZHaazxkdouOoXcG1f6AgD+tLJUhAiOf19h9KHk\n" +
                        "LKlG80qH29Ema2InLEm+wyHvkLunBj+zyXxyD2W2TnWOkdQlK4VbxTS4G9ZbqRc5\n" +
                        "N18CggEAd5LGCIdza1oirSoqBG7EzEvuldWgTY9tRN29ZuxG1PE2DlwGFBS/0NRY\n" +
                        "KpKiKohJ1y/fDuSUz0MapcphxzfmYReKmBZcajJdgZDKu4Vi/fYeuCO1q3mJwuyH\n" +
                        "4b/USOKvxINmof4/7zFxlw4TWkmA4ylWnpLNR9B0Fw9oaF2rT0MPSMVu6zi0eII8\n" +
                        "Hc7JEyVQt2q5SzBJ3AqBOogWrsxO2uuIGNhZ++uJRTIw63cyJEeHlyZlkbhB/xSj\n" +
                        "DEr9XRw9TayQ2u2pQdbqovrD4r+UwqX6YxaIKDdnuurQwdFh+tBOeYZDnEZ0zCQ6\n" +
                        "TuI3ULmoJq1DZdGxPOyrqgmP88eENg==\n" +
                        "-----END PRIVATE KEY-----";

                CryptManager cm = new CryptManager();
                cm.encryptFile(pathFile, publicKey, pathOut);
//                cm.decryptFile(pathOut, privateKey, "C:/Users/theen/Desktop/archivoDesencriptado.txt");
                System.out.println("EXITO");

            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
    }