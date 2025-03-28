package nz.ac.ara.ads.eyeball_maze.model.interfaces;

public interface IGoalHolder {
    public void addGoal(int row, int column);
    public int getGoalCount();
    public boolean hasGoalAt(int targetRow, int targetColumn);
    public int getCompletedGoalCount();
}