package nz.ac.ara.ads.eyeballmaze.model.classes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GameLevel {
    public int levelWidth;
    public int levelHeight;
//    public int currentLevel = 1;
    public int totalGoalCount = 1;
    private int completedGoalCount = 0;
    private final Set<Position> completedGoals = new HashSet<>();
    private static final int MAX_COLS = 20;
    private static final int MAX_ROWS = 20;

//    Map<String, Square> squareCollection = new HashMap<>();

    public GameLevel(int height, int width) {
//        this.totalGoalCount = totalGoals;
        this.levelWidth = width;
        this.levelHeight = height;
    }
//    public void setCompletedGoalCount() {
//        this.completedGoalCount = completedGoalCount;
//    }

//    public void goalCompleted(int row,int col) {
//        //setter
//        Position position = Position.at(row, col);
//        completedGoals.add(position);
//        completedGoalCount++;
//    }

    public int getCompletedGoals() {
        //getter
//        int completedGoalCount = completedGoals.size();
        return completedGoals.size();
    }

//    public int getTotalGoalCount() {
//        //getter
//        return this.totalGoalCount;
//    }

//    public boolean isValidCoordinate(int row, int col) {
//        return row >= 0 && row < levelHeight && col >= 0 && col < levelWidth;
//    }
    public boolean isLevelComplete() {
        return completedGoalCount >= totalGoalCount;
    }
}