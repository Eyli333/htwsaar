/**
 * <h1>Create Objects</h1>
 * Allows the user to create objects with a number, 
 * a type and a quantity. Then the user can interact 
 * with his items using methods
 * 
 * @author Victor Plage and David Glaser
 * @version 1.1.0
 * @since 2022-11-04
 */
public class Artikel {
	private int artikelNr;
	private int bestand;
	private String art;
	
	/**
	 * This constructor is the main entry point for the Artikel class
	 * @param artikelNr This is the first attribute of the class Artikel 
	 * @param art This is the second attribute of the class Artikel
	 * @param bestand This is the third attribute of the class Artikel
	 */
	public Artikel(int artikelNr, String art, int bestand) { 

		checkArtikelNr(artikelNr);
		checkArt(art);
		checkBestand(bestand);
		
		this.artikelNr = artikelNr;
		this.art = art;
		this.bestand = bestand;
	}
	
	
	/**
	 * This constructor is the second entry of the class Artikel
	 * @param artikelNr This is the first attribute of the class Artikel 
	 * @param art This is the second attribute of the class Artikel 
	 */
	public Artikel(int artikelNr, String art) { 
		this(artikelNr, art, 0);
	}

	/**
	 * This method is used to increase the value of the attribute bestand
	 * @param bestand This is the third attribute of the class Artikel
	 */
	public void bucheZugang(int menge) {
		if (menge <= 0) {
			throw new IllegalArgumentException("Die Menge kann nicht null oder negatif sein");
		}
		this.bestand += menge;
	}

	/**
	 * This method is used to decrease the value of the attribute bestand
	 * @param bestand This is the third attribute of the class Artikel
	 */
	public void bucheAbgang(int menge) { 
		if (this.bestand - menge < 0) {
			throw new IllegalArgumentException("Der Bestand wurde nicht aktualisert, sonst ist der Bestand negativ");	
		} 
		this.bestand -= Math.abs(menge);
	}

	/**
	* This method is used to return the value of the attribute artikelNr
	* @param artikelNr This is the first attribute of the class Artikel
	* @return string This returns the content of art
	*/
	public int getArtikel() { 
		return artikelNr;
	}

	/**
	 * This method is used to return the value of the attribute art
	 * @param art This is the second attribute of the class Artikel
	 * @return string This returns the value of art
	 */
	public String getArt() { 
		return art;
	}
	
	/**
	 * This method is used to return the value of the attribute bestand
	 * @param bestand This is the third attribute of the class Artikel
	 * @return int This returns the value of bestand
	 */
	public int getBestand() { 
		return bestand;
	}

	/**
	 * This method is use to set the value of ArtikelNr
	 * @param ArtikelNr This is the first attribute of the class Artikel
	 */
	public void setArtikelNr(int neueArtikelNr) {
		checkArtikelNr(neueArtikelNr);
		this.artikelNr = neueArtikelNr;
	}

	/**
	 * This method is used to set the value of bestand
	 * @param bestand This is the second attribute of the class Artikel
	 */
	public void setBestand(int neuerBestand) { 
		checkBestand(neuerBestand);
		this.bestand = neuerBestand;
	}
	
	/**
	 * This method is used to set the value of art
	 * @param bestand This is the third attribute of the class Artikel
	 */
	public void setArt(String neuerArt) {
		checkArt(neuerArt);
		this.art = neuerArt;
	}

	/**
	 * This method is used to return the values of the attributes of the class Artikel
	 * @param artikelNr This is the first attribute of the class Artikel 
	 * @param art This is the second attribute of the class Artikel
	 * @param bestand This is the third attribute of the class Artikel
	 * @return string This returns the attributes artikelNr, art and bestand in a String
	 */
	public String toString() { 
		return "Artikel: " + artikelNr + ", Art: " + art + ", Bestand: " + bestand;
	}

	/**
	 * This method is used to check if new Art variable can be used
	 * @param inputArt This is the new Art that will be checked
	 */
	public void checkArt(String inputArt) {
		if (inputArt.strip().isEmpty()) {
			throw new IllegalArgumentException("Art kann nicht leer sein");	
		}
	}

	/**
	 * This method is used to check if new bestand variable can be used
	 * @param inputBestand This is the new bestand that will be checked
	 */
	public void checkBestand(int inputBestand) {
		if (inputBestand < 0) {
			throw new IllegalArgumentException("Der Bestand kann nicht negativ sein");
		}
	}

	/**
	 * This method is used to check if new ArtikelNr variable can be used
	 * @param inputArtikelNr This is the new ArtikelNr that will be checked
	 */
	public void checkArtikelNr(int inputArtikelNr) { 
        	if (inputArtikelNr < 1000  || String.valueOf(inputArtikelNr).length() != 4) { 
           		throw new IllegalArgumentException("Die Artikelnummer muss groesser als 1000 und eine positive vierstellige Zahl sein");
		}
	}
    }
