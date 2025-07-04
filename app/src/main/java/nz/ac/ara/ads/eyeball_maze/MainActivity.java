package nz.ac.ara.ads.eyeball_maze;

import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowMetrics;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;
import java.util.Map;

import nz.ac.ara.ads.eyeball_maze.model.classes.Game;
import nz.ac.ara.ads.eyeball_maze.model.classes.GameLevel;
import nz.ac.ara.ads.eyeball_maze.model.classes.HeaderLabel;
import nz.ac.ara.ads.eyeball_maze.model.classes.Position;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout mainLayout;
    Map<Position, Boolean> playableSquareMap = new HashMap<>();
    Game game = new Game();
    int currentLevel = game.getLevelCount();
//    GameLevel level =


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupEdgeToEdge();
        setContentView(R.layout.activity_main);
        applyWindowInsetsPadding();

        mainLayout = findViewById(R.id.main);


        // UI Anchor (Header)

        // String
        createHeaderView();

//        createLabeledTextView(value, label,valueViewId,labelViewId)


//        TextView textView = createConfiguredTextView();
//        mainLayout.addView(textView);
//        applyTextViewConstraints(textView);

        // Add 5x7 grid below the TextView
        int imageSize = calculateImageViewSize();
        generateImageGrid(7, 6, imageSize, 20, R.id.main);
    }

    // Layout Setup
    private void setupEdgeToEdge() {
        EdgeToEdge.enable(this);
    }

    private void applyWindowInsetsPadding() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars()).toPlatformInsets();
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    // TextView
    private TextView createConfiguredTextView() {
        TextView textView = new TextView(this);
        textView.setId(R.id.text_msg);
        textView.setText(R.string.msg);
        textView.setTextSize(12);
        return textView;
    }

    private void applyTextViewConstraints(TextView valueView, TextView labelView) {
//        int topMargin = 34;
//        int spacing = 23;
//
//        ConstraintSet constraintSet = new ConstraintSet();
//        constraintSet.clone(mainLayout);
//
//        // Value on top
//        constraintSet.connect(valueView.getId(), ConstraintSet.TOP, mainLayout.getId(), ConstraintSet.TOP, topMargin);
//        constraintSet.connect(valueView.getId(), ConstraintSet.START, mainLayout.getId(), ConstraintSet.START, 16);
//        constraintSet.connect(valueView.getId(), ConstraintSet.END, mainLayout.getId(), ConstraintSet.END, 16);
//        // Label below value
//        constraintSet.connect(labelView.getId(), ConstraintSet.TOP, mainLayout.getId(), ConstraintSet.TOP, topMargin);
//        constraintSet.connect(labelView.getId(), ConstraintSet.START, mainLayout.getId(), ConstraintSet.START, 16);
//        constraintSet.connect(labelView.getId(), ConstraintSet.END, mainLayout.getId(), ConstraintSet.END, 16);

        // Sizes
//        constraintSet.constrainWidth(valueView.getId(), ConstraintSet.WRAP_CONTENT);
//        constraintSet.constrainHeight(valueView.getId(), ConstraintSet.WRAP_CONTENT);
//        constraintSet.constrainWidth(labelView.getId(), ConstraintSet.WRAP_CONTENT);
//        constraintSet.constrainHeight(labelView.getId(), ConstraintSet.WRAP_CONTENT);
//        constraintSet.createHorizontalChain(
//                mainLayout.getId(), ConstraintSet.START,
//                mainLayout.getId(), ConstraintSet.END,
//                new int[]{view1, view2, view3},
//                null,
//                ConstraintSet.CHAIN_SPREAD
//        );

//        constraintSet.applyTo(mainLayout);

//        constraintSet.connect(valueView.getId(), ConstraintSet.TOP, mainLayout.getId(), ConstraintSet.TOP, 86);
//        constraintSet.connect(valueView.getId(), ConstraintSet.START, mainLayout.getId(), ConstraintSet.START, 16);
//
//        constraintSet.connect(labelView.getId(), ConstraintSet.TOP, mainLayout.getId(), ConstraintSet.TOP, 86);
//        constraintSet.connect(labelView.getId(), ConstraintSet.START, mainLayout.getId(), ConstraintSet.START, 16);
//
//        constraintSet.constrainHeight(valueView.getId(), ConstraintSet.WRAP_CONTENT);
//        constraintSet.constrainWidth(valueView.getId(), ConstraintSet.WRAP_CONTENT);
//        constraintSet.applyTo(mainLayout);
    }

    // Legacy ImageView (Optional)
//    private ImageView createConfiguredImageView() {
//        ImageView imageView = new ImageView(this);
//        imageView.setId(View.generateViewId());
//        imageView.setImageResource(R.drawable.snapchat);
//        int imageSize = calculateImageViewSize();
//        imageView.setLayoutParams(new ConstraintLayout.LayoutParams(imageSize, imageSize));
//        return imageView;
//    }

    private void applyImageViewConstraints(ImageView imageView, int anchorViewId) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(mainLayout);
        constraintSet.connect(imageView.getId(), ConstraintSet.TOP, anchorViewId, ConstraintSet.BOTTOM, 26);
        constraintSet.connect(imageView.getId(), ConstraintSet.START, mainLayout.getId(), ConstraintSet.START, 26);
        constraintSet.applyTo(mainLayout);
    }

    // Modular Grid
    private void generateImageGrid(int rows, int cols, int cellSize, int spacing, int topAnchorId) {
        // To track grid cell IDs
        int[][] gridViewIds = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                ImageView cell = createGridImageView(cellSize);
                mainLayout.addView(cell);
                gridViewIds[row][col] = cell.getId();
            }
        }
        applyGridConstraints(gridViewIds, spacing, topAnchorId);
    }

    private ImageView createGridImageView(int sizePx) {
        ImageView imageView = new ImageView(this);
        imageView.setId(View.generateViewId());
        imageView.setImageResource(R.drawable.line_full);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(sizePx, sizePx);
        imageView.setLayoutParams(params);
        return imageView;
    }

    private void applyGridConstraints(int[][] ids, int spacing, int topAnchorId) {
        ConstraintSet set = new ConstraintSet();
        set.clone(mainLayout);

        int rows = ids.length;
        int cols = ids[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int cellId = ids[row][col];

                // Top
                if (row == 0) {
                    set.connect(cellId, ConstraintSet.TOP, topAnchorId, ConstraintSet.TOP, 180);
                } else {
                    set.connect(cellId, ConstraintSet.TOP, ids[row - 1][col], ConstraintSet.BOTTOM, 20);
                }

                // Start
                if (col == 0) {
                    set.connect(cellId, ConstraintSet.START, mainLayout.getId(), ConstraintSet.START, 25);
                } else {
                    set.connect(cellId, ConstraintSet.START, ids[row][col - 1], ConstraintSet.END, 15);
                }

                // Optional: Right-align last column to allow centering/bounds adjustment
//                if (col == cols - 1) {
//                    set.connect(cellId, ConstraintSet.START, mainLayout.getId(), ConstraintSet.END, spacing);
//                }
            }
        }
        set.applyTo(mainLayout);
    }

    private int calculateImageViewSize() {
        WindowMetrics metrics = getWindowManager().getCurrentWindowMetrics();
        Insets insets = metrics.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.systemBars());
        Rect bounds = metrics.getBounds();
        int usableWidth = bounds.width() - insets.left - insets.right;
        return usableWidth / 7;
    }

    private void createHeaderView() {
        ConstraintLayout container = new ConstraintLayout(this);
        int containerId = View.generateViewId();
        container.setId(containerId);

        TextView valueText = new TextView(this);
        valueText.setId(View.generateViewId());
//        valueText.setText(value);
        valueText.setTextSize(18);
        valueText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        TextView labelText = new TextView(this);
        labelText.setId(View.generateViewId());
//        labelText.setText(label);
        labelText.setTextSize(12);
        labelText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        container.addView(valueText);
        container.addView(labelText);

        // Set constraints inside container
        ConstraintSet subSet = new ConstraintSet();
        subSet.clone(container);
        subSet.connect(valueText.getId(), ConstraintSet.TOP, container.getId(), ConstraintSet.TOP);
        subSet.connect(valueText.getId(), ConstraintSet.START, container.getId(), ConstraintSet.START);
        subSet.connect(valueText.getId(), ConstraintSet.END, container.getId(), ConstraintSet.END);

        subSet.connect(labelText.getId(), ConstraintSet.TOP, valueText.getId(), ConstraintSet.BOTTOM, 4);
        subSet.connect(labelText.getId(), ConstraintSet.START, container.getId(), ConstraintSet.START);
        subSet.connect(labelText.getId(), ConstraintSet.END, container.getId(), ConstraintSet.END);
        subSet.applyTo(container);

        // Add container to main layout
        mainLayout.addView(container);

        // Set constraints of container inside mainLayout
        ConstraintSet mainSet = new ConstraintSet();
        mainSet.clone(mainLayout);
        mainSet.connect(containerId, ConstraintSet.TOP, mainLayout.getId(), ConstraintSet.TOP, 40);
        mainSet.connect(containerId, ConstraintSet.START, mainLayout.getId(), ConstraintSet.START, 2);
        mainSet.applyTo(mainLayout);
    }

    private HeaderLabel createLabeledTextView(String value, String label, int valueViewId, int labelViewId) {
        TextView valueView = new TextView(this);
        valueView.setId(valueViewId);
        valueView.setText(value);
        valueView.setTextSize(18);
        valueView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        TextView labelView = new TextView(this);
        labelView.setId(labelViewId);
        labelView.setText(label);
        labelView.setTextSize(12);
        labelView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        mainLayout.addView(valueView);
        mainLayout.addView(labelView);

        applyTextViewConstraints(valueView, labelView);



        return new HeaderLabel(valueView, labelView);
    }
}
