package nz.ac.ara.ads.eyeballmaze.model.classes;

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

    public void setCompletedGoalCount() {
        this.completedGoalCount = completedGoalCount;
    }

    public int getLevelWidth() {
        return levelWidth;
    }
    public int getLevelHeight() {
        return levelHeight;
    }
}