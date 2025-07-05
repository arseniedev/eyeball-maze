package nz.ac.ara.ads.eyeballmaze;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import nz.ac.ara.ads.eyeballmaze.enums.Color;
import nz.ac.ara.ads.eyeballmaze.enums.Shape;
import nz.ac.ara.ads.eyeballmaze.model.classes.Game;
import nz.ac.ara.ads.eyeballmaze.model.classes.Square;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import android.graphics.Bitmap;
import android.icu.text.SymbolTable;
import android.net.http.UploadDataProvider;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final Game GAME = new Game();
    private int moveCount = 0;
    //    private TextView cu
    final ImageView[] imageViews = new ImageView[GAME.getLevelCount()];
    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
//    Button startButton = findViewById(R.id.button_start);

    int[][] gridIds = {
            { R.id.cellGrid_1_1, R.id.cellGrid_1_2, R.id.cellGrid_1_3, R.id.cellGrid_1_4, R.id.cellGrid_1_5, R.id.cellGrid_1_6, R.id.cellGrid_1_7 },
            { R.id.cellGrid_2_1, R.id.cellGrid_2_2, R.id.cellGrid_2_3, R.id.cellGrid_2_4, R.id.cellGrid_2_5, R.id.cellGrid_2_6, R.id.cellGrid_2_7 },
            { R.id.cellGrid_3_1, R.id.cellGrid_3_2, R.id.cellGrid_3_3, R.id.cellGrid_3_4, R.id.cellGrid_3_5, R.id.cellGrid_3_6, R.id.cellGrid_3_7 },
            { R.id.cellGrid_4_1, R.id.cellGrid_4_2, R.id.cellGrid_4_3, R.id.cellGrid_4_4, R.id.cellGrid_4_5, R.id.cellGrid_4_6, R.id.cellGrid_4_7 },
            { R.id.cellGrid_5_1, R.id.cellGrid_5_2, R.id.cellGrid_5_3, R.id.cellGrid_5_4, R.id.cellGrid_5_5, R.id.cellGrid_5_6, R.id.cellGrid_5_7 },
            { R.id.cellGrid_6_1, R.id.cellGrid_6_2, R.id.cellGrid_6_3, R.id.cellGrid_6_4, R.id.cellGrid_6_5, R.id.cellGrid_6_6, R.id.cellGrid_6_7 },
            { R.id.cellGrid_7_1, R.id.cellGrid_7_2, R.id.cellGrid_7_3, R.id.cellGrid_7_4, R.id.cellGrid_7_5, R.id.cellGrid_7_6, R.id.cellGrid_7_7 },
            { R.id.cellGrid_8_1, R.id.cellGrid_8_2, R.id.cellGrid_8_3, R.id.cellGrid_8_4, R.id.cellGrid_8_5, R.id.cellGrid_8_6, R.id.cellGrid_8_7 }
    };

    ImageView[][] cellGridImages = new ImageView[7][8];


    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void handleStartButtonClick(View view) {
        LOGGER.log(Level.INFO, "Clear Grid");
        clearGrid();
        LOGGER.log(Level.INFO, "Setting level:");
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 4; col++) {
                ImageView cell = findViewById(gridIds[row][col]);
                    cell.setImageResource(R.drawable.shape_cross_yellow); // replace with your desired image
            }
        }
//        GAME.setLevel(1);

        updateTextView(R.id.currentLevelValue, String.valueOf(GAME.getLevelCount()));
        updateTextView(R.id.goalsRemainingValue, String.valueOf(GAME.getGoalCount()));
    }
//    private void initialiseGame() {
////        GAME.addLevel(8,7);
////        GAME.addGoal(0,0);
//    }
    private void clearGrid() {
        // Clear grid first (optional)
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 7; col++) {
                ImageView cell = findViewById(gridIds[row][col]);
                cell.setImageResource(R.drawable.line_none);
            }
        }
    }

    public void getDrawableFromSquare(Square square) {
        Shape shape = square.getShape();
        Color color = square.getColor();

//        if(shape==Shape.CIRCLE)
    }

    public void updateTextView(int viewId, String newText) {
        TextView textView = findViewById(viewId);
        if (textView != null) {
            textView.setText(newText);
        } else {
            LOGGER.log(Level.WARNING, "View ID not found: " + viewId);
        }
    }
}