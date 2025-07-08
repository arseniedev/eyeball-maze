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
    private boolean isFacingSouth = false;
    private ImageView previousEyeballCell = null;
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

            }
        return overlay;
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

    public void updateTextView(int viewId, String newText) {
        TextView textView = findViewById(viewId);

        if (textView != null) {
            textView.setText(newText);
        } else {
            LOGGER.log(Level.WARNING, "View ID not found: " + viewId);
        }
    }
    public void handleGridClick(View view) {
        LOGGER.log(Level.INFO, "Toggling eyeball direction");

        if (!(view instanceof ImageView)) {
            LOGGER.log(Level.WARNING, "Clicked view is not an ImageView");
            return;
        }

        ImageView clickedCell = (ImageView) view;
        GAME.moveCount ++;
        updateTextView(R.id.movesMadeValue, String.valueOf(GAME.moveCount));

        // Clear previous eyeball overlay (reset to base drawable)
        if (previousEyeballCell != null && previousEyeballCell != clickedCell) {
            resetCellToBaseDrawable(previousEyeballCell);
        }

        // Prepare eyeball drawable overlay
        int eyeballRes = isFacingSouth ? R.drawable.eyeball_north : R.drawable.eyeball_south;
        Drawable eyeballDrawable = ContextCompat.getDrawable(this, eyeballRes);

        if (eyeballDrawable != null) {
            eyeballDrawable.setTintList(null); // remove tint if any

            // Get base drawable for clicked cell
            Drawable baseDrawable = getBaseDrawableForCell(clickedCell);
            if (baseDrawable == null) {
                LOGGER.log(Level.WARNING, "Base drawable not found for clicked cell");
                baseDrawable = ContextCompat.getDrawable(this, R.drawable.line_none); // fallback drawable
            }

            // Combine base + eyeball overlay in a LayerDrawable
            LayerDrawable layeredDrawable = new LayerDrawable(new Drawable[]{baseDrawable, eyeballDrawable});
            clickedCell.setImageDrawable(layeredDrawable);

            // Update tracker
            previousEyeballCell = clickedCell;
            isFacingSouth = !isFacingSouth;
        }

        LOGGER.log(Level.INFO, "Eyeball moved to view ID: " + view.getId());
    }

    // Reset a cell's image to just its base drawable (remove eyeball overlay)
    private void resetCellToBaseDrawable(ImageView cell) {
        Drawable baseDrawable = getBaseDrawableForCell(cell);
        if (baseDrawable != null) {
            cell.setImageDrawable(baseDrawable);
        } else {
            cell.setImageDrawable(null);
        }
    }

    // Get the base drawable for a given ImageView cell by extracting its row and col from the ID
    private Drawable getBaseDrawableForCell(ImageView cell) {
        int[] rowCol = getRowColFromViewId(cell.getId());
        int row = rowCol[0];
        int col = rowCol[1];

        Square square = GAME.getSquareAt(row, col);
        if (square instanceof PlayableSquare) {
            PlayableSquare pSquare = (PlayableSquare) square;
            int baseResId = getDrawableFrom(pSquare.getShape(), pSquare.getColor());
            return ContextCompat.getDrawable(this, baseResId);
        }
        return null;
    }

    // Parse the row and column from your grid cell ID (assuming IDs like cellGrid_3_5)
    private int[] getRowColFromViewId(int viewId) {
        String resourceName = getResources().getResourceEntryName(viewId);
        // resourceName is like "cellGrid_3_5"
        String[] parts = resourceName.split("_");
        if (parts.length >= 3) {
            try {
                int row = Integer.parseInt(parts[1]) - 1; // zero-based index
                int col = Integer.parseInt(parts[2]) - 1; // zero-based index
                return new int[]{row, col};
            } catch (NumberFormatException e) {
                LOGGER.log(Level.WARNING, "Failed to parse row/col from view id: " + resourceName, e);
            }
        }
        return new int[]{0, 0}; // fallback
    }
}