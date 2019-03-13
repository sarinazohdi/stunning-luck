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


public class window2 extends Application {

    public static final int GRID = 150;

    private  Rectangle highlighter = currentSelection(random());
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 900, 900, Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Stunning Luck");
        Board board = new Board();
        board.populateBoard();
        ArrayList<Square> randomBoard = board.RandomizeList(board.getList());
        

        root.getChildren().add(prizeBox(0, 0, GRID, GRID));
        root.getChildren().add(prizeBox(GRID, 0, GRID, GRID));
        root.getChildren().add(prizeBox(2 * GRID, 0, GRID, GRID));
        root.getChildren().add(prizeBox(3 * GRID, 0, GRID, GRID));
        root.getChildren().add(prizeBox(4 * GRID, 0, GRID, GRID));
        root.getChildren().add(prizeBox(5 * GRID, 0, GRID, GRID));
        root.getChildren().add(prizeBox(0, GRID, GRID, GRID));
        root.getChildren().add(prizeBox(0, 2 * GRID, GRID, GRID));
        root.getChildren().add(prizeBox(0, 3 * GRID, GRID, GRID));
        root.getChildren().add(prizeBox(0, 4 * GRID, GRID, GRID));
        root.getChildren().add(prizeBox(0, 5 * GRID, GRID, GRID));
        root.getChildren().add(prizeBox(5 * GRID, GRID, GRID, GRID));
        root.getChildren().add(prizeBox(5 * GRID, 2 * GRID, GRID, GRID));
        root.getChildren().add(prizeBox(5 * GRID, 3 * GRID, GRID, GRID));
        root.getChildren().add(prizeBox(5 * GRID, 4 * GRID, GRID, GRID));
        root.getChildren().add(prizeBox(5 * GRID, 5 * GRID, GRID, GRID));
        root.getChildren().add(prizeBox(1 * GRID, 5 * GRID, GRID, GRID));
        root.getChildren().add(prizeBox(2 * GRID, 5 * GRID, GRID, GRID));
        root.getChildren().add(prizeBox(3 * GRID, 5 * GRID, GRID, GRID));
        root.getChildren().add(prizeBox(4 * GRID, 5 * GRID, GRID, GRID));
        /* for (Square square: randomBoard){
            System.out.println(square.getTitle());
        } */
       
/*
        for(int i = 0; i<6;i++){
            Label label = new Label(randomBoard.get(i).getTitle());
            label.setTextFill(Color.WHITE);
            label.setAlignment(Pos.BASELINE_CENTER);
            label.setLayoutX((i+0.5)*GRID);
            label.setLayoutY((0.5*GRID));
            
            root.getChildren().add(label);

        } */

        root.getChildren().add(prizeBox(GRID, GRID, 4 *GRID, 4 *GRID));

        
        
        primaryStage.show();
       
        root.getChildren().add(highlighter);

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500),
        new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event){
                
                root.getChildren().remove(highlighter);
                highlighter = currentSelection(random());
                root.getChildren().add(highlighter);
                
            }

        }
        
        
        
        
        ));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        for(int i = 0; i<20;i++){
            Label label = new Label(randomBoard.get(i).getTitle());
            label.setTextFill(Color.WHITE);
            label.setAlignment(Pos.BASELINE_CENTER);
            if (i >=0 && i <= 5){
                label.setLayoutX((i+0.5)*GRID);
                label.setLayoutY((0.5*GRID));
            }
            else if (i >= 6 && i <= 9) {
                label.setLayoutX(0.5*GRID);
                label.setLayoutY((i - 5 + 0.5) * GRID);
            }
            else if (i >= 10 && i <= 13) {
                label.setLayoutX(5.5*GRID);
                label.setLayoutY((i - 9 + 0.5) * GRID);
            }
            else if (i >= 14 && i < 20) {
                label.setLayoutX((i - 14 + 0.5) *GRID);
                label.setLayoutY(5.5 * GRID);
            }
            
            root.getChildren().add(label);

        }

    }

    public Rectangle prizeBox(int x, int y, int width, int height){
        Rectangle prize = new Rectangle(x, y, width, height);
        prize.setStrokeType(StrokeType.INSIDE);
        prize.setStroke(Color.web("white", 1));
        prize.setStrokeWidth(2);

        return prize;

    }

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
            x = 5 * GRID;
            y = GRID;

        }
        else if (choice == 8) {
            x = 0;
            y = 2 * GRID;

        }
        else if (choice == 9) {
            x = 5 * GRID;
            y = 2 * GRID;

        }
        else if (choice == 10) {
            x = 0;
            y = 3 * GRID;

        }
        else if (choice == 11) {
            x = 5 * GRID;
            y = 3 * GRID;

        }
        else if (choice == 12) {
            x = 0;
            y = 4 * GRID;

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
        selection.setStrokeWidth(6);

        return selection;
    }

    public int random(){
        Random r = new Random();
        return r.nextInt(20);


    }

    





}

