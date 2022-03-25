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
    static GameState gameState = GameState.getInstance();
    public static void main(String[] args) {
        Printer.printIntroduction();
        
        Printer.printDeploymentInstructions();
        Printer.printDeploymentInfo();
        
        startParser();
        
    }
    
    /**
     * starts a loop that sends commands it reads from the scanline to 
     * appropriate methods for validation and execution.
     */
    private static void startParser() {
        Scanner scanner = new Scanner(System.in);
        boolean isQuitting = false;
        while (!isQuitting) {            
            String input = scanner.nextLine();
            
            /*Refactoring: separate everything in this loop into a method that
            takes the input and returns the new value for isQuitting.
            this will make it possible to test the quitting functionality*/
            if (input.equalsIgnoreCase("quit")) {
                isQuitting = true;
                return;
            }
            
            /*Refactoring?: maybe the contents of these  statements should be
            methods*/
            if(isDeploying){
                Printer.printDeploymentInfo();
                if (validateDeployCommand(input)) {
                    String coordinate = input.split(" ")[0];
                    String direction = input.split(" ")[1];
                    gameState.deploy(coordinate, direction);
                } else {
                    //print an error message
                }
            } else if(!isDeploying) {
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
    private static boolean validateDeployCommand(String command) {
        Pattern pattern = Pattern.compile("^[A-J](?:[1-9]|10)\\s[RD]$"
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
    private static boolean validateAttackCommand(String command) {
        Pattern pattern = Pattern.compile("^[A-J](?:[1-9]|10)$"
                ,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(command);
        return matcher.matches();
    }
}
