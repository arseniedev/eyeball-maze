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

    public static final Map<String, LevelData> LEVELS = new HashMap<>();

    static {
        LEVELS.put("level1", new LevelData(
                List.of(
                        new SquareData(0, 0, Color.RED, Shape.FLOWER),
                        new SquareData(0, 1, Color.YELLOW, Shape.CROSS),
                        new SquareData(1, 0, Color.BLANK, Shape.BLANK)
                ),
                Position.at(0, 0), // Eyeball starting position
                5                  // Goal count
        ));

        LEVELS.put("level2", new LevelData(
                List.of(
                        new SquareData(0, 0, Color.BLUE, Shape.STAR),
                        new SquareData(0, 1, Color.GREEN, Shape.CROSS)
                ),
                Position.at(0, 1),
                2
        ));
    }
}