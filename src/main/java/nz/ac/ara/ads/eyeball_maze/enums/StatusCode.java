package nz.ac.ara.ads.eyeball_maze.enums;

public enum StatusCode {
    LEVEL_CHANGED("Setting level:")
    ;

    private final String statusMessage;

    StatusCode(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}
