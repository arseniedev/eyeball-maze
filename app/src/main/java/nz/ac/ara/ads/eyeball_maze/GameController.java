package nz.ac.ara.ads.eyeball_maze;

import nz.ac.ara.ads.eyeball_maze.model.classes.Game;
import nz.ac.ara.ads.eyeball_maze.view.GameView;

public class GameController {

    private Game gameModel;
    private GameView gameView;

    public GameController(Game game, GameView view) {
        this.gameModel = game;
        this.gameView = view;
    }

    public void initGame() {
        // Example: get current level count from game model
        int currentLevel = gameModel.getLevelCount();
        int goalsRemaining = 0;
        int movesMade = 0;

        // Setup UI (View)
        gameView.setupWindowInsetsPadding();

        // Create header view (you can pass actual values)
        gameView.displayurrentLevelView("Level " + currentLevel, "Current Level");
        gameView.displayGoalsRemain("" + 0, "Goal\");
        gameView.displayMovesMadeVIew(0, "Moves Made\");
//        String[] values = {
//                String.valueOf(currentLevel),
//                String.valueOf(goalsRemaining),
//                String.valueOf(movesMade)
//        };
//        String[] labels = {
//                "Current Level",
//                "Goals Remaining",
//                "Moves Made"
//        };
        gameView.createThreeHeadersHorizontally(values, labels);

        // Calculate image size and generate grid
        int imageSize = gameView.calculateImageViewSize();
        gameView.generateImageGrid(7, 6, imageSize, 20, gameView.getMainLayoutId());
    }
}