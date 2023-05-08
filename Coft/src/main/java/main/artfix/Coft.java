package main.artfix;

import java.util.ArrayList;

public class Coft {
    private static boolean banner = false;
    private static boolean loggingSwitch = false;

    private static void NewCommandStarted(String logData) {
        if (loggingSwitch) {
            Coft.showBanner();
            logging.log("CoftSYS: " + logData);
        } else {
            Coft.showBanner();
        }
    }

    private static ArrayList<String> logs = new ArrayList<>();

    private static void showBanner() {
        if (!banner) {
            System.out.println("\n" +
                    "░█▀▀█ ░█▀▀▀█ ░█▀▀▀ ▀▀█▀▀ \n" +
                    "░█─── ░█──░█ ░█▀▀▀ ─░█── \n" +
                    "░█▄▄█ ░█▄▄▄█ ░█─── ─░█──");
            System.out.println();
            System.out.println();
            banner = true;
        }
    }


    public static String intToString(int yourInt) {
        NewCommandStarted("INT TO STRING FUNCTION USED");
        return Integer.toString(yourInt);
    }

    public static int stringToInt(String yourString) {
        NewCommandStarted("STRING TO INT FUNCTION USED");
        return Integer.parseInt(yourString);
    }

    public static boolean isEqualsInt(int num1, int num2) {
        NewCommandStarted("IS EQUALS OR NO FUNCTION USED FOR INT");
        boolean isEqualsIntResult;
        isEqualsIntResult = num1 == num2;
        return isEqualsIntResult;
    }

    public static boolean isEqualsString(String word1, String word2) {
        NewCommandStarted("IS EQUALS OR NO FUNCTION USED FOR STRING");
        boolean isEqualsStringResult;
        isEqualsStringResult = word1.equals(word2);
        return isEqualsStringResult;
    }

    public static void OFFBANNER() {
        Coft.banner = true;
        NewCommandStarted("BANNER TURNED OFF");
    }

    public static class logging {
        public static void log(String log) {
            if (loggingSwitch) {
                logs.add(log);
            } else {
                System.err.println("Turn on logging by 'logging.StartLogging();'.");
                NewCommandStarted("LOG REQUESTED DECLINED | LOGGING TURNED OFF");
            }
        }

        public static void PrintLogged() {
            if (loggingSwitch) {
                for (String log : logs) {
                    System.err.println(log);
                }
                NewCommandStarted("LOGGED DATA PRINTED");
            } else {
                System.err.println("Turn on logging by 'logging.StartLogging();'.");
                NewCommandStarted("PRINTLOGGED REQUESTED DECLINED | LOGGING TURNED OFF");
            }
        }

        public static void StopLogging() {
            loggingSwitch = false;
            NewCommandStarted("LOGGING TURNED OFF");
        }

        public static void StartLogging() {
            NewCommandStarted("LOGGING TURNED ON");
            loggingSwitch = true;
        }
    }

}

