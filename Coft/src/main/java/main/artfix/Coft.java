package main.artfix;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Random;

public class Coft {
    private static boolean banner = false;
    private static boolean loggingSwitch = false;

    private static boolean CoftActive = false;

    public static void run() {
        showBanner();
        CoftActive = true;
    }

    private static void NewCommandStarted(String logData) {
        if (CoftActive) {
            if (loggingSwitch) {
                logging.log("CoftSYS: " + logData);
            }
        } else {
            System.out.println("!!! RUN COFT !!!");
            System.exit(0);
        }
    }

    private static ArrayList<String> CoftLogs = new ArrayList<>();

    private static void showBanner() {
        if (!banner) {
            System.out.println("\n" +
                    "░█▀▀█ ░█▀▀▀█ ░█▀▀▀ ▀▀█▀▀ \n" +
                    "░█─── ░█──░█ ░█▀▀▀ ─░█── \n" +
                    "░█▄▄█ ░█▄▄▄█ ░█─── ─░█──" +
                    "(V3.8.2)");
            System.out.println();
            System.out.println();
            banner = true;
        }
    }


    public static String intToString(int yourInt) {
        NewCommandStarted("INT TO STRING USED");
        return Integer.toString(yourInt);
    }

    public static int stringToInt(String yourString) {
        NewCommandStarted("STRING TO INT USED");
        return Integer.parseInt(yourString);
    }

    public static boolean isEqualsInt(int num1, int num2) {
        NewCommandStarted("IS EQUALS OR NO FOR INT");
        boolean isEqualsIntResult;
        isEqualsIntResult = num1 == num2;
        return isEqualsIntResult;
    }

    public static boolean isEqualsString(String word1, String word2) {
        NewCommandStarted("IS EQUALS OR NO FOR STRING");
        boolean isEqualsStringResult;
        isEqualsStringResult = word1.equals(word2);
        return isEqualsStringResult;
    }

    public static void stop() {
        NewCommandStarted("COFT STOPPED");
        CoftActive = false;
    }

    public static void OFFBANNER() {
        Coft.banner = true;
    }

    public static class security {
        private static String CoftEncryptKey = "nokey";

        public static String encrypt(String text) {
            NewCommandStarted("ENCRYPT REQUESTED");
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
            NewCommandStarted("DECRYPT REQUESTED");
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
            NewCommandStarted("COFT KEY SET");
            CoftEncryptKey = key;
        }
    }

    public static class logging {
        public static void log(String log) {
            if (loggingSwitch) {
                CoftLogs.add(log);
            } else {
                System.err.println("Turn on logging by 'logging.StartLogging();'.");
                NewCommandStarted("LOG REQUESTED DECLINED | LOGGING TURNED OFF");
            }
        }

        public static void PrintLogged() {
            NewCommandStarted("LOGGED DATA PRINTED");
            if (loggingSwitch) {
                for (String log : CoftLogs) {
                    System.err.println(log);
                }
            } else {
                NewCommandStarted("PRINTLOGGED REQUESTED DECLINED | LOGGING TURNED OFF");
                System.err.println("Turn on logging by 'logging.StartLogging();'.");
            }
        }

        public static void StopLogging() {
            NewCommandStarted("LOGGING TURNED OFF");
            loggingSwitch = false;
        }

        public static void StartLogging() {
            NewCommandStarted("LOGGING TURNED ON");
            loggingSwitch = true;
        }
    }

    public static class generator {
        public static String numberGenerator(int length) {
            NewCommandStarted("NUMBER GENERATOR REQUEST");
            StringBuilder codeBuilder = new StringBuilder();
            Random random = new Random();

            for (int i = 0; i < length; i++) {
                int randomDigit = random.nextInt(10); // Generate a random digit (0-9)
                codeBuilder.append(randomDigit);
            }

            return codeBuilder.toString();
        }

        public static String letterGenerator(int length) {
            NewCommandStarted("LETTER GENERATOR REQUEST");
            StringBuilder codeBuilder = new StringBuilder();
            Random random = new Random();

            for (int i = 0; i < length; i++) {
                char randomChar = (char) (random.nextInt(26) + 'A'); // Generate a random uppercase letter
                codeBuilder.append(randomChar);
            }

            return codeBuilder.toString();
        }
    }
}

