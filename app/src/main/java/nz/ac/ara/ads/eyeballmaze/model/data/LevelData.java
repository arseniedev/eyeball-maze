package nz.ac.ara.ads.eyeballmaze.model.data;
import java.util.List;
import nz.ac.ara.ads.eyeballmaze.model.classes.Position;

public record LevelData(
        List<SquareData> squares,
        Position eyeballPosition,
        int targetGoalCount
) {}
