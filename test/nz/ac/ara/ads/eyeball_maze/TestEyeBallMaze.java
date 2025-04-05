//package nz.ac.ara.ads.eyeball_maze;
//import nz.ac.ara.ads.eyeball_maze.enums.Color;
//import nz.ac.ara.ads.eyeball_maze.enums.Direction;
//import nz.ac.ara.ads.eyeball_maze.enums.Message;
//import nz.ac.ara.ads.eyeball_maze.enums.Shape;
//import nz.ac.ara.ads.eyeball_maze.model.classes.*;
////
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.Random;
//
//class TestGameHoldsLevels {
//    Game game = new Game();
//
//    void addTestLevel1() {
//        game.addLevel(1, 5);
//    }
//
//    void addTestLevel2() {
//        game.addLevel(7, 3);
//    }
//
//    @Test
//    void testGetLevelWidth() {
//        this.addTestLevel1();
//        int expectedWidth = 5;
//        int actualWidth = game.getLevelWidth();
//        assertEquals(expectedWidth, actualWidth);
//    }
//
//    @Test
//    void testGetLevelHeight() {
//        this.addTestLevel1();
//        int expectedHeight = 1;
//        int actualHeight = game.getLevelHeight();
//        assertEquals(expectedHeight, actualHeight);
//    }
//
//    @Test
//    void testGetLevelCountWithOneLevel() {
//        this.addTestLevel1();
//        int expectedLevelCount = 1;
//        int actualLevelCount = game.getLevelCount();
//        assertEquals(expectedLevelCount, actualLevelCount);
//    }
//
//    @Test
//    void testGetLevelCountWithTwoLevels() {
//        this.addTestLevel1();
//        this.addTestLevel2();
//        int expectedLevelCount = 2;
//        int actualLevelCount = game.getLevelCount();
//        assertEquals(expectedLevelCount, actualLevelCount);
//    }
//
//    @Test
//    void testMostRecentlyAddedLevelIsCurrentLevelByCheckingSize() {
//        this.addTestLevel1();
//        this.addTestLevel2();
//        int[] expectedLevelSize = {7, 3};
//        int[] actualLevelSize = {game.getLevelHeight(), game.getLevelWidth()};
//        assertArrayEquals(expectedLevelSize, actualLevelSize);
//    }
//
//    @Test
//    void testSettingLevelChangesCurrentLevelByCheckingSize() {
//        this.addTestLevel1();
//        this.addTestLevel2();
//        int[] expectedLevelSize = {1, 5};
//        game.setLevel(0);
//        int[] actualLevelSize = {game.getLevelHeight(), game.getLevelWidth()};
//        assertArrayEquals(expectedLevelSize, actualLevelSize);
//    }
//
//    @Test
//    void testSettingLevelToTooLargeNumberThrowsException() {
//        this.addTestLevel1();
//        this.addTestLevel2();
//        assertThrows(IllegalArgumentException.class, () -> game.setLevel(42));
//    }
//}
//
//
//class TestGameHoldsSquares {
//    Game game = new Game();
//
//    private void setup() {
//        game = new Game();
//        game.addLevel(9, 1);
//        game.addSquare(new BlankSquare(), 0, 0);
//        game.addSquare(new BlankSquare(), 1, 0);
//        game.addSquare(new PlayableSquare(Color.BLUE, Shape.DIAMOND), 2, 0);
//        game.addSquare(new PlayableSquare(Color.RED, Shape.CROSS), 3, 0);
//        game.addSquare(new PlayableSquare(Color.YELLOW, Shape.STAR), 4, 0);
//        game.addSquare(new PlayableSquare(Color.GREEN, Shape.FLOWER), 5, 0);
//        game.addSquare(new PlayableSquare(Color.PURPLE, Shape.LIGHTNING), 6, 0);
//        game.addSquare(new BlankSquare(), 7, 0);
//        game.addSquare(new BlankSquare(), 8, 0);
//    }
//
//    @Test
//    void testAddingSquareOutsideLevelWidthThrowsException() {
//        game = new Game();
//        game.addLevel(9, 1);
//        assertThrows(IllegalArgumentException.class, () -> game.addSquare(new BlankSquare(), 0, 4));
//    }
//
//    @Test
//    void testAddingSquareOutsideLevelHeightThrowsException() {
//        game = new Game();
//        game.addLevel(9, 1);
//        assertThrows(IllegalArgumentException.class, () -> game.addSquare(new BlankSquare(), 22, 0));
//    }
//
//    @Test
//    void testColoursAreAsAdded() {
//        setup();
//        Color[] expectedColors = {
//                Color.BLUE, Color.RED, Color.YELLOW, Color.GREEN, Color.BLANK,
//                Color.PURPLE
//        };
//        Color[] actualColors = {
//                game.getColorAt(2, 0), game.getColorAt(3, 0), game.getColorAt(4, 0),
//                game.getColorAt(5, 0), game.getColorAt(7, 0), game.getColorAt(6, 0)
//        };
//        assertArrayEquals(expectedColors, actualColors);
//    }
//
//    @Test
//    void testShapesAreAsAdded() {
//        setup();
//        Shape[] expectedShapes = {Shape.DIAMOND, Shape.CROSS, Shape.STAR, Shape.FLOWER,
//                Shape.BLANK, Shape.LIGHTNING};
//        Shape[] actualShapes = {game.getShapeAt(2, 0), game.getShapeAt(3, 0), game.getShapeAt(4, 0),
//                game.getShapeAt(5, 0), game.getShapeAt(7, 0), game.getShapeAt(6, 0)};
//        assertArrayEquals(expectedShapes, actualShapes);
//    }
//}
//
//
//class TestGameHoldsEyeball {
//    Game game;
//
//    @BeforeEach
//    void add7High3WideLevel() {
//        game = new Game();
//        game.addLevel(7, 3);
//    }
//
//    @Test
//    void testAddingEyeballOutsideHeightThrowsException() {
//        // this.add7High3WideLevel();
//        assertThrows(IllegalArgumentException.class, () -> game.addEyeball(9, 2, Direction.UP));
//    }
//
//    @Test
//    void testAddingEyeballOutsideWidthThrowsException() {
//        // this.add7High3WideLevel();
//        assertThrows(IllegalArgumentException.class, () -> game.addEyeball(6, 5, Direction.UP));
//    }
//
//    @Test
//    void testAddingEyeballPutsItWhereExpected() {
//        // this.add7High3WideLevel();
//        game.addEyeball(4, 2, Direction.UP);
//        int[] expectedRowColumn = {4, 2};
//        int[] actualRowColumn = {game.getEyeballRow(), game.getEyeballColumn()};
//        assertArrayEquals(expectedRowColumn, actualRowColumn);
//    }
//
//    @Test
//    void testAddingEyeballFacingUpFacesUP() {
//        // this.add7High3WideLevel();
//        game.addEyeball(4, 2, Direction.UP);
//        Direction expectedDirection = Direction.UP;
//        Direction actualDirection = game.getEyeballDirection();
//        assertEquals(expectedDirection, actualDirection);
//    }
//
//    @Test
//    void testAddingEyeballFacingDOWNFacesDOWN() {
//        // this.add7High3WideLevel();
//        game.addEyeball(4, 2, Direction.DOWN);
//        Direction expectedDirection = Direction.DOWN;
//        Direction actualDirection = game.getEyeballDirection();
//        assertEquals(expectedDirection, actualDirection);
//    }
//
//    @Test
//    void testAddingEyeballFacingLEFTFacesLEFT() {
//        // this.add7High3WideLevel();
//        game.addEyeball(4, 2, Direction.LEFT);
//        Direction expectedDirection = Direction.LEFT;
//        Direction actualDirection = game.getEyeballDirection();
//        assertEquals(expectedDirection, actualDirection);
//    }
//
//    @Test
//    void testAddingEyeballFacingRIGHTFacesRIGHT() {
//        // this.add7High3WideLevel();
//        game.addEyeball(4, 2, Direction.RIGHT);
//        Direction expectedDirection = Direction.RIGHT;
//        Direction actualDirection = game.getEyeballDirection();
//        assertEquals(expectedDirection, actualDirection);
//    }
//}
//
//
//class TestLevelHoldsGoals {
//    Game game;
//
//    @BeforeEach
//    void add7High3WideLevel() {
//        game = new Game();
//        game.addLevel(7, 3);
//    }
//
//    @Test
//    void testAddingOneGoalIncreasesGoalCountTo1() {
//        // this.add7High3WideLevel();
//        game.addGoal(4, 2);
//        int expectedGoalCount = 1;
//        int actualGoalCount = game.getGoalCount();
//        assertEquals(expectedGoalCount, actualGoalCount);
//    }
//
//    @Test
//    void testAddingOneGoalPutsGoalAtExpectedPosition() {
//        // this.add7High3WideLevel();
//        game.addGoal(4, 2);
//        boolean hasGoal = game.hasGoalAt(4, 2);
//        assertTrue(hasGoal);
//    }
//
//    @Test
//    void testAddingTwoGoalIncreasesGoalCountTo2() {
////         this.add7High3WideLevel();
//        game.addGoal(4, 2);
//        game.addGoal(6, 1);
//        int expectedGoalCount = 2;
//        int actualGoalCount = game.getGoalCount();
//        assertEquals(expectedGoalCount, actualGoalCount);
//
//    }
//
//    @Test
//    void testAddingTwoGoalsPutsGoalsAtExpectedPositions() {
//        // this.add7High3WideLevel();
//        game.addGoal(4, 2);
//        game.addGoal(6, 1);
//        boolean[] expectedHasGoals = {true, true};
//        boolean[] actualHasGoals = {
//                game.hasGoalAt(4, 2),
//                game.hasGoalAt(6, 1)
//        };
//        assertArrayEquals(expectedHasGoals, actualHasGoals);
//    }
//
//    @Test
//    void testNewGameHas0CompletedGoals() {
//        // this.add7High3WideLevel();
//        game.addGoal(4, 2);
//        game.addGoal(6, 1);
//        int expectedGoalCount = 0;
//        int actualGoalCount = game.getCompletedGoalCount();
//        assertEquals(expectedGoalCount, actualGoalCount);
//    }
//
//    @Test
//    void testAddingGoalsOutsideLevelHeightThrowsRangeException() {
//        // this.add7High3WideLevel();
//        assertThrows(IllegalArgumentException.class, () -> game.addGoal(8, 2));
//    }
//
//    @Test
//    void testAddingGoalsOutsideLevelWidthThrowsRangeException() {
//        // this.add7High3WideLevel();
//        assertThrows(IllegalArgumentException.class, () ->
//                game.addGoal(2, 9));
//    }
//}
//
//class TestLeftMoves {
//    Game game;
//
//    @BeforeEach
//    void setUpVerticalLevel() {
//        game = new Game();
//        game.addLevel(1, 9);
//        game.addSquare(new PlayableSquare(Color.GREEN, Shape.STAR), 0, 0);
//        game.addSquare(new BlankSquare(), 0, 1);
//        game.addSquare(new PlayableSquare(Color.BLUE, Shape.DIAMOND), 0, 2);
//        game.addSquare(new PlayableSquare(Color.RED, Shape.CROSS), 0, 3);
//        game.addSquare(new PlayableSquare(Color.YELLOW, Shape.STAR), 0, 4);
//        game.addSquare(new PlayableSquare(Color.GREEN, Shape.FLOWER), 0, 5);
//        game.addSquare(new PlayableSquare(Color.GREEN, Shape.STAR), 0, 6);
//        // each test needs to add the eyeball!!
//    }
//
//    @Test
//    void testOkToMoveToSameColorOrShape() {
//        boolean[] expected = { true, true };
//        game.addEyeball(0, 6, Direction.LEFT);
//        boolean[] actual = { game.canMoveTo(0, 5), game.canMoveTo(0, 4) };
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    void testNotOkToMovetoDifferentColorAndShape() {
//        boolean[] expected = { false, false };
//        game.addEyeball(0, 6, Direction.LEFT);
//        boolean[] actual = { game.canMoveTo(0, 2), game.canMoveTo(0, 3) };
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    void testNoErrorMessageWhenMovingToSameColorOrShape() {
//        Message[] expected = { Message.OK, Message.OK };
//        game.addEyeball(0, 6, Direction.LEFT);
//        Message[] actual = { game.messageIfMovingTo(0, 5), game.messageIfMovingTo(0, 4) };
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    void testGetsErrorMessageWhenMovingToDifferentColorAndShape() {
//        Message[] expected = { Message.DIFFERENT_SHAPE_OR_COLOR,
//                Message.DIFFERENT_SHAPE_OR_COLOR };
//        game.addEyeball(0, 6, Direction.LEFT);
//        Message[] actual = { game.messageIfMovingTo(0, 2), game.messageIfMovingTo(0, 3) };
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    void testOkWhenEyeballFacesDownOnMovingLeft() {
//        boolean expected = true;
//        game.addEyeball(0, 6, Direction.DOWN);
//        boolean actual = game.isDirectionOK(0, 5);
//        assertEquals(expected, actual);
//    }
//    @Test
//    void testOkWhenEyeballFacesUpOnMovingLeft() {
//        boolean expected = true;
//        game.addEyeball(0, 6, Direction.UP);
//        boolean actual = game.isDirectionOK(0, 5);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testNotOKWhenMovingBackwards() {
//        boolean expected = false;
//        game.addEyeball(0, 6, Direction.RIGHT);
//        boolean actual = game.isDirectionOK(0, 5);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testGetsErrorMessageWhenMovingBackwards() {
//        Message expected = Message.BACKWARDS_MOVE;
//        game.addEyeball(0, 6, Direction.RIGHT);
//        Message actual = game.checkDirectionMessage(0, 5);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testNotOKWhenPathToDestinationCrossesBlank() {
//        boolean expected = false;
//        game.addEyeball(0, 6, Direction.LEFT);
//        boolean actual = game.hasBlankFreePathTo(0, 0);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testErrorMessageWhenPathToDestinationCrossesBlank() {
//        Message expected = Message.MOVING_OVER_BLANK;
//        game.addEyeball(0, 6, Direction.LEFT);
//        Message actual = game.checkMessageForBlankOnPathTo(0, 0);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testEyeballMovesToDestinationRowAndColumn() {
//        int expectedRow = 0;
//        int expectedColumn = 4;
//        int[] expected = { expectedRow, expectedColumn };
//        game.addEyeball(0, 6, Direction.LEFT);
//        game.moveTo(0, 4);
//        int[] actual = { game.getEyeballRow(), game.getEyeballColumn() };
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    void testEyeballFacesLeftOnMovingLeft() {
//        Direction expectedDirection = Direction.LEFT;
//        game.addEyeball(0, 6, Direction.UP);
//        game.moveTo(0, 4);
//        Direction actualDirection = game.getEyeballDirection();
//        assertEquals(expectedDirection, actualDirection);
//    }
//}
//
//
//class TestDownMoves {
//    Game game;
//
//    @BeforeEach
//    void setUpVerticalLevel() throws Exception {
//        game = new Game();
//        game.addLevel(9, 1);
//        game.addSquare(new PlayableSquare(Color.GREEN, Shape.STAR), 0, 0);
//        game.addSquare(new PlayableSquare(Color.GREEN, Shape.FLOWER), 1, 0);
//        game.addSquare(new PlayableSquare(Color.YELLOW, Shape.STAR), 2, 0);
//        game.addSquare(new PlayableSquare(Color.RED, Shape.CROSS), 3, 0);
//        game.addSquare(new PlayableSquare(Color.BLUE, Shape.DIAMOND), 4, 0);
//        game.addSquare(new PlayableSquare(Color.YELLOW, Shape.FLOWER), 5, 0);
//        game.addSquare(new BlankSquare(), 6, 0);
//        game.addSquare(new PlayableSquare(Color.GREEN, Shape.STAR), 7, 0);
//        game.addSquare(new PlayableSquare(Color.RED, Shape.FLOWER), 8, 0);
//        // each test needs to add the eyeball!!
//    }
//
//    @Test
//    void testOkToMoveToSameColorOrShape() {
//        boolean[] expected = {true, true};
//        game.addEyeball(0, 0, Direction.DOWN);
//        boolean[] actual = {game.canMoveTo(1, 0), game.canMoveTo(2, 0)};
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    void testNotOkToMoveToDifferentColorAndShape() {
//        boolean[] expected = {false, false};
//        game.addEyeball(0, 0, Direction.DOWN);
//        boolean[] actual = {game.canMoveTo(3, 0), game.canMoveTo(5, 0)};
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    void testNoErrorMessageWhenMovingToSameColorOrShape() {
//        Message[] expected = {Message.OK, Message.OK};
//        game.addEyeball(0, 0, Direction.DOWN);
//        Message[] actual = {game.messageIfMovingTo(1, 0), game.messageIfMovingTo(2, 0)};
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    void testGetsErrorMessageWhenMovingToDifferentColorAndShape() {
//        Message[] expected = {Message.DIFFERENT_SHAPE_OR_COLOR,
//                Message.DIFFERENT_SHAPE_OR_COLOR};
//        game.addEyeball(0, 0, Direction.DOWN);
//        Message[] actual = {game.messageIfMovingTo(3, 0), game.messageIfMovingTo(5, 0)};
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    void testOkWhenEyeballFacesRightOnMovingDown() {
//        boolean expected = true;
//        game.addEyeball(0, 0, Direction.RIGHT);
//        boolean actual = game.isDirectionOK(2, 0);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testOkWhenEyeballFacesLeftOnMovingDown() {
//        boolean expected = true;
//        game.addEyeball(0, 0, Direction.LEFT);
//        boolean actual = game.isDirectionOK(2, 0);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testNotOkWhenMovingBackwards() {
//        boolean expected = false;
//        game.addEyeball(0, 0, Direction.UP);
//        boolean actual = game.isDirectionOK(2, 0);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testGetsErrorMessageWhenMovingBackwards() {
//        Message expected = Message.BACKWARDS_MOVE;
//        game.addEyeball(0, 0, Direction.UP);
//        Message actual = game.checkDirectionMessage(2, 0);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testNotOkWhenPathToDestinationCrossesBlank() {
//        boolean expected = false;
//        game.addEyeball(1, 0, Direction.DOWN);
//        boolean actual = game.hasBlankFreePathTo(7, 0);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testErrorMessageWhenPathToDestinationCrossesBlank() {
//        Message expected = Message.MOVING_OVER_BLANK;
//        game.addEyeball(1, 0, Direction.DOWN);
//        Message actual = game.checkMessageForBlankOnPathTo(7, 0);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testEyeballMovesToDestinationRowAndColumn() {
//        int expectedRow = 5;
//        int expectedColumn = 0;
//        int[] expected = {expectedRow, expectedColumn};
//        game.addEyeball(1, 0, Direction.DOWN);
//        game.moveTo(5, 0);
//        int[] actual = {game.getEyeballRow(), game.getEyeballColumn()};
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    void testEyeballFacesDownOnMovingDown() {
//        Direction expectedDirection = Direction.DOWN;
//        game.addEyeball(1, 0, Direction.RIGHT);
//        game.moveTo(5, 0);
//        Direction actualDirection = game.getEyeballDirection();
//        assertEquals(expectedDirection, actualDirection);
//    }
//}
//
//
//
//class TestRightMoves {
//    Game game;
//
//    @BeforeEach
//    void setUpVerticalLevel() throws Exception {
//        game = new Game();
//        game.addLevel(1, 9);
//        game.addSquare(new PlayableSquare(Color.GREEN, Shape.STAR), 0, 0);
//        game.addSquare(new PlayableSquare(Color.GREEN, Shape.FLOWER), 0, 1);
//        game.addSquare(new PlayableSquare(Color.YELLOW, Shape.STAR), 0, 2);
//        game.addSquare(new PlayableSquare(Color.RED, Shape.CROSS), 0, 3);
//        game.addSquare(new PlayableSquare(Color.BLUE, Shape.DIAMOND), 0, 4);
//        game.addSquare(new BlankSquare(), 0, 5);
//        game.addSquare(new PlayableSquare(Color.GREEN, Shape.STAR), 0, 6);
//        // each test needs to add the eyeball!!
//    }
//
//    @Test
//    void testOkToMoveToSameColorOrShape() {
//        boolean[] expected = {true, true};
//        game.addEyeball(0, 0, Direction.RIGHT);
//        boolean[] actual = {game.canMoveTo(0, 1), game.canMoveTo(0, 2)};
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    void testNotOkToMovetoDifferentColorAndShape() {
//        boolean[] expected = {false, false};
//        game.addEyeball(0, 0, Direction.RIGHT);
//        boolean[] actual = {game.canMoveTo(0, 3), game.canMoveTo(0, 4)};
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    void testNoErrorMessageWhenMovingToSameColorOrShape() {
//        Message[] expected = {Message.OK, Message.OK};
//        game.addEyeball(0, 0, Direction.RIGHT);
//        Message[] actual = {game.messageIfMovingTo(0, 1), game.messageIfMovingTo(0, 2)};
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    void testGetsErrorMessageWhenMovingToDifferentColorAndShape() {
//        Message[] expected = {Message.DIFFERENT_SHAPE_OR_COLOR,
//                Message.DIFFERENT_SHAPE_OR_COLOR};
//        game.addEyeball(0, 0, Direction.RIGHT);
//        Message[] actual = {game.messageIfMovingTo(0, 3), game.messageIfMovingTo(0, 4)};
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    void testOkWhenEyeballFacesDownOnMovingRight() {
//        boolean expected = true;
//        game.addEyeball(0, 0, Direction.DOWN);
//        boolean actual = game.isDirectionOK(0, 2);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testOkWhenEyeballFacesUpOnMovingRight() {
//        boolean expected = true;
//        game.addEyeball(0, 0, Direction.UP);
//        boolean actual = game.isDirectionOK(0, 2);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testNotOKWhenMovingBackwards() {
//        boolean expected = false;
//        game.addEyeball(0, 0, Direction.LEFT);
//        boolean actual = game.isDirectionOK(0, 2);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testGetsErrorMessageWhenMovingBackwards() {
//        Message expected = Message.BACKWARDS_MOVE;
//        game.addEyeball(0, 0, Direction.LEFT);
//        Message actual = game.checkDirectionMessage(0, 2);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testNotOKWhenPathToDestinationCrossesBlank() {
//        boolean expected = false;
//        game.addEyeball(0, 0, Direction.RIGHT);
//        boolean actual = game.hasBlankFreePathTo(0, 6);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testErrorMessageWhenPathToDestinationCrossesBlank() {
//        Message expected = Message.MOVING_OVER_BLANK;
//        game.addEyeball(0, 0, Direction.RIGHT);
//        Message actual = game.checkMessageForBlankOnPathTo(0, 6);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testEyeballMovesToDestinationRowAndColumn() {
//        int expectedRow = 0;
//        int expectedColumn = 2;
//        int[] expected = {expectedRow, expectedColumn};
//        game.addEyeball(0, 0, Direction.RIGHT);
//        game.moveTo(0, 2);
//        int[] actual = {game.getEyeballRow(), game.getEyeballColumn()};
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    void testEyeballFacesRightOnMovingRight() {
//        Direction expectedDirection = Direction.RIGHT;
//        game.addEyeball(0, 0, Direction.DOWN);
//        game.moveTo(0, 2);
//        Direction actualDirection = game.getEyeballDirection();
//        assertEquals(expectedDirection, actualDirection);
//    }
//}
//
//
//class TestUpMoves {
//    Game game;
//
//    @BeforeEach
//    void setUpVerticalLevel() {
//        game = new Game();
//        game.addLevel(9, 1);
//        game.addSquare(new PlayableSquare(Color.GREEN, Shape.STAR), 0, 0);
//        game.addSquare(new BlankSquare(), 1, 0);
//        game.addSquare(new PlayableSquare(Color.BLUE, Shape.DIAMOND), 2, 0);
//        game.addSquare(new PlayableSquare(Color.RED, Shape.CROSS), 3, 0);
//        game.addSquare(new PlayableSquare(Color.YELLOW, Shape.STAR), 4, 0);
//        game.addSquare(new PlayableSquare(Color.GREEN, Shape.FLOWER), 5, 0);
//        game.addSquare(new PlayableSquare(Color.GREEN, Shape.STAR), 6, 0);
//        // each test needs to add the eyeball!!
//    }
//
//    @Test
//    void testOkToMoveToSameColorOrShape() {
//        boolean[] expected = { true, true };
//        game.addEyeball(6, 0, Direction.UP);
//        boolean[] actual = { game.canMoveTo(5, 0), game.canMoveTo(4, 0) };
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    void testNotOkToMovetoDifferentColorAndShape() {
//        boolean[] expected = { false, false };
//        game.addEyeball(6, 0, Direction.UP);
//        boolean[] actual = { game.canMoveTo(2, 0), game.canMoveTo(3, 0) };
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    void testNoErrorMessageWhenMovingToSameColorOrShape() {
//        Message[] expected = { Message.OK, Message.OK };
//        game.addEyeball(6, 0, Direction.UP);
//        Message[] actual = { game.messageIfMovingTo(5, 0), game.messageIfMovingTo(4, 0) };
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    void testGetsErrorMessageWhenMovingToDifferentColorAndShape() {
//        Message[] expected = { Message.DIFFERENT_SHAPE_OR_COLOR,
//                Message.DIFFERENT_SHAPE_OR_COLOR };
//        game.addEyeball(6, 0, Direction.UP);
//        Message[] actual = {
//                game.messageIfMovingTo(2, 0),
//                game.messageIfMovingTo(3, 0)
//        };
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    void testOkWhenEyeballFacesRightOnMovingUp() {
//        boolean expected = true;
//        game.addEyeball(6, 0, Direction.RIGHT);
//        boolean actual = game.isDirectionOK(5, 0);
//        assertEquals(expected, actual);
//    }
//    @Test
//    void testOkWhenEyeballFacesLeftOnMovingUp() {
//        boolean expected = true;
//        game.addEyeball(6, 0, Direction.LEFT);
//        boolean actual = game.isDirectionOK(5, 0);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testNotOkWhenMovingBackwards() {
//        boolean expected = false;
//        game.addEyeball(6, 0, Direction.DOWN);
//        boolean actual = game.isDirectionOK(5, 0);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testGetsErrorMessageWhenMovingBackwards() {
//        Message expected = Message.BACKWARDS_MOVE;
//        game.addEyeball(6, 0, Direction.DOWN);
//        Message actual = game.checkDirectionMessage(5, 0);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testNotOkWhenPathToDestinationCrossesBlank() {
//        boolean expected = false;
//        game.addEyeball(6, 0, Direction.UP);
//        boolean actual = game.hasBlankFreePathTo(0, 0);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testErrorMessageWhenPathToDestinationCrossesBlank() {
//        Message expected = Message.MOVING_OVER_BLANK;
//        game.addEyeball(6, 0, Direction.UP);
//        Message actual = game.checkMessageForBlankOnPathTo(0, 0);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testEyeballMovesToDestinationRowAndColumn() {
//        int expectedRow = 4;
//        int expectedColumn = 0;
//        int[] expected = { expectedRow, expectedColumn };
//        game.addEyeball(6, 0, Direction.UP);
//        game.moveTo(4, 0);
//        int[] actual = { game.getEyeballRow(), game.getEyeballColumn() };
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    void testEyeballFacesUPOnMovingUp() {
//        Direction expectedDirection = Direction.UP;
//        game.addEyeball(6, 0, Direction.RIGHT);
//        game.moveTo(4, 0);
//        Direction actualDirection = game.getEyeballDirection();
//        assertEquals(expectedDirection, actualDirection);
//    }
//}
//
//
//class TestCompletingGoals {
//    Game game;
//    LevelDataHandler levelDataHandler;
//
//    record SquareData(Color color, Shape shape, Position position) {
//    }
//    SquareData[] levelOneInitData = {
//            new SquareData(Color.BLANK, Shape.BLANK, new Position(0, 0)),
//            new SquareData(Color.BLANK, Shape.BLANK, new Position(0, 1)),
//            new SquareData(Color.RED, Shape.FLOWER, new Position(0, 2)),
//            new SquareData(Color.BLANK, Shape.BLANK, new Position(0, 3)),
//            new SquareData(Color.BLUE, Shape.CROSS, new Position(1, 0)),
//            new SquareData(Color.YELLOW, Shape.FLOWER, new Position(1, 1)),
//            new SquareData(Color.YELLOW, Shape.DIAMOND, new Position(1, 2)),
//            new SquareData(Color.GREEN, Shape.CROSS, new Position(1, 3)),
//            new SquareData(Color.GREEN, Shape.FLOWER, new Position(2, 0)),
//            new SquareData(Color.RED, Shape.STAR, new Position(2, 1)),
//            new SquareData(Color.GREEN, Shape.STAR, new Position(2, 2)),
//            new SquareData(Color.YELLOW, Shape.DIAMOND, new Position(2, 3)),
//            new SquareData(Color.RED, Shape.FLOWER, new Position(3, 0)),
//            new SquareData(Color.BLUE, Shape.FLOWER, new Position(3, 1)),
//            new SquareData(Color.RED, Shape.STAR, new Position(3, 2)),
//            new SquareData(Color.GREEN, Shape.FLOWER, new Position(3, 3)),
//            new SquareData(Color.BLUE, Shape.STAR, new Position(4, 0)),
//            new SquareData(Color.RED, Shape.DIAMOND, new Position(4, 1)),
//            new SquareData(Color.BLUE, Shape.FLOWER, new Position(4, 2)),
//            new SquareData(Color.BLUE, Shape.DIAMOND, new Position(4, 3)),
//            new SquareData(Color.BLANK, Shape.BLANK, new Position(5, 0)),
//            new SquareData(Color.BLUE, Shape.DIAMOND, new Position(5, 1)),
//            new SquareData(Color.BLANK, Shape.BLANK, new Position(5, 2)),
//            new SquareData(Color.BLANK, Shape.BLANK, new Position(5, 3))};
//
//    Position[] levelOneSolution = {
//            new Position(3, 1), new Position(3, 3), new Position(1, 3), new Position(1, 0),
//            new Position(4, 0), new Position(4, 2), new Position(0, 2)};
//
//    private class LevelDataHandler {
//        Game game;
//
//        public LevelDataHandler(Game game) {
//            this.game = game;
//        }
//
//        public void createLevel(int height, int width) {
//            this.game.addLevel(height, width);
//        }
//
//        public void setUpLevel(SquareData[] levelInitData) {
//            for (SquareData s : levelInitData) {
//                Square square;
//                if ((s.color == Color.BLANK) && (s.shape == Shape.BLANK)) {
//                    square = new BlankSquare();
//                } else {
//                    square = new PlayableSquare(s.color, s.shape);
//                }
//                this.game.addSquare(square, s.position.getRow(), s.position.getColumn());
//            }
//        }
//    }
//
//    private void setUpLevelOne() {
//        game = new Game();
//        levelDataHandler = new LevelDataHandler(game);
//
//        levelDataHandler.createLevel(6, 4);
//        levelDataHandler.setUpLevel(levelOneInitData);
//
//        game.addGoal(0, 2);
//        game.addEyeball(5, 1, Direction.UP);
//    }
//
//    @Test
//    void testCompletingLevelOne() {
//        setUpLevelOne();
//
//        for (Position p : levelOneSolution) {
//            game.moveTo(p.getRow(), p.getColumn());
//        }
//
//        int expectedCompletedGoalCount = 1;
//        int actualGoalCount = game.getCompletedGoalCount();
//        assertEquals(expectedCompletedGoalCount, actualGoalCount);
//    }
//
//    private void add10High1WideLevel() {
//        game = new Game();
//        game.addLevel(10, 1);
//        game.addSquare(new PlayableSquare(Color.YELLOW, Shape.STAR), 4, 0);
//        game.addSquare(new PlayableSquare(Color.RED, Shape.CROSS), 5, 0);
//        game.addSquare(new PlayableSquare(Color.GREEN, Shape.STAR), 6, 0);
//        game.addSquare(new PlayableSquare(Color.BLUE, Shape.DIAMOND), 7, 0);
//        game.addSquare(new PlayableSquare(Color.GREEN, Shape.FLOWER), 8, 0);
//
//        game.addEyeball(4, 0, Direction.LEFT);
//        game.addGoal(6, 0);
//    }
//
//    @Test
//    void testOkToMoveToAGoalWithSameColorOrShape() {
//        add10High1WideLevel();
//        assertTrue(game.canMoveTo(6, 0));
//    }
//
//    @Test
//    void testNoErrorMessageWhenMovingToAGoalWithSameColorOrShape() {
//        add10High1WideLevel();
//        Message expected = Message.OK;
//        Message actual = game.messageIfMovingTo(6, 0);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testNotOkToMoveToAGoalWithDifferentColorOrShape() {
//        add10High1WideLevel();
//        game.addGoal(8, 0);
//        assertFalse(game.canMoveTo(8, 0));
//    }
//
//    @Test
//    void testGetsErrorMessageWhenMovingToAGoalWithDifferentColorOrShape() {
//        add10High1WideLevel();
//        Message expected = Message.DIFFERENT_SHAPE_OR_COLOR;
//        game.addGoal(8, 0);
//        Message actual = game.messageIfMovingTo(8, 0);
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testNotOkToMoveToAGoalAtADiagonalSquare() {
//        setUpLevelOne();
//        game.addGoal(2, 3);
//        assertFalse(game.canMoveTo(2, 3));
//    }
//
//    @Test
//    void testNotOkWhenMovingBackwardsToAGoalWithSameColorOrShape() {
//        setUpLevelOne();
//        game.addGoal(3, 0);
//        game.moveTo(3, 1);
//        game.moveTo(3, 3);
//        assertFalse(game.canMoveTo(3, 0));
//    }
//
//    @Test
//    void testCompleting1GoalIncreasesCompletedGoalCountBy1() {
//        add10High1WideLevel();
//        int expectedCompletedGoalCount = game.getCompletedGoalCount() + 1;
//        game.moveTo(6, 0);
//        int actualCompletedGoalCount = game.getCompletedGoalCount();
//        assertEquals(expectedCompletedGoalCount, actualCompletedGoalCount);
//    }
//
//    @Test
//    void testCompleting1GoalDecreaseGoalCountBy1() {
//        add10High1WideLevel();
//        int expectedGoalCount = game.getGoalCount() - 1;
//        game.moveTo(6, 0);
//        int actualGoalCount = game.getGoalCount();
//        assertEquals(expectedGoalCount, actualGoalCount);
//    }
//
//    @Test
//    void testGoalWillBeRemovedFromSquareAfterCompletingTheGoal() {
//        add10High1WideLevel();
//        game.moveTo(6, 0);
//        assertFalse(game.hasGoalAt(6, 0));
//    }
//
//    @Test
//    void testGoalSquareWillNotBeChangedWhenEyeballMovesOntoIt() {
//        add10High1WideLevel();
//        String[] expected = {"GREEN", "STAR"};
//        game.moveTo(6, 0);
//        String[] actual = {game.getColorAt(6, 0).name(), game.getShapeAt(6, 0).name()};
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    void testGoalSquareBecomesBlankSquareAfterEyeballMovesToAnotherSquare() {
//        add10High1WideLevel();
//        game.moveTo(6, 0);
//        game.moveTo(8, 0);
//        String[] expected = {"BLANK", "BLANK"};
//        String[] actual = {game.getColorAt(6, 0).name(), game.getShapeAt(6, 0).name()};
//        assertArrayEquals(expected, actual);
//    }
//}
//
//
//class TestDiagonalMoves {
//    Game game;
//    Random rand;
//
//    @BeforeEach
//    void setUpVerticalLevel() throws Exception {
//        game = new Game();
//        game.addLevel(10, 10);
//        // each test needs to add the eyeball!!
//        rand = new Random();
//    }
//
//    @Test
//    void testNotOkWhenMovingToUpLeft() {
//        boolean expected = false;
//        game.addEyeball(9, 9, Direction.UP);
//        boolean actual = game.isDirectionOK(rand.nextInt(9), rand.nextInt(9));
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testGetsErrorMessageWhenMovingToUpLeft() {
//        Message expected = Message.MOVING_DIAGONALLY;
//        game.addEyeball(9, 9, Direction.UP);
//        Message actual = game.checkDirectionMessage(rand.nextInt(9), rand.nextInt(9));
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testNotOkWhenMovingToUpRight() {
//        boolean expected = false;
//        game.addEyeball(9, 0, Direction.RIGHT);
//        boolean actual = game.isDirectionOK(rand.nextInt(9), rand.nextInt(9) + 1);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testGetsErrorMessageWhenMovingToUpRight() {
//        Message expected = Message.MOVING_DIAGONALLY;
//        game.addEyeball(9, 0, Direction.RIGHT);
//        Message actual = game.checkDirectionMessage(rand.nextInt(9), rand.nextInt(9) + 1);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testNotOkWhenMovingToDownRight() {
//        boolean expected = false;
//        game.addEyeball(0, 0, Direction.DOWN);
//        boolean actual = game.isDirectionOK(rand.nextInt(9) + 1, rand.nextInt(9) + 1);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testGetsErrorMessageWhenMovingToDownRight() {
//        Message expected = Message.MOVING_DIAGONALLY;
//        game.addEyeball(0, 0, Direction.DOWN);
//        Message actual = game.checkDirectionMessage(rand.nextInt(9) + 1, rand.nextInt(9) + 1);
//        assertEquals(expected, actual);
//
//    }
//
//    @Test
//    void testNotOkWhenMovingToDownLeft() {
//        boolean expected = false;
//        game.addEyeball(0, 9, Direction.LEFT);
//        boolean actual = game.isDirectionOK(rand.nextInt(9) + 1, rand.nextInt(9));
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testGetsErrorMessageWhenMovingToDownLeft() {
//        Message expected = Message.MOVING_DIAGONALLY;
//        game.addEyeball(0, 9, Direction.LEFT);
//        Message actual = game.checkDirectionMessage(rand.nextInt(9) + 1, rand.nextInt(9));
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testNotOkWhenMovingBackwards() {
//        boolean expected = false;
//        game.addEyeball(0, 9, Direction.UP);
//        boolean actual = game.isDirectionOK(rand.nextInt(9) + 1, rand.nextInt(9));
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testGetsErrorMessageWhenMovingBackwards() {
//        Message expected = Message.MOVING_DIAGONALLY;
//        game.addEyeball(0, 9, Direction.UP);
//        Message actual = game.checkDirectionMessage(rand.nextInt(9) + 1, rand.nextInt(9));
//        assertEquals(expected, actual);
//    }
//}
