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

    protected int levelWidth;
    protected int levelHeight;
    protected int levelCount;
//    protected int lastIndex;

    private final List<Position> levelPath =  new ArrayList<Position>();

    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public Game() {
//        this.levelPath.clear();
        this.levelCount = 0;
    }

    public void addLevel(int row, int column) {
        this.levelPath.add(new Position(row,column));
        this.levelCount ++;
    }
    public int getLevelWidth() {
//        return this.levelWidth;
//        LOGGER.log(Level.INFO, "Current count: " + this.levelCount);
        return this.levelWidth = this.levelPath.get(this.levelCount).getColumn();
    }
    public int getLevelHeight() {
//        return this.levelHeight;
//        LOGGER.log(Level.INFO, "Current count: " + this.levelCount);
        return this.levelHeight = this.levelPath.get(this.levelCount).getRow();
    }
    public int getLevelCount() {
//        int lastIndex = this.levelPath.size() - 1;
//        if (lastIndex >= 0) {
//            LOGGER.log(Level.INFO, "Setting level " + num);
//            this.levelCount = num;
////            System.out.println("Last element: " + list.get(lastIndex));
//        } else {
////            System.out.println("The list is empty.");
//        }

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
