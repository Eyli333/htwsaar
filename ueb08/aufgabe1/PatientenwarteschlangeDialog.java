import java.util.InputMismatchException;
import java.util.Scanner;

public class PatientenwarteschlangeDialog {
    private PatientenWarteschlange patientenwarteschlange;
    private static Scanner scanner = EingabeUtils.scanOpen();

    private static final int LAGER_CONSTRUCTOR_INT = 1;
    private static final int LAGER_CONSTRUCTOR_DEFAULT_INT = 2;
    private static final int SET_ARTIKEL_WITH_BESTAND_INT = 3;
    private static final int SET_ARTIKEL_WITHOUT_BESTAND_INT = 4;
    private static final int REMOVE_ARTIKEL_INT = 5;
    private static final int BOOK_RECEIPT_INT = 6;
    private static final int BOOK_RELEASE_INT = 7;
    private static final int CHANGE_PRICE_OF_ONE_ARTIKEL_INT = 8;
    private static final int CHANGE_PRICE_OF_ALL_ARTIKEL_INT = 9;
    private static final int GET_ARTIKEL_INT = 10;
    private static final int GET_INFORMATION_OF_LAGER_INT = 11;
    private static final int GET_NUMBER_OF_ARTIKEL_INT = 12;
    private static final int GET_SIZE_OF_LAGER_INT = 13;
    private static final int EXIT_INT = 14;

    private static final String LAGER_CONSTRUCTOR_STRING = " : Ein neues Lager erstellen";
    private static final String LAGER_CONSTRUCTOR_DEFAULT_STRING = " : Ein neues Lager mit der vorgegebenen Maximalgroesse 10 erstellen";
    private static final String SET_ARTIKEL_WITH_BESTAND_STRING = " : Ein neuen Artikel mit Bestand anlegen";
    private static final String SET_ARTIKEL_WITHOUT_BESTAND_STRING = " : Ein neuen Artikel ohne Bestand anlegen";
    private static final String REMOVE_ARTIKEL_STRING = " : Ein Artikel entfernen";
    private static final String BOOK_RECEIPT_STRING = " : Buche Zugang";
    private static final String BOOK_RELEASE_STRING = " : Buche Abgang";
    private static final String CHANGE_PRICE_OF_ONE_ARTIKEL_STRING = " : Den Preis eines Artikel ändern";
    private static final String CHANGE_PRICE_OF_ALL_ARTIKEL_STRING = " : Den Preis aller Artikel ändern";
    private static final String GET_ARTIKEL_STRING = " : Informationen eines Artikels ausgeben";
    private static final String GET_INFORMATION_OF_LAGER_STRING = " : Informationen über das Lager";
    private static final String GET_NUMBER_OF_ARTIKEL_STRING = " : Anzahl der Artikel im Lager";
    private static final String GET_SIZE_OF_LAGER_STRING = " : Größe des Lagers";
    private static final String EXIT_STRING = " : Das Programm beenden";


    /**
     * The main Funktion start a new ArtikelDialog Objekt
     */
    public static void main( String[] args) {
        new PatientenwarteschlangeDialog().start();
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
            LAGER_CONSTRUCTOR_INT + LAGER_CONSTRUCTOR_STRING + "\n" +
            LAGER_CONSTRUCTOR_DEFAULT_INT + LAGER_CONSTRUCTOR_DEFAULT_STRING + "\n" +
            SET_ARTIKEL_WITH_BESTAND_INT + SET_ARTIKEL_WITH_BESTAND_STRING + "\n" +
            SET_ARTIKEL_WITHOUT_BESTAND_INT + SET_ARTIKEL_WITHOUT_BESTAND_STRING + "\n" +
            REMOVE_ARTIKEL_INT + REMOVE_ARTIKEL_STRING + "\n" +
            BOOK_RECEIPT_INT + BOOK_RECEIPT_STRING + "\n" +
            BOOK_RELEASE_INT + BOOK_RELEASE_STRING + "\n" +
            CHANGE_PRICE_OF_ONE_ARTIKEL_INT + CHANGE_PRICE_OF_ONE_ARTIKEL_STRING + "\n" +
            CHANGE_PRICE_OF_ALL_ARTIKEL_INT + CHANGE_PRICE_OF_ALL_ARTIKEL_STRING + "\n" +
            GET_ARTIKEL_INT + GET_ARTIKEL_STRING + "\n" +
            GET_INFORMATION_OF_LAGER_INT + GET_INFORMATION_OF_LAGER_STRING + "\n" +
            GET_NUMBER_OF_ARTIKEL_INT + GET_NUMBER_OF_ARTIKEL_STRING + "\n" +
            GET_SIZE_OF_LAGER_INT + GET_SIZE_OF_LAGER_STRING + "\n" +
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
            case LAGER_CONSTRUCTOR_INT:
                lagerConstructor();
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
    public void lagerConstructor() {
        patientenwarteschlange = new PatientenWarteschlange(10);
        patientenwarteschlange.neuerPatient(1234, "Ellie", "Fant");
        patientenwarteschlange.neuerPatient(1111, "Moni", "Tor");
        patientenwarteschlange.neuerPatient(2222, "Phil", "Harmonie");
        
        System.out.println(patientenwarteschlange);
    }
}
