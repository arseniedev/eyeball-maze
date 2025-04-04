package nz.ac.ara.ads.eyeball_maze.model.classes;

import nz.ac.ara.ads.eyeball_maze.enums.Color;
import nz.ac.ara.ads.eyeball_maze.enums.Shape;

public abstract class Square {
    public boolean isGoal;
    protected  Color color;
    protected Shape shape;

    public Square() {
        this.color = Color.BLANK;
        this.shape = Shape.BLANK;
    }

    public Color getColor() {
        return this.color;
    }

    public Shape getShape() {
        return this.shape;
    }

}
