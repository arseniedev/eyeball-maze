package nz.ac.ara.ads.eyeball_maze.model.interfaces;

public interface IEyeballHolder {
    public void addEyeball(int row, int column, Direction direction);
    public int getEyeballRow();
    public int getEyeballColumn();
    public Direction getEyeballDirection();
}