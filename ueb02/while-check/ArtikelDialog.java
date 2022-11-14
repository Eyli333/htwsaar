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

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArtikelDialog {
    private Artikel artikel;
    private Scanner scanner;

    private static final int ARTIKEL_MIT_BESTAND = 1;
    private static final int ARTIKEL_OHNE_BESTAND = 2;
    private static final int BUCHE_ZUGANG = 3;
    private static final int BUCHE_ABGANG = 4;
    private static final int ARTIKEL_NUMMMER_SETZEN = 5;
    private static final int BESTAND_SETZEN= 6;
    private static final int ART_SETZEN= 7;
    private static final int ARKTIKEL_INFORMATION= 8;
    private static final int EXIT = 9;

    /**
     * This constructor is the main entry point for the ArtikelDialog class
     */
    public ArtikelDialog(){
        scanner = new Scanner(System.in);
    }

    /**
     * The main Funktion start a new ArtikelDialog Objekt
     */
    public static void main( String[] args) {
        new ArtikelDialog().start();
    }

    /** 
     * Main loop of the Programm
     */
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
				scanner.nextLine();
			} catch(Exception e) {
				System.out.println(e);
				e.printStackTrace(System.out);
			}

		}

        scanner.close();
       }

    

    /**
     * This method is used to print the different choices
     */
    public void menuAusgabe() {
        System.out.print("\n"+
                ARTIKEL_MIT_BESTAND + " : Ein Artikel mit bestand anlegen\n" +
                ARTIKEL_OHNE_BESTAND + " : Ein Artikel ohne bestand anlegen\n" +
                BUCHE_ZUGANG + " : Ein Zugang buchen\n" +
                BUCHE_ABGANG + " : Ein Abgang buchen\n" + 
                ARTIKEL_NUMMMER_SETZEN + " : Eine Artikelnummer setzen\n" +
                BESTAND_SETZEN + " : Ein Bestand setzen\n" +
                ART_SETZEN + " : Die Art setzen\n" +
                ARKTIKEL_INFORMATION + " : Die Attribute des Artikels anzeigen\n" +
                EXIT + " : Das Programm beenden\n" +
                ">>> "
                );
    } 

    /**
     * This method is used to read the user input and return it
     * @return userInput as an Integer 
     */
    public int eingabeLesen() {
        int userInput = scanner.nextInt();
        return userInput;
    }

    /**
     * This method is use to execute the user choice 
     * @param userInput The input from the user
     */
    public void todo(int userInput) {

        switch (userInput) {
            case ARTIKEL_MIT_BESTAND: artikelMitBestandAnlegen();
            break;
            case ARTIKEL_OHNE_BESTAND: artikelOhneBestandAnlegen();
            break;
            case BUCHE_ZUGANG: bucheZugang();
            break;
            case BUCHE_ABGANG: bucheAbgang();
            break;
            case ARTIKEL_NUMMMER_SETZEN: artikelNummerSetzen();
            break;
            case BESTAND_SETZEN: bestandSetzen();
            break;
            case ART_SETZEN: artSetzen();
            break;
            case ARKTIKEL_INFORMATION: artikelInformation();
            break;
            case EXIT: System.out.println("Das Programm wird beendet");
            break;
            default: System.out.println(userInput + " ist keine gültige Nummer");
            break;
        }
    }


    /**
     * This method is used to create a new Artikel 
     * It will ask the user to provide :
     * - artikelNr that must be an Integer with 4 digits
     * - art that must be a String
     * - bestand that must be an positive Integer
     */
    public void artikelMitBestandAnlegen() {
        if (artikel != null) {
            System.out.println("Das Artikel existiert bereits und kann nicht ueberchrieben werden");
        } else {
            System.out.println("\nEin Artikel wird angelegt");

			System.out.print("Artikelnummer (eine positive vierstellige Zahl) : ");
			int artikelNr = scanner.nextInt();

			System.out.print("Die Art des Artikels : ");
			String art = scanner.next();

			System.out.print("Der Bestand des Artikels : ");
			int bestand = scanner.nextInt();

			artikel = new Artikel( artikelNr, art, bestand);
        }
    }

    /**
     * This method is used to create a new Artikel but without a bestand 
     * It will ask the user to provide :
     * - artikelNr that must be an Integer with 4 digits
     * - art that must be a String
     */
    public void artikelOhneBestandAnlegen() {
        if (artikel != null) {
            System.out.println("Das Artikel existiert schon und kann nicht ueberchrieben werden");
        } else {
            System.out.println("\nEin Artikel ohne bestand wird angelet");

			System.out.print("Artikelnummer (eine positive Vierstelligezahl) : ");
			int artikelNr = scanner.nextInt();

			System.out.print("Die Art des Artikels : ");
			String art = scanner.next();

            artikel = new Artikel( artikelNr, art);
        }
    }

    /**
     * This method is used to increase the value of the attribute bestand
     * It will ask the user to provide :
     * - menge that must be a positive Integer 
     */
    public void bucheZugang() {
        if (artikel == null) {
            System.out.println("Sie können diese Funktion noch nicht nutzen, denn es existiert noch kein Artikel.\n" + 
            "Bitte tätigen Sie 1 oder 2 um ein Artikel zu erstellen, oder 9 um das Programm zu verlassen.");
        } else {
            System.out.println("\nWie viel soll hinzugefuegt werden ?");
            System.out.print(">>> ");
            int menge = scanner.nextInt();

            artikel.bucheZugang(menge);
        }
    }

    /**
     * This method is used to decrease the value of the attribute bestand
     * It will ask the user to provide :
     * - menge that must be a positive Integer 
     */
    public void bucheAbgang() {
        if (artikel == null) {
            System.out.println("Sie können diese Funktion noch nicht nutzen, denn es existiert noch kein Artikel.\n" + 
            "Bitte tätigen Sie 1 oder 2 um ein Artikel zu erstellen, oder 9 um das Programm zu verlassen.");
        } else {
            System.out.println("\nWie viel soll abgezogen werden ?");
            System.out.print(">>> ");
            int menge = scanner.nextInt();

            artikel.bucheAbgang(menge);
        }
    }

    /**
     * This method is use to set the value of ArtikelNr
     * It will ask the user to provide :
     * - artikelNr that must be an Integer with 4 digits
     */
    public void artikelNummerSetzen() {
        if (artikel == null) {
            System.out.println("Sie können diese Funktion noch nicht nutzen, denn es existiert noch kein Artikel.\n" + 
            "Bitte tätigen Sie 1 oder 2 um ein Artikel zu erstellen, oder 9 um das Programm zu verlassen.");
        } else {

	    // check value artikelNr 
            int artikelNr= 0;
            boolean acceptedArtikelNr = false;
            while (!acceptedArtikelNr) {
            	System.out.println("\nGeben Sie die neue Artikelnummer ein (eine positive Vierstelligezahl) :");
            	System.out.print(">>> ");
		artikelNr= scanner.nextInt();
                try {
                    artikel.checkArtikelNr(artikelNr);
                    acceptedArtikelNr = true;
                } catch(IllegalArgumentException e) {
                    System.out.println(e);
                } catch(InputMismatchException e) {
                    System.out.println(e);
                } catch(Exception e) {
                    System.out.println(e);
                }
            }

            artikel.setArtikelNr(artikelNr);
        }
    }

    /**
     * This method is use to set the value of Bestand
     * It will ask the user to provide :
     * - bestand that must be an positive Integer
     */
    public void bestandSetzen() {
        if (artikel == null) {
            System.out.println("Sie können diese Funktion noch nicht nutzen, denn es existiert noch kein Artikel.\n" + 
            "Bitte tätigen Sie 1 oder 2 um ein Artikel zu erstellen, oder 9 um das Programm zu verlassen.");
        } else {
            int neuerBestand = 0;
            boolean accepted = false;
            while (!accepted) {
                System.out.println("\nGeben Sie den neuen Bestand ein :");
                System.out.print(">>> ");
                neuerBestand= scanner.nextInt();
                try {
                    artikel.checkBestand(neuerBestand);
                    accepted = true;
                } catch(IllegalArgumentException e) {
                    System.out.println(e);
                } catch(InputMismatchException e) {
                    System.out.println(e);
                } catch(Exception e) {
                    System.out.println(e);
                }
            }
            artikel.setBestand(neuerBestand);;
    }
}

    /**
     * This method is use to set the value of Art 
     * It will ask the user to provide :
     * - art that must be a String
     */
    public void artSetzen() {
        if (artikel == null) {
            System.out.println("Sie können diese Funktion noch nicht nutzen, denn es existiert noch kein Artikel.\n" + 
            "Bitte tätigen Sie 1 oder 2 um ein Artikel zu erstellen, oder 9 um das Programm zu verlassen.");
        } else {
            String neuerArt = "";
            boolean accepted = false;
            while (!accepted) {
                System.out.println("\nGeben Sie die neue Art des Artikels ein :");
                System.out.print(">>> ");
                neuerArt= scanner.next();
                try {
                    artikel.checkArt(neuerArt);
                    accepted = true;
                } catch (Exception e) {
                    System.out.println(e);
                    e.printStackTrace(System.out);
                }
                
            }
            artikel.setArt(neuerArt);
        }
    }

    
    /**
     * This method is used to return the values of the attributes of the class Artikel
     */
    public void artikelInformation() {
        if (artikel == null) {
            System.out.println("Sie können diese Funktion noch nicht nutzen, denn es existiert noch kein Artikel.\n" + 
            "Bitte tätigen Sie 1 oder 2 um ein Artikel zu erstellen, oder 9 um das Programm zu verlassen.");
        } else {
            System.out.println(artikel.toString());
        }
    }
}
