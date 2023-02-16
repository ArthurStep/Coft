package main.artfix;

import java.util.Scanner;

public class Coft {

    public static boolean resultEquals = false;
    public static String scannerString;
    public static int scannerInt;

    public static void equalsInt(int a, int b) {
        resultEquals = a == b;
    }

    public static void equalsString(String a, String b) {
        resultEquals = a.equals(b);
    }

    public static void outString(String a) {
        System.out.println(a);
    }

    public static void outInt(int a) {
        System.out.println(a);
    }

    public static void inInt(int a) {
        Scanner scanInIntIn = new Scanner(System.in);
        scannerInt = scanInIntIn.nextInt();
    }

    public static void inString(int a) {
        Scanner scanInIntIn = new Scanner(System.in);
        scannerString = scanInIntIn.nextLine();
    }


}
