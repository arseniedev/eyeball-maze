package nz.ac.ara.ads.eyeball_maze.view;

import android.content.Context;
import android.graphics.Insets;
import android.graphics.Rect;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowMetrics;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import nz.ac.ara.ads.eyeball_maze.R;
import nz.ac.ara.ads.eyeball_maze.model.classes.HeaderLabel;

public class GameView {

    private ConstraintLayout mainLayout;
    private Context context;

    public GameView(Context context, ConstraintLayout mainLayout) {
        this.context = context;
        this.mainLayout = mainLayout;
    }

    public void setupWindowInsetsPadding() {
        ViewCompat.setOnApplyWindowInsetsListener(mainLayout, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars()).toPlatformInsets();
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public int calculateImageViewSize() {
        WindowMetrics metrics = ((android.app.Activity) context).getWindowManager().getCurrentWindowMetrics();
        Insets insets = metrics.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.systemBars());
        Rect bounds = metrics.getBounds();
        int usableWidth = bounds.width() - insets.left - insets.right;
        return usableWidth / 7;  // Assuming 7 columns
    }

    public void generateImageGrid(int rows, int cols, int cellSize, int spacing, int topAnchorId) {
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
        ImageView imageView = new ImageView(context);
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

                // Connect top
                if (row == 0) {
                    set.connect(cellId, ConstraintSet.TOP, topAnchorId, ConstraintSet.TOP, 180);
                } else {
                    set.connect(cellId, ConstraintSet.TOP, ids[row - 1][col], ConstraintSet.BOTTOM, spacing);
                }

                // Connect start
                if (col == 0) {
                    set.connect(cellId, ConstraintSet.START, mainLayout.getId(), ConstraintSet.START, 25);
                } else {
                    set.connect(cellId, ConstraintSet.START, ids[row][col - 1], ConstraintSet.END, spacing);
                }
            }
        }
        set.applyTo(mainLayout);
    }

    public HeaderLabel createHeaderView(String value, String label) {
        ConstraintLayout container = new ConstraintLayout(context);
        int containerId = View.generateViewId();
        container.setId(containerId);

        TextView valueText = new TextView(context);
        valueText.setId(View.generateViewId());
        valueText.setText(value);
        valueText.setTextSize(18);
        valueText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        TextView labelText = new TextView(context);
        labelText.setId(View.generateViewId());
        labelText.setText(label);
        labelText.setTextSize(12);
        labelText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        container.addView(valueText);
        container.addView(labelText);

        ConstraintSet subSet = new ConstraintSet();
        subSet.clone(container);
        subSet.connect(valueText.getId(), ConstraintSet.TOP, container.getId(), ConstraintSet.TOP);
        subSet.connect(valueText.getId(), ConstraintSet.START, container.getId(), ConstraintSet.START, 50);
        subSet.connect(valueText.getId(), ConstraintSet.END, container.getId(), ConstraintSet.END, 50);

        subSet.connect(labelText.getId(), ConstraintSet.TOP, valueText.getId(), ConstraintSet.BOTTOM, 4);
        subSet.connect(labelText.getId(), ConstraintSet.START, container.getId(), ConstraintSet.START, 50);
        subSet.connect(labelText.getId(), ConstraintSet.END, container.getId(), ConstraintSet.END, 50);
        subSet.applyTo(container);

        mainLayout.addView(container);

        ConstraintSet mainSet = new ConstraintSet();
        mainSet.clone(mainLayout);
        mainSet.connect(containerId, ConstraintSet.TOP, mainLayout.getId(), ConstraintSet.TOP, 40);
        mainSet.connect(containerId, ConstraintSet.START, mainLayout.getId(), ConstraintSet.START, 2);
        mainSet.applyTo(mainLayout);

        return new HeaderLabel(valueText, labelText);
    }

    public int getMainLayoutId() {
        return mainLayout.getId();
    }
}
