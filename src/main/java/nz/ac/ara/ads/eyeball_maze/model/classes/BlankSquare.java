package nz.ac.ara.ads.eyeball_maze.model.classes;

import nz.ac.ara.ads.eyeball_maze.enums.Color;
import nz.ac.ara.ads.eyeball_maze.enums.Shape;

public class BlankSquare extends Square {
//    private final Color color;
//    private final Shape shape;

    public BlankSquare() {
        this.color = Color.BLANK;
        this.shape = Shape.BLANK;
    }
}
