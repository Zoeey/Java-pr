package model;


public class Field {
    int Width;
    int Height;


    public Field(int x,int y){
        Width = x;
        Height = y;
    }

    @Override
    public String toString() {
        return "Field w="+ Width +" h=" + Height;
    }
}
