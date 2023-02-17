package main.artfix;

import java.util.Scanner;

public class Coft {

    public static boolean resultEquals = false;
    public static String scannerString = "";
    public static int scannerInt = 0;
    private static boolean helpBool = false;

    public static void equalsInt(int a, int b) {
        resultEquals = a == b;
        if (helpBool) {
            System.out.println("This method check is int (Numbers) a equals with b (Numbers) and save result to bool resultEquals.");
        }
    }

    public static void equalsString(String a, String b) {
        resultEquals = a.equals(b);
        if (helpBool) {
            System.out.println("This method check is string (Text) a equals with b (Text) and save result to bool resultEquals.");
        }
    }

    public static void outString(String a) {
        System.out.println(a);
        if (helpBool) {
            System.out.println("Coft: This command is only sout short type (string for letters but you can " +
                    "use with letters but in string type).");
        }
    }

    public static void outInt(int a) {
        System.out.println(a);
        if (helpBool) {
            System.out.println("Coft: This command is only sout short type (int for only Numbers).");
        }
    }

    public static void inInt(int a) {
        Scanner scanInIntIn = new Scanner(System.in);
        scannerInt = scanInIntIn.nextInt();
        if (helpBool) {
            System.out.println("Coft: This command input int (Numbers) by scanner and save result to scannerInt.");
        }
    }

    public static void inString(int a) {
        Scanner scanInIntIn = new Scanner(System.in);
        scannerString = scanInIntIn.nextLine();
        if (helpBool) {
            System.out.println("Coft: This command input string (Text) by scanner and save result to scannerString.");
        }
    }

    public static void helpMeOn() {
        helpBool = true;
    }

    public static void helpMeOff() {
        helpBool = false;
    }


}
