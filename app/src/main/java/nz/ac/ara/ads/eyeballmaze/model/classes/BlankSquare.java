package nz.ac.ara.ads.eyeballmaze.model.classes;

import nz.ac.ara.ads.eyeballmaze.enums.Color;
import nz.ac.ara.ads.eyeballmaze.enums.Shape;

public class BlankSquare extends Square {
    public BlankSquare() {
    }

    public BlankSquare(int i, int i1, Color color, Shape shape, boolean b, boolean b1) {
    }

    public boolean isCurrent() {
        return false;
    }
}