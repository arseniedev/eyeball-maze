package nz.ac.ara.ads.eyeballmaze.model.data;

import java.util.List;

import nz.ac.ara.ads.eyeballmaze.enums.Direction;
import nz.ac.ara.ads.eyeballmaze.model.classes.PlayableSquare;

public record LevelData(
        int levelNumber,
        int levelHeight,
        int levelWidth,
        int totalGoalCount,
        Direction eyeBallDirection,
        List<PlayableSquare> squares
) {}
