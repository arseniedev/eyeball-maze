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
    private final List<Position> levelCollection =  new ArrayList<>();
    private final List<Position> goalCollection =  new ArrayList<>();
    private final List<SquareData> squareCollection =  new ArrayList<>();
    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public Game() {
        this.levelCount = 0;
    }

    public void addLevel(int row, int column) {
//        this.levelCollection.add(Color.RED, Shape.DIAMOND, new Position(row,column));
        this.levelCollection.add(new Position(row,column));
        this.levelCount ++;
//        this.levelCount = this.levelCollection.size();

    }
    public int getLevelWidth() {
        return this.levelCollection.get(this.levelCount -1).getColumn(); //.position()
    }
    public int getLevelHeight() {
        return this.levelCollection.get(this.levelCount -1).getRow(); //.position()
    }
    public int getLevelCount() {
        return this.levelCount;
    }
    public void setLevel(int level) {
        if (level > this.levelCollection.size()) {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.INDEX_OUT_OF_BOUNDS));
        } else {
            LOGGER.log(Level.INFO, "Setting level: " + level);
            this.levelCount = level + 1;
            LOGGER.log(Level.INFO, Message.OK.name());
        }
    }
    public void addGoal(int row, int column) {
        int validCoordinateCount = this.validCoordinateCount(row,column);
        if (validCoordinateCount > 0) {
            LOGGER.log(Level.INFO, "Adding a goal at: " + row + ", " + column);
            this.goalCollection.add(new Position(row,column));
            LOGGER.log(Level.INFO, Message.OK.name());
        } else {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.INDEX_OUT_OF_BOUNDS));
        }
    }
    private int validCoordinateCount(int row, int column) {
        int validCoordinateCount = 0;
        for (Position position : this.levelCollection) {
            LOGGER.log(Level.INFO, "row: " + position.getRow() + " column: " + position.getColumn());
            if (position.getRow() >= row && position.getColumn() >= column) {
                validCoordinateCount++;
            }
        }
        return validCoordinateCount;
    }
    public int getGoalCount() {
        return this.goalCollection.size();
    }
    public boolean hasGoalAt(int row, int column) {
        LOGGER.log(Level.INFO, "Checking if goal at row: " + row + ", column: " + column);
//        Position targetPosition = (Position) position;
//        return row == targetPosition.getRow() && column == targetPosition.getColumn();

        Position targetPosition = new Position(row,column);
        return this.goalCollection.contains(targetPosition);

//        LOGGER.log(Level.INFO, `${this.goalCollection}`);
    }
    public int getCompletedGoalCount() {
        return 0;
    }
    public void addSquare(Square square, int row, int column) {
        int validCoordinateCount = this.validCoordinateCount(row,column);
        if (validCoordinateCount > 0) {
            Color sqColor = square.color;
            Shape sqShape = square.shape;
            Position sqPosition = new Position(row,column);

            LOGGER.log(Level.INFO, "Adding a square at: " + row + ", " + column);
            this.squareCollection.add(new SquareData(sqColor,sqShape,sqPosition));
            LOGGER.log(Level.INFO, Message.OK.name());
        } else {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.INDEX_OUT_OF_BOUNDS));
        }
    }
    public Color getColorAt(int row, int column) {
        Color output = Color.BLANK;
        LOGGER.log(Level.INFO, "Checking colour at row: " + row + ", column: " + column);
        int targetRow;
        int targetColumn;
        for (SquareData grid : this.squareCollection) {
            targetRow = grid.position().getRow();
            targetColumn = grid.position().getColumn();

            if (targetRow == row && targetColumn == column) {
                LOGGER.log(Level.INFO, String.valueOf(grid.color()));
                output = grid.color();
            }
//            else {
//                output = Color.BLANK;
//            }
        }
//        throw new IllegalArgumentException(String.valueOf(ErrorCode.COLOUR_NOT_FOUND));
//            else {
//            }

//        Position targetPosition = new Position(row,column);
//        return this.goalCollection.contains(targetPosition);
//        this.squareCollection
        return output;
    }
    public Shape getShapeAt(int row, int column) {
        Shape output = Shape.BLANK;
        LOGGER.log(Level.INFO, "Checking shape at row: " + row + ", column: " + column);
        int targetRow;
        int targetColumn;
        for (SquareData grid : this.squareCollection) {
            targetRow = grid.position().getRow();
            targetColumn = grid.position().getColumn();

            if (targetRow == row && targetColumn == column) {
                LOGGER.log(Level.INFO, String.valueOf(grid.shape()));
                output = grid.shape();
            }
//            else {
//                output = Shape.BLANK;
//            }
        }
//        throw new IllegalArgumentException(String.valueOf(ErrorCode.SHAPE_NOT_FOUND));
        return output;
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
