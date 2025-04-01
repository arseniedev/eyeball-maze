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
    private final List<Position> gridCollection =  new ArrayList<Position>();
//    private final List<SquareData> gridCollection =  new ArrayList<SquareData>();
    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public Game() {
        this.levelCount = 0;
    }

    public void addLevel(int row, int column) {
//        this.gridCollection.add(Color.RED, Shape.DIAMOND, new Position(row,column));
        this.gridCollection.add(new Position(row,column));
//        this.levelCount ++;
//        this.levelCount = this.gridCollection.size();

    }
    public int getLevelWidth() {
        return this.gridCollection.get(this.levelCount).getColumn(); //.position()
    }
    public int getLevelHeight() {
        return this.gridCollection.get(this.levelCount).getRow(); //.position()
    }
    public int getLevelCount() {
        return this.levelCount;
    }
    public void setLevel(int level) {
        if (level > this.gridCollection.size()) {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.INDEX_OUT_OF_BOUNDS));
        } else {
            LOGGER.log(Level.INFO, "Setting level: " + level);
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
