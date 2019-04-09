import static org.junit.Assert.*;

import org.junit.Test;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class PlayerTest{
  	public static final String CLASSNAME = "Player";

//


//copy constructor
@Test
public void copy_constructorTest(){
Player a = new Player("Bob",2,5,0);
Player p= new Player(a);
  assertEquals("Testing name" ,"Bob", p.getName());
  assertEquals("Testing number of spins",2, p.getSpins());
  assertEquals("Testing Score",5, p.getScore());
  assertEquals("Testing Strike",0, p.getStrikes());
}
// testing getters and setters
@Test
public void test_anySpins_added(){
  Player p= new Player("john");
  p.addSpins(1);
  assertEquals ("check number of added spin",1, p.getSpins());
  p.addSpins(1);
  assertEquals ("check number of added spin",2, p.getSpins());

}

@Test
public void test_playerscore(){
  Player p= new Player("john");
  p.setScore(1);
    assertEquals ("check value of added score",1, p.getScore());
    p.setScore(5);
    assertEquals("check value of added score", 5, p.getScore());
}

@Test
public void test_number_of_strikes(){
    Player p= new Player("john");
    assertEquals ("max number of strikes",0, p.getStrikes());
    p.setStrikes(1);
    assertEquals("check if strikes are added properly", 1,p.getStrikes());

}

@Test
public void Test_miniGame_count(){
  Player p= new Player("john");
  p.addMiniGameCount(1);
  assertEquals("test number of mini games",1,p.getMiniGameCount());
}
/*
@Test
public void Test_Count_Award(){
  Player p= new Player();
  p.addAward(new Square());
  assertEquals("test initial size",1, p.getAwards().size());
}

@Test
public void Test_Count_squareAwards(){
  Player p= new Player();
  p.addAward(new Square());
  Square testSquare=p.getAwards().get(0);
  assertEquals("test size of square",new Square(), testSquare);
}
*/
//@Test
//public void Test_NameofPlayer(){

//}
}
