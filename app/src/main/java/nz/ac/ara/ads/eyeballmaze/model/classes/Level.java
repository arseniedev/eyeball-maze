package nz.ac.ara.ads.eyeballmaze.model.classes;

import java.util.List;

import nz.ac.ara.ads.eyeballmaze.model.data.LevelData;
import nz.ac.ara.ads.eyeballmaze.model.data.LevelRepository;

import java.lang.reflect.Type;
import java.util.List;
public class Level {
    protected int levelNumber;
    protected int levelWidth;
    protected int levelHeight;
    public int totalGoalCount;

    public int completedGoalCount = 0;

    public Level(
//            LevelData level
//            int totalGoalCo
            int level,
            int height,
            int width
//            LevelData levelData
    ) {
        this.levelNumber = level;
        this.levelWidth = width;
        this.levelHeight = height;
//        this.levelData = levelData;
    }

//    public LevelData setLevel(int levelNumber) {
//        LevelData levelData = LevelRepository.LEVELS.get(levelNumber);
//
//        if (levelData == null) {
//            System.out.println("Level not found: " + levelNumber);
//        } else {
//            System.out.println("Loaded level " + levelNumber);
//            List<PlayableSquare> squares = levelData.squares(); // Access squares directly
//            totalGoalCount = levelData.totalGoalCount();
//            // Do something with squares if needed
//        }
//
//        return levelData;
//    }

    public int getCompletedGoalCount() {
        return this.completedGoalCount;
    }

    public void setCompletedGoalCount(int completedGoalCount) {
        this.completedGoalCount = completedGoalCount;
    }

//    public void getCompletedGoalCount(int completedGoalCount) {
//        this.completedGoalCount = completedGoalCount;
//    }

    public int getLevelWidth() {
        return levelWidth;
    }
    public int getLevelHeight() {
        return levelHeight;
    }
}