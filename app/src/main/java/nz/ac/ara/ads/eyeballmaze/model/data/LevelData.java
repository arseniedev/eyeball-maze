package nz.ac.ara.ads.eyeballmaze.model.data;

import java.util.List;

import nz.ac.ara.ads.eyeballmaze.enums.Direction;
import nz.ac.ara.ads.eyeballmaze.model.classes.PlayableSquare;
import nz.ac.ara.ads.eyeballmaze.model.classes.Position;

public record LevelData(
        int levelNumber,
        int totalGoalCount,
        Position startingPosition,
        Direction eyeBallDirection,
        List<PlayableSquare> squares
) {}
