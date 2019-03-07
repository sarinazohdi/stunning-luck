package shooter;
import java.lang.Math.*;

public class Ship {

    protected float x;
    protected float y;
    protected float velocity;


    public Ship(float x, float y, float velocity) {
        this.x = x;
        this.y = y;
        this.velocity = velocity;

    }

    public float getX() {
        return this.x;

    }

    public float getY() {
        return this.y;

    }

    public double distance(Ship player) {
        return Math.sqrt((player.getX() - this.getX())*(player.getX() - this.getX()) + (player.getY() - this.getY())*(player.getY() - this.getY()));

    }

    public double getAngle(Ship player) {
        return Math.atan2((player.getY() - this.getY()), (player.getX() - this.x));

    }

}