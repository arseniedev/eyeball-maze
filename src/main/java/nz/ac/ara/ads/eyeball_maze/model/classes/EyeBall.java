package nz.ac.ara.ads.eyeball_maze.model.classes;
import nz.ac.ara.ads.eyeball_maze.enums.Direction;
import nz.ac.ara.ads.eyeball_maze.enums.ErrorCode;


public class EyeBall {
    /*
    * Uses singleton design pattern
    * */
    protected Position newPosition;
    protected Position currenPosition;
    protected Position previousPosition;
    protected Direction currentDirection;
    protected Direction previousDirection;
    protected int currentYPosition;
    protected int currentXPosition;
    private static EyeBall eyeBall;

    private EyeBall() {

    }

    public EyeBall(int newYPosition,int newXPosition, Direction eyeballDirection) {
        this.currentYPosition = newYPosition;
        this.currentXPosition = newXPosition;
        this.currenPosition = new Position(newYPosition,newXPosition);
        this.currentDirection = eyeballDirection;
    }

    public static EyeBall getEyeBall() {
        if (eyeBall == null) {
            eyeBall = new EyeBall();
        }

        return eyeBall;
    }

    public int getXPosition() {
        return currenPosition.getColumn();
    }

    public int getYPosition() {
        return currenPosition.getRow();
    }

//    @Override
    public Direction getDirection() {
        return currentDirection;
    }

//    public Direction setNewDirection(int newYDestination, int newXDestination) {
//        return direction;
//    }

    public void updateEyeball(int row, int column) {
//        this.previousPosition = this.currenPosition;
        this.previousPosition = new Position(this.currentYPosition, this.currentXPosition);
        this.previousDirection = this.currentDirection;
        this.setNewEyeballFacingDirection(row, column);
        this.currenPosition = new Position(row, column);
    }

    private void setNewEyeballFacingDirection(int targetY, int targetX) {
////         Returns the direction it is taking
        Direction direction;

        int currentY= this.currentYPosition;
        int currentX = this.currentXPosition;


        boolean isMovingVertical= targetX == currentX;
        boolean isMovingHorizontal = targetY == currentY;

        if (isMovingHorizontal) {
            direction = targetX > currentX ? Direction.RIGHT : Direction.LEFT;

        } else if (isMovingVertical) {
            direction = targetY > currentY ? Direction.UP : Direction.DOWN;
        } else {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.INVALID_MOVE));
        }

        this.currentDirection = direction;
//        return direction;
    }

}
