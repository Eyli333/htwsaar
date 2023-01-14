/**
 * <h1>Create Objects</h1>
 * Allows the user to create objects with a number, 
 * a type and a quantity. Then the user can interact 
 * with his items using methods
 * 
 * @author Victor Plage and David Glaser
 * @version 1.1.1
 * @since 2022-11-04
 */

import java.util.Objects;

public final class Buch extends Artikel {
    private String titel;
    private String autor;
    private String verlag;

    private static final String ARTIKEL_ART = "Medien";

    public Buch(int artikelNr, int bestand, double preis, String titel, String autor, String verlag) {
        super(artikelNr, ARTIKEL_ART, bestand, preis);
        setTitel(titel);
        setAutor(autor);
        setVerlag(verlag);
    }

    public final void setTitel(String titel) {
        TestUtils.checkIfEmpty(titel);
        this.titel = titel;
    }

    public final void setAutor(String autor) {
        TestUtils.checkIfEmpty(autor);
        this.autor = autor;
    }

    public final void setVerlag(String verlag) {
        TestUtils.checkIfEmpty(verlag);
        this.verlag = verlag;
    }

    public final String getTitel() {
        return titel;
    }

    public final String getAutor() {
        return autor;
    }

    public final String getVerlag() {
        return verlag;
    }

    @Override
    public final String getBeschreibung() {
        return autor + ": " + titel;
    }

    @Override
    public final String toString() {
        return super.toString() + ", Buch titel: " + titel + ", autor: " + autor + ", verlag: " + verlag;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object){ 
            return true;
        }
        if (object == null || getClass() != object.getClass()){
            return false;
        }
        if (!super.equals(object)){
            return false;
        }
        
        Buch buch = (Buch) object;
        
        return Objects.equals(titel, buch.titel) &&
            Objects.equals(autor, buch.autor) &&
            Objects.equals(verlag, buch.verlag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), titel, autor, verlag);
    }
}

