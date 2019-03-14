import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class MainMethod extends Application{
    private Player player1 = new Player("John Doe");

    public void start(Stage primaryStage){

        Pane root = new Pane();
        Scene scene = new Scene(root, 600, 600);

        Label nameOfGame = new Label("Stunning Luck");
        nameOfGame.setFont(new Font("Cambria",40));
        nameOfGame.setTextFill(Color.GREEN);
        nameOfGame.setLayoutX(100);
        nameOfGame.setLayoutY(75);

        Button plinkoButton = new Button("Plinko");
        plinkoButton.setLayoutX(50);
        plinkoButton.setLayoutY(300);
        plinkoButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t){
                Stage plinkoStage = new Stage();
                new PlinkoGui().start(plinkoStage);
                player1.addSpins(PlinkoGui.getSpinsFromPlinko());
            }
        });
        Button brickBreakerButton = new Button("Brick Breaker");
        brickBreakerButton.setLayoutX(150);
        brickBreakerButton.setLayoutY(300);
        brickBreakerButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t){
                Stage plinkoStage = new Stage();
                try{
                new BrickBreaker().start(plinkoStage);
                }catch(Exception e){
                    e.printStackTrace();
                }
                player1.addSpins(BrickBreaker.getScore());
            }
        });
        Button boardButton = new Button("Board");
        boardButton.setLayoutX(350);
        boardButton.setLayoutY(300);
        boardButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t){
                Stage plinkoStage = new Stage();
                try{
                  new window2().start(plinkoStage);
                }catch(Exception e){
                  e.printStackTrace();
                }

                //player1.addSpins(PlinkoGui.getSpinsFromPlinko());
            }
        });

        root.getChildren().add(brickBreakerButton);
        root.getChildren().add(plinkoButton);
        root.getChildren().add(boardButton);
        root.getChildren().add(nameOfGame);



        primaryStage.setTitle("Stunning Luck");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args){

        launch(args);

    }
}
