import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.geometry.Insets;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.control.TextField;

public class MainMethod extends Application{
    public static Player player1 = new Player("John Doe");
    private int namesInputCount = 0;

    public void start(Stage primaryStage){
        
        Pane root = new Pane();
        root.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        Scene scene = new Scene(root, 1000, 1000);

        TextField playerName = new TextField("New player? Input name here!");
        playerName.setLayoutX(300);
        playerName.setLayoutY(250);
        playerName.setPrefWidth(225);
        playerName.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent n){
                if (namesInputCount < 1){
                    player1.setName(playerName.getText());
                    
                }
                System.out.println(player1.getName());
                namesInputCount++;
            }
        });
        
        

        Label nameOfGame = new Label("Stunning Luck");
        nameOfGame.setFont(new Font("Tahoma",60));
        nameOfGame.setTextFill(Color.GREEN);
        nameOfGame.setLayoutX(200);
        nameOfGame.setLayoutY(75);

        Label highScores = new Label("High Scores");
        highScores.setFont(new Font("Tahoma", 30));
        highScores.setTextFill(Color.GREEN);
        highScores.setLayoutX(800);
        highScores.setLayoutY(30);

        Label displaySpins = new Label("You've earned " + player1.getSpins() + " spins so far!");
        displaySpins.setFont(new Font("Tahoma", 30));
        displaySpins.setTextFill(Color.GREEN);
        displaySpins.setLayoutX(350);
        displaySpins.setLayoutY(200);

        Button plinkoButton = new Button("Plinko");
        plinkoButton.setLayoutX(50);
        plinkoButton.setLayoutY(300);
        plinkoButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t){
                player1.setMiniGameCount(player1.getMiniGameCount()+ 1);
                Stage plinkoStage = new Stage();
                try{
                new PlinkoGui().start(plinkoStage);
                }catch(Exception e){
                    e.printStackTrace();
                }
                //player1.addSpins(PlinkoGui.getSpinsFromPlinko());
            }
        });

        Button brickBreakerButton = new Button("Brick Breaker");
        brickBreakerButton.setLayoutX(50);
        brickBreakerButton.setLayoutY(350);
        brickBreakerButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t){
                player1.setMiniGameCount(player1.getMiniGameCount()+ 1);
                Stage plinkoStage = new Stage();
                try{
                new BrickBreaker().start(plinkoStage);
                }catch(Exception e){
                    e.printStackTrace();
                }
                //player1.addSpins(BrickBreaker.getScore());
            }
        });
        Button boardButton = new Button("Board");
        boardButton.setLayoutX(50);
        boardButton.setLayoutY(450);
        boardButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t){
                if (player1.getMiniGameCount() > 0){
                    Stage plinkoStage = new Stage();
                try{
                  new window2().start(plinkoStage);
                }catch(Exception e){
                  e.printStackTrace();
                }
                }
            }
        });

        Button snakeButton = new Button("Snake");
        snakeButton.setLayoutX(50);
        snakeButton.setLayoutY(400);
        snakeButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t){
                player1.setMiniGameCount(player1.getMiniGameCount()+ 1);
                Stage snakeStage = new Stage();
                try{
                  new SnakeMain().start(snakeStage);
                }catch(Exception e){
                  e.printStackTrace();
                }
                
            }
        });

        Button endGameButton = new Button("Save and Exit");
        endGameButton.setLayoutX(50);
        endGameButton.setLayoutY(50);
        endGameButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent a){
                primaryStage.close();
                FileIO.write(player1.getName(), player1.getScore(), player1.getSpins());

            }
        });

        Button loadButton = new Button("Load Game");
        loadButton.setLayoutX(300);
        loadButton.setLayoutY(300);
        loadButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent a){
                //primaryStage.close();
                //FileIO.write(player1.getName(), player1.getScore(), player1.getSpins());

            }
        });

        root.getChildren().add(brickBreakerButton);
        root.getChildren().add(plinkoButton);
        root.getChildren().add(boardButton);
        root.getChildren().add(snakeButton);
        root.getChildren().add(highScores);
        root.getChildren().add(nameOfGame);
        root.getChildren().add(playerName);
        root.getChildren().add(displaySpins);
        root.getChildren().add(endGameButton);
        root.getChildren().add(loadButton);


        primaryStage.setTitle("Stunning Luck");
        primaryStage.setScene(scene);
        primaryStage.show();
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(30), 
            new EventHandler<ActionEvent>(){
                public void handle(ActionEvent p){
                    displaySpins.setText("You've earned " + player1.getSpins() + " spins so far!");
                }
            }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        
    }
    public static void main(String[] args){

        launch(args);

    }
}
