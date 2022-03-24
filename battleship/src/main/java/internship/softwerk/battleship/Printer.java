package internship.softwerk.battleship;

/**
 * class responsible for all printing of text.
 * @author Zander Koch
 */
public class Printer {
    public static void printIntroduction(){
        System.out.println("Welcome to Battleships!");
        System.out.println("Type \"quit\" to quit at any time.");
        System.out.println("(all commands are case insensitive)");
    }
    
    public static void printDeploymentInstructions(){
        System.out.println("Deploy ships by entering an origin tile and a"
                + "direction, separated by a space.");
        System.out.println("(r for right, d for down)");
    }
}
