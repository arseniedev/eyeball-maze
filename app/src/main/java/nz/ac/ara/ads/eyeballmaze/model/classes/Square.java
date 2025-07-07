package nz.ac.ara.ads.eyeballmaze.model.classes;

import nz.ac.ara.ads.eyeballmaze.enums.Color;
import nz.ac.ara.ads.eyeballmaze.enums.Shape;
//import nz.ac.ara.ads.eyeballmaze.model.data.LevelRepository;

public abstract class Square {

    protected  Color color;
    protected Shape shape;
//    protected final int[][] position;
    protected final Position position;
    public boolean isGoal;
    public Square(Position position, Color color, Shape shape) {
        this.position= position;
        this.color = color;
        this.shape = shape;
    }

    public Color getColor() {
        return this.color;
    }

    public Shape getShape() {
        return this.shape;
    }
    public int getRow() { return position.row(); }
    public int getCol() { return position.col(); }

//    public int[] getCoordinates() {
//        return new int[] { this.row, this.col };
//    }

    public abstract boolean isPlayable();
}