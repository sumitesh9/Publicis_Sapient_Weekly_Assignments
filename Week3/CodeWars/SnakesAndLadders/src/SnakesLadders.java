import java.util.HashMap;
public class SnakesLadders {
    
    // playerPosition[0] = position of first player
    // playerPosition[1] = position of second player
  
    private int playerPosition[];
    
    // won equals true when game is over
    private boolean won;
    
    // Stores player's turn
    private int player;
  
    // Stores mapping of all special Squares (Positions of ladders and snakes)
    private HashMap<Integer , Integer> specialSquares;
    
    // Constructor to initialise variables
    public SnakesLadders() {
        playerPosition = new int[2];
        won = false;
        player = 0;
        specialSquares = new HashMap<>();
        specialSquares.put(2 , 38);
        specialSquares.put(7 , 14);
        specialSquares.put(8 , 31);
        specialSquares.put(15 , 26);
        specialSquares.put(16 , 6);
        specialSquares.put(21 , 42);
        specialSquares.put(28 , 84);
        specialSquares.put(36 , 44);
        specialSquares.put(46 , 25);
        specialSquares.put(49 , 11);
        specialSquares.put(51 , 67);
        specialSquares.put(62 , 19);
        specialSquares.put(64 , 60);
        specialSquares.put(71 , 91);
        specialSquares.put(74 , 53);
        specialSquares.put(78 , 98);
        specialSquares.put(87 , 94);
        specialSquares.put(89 , 68);
        specialSquares.put(92 , 88);
        specialSquares.put(95 , 75);
        specialSquares.put(99 , 80);
    }
    
    public String play(int die1, int die2) {
        
        // Check if game is over ?
        if (won) return "Game over!";
        
        // Find new position of current player
        int add = die1 + die2;
        int newPosition = add + playerPosition[player];
         
        // If new position is greater than 100 then we need to go back that many steps
        if (newPosition > 100) {
            playerPosition[player] = 200 - newPosition; 
        }
        
        // If new position is within board
        else {
            playerPosition[player] = newPosition;
            
            // Current player has won
            if (newPosition == 100) {
                won = true;
                return "Player " + (player + 1) + " Wins!";
            }
        }
        
        // If new position is special square (ladder or snake) then update accordingly
        
        if (specialSquares.containsKey(playerPosition[player])) {
            playerPosition[player] = specialSquares.get(playerPosition[player]);
        }
         
        // Store the string to be returned
        String answer = "Player " + (player + 1) + " is on square " + playerPosition[player];
        
        // Switch the turn if dice have different values
        if (die1 != die2) {
            player ^= 1;
        }
        
        //return the string
        return answer;
    }
}