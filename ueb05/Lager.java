/**
 * <h1>Create Objects</h1>
 * Allows the user to create, store and minpulate multiple 
 * objects. Then the user can interact 
 * with his items using methods
 * 
 * @author Victor Plage and David Glaser
 * @version 1.1.1
 * @since 2022-11-04
 */
public class Lager {
    private static final int MAX = 10;
    private Artikel[] lager;

    /**
     * This constructor is the main entry point for the Artikel class
     * @param size The size of the array
     */
    public Lager(int size) {
        TestUtils.checkSize(size, MAX);
        lager = new Artikel[size];
        for (int i = 0; i < lager.length; i++) {
            lager[i] = null;
        }
    }

    /**
     * This method adds an article to the array
     * @param artikel The article to be added
     */
    public void legeAnArtikel(Artikel artikel) {
        // This is a alternativ becaause the checkNotNull doesn funcktion
        // TestUtils.checkNotNull(lager);
        int temp = 0;
        for (int i = 0; i < lager.length; i++) {
            if (lager[i] != null) {
                temp++;
            }
        }
        if (temp == lager.length) {
            throw new IllegalArgumentException("Der Lager ist voll ein Artikel soll zuerst geloescht werden");
        }
        // end

        // check if the article is not already in the array
        for (int i = 0; i < lager.length; i++) {
            if (lager[i] != null && lager[i].getArtikelNr() == artikel.getArtikelNr()) {
                throw new IllegalArgumentException("Der Artikel ist schon im Lager");
            }
        }

        for (int i = 0; i < lager.length; i++) {
            if (lager[i] == null) {
                lager[i] = artikel;
                break;
            }
        }
    }

    /**
     * This method removes an article from the array
     * @param artikel The article to be removed
     */
    public void entferneArtikel(int artikelNr) {
        for (int i = 0; i < lager.length; i++) {
            if (lager[i].getArtikelNr() == artikelNr) {
                lager[i] = null;
                break;
            }
        }

        sort();
    }

    /**
     * This method is used remove a menge fron the artikel
     * @param artikelNr is the targeted Artikel 
     * @param abgang is how many will be remove
     */
    public void bucheAbgang(int artikelNr, int abgang) {
        for (int i = 0; i < lager.length; i++) {
            if (lager[i].getArtikelNr() == artikelNr) {
                lager[i].bucheAbgang(abgang);
                break;
            }
        }
    }

    /**
     * This mehtod is used to add to the artikel a new zugang
     * @param artikelNr is the targeted Artikel
     * @param zugang is how many will be added
     */
    public void bucheZugang(int artikelNr, int zugang) {
        for (int i = 0; i < lager.length; i++) {
            if (lager[i].getArtikelNr() == artikelNr) {
                lager[i].bucheZugang(zugang);
                break;
            }
        }
    }

    /**
     * This method is used to change the Preis 
     * @param artikelNr is the targeted Artikel
     * @param preis is the new Preis
     */
    public void aenderePreisEinesArtikels(int artikelNr, double prozent) {
        for (int i = 0; i < lager.length; i++) {
            if (lager[i].getArtikelNr() == artikelNr) {
                lager[i].setPreis(lager[i].getPreis() * (1 + prozent / 100));
                break;
            }
        }
    }

    /**
     * This method is used to change the Preis of all Artikel 
     * @param prozent is the new Preis
     */
    public void aenderePreisAllerArtikel(double prozent) {
        for (int i = 0; i < lager.length; i++) {
            lager[i].setPreis(lager[i].getPreis() * (1 + prozent / 100));
        }
    }

    /**
     * This method is used to get the Artikel at a specific index
     * @param index is the index of the Artikel
     * @return the Artikel at the index
     */
    public Artikel getArtikel(int index) {
        return lager[index];
    }

    /**
     * This method is used to return the number of Artikel in the array
     * @return the number of Artikel in the array
     */
    public int getArtikelAnzahl() {
        int count = 0;
        for (int i = 0; i < lager.length; i++) {
            if (lager[i] != null) {
                count++;
            }
        }
        return count;
    }

    /**
     * This method is used to return the max number that 
     * can be stored in the array
     * @return the max number that can be stored in the array
     */
    public int getLagerGroesse() {
        return lager.length;
    }

    /**
     * This method is used to return the elements of the array
     * @return the elements of the array
     */
    public String toString() {
        // TestUtils.checkNotNull(lager); see first or second function
        String s = "";
        for (int i = 0; i < lager.length; i++) {
            if (lager[i] != null) {
                s += lager[i].toString() + "\n";
            }
        }
        return s;
    }

    /**
     * This method sort the Null in the array to the end 
     */
    public void sort() {
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

}
