package nz.ac.ara.ads.eyeballmaze.model.classes;
import nz.ac.ara.ads.eyeballmaze.enums.Direction;
public class EyeBall {
    /*
     * Uses singleton design pattern
     * */
    protected Position currenPosition;
    protected Direction currentDirection;
    protected Direction previousDirection;
    protected int currentYPosition;
    protected int currentXPosition;
    public EyeBall(int newYPosition,int newXPosition, Direction eyeballDirection) {
        this.currentYPosition = newYPosition;
        this.currentXPosition = newXPosition;
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
        this.currentDirection = direction;

        return direction;
    }

}