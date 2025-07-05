package nz.ac.ara.ads.eyeballmaze.model.data;

import java.util.List;

import nz.ac.ara.ads.eyeballmaze.model.classes.PlayableSquare;

//public record LevelData(int level, int goals, List<PlayableSquare> squares) {}

public record LevelData(
        int levelNumber,
        int levelHeight,
        int levelWidth,
        int totalGoalCount,
        List<PlayableSquare> squares
) {}
