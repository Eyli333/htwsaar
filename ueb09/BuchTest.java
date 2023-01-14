import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;

public class BuchTest {

    /**
     * Constructor test for Buch class without error.
     * Creates a new Buch object and checks if the values are set correctly.
     */
    @Test
    public void test_Constructor_Ohne_Fehler() {
        Buch buch1 = new Buch(1111, 1, 2, "titel", "author", "verlag");

        assertEquals(1111, buch1.getArtikelNr());
        assertEquals(1, buch1.getBestand());
        assertEquals(2, buch1.getPreis(), 0.001);
        assertEquals("titel", buch1.getTitel());
        assertEquals("author", buch1.getAuthor());
        assertEquals("verlag", buch1.getVerlag());
    }

    /**
     * Test for setTitel without error.
     * Sets the title of the Buch object and checks if the value is set correctly.
     */
    @Test
    public void test_SetTitel_Ohne_Fehler() {
        Buch buch1 = new Buch(1111, 1, 2, "titel", "author", "verlag");

        buch1.setTitel("test2");
        assertEquals("test2", buch1.getTitel());

        buch1.setTitel("3");
        assertEquals("3", buch1.getTitel());
    }

    /**
     * Test for setTitel with error.
     * Tries to set an empty title for the Buch object and checks if the IllegalArgumentException is thrown.
     */
    @Test
    public void test_SetTitel_Mit_Fehler() {
        Buch buch1 = new Buch(1111, 1, 2, "titel", "author", "verlag");

        assertThrows(IllegalArgumentException.class, () -> {
            buch1.setTitel("");
        });
    }

    /**
     * Test for setAuthor without error.
     * Sets the author of the Buch object and checks if the value is set correctly.
     */
    @Test
    public void test_SetAuthor_Ohne_Fehler() {
        Buch buch1 = new Buch(1111, 1, 2, "titel", "author", "verlag");

        buch1.setAuthor("author2");
        assertEquals("author2", buch1.getAuthor());

        buch1.setAuthor("4");
        assertEquals("4", buch1.getAuthor());
    }

    /**
     * Test for setAuthor with error.
     * Tries to set an empty author for the Buch object and checks if the IllegalArgumentException is thrown.
     */
    @Test
    public void test_SetAuthor_Mit_Fehler() {
        Buch buch1 = new Buch(1111, 1, 2, "titel", "author", "verlag");

        assertThrows(IllegalArgumentException.class, () -> {
            buch1.setAuthor("");
        });
    }

    /**
     * Test for setVerlag without error.
     * Sets the verlag of the Buch object and checks if the value is set correctly.
     */
    @Test
    public void test_SetVerlag_Ohne_Fehler() {
        Buch buch1 = new Buch(1111, 1, 2, "titel", "author", "verlag");

        buch1.setVerlag("verlag2");
        assertEquals("verlag2", buch1.getVerlag());

        buch1.setVerlag("5");
        assertEquals("5", buch1.getVerlag());
    }

    /**
     * Test for setVerlag with error.
     * Tries to set an empty verlag for the Buch object and checks if the IllegalArgumentException is thrown.
     */
    @Test
    public void test_SetVerlag_Mit_Fehler() {
        Buch buch1 = new Buch(1111, 1, 2, "titel", "author", "verlag");

        assertThrows(IllegalArgumentException.class, () -> {
            buch1.setVerlag("");
        });
    }

    /**
     * Test for getBeschreibung.
     * Gets the description of the Buch object and checks if the value is correct.
     */
    @Test
    public void test_getBeschreibung() {
        Buch buch1 = new Buch(1111, 1, 2, "titel", "author", "verlag");

        assertEquals("author: titel", buch1.getBeschreibung());
    }

    /**
     * Test for toString.
     * Gets the string representation of the Buch object and checks if the value is correct.
     */
    @Test
    public void test_toString() {
        Buch buch1 = new Buch(1111, 1, 2, "titel", "author", "verlag");
        assertEquals("\nArtikel: 1111, Art: Medien, Bestand: 1, Preis: 2.0, Buch titel: titel, author: author, verlag: verlag", buch1.toString());

        Buch buch2 = new Buch(2222, 2, 3, "titel1", "author1", "verlag1");
        assertEquals("\nArtikel: 2222, Art: Medien, Bestand: 2, Preis: 3.0, Buch titel: titel1, author: author1, verlag: verlag1", buch2.toString());
    }

    /**
     * Test for equals.
     * Compares two Buch objects and checks if they are equal.
     */
    @Test
    public void test_equals() {

        Buch buch1 = new Buch(1111, 1, 2, "titel", "author", "verlag");
        Buch buch2 = new Buch(1111, 1, 2, "titel", "author", "verlag");
        Buch buch3 = new Buch(1111, 1, 2, "titel1", "author", "verlag");
        Buch buch4 = new Buch(1111, 1, 2, "titel", "author1", "verlag");
        Buch buch5 = new Buch(1111, 1, 2, "titel", "author", "verlag1");
        Buch buch6 = new Buch(1111, 2, 2, "titel", "author", "verlag");
        Buch buch7 = new Buch(1234, 1, 2, "titel", "author", "verlag");
        Buch buch8 = new Buch(1111, 1, 3, "titel", "author", "verlag");

        // Test for equality
        assertEquals(buch1, buch2);

        // Test for inequality
        assertNotEquals(buch1, buch3);
        assertNotEquals(buch1, buch4);
        assertNotEquals(buch1, buch5);
        assertNotEquals(buch1, buch6);
        assertNotEquals(buch1, buch7);
        assertNotEquals(buch1, buch8);
    }

}
