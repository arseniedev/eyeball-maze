package nz.ac.ara.ads.eyeballmaze.model.interfaces;

import nz.ac.ara.ads.eyeballmaze.enums.Direction;
import nz.ac.ara.ads.eyeballmaze.model.exceptions.*;

public interface IEyeballHolder {
    public void addEyeball(int row, int column, Direction direction) throws InvalidCoordinateException;
    public int getEyeballRow();
    public int getEyeballColumn();
    public Direction getEyeballDirection();
}