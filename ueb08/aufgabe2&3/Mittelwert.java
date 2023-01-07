public class Mittelwert {
    private double mittelwert;
    private double naehstewert;
    private double weitestenwert;

    /**
     * Constructs a new Mittelwert with the given values.
     * @param mittelwert the average value
     * @param naehstewert the nearest value
     * @param weitestenwert the farthest value
     */
    public Mittelwert(double mittelwert, double naehstewert, double weitestenwert) {
        this.mittelwert = mittelwert;
        this.naehstewert = naehstewert;
        this.weitestenwert = weitestenwert;
    }

    /**
     * Returns the average value of this Mittelwert.
     * @return the average value
     */
    public double getMittelwert() {
        return mittelwert;
    }

    /**
     * Returns the nearest value of this Mittelwert.
     * @return the nearest value
     */
    public double getNaehstewert() {
        return naehstewert;
    }

    /**
     * Returns the farthest value of this Mittelwert.
     * @return the farthest value
     */
    public double getWeitestenwert() {
        return weitestenwert;
    }

    /**
     * Returns a string representation of this Mittelwert.
     * @return a string in the format "Mittelwert: {mittelwert}, Naehstewert: {naehstewert}, Weitestenwert: {weitestenwert}"
     */
    @Override
    public String toString() {
        return "Mittelwert: " + mittelwert + ", Naehstewert: " + naehstewert + ", Weitestenwert: " + weitestenwert;
    }
}
