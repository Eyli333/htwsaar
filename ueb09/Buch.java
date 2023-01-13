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
    private String title;
    private String author;
    private String verlag;

    private static final String ARTIKEL_ART = "Medien";

    public Buch(int artikelNr, int bestand, double preis, String title, String author, String verlag) {
        super(artikelNr, ARTIKEL_ART, bestand, preis);
        setTitle(title);
        setAuthor(author);
        setVerlag(verlag);
    }

    public final void setTitle(String title) {
        TestUtils.checkIfEmpty(title);
        this.title = title;
    }

    public final void setAuthor(String author) {
        TestUtils.checkIfEmpty(author);
        this.author = author;
    }

    public final void setVerlag(String verlag) {
        TestUtils.checkIfEmpty(verlag);
        this.verlag = verlag;
    }

    public final String getTitle() {
        return title;
    }

    public final String getAuthor() {
        return author;
    }

    public final String getVerlag() {
        return verlag;
    }

    @Override
    public final String getBeschreibung() {
        return author + ": " + title;
    }

    @Override
    public final String toString() {
        return super.toString() + " Buch title: " + title + ", author: " + author + ", verlag: " + verlag;
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
        
        return Objects.equals(title, buch.title) &&
            Objects.equals(author, buch.author) &&
            Objects.equals(verlag, buch.verlag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, author, verlag);
    }
}

