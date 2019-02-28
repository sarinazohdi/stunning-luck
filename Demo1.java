import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Demo1{
    /**
     * First Class Demo - Firoz, Matthew, Sarina, Doug, Alexis
     */
    public static void main(String args[]){
        Random random = new Random(); //used to pick a random object from the list
        Board gameBoard = new Board();
        gameBoard.populateBoard(); // populates the board with a bunch of squares
        Player player =  new Player("John"); // used to keep track of the players status in the game
       
        Scanner keyboard  = new Scanner(System.in);

        //loop will run forever unless the user presses the W key
        while(true){

            ArrayList<Square> squares = gameBoard.RandomizeList(gameBoard.getList()); //returns a random arraylist from the gameboard
            
            //prints all elements of the random list
            for (Square square : squares){
                System.out.println(square.getTitle());
            }
            //user prompt 
            System.out.println("Press any key to spin and W to exit");
            String input = keyboard.nextLine();

           //adds the award to the players list of awards
            Square newAward = squares.get(random.nextInt(squares.size()));
            player.addAward(newAward);
            
            System.out.println("\nYour reward: " +newAward.getTitle()+"\n\n\n");

                
            
            
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