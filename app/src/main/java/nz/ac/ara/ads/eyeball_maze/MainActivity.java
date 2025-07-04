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

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout mainLayout;
    private int[][] gridViewIds;  // To track grid cell IDs

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupEdgeToEdge();
        setContentView(R.layout.activity_main);
        applyWindowInsetsPadding();

        mainLayout = findViewById(R.id.main);

        // Add TextView
        TextView textView = createConfiguredTextView();
        mainLayout.addView(textView);
        applyTextViewConstraints(textView);

        // Add 5x7 grid below the TextView
        int imageSize = calculateImageViewSize();
        generateImageGrid(7, 6, imageSize, 12, textView.getId());
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

    private void applyTextViewConstraints(TextView textView) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(mainLayout);
        constraintSet.connect(textView.getId(), ConstraintSet.TOP, mainLayout.getId(), ConstraintSet.TOP, 86);
        constraintSet.connect(textView.getId(), ConstraintSet.START, mainLayout.getId(), ConstraintSet.START, 16);
        constraintSet.constrainHeight(textView.getId(), ConstraintSet.WRAP_CONTENT);
        constraintSet.constrainWidth(textView.getId(), ConstraintSet.WRAP_CONTENT);
        constraintSet.applyTo(mainLayout);
    }

    // Legacy ImageView (Optional)
    private ImageView createConfiguredImageView() {
        ImageView imageView = new ImageView(this);
        imageView.setId(View.generateViewId());
        imageView.setImageResource(R.drawable.snapchat);
        int imageSize = calculateImageViewSize();
        imageView.setLayoutParams(new ConstraintLayout.LayoutParams(imageSize, imageSize));
        return imageView;
    }

    private void applyImageViewConstraints(ImageView imageView, int anchorViewId) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(mainLayout);
        constraintSet.connect(imageView.getId(), ConstraintSet.TOP, anchorViewId, ConstraintSet.BOTTOM, 26);
        constraintSet.connect(imageView.getId(), ConstraintSet.START, mainLayout.getId(), ConstraintSet.START, 26);
        constraintSet.applyTo(mainLayout);
    }

    // Modular Grid
    private void generateImageGrid(int rows, int cols, int cellSize, int spacing, int topAnchorId) {
        gridViewIds = new int[rows][cols];
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
        imageView.setImageResource(R.drawable.snapchat);
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
                    set.connect(cellId, ConstraintSet.TOP, topAnchorId, ConstraintSet.BOTTOM, spacing);
                } else {
                    set.connect(cellId, ConstraintSet.TOP, ids[row - 1][col], ConstraintSet.BOTTOM, spacing);
                }

                // Start
                if (col == 0) {
                    set.connect(cellId, ConstraintSet.START, mainLayout.getId(), ConstraintSet.START, spacing);
                } else {
                    set.connect(cellId, ConstraintSet.START, ids[row][col - 1], ConstraintSet.END, spacing);
                }
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
}
