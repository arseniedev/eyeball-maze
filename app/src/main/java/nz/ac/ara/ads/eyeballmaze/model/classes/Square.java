package nz.ac.ara.ads.eyeballmaze.model.classes;

import nz.ac.ara.ads.eyeballmaze.enums.Color;
import nz.ac.ara.ads.eyeballmaze.enums.Shape;
import nz.ac.ara.ads.eyeballmaze.model.data.LevelData;
import nz.ac.ara.ads.eyeballmaze.model.data.LevelRepository;

public abstract class Square {
    public boolean isGoal;
    protected  Color color;
    protected Shape shape;
    public int row;
    public int col;
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

    public int[] getCoordinates() {
        return new int[] { this.row, this.col };
    }

    public abstract boolean isCurrent();
}