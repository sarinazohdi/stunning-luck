import static org.junit.Assert.*;

import org.junit.Test;
import java.io.*;

public class SquareTest{
  	public static final String CLASSNAME = "Square";

@Test
public void ValueTest(){
    Square tester = new Square();
    assertEquals ("value 0",0, Square.getValue());
}

@Test
public void SpinsTest(){
    Square tester = new Square();
    assertEquals ("spins 0",0, Square.getSpins());
}

@Test
public void setSpinsTest(){
    Square tester = new Square();
    tester.setSpins(10);
    assertEquals ("spins 10",10, Square.getSpins());
}

@Test
public void setValueTest(){
    Square tester = new Square();
    tester.setValue(5000);
    assertEquals ("value 0",5000, Square.getValue());
}




}
