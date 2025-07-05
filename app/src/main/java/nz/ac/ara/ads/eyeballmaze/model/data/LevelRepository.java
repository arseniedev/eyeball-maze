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
        squaresForLevel1.add(new PlayableSquare(0, 2, Color.RED, Shape.FLOWER, true));

        squaresForLevel1.add(new PlayableSquare(1, 0, Color.BLUE, Shape.CROSS, false));
        squaresForLevel1.add(new PlayableSquare(1, 1, Color.YELLOW, Shape.FLOWER, false));
        squaresForLevel1.add(new PlayableSquare(1, 2, Color.YELLOW, Shape.DIAMOND, false));
        squaresForLevel1.add(new PlayableSquare(1, 3, Color.GREEN, Shape.FLOWER, false));

        squaresForLevel1.add(new PlayableSquare(2, 0, Color.GREEN, Shape.FLOWER, false));
        squaresForLevel1.add(new PlayableSquare(2, 1, Color.RED, Shape.STAR, false));
        squaresForLevel1.add(new PlayableSquare(2, 2, Color.GREEN, Shape.STAR, false));
        squaresForLevel1.add(new PlayableSquare(2, 3, Color.YELLOW, Shape.DIAMOND, false));

        squaresForLevel1.add(new PlayableSquare(3, 0, Color.RED, Shape.FLOWER, false));
        squaresForLevel1.add(new PlayableSquare(3, 1, Color.BLUE, Shape.FLOWER, false));
        squaresForLevel1.add(new PlayableSquare(3, 2, Color.RED, Shape.STAR, false));
        squaresForLevel1.add(new PlayableSquare(3, 3, Color.GREEN, Shape.FLOWER, false));

        squaresForLevel1.add(new PlayableSquare(4, 0, Color.BLUE, Shape.STAR, false));
        squaresForLevel1.add(new PlayableSquare(4, 1, Color.RED, Shape.DIAMOND, false));
        squaresForLevel1.add(new PlayableSquare(4, 2, Color.BLUE, Shape.FLOWER, false));
        squaresForLevel1.add(new PlayableSquare(4, 3, Color.BLUE, Shape.DIAMOND, false));

        squaresForLevel1.add(new PlayableSquare(5, 1, Color.BLUE, Shape.DIAMOND, false));

        LEVELS.put("level1", new LevelData(
                1,
                16,
                17,
                1,
                squaresForLevel1
        ));

        // Squares for level 2
        List<PlayableSquare> squaresForLevel2 = new ArrayList<>();
        squaresForLevel2.add(new PlayableSquare(0, 2, Color.GREEN, Shape.FLOWER, true));

        squaresForLevel2.add(new PlayableSquare(1, 0, Color.BLUE, Shape.CROSS, false));
        squaresForLevel2.add(new PlayableSquare(1, 1, Color.BLUE, Shape.FLOWER, false));
        squaresForLevel2.add(new PlayableSquare(1, 2, Color.BLUE, Shape.DIAMOND, false));
        squaresForLevel2.add(new PlayableSquare(1, 3, Color.GREEN, Shape.CROSS, false));

        squaresForLevel2.add(new PlayableSquare(2, 0, Color.GREEN, Shape.FLOWER, false));
        squaresForLevel2.add(new PlayableSquare(2, 1, Color.RED, Shape.STAR, false));
        squaresForLevel2.add(new PlayableSquare(2, 2, Color.GREEN, Shape.STAR, false));
        squaresForLevel2.add(new PlayableSquare(2, 3, Color.YELLOW, Shape.FLOWER, false));

        squaresForLevel2.add(new PlayableSquare(3, 0, Color.RED, Shape.FLOWER, false));
        squaresForLevel2.add(new PlayableSquare(3, 1, Color.GREEN, Shape.DIAMOND, false));
        squaresForLevel2.add(new PlayableSquare(3, 2, Color.RED, Shape.STAR, false));
        squaresForLevel2.add(new PlayableSquare(3, 3, Color.YELLOW, Shape.STAR, false));

        squaresForLevel2.add(new PlayableSquare(4, 0, Color.GREEN, Shape.CROSS, false));
        squaresForLevel2.add(new PlayableSquare(4, 1, Color.RED, Shape.STAR, false));
        squaresForLevel2.add(new PlayableSquare(4, 2, Color.BLUE, Shape.FLOWER, false));
        squaresForLevel2.add(new PlayableSquare(4, 3, Color.GREEN, Shape.DIAMOND, false));

        squaresForLevel2.add(new PlayableSquare(5, 1, Color.BLUE, Shape.DIAMOND, false));

        LEVELS.put("level2", new LevelData(
                2,
                16,
                17,
                1,
                squaresForLevel2
        ));
    }
}