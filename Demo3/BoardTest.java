import static org.junit.Assert.*;

import org.junit.Test;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class BoardTest{
  	public static final String CLASSNAME = "Board";
//100 objects test
@Test
public void BoardTest(){
  Board gameboard = new Board();
  gameboard.populateBoard();
    assertEquals ("100 objects in list",100, gameboard.size());


}
// return 20 objects
@Test
public void ReturnBoardTest(){
  Board gameboard = new Board();
  gameboard.populateBoard();
  ArrayList<Square> random = new ArrayList<Square>();
  random=RandomizeList(gameboard);
  assertEquals ("100 objects in list",20, random.size());



}


/*@Test
public void AddSquareTest(){
    Board return = new Board();
}
*/

@Test
public void R2(){
  Board gameboard = new Board();
  gameboard.populateBoard();
  ArrayList<Square> random = new ArrayList<Square>();
  random=RandomizeList(gameboard);
  ArrayList<Square> random2 = new ArrayList<Square>();
  random2=RandomizeList(gameboard);

}

}
