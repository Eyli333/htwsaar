/**
 * <h1>Create Objects</h1>
 * This class allows the user to create, store, and manipulate multiple objects. The user can then interact with the objects using various methods provided by the class.
 *
 * @author Victor Plage and David Glaser
 * @version 1.1.1
 * @since 2022-11-04
 */

public final class Lager {
    private Artikel[] lager;
    private static final int STANDARD_GROESSE = 10;


    /**
     * Constructor that creates a Lager object with a given maximum number of articles that can be stored in the array.
     * @param maxArtikel The maximum number of articles that can be stored in the array.
     */
    public Lager(int maxArtikel) {
        TestUtils.checkGreaterThan(maxArtikel, 1, "lager");

        lager = new Artikel[maxArtikel];
        for (int i = 0; i < lager.length; i++) {
            lager[i] = null;
        }
    }
    /**
     * Alternate constructor that creates a Lager object with the default maximum number of articles that can be stored in the array.
     */
    public Lager() {
        this(STANDARD_GROESSE);
    }

    /**
     * This method used to add an object to the array lager.
     * @param artikel The object that is added to the array lager.
     */
    public final void legeAnArtikel(Artikel artikel){
        TestUtils.checkIfLagerIsFull(lager);
        TestUtils.checkIfInLager(artikel.getArtikelNr(), lager);

        for (int i = 0; i < lager.length; i++) {
            if (lager[i] == null) {
                lager[i] = artikel;
                break;
            }
        }
    }

    /**
     * This method is used to remove an object from the array lager.
     * @param artikelNr The object that is removed from the array lager.
     */
    public final void entferneArtikel(int artikelNr){
        TestUtils.checkIfLagerIsEmpty(lager);
        TestUtils.checkArtikelNr(artikelNr);
        TestUtils.checkIfNotInLager(artikelNr, lager);

        for (int i = 0; i < lager.length; i++) {
            if (lager[i].getArtikelNr() == artikelNr) {
                lager[i] = null;
                break;
            }
        }

        sortLager();
    }

    /**
     * This method is used to add a quantity to the attribute bestand
     * @param artikelNr This is the target Artikel
     * @param zugang This is the quantity that is added to the attribute bestand
     */
    public final void bucheZugang(int artikelNr, int zugang){ 
        TestUtils.checkIfLagerIsEmpty(lager);
        TestUtils.checkArtikelNr(artikelNr);
        TestUtils.checkIfNotInLager(artikelNr, lager);

        for (int i = 0; i < lager.length; i++) {
            if (lager[i].getArtikelNr() == artikelNr) {
                lager[i].bucheZugang(zugang);
                break;
            }
        }
    }

    /**
     * This method is used to remove a quantity from the attribute bestand
     * @param artikelNr This is the target Artikel
     * @param abgang This is the quantity that is removed from the attribute bestand
     */
    public final void bucheAbgang(int artikelNr, int abgang){
        TestUtils.checkIfLagerIsEmpty(lager);
        TestUtils.checkArtikelNr(artikelNr);
        TestUtils.checkIfNotInLager(artikelNr, lager);

        for (int i = 0; i < lager.length; i++) {
            if (lager[i].getArtikelNr() == artikelNr) {
                lager[i].bucheAbgang(abgang);
                break;
            }
        }
    }

    /**
     * This method is used to change the price of a specific Artikel by a certain percentage
     * @param artikelNr This is the target Artikel
     * @param prozent This is the percentage that is added or removed from the target Artikel's price
     */
    public final void aenderePreisEinesArtikels(int artikelNr, double prozent){
        TestUtils.checkIfLagerIsEmpty(lager);
        TestUtils.checkArtikelNr(artikelNr);
        TestUtils.checkIfNotInLager(artikelNr, lager);

        for (int i = 0; i < lager.length; i++) {
            if (lager[i].getArtikelNr() == artikelNr) {
                lager[i].aenderePreis(prozent);
                break;
            }
        }
    }

    /**
     * This method is used to change the price of all Artikel in the array lager by a certain percentage
     * @param prozent This is the percentage that is added or removed from all the Artikel's prices in the array lager
     */
    public final void aenderePreisAllerArtikel(double prozent){
        TestUtils.checkIfLagerIsEmpty(lager);

        for (int i = 0; i < lager.length; i++) {
            if (lager[i] != null) {
                lager[i].aenderePreis(prozent);
            }
        }
    }

    /**
     * This method is used to get the value of a target Artikel
     * @param index This is the index of target Artikel in the array lager
     * @return the target Artikel from the array lager at the given index
     */
    public final Artikel getArtikel(int index){
        TestUtils.checkIfLagerIsEmpty(lager);
        TestUtils.checkIfIndexIsInRange(index, lager.length);
        TestUtils.checkIfIndexIsNull(lager, index);

        return lager[index];
    }

    /**
     * This method is used to print all the Artikel from the array lager
     * @return a string representation of all the Artikel in the array lager
     */
    @Override    
    public String toString() {    
        StringBuilder output = new StringBuilder();    
        for (int i = 0; i < lager.length; i++) {    
            if (lager[i] != null) {    
                output.append(lager[i].toString()).append("\n");    
            }    
        }    
        return output.toString();    
    }

    /**
     * This method is used to get the quantity of Artikel in the array lager
     * @return the quantity of Artikel in the array lager
     */
    public final int getArtikelAnzahl(){
        TestUtils.checkIfLagerIsEmpty(lager); //jsp

        int count = 0;
        for (int i = 0; i < lager.length; i++) {
            if (lager[i] != null) {
                count++;
            }
        }
        return count;
    }

    /**
     * This method is used to get the size of the array lager
     * @return the size of the array lager
     */
    public final int getLagerGroesse(){
        return lager.length;
    }

    /**
     * This method sort the Null in the array to the end 
     */
    public final void sortLager() {
        for (int i = 0; i < lager.length; i++) {
            if (lager[i] == null) {
                for (int j = i; j < lager.length; j++) {
                    if (lager[j] != null) {
                        lager[i] = lager[j];
                        lager[j] = null;
                        break;
                    }
                }
            }
        }
    }

    /**
     * This a method that search for a Artikel in the array lager
     * it return true if the Artikel is in the array lager
     * else it return false
     * @param artikelNr This is the target Artikel
     * @return true if the Artikel is in the array lager
     * @return false if the Artikel is not in the array lager
     */
    public final boolean sucheArtikel(int artikelNr){
        TestUtils.checkIfLagerIsEmpty(lager);
        TestUtils.checkArtikelNr(artikelNr);

        for (int i = 0; i < lager.length; i++) {
            if (lager[i] != null) {
                if (lager[i].getArtikelNr() == artikelNr) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method is used to generate a list of all the Artikel in the array lager
     * including their details such as description, price, stock and total value.
     * @return a string representation of the list of all the Artikel in the array lager
     */
    public final String ausgebenBestandsListe(){    
        TestUtils.checkIfLagerIsEmpty(lager);    
        double sum = 0;    
        StringBuilder output = new StringBuilder();    
        int artNrWidth = 4;    
        int beschreibungWidth = 50;    
        int preisWidth = 10;    
        int bestandWidth = 10;    
        int gesamtWidth = 10;    
        int lineWidth = artNrWidth + beschreibungWidth + preisWidth + bestandWidth + gesamtWidth + 4;    
        String line = new String(new char[lineWidth]).replace("\0", "-");    
        output.append("ArtNr" + " " + "Beschreibung" + " " + "Preis" + " " + "Bestand" + " " + "Gesamt").append("\n");
        output.append(line).append("\n");    
        for (int i = 0; i < lager.length; i++) {    
            if (lager[i] != null) {    
                output.append(lager[i].getArtikelNr() + " " + lager[i].getBeschreibung() + " " + lager[i].getPreis() + " " + lager[i].getBestand() + " " + String.format("%.2f",lager[i].gesamtPreis())).append("\n");    
                sum += lager[i].gesamtPreis();    
            }    
        }    
        output.append(line).append("\n");    
        output.append("Gesamtwert: " + String.format("%.2f", sum)).append("\n");    
        return output.toString();
    }
}
