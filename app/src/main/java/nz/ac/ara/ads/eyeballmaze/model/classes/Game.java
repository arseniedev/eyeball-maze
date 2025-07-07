package nz.ac.ara.ads.eyeballmaze.model.classes;

import android.media.SoundPool;

import androidx.annotation.NonNull;

import java.util.*;
import java.util.logging.Logger;

import nz.ac.ara.ads.eyeballmaze.enums.*;
import nz.ac.ara.ads.eyeballmaze.model.data.LevelData;
import nz.ac.ara.ads.eyeballmaze.model.data.LevelRepository;
import nz.ac.ara.ads.eyeballmaze.model.exceptions.InvalidCoordinateException;
import nz.ac.ara.ads.eyeballmaze.model.interfaces.*;
import java.util.logging.Level;

public class Game implements ILevelHolder, IGoalHolder, ISquareHolder, IEyeballHolder,IMoving {
    protected GameLevel gameLevel;
    EyeBall theEyeball;
    protected int levelNumber;

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public int moveCount = 0;
    //    private SoundPool soundPool;
//    private int clickSoundId;
//    private boolean isSoundEnabled = false;
    private final List<GameLevel> levelCollection =  new ArrayList<>();
    Map <String, Square> squareCollection = new HashMap<>();
    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public Game() {
        this.levelNumber = 1;
    }
    @Override
    public void addLevel(int height, int width) {
        this.gameLevel = new GameLevel(this.levelNumber, height, width);
        this.levelCollection.add(this.gameLevel);
        this.levelNumber ++;
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
        return this.levelNumber;
    }
    @Override
    public void setLevel(int newLevel) {
        LevelData levelData = LevelRepository.LEVELS.get(levelNumber);
        if (levelData == null) {
            System.out.println("Level not found: " + levelNumber);
        } else {
            System.out.println("Loaded level " + levelNumber);
            List<PlayableSquare> squares = levelData.squares();
            gameLevel.totalGoalCount = levelData.totalGoalCount();
            // Access squares directly
            // Do something with squares if needed
        }
        try {
            LOGGER.log(java.util.logging.Level.INFO, "Setting level: " + newLevel);

            this.levelNumber = newLevel;
            this.gameLevel = this.levelCollection.get(newLevel);

            LOGGER.log(java.util.logging.Level.INFO, Message.OK.name());

        } catch (IndexOutOfBoundsException exception) {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.INDEX_OUT_OF_BOUNDS));
        } catch(Exception unknown) {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.UNKNOWN_EXCEPTION));
        } finally {
            LOGGER.log(java.util.logging.Level.INFO, "Setting level count: " + this.levelNumber);
        }
    }
    @Override
    public void addGoal(int row, int column) {
        //Records every goal reached, deducts goal completed
        // Celebrates in the end.
        try {
            if (this.isValidCoordinate(row,column)) {
                LOGGER.log(java.util.logging.Level.INFO, "Adding a goal at: " + row + ", " + column);
                Square square = this.getSquareAt(row, column);
                if (square == null) {
//                    square = new PlayableSquare();
                    this.addSquare(null, row, column);
                    LOGGER.log(java.util.logging.Level.INFO, "Empty PlayableSquare added for a goal");
                }
                assert square != null;
                square.isGoal = true;
                this.gameLevel.totalGoalCount++;
//                this.getCompletedGoalCount()

            } else {
                throw new InvalidCoordinateException(String.valueOf(ErrorCode.INDEX_OUT_OF_BOUNDS));
            }
        } catch (InvalidCoordinateException exception) {
            LOGGER.log(java.util.logging.Level.SEVERE, "Failed to add goal:" + exception);
            throw new IllegalArgumentException(exception.getMessage());
        } finally {
            LOGGER.log(java.util.logging.Level.INFO, "Goal addition process performed");
        }
    }
    private boolean isValidCoordinate(int row, int column) {
        int widthBoundary = this.getLevelWidth();
        int heightBoundary = this.getLevelHeight();

        return row <= heightBoundary && row >= 0 && column <= widthBoundary && column >= 0;
    }
    @Override
    public int getGoalCount() {
        LevelData levelData = LevelRepository.LEVELS.get("level" + (levelNumber));
        int goalCount = levelData != null ? levelData.totalGoalCount() : 0;
        LOGGER.log(Level.INFO, "Setting goal count: " + goalCount);
        this.gameLevel.totalGoalCount = goalCount;
//        return levelData != null ? levelData.totalGoalCount() : 0;
        return goalCount;
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
    @Override
    public int getCompletedGoalCount() {
        return 0;
    }
    public PlayableSquare getCurrentSquare() {
        for (var square : this.squareCollection.values()) {
            if (square.isCurrent()) {
                return (PlayableSquare) square;
            }
        }
        return null;
    }
    private Square getSquareAt(int row, int column) {
        Square square;
        String coordinateKey = this.generateCoordinateKey(row,column);
        LOGGER.log(java.util.logging.Level.INFO, "Getting square at: " + coordinateKey);
        square = this.squareCollection.get(coordinateKey);

        return square;
    }
    private String generateCoordinateKey(int row, int column){
        return row + "," + column;
    }

    //    @RequiresApi(api = Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    @Override
    public void addSquare(Square square, int row, int column) {
        try {
//                Metadata
                String coordinateKey = this.generateCoordinateKey(row,column);

                this.squareCollection.put(coordinateKey,square);

                LOGGER.log(Level.INFO, "Square cell added." +
                        "\nShape: " + square.getShape() +
                        "\nColor: " + square.getColor() +
                        "\nKey:" + coordinateKey);


        } catch (IllegalArgumentException  e) {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.INDEX_OUT_OF_BOUNDS));
        }  catch (Exception unknown) {
            LOGGER.log(java.util.logging.Level.WARNING, ErrorCode.UNKNOWN_EXCEPTION.name(), unknown);
        } finally {
            LOGGER.log(java.util.logging.Level.INFO, "Square addition process performed");
        }
    }
    public Direction rotateDirection(Direction currentDirection, boolean clockwise) {
        switch (currentDirection) {
            case UP: return clockwise ? Direction.RIGHT : Direction.LEFT;
            case RIGHT: return clockwise ? Direction.DOWN : Direction.UP;
            case DOWN: return clockwise ? Direction.LEFT : Direction.RIGHT;
            case LEFT: return clockwise ? Direction.UP : Direction.DOWN;
            default: return Direction.UP;
        }
    }
//    private void getDrawableFromSquare(Square square) {
//        Shape shape = square.getShape();
//        Color color = square.getColor();
//
    ////        if(shape==Shape.CIRCLE)
//    }
    @Override
    public void addEyeball(int currentY, int currentX, Direction direction) {
        try {
            if (this.isValidCoordinate(currentY,currentX)) {
                LOGGER.log(java.util.logging.Level.INFO, "Creating an eyeball at: " + currentY + ", " + currentX);
                this.theEyeball = new EyeBall(currentY, currentX, direction);
            } else {
                throw new InvalidCoordinateException (String.valueOf(ErrorCode.INDEX_OUT_OF_BOUNDS));
            }
        } catch (InvalidCoordinateException e) {
            throw new IllegalArgumentException (String.valueOf(ErrorCode.INDEX_OUT_OF_BOUNDS));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            LOGGER.log(java.util.logging.Level.INFO, "Eyeball addition process performed");
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
        LOGGER.log(java.util.logging.Level.INFO, "Checking if canMoveTo at row: " + newYDestination + ", column: " + newXDestination);

        Square square = this.getSquareAt(newYDestination, newXDestination);

        return square instanceof PlayableSquare
                && this.isDirectionOK(newYDestination, newXDestination)
                &&  isMatchingShapeOrColor(square);
    }
    private boolean isMatchingShapeOrColor(@NonNull Square targetSquare) {
        Color targetColor = targetSquare.getColor();
        Shape targetShape = targetSquare.getShape();
        Color currentColor = this.getColorAt(this.getEyeballRow(),this.getEyeballColumn());
        Shape currentShape = this.getShapeAt(this.getEyeballRow(),this.getEyeballColumn());
        if (currentColor == Color.BLANK && currentShape == Shape.BLANK) {
            return true;
        }
//        int eyeballRow = this.theEyeball.currenPosition.row;
//        int eyeballColumn = this.theEyeball.currenPosition.column;

        boolean isSameColor = currentColor.equals(targetColor);
        boolean isSameShape = currentShape.equals(targetShape);
        return isSameColor || isSameShape;
    }

    @Override
    public boolean hasBlankFreePathTo(int newYDestination, int newXDestination) {
        int currentX = theEyeball.currenPosition.column;
        int currentY = theEyeball.currenPosition.row;
        LOGGER.log(java.util.logging.Level.INFO, "Checking for current: row: " + currentX + ", column: " + currentY);
        Direction direction = this.theEyeball.getNewEyeballFacingDirection(newYDestination,newXDestination);

        LOGGER.log(java.util.logging.Level.INFO, "Checking for direction: " + direction);

        boolean isNotBlank = true;
        boolean isMovingHorizontal =  direction == Direction.RIGHT || direction == Direction.LEFT;
        boolean isMovingVertical = direction == Direction.UP || direction == Direction.DOWN;
        if (isMovingHorizontal || isMovingVertical) {
            Iterator<Map.Entry<String,Square>> iterator = this.squareCollection.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String,Square> entry = iterator.next();
                String[] coordinates = entry.getKey().split(",");
                int targetY = Integer.parseInt(coordinates[0]);
                int targetX = Integer.parseInt(coordinates[1]);

                Square square = entry.getValue();
//                boolean isABlankSquare = square instanceof BlankSquare;
                boolean isPlayable = square instanceof PlayableSquare;
                boolean isInBetweenOldAndNewPosition = isMovingHorizontal ?
                        (targetX <= newXDestination && targetX >= currentX) || targetX >= newXDestination && targetX <= currentX:
                        (targetY <= newYDestination && targetY >= currentY) || (targetY >= newYDestination && targetY <= currentY);
                if (!isPlayable && isInBetweenOldAndNewPosition) {
                    isNotBlank = false;
                    break;
                }
            }
        } else {
            LOGGER.log(java.util.logging.Level.INFO, String.valueOf(Message.MOVING_DIAGONALLY));
        }
        return isNotBlank;
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
    public void moveTo(int row, int col) {
        PlayableSquare current = getCurrentSquare();
        if (current != null) {
            current.setCurrent(false);
        }
        Square target = getSquareAt(row, col);
        if (target instanceof PlayableSquare) {
            ((PlayableSquare) target).setCurrent(true);
        }
        moveCount++;
    }
}