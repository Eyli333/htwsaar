/**
 * Ein Programm fuer eine Artikel Klasse 
 * @author Victor Plage and David Glaser
 * @version 06.11.22
 */
public class Artikel {
	private int artikelNr;
	private int bestand;
	private String art;


	/*
	 * erster Konstruktor der Klasse Artikel
	 * @param artikelNr Die Nummer des Artikels
	 * @param art Die Art des Artikels
	 * @param bestand Der Bestand der Artikel
	 */
	public Artikel(int artikelNr, String art, int bestand) { 
		this.artikelNr = artikelNr;
		this.art = art;
		this.bestand = bestand;
	}

	/*
	 * zweiter Konstruktor der Klasse Artikel
	 * @param artikelNr Die Nummer des Artikels
	 * @param art Die Art des Artikels
	 */
	public Artikel(int artikelNr, String art) { 
		this.artikelNr = artikelNr;
		this.art = art;
	}

	/*
	 * Erhoeht den Wert des Bestandes
	 * @param bestand Der Bestand der Artikel 
	 */
	public void bucheZugang(int menge) { // Methode für den Zugang des Bestandes
		this.bestand += menge;
	}

	/*
	 * Veringert den Wert des Bestandes
	 * @param bestand Der Bestand der Artikel
	 */
	public void bucheAbgang(int menge) { // Methode für den Abgang des Bestandes
		this.bestand -= menge;
	}

	/*
	 * Gibt den Wert des Attributes art aus
	 * @param art Die art des Artikels
	 */
	public String getArt() { 
		return art;
	}

	/*
	 * Gibt den Wert des Attributes artikelNr aus
	 * @param artikelNr Die Nummer des Artikels
	 */
	public int getAttribute() { 
		return artikelNr;
	}

	/*
	 * Gibt den Wert des Attributes bestand aus
	 * @param bestand Der Bestand der Artikel
	 */
	public int getBestand() { 
		return bestand;
	}
	
	/*
	 * Setzt den Wert des Attributes bestand
	 * @param bestand Der Bestand der Artikel
	 */
	public void setBestand(int neuerBestand) { 
		this.bestand = neuerBestand;
	}
	
	/*
	 * Gibt die Werte der Attributen in einem String aus
	 * @param artikelNr Die Nummer des Artikels
	 * @param art Die Art des Artikels
	 * @param bestand Der Bestand der Artikel
	 */
	public String toString() { 
		return "Artikel: " + artikelNr+ ", Art: " + art + ", Bestand: " + bestand;
	}
}
