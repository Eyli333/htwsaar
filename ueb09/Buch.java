/**
 * <h1>Book Class</h1>
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

    /**
     * Creates a new Buch object with the specified properties.
     *
     * @param artikelNr the article number of the book
     * @param bestand the stock of the book
     * @param preis the price of the book
     * @param titel the title of the book
     * @param autor the author of the book
     * @param verlag the publisher of the book
     */
    public Buch(int artikelNr, int bestand, double preis, String titel, String autor, String verlag) {
        super(artikelNr, ARTIKEL_ART, bestand, preis);
        setTitel(titel);
        setAutor(autor);
        setVerlag(verlag);
    }

    /**
     * Sets the title of the book.
     * @param titel the title to set
     */
    public final void setTitel(String titel) {
        TestUtils.checkIfEmpty(titel);
        this.titel = titel;
    }


    /**
     * Sets the author of the book.
     * @param autor the author to set
     */
    public final void setAutor(String autor) {
        TestUtils.checkIfEmpty(autor);
        this.autor = autor;
    }

    /**
     * Sets the publisher of the book.
     * @param verlag the publisher to set
     */
    public final void setVerlag(String verlag) {
        TestUtils.checkIfEmpty(verlag);
        this.verlag = verlag;
    }

    /**
     * Returns the title of the book.
     * @return the title
     */
    public final String getTitel() {
        return titel;
    }

    /**
     * Returns the author of the book.
     * @return the author
     */
    public final String getAutor() {
        return autor;
    }

    /**
     * Returns the publisher of the book.
     * @return the publisher
     */
    public final String getVerlag() {
        return verlag;
    }


    /**
     * Returns a description of the book in the format "author: title".
     * @return the description
     */
    @Override
    public final String getBeschreibung() {
        return autor + ": " + titel;
    }

    /**
     * Returns a string representation of the book.
     * @return the string representation
     */
    @Override
    public final String toString() {
        return super.toString() + ", Buch titel: " + titel + ", autor: " + autor + ", verlag: " + verlag;
    }
    /**
     * Checks if the provided object is equal to this book.
     * @param object the object to compare
     * @return true if the objects are equal, false otherwise
     */
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

    /**
     * Returns the hash code for this book.
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), titel, autor, verlag);
    }
}

