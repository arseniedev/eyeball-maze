package nz.ac.ara.ads.eyeballmaze.model.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import nz.ac.ara.ads.eyeballmaze.enums.Color;
import nz.ac.ara.ads.eyeballmaze.enums.Direction;
import nz.ac.ara.ads.eyeballmaze.enums.Shape;
import nz.ac.ara.ads.eyeballmaze.model.classes.PlayableSquare;
import nz.ac.ara.ads.eyeballmaze.model.classes.Position;

public class LevelRepository {

    public static final Map<String, SquareData> LEVELS = new HashMap<>();

    public static final Map<String, List<SquareData>> RAW_LEVEL_DATA = new HashMap<>();

    static {
        RAW_LEVEL_DATA.put("level1", List.of(
                new SquareData(0, 0, Color.RED, Shape.FLOWER),
                new SquareData(0, 1, Color.YELLOW, Shape.CROSS),
                new SquareData(1, 0, Color.BLANK, Shape.BLANK) // ← blank square
        ));

        RAW_LEVEL_DATA.put("level2", List.of(
                new SquareData(0, 0, Color.BLUE, Shape.STAR),
                new SquareData(0, 1, Color.GREEN, Shape.CROSS)
        ));
    }
}