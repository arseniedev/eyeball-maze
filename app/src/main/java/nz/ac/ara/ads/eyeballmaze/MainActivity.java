package nz.ac.ara.ads.eyeballmaze;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import nz.ac.ara.ads.eyeballmaze.enums.Color;
import nz.ac.ara.ads.eyeballmaze.enums.Direction;
import nz.ac.ara.ads.eyeballmaze.enums.Shape;
import nz.ac.ara.ads.eyeballmaze.model.classes.EyeBall;
import nz.ac.ara.ads.eyeballmaze.model.classes.Game;
import nz.ac.ara.ads.eyeballmaze.model.classes.PlayableSquare;
import nz.ac.ara.ads.eyeballmaze.model.data.LevelData;
import nz.ac.ara.ads.eyeballmaze.model.data.LevelRepository;

import java.util.HashMap;
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
    static EyeBall EyeBall;
    static final int maxLevel = 4;
    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
public static final Map<String, Integer> shapeColorDrawableMap = new HashMap<>();

    static {
        shapeColorDrawableMap.put("STAR_RED", R.drawable.shape_star_red);
        shapeColorDrawableMap.put("STAR_BLUE", R.drawable.shape_star_blue);
        shapeColorDrawableMap.put("STAR_YELLOW", R.drawable.shape_star_yellow);
        shapeColorDrawableMap.put("STAR_GREEN", R.drawable.shape_star_green);

        shapeColorDrawableMap.put("CROSS_RED", R.drawable.shape_cross_red);
        shapeColorDrawableMap.put("CROSS_BLUE", R.drawable.shape_cross_blue);
        shapeColorDrawableMap.put("CROSS_YELLOW", R.drawable.shape_cross_yellow);
        shapeColorDrawableMap.put("CROSS_GREEN", R.drawable.shape_cross_green);

        shapeColorDrawableMap.put("DIAMOND_RED", R.drawable.shape_diamond_red);
        shapeColorDrawableMap.put("DIAMOND_BLUE", R.drawable.shape_diamond_blue);
        shapeColorDrawableMap.put("DIAMOND_YELLOW", R.drawable.shape_diamond_yellow);
        shapeColorDrawableMap.put("DIAMOND_GREEN", R.drawable.shape_diamond_green);

        shapeColorDrawableMap.put("FLOWER_RED", R.drawable.shape_flower_red);
        shapeColorDrawableMap.put("FLOWER_BLUE", R.drawable.shape_flower_blue);
        shapeColorDrawableMap.put("FLOWER_YELLOW", R.drawable.shape_flower_yellow);
        shapeColorDrawableMap.put("FLOWER_GREEN", R.drawable.shape_flower_green);

        shapeColorDrawableMap.put("EMPTY", R.drawable.line_none);
    }
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
    public void handleSoundSwitchClick(View view) {
        LOGGER.log(Level.INFO, "Sound On/off");
//        GAME.toggleSound();
    }
    public void handleResetButtonClick(View view) {
        LOGGER.log(Level.INFO, "Clear Grid");
        clearGrid();
        updateTextView(R.id.currentLevelValue, String.valueOf(1));
        updateTextView(R.id.goalsRemainingValue, String.valueOf(0));
        updateTextView(R.id.movesMadeValue, String.valueOf(GAME.moveCount));
    }
    public void handleUndoButtonClick(View view) {
        LOGGER.log(Level.INFO, "Clear Grid");
        clearGrid();
        updateStatusViews(GAME.getLevelCount(), GAME.getGoalCount());
    }
    public void handleStartButtonClick(View view) {
        LOGGER.log(Level.INFO, "Clear Grid");
        clearGrid();

        int currentLevel = GAME.getLevelCount();
        LevelData levelData = LevelRepository.LEVELS.get("level" + currentLevel);

        if (levelData == null) {
            LOGGER.log(Level.WARNING, "Level not found: " + currentLevel);
            return;
        }
        LOGGER.log(Level.INFO, "Setting Level " + currentLevel);

        GAME.addLevel(levelData.levelHeight(), levelData.levelWidth());
        for (PlayableSquare square : levelData.squares()) {
            handleInitialMarker(square);
            handleCellAt(square);
        }
        if (currentLevel >= maxLevel) {
            GAME.setLevel(1);
        }
        updateTextView(R.id.currentLevelValue, String.valueOf(currentLevel));
        updateTextView(R.id.goalsRemainingValue, String.valueOf(levelData.totalGoalCount()));
        updateTextView(R.id.movesMadeValue, String.valueOf(GAME.moveCount));
    }
    private void handleInitialMarker(@NonNull PlayableSquare square) {
        System.out.println("  Shape: " + square.getShape() +
                ", Color: " + square.getColor() +
                ", Goal: " + square.isGoal +
                ", At [" + square.row + "," + square.col + "]");

        GAME.addSquare(square, square.row, square.col);
//        GAME.addEyeball(square.row, square.col, direction);
    }
    private void handleCellAt(@NonNull PlayableSquare square) {
        int drawableRes = getDrawableFrom(square.getShape(), square.getColor());
        ImageView cell = findCell(square.row, square.col);

        if (cell != null) {
            Drawable base = ContextCompat.getDrawable(this, drawableRes);
            Drawable overlay = getOverlay(square); // move this outside if-block

            if (square.isCurrent()) {
                LOGGER.log(Level.INFO, "Currently at: row=" + square.row + ", col=" + square.col);
                overlay = ContextCompat.getDrawable(this, R.drawable.eyeball);
            }

            applyDrawableToCell(cell, base, overlay, drawableRes);
            attachClickListener(cell, square);
        } else {
            logMissingCell(square.row, square.col);
        }
    }
    private Drawable getOverlay(@NonNull PlayableSquare square) {
        Drawable overlay = null;

        if (GAME.hasGoalAt(square.row, square.col)) {
            overlay = ContextCompat.getDrawable(this, R.drawable.empty_goal);
            if (overlay != null) overlay.setAlpha(100);
        } else if (square.isCurrent()) {
            GAME.addEyeball(square.row, square.col, Direction.UP);
            overlay = ContextCompat.getDrawable(this, R.drawable.eyeball);
        }

        return overlay;
    }
    private void applyDrawableToCell(ImageView cell, Drawable base, Drawable overlay, int fallbackResId) {
        if (overlay != null || base != null) {
            LayerDrawable layeredDrawable = new LayerDrawable(new Drawable[]{base, overlay});
            cell.setImageDrawable(layeredDrawable);
        } else {
            cell.setImageResource(fallbackResId);
        }
    }
    private void attachClickListener(@NonNull ImageView cell, PlayableSquare square) {
        cell.setOnClickListener(v -> handleCellClick(square));
    }
    private void logMissingCell(int row, int col) {
        LOGGER.log(Level.WARNING, "Cell not found at: [" + row + "][" + col + "]");
    }
/*
*   private void handleCellClick(@NonNull PlayableSquare square) {
        int row = square.row;
        int col = square.col;

        LOGGER.log(Level.INFO, "Clicked on: [" + row + "][" + col + "]");

        // 🧹 Remove eyeball from the previous current square
        PlayableSquare previous = GAME.getCurrentSquare();
        if (previous != null) {
            previous.setCurrent(false);
            handleCellAt(previous);  // Refresh UI for previous
        }

        // 🎯 Set new square as current and refresh UI
        square.setCurrent(true);
        handleCellAt(square);

        // 🎮 Optionally track move count
        GAME.moveCount++;
        updateTextView(R.id.movesMadeValue, String.valueOf(GAME.moveCount));
    }
* */
    private void handleCellClick(@NonNull PlayableSquare square) {
        int row = square.row;
        int col = square.col;

        LOGGER.log(Level.INFO, "Clicked on: [" + row + "][" + col + "]");

        // 🧹 Remove eyeball from the previous current square
        PlayableSquare previous = GAME.getCurrentSquare();
        if (previous != null) {
            previous.setCurrent(false);
            handleCellAt(previous);  // Refresh UI for previous
        }

        // 🎯 Set new square as current and refresh UI
        square.setCurrent(true);
        handleCellAt(square);

        // 🎮 Optionally track move count
        GAME.moveCount++;
        updateTextView(R.id.movesMadeValue, String.valueOf(GAME.moveCount));



//        int targetRow  = square.row;
//        int targetColumn = square.col;
//
//        int currentRow = GAME.getEyeballRow();
//        int currentCol = GAME.getEyeballColumn();

//        Direction currentDirection = GAME.getEyeballDirection();
//        LOGGER.log(Level.INFO, "Current Direction: " + currentDirection);
//        LOGGER.log(Level.INFO, "Clicked on: [" + square.row + "][" + square.col + "]");

//        Direction newDirection = currentDirection;
//        float newRotation = EyeBall.currentEyeballRotation;

//        if (targetColumn > currentCol) {
//            newDirection = EyeBall.rotateDirection(currentDirection, true);
//            newRotation += 90f;
//        } else if (targetColumn < currentCol) {
//            newDirection = EyeBall.rotateDirection(currentDirection,false);
//            newRotation -= 90f;
//        }

        // Store updated rotation
//        EyeBall.currentEyeballRotation = newRotation;

//        // Move eyeball logically
//        GAME.addEyeball(targetRow, targetColumn, newDirection);
//        GAME.moveTo(targetRow, targetColumn);

//        // Find the eyeball view and apply rotation
//        ImageView eyeballView = findCell(targetRow, targetColumn);
//        if (eyeballView != null) {
//            rotateEyeball(eyeballView, 0f, EyeBall.currentEyeballRotation);
//        }

        // Update move count
        updateTextView(R.id.movesMadeValue, String.valueOf(GAME.moveCount));

        // Move the current state (handled inside Game)
        GAME.moveTo(square.row, square.col);

        updateTextView(R.id.movesMadeValue, String.valueOf(GAME.moveCount));
    }
    private ImageView findCell(int row, int col) {
        return findViewById(gridIds[row][col]);
    }
    private int getDrawableFrom(Shape shape, Color color) {

        String key = (shape != null && color != null)
                ? shape.name() + "_" + color.name()
                : "EMPTY";
        LOGGER.log(Level.WARNING, "DrawableKey: " + key);

        return shapeColorDrawableMap.getOrDefault(key, R.drawable.line_none);
    }
    private void rotateEyeball(ImageView eyeballView, float prevDegrees, float currentDegrees) {
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
    private void clearGrid() {
        // Clear grid first (optional)
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 7; col++) {
                ImageView cell = findViewById(gridIds[row][col]);
                cell.setImageResource(R.drawable.line_none);
            }
        }
        GAME.moveCount = 0;
        updateTextView(R.id.movesMadeValue, String.valueOf(GAME.moveCount));
    }
    private void updateStatusViews(int currentLevel, int goalCount) {
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