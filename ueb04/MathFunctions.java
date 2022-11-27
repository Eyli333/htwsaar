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
	private static final int zero = 0;
	private static final int one = 1;
	private static final int nine = 9;
	private static final int ten = 10;
	private static final int eleven = 11;
	private static final int twentysix= 26;
	private static final long isbnNumber = 1000000000L;

	/**
	 * Calculate the sum of the divisor for a number
	 * and return it as a long
	 * @param take the number as a long
	 * @return  the sum of the divisor
	 */
	public static long berechneTeilersumme (long zahl) {
		checkAboveOne(zahl);

		long result = 0;

		if (zahl == 1){
			return 1;
		}

		for (int i = 2; i <= Math.sqrt(zahl); i++) {
			if (zahl % i == 0) {
				if (i == (zahl/ i)) {
					result += i;
				} else {
					result += (i + zahl/ i);
				}
			}
		}
		return (result + zahl + 1);
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
		double delta = Math.pow(p/2, 2) - q;
		double x = -p/2 + Math.sqrt(delta);
			if (delta >= -DELTA_NUL && delta < DELTA_NUL) {
				double x1 = x;
	 
				return "Doppelte Nullstelle: " + x1;

			} else if (delta < 0.0) {
				
				return "Komplexe Nullstellen";
				
			} else {
				double x1 = x;
				double x2 = -p/2 - Math.sqrt(delta);
			
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
		checkNonNegative(zahl1);
		checkNonNegative(zahl2);

		if (zahl1 == 0) {
			return zahl2;
		} else if (zahl2 == 0) {
			return zahl1;
		}
		
		if (zahl2 > zahl1) {
			int temp = zahl2;
			zahl2 = zahl1;
			zahl1 = temp;	
		}

		while (zahl2 != zero) {
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
	public static BigInteger berechneFakultaet(long zahl){

		TestUtils.checkIsNonNegativ(zahl);

		if (zahl == 0 || zahl == 1) {
			return BigInteger.valueOf(1);
		}
		
		else if (zahl < 26) {

				long sum = 1;

			while (zahl > 1) {
				sum *= zahl; 
				zahl-= 1;
			}

			return BigInteger.valueOf(sum);

		}
	
		BigInteger sum = new BigInteger("1");

		while(zahl > 1){
			sum = sum.multiply(BigInteger.valueOf(zahl));
			zahl -= 1;
		}

		return sum;
	}

	/**
     	* This method is used to calulate to check if a number
	* can be written as a^4+b^3+c^2
     	* @param zahl is the value as a int
	* @return true if it's possible else false
     	*/
	public static boolean istSummeVonPotenzen(long zahl) {

		checkAboveOne(zahl);

		double asdf = (double)zahl;
		double sqrtZahlDouble = Math.sqrt(asdf);
		double oneThirdSqrtZahlDouble = Math.round(Math.pow(zahl, 1/3));
		double doubleSqrtZahlDouble = Math.sqrt(sqrtZahlDouble);

		long sqrtZahl = (long)sqrtZahlDouble;
		long oneThirdSqrtZahl = (long)oneThirdSqrtZahlDouble;
		long doubleSqrtZahl = (long)doubleSqrtZahlDouble;

		for (long i = 1; i <= doubleSqrtZahl;++i) {
			for (long j = 1; j <= oneThirdSqrtZahl;++j) {
				for (long k = 1; k <= sqrtZahl;++k) {

					double a = Math.pow((double)i, 4.0); 
					double b = Math.pow((double)j, 3.0);
					double c = Math.pow((double)k, 2.0);
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

		checkAboveOne(anzahl);
		
		double sum = 0;
		for (int i = 1; i <= anzahl;++i) {
			double over = Math.pow(x-1, i);
			double under = i * Math.pow(x, i);
			sum += over / under;
			System.out.println(i);
		}
		return sum;
	}

	/**
     	* This method is used to check if the value giving is above one
     	* @param zahl the value with wich we will make the calculation with 
     	*/
	public static void checkAboveOne(long zahl) {
		if (zahl < one) {
		    	throw new IllegalArgumentException("Die Zahl kann nicht negativ oder 0 sein.");
		}
	}

	/**
     	* This method is used to check if the value giving is above 26
     	* @param zahl the value with wich we will make the calculation with 
     	*/
	public static void checkAbovetwentsix(long zahl) {
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
	 * This method is used to check if the value is negativ 
	 * @param zahl this is the value that will be checked 
	 */
	public static void checkNonNegative(int zahl) {
		if (zahl < zero) {
		    	throw new IllegalArgumentException("Die Zahl kann nicht negativ sein.");
		}

	}
}
