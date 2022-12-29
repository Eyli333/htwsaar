class ArrayFunctions {
    public static Mittelwert berechneMittelwert(double[] messverte) {
        double sum = 0;
        for (int i = 0; i < messverte.length; i++) {
            sum += messverte[i];
        }

        double mittelwert = sum / messverte.length;

        double weitestenwert = messverte[0];
        double naehstewert = messverte[0];

        for (int i = 1; i < messverte.length; i++) {
            if (Math.abs(mittelwert - messverte[i]) < Math.abs(mittelwert - naehstewert)) {
                naehstewert = messverte[i];
            }
            if (Math.abs(mittelwert - messverte[i]) > Math.abs(mittelwert - weitestenwert)) {
                weitestenwert = messverte[i];
            }
        }

        return new Mittelwert(mittelwert, naehstewert, weitestenwert);
    }

    public static int stringsAuswerten(String[] strings) {
        int count = 0;

        for (int i = 0; i < strings.length; i++) {
            boolean isValid = true;

            for (int j = 0; j < strings[i].length(); j++) {
                char c = strings[i].charAt(j);

                if (!Character.isLetter(c)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                count++;
            }
        }

        return count;
    }
}

class Mittelwert {
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

    public String toString() {
        return "Mittelwert: " + mittelwert + " Naehstewert: " + naehstewert + " Weitestenwert: " + weitestenwert;
    }

}
