package nz.ac.ara.ads.eyeball_maze.model.classes;

import nz.ac.ara.ads.eyeball_maze.enums.Color;
import nz.ac.ara.ads.eyeball_maze.enums.Direction;
import nz.ac.ara.ads.eyeball_maze.enums.Message;
import nz.ac.ara.ads.eyeball_maze.enums.Shape;

public class Game {

    public Game() {
    }
    public void addLevel(int row, int column) {
    }
    public int getLevelWidth() {
        return 0;
    }
    public int getLevelHeight() {
        return 0;
    }
    public int getLevelCount() {
        return 0;
    }
    public void setLevel(int num) {
    }
    public void addGoal(int row, int column) {
    }
    public int getGoalCount() {
        return 0;
    }
    public boolean hasGoalAt(int row, int column) {
        return false;
    }
    public int getCompletedGoalCount() {
        return 0;
    }
    public void addSquare(Square sq1, int row, int column) {
    }
    public Color getColorAt(int row, int column) {
        return Color.PURPLE;
    }
    public Shape getShapeAt(int row, int column) {
        return Shape.STAR;
    }
    public int getEyeballRow() {
        return 0;
    }
    public int getEyeballColumn() {
        return 0;
    }
    public void addEyeball(int row, int column, Direction direction) {
    }
    public boolean canMoveTo(int row, int column) {
        return false;
    }
    public boolean hasBlankFreePathTo(int row, int column) {
        return false;
    }
    public boolean isDirectionOK(int row, int column) {
        return false;
    }
    public Direction getEyeballDirection() {
        return null;
    }
    public Message checkDirectionMessage(int row, int column) {
        return null;
    }
    public Message checkMessageForBlankOnPathTo(int row, int column) {
        return null;
    }
    public Message messageIfMovingTo(int row, int column) {
        return Message.OK;
    }
    public void moveTo(int row, int column) {
    }
}
