package model;

/**
 * Created by Макс on 10.10.2016.
 */
public class SomeGreenThing extends Circle {

    static int radius = 25;

    public SomeGreenThing(int x,int y){
        x_coord=x;
        y_coord=y;
    }

    @Override
    public String toString() {
        return "SomeGreenThing at (" + x_coord + ',' + y_coord + ")";
    }
}
