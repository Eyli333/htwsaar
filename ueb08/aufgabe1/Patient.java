class Patient {
    int number;
    String vorname;
    String nachname;

    private final int MIN_NUMBER = 1000;
    private final int MAX_NUMBER = 9999;

    public int getNumber() {
        return number;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String toString() {
        return "  " + number + "          " + vorname + " " + nachname;
    }

    public void checkNumber() {
        if (this.number < MIN_NUMBER || this.number > MAX_NUMBER) {
            throw new IllegalArgumentException("Die Artikelnummer muss zwischen " + MIN_NUMBER + " und " + MAX_NUMBER + " liegen.");
        }
    }
}
