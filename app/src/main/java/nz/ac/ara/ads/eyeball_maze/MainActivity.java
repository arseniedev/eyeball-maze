package nz.ac.ara.ads.eyeball_maze;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
//import nz.ac.ara.ads.eyeball_maze.GameController;
import nz.ac.ara.ads.eyeball_maze.model.classes.Game;
import nz.ac.ara.ads.eyeball_maze.view.GameView;
import androidx.activity.EdgeToEdge;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.main);

        Game game = new Game();
        GameView gameView = new GameView(this, mainLayout);
        GameController gameController = new GameController(game, gameView);

        gameController.initGame();
    }
}
