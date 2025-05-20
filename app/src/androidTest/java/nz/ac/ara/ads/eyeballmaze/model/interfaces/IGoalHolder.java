package nz.ac.ara.ads.eyeballmaze.model.interfaces;

public interface IGoalHolder {
    public void addGoal(int row, int column) throws Exception;
    public int getGoalCount();
    public boolean hasGoalAt(int targetRow, int targetColumn);
    public int getCompletedGoalCount();
}