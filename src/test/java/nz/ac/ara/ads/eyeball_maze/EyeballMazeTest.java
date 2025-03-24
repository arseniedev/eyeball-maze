package nz.ac.ara.ads.eyeball_maze;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.testng.annotations.Test;


public class EyeballMazeTest {
    private EyeballMaze aEyeballMaze;
    @Test
    public final void testLowGuess() {
        aEyeballMaze = new EyeballMaze(42);
        String expected = "Try higher";
        String actual = aEyeballMaze.makeGuess(1);
        String errorMessage = "Expected " + expected + " but got " + actual;
        assertEquals(expected, actual, errorMessage );
    }
    @Test
    public final void testHighGuess() {
        aEyeballMaze = new EyeballMaze(42);
        String expected = "Try lower";
        String actual = aEyeballMaze.makeGuess(43);
        String errorMessage = "Expected " + expected + " but got " + actual;
        assertEquals(expected, actual, errorMessage );
    }
    @Test
    public final void testCorrectGuess() {
        aEyeballMaze = new EyeballMaze(42);
        String expected = "You got it in 1 trials!";
        String actual = aEyeballMaze.makeGuess(42);
        String errorMessage = "Expected " + expected + " but got " + actual;
        assertEquals(expected, actual, errorMessage );
    }
    @Test
    public final void testGuessCounting() {
        aEyeballMaze = new EyeballMaze(42);
        String expected = "You got it in 3 trials!";
        aEyeballMaze.makeGuess(40);
        aEyeballMaze.makeGuess(41);
        String actual = aEyeballMaze.makeGuess(42);
        String errorMessage = "Expected " + expected + " but got " + actual;
        assertEquals(expected, actual, errorMessage );
    }
}
