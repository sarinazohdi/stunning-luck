package shooter;

public class Player extends Ship {

    protected int kills;

    public Player(float x, float y, float velocity, int kills) {
        super(x, y, velocity);
        this.kills = kills;
    }


}