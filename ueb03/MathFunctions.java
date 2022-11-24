/**
 * <h1>Create Objects</h1>
 * Allows the user to use MathFunctions
 * to make some calculation
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.0
 * @since 2022-11-16
 */

public class MathFunctions{

	private static final double DELTA_NUL = 0.000000001;
	private static final int zero = 0;
	private static final int one = 1;
	private static final int two = 2;
	private static final int nine = 9;
	private static final int ten = 10;
	private static final int eleven = 11;
	private static final long isbnNumber = 1000000000L;

	/**
	 * Calculate the sum of the divisor for a number
	 * and return it as a long
	 * @param take the number as a long
	 * @return  the sum of the divisor
	 */
	public static long berechneTeilersumme (long zahl) {
		checkTeilersummeZahl(zahl);

		long maxD = (int)Math.sqrt(zahl);
    	long sum = zero;
		for(int i = two; i <= maxD; i++) {
			if(zahl % i == 0) {
				if(i == zahl / i){
					sum += i;
				} else {
					sum += i + zahl / i;
				}
			}
		}
		return sum + one;
	}

	/**
	 * Check if the isbn number giving is a valid one 
	 * It just check for ISBN-10
	 * @param  take the isbn number as a long
	 * @return X if the cheked digit is 10 else the value of the digit 
	 */
	public static String berechneChecksummeIsbn(long isbn) {
		checkIsbnInput(isbn);
		
		long result = zero;
		long isbnMod = isbn;
		for (int i = nine; i > zero; i--) {
			long j = isbnMod % ten; // convert to int j
			isbnMod = isbnMod / ten;
			result += j * i;

		}
		result = result % eleven;
		if (result == ten) {
			return "X";
		}
		return Long.toString(result);
	}

	/**
     	* This method is used to Determine the zeros of a quadratic  
	* quadratic equation and return them as a formatted string
     	* @param p is the first value as a double
     	* @param q is the second value as a double
	* @return x1, x1 and x2 or nothing
     	*/
	public static String berechneNullstellen (double p, double q) {
		double d = Math.pow(p/2, 2) - q;
		double x = -p/2 + Math.sqrt(d);
		if (d >= -DELTA_NUL && d < DELTA_NUL) {
			double x1 = x;
 
			return "Doppelte Nullstelle: " + x1;

		} else if (d < 0.0) {
			
			return "Komplexe Nullstellen";
			
		} else {
			double x1 = x;
			double x2 = -p/2 - Math.sqrt(d);
		
			return "Zwei Nullstellen: " + x1 + "|" + x2;
		}
	}

	/**
     	* This method is used to check if the value giving for berechneTeilersumme
	* valid is or not
     	* @param zahl the value with wich we will make the calculation with
     	*/
	public static void checkTeilersummeZahl(long zahl) {
		if (zahl < one) {
		    	throw new IllegalArgumentException("Die Zahl kann nicht negativ oder 0 sein.");
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
}
