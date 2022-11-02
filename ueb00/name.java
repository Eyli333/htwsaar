import java.util.Scanner;

public class name {
	public static void main( String[] args) {
		String first ;
		String second ;
		int geburtjahr;

		Scanner scanner = new Scanner(System.in);
		System.out.print("Ihr Vorname : " );
		first  = scanner.next();
		System.out.print("Ihr Nachname : " );
		second = scanner.next();
		System.out.print("Ihr Geburtsjahr : " );
		geburtjahr = scanner.nextInt();
		int alter = 2022 - geburtjahr;
		System.out.println("Sie heißen : "+ first+ ", " + second);
		System.out.println("Sie sind " +alter + " Jahre alt");
		scanner.close();
	}
}

