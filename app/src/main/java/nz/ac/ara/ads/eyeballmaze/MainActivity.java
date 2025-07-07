package nz.ac.ara.ads.eyeballmaze;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import nz.ac.ara.ads.eyeballmaze.enums.*;
import nz.ac.ara.ads.eyeballmaze.model.classes.*;
import nz.ac.ara.ads.eyeballmaze.model.data.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import java.util.*;

import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final Game GAME = new Game();
    EyeBall eyeBall = GAME.theEyeball;

    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

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

//    public void handleResetButtonClick(View view) {
//        LOGGER.log(Level.INFO, "Clear Grid");
//        moveCount = 0;
//        GAME.setLevel(1);
//        updateTextView(R.id.currentLevelValue, String.valueOf(GAME.getLevelCount()));
//        updateTextView(R.id.goalsRemainingValue, 0+ " / " + 1);
//
//    }
//    public void handleUndoButtonClick(View view) {
//        LOGGER.log(Level.INFO, "Clear Grid");
//        updateTextView(R.id.currentLevelValue, String.valueOf(GAME.getLevelCount()));
//        updateTextView(R.id.goalsRemainingValue, GAME.getCompletedGoalCount() + " / " + GAME.getGoalCount());
//    }
    public void handleStartButtonClick(View view) {
        int currentLevel = GAME.currentLevel;
        int currentMoveCount = GAME.moveCount;

        LevelData levelData = LevelRepository.LEVELS.get("level" + currentLevel);

        if (levelData == null) {
            LOGGER.log(Level.WARNING, "Level not found: level" + currentLevel);
            return;
        }
        LOGGER.log(Level.INFO, "Setting up Level " + currentLevel);
        GAME.addLevel(8, 8);
        GAME.setLevel(currentLevel);

        // First add all squares to the game grid
        for (SquareData data : levelData.squares()) {
            PlayableSquare square = new PlayableSquare(
                    Position.at(data.row(), data.column()),
                    data.color(), data.shape());
            GAME.addSquare(square, data.row(), data.column());
        }
        renderAllCells();
        Position startPos = levelData.eyeballPosition();

        GAME.addEyeball(startPos.row(), startPos.col(), Direction.UP);
        PlayableSquare startSquare = (PlayableSquare) GAME.getSquareAt(startPos.row(), startPos.col());

    //  place the eyeball
        placeEyeball(startSquare);

        StringBuilder sb = new StringBuilder();
        sb.append(GAME.getCompletedGoalCount()).append("/").append(GAME.getGoalCount());

        updateTextView(R.id.goalsRemainingValue, String.valueOf(sb));

        LOGGER.log(Level.INFO, "Setting up initial marker");
        updateTextView(R.id.currentLevelValue, String.valueOf(currentLevel));
        updateTextView(R.id.movesMadeValue, String.valueOf(currentMoveCount));
    }
    private void placeEyeball(@NonNull PlayableSquare square) {
        LOGGER.log(Level.INFO, "Placing visuals at: row=" + square.getRow() + ", col=" + square.getCol());

        int drawableRes = getDrawableFrom(square.getShape(), square.getColor());
        Drawable base = ContextCompat.getDrawable(this, drawableRes);
        Drawable overlay = getOverlay(square);

        ImageView cell = findCell(square.getRow(), square.getCol());
        if (cell != null) {
            LOGGER.log(Level.INFO, "Found cell at: row=" + square.getRow() + ", col=" + square.getCol());
            applyDrawableToCell(cell, base, overlay, drawableRes);
            cell.setOnClickListener(v -> handleCellClick(square));
        } else {
            logMissingCell(square.getRow(), square.getCol());
        }
    }
    private Drawable getOverlay(@NonNull PlayableSquare square) {
        Drawable overlay = null;
        LevelData levelData = LevelRepository.LEVELS.get("level" + GAME.currentLevel);
        assert levelData != null;
        int startRow = levelData.eyeballPosition().row();
        int startCol = levelData.eyeballPosition().col();

        var row = square.getRow();
        var col = square.getCol();

        if (GAME.hasGoalAt(row, col)) {
            overlay = ContextCompat.getDrawable(this, R.drawable.empty_goal);
            if (overlay != null) overlay.setAlpha(100);
        }
            if (col == startCol && row == startRow) {
                var startDir = Direction.UP;
                GAME.addEyeball(row, col, startDir);

                overlay = switch (startDir) {
                    case UP, DOWN, LEFT, RIGHT -> getEyeballDrawable(startDir);
                    default -> throw new IllegalStateException("Unexpected direction: " + startDir);
                };
            }
        return overlay;
    }
    private static final Map<Direction, Integer> DIRECTION_TO_DRAWABLE = Map.of(
            Direction.UP, R.drawable.eyeball_north,
            Direction.DOWN, R.drawable.eyeball_south,
            Direction.LEFT, R.drawable.eyeball_west,
            Direction.RIGHT, R.drawable.eyeball_east
    );
    private Drawable getEyeballDrawable(Direction direction) {
        var resId = DIRECTION_TO_DRAWABLE.get(direction);
        return ContextCompat.getDrawable(this, resId);
    }
    private void applyDrawableToCell(ImageView cell, Drawable base, Drawable overlay, int fallbackResId) {
        if (overlay != null || base != null) {
            LayerDrawable layeredDrawable = new LayerDrawable(new Drawable[]{base, overlay});
            cell.setImageDrawable(layeredDrawable);
        } else {
        }
    }
    private void logMissingCell(int row, int col) {
        LOGGER.log(Level.WARNING, "Cell not found at: [" + row + "][" + col + "]");
    }
    public void handleCellClick(@NonNull Square clickedSquare) {
        int clickedRow = clickedSquare.getRow();
        int clickedCol = clickedSquare.getCol();

        eyeBall.selectNextGrid(clickedRow,clickedCol);
        LOGGER.log(Level.INFO, "Clicked on: [" + clickedRow + "][" + clickedCol + "]");
//        PlayableSquare previous = GAME.getCurrentSquare();

        GAME.moveCount ++;
        // Update UI
        updateTextView(R.id.movesMadeValue, String.valueOf(++GAME.moveCount));
        updateTextView(R.id.goalsRemainingValue, GAME.getCompletedGoalCount() + " / " + GAME.getGoalCount());
    }
    private void renderAllCells() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 7; col++) {
                Square square = GAME.getSquareAt(row, col);
                if (square instanceof PlayableSquare) {
                    LOGGER.log(Level.INFO, "Rendering: row=" + row + ", col=" + col);
                    placeEyeball((PlayableSquare) square); // render base + overlay
                }
            }
        }
    }
//    private void renderCell(int row, int col) {
//        Square square = GAME.getSquareAt(row, col);
//        if (!(square instanceof PlayableSquare)) return;
//
//        PlayableSquare pSquare = (PlayableSquare) square;
//        ImageView cell = findCell(row, col);
//        if (cell == null) {
//            logMissingCell(row, col);
//            return;
//        }
//        int baseDrawableId = getDrawableFrom(pSquare.getShape(), pSquare.getColor());
//        Drawable base = ContextCompat.getDrawable(this, baseDrawableId);
//
//        Drawable overlay = null;
//        if (GAME.hasGoalAt(row, col)) {
//            overlay = ContextCompat.getDrawable(this, R.drawable.empty_goal);
//            if (overlay != null) overlay.setAlpha(100);
//        }
//        if (GAME.isEyeballAt(row, col)) {
//            overlay = ContextCompat.getDrawable(this, R.drawable.eyeball);
//        }
//        applyDrawableToCell(cell, base, overlay, baseDrawableId);
//    }
    private ImageView findCell(int row, int col) {
        return findViewById(gridIds[row][col]);
    }
    private int getDrawableFrom(Shape shape, Color color) {
        if (shape != null && color != null) {
            LOGGER.log(Level.INFO, "DrawableKey: " + shape.name() + "_" + color.name());
            String key = shape.name() + "_" + color.name();

            LOGGER.log(Level.WARNING, "DrawableKey: " + key);
            return shape.getDrawable(color);
        } else {
            return R.drawable.line_none;
        }
    }
    private void rotateEyeball(@NonNull ImageView eyeballView, float prevDegrees, float currentDegrees) {
        android.view.animation.RotateAnimation rotate = new android.view.animation.RotateAnimation(
                prevDegrees,
                currentDegrees,
                android.view.animation.Animation.RELATIVE_TO_SELF, 0.5f,
                android.view.animation.Animation.RELATIVE_TO_SELF, 0.5f
        );
        rotate.setDuration(300); // duration in ms
        rotate.setFillAfter(true); // maintain end position
        eyeballView.startAnimation(rotate);
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