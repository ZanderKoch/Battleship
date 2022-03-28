package internship.softwerk.battleship;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class for converting from numbers to letters.
 * @author Zander Koch
 */
public class Converter {
    /**
     * Converts an int 1-26 to an uppercase letter String A-J.
     * @param number a number between 1 and 26, inclusive
     * @return An uppercase 1-lenght String corresponding to the specified int
     * @throws IllegalArgumentException
     */
    public static String numberToLetter(int number)
            throws IllegalArgumentException {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (number >= 1 && number <= 26) {
            return Character.toString(alphabet.charAt(number - 1));
        }
        throw new IllegalArgumentException(number + "is outside bounds for "
                + "conversion to letter");
    }
    
    /**
     * Converts a 1-lenght String to the number representing its position in the
     * alphabet.
     * @param letter String to convert, must be a letter A-Z and 1-lenght
     * @return number representing the letter's position in the alphabet, so 
     * A = 1, B = 2, and so on
     * @throws IllegalArgumentException
     */
    public static int letterToNumber(String letter)
            throws IllegalArgumentException {
        Pattern pattern = Pattern.compile("^[A-Z]$"
                ,Pattern.CASE_INSENSITIVE); 
        Matcher matcher = pattern.matcher(letter);
        if (matcher.matches()) {
            char character = letter.charAt(0);
            return character - 40;
        }
        throw new IllegalArgumentException(letter + "is not a singular number"
                + "and can not be converted");
    }
}
