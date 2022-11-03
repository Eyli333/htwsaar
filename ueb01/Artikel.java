public class Artikel {
	private int artikelNr;
	private int bestand;
	private String art;

	public Artikel(int artikelNr, String art, int bestand){
		this.artikelNr = artikelNr;
		this.art = art;
		this.bestand = bestand;
	}

	public Artikel(int artikelNr, String art){
		this.artikelNr = artikelNr;
		this.art = art;
	}

	public void bucheZugang(int menge){
		this.bestand = this.bestand + menge;
	}

	public void bucheAbgang(int menge){
		this.bestand = this.bestand - menge;
	}

	public void setBestand(int neuerBestand) {
		this.bestand = neuerBestand;
	}

	public String toString() {
		return "Artikel: " + artikelNr+ ", Art: " + art + ", Bestand: " + bestand;
	}

	public String getArt(){
		return art;
	}

	public int getAttribute(){
		return artikelNr;
	}

	public int getBestand(){
		return bestand;
	}
}
