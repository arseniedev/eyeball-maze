package nz.ac.ara.ads.eyeballmaze.model.classes;
import nz.ac.ara.ads.eyeballmaze.enums.Shape;
import nz.ac.ara.ads.eyeballmaze.enums.Color;
public class PlayableSquare extends Square {
    private boolean isCurrent = false;
    protected boolean isGoal;
    protected Color color;
    protected Shape shape;
    public PlayableSquare(Position position, Color color, Shape shape) {
        super(position, color, shape);
    }

//    @Override
//    public Color getColor() {
//        return this.color;
//    }
//    @Override
//    public Shape getShape() {
//        return this.shape;
//    }

    public boolean isCurrent() {
        return isCurrent;
    }
    public void setCurrent(boolean current) {
        isCurrent = current;
    }

    public void markAsGoal(this) {
        this.isGoal = true;
    }

//    public void setCurrent(PlayableSquare square) {
//        if (this != null) {
//            isCurrent =  setCurrent(false);
//        }
//        this = square;
//        this.setCurrent(true);
//    }
}