package nz.ac.ara.ads.eyeballmaze.model.classes;

import androidx.annotation.NonNull;
import java.util.logging.Logger;
import java.util.logging.Level;

import nz.ac.ara.ads.eyeballmaze.enums.Direction;
public class EyeBall {
    public Position position;
    public Position targetPosition;
    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public Direction currentFacing;
    public EyeBall(Position startPosition, Direction currentFacing) {
        this.position = startPosition;
        this.currentFacing = currentFacing;
    }
    public int getCol() { return position.col(); }
    public int getRow() { return position.row(); }

    public boolean matches(Position targetPosition, Direction targetFacing) {
        return this.position.equals(targetPosition) && this.currentFacing.equals(targetFacing);
    }
    public void selectNextGrid(int clickedRow, int clickedCol) {
        Position targetPosition = Position.at(clickedRow, clickedCol);
        Position currentEyeballPos = this.position;
        currentFacing = calculateDirection(currentEyeballPos, targetPosition);

        LOGGER.log(Level.INFO, "Eyeball moved to: [" + clickedRow + "][" + clickedCol + "]");

        moveTo(clickedRow, clickedCol);
    }


    // Helper: Calculate Direction from posA to posB (assumes one-step adjacent move)
    private Direction calculateDirection(Position from, Position to) {
        int dRow = to.row() - from.row();
        int dCol = to.col() - from.col();

        // You can customize this logic depending on allowed moves
        if (dRow == -1 && dCol == 0) return Direction.UP;
        if (dRow == 1 && dCol == 0) return Direction.DOWN;
        if (dRow == 0 && dCol == -1) return Direction.LEFT;
        if (dRow == 0 && dCol == 1) return Direction.RIGHT;

        // Return null if move is invalid (non-adjacent)
        return null;
    }
    public void moveTo(int destinationRow, int destinationColumn) {
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

    public Direction targetDirection(@NonNull Position targetPosition) {
        Position currentPosition = this.position;
        // to -< from
        int rowDiff = targetPosition.row() - currentPosition.row();
        int colDiff = targetPosition.col() - currentPosition.col();

        // You can customize this logic depending on allowed moves
        if (rowDiff < 0 && colDiff == 0) return Direction.UP;
        if (rowDiff > 0 && colDiff == 0) return Direction.DOWN;
        if (rowDiff == 0 && colDiff < 0) return Direction.LEFT;
        if (rowDiff == 0 && colDiff > 1) return Direction.RIGHT;

        // Return null if move is invalid (non-adjacent)
        return null;
    }
    public boolean isFacingBackward(@NonNull Direction targetFacing) {
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