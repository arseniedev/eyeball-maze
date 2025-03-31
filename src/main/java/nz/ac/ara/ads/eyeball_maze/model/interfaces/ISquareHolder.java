package nz.ac.ara.ads.eyeball_maze.model.interfaces;

import nz.ac.ara.ads.eyeball_maze.enums.*;
import nz.ac.ara.ads.eyeball_maze.model.classes.Square;

public interface ISquareHolder {
    public void addSquare(Square square, int row, int column);
    public Color getColorAt(int row, int column);
    public Shape getShapeAt(int row, int column);
}