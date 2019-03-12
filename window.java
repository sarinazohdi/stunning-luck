import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font; 
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button; 




public class window extends Application {



    public static void main(String[] args) {
        makeboard();
        launch(args);
    }

    /* Create a BorderPane window as the main stage and call the TopVBox(), LeftVBox(), RightVBox(), CenterAnchorPane() and BottomHBox() methods
    to populate the top, center and bottom of the BorderPane with the elements built in the previously
    named methods */
@Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane root = new BorderPane();

        root.setTop(TopHBox());
        root.setCenter(CenterAnchorPane());
        root.setBottom(BottomHBox());
        root.setLeft(LeftVBox());
        root.setRight(RightSide());
       


        Scene scene = new Scene(root, 900, 900);
        primaryStage.setTitle("Stunning Luck");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    public static Arraylist<Square> makeboard() {
        Board prizeBoard = new Board();
        prizeBoard.populateBoard(); // populates the board with a bunch of squares
        ArrayList<Square> randomboard = prizeBoard.RandomizeList();

        return randomboard;
    }

    public Button prizebutton(int index){
        Button prizebutton = new Button(randomboard.get(index).getTitle());
        prizebutton.setPrefSize(150, 150);
        return prizebutton;
    }

    public HBox BottomHBox() {
        HBox bottom = new HBox();
        bottom.setAlignment(Pos.CENTER);
        bottom.setSpacing(5);

        Button prize15 = prizebutton(14);
        Button prize16 = prizebutton(15);
        Button prize17 = prizebutton(16);
        Button prize18 = prizebutton(17);
        Button prize19 = prizebutton(18);
        Button prize20 = prizebutton(19);

        bottom.getChildren().addAll(prize15, prize16, prize17, prize18, prize19, prize20);

        return bottom;

    }
    /* define a VBox containing the Account holder and balance labels
     to be placed in the top area of the BorderPane */
    public HBox TopHBox() {
        HBox top = new HBox();
        top.setAlignment(Pos.CENTER);
        top.setSpacing(5);

        Button prize1 = prizebutton(0);
        Button prize2 = prizebutton(1);
        Button prize3 = prizebutton(2);
        Button prize4 = prizebutton(3);
        Button prize5 = prizebutton(4);
        Button prize6 = prizebutton(5);
       

        top.getChildren().addAll(prize1, prize2, prize3, prize4, prize5, prize6);

        return top;

    }
    /* define an HBox containing the enter amount label and text field
     to be placed in the center area of the BorderPane */
    public AnchorPane CenterAnchorPane() {
        AnchorPane middle = new AnchorPane();
       
        middle.setPrefSize(600, 600);

        return middle;

    }

    public VBox LeftVBox() {
        VBox left = new VBox();
        left.setAlignment(Pos.CENTER);
        
        Button prize7 = prizebutton(6);
        Button prize8 = prizebutton(7);
        Button prize9 = prizebutton(8);
        Button prize10 = prizebutton(9);


        left.getChildren().add(prize7);
        left.getChildren().add(prize8);
        left.getChildren().add(prize9);
        left.getChildren().add(prize10);

        return left;

    }

    public VBox RightSide() {
        VBox right = new VBox();
        right.setAlignment(Pos.CENTER);
        
        Button prize11 = prizebutton(10);
        Button prize12 = prizebutton(11);
        Button prize13 = prizebutton(12);
        Button prize14 = prizebutton(13);


        right.getChildren().add(prize11);
        right.getChildren().add(prize12);
        right.getChildren().add(prize13);
        right.getChildren().add(prize14);

        return right;

    }

}