package internship.softwerk.battleship;

/**
 * class responsible for all printing of text.
 * @author Zander Koch
 */
public class Printer {
    /*would it be a good idea to include the exact message that gets printed in 
    the javadoc comment?*/
    
    /**
     * prints an introductory message.
     */
    public static void printIntroduction() {
        System.out.println("Welcome to Battleships!");
        System.out.println("Type \"quit\" to quit at any time.");
        System.out.println("(all commands are case insensitive)");
    }
    
    /**
     * prints instructions for deploying ships.
     */
    public static void printDeploymentInstructions() {
        System.out.println("Deploy ships by entering an origin tile and a "
                + "direction, separated by a space.");
        System.out.println("r for right, d for down");
    }
    
    /**
     * prints all info relevant to deploying a ship. This includes:
     * the active player, their list of remaining ships, and their current grid.
     */
    public static void printDeploymentInfo() {
        //print that it is the active player's turn
        //print active player's ship list
        //print active player's own grid
    }
}
