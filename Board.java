import java.util.ArrayList;

/*
* The Board class keeps track of the main gameboard consisting of an list of Square objects.
* this is to be randomized and the first 20 items shown
*/

public class Board{

    private ArrayList<Square> gameboard = new ArrayList<Square>();
    
    public void addSquare(Square square) {
        gameboard.add(square);
    }

}