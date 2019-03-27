import java.util.ArrayList;
import java.util.Random;

/*
* The Board class keeps track of the main gameboard consisting of an list of Square objects.
* this is to be randomized and the first 20 items shown
*/

public class Board{

    private Random r = new Random();
    private ArrayList<Square> gameboard = new ArrayList<Square>();

    /* Method to add Square objects to the board individually */
    public void addSquare(Square square) {
        gameboard.add(square);
    }

    /* method to generate the initial board with 100 objects of the  Square class */
    public void populateBoard(){
        for (int i = 1; i <= 100; i++) {
            if (i > 0 && i <=10) {

                gameboard.add(new Square("Strike", 0, 0, "strike.png" ));
            }
            else if (i > 10 && i <=20) {
                gameboard.add(new Square("Win $5000", 5000, 0, "5000.png" ));
            }    
            else if (i > 20 && i <=25) {
                gameboard.add(new Square("Boat", 8000, 0, "boat.png" ));
            }
            else if  (i > 25 && i <=30) {
                gameboard.add(new Square("Hawaii Vacation", 2500, 0, "vacation.png" ));
            }
            else if  (i > 30 && i <=45) {
                gameboard.add(new Square("Win $100", 100, 0, "100.png" ));
            }
            else if  (i > 45 && i <=55) {
                gameboard.add(new Square("Free Spin", 0, 1, "testimage.png" ));
            }
            else if  (i > 55 && i <=60) {
                gameboard.add(new Square("Jeep", 27000, 0, "testimage.png" ));
            }
            else if  (i > 60 && i <=65) {
                gameboard.add(new Square("Free Coffee for a year", 700, 0, "testimage.png" ));
            }
            else if  (i > 65 && i <=75) {
                gameboard.add(new Square("Win $100 and Sping again", 100, 1, "testimage.png" ));
            }
            else if  (i > 75 && i <=80) {
                gameboard.add(new Square("Lose $50", -50, 0, "testimage.png" ));
            }
            else if  (i > 80 && i <=90) {
                gameboard.add(new Square("Mountain Bike", 250, 0, "testimage.png" ));
            }
            else if  (i > 90 && i <=92) {
                gameboard.add(new Square("Trip around the world", 10000, 0, "testimage.png" ));
            }
            else if  (i > 92 && i <=100) {
                gameboard.add(new Square("Win $500", 500, 0, "testimage.png" ));
            }
 
        }
    }
    
    /* method to return the board list */
    public ArrayList<Square> getList(){
        ArrayList<Square> newBoard = new ArrayList<Square>();
        for (Square square: newBoard){
            newBoard.add(new Square(square));
        }
        return newBoard;
    }

    /* method that pulls 20 random items from the main board list to pull a single randomized item for the player
        returns arrayList of 20 items*/
    public ArrayList<Square> RandomizeList(ArrayList<Square> al){
        ArrayList<Square> randomBoard = new ArrayList<Square>(); 
        for (int j = 1; j <= 20; j++){
            randomBoard.add(gameboard.get(r.nextInt(gameboard.size())));
        }
        return randomBoard;

    }




}
