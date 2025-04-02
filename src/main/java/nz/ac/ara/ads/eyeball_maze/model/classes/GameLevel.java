package nz.ac.ara.ads.eyeball_maze.model.classes;

public class GameLevel {
    protected int levelNumber = 0;
    protected int levelWidth;
    protected int levelHeight;

    protected int totalGoalCount = 0;
    protected int completedGoalCount = 0;

    public GameLevel(int levelNumber, int levelHeight, int levelWidth) {
        this.levelWidth = levelWidth;
        this.levelHeight = levelHeight;
        this.levelNumber = levelNumber;
//        this.levelNumber++; // starts at 1
    }

//    public int getLevelNumber() {
//        return levelNumber;
//    }
    public int getLevelWidth() {
        return levelWidth;
    }
    public int getLevelHeight() {
        return levelHeight;
    }

    public int getCompletedGoalCount() {
        return completedGoalCount;
    }
    public int getTotalGoalCount() {
        return totalGoalCount;
    }
}
