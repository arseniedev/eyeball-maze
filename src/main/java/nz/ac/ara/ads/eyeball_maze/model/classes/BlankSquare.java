package nz.ac.ara.ads.eyeball_maze.model.classes;

import nz.ac.ara.ads.eyeball_maze.enums.Color;
import nz.ac.ara.ads.eyeball_maze.enums.Shape;

public class BlankSquare extends Square {
    protected final Color color = Color.BLANK;
    protected final Shape shape = Shape.BLANK;

    public BlankSquare() {
    }
}