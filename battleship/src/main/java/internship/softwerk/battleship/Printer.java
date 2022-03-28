package internship.softwerk.battleship;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * class responsible for all printing of text.
 * @author Zander Koch
 */
public class Printer {
    private static final String GRID_HEADER =
            "   1   2   3   4   5   6   7   8   9   10";
    private static final String GRID_HORIZONTAL_LINE =
            " +---+---+---+---+---+---+---+---+---+---+";
    private static final String HIT_SOUND ="*Bang!*";
     private static final String MISS_SOUND ="*Splash!*";
    
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
        printActivePlayerShipList();
        printActivePlayerGrid();
    }
    
    /**
     * Prints a message stating that it's the currently active player's turn.
     */
    public static void printPlayerTurn() {
        String message = "It is " 
                + GameState.getInstance().getActivePlayer().getName()
                + "'s turn";
        System.out.println(message);
    }
    
    /**
     * Prints active player's list of ships.
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
    
    /**
     * prints the currently active player's grid
     */
    private static void printActivePlayerGrid() {
        System.out.println("Your grid:");
        printGrid(GameState.getInstance().getActivePlayer().getMyGrid()); 
    }
    
    private static void printActivePlayerHitOrMissGrid() {
        System.out.println("Known enemy grid:");
        printGrid(GameState.getInstance().getActivePlayer().getHitOrMissGrid());
    }
    
    /**
     * Prints the values of a HashMap into the appropriate tiles of a 10*10
     * grid, with numbers 1-10 on the horizontal axis and letters A-J on the 
     * vertical. Tiles with no corresponding value get filled with spaces.
     * @param grid, HashMap with with values 3 letters long or shorter
     */
    private static void printGrid(HashMap<String, String> grid) {
        System.out.println(GRID_HEADER);
        System.out.println(GRID_HORIZONTAL_LINE);
        
        for (int i = 1; i < 11; i++) {
            String row = Converter.numberToLetter(i) + "|";
            for (int j = 1; j < 11; j++) {
                String coordinateLetter = Converter.numberToLetter(i);
                String coordinateNumber = Integer.toString(j);
                String coordinate = coordinateLetter + coordinateNumber;
                
                String tileSymbol = grid.getOrDefault(coordinate, " ");
                row += " " + tileSymbol + " |";
            }
            System.out.println(row);
            System.out.println(GRID_HORIZONTAL_LINE);
        }
    }
    /**
     * Prints an error message for when the player tries to deploy a ship in a 
     * way that makes it extend beyond the 10*10 grid.
     */
    public static void printShipBoundsError() {
        System.out.println("Error: ship is too big to fit inside the grid from "
                + "there");
    }
    
    /**
     * Prints an error message for when the player tries to deploy a ship into
     * tiles that are already occupied by another ship.
     */
    public static void printShipBlockedError() {
        System.out.println("Error: ship overlaps with an already placed ship"
                + " from there");
    }
    
    /**
     * prints a message for when an attack hits a ship tile.
     */
    public static void printAttackHit() {
        System.out.println(HIT_SOUND);
    }
    
    /**
     * prints a message for when an attack does not hit a ship tile.
     */
    public static void printAttackMiss() {
        System.out.println(MISS_SOUND);
    }
    
    /**
     * prints instructions for the attacking phase of the game.
     */
    public static void printAttackingInstructions() {
        System.out.println("All ships have been deployed, and the players will"
                + " now begin attacking eachother.");
        System.out.println("Attack a tile by entering its coordinate. Turns last"
                + " until the attacking player misses.");
    }
    
    /**
     * Prints all info relevant to picking a tile to attack.
     */
    public static void printAttackInfo() {
        printPlayerTurn();
        printActivePlayerHitOrMissGrid();
        printActivePlayerGrid();
    }
}
