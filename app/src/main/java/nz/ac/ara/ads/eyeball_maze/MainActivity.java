package nz.ac.ara.ads.eyeball_maze;


import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Size;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowMetrics;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupEdgeToEdge();
        setContentView(R.layout.activity_main);
        applyWindowInsetsPadding();

        // Get the main layout
        mainLayout = findViewById(R.id.main);

        // Create and configure the TextView
        TextView textView = createConfiguredTextView();
        mainLayout.addView(textView);
        applyTextViewConstraints(textView);

        // Create and configure the ImageView
        ImageView imageView = createConfiguredImageView();
        mainLayout.addView(imageView);
        applyImageViewConstraints(imageView, textView.getId());
        // https://developer.android.com/reference/android/view/View.html#generateViewId()

        final WindowMetrics metrics;
        metrics = getWindowManager().getCurrentWindowMetrics();

        /*
         This gets the the insets for the window. Insets are areas of a window that a window
         manager might use for system UI such as the status bar or navigation bar.
         */
        final WindowInsets windowInsets;
        windowInsets = metrics.getWindowInsets();

        /*
         This gets the size of the insets for the navigation bars and display cutout,
         regardless of whether they are currently visible or not.
         */
        Insets insets = windowInsets.getInsetsIgnoringVisibility(WindowInsets.Type.systemBars());

        generateGridBoard(5, 6, 100); // 5 columns, 6 rows, 100px cell size
    }

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

    @NonNull
    private TextView createConfiguredTextView() {
        TextView textView = new TextView(this);
        textView.setId(View.generateViewId());
        textView.setText(R.string.msg);
        int textSize = 15;
        textView.setTextSize(textSize);
        return textView;
    }
    private void applyTextViewConstraints(@NonNull TextView textView) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(mainLayout);
        int textMargin = 15;
        constraintSet.connect(textView.getId(), ConstraintSet.TOP, mainLayout.getId(), ConstraintSet.TOP, 30);
        constraintSet.connect(textView.getId(), ConstraintSet.TOP, mainLayout.getId(), ConstraintSet.BOTTOM, textMargin);
        constraintSet.connect(textView.getId(), ConstraintSet.START, mainLayout.getId(), ConstraintSet.END, textMargin);
        constraintSet.constrainHeight(textView.getId(), ConstraintSet.WRAP_CONTENT);
        constraintSet.constrainWidth(textView.getId(), ConstraintSet.WRAP_CONTENT);
        constraintSet.applyTo(mainLayout);
    }
    @NonNull
    private ImageView createConfiguredImageView() {
        // Create and configure the ImageView
        ImageView imageView = new ImageView(this);
        // Generate a unique ID for the ImageView
        imageView.setId(View.generateViewId());
        imageView.setImageResource(R.drawable.snapchat);

        int imageSize = calculateImageViewSize();
        imageView.setLayoutParams(new ConstraintLayout.LayoutParams(imageSize,imageSize));

        return imageView;
    }
    private void applyImageViewConstraints(@NonNull ImageView imageView, int anchorViewId) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(mainLayout);
        int imageMargin = 6;
        constraintSet.connect(imageView.getId(), ConstraintSet.TOP, anchorViewId, ConstraintSet.BOTTOM, imageMargin);
        constraintSet.connect(imageView.getId(), ConstraintSet.END, mainLayout.getId(), ConstraintSet.END, imageMargin);
        constraintSet.setHorizontalBias(imageView.getId(), 0.5f);
//        constraintSet.connect(imageView.getId(), ConstraintSet.END, mainLayout.getId(), ConstraintSet.END, 26);
//        constraintSet.constrainHeight(imageView.getId(), ConstraintSet.WRAP_CONTENT);
//        constraintSet.constrainWidth(imageView.getId(), ConstraintSet.WRAP_CONTENT);
        constraintSet.applyTo(mainLayout);
    }

    private int calculateImageViewSize() {
        WindowMetrics metrics = getWindowManager().getCurrentWindowMetrics();
        Insets insets = metrics.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.systemBars());
        Rect bounds = metrics.getBounds();

        int usableWidth = bounds.width() - insets.left - insets.right;
        int gridCount = 5;
        return usableWidth / gridCount;
    }

    private void generateGridBoard(int width, int height, int cellSize) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(mainLayout);

        int[][] viewIds = new int[height][width];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                ImageView cell = new ImageView(this);
                int cellId = View.generateViewId();
                cell.setId(cellId);
                cell.setImageResource(R.drawable.snapchat); // Or custom cell drawable
                cell.setScaleType(ImageView.ScaleType.CENTER_CROP);

                ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(cellSize, cellSize);
                cell.setLayoutParams(params);

                mainLayout.addView(cell);
                viewIds[row][col] = cellId;

                // Top constraint
                if (row == 0) {
                    constraintSet.connect(cellId, ConstraintSet.TOP, mainLayout.getId(), ConstraintSet.TOP, 16);
                } else {
                    constraintSet.connect(cellId, ConstraintSet.TOP, viewIds[row - 1][col], ConstraintSet.BOTTOM, 8);
                }

                // Start constraint
                if (col == 0) {
                    constraintSet.connect(cellId, ConstraintSet.START, mainLayout.getId(), ConstraintSet.START, 16);
                } else {
                    constraintSet.connect(cellId, ConstraintSet.START, viewIds[row][col - 1], ConstraintSet.END, 8);
                }
            }
        }

        constraintSet.applyTo(mainLayout);
    }

}