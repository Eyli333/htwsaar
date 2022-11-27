public class TestUtils {

    private static final int zero = 0;
    private static final int twentysix = 26;
    private static final long isbnNumber = 1000000000L;
    
    /**
	 * This method is used to check if the value is negativ 
	 * @param zahl this is the value that will be checked 
	 */
    public static void checkIsNonNegativ(long zahl){
        if (zahl < zero){
            throw new IllegalArgumentException("Die Zahl kann nicht negativ sein.");
        }
    }   

	/**
    * This method is used to check if the value giving is above 26
    * @param zahl the value with wich we will make the calculation with 
    */
    public static void checkAboveTwentsix(long zahl) {
        if (zahl > twentysix) {
                throw new IllegalArgumentException("Die Zahl kann nicht groesser als 26 sein.");
        }
    }


	/**
     	* This method is used to check if the value giving for isbn is isbn-10
     	* @param isbn the value with wich we will make the calculation with
     	*/
	public static void checkIsbnInput(long isbn) {
		if (isbnNumber > isbn || isbn > isbnNumber) {
		    	throw new IllegalArgumentException("Der ISBN muss 9 Ziffern lang sein");
		}
	}

    /**
    * This method is used to check if the value giving is above one
    * @param zahl the value with wich we will make the calculation 
    */
	public static void checkEqualZero(long zahl) {
		if (zahl == zero) {
		    	throw new IllegalArgumentException("Die Zahl kann nicht 0 sein.");
		}
	}

    /**
    * This method is used to check if the value from both numbers is equal to zero
    * @param zahl1 the first value with wich we will make the calculation
    * @param zahl2 the second value with wich we will make the calculation  
    */
    public static void checkBothNumbersZero(int zahl1, int zahl2) {
        if (zahl1 == 0 && zahl2 == 0) {
            throw new IllegalArgumentException("Eine der Zahlen kann nicht 0 sein.");
        }
    }
}
