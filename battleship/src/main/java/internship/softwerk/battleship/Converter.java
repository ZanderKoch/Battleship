package internship.softwerk.battleship;

/**
 * Utility class for converting from numbers to letters.
 * @author Zander Koch
 */
public class Converter {
    /**
     * 
     * @param number
     * @return An uppercase
     */
    static String numberToLetter(int number) throws IllegalArgumentException{
        switch (number) {
            case 1:
                return "A";
                break;
            default:
                throw new AssertionError();
        }
    }
}
