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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainMethod extends Application{
    public static Player player1 = new Player("John Doe");
    private int namesInputCount = 0;
    private Label name = new Label(player1.getName());

    public void start(Stage primaryStage){
//images on board
      Image image = new Image("Capture.png");
      ImageView imgView = new ImageView(image);
      imgView.setX(655);
      imgView.setY(400);
      imgView.setFitHeight(50);
      imgView.setFitWidth(100);


      Image image2 = new Image("Capture2.png");
      ImageView imgView2 = new ImageView(image2);
      imgView2.setX(390);
      imgView2.setY(400);
      imgView2.setFitHeight(80);
      imgView2.setFitWidth(100);


      Image image3 = new Image("Capture3.png");
      ImageView imgView3 = new ImageView(image3);
      imgView3.setX(160);
      imgView3.setY(400);
      imgView3.setFitHeight(80);
      imgView3.setFitWidth(100);

      Image image4 = new Image("Capture4.png");
      ImageView imgView4 = new ImageView(image4);
      imgView4.setX(445);
      imgView4.setY(700);
      imgView4.setFitHeight(80);
      imgView4.setFitWidth(100);

      Image image5 = new Image("Capture5.png");
      ImageView imgView5 = new ImageView(image5);
      imgView5.setX(520);
      imgView5.setY(750);
      imgView5.setFitHeight(80);
      imgView5.setFitWidth(100);

      Image image6 = new Image("Capture6.png");
      ImageView imgView6 = new ImageView(image6);
      imgView6.setX(370);
      imgView6.setY(750);
      imgView6.setFitHeight(80);
      imgView6.setFitWidth(100);


        Pane root = new Pane();
        root.setBackground(new Background(new BackgroundFill(Color.PINK, CornerRadii.EMPTY, Insets.EMPTY)));
        Scene scene = new Scene(root, 1000, 1000);
        root.getChildren().add(imgView);
        root.getChildren().add(imgView2);
        root.getChildren().add(imgView3);
        root.getChildren().add(imgView4);
        root.getChildren().add(imgView5);
        root.getChildren().add(imgView6);
        TextField playerName = new TextField("New player? Input name here!");
        playerName.setLayoutX(300);
        playerName.setLayoutY(250);
        playerName.setPrefWidth(225);
        playerName.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent n){
                if (namesInputCount < 1){
                    player1.setName(playerName.getText());
                    name.setText(player1.getName());
                }
                System.out.println(player1.getName());
                namesInputCount++;
            }
        });



        name.setFont(new Font("Tahoma",40));
        name.setTextFill(Color.BLACK);
        name.setLayoutX(700);
        name.setLayoutY(75);

        Label nameOfGame = new Label("Stunning Luck");
        nameOfGame.setFont(new Font("Tahoma",60));
        nameOfGame.setTextFill(Color.BLACK);
        nameOfGame.setLayoutX(200);
        nameOfGame.setLayoutY(75);


        Label highScores = new Label("High Scores");
        highScores.setFont(new Font("Tahoma", 30));
        highScores.setTextFill(Color.BLACK);
        highScores.setLayoutX(800);
        highScores.setLayoutY(30);

        Label displaySpins = new Label("You've earned " + player1.getSpins() + " spins so far!");
        displaySpins.setFont(new Font("Tahoma", 30));
        displaySpins.setTextFill(Color.BLACK);
        displaySpins.setLayoutX(350);
        displaySpins.setLayoutY(200);

        Button plinkoButton = new Button("     Plinko     ");
        plinkoButton.setLayoutX(166);
        plinkoButton.setLayoutY(500);
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
        brickBreakerButton.setLayoutX(400);
        brickBreakerButton.setLayoutY(500);
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
        Button boardButton = new Button("     Board     ");
        boardButton.setLayoutX(450);
        boardButton.setLayoutY(850);
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

        Button snakeButton = new Button("     Snake     ");
        snakeButton.setLayoutX(667);
        snakeButton.setLayoutY(500);
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
        Button loadGameButton = new Button("Load Game");
        loadGameButton.setLayoutX(300);
        loadGameButton.setLayoutY(300);
        loadGameButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent a){
                name.setText(player1.getName());
                player1.setName(FileIO.readName());
                player1.setSpins(Integer.parseInt(FileIO.readSpins()));
                player1.setScore(Integer.parseInt(FileIO.readScore()));
                name.setText(player1.getName());

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
        root.getChildren().add(loadGameButton);
        root.getChildren().add(name);

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
