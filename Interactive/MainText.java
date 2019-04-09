import java.util.Scanner;
/**
 * The class MainText provides a test based version of the game Stunning luck.
 * It calls methods from itself, as well as from the BoardText, and MiniGameText classes.
 * It allows the user to enter their name and earn spins with the minigames
 * It then allows the user to "spin" the board which gives the user a random award out of the 20 available. 
 * 
 * @author:
 * Matthew Forman
 */
public class MainText{
    private static Player player = new Player("John Doe");
    private static int counter = 0;

    public static void main(String[] args){
        initiateGame();
        whichGame();
        
    }
    /**
     * The initiateGame method is the function that prompts the user to enter their name and in general sets up 
     * the player object for the user.
     */
    public static void initiateGame(){
        System.out.println("Stunning Luck");
        Scanner getInfo = new Scanner(System.in);
        System.out.println("Enter your name below:");
        String userName = getInfo.nextLine();
        if (userName.equals("") == false){
            player.setName(userName);
        }
            
        System.out.println("Welcome " + player.getName() + "!");
    }
    /**
     * The whichGame Method is the main logic of the test based version. It first keeps track of how many minigames the player has played using the 
     * counter instance variable. If that is below three it propmts the user to play the minigames. once the user has played 3 minigames of thier choice 
     * this method brings them to the board where they can use their spins to earn awards.
     */
    public static void whichGame(){
        
        if (counter < 3){
            System.out.println("Which game do you want to play?");
            System.out.println("Enter 'plinko', 'brick breaker', or 'snake'");
            Scanner getInfo = new Scanner(System.in);
            String gameSelection = getInfo.nextLine();
            if (gameSelection.equalsIgnoreCase("plinko")){
                //System.out.println("play plinko");
                MiniGameText plinko = new MiniGameText();
                plinko.setUpMiniGame();
                plinko.setUserName(player.getName());
                player.addSpins(plinko.getSpinsFromMiniGame());
                System.out.println("You have " + player.getSpins() + " spins total!\n\n\n\n");
                counter+=1;
                whichGame();
            }
            else if (gameSelection.equalsIgnoreCase("brick breaker")){
                //System.out.println("play brick");
                MiniGameText brick = new MiniGameText();
                brick.setUpMiniGame();
                brick.setUserName(player.getName());
                player.addSpins(brick.getSpinsFromMiniGame());
                System.out.println("You have " + player.getSpins() + " spins total!\n\n\n\n");
                counter+=1;
                whichGame();
            }else if (gameSelection.equalsIgnoreCase("Snake")){
                //System.out.println("play snake");
                MiniGameText snake = new MiniGameText();
                snake.setUpMiniGame();
                snake.setUserName(player.getName());
                player.addSpins(snake.getSpinsFromMiniGame());
                System.out.println("You have " + player.getSpins() + " spins total!\n\n\n\n");
                counter+=1;
                whichGame();
            }
            else {
                System.out.println("Invalid input.");
                whichGame();
            }
        } else{
            //System.out.println("play board");
            BoardText.playBoard(player.getSpins(), player);
        }
            
        
        

    }
    
}