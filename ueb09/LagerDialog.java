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
    private static Scanner scanner = EingabeUtils.scanOpen();

    private static final int LAGER_CONSTRUCTOR_INT = 1;
    private static final int LAGER_CONSTRUCTOR_DEFAULT_INT = 2;
    private static final int CREATE_ARTIKEL_INT = 3;
    private static final int REMOVE_ARTIKEL_INT = 4;
    private static final int BOOK_RECEIPT_INT = 5;
    private static final int BOOK_RELEASE_INT = 6;
    private static final int CHANGE_PRICE_OF_ONE_ARTIKEL_INT = 7;
    private static final int CHANGE_PRICE_OF_ALL_ARTIKEL_INT = 8;
    private static final int GET_ARTIKEL_INT = 9;
    private static final int GET_INFORMATION_OF_LAGER_INT = 10;
    private static final int GET_NUMBER_OF_ARTIKEL_INT = 11;
    private static final int GET_SIZE_OF_LAGER_INT = 12;
    private static final int LAGER_EXIT_INT = 13;

    private static final int SET_BUCH_INT = 1;
    private static final int SET_VIDEO_INT = 2;
    private static final int SET_CD_INT = 3;
    private static final int SET_ARTIKEL_WITH_BESTAND_INT = 4;
    private static final int SET_ARTIKEL_WITHOUT_BESTAND_INT = 5;
    private static final int ARTIKEL_EXIT_INT = 6;

    private static final String LAGER_CONSTRUCTOR_STRING = " : Ein neues Lager erstellen";
    private static final String LAGER_CONSTRUCTOR_DEFAULT_STRING = " : Ein neues Lager mit der vorgegebenen Maximalgroesse 10 erstellen";
    private static final String CREATE_ARTIKEL_STRING = " : Ein neues Artikel erstellen";
    private static final String REMOVE_ARTIKEL_STRING = " : Ein Artikel entfernen";
    private static final String BOOK_RECEIPT_STRING = " : Buche Zugang";
    private static final String BOOK_RELEASE_STRING = " : Buche Abgang";
    private static final String CHANGE_PRICE_OF_ONE_ARTIKEL_STRING = " : Den Preis eines Artikel ändern";
    private static final String CHANGE_PRICE_OF_ALL_ARTIKEL_STRING = " : Den Preis aller Artikel ändern";
    private static final String GET_ARTIKEL_STRING = " : Informationen eines Artikels ausgeben";
    private static final String GET_INFORMATION_OF_LAGER_STRING = " : Informationen über das Lager";
    private static final String GET_NUMBER_OF_ARTIKEL_STRING = " : Anzahl der Artikel im Lager";
    private static final String GET_SIZE_OF_LAGER_STRING = " : Größe des Lagers";
    private static final String LAGER_EXIT_STRING = " : Das Programm beenden";

    private static final String SET_BUCH_STRING = " : Ein neues Buch anlegen";
    private static final String SET_VIDEO_STRING = " : Ein neues Video anlegen";
    private static final String SET_CD_STRING = " : Eine neue CD anlegen";
    private static final String SET_ARTIKEL_WITH_BESTAND_STRING = " : Ein neues Artikel mit Bestand anlegen";
    private static final String SET_ARTIKEL_WITHOUT_BESTAND_STRING = " : Ein neues Artikel ohne Bestand anlegen";
    private static final String ARTIKEL_EXIT_STRING = " : Zurück zum Hauptmenü";

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

        while (userInput != LAGER_EXIT_INT) {
            try {
                lagerMenuAusgabe();
                userInput = eingabeLesen();
                lagerEingabeBearbeitung(userInput);
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
    public void lagerMenuAusgabe() {
        System.out.print("\n"+
                LAGER_CONSTRUCTOR_INT + LAGER_CONSTRUCTOR_STRING + "\n" +
                LAGER_CONSTRUCTOR_DEFAULT_INT + LAGER_CONSTRUCTOR_DEFAULT_STRING + "\n" +
                CREATE_ARTIKEL_INT + CREATE_ARTIKEL_STRING + "\n" +
                REMOVE_ARTIKEL_INT + REMOVE_ARTIKEL_STRING + "\n" +
                BOOK_RECEIPT_INT + BOOK_RECEIPT_STRING + "\n" +
                BOOK_RELEASE_INT + BOOK_RELEASE_STRING + "\n" +
                CHANGE_PRICE_OF_ONE_ARTIKEL_INT + CHANGE_PRICE_OF_ONE_ARTIKEL_STRING + "\n" +
                CHANGE_PRICE_OF_ALL_ARTIKEL_INT + CHANGE_PRICE_OF_ALL_ARTIKEL_STRING + "\n" +
                GET_ARTIKEL_INT + GET_ARTIKEL_STRING + "\n" +
                GET_INFORMATION_OF_LAGER_INT + GET_INFORMATION_OF_LAGER_STRING + "\n" +
                GET_NUMBER_OF_ARTIKEL_INT + GET_NUMBER_OF_ARTIKEL_STRING + "\n" +
                GET_SIZE_OF_LAGER_INT + GET_SIZE_OF_LAGER_STRING + "\n" +
                LAGER_EXIT_INT + LAGER_EXIT_STRING + "\n"
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
    public void lagerEingabeBearbeitung(int userInput) {
        switch (userInput) {
            case LAGER_CONSTRUCTOR_INT:
                lagerConstructor();
                break;
            case LAGER_CONSTRUCTOR_DEFAULT_INT:
                lagerConstructorDefault();
                break;
            case CREATE_ARTIKEL_INT:
                createArtikel();
                break;
            case REMOVE_ARTIKEL_INT:
                removeArtikel();
                break;
            case BOOK_RECEIPT_INT:
                bookReceipt();
                break;
            case BOOK_RELEASE_INT:
                bookRelease();
                break;
            case CHANGE_PRICE_OF_ONE_ARTIKEL_INT:
                changePriceOfOneArtikel();
                break;
            case CHANGE_PRICE_OF_ALL_ARTIKEL_INT:
                changePriceOfAllArtikel();
                break;
            case GET_ARTIKEL_INT:
                getArtikel();
                break;
            case GET_INFORMATION_OF_LAGER_INT:
                getInformationOfLager();
                break;
            case GET_NUMBER_OF_ARTIKEL_INT:
                getNumberOfArtikel();
                break;
            case GET_SIZE_OF_LAGER_INT:
                getSizeOfLager();
                break;
            case LAGER_EXIT_INT:
                System.out.println("Das Programm wird beendet");
                EingabeUtils.scanClose(scanner);
                break;
            default:
                System.out.println(userInput + " ist keine gültige Nummer !");
                break;
        }
    }

    public void artikelMenuAusgabe() {
        System.out.print("\n"+
                SET_ARTIKEL_WITH_BESTAND_INT + SET_ARTIKEL_WITH_BESTAND_STRING + "\n" +
                SET_ARTIKEL_WITHOUT_BESTAND_INT + SET_ARTIKEL_WITHOUT_BESTAND_STRING + "\n" +
                SET_BUCH_INT + SET_BUCH_STRING + "\n" +
                SET_VIDEO_INT + SET_VIDEO_STRING + "\n" +
                SET_CD_INT + SET_CD_STRING + "\n" +
                ARTIKEL_EXIT_INT + ARTIKEL_EXIT_STRING + "\n"
                + ">>> "
                );
    }

    public void artikelEingabeBearbeitung(int userInput) {
        switch (userInput) {    
            case SET_ARTIKEL_WITH_BESTAND_INT:
                setArtikelWithBestand();
                break;
            case SET_ARTIKEL_WITHOUT_BESTAND_INT:
                setArtikelWithoutBestand();
                break;
            case SET_BUCH_INT:    
                setBuch();    
                break;    
            case SET_CD_INT:    
                setCD();    
                break;    
            case SET_VIDEO_INT:
                setVideo();    
                break;    
            case ARTIKEL_EXIT_INT:    
                System.out.println("Es wird zurück zum Hauptmenü gewechselt");
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
    public void lagerConstructor() {
        if (lager != null) {
            System.out.println("Es gibt schon ein Lager.");
        } else {
            System.out.println("Geben Sie die Größe des Lagers ein:");
            System.out.print(">>> ");
            int groesse = EingabeUtils.scanInt(scanner);

            lager = new Lager(groesse);
        }
    }

    /**
     * This method is used to create a new Lager with the default size of 10
     */
    public void lagerConstructorDefault() {
        if (lager != null) {
            System.out.println("Es gibt schon ein Lager.");
        } else {
            lager = new Lager();
        }
    }

    /**
     * This method is used to create a new Artikel without a bestand
     * It ask the user for the ArtikelNr, art and preis of the Artikel
     */
    public void createArtikel() {
        if (lager == null) {
            System.out.println("Es gibt noch kein Lager. erstellen Sie erstmal eins.");
        } else {
            int userInput = 0;
            while (userInput != ARTIKEL_EXIT_INT) {
                try {
                    artikelMenuAusgabe();
                    userInput = eingabeLesen();
                    artikelEingabeBearbeitung(userInput);
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

    }

    /**
     * This method is used to create a new Artikel with a bestand
     * It ask the user for the ArtikelNr, art, preis and bestand of the Artikel
     */
    public void setArtikelWithBestand() {
        System.out.println("Geben Sie die ArtikelNr ein:");
        System.out.print(">>> ");
        int artikelNr = EingabeUtils.scanInt(scanner);

        System.out.println("Geben Sie die Art ein:");
        System.out.print(">>> ");
        String art = EingabeUtils.scanString(scanner);

        System.out.println("Geben Sie den Bestand ein:");
        System.out.print(">>> ");
        int bestand = EingabeUtils.scanInt(scanner);

        System.out.println("Geben Sie den Preis ein:");
        System.out.print(">>> ");
        double preis = EingabeUtils.scanDouble(scanner);

        artikel = new Artikel(artikelNr, art, bestand, preis);
        lager.legeAnArtikel(artikel);
    }

    /**
     * This method is used to create a new Artikel with a bestand
     * It ask the user for the ArtikelNr, art, preis and bestand of the Artikel
     */
    public void setArtikelWithoutBestand() {
        System.out.println("Geben Sie die ArtikelNr ein:");
        System.out.print(">>> ");
        int artikelNr = EingabeUtils.scanInt(scanner);

        System.out.println("Geben Sie die Art ein:");
        System.out.print(">>> ");
        String art = EingabeUtils.scanString(scanner);

        System.out.println("Geben Sie den Bestand ein:");
        System.out.print(">>> ");
        int bestand = EingabeUtils.scanInt(scanner);

        System.out.println("Geben Sie den Preis ein:");
        System.out.print(">>> ");
        double preis = EingabeUtils.scanDouble(scanner);

        artikel = new Artikel(artikelNr, art, bestand, preis);
        lager.legeAnArtikel(artikel);
    }


    public void setBuch() {
        System.out.println("Geben Sie die ArtikelNr ein:");
        System.out.print(">>> ");
        int artikelNr = EingabeUtils.scanInt(scanner);

        System.out.println("Geben Sie den Titel ein:");
        System.out.print(">>> ");
        String title = EingabeUtils.scanString(scanner);

        System.out.println("Geben Sie den Autor ein:");
        System.out.print(">>> ");
        String author = EingabeUtils.scanString(scanner);

        System.out.println("Geben Sie den Verlag ein:");
        System.out.print(">>> ");
        String verlag = EingabeUtils.scanString(scanner);

        System.out.println("Geben Sie den Bestand ein:");
        System.out.print(">>> ");
        int bestand = EingabeUtils.scanInt(scanner);

        System.out.println("Geben Sie den Preis ein:");
        System.out.print(">>> ");
        double preis = EingabeUtils.scanDouble(scanner);

        Buch buch = new Buch(artikelNr, "Buch", bestand, preis, title, author, verlag);

        lager.legeAnArtikel(buch);
    }

    public void setVideo() {
        System.out.println("Geben Sie die ArtikelNr ein:");
        System.out.print(">>> ");
        int artikelNr = EingabeUtils.scanInt(scanner);

        System.out.println("Geben Sie den Titel ein:");
        System.out.print(">>> ");
        String title = EingabeUtils.scanString(scanner);

        System.out.println("Geben Sie die Spieldauer ein:");
        System.out.print(">>> ");
        int spieldauer = EingabeUtils.scanInt(scanner);

        System.out.println("Geben Sie das Jahr ein:");
        System.out.print(">>> ");
        int jahr = EingabeUtils.scanInt(scanner);

        System.out.println("Geben Sie den Bestand ein:");
        System.out.print(">>> ");
        int bestand = EingabeUtils.scanInt(scanner);

        System.out.println("Geben Sie den Preis ein:");
        System.out.print(">>> ");
        double preis = EingabeUtils.scanDouble(scanner);

        Video video = new Video(artikelNr, "Video", bestand, preis, title, spieldauer, jahr);

        lager.legeAnArtikel(video);
    }

    public void setCD(){
        System.out.println("Geben Sie die ArtikelNr ein:");
        System.out.print(">>> ");
        int artikelNr = EingabeUtils.scanInt(scanner);

        System.out.println("Geben Sie den Interpret ein:");
        System.out.print(">>> ");
        String interpret = EingabeUtils.scanString(scanner);

        System.out.println("Geben Sie den Titel ein:");
        System.out.print(">>> ");
        String title = EingabeUtils.scanString(scanner);

        System.out.println("Geben Sie die Titelanzahl ein:");
        System.out.print(">>> ");
        int anzahlTitel = EingabeUtils.scanInt(scanner);

        System.out.println("Geben Sie den Bestand ein:");
        System.out.print(">>> ");
        int bestand = EingabeUtils.scanInt(scanner);

        System.out.println("Geben Sie den Preis ein:");
        System.out.print(">>> ");
        double preis = EingabeUtils.scanDouble(scanner);

        CD cd = new CD(artikelNr, "CD", bestand, preis, interpret, title, anzahlTitel);

        lager.legeAnArtikel(cd);
    }

    /**
     * This method is used to remove an Artikel from the Lager
     * It ask the user for the ArtikelNr of the Artikel
     */
    public void removeArtikel() {
        if (lager == null) {
            System.out.println("Es gibt noch kein Lager. erstellen Sie erstmal eins.");
        } else {
            System.out.println("Geben Sie die ArtikelNr ein:");
            System.out.print(">>> ");
            int artikelNr = EingabeUtils.scanInt(scanner);

            lager.entferneArtikel(artikelNr);
        }
    }

    /**
     * This method is used to add a bestand to an Artikel
     * It ask the user for the ArtikelNr and the amount of the bestand that need to be modifed
     */
    public void bookRelease() {
        if (lager == null) {
            System.out.println("Es gibt noch kein Lager. erstellen Sie erstmal eins.");
        } else {
            System.out.println("Geben Sie die ArtikelNr ein:");
            System.out.print(">>> ");
            int artikelNr = EingabeUtils.scanInt(scanner);

            System.out.println("Geben Sie die Menge ein:");
            System.out.print(">>> ");
            int menge = EingabeUtils.scanInt(scanner);

            lager.bucheZugang(artikelNr, menge);
        }
    }

    /**
     * This method is used to remove a bestand from an Artikel
     * It ask the user the amount of the bestand that need to be modifed
     */
    public void bookReceipt() {
        if (lager == null) {
            System.out.println("Es gibt noch kein Lager. erstellen Sie erstmal eins.");
        } else {
            System.out.println("Geben Sie die ArtikelNr ein:");
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
     * It ask the user for the ArtikelNr and the percentage by which to change the price 
     */
    public void changePriceOfOneArtikel() {
        if (lager == null) { 
            System.out.println("Es gibt noch kein Lager. erstellen Sie erstmal eins.");
        } else {
            System.out.println("Geben Sie die ArtikelNr ein");
            System.out.print(">>> ");
            int artikelNr = EingabeUtils.scanInt(scanner);

            System.out.println("Geben Sie den Prozentsatz ein:");
            System.out.print(">>> ");
            double preis = EingabeUtils.scanDouble(scanner);

            lager.aenderePreisEinesArtikels(artikelNr, preis);
        }
    }

    /** 
     * This method is used to change the price of all Artikel
     * It ask the user for the percentage by which to change the price 
     */
    public void changePriceOfAllArtikel() {
        if (lager == null) {
            System.out.println("Es gibt noch kein Lager. erstellen Sie erstmal eins.");
        } else {
            System.out.println("Geben Sie den Prozentsatz ein:");
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
            System.out.println("Es gibt noch kein Lager. erstellen Sie erstmal eins.");
        } else {
            System.out.println("Geben Sie den Index ein: ");
            System.out.print(">>> ");
            int index = EingabeUtils.scanInt(scanner);

            System.out.println(lager.getArtikel(index));
        }
    }

    /**
     * This method is used to print the Lager
     */
    public void getInformationOfLager() {
        if (lager == null) {
            System.out.println("Es gibt noch kein Lager, erstellen Sie erstmal eins.");
        } else {
            if( lager.getArtikelAnzahl() == 0) {
                System.out.println("Es gibt keine Artikel im Lager, erstellen Sie erstmal welche.");
            } else {
                System.out.println(lager);
            }
        }
    }

    /**
     * This method is used to print the number of Artikel in the Lager
     */
    public void getNumberOfArtikel() {
        if (lager == null) {
            System.out.println("Es gibt noch kein Lager. erstellen Sie erstmal eins.");
        } else {
            System.out.println("Anzahl der Artikel: " + lager.getArtikelAnzahl());
        }
    }

    /**
     * This method is used to print the size of the Lager
     */
    public void getSizeOfLager() {
        if (lager == null) {
            System.out.println("Es gibt noch kein Lager. erstellen Sie erstmal eins.");
        } else {
            System.out.println("Lagergröße: " + lager.getLagerGroesse());
        }
    }
}
