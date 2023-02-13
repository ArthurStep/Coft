package main.artfix;


public class Coft {

    private static boolean runned = false;
    public static boolean resultEquals = false;



    public static void Run(){
        try {
            runned = true;
            Thread.sleep(600);
            System.out.println("Starting Coft.");
            Thread.sleep(700);
            System.out.println("Starting Coft..");
            Thread.sleep(700);
            System.out.println("Starting Coft...");
            System.out.println(" ");
            System.out.println(" ");

        }
        catch (Exception e){
            System.out.println("Coft Exception ERR");
        }
    }

    public static void equalsInt(int a, int b){
        if(runned) {
            resultEquals = a == b;
        }else{
            System.out.println("Run 'Coft.Run'.");
        }
    }

    public static void equalsString(String a, String b){
        if(runned) {
            resultEquals = a.equals(b);
        }else{
            System.out.println("Run 'Coft.Run'.");
        }
    }



}
