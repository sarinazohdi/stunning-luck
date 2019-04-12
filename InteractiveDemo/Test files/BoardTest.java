import static org.junit.Assert.*;

import org.junit.Test;
import java.io.*;
import java.util.ArrayList;

public class BoardTest{
  	public static final String CLASSNAME = "Board";

      Board board = new Board();
      board.populateBoard();

@Test
public void PopulateTest(){

    assertEquals ("Board created length 100",100, board.size());
}

@Test
public void RandomTest(){
    ArrayList<Square> randomBoard = board.RandomizeList(board.getList());
    assertEquals ("Random board created length 20",20, randomboard.size());
}


}
