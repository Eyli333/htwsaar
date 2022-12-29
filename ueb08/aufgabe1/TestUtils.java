public class TestUtils {

    /**
     * This method is used to check if the value is less than 1
     * @param value this is the value that will be checked 
     * @throws IllegalArgumentException if the value is less than 1
     */
    public static void checkAboveOne(int value){
        if (value < 1){
            throw new IllegalArgumentException("Die Zahl muss groesser als 1 sein. Sie haben " + value + " eingegeben.");
        }
    }   
}

