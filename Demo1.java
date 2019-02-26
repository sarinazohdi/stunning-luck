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
        ArrayList<Square> squares = gameBoard.RandomizeList(gameBoard.getList());
        for (Square square : squares){
            System.out.println(square.getTitle());

        }
        Scanner keyboard  = new Scanner(System.in);
        System.out.println("Press any key to spin");
        String input = keyboard.nextLine();
        
        System.out.println("\nYour reward: " +squares.get(random.nextInt(squares.size())).getTitle());
    }
}