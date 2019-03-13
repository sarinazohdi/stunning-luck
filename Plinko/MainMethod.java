import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class MainMethod extends Application{
    private Player player1 = new Player("John Doe");

    public void start(Stage primaryStage){

        Pane root = new Pane();
        Scene scene = new Scene(root, 600, 600);

        Button plinkoButton = new Button("Plinko");
        plinkoButton.setLayoutX(50);
        plinkoButton.setLayoutY(300);
        plinkoButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t){
                Stage plinkoStage = new Stage();
                new PlinkoGui().start(plinkoStage);
                player1.setSpins(PlinkoGui.getSpinsFromPlinko());
            }
        });

        root.getChildren().add(plinkoButton);



        primaryStage.setTitle("Stunning Luck");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args){
        
        launch(args);
        
    }
}
