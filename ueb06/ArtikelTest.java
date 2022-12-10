import org.junit.Test;
import static org.junit.Assert.*;

public class ArtikelTest {

    @Test
    public void testConstructor() {
        // Test the main constructor
        Artikel a1 = new Artikel(1000, "Test Artikel 1", 10, 5);
        assertEquals(1000, a1.getArtikelNr());
        assertEquals("Test Artikel 1", a1.getArt());
        assertEquals(10, a1.getBestand());
        assertEquals(5, a1.getPreis(), 0.001);

        // Test the second constructor
        Artikel a2 = new Artikel(2000, "Test Artikel 2", 3.0);
        assertEquals(2000, a2.getArtikelNr());
        assertEquals("Test Artikel 2", a2.getArt());
        assertEquals(0, a2.getBestand());
        assertEquals(3.0, a2.getPreis(), 0.001);
    }

    @Test
    public void testBucheZugang() {
        Artikel a1 = new Artikel(1000, "Test Artikel 1", 10, 5.0);
        assertEquals(10, a1.getBestand());

        a1.bucheZugang(5);
        assertEquals(15, a1.getBestand(), 0.001);

        // Test that the method throws an exception for invalid input
        assertThrows(IllegalArgumentException.class, () -> a1.bucheZugang(-1));
    }

    @Test
    public void testBucheAbgang() {
        Artikel a1 = new Artikel(1000, "Test Artikel 1", 10, 5.0);
        assertEquals(10, a1.getBestand());

        a1.bucheAbgang(5);
        assertEquals(5, a1.getBestand(), 0.001);

        // Test that the method throws an exception for invalid input
        assertThrows(IllegalArgumentException.class, () -> a1.bucheAbgang(-1));
    }

    @Test
    public void testSetters() {
        Artikel a1 = new Artikel(1000, "Test Artikel 1", 10, 5.0);

        // Test the setArtikelNr() method
        a1.setArtikelNr(2000);
        assertEquals(2000, a1.getArtikelNr());

        // Test that the method throws an exception for invalid input
        assertThrows(IllegalArgumentException.class, () -> a1.setArtikelNr(-1));

    }
}
       

