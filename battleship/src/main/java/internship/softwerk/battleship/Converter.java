package internship.softwerk.battleship;

/**
 * Utility class for converting from numbers to letters.
 * @author Zander Koch
 */
public class Converter {
    /**
     * Converts an int 1-26 to an uppercase letter String A-J
     * @param number
     * @return A String equivalent to the specified int
     */
    static String numberToLetter(int number)  throws IllegalArgumentException{
        String alphabet = "ABCDFEFGHIJKLMNOPQRSTUVWXYZ";
        if (number >= 1 && number <= 26) {
            return Character.toString(alphabet.charAt(number - 1));
        }
        throw new IllegalArgumentException();
    }
}
