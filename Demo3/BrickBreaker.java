import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.*;
import javafx.scene.input.*;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.util.Duration;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;

import java.util.ArrayList;
/**
 * This is the class that is responsible for creating the scene for
 * the Brick Breaker Game. This game involves launching a ball and hitting
 * bricks to aquire points
 */
public class BrickBreaker extends Application {
    //instance variables keep track of various game properties
    private static int score = 0;
    private Rectangle paddle = new Rectangle(70f,20f,Color.RED);
    private Circle ball = new Circle(10f,Color.MAGENTA);
    private ArrayList<Rectangle> blocks = new ArrayList<Rectangle>();

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane root = new Pane();

        root.setStyle("-fx-background-color: #000000;");//black background
        root.getChildren().add(paddle);

        root.getChildren().add(ball);

        for (int i = 0; i<16;i++){
            blocks.add(new Rectangle(50f,20f,Color.ORANGE));
        }
         /**
         * adds all the blocks to the screen
         */
        for (int i = 0; i<8;i++){
           Rectangle block = blocks.get(i);
           block.setLayoutX(i*80);
           block.setLayoutY(50);
           root.getChildren().add(block);
        }
        for (int i = 8; i<16;i++){
            Rectangle block = blocks.get(i);
            block.setLayoutX((i-8)*80);
            block.setLayoutY(100);
            root.getChildren().add(block);
         }
        //sets the position of the paddle
        paddle.setLayoutX(250);
        paddle.setLayoutY(420);

        //sets the position of the ball
        ball.setLayoutX(150);
        ball.setLayoutY(250);



        Scene scene = new Scene(root, 623, 450);

        //moves the paddle when the left and right keys are pressed
        scene.setOnKeyPressed(e -> {
            Bounds bounds = root.getBoundsInLocal();
            if (e.getCode() == KeyCode.RIGHT){

                /**
                 * sets right boundary for the paddle and will only move it if the paddle
                 * will not exceed that boundary
                 */
                if(paddle.getLayoutX() <= 500.0)
                {
                    paddle.setLayoutX(paddle.getLayoutX()+50);
                }


            }

                /**
                 * sets left boundary for the paddle and will only move it if the paddle
                 * will not exceed that boundary
                 */
            if (e.getCode() == KeyCode.LEFT) {

                if(paddle.getLayoutX() > bounds.getMinX())
                {
                    paddle.setLayoutX(paddle.getLayoutX()-50);
                }
            }
        });

        /**
         * New Pane is created for the gameover screen
         */
        Pane root1 = new Pane();
        //properties for the game over text
        Label message = new Label("Game Over");
        message.setTextFill(Color.RED);
        message.setFont(new Font("Cambria", 40));
        message.setLayoutX(190);
        message.setLayoutY(170);

        Button mainMenu = new Button("Main Menu");
        mainMenu.setLayoutX(300);
        mainMenu.setLayoutY(300);
        mainMenu.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent a){
                primaryStage.close();
            }
        });

        root1.getChildren().add(message);
        root1.getChildren().add(mainMenu);
        root1.setStyle("-fx-background-color: #000000;");
        Scene gameOver = new Scene(root1,600,450);

        primaryStage.setTitle("Brick Breaker");
        primaryStage.setScene(scene);
        primaryStage.show();

        /**
         * the timeline is used for collision detection as well
         * as the game animations
         */
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20),
                new EventHandler<ActionEvent>() {

        	double dx = 4; //change in x
        	double dy = 4; //change in y

            @Override
            public void handle(ActionEvent t) {
            	//move the ball
            	ball.setLayoutX(ball.getLayoutX() + dx);
            	ball.setLayoutY(ball.getLayoutY() + dy);

                Bounds bounds = root.getBoundsInLocal();

                /**
                 * If the ball reaches the left or right border , the ball will bounce off of it
                */
                if(ball.getLayoutX() <= (bounds.getMinX() + ball.getRadius()) ||
                        ball.getLayoutX() >= (bounds.getMaxX() - ball.getRadius()) ){

                	dx = -dx;

                }

                /**
                 * If the ball reaches the top border , the ball will bounce off of it
                */

                if((ball.getLayoutY() <= (bounds.getMinY() + ball.getRadius()))
                ||(ball.getBoundsInParent().intersects(paddle.getBoundsInParent()))){
                	dy = -dy;
                }

                /**
                 * destroys blocks that are hit by the ball and
                 * increments the score
                 */

                for (Rectangle block:blocks){
                    if(ball.getBoundsInParent().intersects(block.getBoundsInParent())){
                        root.getChildren().remove(block);
                        block.setLayoutX(1000);
                        block.setLayoutY(1000);
                        score++;
                        
                        if (score == 16){
                            primaryStage.setScene(gameOver);
                        }
                      }
                      



                }
                /**
                 * Switches to the game over
                 * screen if the player misses the ball
                 */

                if(ball.getLayoutY() >= (bounds.getMaxY() - ball.getRadius())){

                    primaryStage.setScene(gameOver);

                }



            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        primaryStage.show();


        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode() == KeyCode.P){
                if (timeline != null)
                    timeline.pause();
                
                Stage pauseStage = new Stage();
                pause(pauseStage, primaryStage, timeline);
                
            }
        }); 

    }
    /**
     * @return the score achieved
     */
    public static int getScore(){
        return score;
    }

    public void pause(Stage pauseStage, Stage primaryStage, Timeline timeline){
        Pane root = new Pane();
        Scene scene = new Scene(root, 300, 150);

        Button resumeButton = new Button("Resume");
        resumeButton.setLayoutX(50);
        resumeButton.setLayoutY(100);
        resumeButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent a){
                if (timeline != null)
                    timeline.play();
                pauseStage.close();
            }
        });

        Button endGameButton = new Button("End Game");
        endGameButton.setLayoutX(150);
        endGameButton.setLayoutY(100);
        endGameButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent a){
                //if (timeline != null)
                    //timeline.play();
                pauseStage.close();
                primaryStage.close();
            }
        });

        root.getChildren().add(resumeButton);
        root.getChildren().add(endGameButton);
        

        pauseStage.setTitle("Pause");
        pauseStage.setScene(scene);
        pauseStage.show();
    }

    public Scene afterBallReachBottom(Stage primaryStage, Player player1){
        Pane endPane = new Pane();
        Scene endScene = new Scene(endPane, 623, 450);

        Label spinsEarned = new Label("Congratulations! You earned " + player1.getSpins()+ " spins!");
        spinsEarned.setLayoutX(200);
        spinsEarned.setLayoutY(150);

        Button mainMenu = new Button("Main Menu");
        mainMenu.setLayoutX(300);
        mainMenu.setLayoutY(300);
        mainMenu.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent a){
                primaryStage.close();
            }
        });

        endPane.getChildren().add(spinsEarned);
        endPane.getChildren().add(mainMenu);
        

        return endScene;
    }
}
