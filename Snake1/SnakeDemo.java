import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SnakeDemo extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

  private Grid grid;
  private GraphicsContext graphicsContext;
  private static final int WINDOW_HEIGHT = 800;
	private static final int WINDOW_WIDTH = 800;
	private static final int PIXEL_SIZE = 20;

  @Override
	public void start(Stage primaryStage) throws Exception {
    graphicsContext.setFill(Color.WHITE);
		graphicsContext.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
    graphicsContext.setStroke(Color.GRAY);
    graphicsContext.setLineWidth(0.5);

    for (int x = 0; x < WINDOW_WIDTH; x += GRID_BLOCK_SIZE) {
    	graphicsContext.strokeLine(x, 0, x, x + WINDOW_HEIGHT);
    }

    for (int y = 0; y < WINDOW_HEIGHT; y += GRID_BLOCK_SIZE) {
    	graphicsContext.strokeLine(0, y, y + WINDOW_WIDTH, y);
    }

    primaryStage.setTitle("Snake");
		Group root = new Group();
		Canvas canvas = new Canvas(WINDOW_WIDTH, WINDOW_HEIGHT);
		graphicsContext = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		Scene scene = new Scene(root);
}
