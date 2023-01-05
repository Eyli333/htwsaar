import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayFunctionsTest {
    @Test
    void test_Strings_Auswerten_expecte_2() {
        String[] strings1 = {"HTW", "saarland", "Saarbruecken"};
        int result1 = ArrayFunctions.stringsAuswerten(strings1);
        assertEquals(3, result1);
    }

    @Test
    void test_Strings_Auswerten_expecte_3() {
        String[] strings2 = {"HTW. saarland", "Saarbruecken", "MERZIG", "UNIversitaet"};
        int result2 = ArrayFunctions.stringsAuswerten(strings2);
        assertEquals(3, result2);
    } 

    @Test
    void test_Strings_Auswerten_expecte_2_() {
        String[] strings3 = {"123", "abc", "def"};
        int result3 = ArrayFunctions.stringsAuswerten(strings3);
        assertEquals(2, result3);
    }

    @Test
    void test_Strings_Auswerten_expecte_0() {
        String[] strings4 = {};
        int result4 = ArrayFunctions.stringsAuswerten(strings4);
        assertEquals(0, result4);
    }

    @Test
    void test_Strings_Auswerten_expected_0() {
        String[] strings5 = {"12fa"};
        int result5 = ArrayFunctions.stringsAuswerten(strings5);
        assertEquals(0, result5);
    }

    @Test
    void test_Getters_Mittelwert() {
        Mittelwert mittelwert = new Mittelwert(10.5, 9.5, 11.5);
        assertEquals(10.5, mittelwert.getMittelwert(), 0.0001);
        assertEquals(9.5, mittelwert.getNaehstewert(), 0.0001);
        assertEquals(11.5, mittelwert.getWeitestenwert(), 0.0001);
    }

    @Test
    void test_Berechne_Mittelwert_1() {
        double[] values1 = {1.0, 2.0, 3.0, 4.0};
        Mittelwert result1 = ArrayFunctions.berechneMittelwert(values1);
        assertEquals(2.5, result1.getMittelwert(), 0.0001);
        assertEquals(2.0, result1.getNaehstewert(), 0.0001);
        assertEquals(1.0, result1.getWeitestenwert(), 0.0001);
    }

    @Test
    void test_Berechne_Mittelwert_2() {
        double[] values2 = {1.5, 2.5, 3.5, 4.5};
        Mittelwert result2 = ArrayFunctions.berechneMittelwert(values2);
        assertEquals(3.0, result2.getMittelwert(), 0.0001);
        assertEquals(2.5, result2.getNaehstewert(), 0.0001);
        assertEquals(1.5, result2.getWeitestenwert(), 0.0001);
    }

    @Test
    void test_BerechneMittelwert_3() {
        double[] values3 = {1.0, 1.0, 1.0, 1.0};
        Mittelwert result3 = ArrayFunctions.berechneMittelwert(values3);
        assertEquals(1.0, result3.getMittelwert(), 0.0001);
        assertEquals(1.0, result3.getNaehstewert(), 0.0001);
        assertEquals(1.0, result3.getWeitestenwert(), 0.0001);
    }

    @Test
    void test_BerechneMittelwert_4() {
        double[] values4 = {1.0};
        Mittelwert result4 = ArrayFunctions.berechneMittelwert(values4);
        assertEquals(1.0, result4.getMittelwert(), 0.0001);
        assertEquals(1.0, result4.getNaehstewert(), 0.0001);
        assertEquals(1.0, result4.getWeitestenwert(), 0.0001);
    }

}

