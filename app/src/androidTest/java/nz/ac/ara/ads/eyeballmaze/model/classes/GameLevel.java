package nz.ac.ara.ads.eyeballmaze.model.classes;
public class GameLevel {
    protected int levelNumber = 0;
    protected int levelWidth;
    protected int levelHeight;

    public int totalGoalCount = 0;
    public int completedGoalCount = 0;

    public GameLevel(int levelNumber, int levelHeight, int levelWidth) {
        this.levelWidth = levelWidth;
        this.levelHeight = levelHeight;
        this.levelNumber = levelNumber;
    }
    public int getLevelWidth() {
        return levelWidth;
    }
    public int getLevelHeight() {
        return levelHeight;
    }
}