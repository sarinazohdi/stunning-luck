import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.animation.Animation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;
/**
* The SnakeMain class uses javafx to recreate a simple snake game.
* Code referenced from:
* Title: JavaFX: Snake
* Author: Almas B.

* @author
* - Matthew Forman
* - Sarina Zohdi
* - Alexis Lee
* - Doug Comperen
* - Firoz Lakhani
*/

public class SnakeMain extends Application {

    /**A direction can be up, down, left, or right.*/
    public enum Direction {
      UP, DOWN, LEFT, RIGHT
    }

    public static final int RECT_SIZE = 30;
    public static final int WINDOW_W = 600;
    public static final int WINDOW_H = 450;

    /**The default direction is right.*/
    private Direction direction = Direction.RIGHT;

    private boolean moved = false;
    private boolean running = false;

    private Timeline timeline;

    /** list to keep track of the snake location and movements. */
    private ObservableList<Node> snake;

    private Parent createContent(Stage primaryStage) {
      Pane root = new Pane();
      root.setPrefSize(WINDOW_W, WINDOW_H);

      Group snakeB = new Group();

      /** Assign children from snakeB Group to the snake list. */
      snake = snakeB.getChildren();

      /** Food graphics. */
      Image image = new Image("Apple.png");
      ImageView food = new ImageView(image);
      food.setFitHeight(30);
      food.setFitWidth(30);


      /** Locate food at a random point on the screen. */
      food.setTranslateX((int)(Math.random() * (WINDOW_W - RECT_SIZE)) / RECT_SIZE * RECT_SIZE);
      food.setTranslateY((int)(Math.random() * (WINDOW_H - RECT_SIZE)) / RECT_SIZE * RECT_SIZE);

      /** Lower the duration value to increase the difficulty of the game; snake will move faster. */

      timeline = new Timeline(new KeyFrame(Duration.seconds(0.3), event -> {
        if(!running)
          return;

        /** Check if food has been added. */
        boolean toRemove = snake.size() > 1;

        /** If condition toRemove is true, remove the last element(tail) from snake list. This will make the tail become the head. Else, everything remains the same. */
        Node tail = toRemove ? snake.remove(snake.size() - 1) : snake.get(0);

        double xTail = tail.getTranslateX();
        double yTail = tail.getTranslateY();

        /** There are four cases (one for each direction). */
        switch(direction) {
          case UP:
            tail.setTranslateX(snake.get(0).getTranslateX());
            tail.setTranslateY(snake.get(0).getTranslateY() - RECT_SIZE);
            break;
          case DOWN:
            tail.setTranslateX(snake.get(0).getTranslateX());
            tail.setTranslateY(snake.get(0).getTranslateY() + RECT_SIZE);
            break;
          case LEFT:
            tail.setTranslateX(snake.get(0).getTranslateX() - RECT_SIZE);
            tail.setTranslateY(snake.get(0).getTranslateY());
            break;
          case RIGHT:
            tail.setTranslateX(snake.get(0).getTranslateX() + RECT_SIZE);
            tail.setTranslateY(snake.get(0).getTranslateY());
            break;
        }

        moved = true;



        /** Since we removed one block, add one block back. */
        if(toRemove)
          snake.add(0, tail);

        /** Collision detection - its own body. REMEMBER: TAIL HERE MEANS HEAD. Restart game if condition is true.*/
        for (Node rect : snake) {
          if(rect != tail && tail.getTranslateX() == rect.getTranslateX() && tail.getTranslateY() == rect.getTranslateY()) {
            timeline.stop();
            break;
          }
        }

        /** Collision detection - walls. Restart game condition is true. */
        if(tail.getTranslateX() < 0 || tail.getTranslateX() >= WINDOW_W || tail.getTranslateY() < 0 || tail.getTranslateY() >= WINDOW_H) {
          timeline.stop();
        }

        /** Check if the snake hits food. ("tail" (head) coordinates = food coordinates) */
        if(tail.getTranslateX() == food.getTranslateX() && tail.getTranslateY() == food.getTranslateY()){

          /** Add new food. */
          food.setTranslateX((int)(Math.random() * (WINDOW_W - RECT_SIZE)) / RECT_SIZE * RECT_SIZE);
          food.setTranslateY((int)(Math.random() * (WINDOW_H - RECT_SIZE)) / RECT_SIZE * RECT_SIZE);
          Rectangle rect = new Rectangle(RECT_SIZE, RECT_SIZE);
          rect.setFill(Color.BLUE);

          /** Add food to snake. */
          rect.setTranslateX(xTail);
          rect.setTranslateY(yTail);
          MainMethod.player1.addSpins(1);
          snake.add(rect);

        }

        if (timeline.getStatus() == Animation.Status.STOPPED) {
          /** Gameover screen. Displays the score. */
          Pane rootG = new Pane();
          Label message = new Label("Game over");
          message.setLayoutX(100);
          message.setLayoutY(100);

          Image image2 = new Image("sadsnake.png");
          ImageView snakepic = new ImageView(image2);
          snakepic.setLayoutX(110);
          snakepic.setLayoutY(30);
          snakepic.setFitHeight(70);
          snakepic.setFitWidth(70);

          Label spins = new Label("You've earned this many spins: " + Integer.toString(snake.size() - 1));
          spins.setLayoutX(75);
          spins.setLayoutY(150);

          Button mainMenu = new Button("Main Menu");
          mainMenu.setLayoutX(100);
          mainMenu.setLayoutY(225);
          mainMenu.setOnAction(new EventHandler<ActionEvent>(){
              public void handle(ActionEvent a){
                  primaryStage.close();
              }
          });
          rootG.getChildren().add(snakepic);
          rootG.getChildren().add(message);
          rootG.getChildren().add(spins);
          rootG.getChildren().add(mainMenu);
          Scene gameOver = new Scene(rootG,300,300);
          primaryStage.setScene(gameOver);
        }
      }));
      timeline.setCycleCount(Timeline.INDEFINITE);

      Image bimage = new Image("snakebackground.png");
      BackgroundSize size = new BackgroundSize(600, 450, false, false, false, false);
      BackgroundImage backgroundimage = new BackgroundImage(bimage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, size);
      Background background = new Background(backgroundimage);
      root.setBackground(background);

      root.getChildren().add(food);
      root.getChildren().add(snakeB);
      return root;
    }

    /** Private method to start the game. */
    private void startGame() {
      /** Default direction; snake will start running right. */
      direction = Direction.RIGHT;
      Rectangle head = new Rectangle(RECT_SIZE, RECT_SIZE);
      head.setFill(Color.BLUE);
      snake.add(head);
      timeline.play();
      running = true;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
      Scene scene = new Scene(createContent(primaryStage));

      scene.setOnKeyPressed(event -> {
        if(!moved)
          return;

        switch (event.getCode()) {
          case UP:
            if (direction != Direction.DOWN)
              direction = Direction.UP;
              break;
          case DOWN:
            if (direction != Direction.UP)
                direction = Direction.DOWN;
              break;
           case LEFT:
            if (direction != Direction.RIGHT)
                  direction = Direction.LEFT;
                break;
            case RIGHT:
              if (direction != Direction.LEFT)
                  direction = Direction.RIGHT;
                break;

            case P:
            if (timeline != null)
            timeline.pause();

            Stage pauseStage = new Stage();
            pause(pauseStage, primaryStage);

        }

        moved = false;
      });



      /* Button to end the game. */
      Button endGame = new Button("End Game");
      endGame.setLayoutX(100);
      endGame.setLayoutY(100);

      primaryStage.setTitle("Snake Game");
      primaryStage.setScene(scene);
      primaryStage.show();
      startGame();
    }

    public void pause(Stage pauseStage, Stage primaryStage){
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

        Button endGameButton = new Button("Main Menu");
        endGameButton.setLayoutX(150);
        endGameButton.setLayoutY(100);
        endGameButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent a){
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

    public static void main(String[] args){
      launch(args);
    }
}
