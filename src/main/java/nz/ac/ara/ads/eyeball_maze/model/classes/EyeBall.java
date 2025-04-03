package nz.ac.ara.ads.eyeball_maze.model.classes;

import nz.ac.ara.ads.eyeball_maze.enums.Direction;

public class EyeBall {
    /*
    * Uses singleton design pattern
    * */
    protected Position position;
    protected Direction direction;

    private static EyeBall eyeBall;

    private EyeBall() {

    }

    public EyeBall(Position eyeballPosition, Direction eyeballDirection) {
        this.position = eyeballPosition;
        this.direction = eyeballDirection;
    }

    public static EyeBall getEyeBall() {
        if (eyeBall == null) {
            eyeBall = new EyeBall();
        }

        return eyeBall;
    }

    public int getXPosition() {
        return position.getColumn();
    }

    public int getYPosition() {
        return position.getRow();
    }

//    @Override
    public Direction getDirection() {
        return direction;
    }

//    public Direction setDirection() {
//        return direction;
//    }

    public void setPosition(int row, int column) {
        this.position = new Position(row, column);
    }
}
