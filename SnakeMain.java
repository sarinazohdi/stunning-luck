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
/**
* The SnakeMain class uses javafx to recreate a simple snake game.
* Code referenced from:
* Title: JavaFX: Snake
* Author: Almas B.
*/

public class SnakeMain extends Application {

    //public int score1 = 0;

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

    private Timeline timeline = new Timeline();

    /** list to keep track of the snake location and movements. */
    private ObservableList<Node> snake;

    private Parent createContent() {
      Pane root = new Pane();
      root.setPrefSize(WINDOW_W, WINDOW_H);

      Group snakeB = new Group();

      /** Assign children from snakeB Group to the snake list. */
      snake = snakeB.getChildren();

      /** Food graphics. */
      Rectangle food = new Rectangle(RECT_SIZE, RECT_SIZE);
      food.setFill(Color.GREEN);

      /** Locate food at a random point on the screen. */
      food.setTranslateX((int)(Math.random() * (WINDOW_W - RECT_SIZE)) / RECT_SIZE * RECT_SIZE);
      food.setTranslateY((int)(Math.random() * (WINDOW_H - RECT_SIZE)) / RECT_SIZE * RECT_SIZE);

      /** Lower the duration value to increase the difficulty of the game; snake will move faster. */
      KeyFrame snakeframe = new KeyFrame(Duration.seconds(0.3), event -> {
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

        /** Gameover screen. Displays the score. */
        Pane rootG = new Pane();
        Label message = new Label("Game over");
        message.setLayoutX(100);
        message.setLayoutY(100);
        //public int fscore = snake.size() - 1;
        Label score = new Label("Your score is: " + Integer.toString(snake.size()));
        score.setLayoutX(100);
        score.setLayoutY(150);

        rootG.getChildren().add(message);
        rootG.getChildren().add(score);
        Scene gameOver = new Scene(rootG,300,300);

        /** Since we removed one block, add one block back. */
        if(toRemove)
          snake.add(0, tail);

        /** Collision detection - its own body. REMEMBER: TAIL HERE MEANS HEAD. Restart game if condition is true.*/
        for (Node rect : snake) {
          if(rect != tail && tail.getTranslateX() == rect.getTranslateX() && tail.getTranslateY() == rect.getTranslateY()) {
            //Scene = gameOver;
            stopGame();
            //primaryStage.setScene(gameOver);
            break;
          }
        }

        /** Collision detection - walls. Restart game condition is true. */
        if(tail.getTranslateX() < 0 || tail.getTranslateX() >= WINDOW_W || tail.getTranslateY() < 0 || tail.getTranslateY() >= WINDOW_H) {
          stopGame();
          //primaryStage.setScene(gameOver);
        }

        /** Check if the snake hits food. ("tail" (head) coordinates = food coordinates) */
        if(tail.getTranslateX() == food.getTranslateX() && tail.getTranslateY() == food.getTranslateY()){

          /** Add new food. */
          food.setTranslateX((int)(Math.random() * (WINDOW_W - RECT_SIZE)) / RECT_SIZE * RECT_SIZE);
          food.setTranslateY((int)(Math.random() * (WINDOW_H - RECT_SIZE)) / RECT_SIZE * RECT_SIZE);
          Rectangle rect = new Rectangle(RECT_SIZE, RECT_SIZE);

          /** Add food to snake. */
          rect.setTranslateX(xTail);
          rect.setTranslateY(yTail);
          snake.add(rect);
        }
      });

      timeline.getKeyFrames().add(snakeframe);
      timeline.setCycleCount(Timeline.INDEFINITE);

      root.getChildren().addAll(food, snakeB);
      return root;
    }

    /** Private method to stop the game.Displays the score after the game is over. */
    private void stopGame() {
      //private int score;
      running = false;
      timeline.stop();
      snake.clear();
    }
    /*
    public static int getScore(){
      return fscore;
    }
    */
    /** Private method to start the game. */
    private void startGame() {
      direction = Direction.RIGHT;
      Rectangle head = new Rectangle(RECT_SIZE, RECT_SIZE);
      snake.add(head);
      timeline.play();
      running = true;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
      Scene scene = new Scene(createContent());
      scene.setOnKeyPressed(event -> {
        if(!moved)
          return;

        switch (event.getCode()) {
          case W:
            if (direction != Direction.DOWN)
              direction = Direction.UP;
              break;
          case S:
            if (direction != Direction.UP)
                direction = Direction.DOWN;
              break;
           case A:
            if (direction != Direction.RIGHT)
                  direction = Direction.LEFT;
                break;
            case D:
              if (direction != Direction.LEFT)
                  direction = Direction.RIGHT;
                break;
        }
        moved = false;
      });

  /* Button to end the game. */
      Button endGame = new Button("End Game");
      endGame.setLayoutX(100);
      endGame.setLayoutY(100);
      //endGame.setOnAction(new EventHandler<ActionEvent>(){
        //running = false;
        //primaryStage.close();
      //}


      primaryStage.setTitle("Snake Game");
      primaryStage.setScene(scene);
      primaryStage.show();
      startGame();
    }

    public static void main(String[] args){
      launch(args);
    }
}
