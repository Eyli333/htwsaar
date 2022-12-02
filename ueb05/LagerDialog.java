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

public class LagerDialog {
    private Artikel artikel;
    private Lager lager;

    private static final int LAGER_KONSTRUKTEUR_INT = 1;
    private static final int ARTIKEL_LEGEN_MIT_BESTANT_INT = 2;
    private static final int ARTIKEL_LEGEN_OHNE_BESTANT_INT = 3;
    private static final int ARTIKEL_ENTFERNEN_INT = 4;
    private static final int BUCHE_ZUGANG_INT = 5;
    private static final int BUCHE_ABGANG_INT = 6;
    private static final int ANDERER_PREIS_ARTIKEL_INT = 7;
    private static final int ANDERER_PREIS_GLOBAL_INT = 8;
    private static final int GET_ARTIKEL_INT = 9;
    private static final int INFORMATION_LAGER_INT = 10;
    private static final int GET_NUMBER_OF_ARTIKEL_INT = 11;
    private static final int GET_GROESSE_LAGER_INT = 12;
    private static final int EXIT_INT = 13;

    private static final String LAGER_KONSTRUKTEUR_STRING = " : Ein neuer Lager erstellen";
    private static final String ARTIKEL_LEGEN_MIT_BESTANT_STRING = " : Ein neuer Artikel mit Bestand legen";
    private static final String ARTIKEL_LEGEN_OHNE_BESTANT_STRING = " : Ein neuer Artikel ohne Bestand legen";
    private static final String ARTIKEL_ENTFERNEN_STRING = " : Ein Artikel entfernen";
    private static final String BUCHE_ZUGANG_STRING = " : Buche Zugang";
    private static final String BUCHE_ABGANG_STRING = " : Buche Abgang";
    private static final String ANDERER_PREIS_ARTIKEL_STRING = " : Den Preis eines Artikel ändern";
    private static final String ANDERER_PREIS_GLOBAL_STRING = " : Den Preis aller Artikel ändern";
    private static final String GET_ARTIKEL_STRING = " : Ein Artikel bekommen";
    private static final String INFORMATION_LAGER_STRING = " : Informationen über das Lager";
    private static final String GET_NUMBER_OF_ARTIKEL_STRING = " : Die Anzahl der Artikel bekommen";
    private static final String GET_GROESSE_LAGER_STRING = " : Die Größe des Lagers bekommen";
    private static final String EXIT_STRING = " : Das Programm beenden";

    private static Scanner scanner = EingabeUtils.scanOpen();

    /**
     * The main Funktion start a new ArtikelDialog Objekt
     */
    public static void main( String[] args) {
        new LagerDialog().start();
    }

    /** 
     * Main loop of the Programm
     */
    public void start() {

        lager = null;
        int userInput = 0;

        while (userInput != EXIT_INT) {
            try {
                menuAusgabe();
                userInput = eingabeLesen();
                eingabeBearbeitung(userInput);
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

    }

    /**
     * This method is used to print the different choices
     */
    public void menuAusgabe() {
        System.out.print("\n"+
            LAGER_KONSTRUKTEUR_INT + LAGER_KONSTRUKTEUR_STRING + "\n" +
            ARTIKEL_LEGEN_MIT_BESTANT_INT + ARTIKEL_LEGEN_MIT_BESTANT_STRING + "\n" +
            ARTIKEL_LEGEN_OHNE_BESTANT_INT + ARTIKEL_LEGEN_OHNE_BESTANT_STRING + "\n" +
            ARTIKEL_ENTFERNEN_INT + ARTIKEL_ENTFERNEN_STRING + "\n" +
            BUCHE_ZUGANG_INT + BUCHE_ZUGANG_STRING + "\n" +
            BUCHE_ABGANG_INT + BUCHE_ABGANG_STRING + "\n" +
            ANDERER_PREIS_ARTIKEL_INT + ANDERER_PREIS_ARTIKEL_STRING + "\n" +
            ANDERER_PREIS_GLOBAL_INT + ANDERER_PREIS_GLOBAL_STRING + "\n" +
            GET_ARTIKEL_INT + GET_ARTIKEL_STRING + "\n" +
            INFORMATION_LAGER_INT + INFORMATION_LAGER_STRING + "\n" +
            GET_NUMBER_OF_ARTIKEL_INT + GET_NUMBER_OF_ARTIKEL_STRING + "\n" +
            GET_GROESSE_LAGER_INT + GET_GROESSE_LAGER_STRING + "\n" +
            EXIT_INT + EXIT_STRING + "\n"
            + ">>> "
        );
    } 

    /**
     * This method is used to read the user input and return it
     * @return userInput as an Integer 
     */
    public int eingabeLesen() {
        int userInput = EingabeUtils.scanInt(scanner);
        return userInput;
    }

    /**
     * This method is use to execute the user choice 
     * @param userInput The input from the user
     */
    public void eingabeBearbeitung(int userInput) {
        switch (userInput) {
            case LAGER_KONSTRUKTEUR_INT:
                lagerKonstrukteur();
                break;
            case ARTIKEL_LEGEN_MIT_BESTANT_INT:
                artikelLegenMitBestand();
                break;
            case ARTIKEL_LEGEN_OHNE_BESTANT_INT:
                artikelLegenOhneBestand();
                break;
            case ARTIKEL_ENTFERNEN_INT:
                artikelEntfernen();
                break;
            case BUCHE_ZUGANG_INT:
                bucheZugang();
                break;
            case BUCHE_ABGANG_INT:
                bucheAbgang();
                break;
            case ANDERER_PREIS_ARTIKEL_INT:
                andererPreisArtikel();
                break;
            case ANDERER_PREIS_GLOBAL_INT:
                andererPreisGlobal();
                break;
            case GET_ARTIKEL_INT:
                getArtikel();
                break;
            case INFORMATION_LAGER_INT:
                informationLager();
                break;
            case GET_NUMBER_OF_ARTIKEL_INT:
                getNumberOfArtikel();
                break;
            case GET_GROESSE_LAGER_INT:
                getSizeLager();
                break;
            case EXIT_INT:
                System.out.println("Das Programm wird beendet");
                EingabeUtils.scanClose(scanner);
                break;
            default:
                System.out.println(userInput + " ist keine gültige Nummer !");
                break;
        }
    }

    /**
     * This method is used to create a new Lager
     * It ask the user for the size of the Lager
     */
    public void lagerKonstrukteur() {
        if (lager != null) {
            System.out.println("Es gibt schon ein Lager");
        } else {
            System.out.println("Geben Sie die Größe des Lagers ein");
            System.out.print(">>> ");
            int groesse = EingabeUtils.scanInt(scanner);

            lager = new Lager(groesse);
        }
    }

    /**
     * This method is used to create a new Artikel with a bestand
     * It ask the user for the ArtikelNr, art, preis and bestand of the Artikel
     */
    public void artikelLegenMitBestand() {
        if (lager == null) {
            System.out.println("Es gibt kein Lager. Erstellen Sie ein Lager");
        } else {

            System.out.println("Geben Sie die ArtikelNr ein");
            System.out.print(">>> ");
            int artikelNr = EingabeUtils.scanInt(scanner);

            System.out.println("Geben Sie die Art ein");
            System.out.print(">>> ");
            String art = EingabeUtils.scanString(scanner);

            System.out.println("Geben Sie den Preis ein");
            System.out.print(">>> ");
            double preis = EingabeUtils.scanDouble(scanner);

            System.out.println("Geben Sie den Bestand ein");
            System.out.print(">>> ");
            int bestand = EingabeUtils.scanInt(scanner);

            artikel = new Artikel(artikelNr, art, bestand, preis);
            lager.legeAnArtikel(artikel);
        }
    }

    /**
     * This method is used to create a new Artikel without a bestand
     * It ask the user for the ArtikelNr, art and preis of the Artikel
     */
    public void artikelLegenOhneBestand() {
        if (lager == null) {
            System.out.println("Es gibt kein Lager. Erstellen Sie ein Lager");
        } else {

            System.out.println("Geben Sie die ArtikelNr ein");
            System.out.print(">>> ");
            int artikelNr = EingabeUtils.scanInt(scanner);

            System.out.println("Geben Sie die Art ein");
            System.out.print(">>> ");
            String art = EingabeUtils.scanString(scanner);

            System.out.println("Geben Sie den Preis ein");
            System.out.print(">>> ");
            double preis = EingabeUtils.scanDouble(scanner);

            artikel = new Artikel(artikelNr, art, preis);
            lager.legeAnArtikel(artikel);
        }
    }

    /**
     * This method is used to remove an Artikel from the Lager
     * It ask the user for the ArtikelNr of the Artikel
     */
    public void artikelEntfernen() {
        if (lager == null) {
            System.out.println("Es gibt kein Lager. Erstellen Sie ein Lager");
        } else {
            System.out.println("Geben Sie die ArtikelNr ein");
            System.out.print(">>> ");
            int artikelNr = EingabeUtils.scanInt(scanner);

            lager.entferneArtikel(artikelNr);
        }
    }

    /**
     * This method is used to add a bestand to an Artikel
     * It ask the user for the ArtikelNr and the amount of the bestand that need to be modifed
     */
    public void bucheZugang() {
        if (lager == null) {
            System.out.println("Es gibt kein Lager. Erstellen Sie ein Lager");
        } else {
            System.out.println("Geben Sie die ArtikelNr ein");
            System.out.print(">>> ");
            int artikelNr = EingabeUtils.scanInt(scanner);

            System.out.println("Geben Sie die Menge ein");
            System.out.print(">>> ");
            int menge = EingabeUtils.scanInt(scanner);

            lager.bucheZugang(artikelNr, menge);
        }
    }

    /**
     * This method is used to remove a bestand from an Artikel
     * It ask the user the amount of the bestand that need to be modifed
     */
    public void bucheAbgang() {
        if (lager == null) {
            System.out.println("Es gibt kein Lager. Erstellen Sie ein Lager");
        } else {
            System.out.println("Geben Sie die ArtikelNr ein");
            System.out.print(">>> ");
            int artikelNr = EingabeUtils.scanInt(scanner);

            System.out.println("Geben Sie die Menge ein");
            System.out.print(">>> ");
            int menge = EingabeUtils.scanInt(scanner);

            lager.bucheAbgang(artikelNr, menge);
        }
    }

    /**
     * This method is used to change the price of an Artikel
     * It ask the user for the ArtikelNr and the new price of the Artikel
     */
    public void andererPreisArtikel() {
        if (lager == null) {
            System.out.println("Es gibt kein Lager. Erstellen Sie ein Lager");
        } else {
            System.out.println("Geben Sie die ArtikelNr ein");
            System.out.print(">>> ");
            int artikelNr = EingabeUtils.scanInt(scanner);

            System.out.println("Geben Sie den neuen Preis ein");
            System.out.print(">>> ");
            double preis = EingabeUtils.scanDouble(scanner);

            lager.aenderePreisEinesArtikels(artikelNr, preis);
        }
    }

    /** 
     * This method is used to change the price of all Artikel
     * It ask the user for the new price of all Artikel
     */
    public void andererPreisGlobal() {
        if (lager == null) {
            System.out.println("Es gibt kein Lager. Erstellen Sie ein Lager");
        } else {
            System.out.println("Geben Sie den neuen Preis ein");
            System.out.print(">>> ");
            double preis = EingabeUtils.scanDouble(scanner);

            lager.aenderePreisAllerArtikel(preis);
        }
    }

    /**
     * This method is used to print the Artikel
     * It ask the user for the index
     */
    public void getArtikel() {
        if (lager == null) {
            System.out.println("Es gibt kein Lager. Erstellen Sie ein Lager");
        } else {
            System.out.println("Geben Sie den Index ein");
            System.out.print(">>> ");
            int index = EingabeUtils.scanInt(scanner);

            System.out.println(lager.getArtikel(index));
        }
    }

    /**
     * This method is used to print the Lager
     */
    public void informationLager() {
        if (lager == null) {
            System.out.println("Es gibt kein Lager. Erstellen Sie ein Lager");
        } else {
            System.out.println(lager);
        }
    }

    /**
     * This method is used to print the number of Artikel in the Lager
     */
    public void getNumberOfArtikel() {
        if (lager == null) {
            System.out.println("Es gibt kein Lager. Erstellen Sie ein Lager");
        } else {
            System.out.println("Anzahl der Artikel: " + lager.getArtikelAnzahl());
        }
    }

    /**
     * This method is used to print the size of the Lager
     */
    public void getSizeLager() {
        if (lager == null) {
            System.out.println("Es gibt kein Lager. Erstellen Sie ein Lager");
        } else {
            System.out.println("Lagergröße: " + lager.getLagerGroesse());
        }
    }
}
