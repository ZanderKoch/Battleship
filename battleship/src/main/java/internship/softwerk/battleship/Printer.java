package internship.softwerk.battleship;

import java.util.ArrayList;
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
        printPlayerTurn();
        //print active player's own grid
        printActivePlayerShipList();
    }
    
    /**
     * Prints a message stating that it's the currently active player's turn.
     */
    public static void printPlayerTurn() {
        String message = "It is player" 
                + GameState.getInstance().getActivePlayer().getName()
                + "'s turn";
        System.out.println(message);
    }
    
    /**
     * prints active player's list of ships.
     * 
     */
    private static void printActivePlayerShipList() {
        System.out.println("Ships available to deploy listed by length:");
        ArrayList<Integer> shipSizes =
                GameState.getInstance().getActivePlayer().getShipSizes();
        for(int shipSize : shipSizes) {
            System.out.println(shipSize);
        }
    }
     */
    public static void printPlayerShipList(Player player){
        System.out.println("Ship ships available to deploy listed by type:");
        for()
    }
}
