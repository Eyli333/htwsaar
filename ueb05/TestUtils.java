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
        if (temp == lager.length) {
            throw new IllegalArgumentException("Der Lager ist voll ein Artikel soll zuerst geloescht werden");
        }
    }

    /**
     * This method is used to check if the lager is empty
     * @param lager this is the lager that will be checked
     */
    public static void checkNull(Artikel[] lager) {
        int temp = 0;
        for (int i = 0; i < lager.length; i++) {
            if (lager[i] == null) {
                temp++;
            }
        }
        if (temp == lager.length) {
            throw new IllegalArgumentException("Der Lager ist leer");
        }
    }

    /**
     * This method is used to check if the lager containe the Artikel
     * @param lager this is the lager that will be checked
     * @param artikel this is the artikel that will be checked
     */
    public static void checkInLager(Artikel[] lager, int artikelNr) {
        for (int i = 0; i < lager.length; i++) {
            if (lager[i] != null && lager[i].getArtikelNr() == artikelNr) {
                throw new IllegalArgumentException("Der Artikel mit der Artikelnummer " + artikelNr + " ist bereits im Lager");
            }
        }
    }

    /**
     * This method is used to check if the lager containe the Artikel
     * @param lager this is the lager that will be checked
     * @param artikel this is the artikel that will be checked
     */
    public static void checkNotInLager(Artikel[] lager, int artikelNr) {
        for (int i = 0; i < lager.length; i++) {
            if (lager[i] != null && lager[i].getArtikelNr() == artikelNr) {
                return;
            }
        }
        throw new IllegalArgumentException("Der Artikel mit der Artikelnummer " + artikelNr + " ist nicht im Lager");
    }
    
    /**
     * This method is used to check if the idex is in the range of the lager
     * @param lager this is the lager that will be checked
     * @param index this is the index that will be checked
     */
    public static void checkIndex(int index, int size) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Der Index " + index + " ist nicht gueltig");
        }
    }
}
