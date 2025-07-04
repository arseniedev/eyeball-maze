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

        // Setup UI (View)
        gameView.setupWindowInsetsPadding();

        // Create header view (you can pass actual values)
        gameView.createHeaderView("Level " + currentLevel, "Current Level");

        // Calculate image size and generate grid
        int imageSize = gameView.calculateImageViewSize();
        gameView.generateImageGrid(7, 6, imageSize, 20, gameView.getMainLayoutId());
    }
}