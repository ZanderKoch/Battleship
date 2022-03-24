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
        
        //print deployment instructions
        
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
            
            /*Refactoring?: maybe the contents of these two statements should be
            methods*/
            if(isDeploying){
                //print deployment info (friendly board and available ships)
                if (validateDeployCommand(input)) {
                    //deploy a boat
                } else {
                    //print an error message
                }
            } else {
                if (validateAttackCommand(input)) {
                    //attack a square
                } else {
                    //print and error message
                }
            }
        }
    }
    
    /**
     * validates given command. Returns true for valid commands,
     * false for invalid ones. Case insesitive
     * @param command should consist of a character, one or two digits, and a 
     * space followed by v or h. 
     * @return 
     */
    private static boolean validateDeployCommand(String command){
        Pattern pattern = Pattern.compile("^[a-j](?:[1-9]|10)\\s[rd]$"
                ,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(command);
        return matcher.matches();
    }
    
    /**
     * validates given command. Returns true for valid commands,
     * false for invalid ones. Case insesitive
     * @param command should consist of a character, followed a number 1-10,
     * inclusive
     * @return 
     */
    private static boolean validateAttackCommand(String command){
        Pattern pattern = Pattern.compile("^[a-j](?:[1-9]|10)$"
                ,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(command);
        return matcher.matches();
    }
}
