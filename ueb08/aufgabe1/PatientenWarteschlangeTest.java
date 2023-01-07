import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PatientenWarteschlangeTest {

    /**
     * Tests that an IllegalArgumentException is thrown when an invalid patient number is passed to the neuerPatient method.
     */
    @Test
    public void test_Constructor_Patient_Mit_Fehler() {

        PatientenWarteschlange pw = new PatientenWarteschlange(10);
        assertThrows(IllegalArgumentException.class, () -> pw.neuerPatient(0000, "hans", "schmidt"));
    }

    /**
     * Tests that the size of the queue is correctly set when a valid size is passed to the constructor.
     */
    @Test
    public void test_Constructor_Ohne_Fehler_1() {
        PatientenWarteschlange pw = new PatientenWarteschlange(10);
        assertEquals(10, pw.getArraySize());
    }

    /**
     * Tests that the size of the queue is correctly set when a valid size is passed to the constructor.
     */
    @Test
    public void test_Constructor_Ohne_Fehler_2() {
        PatientenWarteschlange pw = new PatientenWarteschlange(1);
        assertEquals(1, pw.getArraySize());
    }

    /**
     * Tests that an IllegalArgumentException is thrown when an invalid size is passed to the constructor.
     */
    @Test
    public void test_Constructor_Mit_Fehler_1() {
        assertThrows(IllegalArgumentException.class, () -> new PatientenWarteschlange(0));
    }

    /**
     * Tests that an IllegalArgumentException is thrown when an invalid size is passed to the constructor.
     */
    @Test
    public void test_Constructor_Mit_Fehler_2() {
        assertThrows(IllegalArgumentException.class, () -> new PatientenWarteschlange(-1));
    }

}
