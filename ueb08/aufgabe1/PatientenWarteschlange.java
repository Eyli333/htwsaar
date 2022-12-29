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
        // check if array was build
        // and +

        Patient patient = new Patient();
        patient.number = number;
        patient.checkNumber();
        patient.vorname = vorname;
        patient.nachname = nachname;

        for (int i = 0; i < warteschlange.length; i++) {
            if (warteschlange[i] == null) {
                warteschlange[i] = patient;
                break;
            }
        }
    }

    public String entfernePatient(int number) {
        // make some test before

        for (int i = 0; i < warteschlange.length; i++) {
            if (warteschlange[i] != null && warteschlange[i].number == number) {
                Patient patientValue = warteschlange[i];
                warteschlange[i] = null;

                sort();

                return "Patient geloescht : " +  patientValue;
            }
        }
        
        return "Patient nicht gefunden";
    }
    
    public String derNaechsteBitte() {
        // check if not null 
        // and more

        Patient patientValue = warteschlange[0];
        warteschlange[0] = null;

        sort();

        return "Naechster Patient: " +  patientValue;
    }

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

    public  void sort() {
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
