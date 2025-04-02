package nz.ac.ara.ads.eyeball_maze.model.classes;

import nz.ac.ara.ads.eyeball_maze.enums.*;
import java.util.Objects;

public record SquareData (Color color, Shape shape, Position position) {

    public SquareData {
//        Shape sqShape;
//        Color sqColor;

        Objects.requireNonNull(position, "Position cannot be null");

//        if (color == null) {
//            color = Color.BLANK;
//        }
//        if (shape == null) {
//            shape = Shape.BLANK;
//        }
    }
}

