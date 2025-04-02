package nz.ac.ara.ads.eyeball_maze.model.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import nz.ac.ara.ads.eyeball_maze.enums.*;
import nz.ac.ara.ads.eyeball_maze.model.interfaces.*;
import org.jetbrains.annotations.NotNull;

public class Game implements ILevelHolder, IGoalHolder, ISquareHolder, IEyeballHolder,IMoving {
    protected GameLevel gameLevel;
    EyeBall theEyeball;
    protected int levelCount = 0;

    private final List<GameLevel> levelCollection =  new ArrayList<>();
    Map <String, Square> squareCollection = new HashMap<>();
    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public Game() {
        this.levelCount = 0;
    }

    @Override
    public void addLevel(int height, int width) {
        this.gameLevel = new GameLevel(this.levelCount, height, width);
        this.levelCollection.add(this.gameLevel);
        this.levelCount ++;
    }

    @Override
    public int getLevelWidth() {
        return this.gameLevel.getLevelWidth();
    }

    @Override
    public int getLevelHeight() {
        return this.gameLevel.getLevelHeight();
    }

    @Override
    public int getLevelCount() {
        return this.levelCount;
    }

    @Override
    public void setLevel(int newLevel) {
        /*
        * Inclusive: Array size means index or level number
        * newLevel 0 must get index 0
        * newLevel 1 must get index 1
        */
        if (newLevel >= this.levelCollection.size()) {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.INDEX_OUT_OF_BOUNDS));
        } else {
            LOGGER.log(Level.INFO, "Setting level: " + newLevel);

            // Displays it as it is
            this.levelCount = newLevel;

            this.gameLevel = this.levelCollection.get(newLevel);

            LOGGER.log(Level.INFO, Message.OK.name());
        }
    }
    @Override
    public void addGoal(int row, int column) {
        if (this.isValidCoordinate(row,column)) {
            LOGGER.log(Level.INFO, "Adding a goal at: " + row + ", " + column);

            Square newSquare = new PlayableSquare();
            this.addSquare(newSquare, row, column);

            newSquare.isGoal = true;
            this.gameLevel.totalGoalCount++;
        } else {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.INDEX_OUT_OF_BOUNDS));
        }
    }
    private boolean isValidCoordinate(int row, int column) {
        int widthBoundary = this.gameLevel.getLevelWidth();
        int heightBoundary = this.gameLevel.getLevelHeight();
        return row <= heightBoundary && row >= 0 && column <= widthBoundary && column >= 0;
    }

    @Override
    public int getGoalCount() {
        return this.gameLevel.totalGoalCount;
    }

    @Override
    public boolean hasGoalAt(int row, int column) {
        Square square = this.getSquareAt(row, column);
        return square.isGoal;
    }

    @Override
    public Color getColorAt(int row, int column) {
        return this.getSquareAt(row, column).getColor();
    }

    @Override
    public Shape getShapeAt(int row, int column) {
        return this.getSquareAt(row, column).getShape();
    }

    private Square getSquareAt(int row, int column) {
        String squareKey =  row + "," + column;
        LOGGER.log(Level.INFO, "Getting square at: " + squareKey);
        Square square = this.squareCollection.get(squareKey);
        if (square == null) {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.SHAPE_NOT_FOUND));
        }
        return square;
    }

    @Override
    public void addSquare(Square square, int row, int column) {
        if (this.isValidCoordinate(row,column)) {
            String squareType = square.getClass().getSimpleName();

            LOGGER.log(Level.INFO, "Adding a "+ squareType + " shape: " + square.getShape() + ", color: " + square.getColor() + " at row: " + row + ", column: " + column);

            /*
            * https://www.tutorialspoint.com/java/lang/class_getsimplename.htm
            */
            String coordinateKey = row + "," + column;
            this.squareCollection.put(coordinateKey,square);

        } else {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.INDEX_OUT_OF_BOUNDS));
        }
    }

    @Override
    public void addEyeball(int row, int column, Direction direction) {
        if (this.isValidCoordinate(row,column)) {
            LOGGER.log(Level.INFO, "Creating an eyeball at: " + row + ", " + column);
            Position position = new Position(row,column);
            this.theEyeball = new EyeBall(position, direction);

//            this.eyeBallCollection.add(new EyeBall(position, direction));
//            LOGGER.log(Level.INFO, Message.OK.name());
        } else {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.INDEX_OUT_OF_BOUNDS));
        }
    }
    @Override
    public int getEyeballRow() {
        return this.theEyeball.getXPosition();
    }
//
    @Override
    public int getEyeballColumn() {
        return this.theEyeball.getYPosition();
//        return this.eyeBallCollection.get(this.levelCount -1).position.getColumn();
    }

    @Override
    public Direction getEyeballDirection() {
        return this.theEyeball.getDirection();
//        return Direction.UP;
//        return this.eyeBallCollection.get(this.levelCount -1).direction; //.position()
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
    public Message checkDirectionMessage(int row, int column) {
        return null;
    }

    @Override
    public Message checkMessageForBlankOnPathTo(int row, int column) {
//        Color color = this.getColorAt(row,column);
//        Shape shape = this.getShapeAt(row,column);
//        if (shape == Shape.BLANK && color == Color.BLANK) {
//            return Message.MOVING_OVER_BLANK;
//        }
        return null;
    }

    @Override
    public Message messageIfMovingTo(int row, int column) {
        return Message.OK;
    }

    @Override
    public void moveTo(int row, int column) {
//        if (this.hasGoalAt(row,column)) {
//            this.completedGoalCount++;
//        }
//        return this.getCompletedGoalCount();

    }

    @Override
    public int getCompletedGoalCount() {
        return 0;
//        return completedGoalCount;
    }

}
