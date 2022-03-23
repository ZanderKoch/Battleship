package internship.softwerk.battleship;

import java.util.Scanner;

/**
 * Main program class, continually processes text commands entered by the user
 * @author Zander Koch
 */
public class CommandParser {
    public static void main(String[] args) {
        Printer.printIntroduction();
        boolean isDeploying = true;
        
        
        Scanner scanner = new Scanner(System.in);
        boolean isQuitting = false;
        while (!isQuitting) {            
            String input = scanner.nextLine();
            
            
            if (input.equalsIgnoreCase("quit")) {
                isQuitting = true;
                return;
            }
        }
    }
}
