import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Demo1{
    /**

     */
    public static void main(String args[]){
        Random random = new Random();
        Board gameBoard = new Board();
        gameBoard.populateBoard();
        Player player =  new Player("John");
       /* ArrayList<Square> squares = gameBoard.RandomizeList(gameBoard.getList());
        for (Square square : squares){
            System.out.println(square.getTitle());

        }*/
        Scanner keyboard  = new Scanner(System.in);
        while(true){
            ArrayList<Square> squares = gameBoard.RandomizeList(gameBoard.getList());
            for (Square square : squares){
                System.out.println(square.getTitle());
    
            }
            System.out.println("Press Q to spin and W to exit");
            String input = keyboard.nextLine();
            if(input.equalsIgnoreCase("q")){
                Square newAward = squares.get(random.nextInt(squares.size()));
                player.addAward(newAward);
                System.out.println("\nYour reward: " +newAward.getTitle()+"\n\n\n");

                for (Square square : squares){
                    System.out.println(square.getTitle());
                }  
        
            } 
            
            if(input.equalsIgnoreCase("w")){
                break;
            }

           
        }
        System.out.println("Your awards: ");
        for (Square square : player.getAwards()){
            System.out.println(square.getTitle());
        }  
    }
}