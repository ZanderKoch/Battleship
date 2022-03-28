package internship.softwerk.battleship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * contains and handles the mutation of a single player's data
 * @author Zander Koch
 */
public class Player {
     private static final String SHIP_SYMBOL = "B";
     private static final String WRECK_SYMBOL = "X";
     private static final String MISS_SYMBOL = "O";

    private final String name;
    private ArrayList<Integer> shipSizes = new ArrayList(
            Arrays.asList(5
                        , 4, 4
                        , 3, 3, 3, 3, 3, 3, 3
                        , 2, 2));
    private HashMap<String,String> myGrid = new HashMap();
    private HashMap<String,String> hitOrMissGrid = new HashMap();
    
    public Player(String name){
        this.name = name;
    }
    
    
    /**
     * Adds a ship of the same size as the first number in shipSizes to player's
     * grid if it fits, prints error message if not.
     * @param coordinate origin coordinate to deploy at 
     * @return wether or not the player still has boats to deploy
     */
    //Refactoring: split into multiple private methods
    public boolean deployRight(String coordinate){
        if (shipSizes.isEmpty()) {
            return false;
        }
        int size = shipSizes.get(0);
        
        Pattern pattern = Pattern.compile("^([A-J])([1-9]|10)$"
                ,Pattern.CASE_INSENSITIVE); 
        Matcher matcher = pattern.matcher(coordinate);
        matcher.matches();
        String coordinateLetter = matcher.group(1);
        int coordinateNumber = Integer.parseInt(matcher.group(2));
        
        if ( size > 10 - coordinateNumber) {
            Printer.printShipBoundsError();
            return true;
        }
        
        //checking that none of the tiles the ship would go on are taken already
        for (int i = 0; i < size; i++) {
            String checkingCoordinate =coordinateLetter
                    + Integer.toString(coordinateNumber + i);
            if (myGrid.containsKey(checkingCoordinate)) {
                Printer.printShipBlockedError();
                return true;
            }
        }
        
        //add key value pairs for all tiles to myGrid
        for (int i = 0; i < size; i++) {
            String placeCoordinate = coordinateLetter
                    + Integer.toString(coordinateNumber + i);
            myGrid.put(placeCoordinate.toUpperCase(Locale.ENGLISH), SHIP_SYMBOL);
        }
        shipSizes.remove(0);
        //returns true as long as shipSizes has not been emptied
        return !shipSizes.isEmpty();
    }
    
    /**
     * Adds a ship of the same size as the first number in shipSizes to player's
     * grid if it fits, prints error message if not.
     * @param coordinate origin coordinate to deploy at 
     * @return wether or not the player still has boats to deploy
     */
    //Refactoring: split into multiple private methods
    public boolean deployDown(String coordinate){
        if (shipSizes.isEmpty()) {
            return false;
        }
        int size = shipSizes.get(0);
        
        Pattern pattern = Pattern.compile("^([A-J])([1-9]|10)$"
                ,Pattern.CASE_INSENSITIVE); 
        Matcher matcher = pattern.matcher(coordinate);
        matcher.matches();
        String coordinateLetter = matcher.group(1);
        int coordinateNumber = Integer.parseInt(matcher.group(2));
        
        if ( size > 10 - Converter.letterToNumber(coordinateLetter)) {
            Printer.printShipBoundsError();
            return true;
        }
        
        //checking that none of the tiles the ship would go on are taken already
        for (int i = 0; i < size; i++) {
            String checkingCoordinate = Converter.numberToLetter(
                    Converter.letterToNumber(coordinateLetter) + i)
                    + coordinateNumber; 
            if (myGrid.containsKey(checkingCoordinate)) {
                Printer.printShipBlockedError();
                return true;
            }
        }
        
        //add key value pairs for all tiles to myGrid
        for (int i = 0; i < size; i++) {
            String placeCoordinate =Converter.numberToLetter(
                    Converter.letterToNumber(coordinateLetter) + i)
                    + coordinateNumber;
            myGrid.put(placeCoordinate.toUpperCase(Locale.ENGLISH), SHIP_SYMBOL);
        }
        shipSizes.remove(0);
        //returns true as long as shipSizes has not been emptied
        return !shipSizes.isEmpty();
    }
    
    /**
     * Attacks the given tile on the players grid, replacing hit ship tiles with
     * an X, and returns true for a hit and false for a miss
     * 
     * @param coordinate
     * @return 
     */
    public boolean attackTile(String coordinate){
        if (myGrid.getOrDefault(
                coordinate.toUpperCase(Locale.ENGLISH), "")
                .equals(SHIP_SYMBOL)) {
            myGrid.put(coordinate, WRECK_SYMBOL);
            Printer.printAttackHit();
            return true;
        } else {
            Printer.printAttackMiss();
            return false;
        }
    }
    
    /**
     * Updates player's grid of hits and misses on given coordinates with given
     * boolean indicating wether to add a hit or miss.
     * @param coordinates tile to update
     * @param hit wether or not to add a hit or miss
     */
    public void updateHitOrMissGrid(String coordinates, boolean hit) {
        String symbol;
        if (hit) {
            symbol = WRECK_SYMBOL;
        } else {
            symbol = MISS_SYMBOL;
        }
        
        hitOrMissGrid.put(coordinates.toUpperCase(Locale.ENGLISH), symbol);
    }
    
    
    public String getName() {
        return name;
    }

    public ArrayList<Integer> getShipSizes() {
        return shipSizes;
    }

    public HashMap<String, String> getMyGrid() {
        return myGrid;
    }
}
