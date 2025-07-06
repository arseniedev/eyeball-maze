package nz.ac.ara.ads.eyeballmaze.model.classes;
import nz.ac.ara.ads.eyeballmaze.enums.Direction;
public class EyeBall {
    protected Position currenPosition;
    public float currentEyeballRotation = 0f;
    public Direction currentDirection;
    protected Direction previousDirection;
    public EyeBall(int newYPosition,int newXPosition, Direction eyeballDirection) {
        this.currenPosition = new Position(newYPosition,newXPosition);
        this.currentDirection = eyeballDirection;
    }
    public int getXPosition() {
        return currenPosition.getColumn();
    }
    public int getYPosition() {
        return currenPosition.getRow();
    }
    public Direction getDirection() {
        return currentDirection;
    }
    public Direction rotateDirection(Direction currentDirection, boolean clockwise) {
        switch (currentDirection) {
            case UP: return clockwise ? Direction.RIGHT : Direction.LEFT;
            case RIGHT: return clockwise ? Direction.DOWN : Direction.UP;
            case DOWN: return clockwise ? Direction.LEFT : Direction.RIGHT;
            case LEFT: return clockwise ? Direction.UP : Direction.DOWN;
            default: return Direction.UP;
        }
    }

    public void updateEyeball(int row, int column) {
        this.previousDirection = this.currentDirection;
        this.getNewEyeballFacingDirection(row, column);
        this.currenPosition = new Position(row, column);
    }

    public Direction getNewEyeballFacingDirection(int targetY, int targetX) {
        Direction direction;

        int currentY= this.getYPosition();
        int currentX = this.getXPosition();

        boolean isMovingVertical= targetX == currentX;
        boolean isMovingHorizontal = targetY == currentY;

        if (isMovingHorizontal) {
            direction = targetX > currentX ? Direction.RIGHT : Direction.LEFT;

        } else if (isMovingVertical) {
            direction = targetY < currentY ? Direction.UP : Direction.DOWN;
        } else {
            direction = Direction.DIAGONAL;
        }

        this.currentDirection = Direction.UP;

        return direction;
    }
}