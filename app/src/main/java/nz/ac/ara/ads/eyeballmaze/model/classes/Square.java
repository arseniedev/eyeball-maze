package nz.ac.ara.ads.eyeballmaze.model.classes;

import nz.ac.ara.ads.eyeballmaze.enums.Color;
import nz.ac.ara.ads.eyeballmaze.enums.Shape;

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