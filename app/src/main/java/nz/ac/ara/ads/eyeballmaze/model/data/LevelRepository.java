package nz.ac.ara.ads.eyeballmaze.model.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import nz.ac.ara.ads.eyeballmaze.enums.Color;
import nz.ac.ara.ads.eyeballmaze.enums.Shape;
import nz.ac.ara.ads.eyeballmaze.model.classes.PlayableSquare;

public class LevelRepository {

    public static final Map<String, LevelData> LEVELS = new HashMap<>();

    static {
        // Squares for level 1
        List<PlayableSquare> squaresForLevel1 = new ArrayList<>();
        squaresForLevel1.add(new PlayableSquare(0, 0, Color.RED, Shape.STAR, true));
        squaresForLevel1.add(new PlayableSquare(1, 1, Color.GREEN, Shape.FLOWER, false));

        LEVELS.put("level1", new LevelData(
                1,
                16,
                17,
                1,
                squaresForLevel1
        ));

        // Squares for level 2
        List<PlayableSquare> squaresForLevel2 = new ArrayList<>();
        squaresForLevel2.add(new PlayableSquare(5, 1, Color.GREEN, Shape.DIAMOND, false));
        squaresForLevel2.add(new PlayableSquare(1, 1, Color.BLUE, Shape.CROSS, true));
        squaresForLevel2.add(new PlayableSquare(1, 2, Color.BLUE, Shape.STAR, false));
        squaresForLevel2.add(new PlayableSquare(3, 4, Color.RED, Shape.DIAMOND, true));
        squaresForLevel2.add(new PlayableSquare(6, 2, Color.RED, Shape.FLOWER, false));

        LEVELS.put("level2", new LevelData(
                2,
                16,
                17,
                3,
                squaresForLevel2
        ));
    }
}