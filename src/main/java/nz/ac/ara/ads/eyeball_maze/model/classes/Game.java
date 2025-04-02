package nz.ac.ara.ads.eyeball_maze.model.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import nz.ac.ara.ads.eyeball_maze.enums.*;
import nz.ac.ara.ads.eyeball_maze.model.interfaces.*;

public class Game implements ILevelHolder, IGoalHolder, ISquareHolder, IEyeballHolder,IMoving {
    protected int levelCount;
    protected int completedGoalCount;

    private final List<Position> levelCollection =  new ArrayList<>();
//    private final List<Position> goalCollection =  new ArrayList<>();
//    private final List<EyeBall> eyeBallCollection = new ArrayList<>();
//    Map <Position, Square> squareCollection = new HashMap<>();
    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public Game() {
        this.levelCount = 0;
        this.completedGoalCount = 0;
    }

    @Override
    public void addLevel(int row, int column) {
//        this.levelCollection.add(Color.RED, Shape.DIAMOND, new Position(row,column));
        this.levelCollection.add(new Position(row,column));
        this.levelCount ++;

    }
    @Override
    public int getLevelWidth() {
        return this.levelCollection.get(this.levelCount -1).getColumn(); //.position()
    }

    @Override
    public int getLevelHeight() {
        return this.levelCollection.get(this.levelCount -1).getRow(); //.position()
    }

    @Override
    public int getLevelCount() {
        return this.levelCount;
    }

    @Override
    public void setLevel(int level) {
        if (level > this.levelCollection.size()) {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.INDEX_OUT_OF_BOUNDS));
        } else {
            LOGGER.log(Level.INFO, "Setting level: " + level);
            this.levelCount = level + 1;
            LOGGER.log(Level.INFO, Message.OK.name());
        }
    }
    @Override
    public void addGoal(int row, int column) {
        if (this.validCoordinate(row,column)) {
            LOGGER.log(Level.INFO, "Adding a goal at: " + row + ", " + column);
            this.goalCollection.add(new Position(row,column));
            LOGGER.log(Level.INFO, Message.OK.name());
        } else {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.INDEX_OUT_OF_BOUNDS));
        }
    }
    private boolean validCoordinate(int row, int column) {
        return this.levelCollection.stream().anyMatch(position -> position.getRow() >= row && position.getColumn() >= column);
    }

//    private Square getS(int row, int column) {
//        Position key = new Position(row,column);
//        return this.squareCollection.containsKey(key)
//    }

    @Override
    public int getGoalCount() {
        return 0;
//        return this.goalCollection.size();
    }

    @Override
    public boolean hasGoalAt(int row, int column) {
        return false;
//        LOGGER.log(Level.INFO, "Checking if goal at row: " + row + ", column: " + column);
//
//        Position targetPosition = new Position(row,column);
//        return this.goalCollection.contains(targetPosition);
    }

    @Override
    public Color getColorAt(int row, int column) {
        Color output = Color.BLANK;
//        LOGGER.log(Level.INFO, "Checking color at row: " + row + ", column: " + column);
//        for (Map.Entry<Position, Square> entry : this.squareCollection.entrySet()) {
//            if (entry.getKey().row == row && entry.getKey().column == column) {
//                output = entry.getValue().getColor();
//                LOGGER.log(Level.INFO, "output: " + output);
//            }
//        }
        return output;
    }
    @Override
    public void addSquare(Square square, int row, int column) {
//        if (this.validCoordinate(row,column)) {
//            Position sqPosition = new Position(row,column);
//
//            LOGGER.log(Level.INFO, "Adding a square shape" + square.getShape() + ", color:" + square.getColor());
//            this.squareCollection.put(sqPosition,square);
//
//        } else {
//            throw new IllegalArgumentException(String.valueOf(ErrorCode.INDEX_OUT_OF_BOUNDS));
//        }
    }

    @Override
    public Shape getShapeAt(int row, int column) {
        Shape output = Shape.BLANK;
//        LOGGER.log(Level.INFO, "Checking shape at row: " + row + ", column: " + column);
//        for (Map.Entry<Position, Square> entry : this.squareCollection.entrySet()) {
//            if (entry.getKey().row == row && entry.getKey().column == column) {
//                output = entry.getValue().getShape();
//                LOGGER.log(Level.INFO, "output: " + output);
//            }
//        }
        return output;

    }

    @Override
    public void addEyeball(int row, int column, Direction direction) {
//        if (this.validCoordinate(row,column)) {
//            Position position = new Position(row,column);
//
//            LOGGER.log(Level.INFO, "Adding an eyeball at: " + row + ", " + column);
//            this.eyeBallCollection.add(new EyeBall(position, direction));
//            LOGGER.log(Level.INFO, Message.OK.name());
//        } else {
//            throw new IllegalArgumentException(String.valueOf(ErrorCode.INDEX_OUT_OF_BOUNDS));
//        }
    }
    @Override
    public int getEyeballRow() {
        return 0;
//        return this.eyeBallCollection.get(this.levelCount -1).position.getRow(); //.position()
    }
//
    @Override
    public int getEyeballColumn() {
        return 0;
//        return this.eyeBallCollection.get(this.levelCount -1).position.getColumn();
    }

    @Override
    public boolean canMoveTo(int row, int column) {
//        LOGGER.log(Level.INFO, "Checking if canMoveTo at row: " + row + ", column: " + column);
////        LOGGER.log(Level.INFO, "Eyeball: " + this.eyeBallCollection.size());
//        // Eyeballs props
//        Position targetPosition = new Position(row,column);
//        /*
//        * Is it in bound
//        * Same color and shape
//        * It is not the same cell
//        * */
//        Shape shape = this.getShapeAt(row,column);
//        Color squareColor = this.getColorAt(row,column);
////        PlayableSquare square =  this.squareCollection.get(targetPosition);
////        this.squareCollection.containsKey()
//        // match first
//        // then check type is playable
//
//
////        LOGGER.log(Level.INFO, "Eyeball:" + this.eyeBallCollection.size());
        return false;
    }

    @Override
    public boolean hasBlankFreePathTo(int row, int column) {
        return false;
    }

    @Override
    public boolean isDirectionOK(int row, int column) {
        return false;
    }

    @Override
    public Direction getEyeballDirection() {
        return this.eyeBallCollection.get(this.levelCount -1).direction; //.position()
    }

    @Override
    public Message checkDirectionMessage(int row, int column) {
        return null;
    }

    @Override
    public Message checkMessageForBlankOnPathTo(int row, int column) {
        Color color = this.getColorAt(row,column);
        Shape shape = this.getShapeAt(row,column);
        if (shape == Shape.BLANK && color == Color.BLANK) {
            return Message.MOVING_OVER_BLANK;
        }
        return null;
    }

    @Override
    public Message messageIfMovingTo(int row, int column) {
        return Message.OK;
    }

    @Override
    public void moveTo(int row, int column) {
        if (this.hasGoalAt(row,column)) {
            this.completedGoalCount++;
        }
//        return this.getCompletedGoalCount();

    }

    @Override
    public int getCompletedGoalCount() {
        return completedGoalCount;
    }

}
