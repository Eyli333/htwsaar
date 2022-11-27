public class TestUtils {

    private static final int zero = 0;
    private static final int twentysix = 26;
    
    public static void checkIsNonNegativ(long zahl){
        if (zahl <= zero){
            throw new IllegalArgumentException("Die Zahl kann nicht negativ sein.");
        }
    }   
    
    public static void checkAboveTwentsix(long zahl){
        if (zahl >= twentysix){
            throw new IllegalArgumentException("Die Zahl kann nicht groesser als 26 sein.");
        }
    }
}
