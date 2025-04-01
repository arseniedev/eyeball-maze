package nz.ac.ara.ads.eyeball_maze.model.classes;

import nz.ac.ara.ads.eyeball_maze.enums.*;
import java.util.Objects;

public record SquareData (Color color, Shape shape, Position position) {

    public SquareData {
        Objects.requireNonNull(color);
        Objects.requireNonNull(shape);
        Objects.requireNonNull(position);
    }

//    public SquareData (Color color, Shape shape, Position position) {
//        this(color, Color.RED);
//    }
//
//    public SquareData(Color color, Shape shape) {
//    }
}

