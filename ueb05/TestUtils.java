public class TestUtils {
    
    /**
     * This method is used to check if new Art variable can be used
     * @param inputArt This is the new Art that will be checked
     */
    public static void checkArt(String inputArt) {
        if (inputArt.strip().isEmpty()) {
            throw new IllegalArgumentException("Art kann nicht leer sein");    
        } else if (!inputArt.equals(inputArt.strip())){
            throw new IllegalArgumentException("Sie koennen keine Leerzeichen vor oder nach dem Objekt eingeben.");    
        }
    }

    /**
     * This method is used to check if new bestand variable can be used
     * @param inputBestand This is the new bestand that will be checked
     */
    public static void checkBestand(int inputBestand) {
        if (inputBestand < 0) {
            throw new IllegalArgumentException("Der Bestand kann nicht negativ sein");
        }
    }

    /**
     * This method is used to check if new ArtikelNr variable can be used
     * @param inputArtikelNr This is the new ArtikelNr that will be checked
     */
    public static void checkArtikelNr(int inputArtikelNr) { 
        if (inputArtikelNr < 1000  || inputArtikelNr > 9999) { 
            throw new IllegalArgumentException("Die Artikelnummer muss groesser als 1000 und eine positive vierstellige Zahl sein");
        }
    }

    /**
     * This method is used to check if new preis variable can be used
     * @param preis This is the new preis that will be checked
     */
    public static void checkPreis(double inputPreis) { 
        if (inputPreis < 0.0) { 
            throw new IllegalArgumentException("Der Preis " + inputPreis + " ist nicht gueltig. Der Preis soll groesser als 0 sein");
        }
    }

    /**
     * This method is used to check if the size is not bigger than 10 
     * @param size this is the size that will be checked
     * @param MAX this is the Max that will be used to compare
     */
    public static void checkSize(int size, int MAX) {
        if (size > MAX) {
            throw new IllegalArgumentException("Die Groesse kann nicht groesser als " + MAX + " sein");
        }
        if (size < 0) {
            throw new IllegalArgumentException("Die Groesse kann nicht kleiner als 0 sein");
        }
    }

    /**
     * This method is used to check if a Array have a null value in a index
     * @param array this is the array that will be checked
     */
    public static void checkNotNull(Artikel[] lager) {
        int temp = 0;
        for (int i = 0; i < lager.length; i++) {
            if (lager[i] != null) {
                temp++;
            }
        }
        if (temp != 0) {
            throw new IllegalArgumentException("Der Lager ist voll ein Artikel soll zuerst geloescht werden");
        }
    }
}
