package nz.ac.ara.ads.eyeballmaze.model.interfaces;

import nz.ac.ara.ads.eyeballmaze.enums.*;
import nz.ac.ara.ads.eyeballmaze.model.classes.Square;

public interface ISquareHolder {
    public void addSquare(Square square, int row, int column);
    public Color getColorAt(int row, int column);
    public Shape getShapeAt(int row, int column);
}