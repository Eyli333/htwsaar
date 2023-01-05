public class TestUtils {
    private static final int MIN_NUMBER = 1000;
    private static final int MAX_NUMBER = 9999;

     public static void checkNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("Die Artikelnummer muss zwischen " + MIN_NUMBER + " und " + MAX_NUMBER + " liegen.");
        }
    }

    public static void checkAboveOne(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("Die Anzahl muss mindestens 1 sein.");
        }
    }

    public static void checkNotEmpty(String text) {
        if (text == null || text.strip().isEmpty()) {
            throw new IllegalArgumentException("Der Text darf nicht leer sein.");
        }
    }
}

