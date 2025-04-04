package nz.ac.ara.ads.eyeball_maze.model.interfaces;

import nz.ac.ara.ads.eyeball_maze.enums.Direction;
import nz.ac.ara.ads.eyeball_maze.model.exceptions.InvalidCoordinateException;

public interface IEyeballHolder {
    public void addEyeball(int row, int column, Direction direction) throws InvalidCoordinateException;
    public int getEyeballRow();
    public int getEyeballColumn();
    public Direction getEyeballDirection();
}