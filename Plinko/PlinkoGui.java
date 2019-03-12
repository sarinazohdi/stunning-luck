
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.util.Duration;
import plinkogame.Plinko;
import javafx.animation.KeyFrame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.ArrayList;
import javafx.scene.input.*;


/**
 * The PlinkoGui class works withe the Plinko class to create a visual experience for the player
 * it involves dtopping a ball through a serires of obstacles in order to fall into award sections
 * at the bottom of the window. 
 * @author
 * - Matthew Forman
 * - Sarina Zohdi
 * - Alexis Lee
 * - Doug Comperen
 * - Firoz Lakhani
 */
public class PlinkoGui extends Application {

    //private Plinko plinkoGame = new Plinko();
    private ArrayList<String> spinEarnedArray = new ArrayList<String>();
    private Player player = new Player("John Doe"); 


    @Override
    public void start(Stage primaryStage){
        // Array that contain groups of similar objects such as the pegs the abll bounces off of, the lines on the bottom of the diplay
        // and the numbers being displayed as well
        ArrayList<Circle> pegs = new ArrayList<Circle>();
        ArrayList<Label> numbers = new ArrayList<Label>();
        ArrayList<Line> lines = new ArrayList<Line>();
        setUpPlinko(spinEarnedArray);

        Pane root  = new Pane();
        Scene scene  = new Scene(root, 600,600);

        Bounds bounds = root.getBoundsInLocal();
        // setup the pegs on the board and adds them to the pegs Array; 
        for (int j = 1; j<=7; j++){
            if (j%2 != 0){
                for (int i = 1; i <= 6; i++){
                    pegs.add(new Circle(((bounds.getMaxX()/6)*i - 50), (j*(bounds.getMaxY()/9.23)), 5));
                }
            }
            else{
                for (int i = 1; i <= 5; i++){
                    pegs.add(new Circle((bounds.getMaxX()/6)*i, j*(bounds.getMaxY()/9.23), 5));
                }

            }

        }
        // creates the label objects that are used to display the numbers on the bottom
        for(int n = 1; n <= 9; n++){
            numbers.add(new Label(getValueFromSpinsEarnedArray(n-1)));
            numbers.get(n-1).setLayoutX((bounds.getMaxX()/9 * n) - 33);
            numbers.get(n-1).setLayoutY(560);
        }
        // creates the line objects that are used to specify the different sections at the bottom of the board
        for(int n = 1; n <= 9; n++){
            lines.add(new Line());
            lines.get(n-1).setStartX((bounds.getMaxX()/9 * n));
            lines.get(n-1).setEndX((bounds.getMaxX()/9 * n));
            lines.get(n-1).setStartY(600);
            lines.get(n-1).setEndY(535);
        }
        
        // the main ball used thorughout the game
        Circle droppedBall = new Circle();
        droppedBall.setRadius(20);
        droppedBall.setLayoutX(200);
        droppedBall.setLayoutY(25);
        
        // rectangle at bottom of screen the ball falls behind
        Rectangle rect = new Rectangle(600,65);
        rect.setLayoutX(0);
        rect.setLayoutY(535);
        rect.setFill(Color.RED);
        
        // adds all elements to the scene 
        root.getChildren().add(droppedBall);
        for (Circle p: pegs){
            root.getChildren().add(p);
        }
        root.getChildren().add(rect);
        for(Label l: numbers){
            root.getChildren().add(l);
        }
        for(Line l: lines){
            root.getChildren().add(l);
        }



        //Scene scene  = new Scene(root, 600,600);
        primaryStage.setTitle("Plinko");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // checks to see if left or right key is pressed to adjust initla position of ball or if space is pressed to initiate the drop ball sequence
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.SPACE) {
                dropBall(droppedBall, bounds, pegs, player);
            }
            if(key.getCode()==KeyCode.LEFT && droppedBall.getLayoutX() > (droppedBall.getRadius() + 50)){
                droppedBall.setLayoutX(droppedBall.getLayoutX() - 15);
            }
            if(key.getCode()==KeyCode.RIGHT && droppedBall.getLayoutX() < (600 - (droppedBall.getRadius() + 50 ))){
                droppedBall.setLayoutX(droppedBall.getLayoutX() + 15);
            }
        });         
    }

    public static void main(String[] args){
        launch(args);
    }
    /**
     * @param obj
     * @param obj2
     * the check for collisions function examines the location of 2 different circle items and checks to see if they collide
     * @return a Boolean result that is used elsewhere in the program.
     */
    public Boolean checkForCollisions(Circle obj, Circle obj2){
        Boolean collision = false;
        if (obj.getLayoutX() >= (obj2.getCenterX() - 5 - obj.getRadius()) && obj.getLayoutX() <= (obj2.getCenterX() + 5 + obj.getRadius())){

            if (obj.getLayoutY() >= (obj2.getCenterY() - 5 - obj.getRadius()) && obj.getLayoutY() <= (obj2.getCenterY() + 5 + obj.getRadius())){
                collision = true;
            }

        }

        return collision;

    }

    /**
     * @param obj
     * @param obj2
     * the check for collisions function examines the location of 2 different circle items and checks to see if they collide
     * @return a double result of the X Location at the point of the impact that is used elsewhere in the program.
     */
    public double getXOfCollision(Circle obj, Circle obj2){
        double xValue = 0.0;
        if (obj.getLayoutX() >= (obj2.getLayoutX() - obj.getRadius()) && obj.getLayoutX() <= (obj2.getLayoutX() + obj.getLayoutX())){

            if (obj.getLayoutY()>= (obj2.getLayoutY() - obj.getRadius()) && obj.getLayoutY() <= (obj2.getLayoutY() + obj.getLayoutY())){
                xValue  = obj.getLayoutX();
            }

        }
        return xValue;
    }

    /**
     * @param obj
     * @param obj2
     * the check for collisions function examines the location of 2 different circle items and checks to see if they collide
     * @return a double result of the Y Location at the point of the impact that is used elsewhere in the program.
     */
    public double getYOfCollision(Circle obj, Circle obj2){
        double yValue = 0.0;
        if (obj.getLayoutX() >= (obj2.getLayoutX() - obj.getRadius()) && obj.getLayoutX() <= (obj2.getLayoutX() + obj.getLayoutX())){

            if (obj.getLayoutY()>= (obj2.getLayoutY() - obj.getRadius()) && obj.getLayoutY() <= (obj2.getLayoutY() + obj.getLayoutY())){
                yValue  = obj.getLayoutY();
            }

        }
        return yValue;
    }

    /**
     * @param droppedBall
     * @param bounds
     * The giveSpinsToPlayer function checks the x value of the droppedBall parameter with regards to the bounds and uses that to return
     * the correct value of spins the player has earned, corresponding to the spot it landed.
     * @return and integer value spins.
     */
    public int giveSpinsToPlayer(Circle droppedBall, Bounds bounds, Player player) {
        int spins = 0;
        //Bounds bounds = root.getBoundsInLocal();
        if (droppedBall.getLayoutX() <= (bounds.getMaxX()/9)){
            spins = 2;
            player.setSpins(2);
        }
        else if (droppedBall.getLayoutX() > bounds.getMaxX()/9 && droppedBall.getLayoutX() <= (2*bounds.getMaxX())/9){
            spins = 3;
            player.setSpins(3);
        }
        else if (droppedBall.getLayoutX() > (2*bounds.getMaxX())/9 && droppedBall.getLayoutX() <= (3*bounds.getMaxX())/9){
            spins = 4;
            player.setSpins(4);
        }
        else if (droppedBall.getLayoutX() > (3*bounds.getMaxX())/9 && droppedBall.getLayoutX() <= (4*bounds.getMaxX())/9){
            spins = 1;
            player.setSpins(1);
        }
        else if (droppedBall.getLayoutX() > (4*bounds.getMaxX())/9 && droppedBall.getLayoutX() <= (5*bounds.getMaxX())/9){
            spins = 5;
            player.setSpins(5);
        }
        else if (droppedBall.getLayoutX() > (5*bounds.getMaxX())/9 && droppedBall.getLayoutX() <= (6*bounds.getMaxX())/9){
            spins = 1;
            player.setSpins(1);
        }
        else if (droppedBall.getLayoutX() > (6*bounds.getMaxX())/9 && droppedBall.getLayoutX() <= (7*bounds.getMaxX())/9){
            spins = 4;
            player.setSpins(4);
        }
        else if (droppedBall.getLayoutX() > (7*bounds.getMaxX())/9 && droppedBall.getLayoutX() <= (8*bounds.getMaxX())/9){
            spins = 3;
            player.setSpins(3);
        }
        else if (droppedBall.getLayoutX() > (8*bounds.getMaxX())/9 && droppedBall.getLayoutX() <= (9*bounds.getMaxX())/9){
            spins = 2;
            player.setSpins(2);
        }

        return spins;

    }
    
    /**
     * @param droppedBall
     * @param bounds
     * @param pegs
     * the dropBall function uses information provided from the parameters in order to simulate the dropping of a ball
     * through a field of pegs, as would happen in a real version of plinko. 
     * it is through this action that the player recieves a score. 
     */
    public void dropBall(Circle droppedBall, Bounds bounds, ArrayList<Circle> pegs, Player player){

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(30), new EventHandler<ActionEvent>(){
            double dy = 1.58;
            double verticalVelocity = 0.0;
            double horizontalVelocity = 0.0;
            

            public void handle(ActionEvent t){
                droppedBall.setLayoutY(droppedBall.getLayoutY() + verticalVelocity);
                droppedBall.setLayoutX(droppedBall.getLayoutX() + horizontalVelocity);
                // condidtion for if somehow the ball touches the top of the board the velocity if reveresed so it returns to the board
                if ((droppedBall.getLayoutY() <= (bounds.getMinY() + droppedBall.getRadius()))){
                    verticalVelocity = -verticalVelocity;
                    
                } 
                // checks to see if the ball has reached the bottom of the screen and collects the score.
                if (droppedBall.getLayoutY() >= (bounds.getMaxY() - droppedBall.getRadius())){
                    verticalVelocity = 0;
                    dy = 0;
                    horizontalVelocity = 0;
                    giveSpinsToPlayer(droppedBall, bounds, player);
                }
                // reverses the velocity of the ball if it hits either sides of the window to keep it on screen
                if ((droppedBall.getLayoutX() >= (bounds.getMaxX() - droppedBall.getRadius())) || (droppedBall.getLayoutX() <= (bounds.getMinX() + droppedBall.getRadius()))){
                    horizontalVelocity = -horizontalVelocity;
                    
                }
                
                // checks all the circles objects in peg to see if they collide with the dropped ball 
                for (Circle peg: pegs){
                    Boolean collide = checkForCollisions(droppedBall, peg);
                    if (collide == true){
                        double xCoord = getXOfCollision(droppedBall, peg);
                        double yCoord = getYOfCollision(droppedBall, peg);
                        if ((xCoord) > peg.getCenterX()){
                            horizontalVelocity += 0.75;
                            
                        }
                        if ((xCoord) < peg.getCenterX()){
                            horizontalVelocity -= 0.75;
                        }

                        if (yCoord <= peg.getCenterY()){
                            verticalVelocity = -1;
                        }

                        if (yCoord < peg.getCenterY() && xCoord == peg.getCenterX()){
                            System.out.println("equals");
                            verticalVelocity = -3;
                            horizontalVelocity = 0.05;
                        }
                    }

                    
                }
                // puts a gravity type effect on the ball always having it wanting to go downwards
                verticalVelocity += dy;
            }

        })); 

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        
               

    }


    public void setUpPlinko(ArrayList<String> alstr){
        alstr.add("2");
        alstr.add("4");
        alstr.add("3");
        alstr.add("1");
        alstr.add("5");
        alstr.add("1");
        alstr.add("3");
        alstr.add("4");
        alstr.add("2");

    }

    public String getValueFromSpinsEarnedArray(int i){
        ArrayList<String> getterSpins = new ArrayList<String>();
        for (String n: spinEarnedArray){
            getterSpins.add(n);
        }
        return getterSpins.get(i);
    }
}