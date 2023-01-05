import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PatientTest {

    @Test 
    public void test_Patient_attribut_Ohne_Fehler() {
        Patient patient = new Patient(9999, "asdf", "sdfg");

        assertEquals(patient.getNumber(), 9999);
        assertEquals(patient.getVorname(), "asdf");
        assertEquals(patient.getNachname(), "sdfg");
    }

    @Test 
    public void test_Patient_attribut_Ohne_Fehler_2() {
        Patient patient = new Patient(1000, "f", "2");

        assertEquals(patient.getNumber(), 1000);
        assertEquals(patient.getVorname(), "f");
        assertEquals(patient.getNachname(), "2");
    }

    @Test
    public void test_Patient_Number_10000_Mit_Fehler() {
        assertThrows(IllegalArgumentException.class, () -> new Patient(10000, "asdf", "sdfg"));
    }

    @Test
    public void test_Patient_Number_999_Mit_Fehler() {
        assertThrows(IllegalArgumentException.class, () -> new Patient(999, "asdf", "sdfg"));
    }

    @Test
    public void test_Patient_Vorname_Mit_Fehler() {
        assertThrows(IllegalArgumentException.class, () -> new Patient(1000, "", "sdfg"));
    }

    @Test
    public void test_Patient_Nachname_Mit_Fehler() {
        assertThrows(IllegalArgumentException.class, () -> new Patient(1000, "asdf", ""));
    }
    
    @Test
    public void test_ToString() {
        Patient patient = new Patient(9999, "asdf", "sdfg");
        assertEquals(patient.toString(), " 9999 asdf sdfg");
    }
}
