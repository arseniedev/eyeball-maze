package nz.ac.ara.ads.eyeball_maze.model.classes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.*;

import nz.ac.ara.ads.eyeball_maze.enums.*;
import nz.ac.ara.ads.eyeball_maze.model.interfaces.*;


public class Game {
    protected int levelCount;
    private final List<Position> levelPath =  new ArrayList<Position>();
    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public Game() {
        this.levelCount = 0;
    }

    public void addLevel(int row, int column) {
        this.levelPath.add(new Position(row,column));
        this.levelCount ++;
//        if (this.levelCount > 0) {
//            LOGGER.log(Level.INFO, "Not Empty " + this.levelPath.size());
//            this.levelCount = this.levelPath.size();
//        } else {
//            LOGGER.log(Level.INFO, "Empty " + this.levelPath.size());
//            this.levelCount ++;
//        }
    }
    public int getLevelWidth() {
//        try {
            return this.levelPath.get(this.levelCount - 1).getColumn();
//        }
//        catch (IndexOutOfBoundsException exception) {
//            throw new IndexOutOfBoundsException(exception.getMessage());
//        }
////        LOGGER.log(Level.INFO, "Width " + this.levelPath.get(this.levelCount).getColumn());
    }
    public int getLevelHeight() {
//        try {
            return this.levelPath.get(this.levelCount - 1).getRow();
//        }
//        catch (IndexOutOfBoundsException exception) {
//            throw new IndexOutOfBoundsException(exception.getMessage());
//        }
//        LOGGER.log(Level.INFO, "Height " + this.levelPath.get(this.levelCount).getRow());
//        return this.levelPath.get(this.levelCount).getRow();
    }
    public int getLevelCount() {

        return this.levelCount;
    }
    public void setLevel(int level) {
        if (level > this.levelPath.size()) {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.INDEX_OUT_OF_BOUNDS));
        } else {
            LOGGER.log(Level.INFO, "Setting level: " + this.levelPath.size());
            this.levelCount = level;
            LOGGER.log(Level.INFO, Message.OK.name());
        }
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
