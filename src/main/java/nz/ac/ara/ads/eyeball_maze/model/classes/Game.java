package nz.ac.ara.ads.eyeball_maze.model.classes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.*;

import nz.ac.ara.ads.eyeball_maze.enums.*;


public class Game {

    protected int levelWidth;
    protected int levelHeight;
    protected int levelCount;

    private List<int[]> levelPath =  new ArrayList<int[]>();

//    private LogManager logManager = LogManager.getLogManager();
//    private Logger log = logManager.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public Game() {
        this.levelCount = 0;
//        this.levelWidth = 0;
//        this.levelHeight = 0;
    }
//    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public void addLevel(int row, int column) {
        this.levelWidth = column;
        this.levelHeight = row;

//        this.levelPath = new int[][]{{row, column}};
        this.levelPath.add(new int[]{row, column});
        this.levelCount ++;
    }
    public int getLevelWidth() {
        return this.levelWidth;
    }
    public int getLevelHeight() {
        return this.levelHeight;
    }
    public int getLevelCount() {
        return this.levelCount;
    }
    public void setLevel(int num) {
        LOGGER.log(Level.INFO, "Setting level " + num);
        this.levelHeight = this.levelPath.get(num)[0];
        this.levelWidth = this.levelPath.get(num)[1];
        LOGGER.log(Level.INFO,  this.levelWidth + ","+ this.levelHeight);
        this.levelCount = num;
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
