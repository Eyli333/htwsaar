/**
 * <h1>Dialogue to Create Objects</h1>
 * Allows the user to create objects with a number, 
 * a type and a quantity. Then the user can interact 
 * with his items using methods with an interactif way.
 * 
 * @author Victor Plage and David Glaser
 * @version 1.1.1
 * @since 2022-11-04
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class MathFunctionsDialog{
	
	private static final int BERECHNE_TEILERSUMME = 1;
	private static final int BERECHNER_CHECKSUMME_ISBN = 2;
	private static final int BERECHNER_NULLSTELLEN = 3;
	private static final int EXIT_INT = 4;

	private static final String BERECHNE_TEILERSUMME_STRING = " : Berechne die Teilersumme einer Zahl";
	private static final String BERECHNER_CHECKSUMME_ISBN_STRING=" : Berechne die Checksum von einer ISBN-10";
	private static final String BERECHNER_NULLSTELLEN_STRING = " : Berechne die Nullstellen von p und q";
	private static final String EXIT_STRING = " : Das Programm beenden";

	private static Scanner scanner = EingabeUtils.scanOpen();

	/**
	 * This constructor is the main entry point for the ArtikelDialog class
	 */
	public MathFunctionsDialog(){
	}

	/**
	 * The main Funktion start a new ArtikelDialog Objekt
	 */
	public static void main( String[] args) {
		new MathFunctionsDialog().start();
	}

	/** 
	 * Main loop of the Programm
	 */
	public void start() {

		int userInput = 0;

		while (userInput != EXIT_INT) {
			try {
				menuAusgabe();
				userInput = eingabeLesen();
				todo(userInput);
			} catch(IllegalArgumentException e) {
				System.out.println(e);
			} catch(InputMismatchException e) {
				System.out.println(e);
			} catch(Exception e) {
				System.out.println(e);
				e.printStackTrace(System.out);
			}

		}

	}

	/**
	 * This method is used to print the different choices
	 */
	public void menuAusgabe() {
		System.out.print("\n"+
			BERECHNE_TEILERSUMME +  BERECHNE_TEILERSUMME_STRING + "\n" +
			BERECHNER_CHECKSUMME_ISBN + BERECHNER_CHECKSUMME_ISBN_STRING + "\n" +
			BERECHNER_NULLSTELLEN + BERECHNER_NULLSTELLEN_STRING +  "\n" +
			EXIT_INT + EXIT_STRING + "\n" +
			">>> "
		);
	} 

	/**
	 * This method is used to read the user input and return it
	 * @return userInput as an Integer 
	 */
	public int eingabeLesen() {
		int userInput = EingabeUtils.scanInt(scanner);
		System.out.println(userInput);
		return userInput;
	}

	/**
	 * This method is use to execute the user choice 
	 * @param userInput The input from the user
	 */
	public void todo(int userInput) {
		// switch(userInput) {
		// 	case BERECHNE_TEILERSUMME: 
				// berechneTeilersumme();
				// break;
			// case BERECHNER_CHECKSUMME_ISBN: 
				// berechneChecksummeIsbn();
				// break;
			// case BERECHNER_NULLSTELLEN: 
				// berechneNullstellen();
				// break;
			// case EXIT_INT: 
				// System.out.println("Das Programm wird beendet!");
				// break;
			// default: 
				// System.out.println(userInput + " ist keine gültige Nummer!");
				// break;
		// }
		if(userInput == BERECHNE_TEILERSUMME){
			berechneTeilersumme();
		}
		else if(userInput == BERECHNER_CHECKSUMME_ISBN){
			berechneChecksummeIsbn();
		}
		else if(userInput == BERECHNER_NULLSTELLEN){
			berechneNullstellen();
		}
		else if(userInput == EXIT_INT){
			EingabeUtils.scanClose(scanner);
			System.out.println("Das Programm wird beendet!");
		}
		else {
			System.out.println(userInput + " ist keine gültige Nummer!");
		}
	}

	/**
	 * This method is used to call the berechneTeilersumme in MathFunctions
	 * It will ask the user to provide :
	 * - zahl that must be a positive long 
	 */
	public void berechneTeilersumme() {

		System.out.print("Teilersumme: ");
		long zahl = EingabeUtils.scanLong(scanner);

		System.out.println("Die Summe aller möglichen Teiler: " + MathFunctions.berechneTeilersumme(zahl));
	}

	/**
	 * This method is used to call the berechneChecksummeIsbn in MathFunctions
	 * It will ask the user to provide :
	 * - zahl that must be a isbn-10
	 */
	public void berechneChecksummeIsbn() {

		System.out.print("ISBN: ");

		long zahl = EingabeUtils.scanLong(scanner);

		String result = MathFunctions.berechneChecksummeIsbn(zahl);

		System.out.println("Die errechnete Prüfziffer: " + result);
	}

	/**
	 * This method is used to call the berechneNullstellen in MathFunctions
	 * It will ask the user to provide :
	 * - p that must be a double
	 * - q that must be a double
	 */
	public void berechneNullstellen() {

		System.out.print("p: ");
		double pvalue = EingabeUtils.scanDouble(scanner);

		System.out.print("q: ");
		double qvalue = EingabeUtils.scanDouble(scanner);

		String result = MathFunctions.berechneNullstellen(pvalue, qvalue);

		System.out.println(result);
		
	}

}
