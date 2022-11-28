/**
 * <h1>Create Objects</h1>
 * Allows the user to use MathFunctions
 * to make some calculation
 * 
 * @author Victor Plage and David Glaser
 * @version 1.0.0
 * @since 2022-11-16
 */

import java.lang.Math;
public class MathFunctions{

	private static final double DELTA_NUL = 0.000000001;
	private static final int ZERO = 0;
	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int THREE = 3;
	private static final int FOUR = 4;
	private static final int FIVE = 5;
	private static final int SIX = 6;
	private static final int NINE = 9;
	private static final int TEN = 10;
	private static final int ELEVEN = 11;

	/**
	 * Calculate the sum of the divisor for a number
	 * and return it as a long
	 * @param take the number as a long
	 * @return  the sum of the divisor
	 */
	public static long berechneTeilersumme (long zahl) {
		TestUtils.checkEqualZero(zahl);
		TestUtils.checkIsNonNegativ(zahl);

		long result = 0;

		if (zahl == 1){
			return 1;
		}

		else if(istPrimzahl(zahl)){
			return 1 + zahl;
		}

		for (int i = 4; i <= Math.sqrt(zahl); i++) {
			if (zahl % i == 0) {
				if (i == (zahl / i)) {
					result += i;
				} else {
					result += (i + zahl / i);
				}
			}
		}
		return (result + zahl + 1);
	}

	/**
	 * Check if the isbn number giving is a valid ONE 
	 * It just check for ISBN-10
	 * @param  take the isbn number as a long
	 * @return X if the cheked digit is 10 else the value of the digit 
	 */
	public static String berechneChecksummeIsbn(long isbn) {
		TestUtils.checkIsbnInput(isbn);
		
		long result = ZERO;
		long isbnMod = isbn;
		for (int i = NINE; i > ZERO; i--) {
			long j = isbnMod % TEN; // convert to int j
			isbnMod = isbnMod / TEN;
			result += j * i;

		}
		result = result % ELEVEN;
		if (result == TEN) {
			return "X";
		}
		return Long.toString(result);
	}

	/**
     	* This method is used to Determine the ZEROs of a quadratic  
	* quadratic equation and return them as a formatted string
     	* @param p is the first value as a double
     	* @param q is the second value as a double
	* @return x1, x1 and x2 or nothing
     	*/
	public static String berechneNullstellen (double p, double q) {
		double delta = Math.pow(p/TWO, TWO) - q;
		double x = -p/TWO + Math.sqrt(delta);
			if (delta >= -DELTA_NUL && delta < DELTA_NUL) {
				double x1 = x;
	 
				return "Doppelte Nullstelle: " + x1;

			} else if (delta < 0.0) {
				
				return "Komplexe Nullstellen";
				
			} else {
				double x1 = x;
				double x2 = -p/TWO - Math.sqrt(delta);
			
				return "Zwei Nullstellen: " + x1 + "|" + x2;
			}
		}

	/**
     	* This method is used to Determine the Ggt
	* and return them as a int
     	* @param zahl1 is the first value as a int
     	* @param zahl2 is the second value as a int
	* @return zahl as the Ggt in int
     	*/
	public static int berechneGgt(int zahl1, int zahl2) {
		TestUtils.checkIsNonNegativ(zahl1);
		TestUtils.checkIsNonNegativ(zahl2);
		TestUtils.checkBothNumbersZero(zahl1, zahl2);

		if (zahl1 == ZERO) {
			return zahl2;
		} else if (zahl2 == ZERO) {
			return zahl1;
		}
		
		if (zahl2 > zahl1) {
			int temp = zahl2;
			zahl2 = zahl1;
			zahl1 = temp;	
		}

		while (zahl2 != ZERO) {
			int temp = zahl1;
			zahl1 = zahl2;
			zahl2 = temp % zahl1;

		}

		return Math.abs(zahl1);

	}

	/**
     	* This method is used to calulate the Faktorial of a number
	* and return them as a long
     	* @param zahl is the value as a int
	* @return sum as the result of the factorial as a long
     	*/
	public static long berechneFakultaet(long zahl){
		TestUtils.checkIsNonNegativ(zahl);
		TestUtils.checkAboveTwentsix(zahl);

		if (zahl == ZERO || zahl == ONE) {

			return ONE;

			// return BigInteger.valueOf(1);
		}
		
		// else if (zahl < 26) {
		
		long sum = ONE;

		while (zahl > ONE) {
			sum *= zahl; 
			zahl -= ONE;
		}
		
		return sum;

		// return BigInteger.valueOf(sum);

		// }
	
		// BigInteger sum = new BigInteger("1");

		// while(zahl > 1){
		// 	sum = sum.multiply(BigInteger.valueOf(zahl));
		// 	zahl -= 1;
		// }

		// return sum;
	}
	/**
     	* This method is used to calulate to check if a number
	* can be written as a^4+b^3+c^2
     	* @param zahl is the value as a int
	* @return true if it's possible else false
     	*/
	public static boolean istSummeVonPotenzen(long zahl) {
		TestUtils.checkEqualZero(zahl);
		TestUtils.checkIsNonNegativ(zahl);

		double doubleZahl = (double)zahl;
		double squareRootZahlDouble = Math.sqrt(doubleZahl);
		double cubeRootZahlDouble = Math.cbrt(doubleZahl);
		double quarticRootZahlDouble = Math.sqrt(squareRootZahlDouble);

		long squareRootZahl = (long)squareRootZahlDouble;
		long cubeRootZahl = (long)cubeRootZahlDouble;
		long quarticRootZahl = (long)quarticRootZahlDouble;

		for (long i = ONE; i <= quarticRootZahl; ++i) {
			for (long j = ONE; j <= cubeRootZahl; ++j) {
				for (long k = ONE; k <= squareRootZahl; ++k) {

					double a = Math.pow((double)i, (double) FOUR); 
					double b = Math.pow((double)j, (double) THREE);
					double c = Math.pow((double)k, (double) TWO);
					double compute = a + b + c;

					if ((long)compute == zahl) {
						return true;
					}
				}
			}
		}

		return false;
	}

	/**
    	* This method is used to calulate the sum of a serie
    	* @param anzahl is the first value as a int
    	* @param x is the second value as a double 
	* @return the sum as a double
     	*/
	public static double berechneReihensumme(int anzahl, double x) {
		TestUtils.checkEqualZero(anzahl);
		TestUtils.checkIsNonNegativ(anzahl);
		
		double sum = ZERO;
		for (int i = ONE; i <= anzahl; ++i) {
			double over = Math.pow(x-ONE, i);
			double under = i * Math.pow(x, i);
			sum += over / under;
		}
		return sum;
	}

	/**
    	* This method is used check if a number is prime
    	* @param zahl is the value as a int
	* @return the result as a boolean
     	*/
	public static boolean istPrimzahl(long zahl) {
		TestUtils.checkEqualZero(zahl);
		TestUtils.checkIsNonNegativ(zahl);

		if (zahl <= THREE){

			return true;
		}
		// This is checked so that we can skip
		// middle FIVE numbers in below loop
		if (zahl % TWO == ZERO || zahl % THREE == ZERO){

			return false;
		}

		for (int i = FIVE; i * i <= zahl; i = i + SIX){

			if (zahl % i == ZERO || zahl % (i + TWO) == ZERO){

				return false;
			}
		}

		return true;
	}
}
