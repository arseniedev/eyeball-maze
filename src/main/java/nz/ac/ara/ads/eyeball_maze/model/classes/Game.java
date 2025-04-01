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
    private final List<Position> levelCollection =  new ArrayList<>();
    private final List<Position> goalCollection =  new ArrayList<>();
//    private final List<Square> squareCollection =  new ArrayList<>();
    private final List<EyeBall> eyeBallCollection = new ArrayList<>();
    Map <Position, Square> squareCollection = new HashMap<>();
    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public Game() {
        this.levelCount = 0;
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
//            long validCoordinateCount = this.levelCollection.stream().filter(position -> position.getRow() >= row && position.getColumn() >= column).count();
//        int validCoordinateCount = 0;
//        for (Position position : this.levelCollection) {
//            LOGGER.log(Level.INFO, "row: " + position.getRow() + " column: " + position.getColumn());
//            if (position.getRow() >= row && position.getColumn() >= column) {
//                validCoordinateCount++;
//            }
//        }

//        return validCoordinateCount > 0;
        return this.levelCollection.stream()
                .filter(
                        position -> position.getRow() >= row && position.getColumn() >= column)
                .count() > 0;
    }

    @Override
    public int getGoalCount() {
        return this.goalCollection.size();
    }

    @Override
    public boolean hasGoalAt(int row, int column) {
        LOGGER.log(Level.INFO, "Checking if goal at row: " + row + ", column: " + column);

        Position targetPosition = new Position(row,column);
        return this.goalCollection.contains(targetPosition);
    }

    @Override
    public int getCompletedGoalCount() {
        return 0;
    }

    @Override
    public Color getColorAt(int row, int column) {
        Color output = Color.BLANK;
        LOGGER.log(Level.INFO, "Checking color at row: " + row + ", column: " + column);
        for (Map.Entry<Position, Square> entry : this.squareCollection.entrySet()) {
            if (entry.getKey().row == row && entry.getKey().column == column) {
                output = entry.getValue().getColor();
                LOGGER.log(Level.INFO, "output: " + output);
            }
        }
        return output;
    }
    @Override
    public void addSquare(Square square, int row, int column) {
//        Map <Position, Square> squareCollection = new HashMap<>();

        if (this.validCoordinate(row,column)) {
//            Color sqColor = square.getColor();
//            Shape sqShape = square.getShape();
            Position sqPosition = new Position(row,column);

            LOGGER.log(Level.INFO, "Adding a square shape" + square.getShape() + ", color:" + square.getColor());
            this.squareCollection.put(sqPosition,square);

//            if (sqColor == null && sqShape == null) {
//                this.squareCollection.put(sqPosition,new BlankSquare());
////                this.squareCollection.add(new BlankSquare(), );
//            } else {
//                this.squareCollection.put(sqPosition,new PlayableSquare(sqColor,sqShape));
////                this.squareCollection.add(new PlayableSquare(sqColor,sqShape));
//            }
//            this.squareCollection.add(sqData);
//            SquareData sqData = new SquareData(sqColor,sqShape,sqPosition);
            LOGGER.log(Level.INFO, "Adding a square at: " + row + ", " + column); //+ "With color/shape" + sqData.color() + sqShape.shape()
        } else {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.INDEX_OUT_OF_BOUNDS));
        }
    }

    @Override
    public Shape getShapeAt(int row, int column) {
        Shape output = Shape.BLANK;
        LOGGER.log(Level.INFO, "Checking shape at row: " + row + ", column: " + column);
        for (Map.Entry<Position, Square> entry : this.squareCollection.entrySet()) {
//            if (entry.getValue().getClass().getName() instanceof BlankSquare) {
            if (entry.getKey().row == row && entry.getKey().column == column) {
                output = entry.getValue().getShape();
                LOGGER.log(Level.INFO, "output: " + output);
            }
        }
//            System.out.println(entry);
            // %n - A new line character appropriate to the platform running the application
//            System.out.printf("Key: %s and Value: %s %n", entry.getKey().getRow(), entry.getValue().getClass().getName());
//            System.out.printf("Value: %s", entry.getValue().getShape());
        return output;

        }
//        int targetRow;
//        int targetColumn;
        /*
        Position targetPosition = new Position(row,column);
        LOGGER.log(Level.INFO, "Checking shape at row: " + row + ", column: " + column);
        Square sq = this.squareCollection.get(targetPosition);

        return sq.shape;
        for (Position position: this.squareCollection.keySet()) {
            LOGGER.log(Level.INFO, "Getting" + this.squareCollection.get(position).shape);
//            if (square.position.getRow() == row && square.position.getColumn() == column) {
//                Square square = this.squareCollection.get(position);
//                if (square != null) {
//                    LOGGER.log(Level.INFO, "Checking shape at row: " + row + ", column: " + column + ", shape: " + this.squareCollection.get(position).shape);
//                    return square.shape;
//                } else {
//                    LOGGER.log(Level.WARNING, "Square not found at row:" + row + "column:" + column);
//                }
//            }
//        }
        * */
/*
* */
/*
//        for (Square grid : this.squareCollection) {
//            targetRow = grid.position.getRow();
//            targetColumn = grid.position.getColumn();
//            Position p = new Position(row,column);
////
////            if (targetRow == row && targetColumn == column) {
////                LOGGER.log(Level.INFO, String.valueOf(grid.shape));
////                return grid.shape;
////            }
//        }
*/
//    }

//    private static <L> int findIndexInAList(ArrayList<L> list, int position) {
//        for (int index = 0; index < list.size(); index++) {
////            int row = list.get(index).position.row;
////            int col = list.get(index).position.column;
////            if(list.get(index).position) {
////            if (list.get(index).position.equals(list.get(index + 1))) {
////            }
//        }
//    }
    @Override
    public void addEyeball(int row, int column, Direction direction) {
        if (this.validCoordinate(row,column)) {
            Position position = new Position(row,column);

            LOGGER.log(Level.INFO, "Adding an eyeball at: " + row + ", " + column);
            this.eyeBallCollection.add(new EyeBall(position, direction));
            LOGGER.log(Level.INFO, Message.OK.name());
        } else {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.INDEX_OUT_OF_BOUNDS));
        }
    }
    @Override
    public int getEyeballRow() {
        return this.eyeBallCollection.get(this.levelCount -1).position.getRow(); //.position()
    }

    @Override
    public int getEyeballColumn() {
        return this.eyeBallCollection.get(this.levelCount -1).position.getColumn();
    }

    @Override
    public boolean canMoveTo(int row, int column) {
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
    }
}
