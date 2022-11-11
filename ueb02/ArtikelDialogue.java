/**
 * <h1>Dialogue to Create Objects</h1>
 * Allows the user to create objects with a number, 
 * a type and a quantity. Then the user can interact 
 * with his items using methods with an interactif way.
 * 
 * @author Victor Plage and David Glaser
 * @version 1.1.0
 * @since 2022-11-04
 */

/*  todo :
	mettre les java doc commentaires
	mettre to string quand changer quelque chose
	mettre saut de ligne pour meilleur visibilité
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArtikelDialogue {
	private Artikel artikel;
	private Scanner input;

	private static final int ARTIKEL_MIT_BESTAND = 1;
	private static final int ARTIKEL_OHNE_BESTAND = 2;
	private static final int BUCHE_ZUGANG = 3;
	private static final int BUCHE_ABGANG = 4;
	private static final int ARTIKEL_NUMMMER_SETZEN = 5;
	private static final int BESTAND_SETZEN= 6;
	private static final int ART_SETZEN= 7;
	private static final int ARKTIKEL_INFORMATION= 8;
	private static final int EXIT = 9;

	public ArtikelDialogue(){
		input = new Scanner(System.in);
	}

	public static void main( String[] args) {
		new ArtikelDialogue().start();
	}

	public void start() {

		artikel = null;
		int userInput = 0;

		while (userInput != EXIT) {
			try {
				menuAusgabe();
				userInput = eingabeLesen();
				todo(userInput);
			} catch(IllegalArgumentException e) {
				System.out.println(e);
			} catch(InputMismatchException e) {
				System.out.println(e);
				input.nextLine();
			} catch(Exception e) {
				System.out.println(e);
				e.printStackTrace(System.out);
			}

		}

		input.close();
	}

	public void menuAusgabe() {
		System.out.println(
				ARTIKEL_MIT_BESTAND + " : Ein Artikel mit bestand anlegen\n" +
				ARTIKEL_OHNE_BESTAND + " : Ein Artikel ohtne bestand anlegen\n" +
				BUCHE_ZUGANG + " : Ein Zugang buchen\n" +
				BUCHE_ABGANG + " : Ein Abgang buchen\n" + 
				ARTIKEL_NUMMMER_SETZEN + " : Eine Artikelnummer setzen\n" +
				BESTAND_SETZEN + " : Ein Bestand setzen\n" +
				ART_SETZEN + " : Die Art setzen\n" +
				ARKTIKEL_INFORMATION + " : Die Attributen des Artkiles\n" +
				EXIT + " : Das Programm enden\n" +
				">>> "
				);
	} 

	public int eingabeLesen() {
		int userInput = input.nextInt();
		input.nextLine();
		return userInput;
	}

	public void todo(int userInput) {
		if (userInput == ARTIKEL_MIT_BESTAND) {
			artikelMitBestandAnlegen();
		} else if (userInput == ARTIKEL_OHNE_BESTAND) {
			artikelOhneBestandAnlegen();
		} else if ( userInput == BUCHE_ZUGANG) {
			bucheZugang();
		} else if ( userInput == BUCHE_ABGANG) {
			bucheAbgang();
		} else if ( userInput == ARTIKEL_NUMMMER_SETZEN) {
			artikelNummerSetzen();
		} else if ( userInput == BESTAND_SETZEN) {
			bestandSetzen();
		} else if ( userInput == ART_SETZEN) {
			artSetzen();
		} else if ( userInput == ARKTIKEL_INFORMATION) {
			artikelInformation();
		} else if ( userInput == EXIT) {
			System.out.println("Das Programm wird beendet");
		} else {
			System.out.println(userInput + " ist keine gültige Nummer");
		}
	}

	public void artikelMitBestandAnlegen() {
		if (artikel != null) {
			System.out.println("Der Artikel existiert schon und kann nicht ueberchrieben werden");
		} else {
			System.out.println("Ein Artikel wird angelet");

			System.out.println("Artikelnummer ( ein positive Vierstelligezahl) : ");
			int artikelNr = input.nextInt();

			System.out.println("Die Art des Artikels : ");
			String art = input.next();

			System.out.println("Der Bestand des Artikels : ");
			int bestand = input.nextInt();

			artikel = new Artikel( artikelNr, art, bestand);
		}
	}

	public void artikelOhneBestandAnlegen() {
		if (artikel != null) {
			System.out.println("Der Artikel existiert schon und kann nicht ueberchrieben werden");
		} else {
			System.out.println("Ein Artikel ohne bestand wird angelet");

			System.out.println("Artikelnummer ( ein positive Vierstelligezahl) : ");
			int artikelNr = input.nextInt();

			System.out.println("Die Art des Artikels : ");
			String art = input.next();

			artikel = new Artikel( artikelNr, art);
		}
	}

	public void bucheZugang() {
		if (artikel == null) {
			System.out.println("Der Artikel existiert nicht. 1 oder 2 wählen um ein Artikel zu erstellen");
		} else {
			System.out.println("Wie viel soll zugelegt werden ?");
			System.out.println(">>> ");
			int menge = input.nextInt();

			artikel.bucheZugang(menge);
		}
	}

	public void bucheAbgang() {
		if (artikel == null) {
			System.out.println("Der Artikel existiert nicht. 1 oder 2 wählen um ein Artikel zu erstellen");
		} else {
			System.out.println("Wie viel soll abgenomen werden ?");
			System.out.println(">>> ");
			int menge = input.nextInt();

			artikel.bucheAbgang(menge);
		}
	}

	public void artikelNummerSetzen() {
		if (artikel == null) {
			System.out.println("Der Artikel existiert nicht. 1 oder 2 wählen um ein Artikel zu erstellen");
		} else {
			System.out.println("Was soll die neue Artikelnummer sein ( ein positive Vierstelligezahl) ?");
			System.out.println(">>> ");
			int neuerArtikelNr= input.nextInt();

			artikel.setArtikelNr(neuerArtikelNr);
		}
	}

	public void bestandSetzen() {
		if (artikel == null) {
			System.out.println("Der Artikel existiert nicht. 1 oder 2 wählen um ein Artikel zu erstellen");
		} else {
			System.out.println("Was soll der neuer Bestand sein ?");
			System.out.println(">>> ");
			int neuerBestand= input.nextInt();

			artikel.setBestand(neuerBestand);;
		}
	}

	public void artSetzen() {
		if (artikel == null) {
			System.out.println("Der Artikel existiert nicht. 1 oder 2 wählen um ein Artikel zu erstellen");
		} else {
			System.out.println("Was soll die neue Art des Artikels sein ?");
			System.out.println(">>> ");
			String neuerArt= input.next();

			artikel.setArt(neuerArt);
		}
	}
	
	public void artikelInformation() {
		if (artikel == null) {
			System.out.println("Der Artikel existiert nicht. 1 oder 2 wählen um ein Artikel zu erstellen");
		} else {
			System.out.println(artikel.toString());
		}
	}
}
