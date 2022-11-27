public class TestUtils {

    private static final int zero = 0;
    
    public static void checkIsNonNegativ(long zahl){
        if (zahl <= zero){
            throw new IllegalArgumentException("Die Zahl kann nicht negativ sein.");
        }
    }
}
