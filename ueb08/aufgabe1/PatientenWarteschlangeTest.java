import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PatientenWarteschlangeTest {

    @Test
    public void test_Constructor_Patient_Mit_Fehler() {

        PatientenWarteschlange pw = new PatientenWarteschlange(10);
        assertThrows(IllegalArgumentException.class, () -> pw.neuerPatient(0000, "hans", "schmidt"));
    }
    
    @Test
    public void test_Constructor_Ohne_Fehler_1() {
        PatientenWarteschlange pw = new PatientenWarteschlange(10);
        assertEquals(10, pw.getArraySize());
    }

    @Test
    public void test_Constructor_Ohne_Fehler_2() {
        PatientenWarteschlange pw = new PatientenWarteschlange(1);
        assertEquals(1, pw.getArraySize());
    }

    @Test
    public void test_Constructor_Mit_Fehler_1() {
        assertThrows(IllegalArgumentException.class, () -> new PatientenWarteschlange(0));
    }

    @Test
    public void test_Constructor_Mit_Fehler_2() {
        assertThrows(IllegalArgumentException.class, () -> new PatientenWarteschlange(-1));
    }

}
