package nz.ac.ara.ads.eyeballmaze.model.classes;
import nz.ac.ara.ads.eyeballmaze.enums.Direction;
public class EyeBall {
    public Position position;
    public Position targetPosition;
    public float currentEyeballRotation = 0f;
    protected Direction currentFacing;
//    public Direction targetFacing;
    public EyeBall(Position startPosition, Direction currentFacing) {
        this.position = startPosition;
        this.currentFacing = currentFacing;
    }

    public int getCol() { return position.col(); }
    public int getRow() { return position.row(); }

    public boolean matches(Position targetPosition, Direction targetFacing) {
        return this.position.equals(targetPosition) && this.currentFacing.equals(targetFacing);
    }

    public void moveTo(int destinationRow, int destinationColumn) {
//        Position newTarget = Position.at(destinationRow, destinationColumn);
        this.targetPosition = Position.at(destinationRow, destinationColumn);;
    }

    public void confirmMove() {
        this.position = targetPosition;
    }

    public void undoMove() {
        this.targetPosition = position;
    }

    public void rotate(Direction direction) {
        this.currentFacing = direction;
    }

    public Direction getDirection() {
        return currentFacing;
    }

    public boolean isFacingBackward(Direction targetFacing) {
        return targetFacing.equals(this.currentFacing.opposite());
    }
}

//    public Direction rotateDirection(Direction currentDirection, boolean clockwise) {
//        switch (currentDirection) {
//            case UP: return clockwise ? Direction.RIGHT : Direction.LEFT;
//            case RIGHT: return clockwise ? Direction.DOWN : Direction.UP;
//            case DOWN: return clockwise ? Direction.LEFT : Direction.RIGHT;
//            case LEFT: return clockwise ? Direction.UP : Direction.DOWN;
//            default: return Direction.UP;
//        }
//    }

//    public void updateEyeball(int row, int column) {
//        this.previousDirection = this.currentDirection;
//        this.getNewEyeballFacingDirection(row, column);
////        this.currenPosition = new Position(row, column);
//    }

//    public Direction setTargetDirection(int targetY, int targetX) {
//        Direction direction;
//
//        boolean isMovingVertical= targetY != currentY;
//        boolean isMovingHorizontal = targetX != currentX;
//        if (isMovingVertical && isMovingHorizontal) {
//            direction = Direction.DIAGONAL;
//        } else {
//            if (isMovingHorizontal) {
//                direction = targetX > currentX ? Direction.RIGHT : Direction.LEFT;
//
//            } else { //if (isMovingVertical)
//                direction = targetY < currentY ? Direction.UP : Direction.DOWN;
//            }
//        }
//
//        return direction;
//    }