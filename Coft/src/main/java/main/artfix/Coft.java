package main.artfix;

import java.util.Scanner;

public class Coft {
    private static boolean banner = false;

    private static void showBanner() {
        if (!banner) {
            System.out.println("\n" +
                    "░█▀▀█ ░█▀▀▀█ ░█▀▀▀ ▀▀█▀▀ \n" +
                    "░█─── ░█──░█ ░█▀▀▀ ─░█── \n" +
                    "░█▄▄█ ░█▄▄▄█ ░█─── ─░█──");
            System.out.println();
            banner = true;
        }
    }


    public static Scanner scanner = new Scanner(System.in);

    public static String intToString(int yourInt) {
        Coft.showBanner();
        return Integer.toString(yourInt);
    }

    public static int stringToInt(String yourString) {
        Coft.showBanner();
        return Integer.parseInt(yourString);
    }

    public static boolean isEqualsInt(int num1, int num2) {
        Coft.showBanner();
        boolean isEqualsIntResult;
        isEqualsIntResult = num1 == num2;
        return isEqualsIntResult;
    }

    public static boolean isEqualsString(String word1, String word2) {
        Coft.showBanner();
        boolean isEqualsStringResult;
        isEqualsStringResult = word1.equals(word2);
        return isEqualsStringResult;
    }

}
