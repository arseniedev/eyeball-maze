//package nz.ac.ara.ads.eyeballmaze;
//import nz.ac.ara.ads.eyeballmaze.model.classes.Game;
////
//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Test;
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