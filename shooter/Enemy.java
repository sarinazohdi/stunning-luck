package shooter;

public class Enemy extends Ship {

    protected boolean passive;

    public Enemy(float x, float y, float velocity, boolean passive) {
        super(x, y, velocity);
        this.passive = passive;
    }

}