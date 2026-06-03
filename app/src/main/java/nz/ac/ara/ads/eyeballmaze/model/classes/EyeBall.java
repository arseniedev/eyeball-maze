package nz.ac.ara.ads.eyeballmaze.model.classes;

import nz.ac.ara.ads.eyeballmaze.enums.Direction;

public class EyeBall {
    protected Position currentPosition;
    protected Direction previousDirection;
    public Direction currentDirection;
    public float currentEyeballRotation = 0f;

    public EyeBall(int newYPosition, int newXPosition, Direction eyeballDirection) {
        this.currentPosition = new Position(newYPosition, newXPosition);
        this.currentDirection = eyeballDirection;
    }

    public int getXPosition() {
        return currentPosition.getColumn();
    }

    public int getYPosition() {
        return currentPosition.getRow();
    }

    public Direction getDirection() {
        return currentDirection;
    }

    private float getRotationDegrees(Direction direction) {
        return switch (direction) {
            case RIGHT -> 90f;
            case DOWN -> 180f;
            case LEFT -> 270f;
            default -> 0f; // UP or fallback
        };
    }

    public Direction getNewFacing(Direction intendedMove) {
        // Returns new direction relative to the current facing direction
        return switch (currentDirection) {
            case UP -> intendedMove;
            case RIGHT -> switch (intendedMove) {
                case UP -> Direction.LEFT;
                case DOWN -> Direction.RIGHT;
                case LEFT -> Direction.UP;
                case RIGHT -> Direction.DOWN;
                default -> intendedMove;
            };
            case DOWN -> switch (intendedMove) {
                case UP -> Direction.DOWN;
                case DOWN -> Direction.UP;
                case LEFT -> Direction.RIGHT;
                case RIGHT -> Direction.LEFT;
                default -> intendedMove;
            };
            case LEFT -> switch (intendedMove) {
                case UP -> Direction.RIGHT;
                case DOWN -> Direction.LEFT;
                case LEFT -> Direction.DOWN;
                case RIGHT -> Direction.UP;
                default -> intendedMove;
            };
            default -> intendedMove;
        };
    }

    public boolean isOpposite(Direction move) {
        return (this.currentDirection == Direction.UP && move == Direction.DOWN) ||
                (this.currentDirection == Direction.DOWN && move == Direction.UP) ||
                (this.currentDirection == Direction.LEFT && move == Direction.RIGHT) ||
                (this.currentDirection == Direction.RIGHT && move == Direction.LEFT);
    }

    public void updateEyeball(int row, int column) {
        this.previousDirection = this.currentDirection;
        this.currentDirection = getNewEyeballFacingDirection(row, column);
        this.currentPosition = new Position(row, column);
    }

    public Direction getNewEyeballFacingDirection(int targetY, int targetX) {
        int currentY = this.getYPosition();
        int currentX = this.getXPosition();

        boolean isMovingVertical = targetY != currentY;
        boolean isMovingHorizontal = targetX != currentX;

        if (isMovingVertical && isMovingHorizontal) {
            return Direction.DIAGONAL;
        } else if (isMovingHorizontal) {
            return targetX > currentX ? Direction.RIGHT : Direction.LEFT;
        } else {
            return targetY < currentY ? Direction.UP : Direction.DOWN;
        }
    }
}
