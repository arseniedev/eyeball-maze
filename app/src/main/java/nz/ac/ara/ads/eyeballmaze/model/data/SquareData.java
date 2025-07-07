package nz.ac.ara.ads.eyeballmaze.model.data;

import nz.ac.ara.ads.eyeballmaze.enums.Color;
import nz.ac.ara.ads.eyeballmaze.enums.Shape;

//public record LevelData(
//        int totalGoalCount,
//        Position startingPosition,
//        Position position,
//        Direction eyeBallDirection,
//        List<PlayableSquare> squares
//) {}

public record SquareData(
        int row,
        int column,
        Color color,
        Shape shape
) {
}