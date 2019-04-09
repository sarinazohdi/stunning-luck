import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

/**
 * The MiniGameText class contains methods that have a really basic random function that returns a number from an array.
 * due to the fact that we dont have a GUI as this game runs in the terminal the game simply randomly chooses a number out of an array in which a maximum of 5 spins can be earned
 * when the GUI is introduced we will still have to same array for the plinko game however the selection process will be based off of where a ball "lands" at the bottom of the screen. 
 * The GUI also contains different ways to earn spins in the other two minigames. In snake the more food you eat, the more spins you get and in brick breaker the more bricks
 * you break the more spins you earn.
 * 
 * 
 * @author
 * Matthew Forman
 */
public class MiniGameText {
    //Instance Variables
    private static ArrayList<Integer> spinEarnedArray = new ArrayList<Integer>();
    private static Random randIndexGenerator;
    private static Player player = new Player("John Doe");
    
    /**
     * MiniGameText Constructor
     */
    public MiniGameText(){
        spinEarnedArray = new ArrayList<Integer>();
        randIndexGenerator = new Random();
    }

    /**
     * the getSpinsFromMiniGame method randomly selects an index value from the array 
     * @return the int element of the array from the random index
     */    
    public  int getSpinsFromMiniGame(){
        int randIndex = randIndexGenerator.nextInt(spinEarnedArray.size());
        player.setSpins(spinEarnedArray.get(randIndex));
        System.out.println("Congratualtions "+ player.getName()+  " you earned " + player.getSpins() + " spins!");
        return spinEarnedArray.get(randIndex);

    }


    public static void setUserName(String userName){
        player.setName(userName);
    }

    
    /**
     * this function adds the initial values to the array that the game chooses from
     * this MUST be called before the mini game is played!!!
     */
    public void setUpMiniGame(){
        spinEarnedArray.add(2);
        spinEarnedArray.add(4);
        spinEarnedArray.add(3);
        spinEarnedArray.add(1);
        spinEarnedArray.add(5);
        spinEarnedArray.add(1);
        spinEarnedArray.add(3);
        spinEarnedArray.add(4);
        spinEarnedArray.add(2);

    }

    
}
