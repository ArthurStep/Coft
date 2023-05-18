package main.artfix;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Random;

public class Coft {
    private static boolean bannerSwitch = false;
    private static boolean loggingSwitch = false;

    private static boolean CoftActiveSwitch = false;
    private static final String appVersion = "(V3.8.4)";

    public static void run() {
        if (!bannerSwitch) {
            System.out.println("\n" +
                    "░█▀▀█ ░█▀▀▀█ ░█▀▀▀ ▀▀█▀▀ \n" +
                    "░█─── ░█──░█ ░█▀▀▀ ─░█── \n" +
                    "░█▄▄█ ░█▄▄▄█ ░█─── ─░█──" +
                    appVersion);
            System.out.println();
            System.out.println();
            bannerSwitch = true;
        }
        CoftActiveSwitch = true;
    }

    public static void OFFBANNER() {
        Coft.bannerSwitch = true;
    }

    private static void NewCommandStarted() {
        if (!CoftActiveSwitch) {
            System.err.println("!!! RUN COFT !!!");
            System.exit(0);
        }
    }

    private static ArrayList<String> CoftLogs = new ArrayList<>();


    public static class convert {
        public static String intToString(int yourInt) {
            NewCommandStarted();
            return Integer.toString(yourInt);
        }

        public static int stringToInt(String yourString) {
            NewCommandStarted();
            return Integer.parseInt(yourString);
        }
    }

    public static class security {
        private static String CoftEncryptKey = "nokey";

        public static String encrypt(String text) {
            NewCommandStarted();
            if (!CoftEncryptKey.equals("nokey")) {
                try {
                    byte[] keyBytes = CoftEncryptKey.getBytes();
                    SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
                    Cipher cipher = Cipher.getInstance("AES");
                    cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
                    byte[] encryptedBytes = cipher.doFinal(text.getBytes());
                    return Base64.getEncoder().encodeToString(encryptedBytes);
                } catch (InvalidKeyException ie) {
                    System.err.println("Coft >> Error! ENCRYPT --> Key size should be 16 or 32 symbols!");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println("Coft >> Error! ENCRYPT");

                }
            } else {
                System.err.println("Coft >> Error! Set Key.");
                text = "Coft >> Error! Set Key.";
            }
            return text;
        }

        public static String decrypt(String text) {
            NewCommandStarted();
            if (!CoftEncryptKey.equals("nokey")) {
                try {
                    byte[] keyBytes = CoftEncryptKey.getBytes();
                    SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
                    Cipher cipher = Cipher.getInstance("AES");
                    cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
                    byte[] encryptedBytes = Base64.getDecoder().decode(text);
                    byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
                    return new String(decryptedBytes);
                } catch (InvalidKeyException ie) {
                    System.err.println("Coft >> Error! DECRYPT --> Key size should be 16 or 32 symbols!");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println("Coft >> Error! DECRYPT");

                }
            } else {
                System.err.println("Coft >> Error! Set Key.");
                text = "Coft >> Error! Set Key.";
            }
            return text;
        }

        public static void setEncryptDecryptKEY(String key) {
            NewCommandStarted();
            CoftEncryptKey = key;
        }
    }

    public static class logging {
        public static void logSave(String logSave) {
            if (loggingSwitch) {
                CoftLogs.add(logSave);
            } else {
                System.err.println("Turn on logging by 'logging.StartLogging();'.");
                NewCommandStarted();
            }
        }

        public static void log(String log) {
            NewCommandStarted();
            System.err.println(log);
        }

        public static void printLogged() {
            NewCommandStarted();
            if (loggingSwitch) {
                for (String log : CoftLogs) {
                    System.err.println(log);
                }
            } else {
                NewCommandStarted();
                System.err.println("Turn on logging by 'logging.StartLogging();'.");
            }
        }

        public static void stopLogging() {
            NewCommandStarted();
            loggingSwitch = false;
        }

        public static void startLogging() {
            NewCommandStarted();
            loggingSwitch = true;
        }
    }

    public static class generator {
        public static String numberGenerator(int length) {
            NewCommandStarted();
            StringBuilder codeBuilder = new StringBuilder();
            Random random = new Random();

            for (int i = 0; i < length; i++) {
                int randomDigit = random.nextInt(10);
                codeBuilder.append(randomDigit);
            }

            return codeBuilder.toString();
        }

        public static String letterGenerator(int length) {
            NewCommandStarted();
            StringBuilder codeBuilder = new StringBuilder();
            Random random = new Random();

            for (int i = 0; i < length; i++) {
                char randomChar = (char) (random.nextInt(26) + 'A');
                codeBuilder.append(randomChar);
            }

            return codeBuilder.toString();
        }
    }

    public static class tools {
        public static void clear(int lines) {
            NewCommandStarted();
            if (lines == 0) {
                lines = 85;
            }
            for (int i = 0; i < lines; i++) {
                System.out.println(" ");
            }
        }
    }
}

