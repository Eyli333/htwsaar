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

public final class Video extends Artikel {
    private String title;
    private int spieldauer;
    private int jahr;

    private static final String ARTIKEL_ART = "Medien";

    /**
     * Creates a new Video with the given information.
     *
     * @param artikelNr the article number of the Video.
     * @param art the type of the Video.
     * @param bestand the stock of the Video.
     * @param preis the price of the Video.
     * @param title the title of the Video.
     * @param spieldauer the playtime of the Video.
     * @param jahr the year of the Video.
     */
    public Video(int artikelNr, int bestand, double preis, String title, int spieldauer, int jahr) {
        super(artikelNr, ARTIKEL_ART, bestand, preis);
        setTitle(title);
        setSpieldauer(spieldauer);
        setJahr(jahr);
    }

    /**
     * Sets the title of this Video.
     * @param title the title to set.
     */
    public final void setTitle(String title) {
        TestUtils.checkIfEmpty(title);
        this.title = title;
    }

    /**
     * Sets the playtime of this Video.
     * @param spieldauer the playtime to set.
     */
    public final void setSpieldauer(int spieldauer) {
        TestUtils.checkGreaterThan(spieldauer, 0, "spieldauer");
        this.spieldauer = spieldauer;
    }

    /**
     * Sets the year of this Video.
     * @param jahr the year to set.
     */
    public final void setJahr(int jahr) {
        TestUtils.checkJahr(jahr);
        this.jahr = jahr;
    }

    /**
     * Sets the year of this Video.
     * @param jahr the year to set.
     */
    public final String getTitle() {
        return title;
    }

    /**
     * Returns the playtime of this Video.
     * @return the playtime.
     */
    public final int getSpieldauer() {
        return spieldauer;
    }

    /**
     * Returns the year of this Video.
     * @return the year.
     */
    public final int getJahr() {
        return jahr;
    }

    /**
     * Returns the description of this Video.
     * @return the title.
     */
    @Override
    public final String getBeschreibung() {
        return title;
    }

    /**
     * Returns the string representation of this Video.
     * @return the string representation of this Video.
     */
    @Override
    public final String toString() {
        return super.toString() + " Video title: " + title + ", spieldauer: " + spieldauer + ", jahr: " + jahr;
    }

    /**
     * Compares this object to the specified object to check for equality.
     * @param object the object to compare to.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()){ 
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        
        Video video = (Video) object;
        
        return Objects.equals(title, video.title) &&
            spieldauer == video.spieldauer &&
            jahr == video.jahr;
    }


    /**
     * Generates a hash code for this object.
     * @return the generated hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, spieldauer, jahr);
    }
}
