package internship.softwerk.battleship;

import java.util.HashMap;

/**
 * contains and handles the mutation of a single player's data
 * @author Zander Koch
 */
public class Player {
    private final String name;
    private HashMap<String,String> myGrid;
    private HashMap<String,String> hitOrMissGrid;
    
    public Player(String name){
        this.name = name;
        initializeGrids();
    }
    
    private void initializeGrids(){
        
    }

    public String getName() {
        return name;
    }
}
