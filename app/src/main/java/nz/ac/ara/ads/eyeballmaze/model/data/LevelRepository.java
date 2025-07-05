package nz.ac.ara.ads.eyeballmaze.model.data;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import nz.ac.ara.ads.eyeballmaze.enums.Color;
import nz.ac.ara.ads.eyeballmaze.enums.Shape;
import nz.ac.ara.ads.eyeballmaze.model.classes.PlayableSquare;

public class LevelRepository {

    public static final Map<Integer, LevelData> LEVELS = new HashMap<>();

    static {
        LEVELS.put(1, new LevelData(
                1,
                6, // height
                7, // width
                List.of(
                        new PlayableSquare(3, 1, Color.RED, Shape.STAR, true),
                        new PlayableSquare(2, 3, Color.GREEN, Shape.FLOWER, false)
                )
        ));

        LEVELS.put(2, new LevelData(
                2,
                6, // height
                7, // width
                List.of(
                        new PlayableSquare(1, 1, Color.BLUE, Shape.CROSS, true),
                        new PlayableSquare(1, 2, Color.BLUE, Shape.STAR, false),
                        new PlayableSquare(5, 1, Color.GREEN, Shape.DIAMOND, false),
                        new PlayableSquare(3, 4, Color.RED, Shape.DIAMOND, true),
                        new PlayableSquare(0, 2, Color.RED, Shape.FLOWER, false)
                )
        ));
    }
}