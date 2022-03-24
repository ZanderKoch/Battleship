package internship.softwerk.battleship;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Main program class, continually processes text commands entered by the user
 * @author Zander Koch
 */
public class CommandParser {
    static boolean isDeploying = true;
    public static void main(String[] args) {
        Printer.printIntroduction();
        
        GameState gameState = GameState.getInstance();
        
        startParse();
        
    }
    
    /**
     * starts a loop that sends commands it reads from the scanline to 
     * appropriate methods for validation and execution.
     */
    private static void startParse(){
        Scanner scanner = new Scanner(System.in);
        boolean isQuitting = false;
        while (!isQuitting) {            
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("quit")) {
                isQuitting = true;
                return;
            }
            
            /*check if input consits of a character, one or two numbers, and
            optionally a space and a v or h*/
            Pattern pattern = Pattern.compile(
                    "^[a-j]\\d{1,2}$|^[a-j]\\d{1,2}\\s[vh]$"
                    ,Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            if (!matcher.matches()) {
                System.out.println("Command was not recognised");
                continue;
            }
            if (isDeploying) {
                
            }
        }
    }
}
