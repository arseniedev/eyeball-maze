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
            int level,
            int height,
            int width
    ) {
        this.levelNumber = level;
        this.levelWidth = width;
        this.levelHeight = height;
    }

    public int getCompletedGoalCount() {
        return this.completedGoalCount;
    }

    public void setCompletedGoalCount(int completedGoalCount) {
        this.completedGoalCount = completedGoalCount;
    }

    public int getLevelWidth() {
        return levelWidth;
    }
    public int getLevelHeight() {
        return levelHeight;
    }
}