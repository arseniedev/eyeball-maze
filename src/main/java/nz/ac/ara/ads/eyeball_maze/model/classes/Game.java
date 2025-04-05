package nz.ac.ara.ads.eyeball_maze.model.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import nz.ac.ara.ads.eyeball_maze.enums.*;
import nz.ac.ara.ads.eyeball_maze.model.exceptions.InvalidCoordinateException;
import nz.ac.ara.ads.eyeball_maze.model.interfaces.*;

public class Game implements ILevelHolder, IGoalHolder, ISquareHolder, IEyeballHolder,IMoving {
    protected GameLevel gameLevel;
    EyeBall theEyeball;
    protected int levelCount;

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
        try {
            LOGGER.log(Level.INFO, "Setting level: " + newLevel);

            this.levelCount = newLevel;
            this.gameLevel = this.levelCollection.get(newLevel);

            LOGGER.log(Level.INFO, Message.OK.name());

        } catch (IndexOutOfBoundsException exception) {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.INDEX_OUT_OF_BOUNDS));
        } catch(Exception unknown) {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.UNKNOWN_EXCEPTION));
        } finally {
            LOGGER.log(Level.INFO, "Setting level count: " + this.levelCount);
        }
    }

    @Override
    public void addGoal(int row, int column) {
        try {
            if (this.isValidCoordinate(row,column)) {
                LOGGER.log(Level.INFO, "Adding a goal at: " + row + ", " + column);
                Square square = this.getSquareAt(row, column);
                if (square == null) {
                    square = new PlayableSquare();
                    this.addSquare(square, row, column);
                    LOGGER.log(Level.INFO, "Empty PlayableSquare added for a goal");
                }
                square.isGoal = true;
                this.gameLevel.totalGoalCount++;
            } else {
                throw new InvalidCoordinateException(String.valueOf(ErrorCode.INDEX_OUT_OF_BOUNDS));
            }
        } catch (InvalidCoordinateException exception) {
            LOGGER.log(Level.SEVERE, "Failed to add goal:" + exception);
            throw new IllegalArgumentException(exception.getMessage());
        } finally {
            LOGGER.log(Level.INFO, "Goal addition process performed");
        }
    }

    private boolean isValidCoordinate(int row, int column) {
        int widthBoundary = this.getLevelWidth();
        int heightBoundary = this.getLevelHeight();

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
        Square square;
            String coordinateKey = this.generateCoordinateKey(row,column);
            LOGGER.log(Level.INFO, "Getting square at: " + coordinateKey);
            square = this.squareCollection.get(coordinateKey);

        return square;
    }

    private String generateCoordinateKey(int row, int column){
        return row + "," + column;
    }

    @Override
    public void addSquare(Square square, int row, int column) {
        try {
            if (this.isValidCoordinate(row,column)) {
                String coordinateKey = this.generateCoordinateKey(row,column);
                this.squareCollection.put(coordinateKey,square);

                LOGGER.log(Level.INFO, "Square cell added." +
                        "\nShape: " + square.getShape() +
                        "\nColor: " + square.getColor() +
                        "\nKey:" + coordinateKey);

            } else {
                throw new IllegalArgumentException(String.valueOf(ErrorCode.INDEX_OUT_OF_BOUNDS));
            }
        } catch (IllegalArgumentException  e) {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.INDEX_OUT_OF_BOUNDS));
        }  catch (Exception unknown) {
            LOGGER.log(Level.WARNING, ErrorCode.UNKNOWN_EXCEPTION.name(), unknown);
        } finally {
            LOGGER.log(Level.INFO, "Square addition process performed");
        }
    }

    @Override
    public void addEyeball(int currentY, int currentX, Direction direction) {
        try {
            if (this.isValidCoordinate(currentY,currentX)) {
                LOGGER.log(Level.INFO, "Creating an eyeball at: " + currentY + ", " + currentX);
                this.theEyeball = new EyeBall(currentY, currentX, direction);
            } else {
                throw new InvalidCoordinateException (String.valueOf(ErrorCode.INDEX_OUT_OF_BOUNDS));
            }
        } catch (InvalidCoordinateException e) {
            throw new IllegalArgumentException (String.valueOf(ErrorCode.INDEX_OUT_OF_BOUNDS));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            LOGGER.log(Level.INFO, "Eyeball addition process performed");
        }
    }
    @Override
    public int getEyeballRow() {
        return this.theEyeball.getYPosition();
    }
    @Override
    public int getEyeballColumn() {
        return this.theEyeball.getXPosition();
    }

    @Override
    public Direction getEyeballDirection() {
//         Returns what is the direction it is facing
        return this.theEyeball.getDirection();
    }

    @Override
    public boolean canMoveTo(int newYDestination, int newXDestination) {
        boolean result = false;
        LOGGER.log(Level.INFO, "Checking if canMoveTo at row: " + newYDestination + ", column: " + newXDestination);

        Square square = this.getSquareAt(newYDestination, newXDestination);

           return square instanceof PlayableSquare
            && this.isDirectionOK(newYDestination, newXDestination)
            &&  isMatchingShapeOrColor(square);
    }

    private boolean isMatchingShapeOrColor(Square targetSquare) {
        Color targetColor = targetSquare.getColor();
        Shape targetShape = targetSquare.getShape();

        int eyeballRow = this.theEyeball.currentYPosition;
        int eyeballColumn = this.theEyeball.currentXPosition;


        boolean isSameColor = this.getColorAt(eyeballRow,eyeballColumn).equals(targetColor);
        boolean isSameShape = this.getShapeAt(eyeballRow,eyeballColumn).equals(targetShape);

        return isSameColor || isSameShape;
    }

    @Override
    public boolean hasBlankFreePathTo(int newYDestination, int newXDestination) {
        int currentX = theEyeball.currentXPosition;
        int currentY = theEyeball.currentYPosition;


        LOGGER.log(Level.INFO, "Checking for current: row: " + currentX + ", column: " + currentY);
        Direction direction = this.theEyeball.getNewEyeballFacingDirection(newYDestination,newXDestination);
        LOGGER.log(Level.INFO, "Checking for direction: " + direction);
        boolean isBlankFree = true;
        boolean isMovingHorizontal = direction == Direction.RIGHT || direction == Direction.LEFT;
        boolean isMovingVertical = direction == Direction.UP || direction == Direction.DOWN;
        if (isMovingHorizontal || isMovingVertical) {
            /*
             * https://docs.oracle.com/javase/8/docs/api/java/util/Map.Entry.html
             * */
            for (Map.Entry<String, Square> square: this.squareCollection.entrySet()) {
                String coordinateKey = square.getKey();
                int keyY = Integer.parseInt(coordinateKey.split(",")[0]);
                int keyX = Integer.parseInt(coordinateKey.split(",")[1]);

                Square squareValue = square.getValue();
                boolean isABlankSquare = squareValue instanceof BlankSquare;
                boolean isInBetweenOldAndNewPosition = isMovingHorizontal ?
                        (keyX <= newXDestination && keyX >= currentX) || keyX >= newXDestination && keyX <= currentX:
                        (keyY <= newYDestination && keyY >= currentY) || (keyY >= newYDestination && keyY <= currentY);
                if (isABlankSquare && isInBetweenOldAndNewPosition) {
                    isBlankFree = false;
                    break;
                } else{
                    LOGGER.log(Level.INFO, "Searching for blank squares...");
                }
            }
        } else {
            LOGGER.log(Level.INFO, String.valueOf(Message.MOVING_DIAGONALLY));
        }
        return isBlankFree;
    }

    @Override
    public boolean isDirectionOK(int newYDestination, int newXDestination) {
        boolean result;
        Direction eyeBallFacingDirection = this.theEyeball.getDirection();
        this.theEyeball.updateEyeball(newYDestination, newXDestination);

        Direction newDirection = this.theEyeball.currentDirection;

        if (newDirection == Direction.DIAGONAL) {
            result = false;
        } else {
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
                case DIAGONAL -> false;
            };
        }
        return result;
    }

    @Override
    public Message checkDirectionMessage(int newYDestination, int newXDestination) {
        Direction newDirection = this.theEyeball.getNewEyeballFacingDirection(newYDestination,newXDestination);

        if (newDirection == Direction.DIAGONAL) {
            return Message.MOVING_DIAGONALLY;
        } else {
            return this.isDirectionOK(newYDestination,newXDestination) ? Message.BACKWARDS_MOVE : Message.OK;
        }
    }

    @Override
    public Message checkMessageForBlankOnPathTo(int newYDestination, int newXDestination) {
        boolean isBlankFree = this.hasBlankFreePathTo(newYDestination, newXDestination);
        return isBlankFree? Message.OK: Message.MOVING_OVER_BLANK;
    }

    @Override
    public Message messageIfMovingTo(int row, int column) {
        if (this.canMoveTo(row,column)) {
            return Message.OK;
        } else {
            return Message.DIFFERENT_SHAPE_OR_COLOR;
        }
    }

    private void updateGoalSquare() {
        int row = this.getEyeballRow();
        int column = this.getEyeballColumn();
        Square currentSquare = new BlankSquare();
        this.addSquare(currentSquare, row,column);
    }

    @Override
    public void moveTo(int row, int column) {
        this.updateGoalSquare();
        Square destinationSquare = this.getSquareAt(row, column);
        String squareType = destinationSquare.getClass().getSimpleName();

        if(destinationSquare instanceof PlayableSquare) {
            LOGGER.log(Level.INFO, "This is a " + squareType);

            LOGGER.log(Level.INFO, "Moving " + squareType + " to " + row + ", " + column);
            this.theEyeball.updateEyeball(row,column);

            if (this.hasGoalAt(row,column)) {
                this.gameLevel.completedGoalCount++;
                this.gameLevel.totalGoalCount--;
                destinationSquare.isGoal = false;
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
