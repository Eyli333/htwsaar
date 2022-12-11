import org.junit.Assert;
import org.junit.Test;

public class LagerTest {

    /**
     * Test the Lager constructor with a valid size
     */
    @Test
    public void testConstructorWithValidSize() {
        int size = 5;
        Lager lager = new Lager(size);

        // Check that the lager array has the expected size
        Assert.assertEquals(size, lager.getLagerGroesse());
    }

    /**
     * Test the Lager constructor without an argument
     * The default size should be 10
     */
    @Test
    public void testConstructorWithoutArgument() {
        Lager lager = new Lager();

        // Check that the lager array has the default size
        Assert.assertEquals(10, lager.getLagerGroesse());
    }

    /**
     * Test the lager constructor with an invalid size
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidSize() {
        int size = -1;
        Lager lager = new Lager(size);

    }

    /**
     * Test the legeArtikelAn method with a valid article
     */
    @Test
    public void testLegeArtikelAnWithValidArticle() {
        Lager lager = new Lager();

        Artikel artikel = new Artikel(1000, "Test article", 0, 0);

        lager.legeAnArtikel(artikel);

        Assert.assertTrue(lager.sucheArtikel(artikel.getArtikelNr()));

    }

    // Test the legeArtikelAn method with an article that already exists in the lager
    @Test(expected = IllegalArgumentException.class)
    public void testLegeArtikelAnWithExistingArticle() {
        Lager lager = new Lager();

        Artikel artikel1 = new Artikel(1000, "Test article", 0, 0);
        Artikel artikel2 = new Artikel(1000, "Test article", 0, 0);

        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
    }

    // Test the legeArtikelAn method with a full lager
    @Test(expected = IllegalArgumentException.class)
    public void testLegeArtikelAnWithFullLager() {
        int size = 1;
        Lager lager = new Lager(size);

        Artikel artikel1 = new Artikel(1000, "Test article", 0, 0);
        Artikel artikel2 = new Artikel(2000, "Test article", 0, 0);

        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
    }

    // Test the entferneArtikel method with a valid article number
    @Test
    public void testEntferneArtikelWithValidArticleNumber() {
        Lager lager = new Lager();

        Artikel artikel = new Artikel(1000, "Test article", 0, 0);
        Artikel artikel2 = new Artikel(2000, "Test article", 0, 0);

        lager.legeAnArtikel(artikel);
        lager.legeAnArtikel(artikel2);
        lager.entferneArtikel(artikel.getArtikelNr());

	Assert.assertFalse(lager.sucheArtikel(artikel.getArtikelNr()));
    }

    // Test the entferneArtikel method with an invalid article number
    @Test(expected = IllegalArgumentException.class)
    public void testEntferneArtikelWithInvalidArticleNumber() {
        Lager lager = new Lager();

        Artikel artikel = new Artikel(1000, "Test article", 0, 0);
        lager.legeAnArtikel(artikel);

        lager.entferneArtikel(2000);
    }

    @Test
    public void testBucheZugang() {
        Lager lager = new Lager(1);
        Artikel artikel = new Artikel(1000, "TestArtikel", 1);
        lager.legeAnArtikel(artikel);

        lager.bucheZugang(1000, 10);
    }

    // Test the bucheZugang method with a valid article number and quantity
    @Test(expected = IllegalArgumentException.class)
    public void testBucheZugangWithValidArticleNumberAndQuantity() {
        Lager lager = new Lager();

        Artikel artikel = new Artikel(1000, "Test article", 0, 0);
        lager.legeAnArtikel(artikel);

        lager.bucheZugang(2000, 10);
    }

    // Test the aenderePreisEinesArtikels method with a valid article number and price increase
    @Test
    public void testAenderePreisEinesArtikelsWithValidArticleNumberAndPriceIncrease() {
        Lager lager = new Lager();

        Artikel artikel = new Artikel(1000, "Test article", 0, 10);
        lager.legeAnArtikel(artikel);


        lager.aenderePreisEinesArtikels(1000, 10);

    }

    // Test the aenderePreisEinesArtikels method with a valid article number and price decrease
    @Test
    public void testAenderePreisEinesArtikelsWithValidArticleNumberAndPriceDecrease() {
        Lager lager = new Lager();

        Artikel artikel = new Artikel(1000, "Test article", 0, 10);
        lager.legeAnArtikel(artikel);

        lager.aenderePreisEinesArtikels(1000, -10);

    }

    // Test the aenderePreisEinesArtikels method with an invalid article
    // number
    @Test(expected = IllegalArgumentException.class)
    public void testAenderePreisEinesArtikelsWithInvalidArticleNumber() {
        Lager lager = new Lager();
        Artikel artikel = new Artikel(1000, "Test article", 0, 10);
        lager.legeAnArtikel(artikel);

        lager.aenderePreisEinesArtikels(2000, 10.0);
    }

    // Test the aenderePreisEinesArtikels method with a negative price change
    @Test(expected = IllegalArgumentException.class)
    public void testAenderePreisEinesArtikelsWithNegativePriceChange() {
        Lager lager = new Lager();

        Artikel artikel = new Artikel(1000, "Test article", 0, 1);
        lager.legeAnArtikel(artikel);

        lager.aenderePreisEinesArtikels(1000, -1000);
    }
}
