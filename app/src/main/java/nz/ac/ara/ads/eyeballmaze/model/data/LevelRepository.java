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
                        // Row 0
                        new SquareData(0, 0, Color.RED, Shape.DIAMOND),
                        new SquareData(0, 1, Color.YELLOW, Shape.STAR),
                        new SquareData(0, 2, Color.BLUE, Shape.FLOWER),
                        new SquareData(0, 3, Color.RED, Shape.CROSS),
                        new SquareData(0, 4, Color.RED, Shape.FLOWER),
                        new SquareData(0, 5, Color.BLUE, Shape.CROSS),

                        // Row 1
                        new SquareData(1, 0, Color.YELLOW, Shape.DIAMOND),
                        new SquareData(1, 1, Color.BLUE, Shape.FLOWER),
                        new SquareData(1, 2, Color.YELLOW, Shape.STAR),     // Goal
                        new SquareData(1, 3, Color.BLUE, Shape.STAR),
                        new SquareData(1, 4, Color.BLUE, Shape.CROSS),      // Goal
                        new SquareData(1, 5, Color.YELLOW, Shape.STAR),

                        // Row 2
                        new SquareData(2, 0, Color.RED, Shape.FLOWER),
                        new SquareData(2, 1, Color.BLUE, Shape.STAR),
                        new SquareData(2, 2, Color.BLUE, Shape.DIAMOND),
                        new SquareData(2, 3, Color.GREEN, Shape.FLOWER),
                        new SquareData(2, 4, Color.RED, Shape.CROSS),
                        new SquareData(2, 5, Color.YELLOW, Shape.DIAMOND),

                        // Row 3
                        new SquareData(3, 3, Color.RED, Shape.DIAMOND),     // Bridge/Goal center

                        // Row 4
                        new SquareData(4, 0, Color.BLUE, Shape.CROSS),
                        new SquareData(4, 1, Color.RED, Shape.DIAMOND),
                        new SquareData(4, 2, Color.GREEN, Shape.FLOWER),
                        new SquareData(4, 3, Color.GREEN, Shape.STAR),
                        new SquareData(4, 4, Color.YELLOW, Shape.STAR),
                        new SquareData(4, 5, Color.RED, Shape.DIAMOND),
                        new SquareData(4, 6, Color.GREEN, Shape.STAR),

                        // Row 5
                        new SquareData(5, 0, Color.YELLOW, Shape.CROSS),
                        new SquareData(5, 1, Color.BLUE, Shape.STAR),
                        new SquareData(5, 2, Color.YELLOW, Shape.DIAMOND),  // Goal
                        new SquareData(5, 3, Color.YELLOW, Shape.FLOWER),
                        new SquareData(5, 4, Color.RED, Shape.FLOWER),
                        new SquareData(5, 5, Color.GREEN, Shape.STAR),      // Goal
                        new SquareData(5, 6, Color.BLUE, Shape.CROSS),

                        // Row 6
                        new SquareData(6, 0, Color.RED, Shape.CROSS),
                        new SquareData(6, 1, Color.GREEN, Shape.DIAMOND),
                        new SquareData(6, 2, Color.BLUE, Shape.FLOWER),
                        new SquareData(6, 3, Color.YELLOW, Shape.DIAMOND),
                        new SquareData(6, 4, Color.BLUE, Shape.STAR),
                        new SquareData(6, 5, Color.YELLOW, Shape.DIAMOND),
                        new SquareData(6, 6, Color.BLUE, Shape.STAR),

                        // Row 7 (only one square)
                        new SquareData(7, 1, Color.YELLOW, Shape.STAR)      // Starting position
                ),
                Position.at(7, 1), // Eyeball starting position
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