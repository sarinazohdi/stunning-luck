import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


/**
 * The BoardText class provides a text based version of the logic behind the the GUI version of the board
 * it creates a board with 20 random objects from a list of 100 and then chooses one at random from which the user has won.
 * It then returns the awards won by the user.
 */
public class BoardText {

    /**
     * 
     * @param Spins
     * @param player
     * uses the above parameters from the MainText class in order to edit them.
     * This is called after the player has played all 3 minigames.
     */
    public static void playBoard(int Spins, Player player){
        Random random = new Random(); //used to pick a random object from the list
        Board gameBoard = new Board();
        gameBoard.populateBoard(); // populates the board with a bunch of squares
        //Player player =  new Player("John"); // used to keep track of the players status in the game
       
        Scanner keyboard  = new Scanner(System.in);

        //loop will run forever unless the user presses the W key or they run out of spins
        while(true){

            ArrayList<Square> squares = gameBoard.RandomizeList(gameBoard.getList()); //returns a random arraylist from the gameboard
            
            //prints all elements of the random list
            for (Square square : squares){
                System.out.println(square.getTitle());
            }
            //user prompt
            System.out.println("You have " + player.getSpins() + " spins left."); 
            System.out.println("Press any key to spin and W to exit");
            String input = keyboard.nextLine();

           //adds the award to the players list of awards
            Square newAward = squares.get(random.nextInt(squares.size()));
            player.addAward(newAward);
            if (newAward.getTitle().equals("Strike")){
                player.setSpins(player.getSpins() - 1);
            }
            if (newAward.getTitle().contains("Spin again") || newAward.getTitle().contains("Free Spin")){
                player.setSpins(player.getSpins() + 1);
            }
            player.setSpins(player.getSpins() - 1);
            
            System.out.println("\nYour reward: " +newAward.getTitle()+"\n\n\n");
            

                
            
            if (player.getSpins() == 0){
                break;
            }
            if(input.equalsIgnoreCase("w")){
                break;
            }

           
        }
        
        //prints the player's awards to the screen
        
        System.out.println("\n\n\nYour awards: ");
        for (Square square : player.getAwards()){
            System.out.println(square.getTitle());
        }  
    }


    
}