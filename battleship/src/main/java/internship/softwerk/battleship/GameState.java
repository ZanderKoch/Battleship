package internship.softwerk.battleship;

/**
 * singleton class responsible for the execution of commands parsed and sent by
 * Commandparser
 * @author Zander Koch
 */
public class GameState {
    private static GameState instance;
    
    private Player player1 = new Player("Player one");
    private Player player2 = new Player("Player two");
    private Player activePlayer = player1;
    private Player inactivePlayer = player2;

    private GameState() {
        
    }
    
    /**
     * Tries to deploy a ship of the same size of the first ship on the active
     * player's ship list and returns false when both players are out of ships.
     * @param coordinate origin coordinate for the deploying ship
     * @param direction direction that the ship deploys in
     * @return 
     */
    public boolean deploy (String coordinate, String direction){
        boolean shipsRemain;
        
        if (direction.equalsIgnoreCase("r")) {
            shipsRemain = activePlayer.deployRight(coordinate);
        } else {
            shipsRemain = activePlayer.deployDown(coordinate);
        }
        
        //if the player who just deployed doesn't have any ships left
        if (!shipsRemain) {
            //and the deploying player is player one
            if (activePlayer.equals(player1)) {
                //switch to player two and print their info
                cycleActivePlayer();
                 Printer.printDeploymentInfo();
                return true;
            } else {
                //tell the parser that deployment is done
                return false;
            }
        }
        //keep depoying for the same player
         Printer.printDeploymentInfo();
        return true;
    }
    
    
    private void cycleActivePlayer(){
        Player previousActivePlayer = activePlayer;
        activePlayer = inactivePlayer;
        inactivePlayer = previousActivePlayer;
        
    }
    
    public void attack(String coordinate){
        
    }
    
    public static GameState getInstance() {
        if (instance == null) {
            instance = new GameState();
        }
        return instance;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }    
}
