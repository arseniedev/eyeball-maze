package nz.ac.ara.ads.eyeballmaze.model.classes;
import nz.ac.ara.ads.eyeballmaze.enums.Shape;
import nz.ac.ara.ads.eyeballmaze.enums.Color;
public class PlayableSquare extends Square {
    protected Color color;
    protected Shape shape;
    public PlayableSquare() {
    }
    public PlayableSquare(Color color, Shape shape) {
        this.color = color;
        this.shape = shape;
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