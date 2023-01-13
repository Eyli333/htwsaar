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

public final class CD extends Artikel {
    private String interpret;
    private String titel;
    private int anzahlTitel;

    private static final String ARTIKEL_ART = "Medien";

    public CD(int artikelNr, int bestand, double preis, String interpret, String title, int anzahlTitel) {
        super(artikelNr, ARTIKEL_ART, bestand, preis);
        setInterpret(interpret);
        setTitel(title);
        setAnzahlTitel(anzahlTitel);
    }

    public final void setInterpret(String interpret) {
        TestUtils.checkIfEmpty(interpret);
        this.interpret = interpret;
    }

    public final void setTitel(String titel) {
        TestUtils.checkIfEmpty(titel);
        this.titel = titel;
    }

    public final void setAnzahlTitel(int anzahlTitel) {
        TestUtils.checkGreaterThan(anzahlTitel, 0, "anzahlTitel");
        this.anzahlTitel = anzahlTitel;
    }

    public final String getInterpret() {
        return interpret;
    }

    public final String getTitel() {
        return titel;
    }

    public final int getAnzahlTitel() {
        return anzahlTitel;
    }

    @Override
    public final String getBeschreibung() {
        return interpret + ": " + titel;
    }

    @Override
    public final String toString(){
        return super.toString() + " CD interpret: " + interpret + ", titel: " + titel + ", anzahlTitel: " + anzahlTitel;
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

        CD cd = (CD) object;

        return Objects.equals(interpret, cd.interpret) &&
            Objects.equals(titel, cd.titel) &&
            anzahlTitel == cd.anzahlTitel;
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), interpret, titel, anzahlTitel);
    }

}
