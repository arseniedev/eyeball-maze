package nz.ac.ara.ads.eyeball_maze.model.classes;

import nz.ac.ara.ads.eyeball_maze.enums.Color;
import nz.ac.ara.ads.eyeball_maze.enums.Shape;

public abstract class Square {
    public boolean isGoal;
    protected  Color color;
    protected Shape shape;
//    public Position position;

    public Square() {
        this.color = Color.BLANK;
        this.shape = Shape.BLANK;
//        this.position = new Position(0,0);
    }

//    public Square(Color color, Shape shape) {
//        this.color = color;
//        this.shape = shape;
//    }

//    public void setColor(Color color) {
//        this.color = color;
//    }
    public Color getColor() {
        return this.color;
    }

    public Shape getShape() {
        return this.shape;
    }

}
