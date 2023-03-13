package main.artfix;

import java.util.Scanner;

public class Coft {
    public static Scanner scanner = new Scanner(System.in);

    public static String intToString(int yourInt) {
        return Integer.toString(yourInt);
    }

    public static int stringToInt(String yourString) {
        return Integer.parseInt(yourString);
    }

    public static boolean isEqualsInt(int num1, int num2) {
        boolean isEqualsIntResult;
        isEqualsIntResult = num1 == num2;
        return isEqualsIntResult;
    }

    public static boolean isEqualsString(String word1, String word2) {
        boolean isEqualsStringResult;
        isEqualsStringResult = word1.equals(word2);
        return isEqualsStringResult;
    }


}
