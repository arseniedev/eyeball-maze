package nz.ac.ara.ads.eyeballmaze.enums;

public enum Direction {
    DIAGONAL,
    UP,
    DOWN,
    LEFT,
    RIGHT;

    public Direction opposite() {
        return switch (this) {
            case UP -> DOWN;
            case DOWN -> UP;
            case LEFT -> RIGHT;
            case RIGHT -> LEFT;
            default -> throw new IllegalStateException("Unknown direction: " + this);
        };
    }
}