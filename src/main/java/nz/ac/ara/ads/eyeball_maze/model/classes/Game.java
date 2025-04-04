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
    protected GameLevel gameLevel;
    EyeBall theEyeball;
    protected int levelCount = 0;
    private String currentStatusMessage;

    private final List<GameLevel> levelCollection =  new ArrayList<>();
    Map <String, Square> squareCollection = new HashMap<>();
//    Map <Position, Square> blankSquareCollection = new HashMap<>();
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
        String coordinateKey =  row + "," + column;
        LOGGER.log(Level.INFO, "Getting square at: " + coordinateKey);
        Square square = this.squareCollection.get(coordinateKey);

        if (square == null) {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.SQUARE_NOT_FOUND));
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
    public void addEyeball(int currentY, int currentX, Direction direction) {
        if (this.isValidCoordinate(currentY,currentX)) {
            LOGGER.log(Level.INFO, "Creating an eyeball at: " + currentY + ", " + currentX);
            this.theEyeball = new EyeBall(currentY, currentX, direction);
        } else {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.INDEX_OUT_OF_BOUNDS));
        }
    }
    @Override
    public int getEyeballRow() {
        return this.theEyeball.getYPosition();
    }
//
    @Override
    public int getEyeballColumn() {
        return this.theEyeball.getXPosition();
    }

    private Direction getNewEyeballDirection(int newYDestination, int newXDestination) {
//         Returns the direction it is taking
        Direction direction;

        int currentY= this.theEyeball.currentYPosition;
        int currentX = this.theEyeball.currentXPosition;

        if (newYDestination == currentY) {
            // moving horizontal: left/right
            direction = newXDestination > currentX ? Direction.RIGHT : Direction.LEFT;

        } else if (newXDestination == currentX) {
            // moving vertical: up/down
            direction = newYDestination > currentY ? Direction.UP : Direction.DOWN;
        } else {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.INVALID_MOVE));
        }
        return direction;
    }

    @Override
    public Direction getEyeballDirection() {
////         Returns what is the direction it is facing
        return this.theEyeball.getDirection();

    }

    @Override
    public boolean canMoveTo(int row, int column) {
        boolean result = false;
        LOGGER.log(Level.INFO, "Checking if canMoveTo at row: " + row + ", column: " + column);
        /*
         Check if this is a goal playable square
        * Is it in bound -> does it exist
        * Same color and shape
        * Is it a goal?
        * It is not the same cell
        */
        //if (this.hasGoalAt(row,column)) {
        Square square = this.getSquareAt(row, column);
        if (square instanceof PlayableSquare) {
            LOGGER.log(Level.INFO, "This is a valid cell");
            // Getting the shape and color of the destination square
            Color targetColor = square.getColor();
            Shape targetShape = square.getShape();

//            this currentEyeballColor = this.theEyeball.getColor();
            int eyeballRow = this.getEyeballRow();
            int eyeballColumn = this.getEyeballColumn();

            boolean isSameColor = this.getColorAt(eyeballRow,eyeballColumn).equals(targetColor);
            boolean isSameShape = this.getShapeAt(eyeballRow,eyeballColumn).equals(targetShape);

            result =  isSameColor || isSameShape;
//            }
        } else {
            LOGGER.log(Level.WARNING, "Can not move to " + row + ", " + column);
        }
        return result;
    }

    @Override
    public boolean hasBlankFreePathTo(int row, int column) {
        return false;
    }

    @Override
    public boolean isDirectionOK(int newYDestination, int newXDestination) {
        boolean result;
        Direction eyeBallFacingDirection = this.theEyeball.getDirection();
        this.theEyeball.updateEyeball(newYDestination, newXDestination);
        Direction newDirection = this.getNewEyeballDirection(newYDestination,newXDestination);

        // This will handle what it should not be ...
        result = switch(eyeBallFacingDirection) {
            // Moving horizontal, AND moving left
            case LEFT -> newDirection != Direction.RIGHT;
            // Moving horizontal,AND moving right
            case RIGHT -> newDirection != Direction.LEFT;
            // Moving vertical, AND moving up
            case UP -> newDirection != Direction.DOWN;
            // Moving vertical, AND moving down
            case DOWN -> newDirection != Direction.UP;
        };

        return result;
    }

    @Override
    public Message checkDirectionMessage(int row, int column) {
        return this.isDirectionOK(row,column) ? Message.OK : Message.BACKWARDS_MOVE;
    }

    @Override
    public Message checkMessageForBlankOnPathTo(int newYDestination, int newXDestination) {
        int currentX = theEyeball.currentXPosition;
        int currentY = theEyeball.currentYPosition;
        LOGGER.log(Level.INFO, "Checking for current: row: " + currentX + ", column: " + currentY);
        Direction direction = this.getNewEyeballDirection(newYDestination,newXDestination);
        LOGGER.log(Level.INFO, "Checking for direction: " + direction);
        boolean hasBlank = false;

        boolean isMovingHorizontal = direction == Direction.RIGHT || direction == Direction.LEFT;
        boolean isMovingVertical = direction == Direction.UP || direction == Direction.DOWN;
        if (isMovingHorizontal || isMovingVertical) {
            for (Map.Entry<String, Square> square: this.squareCollection.entrySet()) {
                String coordinateKey = square.getKey();
                int keyY = Integer.parseInt(coordinateKey.split(",")[0]);
                int keyX = Integer.parseInt(coordinateKey.split(",")[1]);

                Square squareValue = square.getValue();
                boolean isABlankSquare = squareValue instanceof BlankSquare;
                boolean isInBetweenOldAndNewPosition = isMovingHorizontal ?
                        (keyX <= newXDestination && keyX >= currentX) :
                        (keyY <= newYDestination && keyY >= currentY);
                if (isABlankSquare && isInBetweenOldAndNewPosition) {
                    hasBlank = true;
                    break;
                } else{
                    LOGGER.log(Level.INFO, "Searching for blank squares...");
                }
            }
        } else {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.INVALID_MOVE));
        }
        return hasBlank? Message.MOVING_OVER_BLANK: Message.OK;
    }
//    public Message checkMessageForBlankOnPathTo(int newYDestination, int newXDestination) {
//        int currentX = theEyeball.currentXPosition;
//        int currentY = theEyeball.currentYPosition;
//        LOGGER.log(Level.INFO, "Checking for current: row: " + currentX + ", column: " + currentY);
//        Direction direction = this.getNewEyeballDirection(newYDestination,newXDestination);
//        LOGGER.log(Level.INFO, "Checking for direction: " + direction);
//        boolean hasBlank = false;
//
//        if (direction == Direction.RIGHT || direction == Direction.LEFT) {
//            for (Map.Entry<Position, Square> square: this.squareCollection.entrySet()) {
//                Position coordinateKey = square.getKey();
//                Square squareValue = square.getValue();
//                if (squareValue instanceof BlankSquare && (coordinateKey.column <= newXDestination && coordinateKey.column >= currentX
//                || coordinateKey.column >= newYDestination && coordinateKey.column <= currentX)) {
//                    hasBlank = true;
//                    break;
//                } else {
////                LOGGER.log(level.In);
//            }
//
//        }
//        } else if (direction == Direction.UP || direction == Direction.DOWN) {
//            for (Map.Entry<Position, Square> square: this.squareCollection.entrySet()) {
//                Position coordinateKey = square.getKey();
//                Square squareValue = square.getValue();
//                if (squareValue instanceof BlankSquare && (coordinateKey.row <= newYDestination && coordinateKey.row >= currentX
//                        || coordinateKey.row >= newYDestination && coordinateKey.row <= currentX)) {
//                    hasBlank = true;
//                    break;
//                } else {
//                    throw new IllegalArgumentException(String.valueOf(ErrorCode.INVALID_MOVE));
//                }
////                LOGGER.log(level.In);
//                }
//        } else {
//            throw new IllegalArgumentException(String.valueOf(ErrorCode.INVALID_MOVE));
//        }
//        return hasBlank? Message.MOVING_OVER_BLANK: Message.OK;
//    }

    @Override
    public Message messageIfMovingTo(int row, int column) {
        if (this.canMoveTo(row,column)) {
            return Message.OK;
        } else {
            return Message.DIFFERENT_SHAPE_OR_COLOR;
        }

    }

    @Override
    public void moveTo(int row, int column) {
        Square destinationSquare = this.getSquareAt(row, column);
        String squareType = destinationSquare.getClass().getSimpleName();

        if(destinationSquare instanceof PlayableSquare) {
            LOGGER.log(Level.INFO, "This is a " + squareType);
//            PlayableSquare playableSquare = (PlayableSquare) destinationSquare;

            LOGGER.log(Level.INFO, "Moving " + squareType + " to " + row + ", " + column);
            this.theEyeball.updateEyeball(row,column);
//            this.setNewEyeballDirection(row,column);

            if (this.hasGoalAt(row,column)) {
                this.gameLevel.completedGoalCount++;
                this.gameLevel.totalGoalCount--;
            }
        } else {
            LOGGER.log(Level.WARNING, String.valueOf(ErrorCode.INVALID_MOVE));
        }
    }

    @Override
    public int getCompletedGoalCount() {
        return this.gameLevel.completedGoalCount;
    }

}
