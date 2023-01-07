class Patient {
    private int number;
    private String vorname;
    private String nachname;

    /**
     * Constructor for the Patient class.
     * @param number The patient's number
     * @param vorname The patient's first name
     * @param nachname The patient's last name
     * @throws IllegalArgumentException If the number is outside of the range MIN_NUMBER and MAX_NUMBER (defined in TestUtils)
     * @throws IllegalArgumentExceptionIf vorname or nachname is empty or null
    */
    public Patient(int number, String vorname, String nachname) {
        TestUtils.checkNumber(number);
        TestUtils.checkNotEmpty(vorname);
        TestUtils.checkNotEmpty(nachname);

        this.number = number;
        this.vorname = vorname;
        this.nachname = nachname;
    }
    
    /**
     * Getter for the patient's number.
     * @return The patient's number
    */
    public int getNumber() {
        return number;
    }

    /**
     * Getter for the patient's vorname.
     * @return The patient's vorname
    */
    public String getVorname() {
        return vorname;
    }

    /**
     * Getter for the patient's nachname.
     * @return The patient's nachname 
    */
    public String getNachname() {
        return nachname;
    }
    
    /**
     * Returns a string representation of the patient.
     * @return A string in the format " number vorname nachname"
    */
    @Override
    public String toString() {
        return " " + number + " " + vorname + " " + nachname;
    }
}
