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
        // Squares for level 1
        List<PlayableSquare> squaresForLevel1 = new ArrayList<>();
        squaresForLevel1.add(new PlayableSquare(new Position(0, 2), Color.RED, Shape.FLOWER));

        squaresForLevel1.add(new PlayableSquare(new Position(1, 0), Color.BLUE, Shape.CROSS));
        squaresForLevel1.add(new PlayableSquare(new Position(1, 1), Color.YELLOW, Shape.FLOWER));
        squaresForLevel1.add(new PlayableSquare(new Position(1, 2), Color.YELLOW, Shape.DIAMOND));
        squaresForLevel1.add(new PlayableSquare(new Position(1, 3), Color.GREEN, Shape.FLOWER));

        squaresForLevel1.add(new PlayableSquare(new Position(2, 0), Color.GREEN, Shape.FLOWER));
        squaresForLevel1.add(new PlayableSquare(new Position(2, 1), Color.RED, Shape.STAR));
        squaresForLevel1.add(new PlayableSquare(new Position(2, 2), Color.GREEN, Shape.STAR));
        squaresForLevel1.add(new PlayableSquare(new Position(2, 3), Color.YELLOW, Shape.DIAMOND));

        squaresForLevel1.add(new PlayableSquare(new Position(3, 0), Color.RED, Shape.FLOWER));
        squaresForLevel1.add(new PlayableSquare(new Position(3, 1), Color.BLUE, Shape.FLOWER));
        squaresForLevel1.add(new PlayableSquare(new Position(3, 2), Color.RED, Shape.STAR));
        squaresForLevel1.add(new PlayableSquare(new Position(3, 3), Color.GREEN, Shape.FLOWER));

        squaresForLevel1.add(new PlayableSquare(new Position(4, 0), Color.BLUE, Shape.STAR));
        squaresForLevel1.add(new PlayableSquare(new Position(4, 1), Color.RED, Shape.DIAMOND));
        squaresForLevel1.add(new PlayableSquare(new Position(4, 2), Color.BLUE, Shape.FLOWER));
        squaresForLevel1.add(new PlayableSquare(new Position(4, 3), Color.BLUE, Shape.DIAMOND));

        squaresForLevel1.add(new PlayableSquare(new Position(5, 1), Color.BLUE, Shape.DIAMOND));

        LEVELS.put("level1", new LevelData(
                1,
                16,
                Position.at(0,0),
                Direction.UP,
                squaresForLevel1
        ));

        // Squares for level 2
        List<PlayableSquare> squaresForLevel2 = new ArrayList<>();
        squaresForLevel2.add(new PlayableSquare(new Position(0, 2), Color.GREEN, Shape.CROSS));

        squaresForLevel2.add(new PlayableSquare(new Position(1, 0), Color.RED, Shape.CROSS));
        squaresForLevel2.add(new PlayableSquare(new Position(1, 1), Color.RED, Shape.STAR));
        squaresForLevel2.add(new PlayableSquare(new Position(1, 2), Color.YELLOW, Shape.DIAMOND));
        squaresForLevel2.add(new PlayableSquare(new Position(1, 3), Color.BLUE, Shape.DIAMOND));
        squaresForLevel2.add(new PlayableSquare(new Position(1, 4), Color.RED, Shape.DIAMOND));
        squaresForLevel2.add(new PlayableSquare(new Position(1, 5), Color.YELLOW, Shape.STAR));

        squaresForLevel2.add(new PlayableSquare(new Position(2, 0), Color.YELLOW, Shape.STAR));
        squaresForLevel2.add(new PlayableSquare(new Position(2, 1), Color.YELLOW, Shape.DIAMOND));
        squaresForLevel2.add(new PlayableSquare(new Position(2, 2), Color.RED, Shape.STAR));
        squaresForLevel2.add(new PlayableSquare(new Position(2, 3), Color.GREEN, Shape.CROSS));
        squaresForLevel2.add(new PlayableSquare(new Position(2, 4), Color.GREEN, Shape.STAR));
        squaresForLevel2.add(new PlayableSquare(new Position(2, 5), Color.GREEN, Shape.FLOWER));

        squaresForLevel2.add(new PlayableSquare(new Position(3, 0), Color.RED, Shape.FLOWER));
        squaresForLevel2.add(new PlayableSquare(new Position(3, 1), Color.RED, Shape.CROSS));
        squaresForLevel2.add(new PlayableSquare(new Position(3, 2), Color.GREEN, Shape.STAR));
        squaresForLevel2.add(new PlayableSquare(new Position(3, 3), Color.BLUE, Shape.FLOWER));
        squaresForLevel2.add(new PlayableSquare(new Position(3, 4), Color.YELLOW, Shape.DIAMOND));
        squaresForLevel2.add(new PlayableSquare(new Position(3, 5), Color.YELLOW, Shape.CROSS));

        squaresForLevel2.add(new PlayableSquare(new Position(4, 0), Color.GREEN, Shape.STAR));
        squaresForLevel2.add(new PlayableSquare(new Position(4, 1), Color.RED, Shape.DIAMOND));
        squaresForLevel2.add(new PlayableSquare(new Position(4, 2), Color.YELLOW, Shape.CROSS));
        squaresForLevel2.add(new PlayableSquare(new Position(4, 3), Color.YELLOW, Shape.DIAMOND));
        squaresForLevel2.add(new PlayableSquare(new Position(4, 4), Color.GREEN, Shape.FLOWER));
        squaresForLevel2.add(new PlayableSquare(new Position(4, 5), Color.BLUE, Shape.FLOWER));

        squaresForLevel2.add(new PlayableSquare(new Position(5, 1), Color.YELLOW, Shape.FLOWER));

        LEVELS.put("level2", new LevelData(
                2,
                16,
                Position.at(0,0),
                Direction.UP,
                squaresForLevel2
        ));


        // Squares for level 3
        List<PlayableSquare> squaresForLevel3 = new ArrayList<>();
// Row 0
        squaresForLevel3.add(new PlayableSquare(new Position(0, 0), Color.GREEN, Shape.STAR));
        squaresForLevel3.add(new PlayableSquare(new Position(0, 1), Color.RED, Shape.FLOWER));
        squaresForLevel3.add(new PlayableSquare(new Position(0, 2), Color.GREEN, Shape.CROSS));
        squaresForLevel3.add(new PlayableSquare(new Position(0, 4), Color.YELLOW, Shape.STAR));
        squaresForLevel3.add(new PlayableSquare(new Position(0, 5), Color.YELLOW, Shape.FLOWER));
        squaresForLevel3.add(new PlayableSquare(new Position(0, 6), Color.BLUE, Shape.STAR));
// Row 1
        squaresForLevel3.add(new PlayableSquare(new Position(1, 0), Color.RED, Shape.CROSS));
        squaresForLevel3.add(new PlayableSquare(new Position(1, 1), Color.YELLOW, Shape.STAR));
        squaresForLevel3.add(new PlayableSquare(new Position(1, 2), Color.YELLOW, Shape.DIAMOND));
        squaresForLevel3.add(new PlayableSquare(new Position(1, 4), Color.GREEN, Shape.DIAMOND));
        squaresForLevel3.add(new PlayableSquare(new Position(1, 5), Color.BLUE, Shape.STAR));
        squaresForLevel3.add(new PlayableSquare(new Position(1, 6), Color.YELLOW, Shape.FLOWER));

// Row 2
        squaresForLevel3.add(new PlayableSquare(new Position(2, 0), Color.RED, Shape.FLOWER));
        squaresForLevel3.add(new PlayableSquare(new Position(2, 1), Color.RED, Shape.DIAMOND));
        squaresForLevel3.add(new PlayableSquare(new Position(2, 2), Color.BLUE, Shape.STAR));
        squaresForLevel3.add(new PlayableSquare(new Position(2, 3), Color.BLUE, Shape.FLOWER));
        squaresForLevel3.add(new PlayableSquare(new Position(2, 4), Color.BLUE, Shape.CROSS));
        squaresForLevel3.add(new PlayableSquare(new Position(2, 5), Color.YELLOW, Shape.DIAMOND));
        squaresForLevel3.add(new PlayableSquare(new Position(2, 6), Color.GREEN, Shape.STAR));

// Row 3
        squaresForLevel3.add(new PlayableSquare(new Position(3, 0), Color.GREEN, Shape.DIAMOND));
        squaresForLevel3.add(new PlayableSquare(new Position(3, 1), Color.RED, Shape.CROSS));
        squaresForLevel3.add(new PlayableSquare(new Position(3, 2), Color.YELLOW, Shape.FLOWER));
        squaresForLevel3.add(new PlayableSquare(new Position(3, 3), Color.BLUE, Shape.STAR));
        squaresForLevel3.add(new PlayableSquare(new Position(3, 4), Color.RED, Shape.FLOWER));
        squaresForLevel3.add(new PlayableSquare(new Position(3, 5), Color.YELLOW, Shape.DIAMOND));
        squaresForLevel3.add(new PlayableSquare(new Position(3, 6), Color.GREEN, Shape.STAR));

// Row 4
        squaresForLevel3.add(new PlayableSquare(new Position(4, 0), Color.BLUE, Shape.FLOWER));
        squaresForLevel3.add(new PlayableSquare(new Position(4, 1), Color.BLUE, Shape.CROSS));
        squaresForLevel3.add(new PlayableSquare(new Position(4, 2), Color.RED, Shape.DIAMOND));
        squaresForLevel3.add(new PlayableSquare(new Position(4, 3), Color.RED, Shape.CROSS));
        squaresForLevel3.add(new PlayableSquare(new Position(4, 4), Color.GREEN, Shape.FLOWER));
        squaresForLevel3.add(new PlayableSquare(new Position(4, 5), Color.GREEN, Shape.CROSS));
        squaresForLevel3.add(new PlayableSquare(new Position(4, 6), Color.RED, Shape.CROSS));


// Row 6
        squaresForLevel3.add(new PlayableSquare(new Position(5, 0), Color.BLUE, Shape.CROSS));
        squaresForLevel3.add(new PlayableSquare(new Position(5, 1), Color.RED, Shape.FLOWER));
        squaresForLevel3.add(new PlayableSquare(new Position(5, 2), Color.BLUE, Shape.DIAMOND));
        squaresForLevel3.add(new PlayableSquare(new Position(5, 4), Color.RED, Shape.CROSS));
        squaresForLevel3.add(new PlayableSquare(new Position(5, 5), Color.GREEN, Shape.FLOWER));
        squaresForLevel3.add(new PlayableSquare(new Position(5, 6), Color.BLUE, Shape.FLOWER));

// Row 7
        squaresForLevel3.add(new PlayableSquare(new Position(6, 0), Color.RED, Shape.FLOWER));
        squaresForLevel3.add(new PlayableSquare(new Position(6, 1), Color.RED, Shape.FLOWER));
        squaresForLevel3.add(new PlayableSquare(new Position(6, 2), Color.BLUE, Shape.CROSS));
        squaresForLevel3.add(new PlayableSquare(new Position(6, 4), Color.GREEN, Shape.STAR));
        squaresForLevel3.add(new PlayableSquare(new Position(6, 5), Color.YELLOW, Shape.CROSS));
        squaresForLevel3.add(new PlayableSquare(new Position(6, 6), Color.RED, Shape.STAR));

// Row 8 (bottom special tiles)
        squaresForLevel3.add(new PlayableSquare(new Position(7, 1), Color.GREEN, Shape.DIAMOND));
        squaresForLevel3.add(new PlayableSquare(new Position(7, 5), Color.GREEN, Shape.STAR)); // Goal

        LEVELS.put("level3", new LevelData(
                3,
                16,
                Position.at(0,0),
                Direction.UP,
                squaresForLevel3
        ));

        List<PlayableSquare> squaresForLevel4 = new ArrayList<>();
// Row 0
        squaresForLevel4.add(new PlayableSquare(new Position(0, 0), Color.RED, Shape.DIAMOND));
        squaresForLevel4.add(new PlayableSquare(new Position(0, 1), Color.YELLOW, Shape.STAR));
        squaresForLevel4.add(new PlayableSquare(new Position(0, 2), Color.BLUE, Shape.FLOWER));
        squaresForLevel4.add(new PlayableSquare(new Position(0, 3), Color.RED, Shape.CROSS));
        squaresForLevel4.add(new PlayableSquare(new Position(0, 4), Color.RED, Shape.FLOWER));
        squaresForLevel4.add(new PlayableSquare(new Position(0, 5), Color.BLUE, Shape.CROSS));

// Row 1
        squaresForLevel4.add(new PlayableSquare(new Position(1, 0), Color.YELLOW, Shape.DIAMOND));
        squaresForLevel4.add(new PlayableSquare(new Position(1, 1), Color.BLUE, Shape.FLOWER));
        squaresForLevel4.add(new PlayableSquare(new Position(1, 2), Color.YELLOW, Shape.STAR));  // Goal
        squaresForLevel4.add(new PlayableSquare(new Position(1, 3), Color.BLUE, Shape.STAR));
        squaresForLevel4.add(new PlayableSquare(new Position(1, 4), Color.BLUE, Shape.CROSS));  // Goal
        squaresForLevel4.add(new PlayableSquare(new Position(1, 5), Color.YELLOW, Shape.STAR));

// Row 2
        squaresForLevel4.add(new PlayableSquare(new Position(2, 0), Color.RED, Shape.FLOWER));
        squaresForLevel4.add(new PlayableSquare(new Position(2, 1), Color.BLUE, Shape.STAR));
        squaresForLevel4.add(new PlayableSquare(new Position(2, 2), Color.BLUE, Shape.DIAMOND));
        squaresForLevel4.add(new PlayableSquare(new Position(2, 3), Color.GREEN, Shape.FLOWER));
        squaresForLevel4.add(new PlayableSquare(new Position(2, 4), Color.RED, Shape.CROSS));
        squaresForLevel4.add(new PlayableSquare(new Position(2, 5), Color.YELLOW, Shape.DIAMOND));

// Row 3
        squaresForLevel4.add(new PlayableSquare(new Position(3, 3), Color.RED, Shape.DIAMOND)); // Bridge/Goal center

// Row 4
        squaresForLevel4.add(new PlayableSquare(new Position(4, 0), Color.BLUE, Shape.CROSS));
        squaresForLevel4.add(new PlayableSquare(new Position(4, 1), Color.RED, Shape.DIAMOND));
        squaresForLevel4.add(new PlayableSquare(new Position(4, 2), Color.GREEN, Shape.FLOWER));
        squaresForLevel4.add(new PlayableSquare(new Position(4, 3), Color.GREEN, Shape.STAR));
        squaresForLevel4.add(new PlayableSquare(new Position(4, 4), Color.YELLOW, Shape.STAR));
        squaresForLevel4.add(new PlayableSquare(new Position(4, 5), Color.RED, Shape.DIAMOND));
        squaresForLevel4.add(new PlayableSquare(new Position(4, 6), Color.GREEN, Shape.STAR));


// Row 5
        squaresForLevel4.add(new PlayableSquare(new Position(5, 0), Color.YELLOW, Shape.CROSS));
        squaresForLevel4.add(new PlayableSquare(new Position(5, 1), Color.BLUE, Shape.STAR));
        squaresForLevel4.add(new PlayableSquare(new Position(5, 2), Color.YELLOW, Shape.DIAMOND)); // Goal
        squaresForLevel4.add(new PlayableSquare(new Position(5, 3), Color.YELLOW, Shape.FLOWER));
        squaresForLevel4.add(new PlayableSquare(new Position(5, 4), Color.RED, Shape.FLOWER));
        squaresForLevel4.add(new PlayableSquare(new Position(5, 5), Color.GREEN, Shape.STAR)); // Goal
        squaresForLevel4.add(new PlayableSquare(new Position(5, 6), Color.BLUE, Shape.CROSS));

// Row 6
        squaresForLevel4.add(new PlayableSquare(new Position(6, 0), Color.RED, Shape.CROSS));
        squaresForLevel4.add(new PlayableSquare(new Position(6, 1), Color.GREEN, Shape.DIAMOND));
        squaresForLevel4.add(new PlayableSquare(new Position(6, 2), Color.BLUE, Shape.FLOWER));
        squaresForLevel4.add(new PlayableSquare(new Position(6, 3), Color.YELLOW, Shape.DIAMOND));
        squaresForLevel4.add(new PlayableSquare(new Position(6, 4), Color.BLUE, Shape.STAR));
        squaresForLevel4.add(new PlayableSquare(new Position(6, 5), Color.YELLOW, Shape.DIAMOND));
        squaresForLevel4.add(new PlayableSquare(new Position(6, 6), Color.BLUE, Shape.STAR));

// Row 7 (bottom goal)
        squaresForLevel4.add(new PlayableSquare(new Position(7, 1), Color.YELLOW, Shape.STAR));  // Starting goal

        LEVELS.put("level4", new LevelData(
                4,
                16,
                Position.at(0,0),
                Direction.UP,
                squaresForLevel4
        ));
    }
}