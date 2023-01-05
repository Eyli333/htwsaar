public class Mittelwert {
    private double mittelwert;
    private double naehstewert;
    private double weitestenwert;

    public Mittelwert(double mittelwert, double naehstewert, double weitestenwert) {
        this.mittelwert = mittelwert;
        this.naehstewert = naehstewert;
        this.weitestenwert = weitestenwert;
    }

    public double getMittelwert() {
        return mittelwert;
    }

    public double getNaehstewert() {
        return naehstewert;
    }

    public double getWeitestenwert() {
        return weitestenwert;
    }

    @Override
    public String toString() {
        return "Mittelwert: " + mittelwert + ", Naehstewert: " + naehstewert + ", Weitestenwert: " + weitestenwert;
    }

}
