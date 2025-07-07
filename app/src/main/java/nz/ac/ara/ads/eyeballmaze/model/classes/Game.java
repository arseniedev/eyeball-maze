package nz.ac.ara.ads.eyeballmaze.model.classes;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import nz.ac.ara.ads.eyeballmaze.enums.*;
import nz.ac.ara.ads.eyeballmaze.model.exceptions.InvalidCoordinateException;
import nz.ac.ara.ads.eyeballmaze.model.interfaces.*;

public class Game implements ILevelHolder, IGoalHolder, ISquareHolder, IEyeballHolder,IMoving {

    EyeBall theEyeball;
    protected int currentLevel;
    private GameLevel gameLevel;
    private final List<GameLevel> levelCollection =  new ArrayList<>();
    Map <Position, Square> squareCollection = new HashMap<>();
    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public Game() {
        this.currentLevel = 0;
    }

    @Override
    public void addLevel(int height, int width) {
        gameLevel = new GameLevel(height, width);
        this.levelCollection.add(gameLevel);
    }
    @Override
    public int getLevelWidth() {
//        GameLevel current = this.levelCollection.get(this.currentLevel);
//        return current.levelWidth;
        return this.gameLevel.levelWidth;
    }
    @Override
    public int getLevelHeight() {
//        GameLevel current = this.levelCollection.get(this.currentLevel);
//        return current.levelWidth;
        return this.gameLevel.levelHeight;
    }

    @Override
    public int getLevelCount() {
        return this.levelCollection.size();
//        return this.currentLevel;
    }
    @Override
    public void setLevel(int newLevel) {
        /*
        - new level also means:
        > resetting move count to 0
        > changing level name to 1
        > changing target goals
        > resetting goals completed to 0

        >resetting the eyeball position to start
        > changing the shapes & colors of the grids (some will no longer be playable
        > removing current goals + adding new one
        > changing the eyeball (direction and/or position)

        * */
        try {
            LOGGER.log(Level.INFO, "Setting level: " + newLevel);
            GameLevel level = this.levelCollection.get(newLevel);
            this.currentLevel = newLevel;

            if (level == null) {
                throw new IndexOutOfBoundsException();
            } else {
                // TODO: apply all the needed changes when changing the level
//                addGoal();
//                addEyeball();

                LOGGER.log(Level.INFO, Message.OK.name());
            }
        } catch (IndexOutOfBoundsException exception) {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.INDEX_OUT_OF_BOUNDS));
        } catch(Exception unknown) {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.UNKNOWN_EXCEPTION));
        } finally {
            LOGGER.log(Level.INFO, "Setting level count: " + this.currentLevel);
        }
    }
    @Override
    public void addGoal(int row, int column) {
        try {
            if (this.isValidCoordinate(row,column)) {
                LOGGER.log(Level.INFO, "Adding a goal at: " + row + ", " + column);
                Square grid = this.getSquareAt(row, column);

                if (grid instanceof PlayableSquare) {
                    ((PlayableSquare) grid).markAsGoal();
                    LOGGER.log(Level.INFO, "PlayableSquare added for a goal");
                    // Updating the level count
                    GameLevel gameLevel = this.levelCollection.get(this.currentLevel);
                    gameLevel.totalGoalCount++;
                }
                LOGGER.log(Level.INFO, "Non-PlayableSquare NOT added for a goal");

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
        GameLevel gameLevel = this.levelCollection.get(this.currentLevel);
        return gameLevel.getTotalGoalCount();
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
        Position position = Position.at(row, column);
        LOGGER.log(Level.INFO, "Getting square at: " + position);
        square = this.squareCollection.get(position);

        return square;
    }

    @Override
    public void addSquare(Square square, int row, int column) {
        try {
            if (this.isValidCoordinate(row,column)) {
                Position position = Position.at(row, column);
                this.squareCollection.put(position,square);

                LOGGER.log(Level.INFO, "Square cell added." +
                        "\nShape: " + square.getShape() +
                        "\nColor: " + square.getColor() +
                        "\nKey:" + position);

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
    public void addEyeball(int row, int column, Direction direction) {
        try {
            if (this.isValidCoordinate(row,column)) {
                LOGGER.log(Level.INFO, "Creating an eyeball at: " + row + ", " + column);
                Position position = new Position(row, column);
                this.theEyeball = new EyeBall(position, direction);
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
        return this.theEyeball.getRow();
    }
    @Override
    public int getEyeballColumn() {
        return this.theEyeball.getCol();
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

        int eyeballRow = this.theEyeball.getRow();
        int eyeballColumn = this.theEyeball.getCol();

        boolean isSameColor = this.getColorAt(eyeballRow,eyeballColumn).equals(targetColor);
        boolean isSameShape = this.getShapeAt(eyeballRow,eyeballColumn).equals(targetShape);

        return isSameColor || isSameShape;
    }
    @Override
    public boolean hasBlankFreePathTo(int newYDestination, int newXDestination) {
        int column = theEyeball.getCol();
        int row = theEyeball.getRow();

        LOGGER.log(Level.INFO, "Checking for current: row: " + column + ", column: " + row);
        Direction direction = this.theEyeball.getDirection();

        LOGGER.log(Level.INFO, "Checking for direction: " + direction);

        boolean isNotBlank = true;
        boolean isMovingHorizontal =  direction == Direction.RIGHT|| direction == Direction.LEFT;
        boolean isMovingVertical = direction == Direction.UP || direction == Direction.DOWN;
        if (isMovingHorizontal || isMovingVertical) {
            for (Map.Entry<Position, Square> entry : this.squareCollection.entrySet()) {
                Position position = entry.getKey();
                int targetX = position.col();
                int targetY = position.row();

                Square square = entry.getValue();
                boolean isABlankSquare = square instanceof BlankSquare;
                boolean isInBetweenOldAndNewPosition = isMovingHorizontal ?
                        (targetX <= newXDestination && targetX >= column) || targetX >= newXDestination && targetX <= column :
                        (targetY <= newYDestination && targetY >= row) || (targetY >= newYDestination && targetY <= row);
                if (isABlankSquare && isInBetweenOldAndNewPosition) {
                    isNotBlank = false;
                    break;
                }
            }
        } else {
            LOGGER.log(Level.INFO, String.valueOf(Message.MOVING_DIAGONALLY));
        }
        return isNotBlank;
    }

    @Override
    public boolean isDirectionOK(int destinationRow, int destinationColumn) {
        boolean result;
        Direction eyeBallFacingDirection = this.theEyeball.getDirection();
        this.theEyeball.moveTo(destinationRow, destinationColumn);
        Direction newDirection = this.theEyeball.getDirection();

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
        Direction newDirection = this.theEyeball.getDirection();

        if (newDirection == Direction.DIAGONAL) {
            return Message.MOVING_DIAGONALLY;
        } else {
            return !this.isDirectionOK(newYDestination,newXDestination) ? Message.OK : Message.BACKWARDS_MOVE;
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
        Square currentSquare = new BlankSquare(new Position(row,column));
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
//            this.theEyeball.moveTo(row,column);
            this.theEyeball.confirmMove();

            if (this.hasGoalAt(row,column)) {
                // Update goal completed
                this.gameLevel.goalCompleted(row,column);
//                destinationSquare.isGoal = false;
                if (this.gameLevel.isLevelComplete()) {
                    LOGGER.log(Level.INFO, "Level Complete");
                }
            }
        } else {
            LOGGER.log(Level.WARNING, String.valueOf(ErrorCode.INVALID_MOVE));
        }
    }
    @Override
    public int getCompletedGoalCount() {
        GameLevel gameLevel = this.levelCollection.get(this.currentLevel);
        return gameLevel.getCompletedGoals();
    }
}