package nz.ac.ara.ads.eyeballmaze.model.classes;

import java.util.HashMap;
import java.util.Map;

public class GameLevel {
    private final int totalGoals;
    private int completedGoals;
//    protected int levelNumber;
    protected int levelWidth;
    protected int levelHeight;
    public int totalGoalCount;
    public int completedGoalCount = 0;
    Map<String, Square> squareCollection = new HashMap<>();
    public GameLevel(
            int totalGoals,
            int height,
            int width
    ) {
        this.totalGoals = totalGoals;
        this.levelWidth = width;
        this.levelHeight = height;
    }
//    public void setCompletedGoalCount() {
//        this.completedGoalCount = completedGoalCount;
//    }

    public void goalCompleted() {
        this.completedGoalCount++;
    }
    public void addGoal() {
        this.totalGoalCount++;
    }

//    public int getLevelWidth() {
//        return levelWidth;
//    }
//    public int getLevelHeight() {
//        return levelHeight;
//    }
    public int getCompletedGoals() {
        return completedGoals;
    }
    public int getTotalGoals() {
        return totalGoals;
    }

    public boolean isValidCoordinate(int row, int col) {
        return row >= 0 && row < levelHeight && col >= 0 && col < levelWidth;
    }

    public boolean isLevelComplete() {
        return completedGoals >= totalGoals;
    }

    public int getLevelWidth() {
        return levelWidth;
    }
    public int getLevelHeight() {
        return levelHeight;
    }

}