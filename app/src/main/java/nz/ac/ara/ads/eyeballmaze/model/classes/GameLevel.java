package nz.ac.ara.ads.eyeballmaze.model.classes;

import java.util.HashSet;
import java.util.Set;

public class GameLevel {
    public int levelWidth;
    public int levelHeight;
    public int totalGoalCount;
    public int completedGoalCount = 0;
    private final Set<Position> completedGoals = new HashSet<>();


    public GameLevel(int height, int width) {
//        this.totalGoalCount = totalGoals;
        this.levelWidth = width;
        this.levelHeight = height;
    }

    public void goalCompleted(int row,int col) {
        //setter
        Position position = Position.at(row, col);
        completedGoals.add(position);
        completedGoalCount++;
    }

    public int getCompletedGoals() {
        //getter
        return completedGoals.size();
    }

    public boolean isLevelComplete() {
        return completedGoalCount >= totalGoalCount;
    }
}