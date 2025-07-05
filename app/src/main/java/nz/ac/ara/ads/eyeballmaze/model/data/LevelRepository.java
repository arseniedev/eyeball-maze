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
        squaresForLevel2.add(new PlayableSquare(0, 2, Color.GREEN, Shape.CROSS, true));

        squaresForLevel2.add(new PlayableSquare(1, 0, Color.RED, Shape.CROSS, false));
        squaresForLevel2.add(new PlayableSquare(1, 1, Color.RED, Shape.STAR, false));
        squaresForLevel2.add(new PlayableSquare(1, 2, Color.YELLOW, Shape.DIAMOND, false));
        squaresForLevel2.add(new PlayableSquare(1, 3, Color.BLUE, Shape.DIAMOND, false));
        squaresForLevel2.add(new PlayableSquare(1, 4, Color.RED, Shape.DIAMOND, false));
        squaresForLevel2.add(new PlayableSquare(1, 5, Color.YELLOW, Shape.STAR, false));

        squaresForLevel2.add(new PlayableSquare(2, 0, Color.YELLOW, Shape.STAR, false));
        squaresForLevel2.add(new PlayableSquare(2, 1, Color.YELLOW, Shape.DIAMOND, false));
        squaresForLevel2.add(new PlayableSquare(2, 2, Color.RED, Shape.STAR, false));
        squaresForLevel2.add(new PlayableSquare(2, 3, Color.GREEN, Shape.CROSS, false));
        squaresForLevel2.add(new PlayableSquare(2, 4, Color.GREEN, Shape.STAR, false));
        squaresForLevel2.add(new PlayableSquare(2, 5, Color.GREEN, Shape.FLOWER, false));

        squaresForLevel2.add(new PlayableSquare(3, 0, Color.RED, Shape.FLOWER, false));
        squaresForLevel2.add(new PlayableSquare(3, 1, Color.RED, Shape.CROSS, false));
        squaresForLevel2.add(new PlayableSquare(3, 2, Color.GREEN, Shape.STAR, false));
        squaresForLevel2.add(new PlayableSquare(3, 3, Color.BLUE, Shape.FLOWER, false));
        squaresForLevel2.add(new PlayableSquare(3, 4, Color.YELLOW, Shape.DIAMOND, false));
        squaresForLevel2.add(new PlayableSquare(3, 5, Color.YELLOW, Shape.CROSS, false));

        squaresForLevel2.add(new PlayableSquare(4, 0, Color.GREEN, Shape.STAR, false));
        squaresForLevel2.add(new PlayableSquare(4, 1, Color.RED, Shape.DIAMOND, false));
        squaresForLevel2.add(new PlayableSquare(4, 2, Color.YELLOW, Shape.CROSS, false));
        squaresForLevel2.add(new PlayableSquare(4, 3, Color.YELLOW, Shape.DIAMOND, false));
        squaresForLevel2.add(new PlayableSquare(4, 4, Color.GREEN, Shape.FLOWER, false));
        squaresForLevel2.add(new PlayableSquare(4, 5, Color.BLUE, Shape.FLOWER, false));

        squaresForLevel2.add(new PlayableSquare(5, 1, Color.YELLOW, Shape.FLOWER, false));

        LEVELS.put("level2", new LevelData(
                2,
                16,
                17,
                1,
                squaresForLevel2
        ));


        // Squares for level 3
        List<PlayableSquare> squaresForLevel3 = new ArrayList<>();
// Row 0
        squaresForLevel3.add(new PlayableSquare(0, 0, Color.GREEN, Shape.STAR, false));
        squaresForLevel3.add(new PlayableSquare(0, 1, Color.RED, Shape.FLOWER, false));
        squaresForLevel3.add(new PlayableSquare(0, 2, Color.GREEN, Shape.CROSS, false));
        squaresForLevel3.add(new PlayableSquare(0, 4, Color.YELLOW, Shape.STAR, false));
        squaresForLevel3.add(new PlayableSquare(0, 5, Color.YELLOW, Shape.FLOWER, false));
        squaresForLevel3.add(new PlayableSquare(0, 6, Color.BLUE, Shape.STAR, false));
// Row 1
        squaresForLevel3.add(new PlayableSquare(1, 0, Color.RED, Shape.CROSS, false));
        squaresForLevel3.add(new PlayableSquare(1, 1, Color.YELLOW, Shape.STAR, false));
        squaresForLevel3.add(new PlayableSquare(1, 2, Color.YELLOW, Shape.DIAMOND, false));
        squaresForLevel3.add(new PlayableSquare(1, 4, Color.GREEN, Shape.DIAMOND, false));
        squaresForLevel3.add(new PlayableSquare(1, 5, Color.BLUE, Shape.STAR, false));
        squaresForLevel3.add(new PlayableSquare(1, 6, Color.YELLOW, Shape.FLOWER, false));

// Row 2
        squaresForLevel3.add(new PlayableSquare(2, 0, Color.RED, Shape.FLOWER, false));
        squaresForLevel3.add(new PlayableSquare(2, 1, Color.RED, Shape.DIAMOND, false));
        squaresForLevel3.add(new PlayableSquare(2, 2, Color.BLUE, Shape.STAR, false));
        squaresForLevel3.add(new PlayableSquare(2, 3, Color.BLUE, Shape.FLOWER, false));
        squaresForLevel3.add(new PlayableSquare(2, 4, Color.BLUE, Shape.CROSS, false));
        squaresForLevel3.add(new PlayableSquare(2, 5, Color.YELLOW, Shape.DIAMOND, false));
        squaresForLevel3.add(new PlayableSquare(2, 6, Color.GREEN, Shape.STAR, false));

// Row 3
        squaresForLevel3.add(new PlayableSquare(3, 0, Color.GREEN, Shape.DIAMOND, false));
        squaresForLevel3.add(new PlayableSquare(3, 1, Color.RED, Shape.CROSS, false));
        squaresForLevel3.add(new PlayableSquare(3, 2, Color.YELLOW, Shape.FLOWER, false));
        squaresForLevel3.add(new PlayableSquare(3, 3, Color.BLUE, Shape.STAR, false));
        squaresForLevel3.add(new PlayableSquare(3, 4, Color.RED, Shape.FLOWER, false));
        squaresForLevel3.add(new PlayableSquare(3, 5, Color.YELLOW, Shape.DIAMOND, false));
        squaresForLevel3.add(new PlayableSquare(3, 6, Color.GREEN, Shape.STAR, false));

// Row 4
        squaresForLevel3.add(new PlayableSquare(4, 0, Color.BLUE, Shape.FLOWER, false));
        squaresForLevel3.add(new PlayableSquare(4, 1, Color.BLUE, Shape.CROSS, false));
        squaresForLevel3.add(new PlayableSquare(4, 2, Color.RED, Shape.DIAMOND, false));
        squaresForLevel3.add(new PlayableSquare(4, 3, Color.RED, Shape.CROSS, false));
        squaresForLevel3.add(new PlayableSquare(4, 4, Color.GREEN, Shape.FLOWER, false));
        squaresForLevel3.add(new PlayableSquare(4, 5, Color.GREEN, Shape.CROSS, false));
        squaresForLevel3.add(new PlayableSquare(4, 6, Color.RED, Shape.CROSS, false));


// Row 6
        squaresForLevel3.add(new PlayableSquare(5, 0, Color.BLUE, Shape.CROSS, false));
        squaresForLevel3.add(new PlayableSquare(5, 1, Color.RED, Shape.FLOWER, false));
        squaresForLevel3.add(new PlayableSquare(5, 2, Color.BLUE, Shape.DIAMOND, false));
        squaresForLevel3.add(new PlayableSquare(5, 4, Color.RED, Shape.CROSS, false));
        squaresForLevel3.add(new PlayableSquare(5, 5, Color.GREEN, Shape.FLOWER, false));
        squaresForLevel3.add(new PlayableSquare(5, 6, Color.BLUE, Shape.FLOWER, false));

// Row 7
        squaresForLevel3.add(new PlayableSquare(6, 0, Color.RED, Shape.FLOWER, false));
        squaresForLevel3.add(new PlayableSquare(6, 1, Color.RED, Shape.FLOWER, false));
        squaresForLevel3.add(new PlayableSquare(6, 2, Color.BLUE, Shape.CROSS, false));
        squaresForLevel3.add(new PlayableSquare(6, 4, Color.GREEN, Shape.STAR, false));
        squaresForLevel3.add(new PlayableSquare(6, 5, Color.YELLOW, Shape.CROSS, false));
        squaresForLevel3.add(new PlayableSquare(6, 6, Color.RED, Shape.STAR, false));

// Row 8 (bottom special tiles)
        squaresForLevel3.add(new PlayableSquare(7, 1, Color.GREEN, Shape.DIAMOND, false));
        squaresForLevel3.add(new PlayableSquare(7, 5, Color.GREEN, Shape.STAR, true)); // Goal

        LEVELS.put("level3", new LevelData(
                3,
                16,
                17,
                2,
                squaresForLevel3
        ));

        List<PlayableSquare> squaresForLevel4 = new ArrayList<>();
// Row 0
        squaresForLevel4.add(new PlayableSquare(0, 0, Color.RED, Shape.DIAMOND, false));
        squaresForLevel4.add(new PlayableSquare(0, 1, Color.YELLOW, Shape.STAR, false));
        squaresForLevel4.add(new PlayableSquare(0, 2, Color.BLUE, Shape.FLOWER, false));
        squaresForLevel4.add(new PlayableSquare(0, 3, Color.RED, Shape.CROSS, false));
        squaresForLevel4.add(new PlayableSquare(0, 4, Color.RED, Shape.FLOWER, false));
        squaresForLevel4.add(new PlayableSquare(0, 5, Color.BLUE, Shape.CROSS, false));

// Row 1
        squaresForLevel4.add(new PlayableSquare(1, 0, Color.YELLOW, Shape.DIAMOND, false));
        squaresForLevel4.add(new PlayableSquare(1, 1, Color.BLUE, Shape.FLOWER, false));
        squaresForLevel4.add(new PlayableSquare(1, 2, Color.YELLOW, Shape.STAR, true));  // Goal
        squaresForLevel4.add(new PlayableSquare(1, 3, Color.BLUE, Shape.STAR, false));
        squaresForLevel4.add(new PlayableSquare(1, 4, Color.BLUE, Shape.CROSS, true));  // Goal
        squaresForLevel4.add(new PlayableSquare(1, 5, Color.YELLOW, Shape.STAR, false));

// Row 2
        squaresForLevel4.add(new PlayableSquare(2, 0, Color.RED, Shape.FLOWER, false));
        squaresForLevel4.add(new PlayableSquare(2, 1, Color.BLUE, Shape.STAR, false));
        squaresForLevel4.add(new PlayableSquare(2, 2, Color.BLUE, Shape.DIAMOND, false));
        squaresForLevel4.add(new PlayableSquare(2, 3, Color.GREEN, Shape.FLOWER, false));
        squaresForLevel4.add(new PlayableSquare(2, 4, Color.RED, Shape.CROSS, false));
        squaresForLevel4.add(new PlayableSquare(2, 5, Color.YELLOW, Shape.DIAMOND, false));

// Row 3
        squaresForLevel4.add(new PlayableSquare(3, 3, Color.RED, Shape.DIAMOND, true)); // Bridge/Goal center

// Row 4
        squaresForLevel4.add(new PlayableSquare(4, 0, Color.BLUE, Shape.CROSS, false));
        squaresForLevel4.add(new PlayableSquare(4, 1, Color.RED, Shape.DIAMOND, false));
        squaresForLevel4.add(new PlayableSquare(4, 2, Color.GREEN, Shape.FLOWER, false));
        squaresForLevel4.add(new PlayableSquare(4, 3, Color.GREEN, Shape.STAR, false));
        squaresForLevel4.add(new PlayableSquare(4, 4, Color.YELLOW, Shape.STAR, false));
        squaresForLevel4.add(new PlayableSquare(4, 5, Color.RED, Shape.DIAMOND, false));
        squaresForLevel4.add(new PlayableSquare(4, 6, Color.GREEN, Shape.STAR, false));


// Row 5
        squaresForLevel4.add(new PlayableSquare(5, 0, Color.YELLOW, Shape.CROSS, false));
        squaresForLevel4.add(new PlayableSquare(5, 1, Color.BLUE, Shape.STAR, false));
        squaresForLevel4.add(new PlayableSquare(5, 2, Color.YELLOW, Shape.DIAMOND, true)); // Goal
        squaresForLevel4.add(new PlayableSquare(5, 3, Color.YELLOW, Shape.FLOWER, false));
        squaresForLevel4.add(new PlayableSquare(5, 4, Color.RED, Shape.FLOWER, true));
        squaresForLevel4.add(new PlayableSquare(5, 5, Color.BLUE, Shape.CROSS, false)); // Goal

// Row 6
        squaresForLevel4.add(new PlayableSquare(6, 0, Color.RED, Shape.CROSS, false));
        squaresForLevel4.add(new PlayableSquare(6, 1, Color.GREEN, Shape.DIAMOND, false));
        squaresForLevel4.add(new PlayableSquare(6, 2, Color.BLUE, Shape.FLOWER, false));
        squaresForLevel4.add(new PlayableSquare(6, 3, Color.YELLOW, Shape.DIAMOND, false));
        squaresForLevel4.add(new PlayableSquare(6, 4, Color.BLUE, Shape.STAR, false));

// Row 7 (bottom goal)
        squaresForLevel4.add(new PlayableSquare(7, 1, Color.YELLOW, Shape.STAR, false));  // Starting goal

        LEVELS.put("level4", new LevelData(
                4,
                16,
                17,
                5,
                squaresForLevel4
        ));
    }
}