class ArrayFunctions {

    /**
     * Calculates the average value, nearest value, and farthest value of the given array of doubles.
     * @param messverte the array of doubles
     * @return a Mittelwert object with the calculated average value, nearest value, and farthest value
     */
    public static Mittelwert berechneMittelwert(double[] messverte) {
        double sum = 0;
        for (int i = 0; i < messverte.length; i++) {
            sum += messverte[i];
        }

        double mittelwert = sum / messverte.length;

        double weitestenwert = messverte[0];
        double naehstewert = messverte[0];

        for (int i = 1; i < messverte.length; i++) {
            if (Math.abs(mittelwert - messverte[i]) < Math.abs(mittelwert - naehstewert)) {
                naehstewert = messverte[i];
            }
            if (Math.abs(mittelwert - messverte[i]) > Math.abs(mittelwert - weitestenwert)) {
                weitestenwert = messverte[i];
            }
        }

        return new Mittelwert(mittelwert, naehstewert, weitestenwert);
    }

    /**
     * Counts the number of valid strings in the given array. A string is considered valid if it consists only of letters.
     * @param strings the array of strings
     * @return the number of valid strings
     */
    public static int stringsAuswerten(String[] strings) {
        int count = 0;
        

        for (int i = 0; i < strings.length; i++) {
            boolean isValid = true;
            int lowerCase = 0;
            int upperCase = 0;
            int stringLength = strings[i].length();

            for (int j = 0; j < stringLength; j++) {
                char c = strings[i].charAt(j);

                if (!Character.isLetter(c)) {
                    isValid = false;
                    break;
                }

                if (Character.isLowerCase(c)) {
                    lowerCase++;
                } else {
                    upperCase++;
                }
            }

            if (isValid && lowerCase == stringLength || upperCase == stringLength) {
                count++;
            }
        }

        return count;
    }
}
