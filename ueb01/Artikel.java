/**
 * @author Victor Plage and David Glaser
 * @version 06.11.22
 */
public class Artikel {
	private int artikelNr;
	private int bestand;
	private String art;

	public Artikel(int artikelNr, String art, int bestand) { // erster Konstruktor für Artikel
		this.artikelNr = artikelNr;
		this.artikelNr = artikelNr;
		this.art = art;
		this.bestand = bestand;
	}

	public Artikel(int artikelNr, String art) { // zweiter Konstruktor für Artikel
		this.artikelNr = artikelNr;
		this.artikelNr = artikelNr;
		this.art = art;
	}

	public void bucheZugang(int menge) { // Methode für den Zugang des Bestandes
		this.bestand += menge;
	}

	public void bucheAbgang(int menge) { // Methode für den Abgang des Bestandes
		this.bestand -= menge;
	}

	public String getArt() { // Methode zur Ausgabe der Art
		return art;
	}

	public int getAttribute() { // Methode zur Ausgabe der ArtikelNr
		return artikelNr;
	}

	public int getBestand() { // Methode zur Ausgabe des Bestandes
		return bestand;
	}
	
	public void setBestand(int neuerBestand) { // Methode zum setzen eines neuen Bestandes
		this.bestand = neuerBestand;
	}
	
	public String toString() { // Methode zur Ausgabe der Informationen über den Artikel
		return "Artikel: " + artikelNr+ ", Art: " + art + ", Bestand: " + bestand;
	}
}
