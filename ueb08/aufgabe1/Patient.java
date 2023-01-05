class Patient {
    private int number;
    private String vorname;
    private String nachname;


    public Patient(int number, String vorname, String nachname) {
        TestUtils.checkNumber(number);
        TestUtils.checkNotEmpty(vorname);
        TestUtils.checkNotEmpty(nachname);

        this.number = number;
        this.vorname = vorname;
        this.nachname = nachname;
    }
    
    public int getNumber() {
        return number;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }
    
    @Override
    public String toString() {
        return " " + number + " " + vorname + " " + nachname;
    }
}
