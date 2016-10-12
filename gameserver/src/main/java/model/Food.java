package model;

/**
 * Created by Макс on 10.10.2016.
 */
public class Food extends Circle {

    int weigth = 1;
    static int radius = 5;


    public Food(int x, int y){
        x_coord = x;
        y_coord = y;
    }

    @Override
    public String toString() {
        return "Food at (" + x_coord + ',' + y_coord + ")";
    }
}
