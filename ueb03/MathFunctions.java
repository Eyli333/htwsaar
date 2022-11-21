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


	/**
	 * Calculate the sum of the divisor for a number
	 * and return it as a long
	 * @param take the number as a long
	 * @return  the sum of the divisor
	 */
	public static long berechneTeilersumme (long zahl) {
		checkTeilersummeZahl(zahl);

		long sum = 0;
		for (long i = 1; i<zahl+1; i++) {
			if (zahl % i == 0) {
				sum += i;
			}
		}
		return sum;
	}

	/**
	 * Check if the isbn number giving is a valid one 
	 * It just check for ISBN-10
	 * @param  take the isbn number as a long
	 * @return X if the cheked digit is 10 else the value of the digit 
	 */
	public static String berechneChecksummeIsbn(long isbn) {
		checkIsbnInput(isbn);
		
		long result = 0;
		long isbn_mod = isbn;
		for (int i = 9; i > 0; i--) {
			long j = isbn_mod % 10; // convert to int j
			isbn_mod = isbn_mod / 10;
			result += j*i;

		}
		result = result % 11;
		if (result == 10) {
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
		if (d >= -DELTA_NUL && d < DELTA_NUL) {
			double x1 = -p/2 + Math.sqrt(d);

			return "Doppelte Nullstelle: " + x1;

		} else if (d < 0.0) {
			
			return "Komplexe Nullstellen";
			
		} else {
			double x1 = -p/2 + Math.sqrt(d);
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
		if (zahl<1) {
		    	throw new IllegalArgumentException("Die Zahl kann nicht negativ oder 0 sein.");
		}
	}

	/**
     	* This method is used to check if the value giving for isbn is isbn-10
     	* @param isbn the value with wich we will make the calculation with
     	*/
	public static void checkIsbnInput(long isbn) {
		if (100000000L > isbn || isbn > 1000000000L) {
		    	throw new IllegalArgumentException("Der ISBN muss 9 Ziffern lang sein");
		}
	}
}
