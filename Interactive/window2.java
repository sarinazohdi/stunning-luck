import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 

/**
 * The main class for the spinning prize board of the Stunning Luck game
 * @author 
 * - Doug Comperen
 * - Matthew Forman
 * - Sarina Zohdi
 * - Alexis Lee
 * - Firoz Lakhani
 */
public class window2 extends Application {

    public static final int GRID = 150; // sets a static variable that is used to calculate placement of items
    private int returnprize = 0; //holds the random number after the animation plays to assign prize
    private  Rectangle highlighter = currentSelection(random()); // variable to call the random highlight
    private int spins = MainMethod.player1.getSpins(); // gets number of spins from player
    public static void main(String[] args) {
        launch(args);
    }

/**
 * Builds the main gameboard and positions each element and label
 * @author 
 * - Doug Comperen
 * - Matthew Forman
 * - Sarina Zohdi
 * - Alexis Lee
 * - Firoz Lakhani
 */

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        Group root = new Group();
        Scene scene = new Scene(root, 900, 900, Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Stunning Luck");
        Board board = new Board();
        board.populateBoard();
        ArrayList<Square> randomBoard = board.RandomizeList(board.getList()); // gets list of 20 random objects from the board class
        int counter = 0;

        Group root2 = new Group();
        Scene endScene  = new Scene(root2, 900, 900, Color.PINK);

        
        Button endGame = new Button("Close");
        endGame.setLayoutX(350);
        endGame.setLayoutY(500);
        endGame.setOnAction(click -> {
            primaryStage.close();
            MainMethod.gameFinished = true;
            

        });

        Label congrats = new Label("Congratulations!");
        congrats.setFont(new Font("Tahoma",70));
        congrats.setTextFill(Color.BLACK);
        congrats.setLayoutX(300);
        congrats.setLayoutY(200);
        
        Label endScore = new Label("You won a total cash and prize value of: " + Integer.toString(MainMethod.player1.getScore()));
        endScore.setLayoutX(200);
        endScore.setLayoutY(250);
        endScore.setTextFill(Color.BLACK);
        
        root2.getChildren().add(endScore);
        root2.getChildren().add(endGame);
        root2.getChildren().add(congrats);

        
        primaryStage.show();

        
        // creates pause button
        Button save = new Button("Pause");
        save.setLayoutX(175);
        save.setLayoutY(175);
        save.setOnAction(click -> {
            Stage pauseStage = new Stage();
           
                Group groot = new Group();
                Scene pscene = new Scene(groot, 300, 150);
        
                Button resumeButton = new Button("Resume");
                resumeButton.setLayoutX(50);
                resumeButton.setLayoutY(100);
                resumeButton.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(ActionEvent a){

                        pauseStage.close();
                    }
                });
        
                Button endGameButton = new Button("Main Menu");
                endGameButton.setLayoutX(150);
                endGameButton.setLayoutY(100);
                endGameButton.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(ActionEvent a){
                        pauseStage.close();
                        primaryStage.close();
        
                    }
                });
        
                groot.getChildren().add(resumeButton);
                groot.getChildren().add(endGameButton);
                
        
                pauseStage.setTitle("Pause");
                pauseStage.setScene(pscene);
                pauseStage.show();
            

        });

        root.getChildren().add(save);
        //creates label for remaining spins to be updated after animation plays
        Label spinsRemaining = new Label("Spins Remaining " + Integer.toString(spins));
        spinsRemaining.setLayoutX(375);
        spinsRemaining.setLayoutY(200);
        spinsRemaining.setTextFill(Color.WHITE);
        root.getChildren().add(spinsRemaining);
        //creates label for remaining spins to be updated after animation plays
        Label currentScore = new Label("Current cash and prize value: " + Integer.toString(MainMethod.player1.getScore()));
        currentScore.setLayoutX(375);
        currentScore.setLayoutY(250);
        currentScore.setTextFill(Color.WHITE);
        root.getChildren().add(currentScore);
        root.getChildren().add(highlighter);


        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200),
        new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event){
                
                root.getChildren().remove(highlighter);
                highlighter = currentSelection(random());
                root.getChildren().add(highlighter);
                 
     
                }
                    
            }  
            
            
        
        ));
        //set timeline animation to repeat 15 times
        timeline.setCycleCount(15);
        timeline.setOnFinished(event -> {        
            MainMethod.player1.addScore(randomBoard.get(returnprize).getValue()); //add prize value to players score
            spins += randomBoard.get(returnprize).getSpins();
            MainMethod.player1.setSpins(spins);            
            currentScore.setText("Current cash and prize value: " + Integer.toString(MainMethod.player1.getScore()));
            if(spins == 0){
                primaryStage.setScene(endScene);
            }
            
        });
        //creates spin button and places it
        Button spin = new Button("SPIN");
        spin.setLayoutX(300);
        spin.setLayoutY(400);
        spin.setPrefSize(300, 100);
        spin.setOnAction(click -> {
            if (spins > 0){
            timeline.play();
            spins -= 1;
            spinsRemaining.setText("Spins Remaining " + Integer.toString(spins));
            
            
            }
            else if (spins <= 0){
            
            }
        });
        root.getChildren().add(spin);
        //timeline.play();

        for(int i = 0; i<20;i++){
            ImageView label = wins(i, randomBoard);
            if (i >=0 && i <= 5){
                label.setX(i*GRID);
                label.setY(0);
            }
            else if (i >= 6 && i <= 9) {
                label.setX(0);
                label.setY((i - 5) * GRID);
            }
            else if (i >= 10 && i <= 13) {
                label.setX(5 *GRID);
                label.setY((i - 9) * GRID);
            }
            else if (i >= 14 && i < 20) {
                label.setX((i - 14) *GRID);
                label.setY(5 * GRID);
            }
            
            root.getChildren().add(label);

        }

        

    }



    public ImageView wins(int i, ArrayList<Square> randomBoard) throws FileNotFoundException{

        Image labelprize = new Image(new FileInputStream(randomBoard.get(i).getImage()));
        ImageView label = new ImageView(labelprize);
        label.setFitHeight(150); 
        label.setFitWidth(150);
        label.setPreserveRatio(true); 

        return label;

    }

    /**
 * prizebox creates a rectangle object to pass to the stage
 * @param x the x coordinate of the top left corner
 * @param y the y coordinate of the top left corner
 * @param width the total width of the rectangle
 * @param height the height of the rectangle
 * @return prize, a rectangle object
 * @author 
 * - Doug Comperen
 * - Matthew Forman
 * - Sarina Zohdi
 * - Alexis Lee
 * - Firoz Lakhani
 */

    public ImageView prizeBox(int x, int y, int width, int height) throws FileNotFoundException{
        //Rectangle prize = new Rectangle(x, y, width, height);
        //prize.setStrokeType(StrokeType.INSIDE);
        //prize.setStroke(Color.web("white", 1));
        //prize.setStrokeWidth(2);
        Image prizePic = new Image(new FileInputStream("testimage.png"));
        ImageView prizeView = new ImageView(prizePic); 
        prizeView.setX(x); 
        prizeView.setY(y);
        prizeView.setFitHeight(150); 
        prizeView.setFitWidth(150);
        prizeView.setPreserveRatio(true); 

        return prizeView;

    }


/**
 * currentSelection creates a rectangle object to pass to the stage
 * @param choice the index of the object being refenced from the arraylist
 * @return selection, a rectangle object
 * @author 
 * - Doug Comperen
 * - Matthew Forman
 * - Sarina Zohdi
 * - Alexis Lee
 * - Firoz Lakhani
 */

    public Rectangle currentSelection(int choice) {
        int x = 0;
        int y = 0;
        if (choice == 0) {
            x = 0;
            y = 0;

        }
        else if (choice == 1) {
            x = GRID;
            y = 0;

        }
        else if (choice == 2) {
            x = 2 * GRID;
            y = 0;

        }
        else if (choice == 3) {
            x = 3 * GRID;
            y = 0;

        }
        else if (choice == 4) {
            x = 4 * GRID;
            y = 0;

        }
        else if (choice == 5) {
            x = 5 * GRID;
            y = 0;

        }
        else if (choice == 6) {
            x = 0;
            y = GRID;

        }
        else if (choice == 7) {
            x = 0;
            y = 2 * GRID;

        }
        else if (choice == 8) {
            x = 0;
            y = 3 * GRID;

        }
        else if (choice == 9) {
            x = 0;
            y = 4 * GRID;

        }
        else if (choice == 10) {
            x = 5 * GRID;
            y = GRID;

        }
        else if (choice == 11) {
            x = 5 * GRID;
            y = 2 * GRID;

        }
        else if (choice == 12) {
            x = 5 * GRID;
            y = 3 * GRID;

        }
        else if (choice == 13) {
            x = 5 * GRID;
            y = 4 * GRID;

        }
        else if (choice == 14) {
            x = 0;
            y = 5 * GRID;

        }
        else if (choice == 15) {
            x = GRID;
            y = 5 * GRID;

        }
        else if (choice == 16) {
            x = 2 *GRID;
            y = 5 * GRID;

        }
        else if (choice == 17) {
            x = 3 * GRID;
            y = 5 * GRID;

        }
        else if (choice == 18) {
            x = 4 * GRID;
            y = 5 * GRID;

        }
        else if (choice == 19) {
            x = 5 * GRID;
            y = 5 * GRID;

        }

        Rectangle selection = new Rectangle(x, y, GRID, GRID);
        selection.setStrokeType(StrokeType.INSIDE);
        selection.setStroke(Color.web("yellow", 0.75));
        selection.setFill(Color.TRANSPARENT);
        selection.setStrokeWidth(6);

        return selection;
    }


    /**
 * random creates a random number between 0 and 19. It is used to randomly select a prize from the arraylist
 * @return a random int between 0 and 19 inclusive
 * @author 
 * - Doug Comperen
 * - Matthew Forman
 * - Sarina Zohdi
 * - Alexis Lee
 * - Firoz Lakhani
 */

    public int random(){
        Random r = new Random();
        returnprize = r.nextInt(20);
        return returnprize;


    }



    





}

