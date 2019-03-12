/**
* Reference code from:
<stratosonic/ SnakeGame> (GitHub)
**/

public class Food {
	Point location;

	public Food(int x, int y) {
		location = new Point(x, y);
	}

	public Point getLocation() {
		return location;
	}

	@Override
	public String toString() {
		return "Food [myLocation=" + location + "]";
	}

}
