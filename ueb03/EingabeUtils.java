import java.util.Scanner;

class EingabeUtils {
    public static String sstring(){
        Scanner scanner = new Scanner(System.in);
        String userinput = scanner.next();
        scanner.nextLine();
        scanner.close();
        return userinput;
    }
    public static int sint(){
        Scanner scanner = new Scanner(System.in);
        int userinput = scanner.nextInt();
        scanner.nextLine();
        scanner.close();
        return userinput;
    }
    public static long slong(){
        Scanner scanner = new Scanner(System.in);
        long userinput = scanner.nextLong();
        scanner.nextLine();
        scanner.close();
        return userinput;
    }
    public static double sdouble(){
        Scanner scanner = new Scanner(System.in);
        double userinput = scanner.nextDouble();
        scanner.nextLine();
        scanner.close();
        return userinput;
    }
    public static short sshort(){
        Scanner scanner = new Scanner(System.in);
        short userinput = scanner.nextShort();
        scanner.nextLine();
        scanner.close();
        return userinput;
    }
    public static Float sFloat(){
        Scanner scanner = new Scanner(System.in);
        Float userinput = scanner.nextFloat();
        scanner.nextLine();
        scanner.close();
        return userinput;
    }
    public static Boolean sBoolean(){
        Scanner scanner = new Scanner(System.in);
        Boolean userinput = scanner.nextBoolean();
        scanner.nextLine();
        scanner.close();
        return userinput;
    }
}