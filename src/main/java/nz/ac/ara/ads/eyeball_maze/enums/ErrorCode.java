package nz.ac.ara.ads.eyeball_maze.enums;

public enum ErrorCode {
    INDEX_OUT_OF_BOUNDS("Index out of bounds"),
    COLOUR_NOT_FOUND("Input coordinates does not correspond to a color"),
    SHAPE_NOT_FOUND("Input coordinates does not correspond to a shape");;

    private final String errorMessage;
    ErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public String errorMessage() { return errorMessage; }
}