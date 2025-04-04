package nz.ac.ara.ads.eyeball_maze.model.classes;

import nz.ac.ara.ads.eyeball_maze.enums.Shape;
import nz.ac.ara.ads.eyeball_maze.enums.Color;

public class PlayableSquare extends Square {
    protected Color color;
    protected Shape shape;
    public boolean isGoal = false;

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
