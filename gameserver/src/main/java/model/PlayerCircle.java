package model;

/**
 * Created by Макс on 11.10.2016.
 */
public class PlayerCircle extends Circle {

    int weigth;
    int radius;
    Player owner;

    public PlayerCircle(int x, int y, Player player) {
        x_coord = x;
        y_coord = y;
        owner = player;
        weigth = GameConstants.START_PLAYER_WEIGTH;
    }

    @Override
    public String toString() {
        return "Circle of " + owner.name() + " at (" + x_coord + ',' + y_coord + ")";
    }
}
