package nz.ac.ara.ads.eyeball_maze.model.classes;

import nz.ac.ara.ads.eyeball_maze.enums.Direction;

public class EyeBall {
    protected Position position;
    protected Direction direction;
    public EyeBall(Position eyeballPosition, Direction eyeballDirection) {
        this.position = eyeballPosition;
        this.direction = eyeballDirection;
    }
}
