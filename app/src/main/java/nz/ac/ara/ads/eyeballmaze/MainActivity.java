package nz.ac.ara.ads.eyeballmaze;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import nz.ac.ara.ads.eyeballmaze.enums.*;
import nz.ac.ara.ads.eyeballmaze.model.classes.*;
import nz.ac.ara.ads.eyeballmaze.model.data.*;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {
    static final Game GAME = new Game();
    static final GameLevel GAME_LEVEL = new GameLevel(8, 8);
//    EyeBall eyeBall = GAME.theEyeball;
    private ImageView previousEyeballCell = null;
    private Direction eyeballDirection = Direction.UP;
    private int eyeballRow = -1;
    private int eyeballCol = -1;
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    int[][] gridIds = {
            {R.id.cellGrid_1_1, R.id.cellGrid_1_2, R.id.cellGrid_1_3, R.id.cellGrid_1_4, R.id.cellGrid_1_5, R.id.cellGrid_1_6, R.id.cellGrid_1_7},
            {R.id.cellGrid_2_1, R.id.cellGrid_2_2, R.id.cellGrid_2_3, R.id.cellGrid_2_4, R.id.cellGrid_2_5, R.id.cellGrid_2_6, R.id.cellGrid_2_7},
            {R.id.cellGrid_3_1, R.id.cellGrid_3_2, R.id.cellGrid_3_3, R.id.cellGrid_3_4, R.id.cellGrid_3_5, R.id.cellGrid_3_6, R.id.cellGrid_3_7},
            {R.id.cellGrid_4_1, R.id.cellGrid_4_2, R.id.cellGrid_4_3, R.id.cellGrid_4_4, R.id.cellGrid_4_5, R.id.cellGrid_4_6, R.id.cellGrid_4_7},
            {R.id.cellGrid_5_1, R.id.cellGrid_5_2, R.id.cellGrid_5_3, R.id.cellGrid_5_4, R.id.cellGrid_5_5, R.id.cellGrid_5_6, R.id.cellGrid_5_7},
            {R.id.cellGrid_6_1, R.id.cellGrid_6_2, R.id.cellGrid_6_3, R.id.cellGrid_6_4, R.id.cellGrid_6_5, R.id.cellGrid_6_6, R.id.cellGrid_6_7},
            {R.id.cellGrid_7_1, R.id.cellGrid_7_2, R.id.cellGrid_7_3, R.id.cellGrid_7_4, R.id.cellGrid_7_5, R.id.cellGrid_7_6, R.id.cellGrid_7_7},
            {R.id.cellGrid_8_1, R.id.cellGrid_8_2, R.id.cellGrid_8_3, R.id.cellGrid_8_4, R.id.cellGrid_8_5, R.id.cellGrid_8_6, R.id.cellGrid_8_7}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        LevelData levelData = LevelRepository.LEVELS.get("level1");
        assert levelData != null;
        GAME_LEVEL.totalGoalCount = levelData.targetGoalCount();
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

        // Add all squares to the game grid
        for (SquareData data : levelData.squares()) {
            PlayableSquare square = new PlayableSquare(
                    Position.at(data.row(), data.column()),
                    data.color(), data.shape());
            GAME.addSquare(square, data.row(), data.column());
        }
        renderAllCells();

        Position startPos = levelData.eyeballPosition();
        GAME.addEyeball(startPos.row(), startPos.col(), Direction.UP);
        placeEyeball((PlayableSquare) GAME.getSquareAt(startPos.row(), startPos.col()));

        updateTextView(R.id.goalsRemainingValue, GAME.getCompletedGoalCount() + "/" + GAME_LEVEL.totalGoalCount);
        updateTextView(R.id.currentLevelValue, String.valueOf(currentLevel));
        updateTextView(R.id.movesMadeValue, String.valueOf(currentMoveCount));

        placeEyeballAt(7, 1, Direction.UP);
    }

    private void placeEyeball(@NonNull PlayableSquare square) {
        LOGGER.log(Level.INFO, "Placing visuals at: row=" + square.getRow() + ", col=" + square.getCol());
        ImageView cell = findCell(square.getRow(), square.getCol());
        if (cell == null) {
            logMissingCell(square.getRow(), square.getCol());
            return;
        }

        Drawable base = getDrawableForSquare(square);
        Drawable overlay = getOverlayDrawable(square);

        applyLayeredDrawable(cell, base, overlay);
    }
    private Drawable getDrawableForSquare(@NonNull PlayableSquare square) {
        return ContextCompat.getDrawable(this, getDrawableFrom(square.getShape(), square.getColor()));
    }
    @Nullable
    private Drawable getOverlayDrawable(@NonNull PlayableSquare square) {
        LevelData levelData = LevelRepository.LEVELS.get("level" + GAME.currentLevel);
        assert levelData != null;
//        int startRow = levelData.eyeballPosition().row();
//        int startCol = levelData.eyeballPosition().col();

        int row = square.getRow();
        int col = square.getCol();

//        GOAL_COORDINATES
        boolean goalCoordinates = LevelRepository.GOAL_COORDINATES.containsValue(Position.at(row, col));
        if (GAME.hasGoalAt(row, col)) {
            Drawable overlay = ContextCompat.getDrawable(this, R.drawable.empty_goal);
            if (overlay != null) overlay.setAlpha(100);
            return overlay;
        }
        return null;
    }

    private void applyLayeredDrawable(ImageView cell, Drawable base, Drawable overlay) {
        if (base == null && overlay == null) {
            cell.setImageDrawable(null);
            return;
        }
        Drawable[] layers = overlay != null ? new Drawable[]{base, overlay} : new Drawable[]{base};
        LayerDrawable layeredDrawable = new LayerDrawable(layers);
        cell.setImageDrawable(layeredDrawable);
    }

    private void logMissingCell(int row, int col) {
        LOGGER.log(Level.WARNING, "Cell not found at: [" + row + "][" + col + "]");
    }

    private void renderAllCells() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 7; col++) {
                Square square = GAME.getSquareAt(row, col);
                if (square instanceof PlayableSquare) {
                    placeEyeball((PlayableSquare) square);
                }
            }
        }
    }

    private ImageView findCell(int row, int col) {
        return findViewById(gridIds[row][col]);
    }

    private int getDrawableFrom(Shape shape, Color color) {
        if (shape != null && color != null) {
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
        if (!(view instanceof ImageView clickedCell)) {
            LOGGER.log(Level.WARNING, "Clicked view is not an ImageView");
            return;
        }

        int[] clickedPos = getRowColFromViewId(clickedCell.getId());
        int clickedRow = clickedPos[0];
        int clickedCol = clickedPos[1];

        Square s = GAME.getSquareAt(clickedRow, clickedCol);
        boolean isBlank = s instanceof BlankSquare;
        LOGGER.log(Level.INFO, String.valueOf(isBlank));
        // If no eyeball on grid yet, place it on clicked cell facing UP
        if (eyeballRow == -1 && eyeballCol == -1) {
            placeEyeballAt(clickedRow, clickedCol, Direction.UP);
            return;
        }

        Direction moveDir = getDirectionFromTo(eyeballRow, eyeballCol, clickedRow, clickedCol);

        if (moveDir == null) {
            // Not an adjacent cell (or invalid)
            Toast.makeText(this, "Can only move to adjacent cells", Toast.LENGTH_SHORT).show();
            return;
        }

        if (isOppositeDirection(moveDir, eyeballDirection)) {
            Toast.makeText(this, "Cannot move in opposite direction!", Toast.LENGTH_SHORT).show();
            return;
        }

        placeEyeballAt(clickedRow, clickedCol, moveDir);

        GAME.moveCount++;
        updateTextView(R.id.movesMadeValue, String.valueOf(GAME.moveCount));
        boolean checkGoal = GAME.hasGoalAt(clickedRow,clickedCol);
        updateTextView(R.id.goalsRemainingValue, GAME.getCompletedGoalCount() + "/" + GAME_LEVEL.totalGoalCount);
        if (checkGoal) {

            updateTextView(R.id.goalsRemainingValue, GAME.getCompletedGoalCount() + "/" + GAME_LEVEL.totalGoalCount);
        }
        LOGGER.log(Level.INFO, "Eyeball moved to row=" + clickedRow + ", col=" + clickedCol + ", direction=" + moveDir);
    }

    private void placeEyeballAt(int row, int col, Direction direction) {
        ImageView cell = findCell(row, col);
        if (cell == null) {
            LOGGER.log(Level.WARNING, "Cell not found at row=" + row + ", col=" + col);
            return;
        }

        if (previousEyeballCell != null && previousEyeballCell != cell) {
            resetCellToBaseDrawable(previousEyeballCell);
        }

        Drawable baseDrawable = getBaseDrawableForCell(cell);
        if (baseDrawable == null) {
            baseDrawable = ContextCompat.getDrawable(this, R.drawable.line_none);
        }

        int eyeballRes = switch (direction) {
            case UP -> R.drawable.eyeball_north;
            case DOWN -> R.drawable.eyeball_south;
            case LEFT -> R.drawable.eyeball_west;
            case RIGHT -> R.drawable.eyeball_east;
            default -> R.drawable.eyeball_north; // fallback
        };

        Drawable eyeballDrawable = ContextCompat.getDrawable(this, eyeballRes);
        if (eyeballDrawable != null) {
            eyeballDrawable.setTintList(null);
        }

        applyLayeredDrawable(cell, baseDrawable, eyeballDrawable);

        previousEyeballCell = cell;
        eyeballRow = row;
        eyeballCol = col;
        eyeballDirection = direction;
    }
    private void resetCellToBaseDrawable(ImageView cell) {
        Drawable baseDrawable = getBaseDrawableForCell(cell);
        cell.setImageDrawable(baseDrawable);
    }
    @Nullable
    private Drawable getBaseDrawableForCell(ImageView cell) {
        int[] rowCol = getRowColFromViewId(cell.getId());
        int row = rowCol[0];
        int col = rowCol[1];
        Square square = GAME.getSquareAt(row, col);
        if (square instanceof PlayableSquare) {
            PlayableSquare pSquare = (PlayableSquare) square;
            return ContextCompat.getDrawable(this, getDrawableFrom(pSquare.getShape(), pSquare.getColor()));
        }
        return null;
    }
    private int[] getRowColFromViewId(int viewId) {
        String resourceName = getResources().getResourceEntryName(viewId);
        String[] parts = resourceName.split("_");
        if (parts.length >= 3) {
            try {
                int row = Integer.parseInt(parts[1]) - 1;
                int col = Integer.parseInt(parts[2]) - 1;
                return new int[]{row, col};
            } catch (NumberFormatException e) {
                LOGGER.log(Level.WARNING, "Failed to parse row/col from view id: " + resourceName, e);
            }
        }
        return new int[]{0, 0};
    }
    // Get direction from one cell to adjacent cell
    private Direction getDirectionFromTo(int fromRow, int fromCol, int toRow, int toCol) {
        if (toRow == fromRow - 1 && toCol == fromCol) return Direction.UP;
        if (toRow == fromRow + 1 && toCol == fromCol) return Direction.DOWN;
        if (toCol == fromCol - 1 && toRow == fromRow) return Direction.LEFT;
        if (toCol == fromCol + 1 && toRow == fromRow) return Direction.RIGHT;
        return null; // not adjacent
    }

    // Check if two directions are opposites
    private boolean isOppositeDirection(Direction dir1, Direction dir2) {
        return (dir1 == Direction.UP && dir2 == Direction.DOWN) ||
                (dir1 == Direction.DOWN && dir2 == Direction.UP) ||
                (dir1 == Direction.LEFT && dir2 == Direction.RIGHT) ||
                (dir1 == Direction.RIGHT && dir2 == Direction.LEFT);
    }
    public void handleResetButtonClick(View view) {
        LOGGER.log(Level.INFO, "Resetting game state");

        GAME.currentLevel = 1;
        GAME.moveCount = 0;

        LevelData levelData = LevelRepository.LEVELS.get("level1");
        if (levelData == null) {
            LOGGER.log(Level.WARNING, "Level 1 data not found");
            return;
        }

        // Reset board
        GAME.addLevel(8, 8);
        GAME.setLevel(1);
        GAME.moveCount = 0;
        for (SquareData data : levelData.squares()) {
            PlayableSquare square = new PlayableSquare(
                    Position.at(data.row(), data.column()),
                    data.color(), data.shape());
            GAME.addSquare(square, data.row(), data.column());
        }

        renderAllCells();

        // Reset eyeball to (6, 0) = grid position 7,1
        eyeballRow = -1;  // clear previous internal tracking
        eyeballCol = -1;
        previousEyeballCell = null;
        placeEyeballAt(7, 1, Direction.UP);

        // Update UI text
        updateTextView(R.id.currentLevelValue, "1");
        updateTextView(R.id.movesMadeValue, "0");
        updateTextView(R.id.goalsRemainingValue, GAME.getCompletedGoalCount() + "/" + GAME_LEVEL.totalGoalCount);
        Toast.makeText(this, "Game reset to Level 1", Toast.LENGTH_SHORT).show();

    }

}
