package nz.ac.ara.ads.eyeballmaze.model.classes;
import nz.ac.ara.ads.eyeballmaze.enums.Shape;
import nz.ac.ara.ads.eyeballmaze.enums.Color;
public class PlayableSquare extends Square {
    protected Color color;
    protected Shape shape;
    public PlayableSquare() {
        super();
    }
    public PlayableSquare(int row, int col, Color color, Shape shape, boolean isGoal) {
        this.row = row;
        this.col = col;
        this.color = color;
        this.shape = shape;
        this.isGoal = isGoal;
    }

    @Override
    public Color getColor() {
        return this.color;
    }
    @Override
    public Shape getShape() {
        return this.shape;
    }
}