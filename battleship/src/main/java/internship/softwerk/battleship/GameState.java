package internship.softwerk.battleship;

/**
 * singleton class responsible for the execution of commands parsed and sent by
 * Commandparser
 * @author Zander Koch
 */
public class GameState {
    private static GameState instance;

    private GameState() {
        
    }
    
    public static GameState getInstance(){
        if (instance == null) {
            instance = new GameState();
        }
        return instance;
    }
    
    
}
