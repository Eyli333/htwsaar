/** 
 * This class is used to extract links from a given input and display their text and URL.
 * It also counts the number of links found and the number of lines in the input.
 * 
 * @author Victor Plage and David Glaser
 * @version 1.1.0
 * @since 2013-13-13
 */

public class PatientenWarteschlange {
    private Patient[] warteschlange; 

    /**
     * Constructor for objects of class PatientenWarteschlange
     * @param groesse
     */
    public PatientenWarteschlange(int groesse) {
        TestUtils.checkAboveOne(groesse);

        warteschlange = new Patient[groesse];
    }

    public void neuerPatient(int number, String vorname, String nachname) {

        Patient patient = new Patient(number, vorname, nachname);

        for (int i = 0; i < warteschlange.length; i++) {
            if (warteschlange[i] == null) {
                warteschlange[i] = patient;
                break;
            }
        }
    }

    public Patient entfernePatient(int number) {

        for (int i = 0; i < warteschlange.length; i++) {
            if (warteschlange[i] != null && warteschlange[i].getNumber() == number) {
                Patient patientValue = warteschlange[i];
                warteschlange[i] = null;

                sort();

                return patientValue;
            }
        }
        
        return null;
    }
    
    public Patient derNaechsteBitte() {

        Patient patientValue = warteschlange[0];
        warteschlange[0] = null;

        sort();

        return patientValue;
    }

    @Override
    public String toString() {
        String buffer = new String();
        buffer = "Warteschlange\n" + "Patientenummer Vorname Nachname\n";
        for (int i = 0; i < warteschlange.length; i++) {
            if (warteschlange[i] != null ) {
                buffer +=  warteschlange[i].toString() + "\n";
            }
        }
        return buffer;
    }

    public int getArraySize() {
        return warteschlange.length ;
    }

    public void sort() {
        for (int i = 0; i < warteschlange.length; i++) {
            if (warteschlange[i] == null) {
                for (int j = i; j < warteschlange.length; j++) {
                    if (warteschlange[j] != null) {
                        warteschlange[i] = warteschlange[j];
                        warteschlange[j] = null;
                        break;
                    }
                }
            }
        }
    }
}
