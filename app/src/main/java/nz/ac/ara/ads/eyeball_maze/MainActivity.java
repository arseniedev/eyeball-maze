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
        ImageView imageView = createConfiguredImageView(textView.getId());
        mainLayout.addView(imageView);
        applyImageViewConstraints(imageView, textView.getId());
        // https://developer.android.com/reference/android/view/View.html#generateViewId()

//        imageView.setId(View.generateViewId());
//        imageView.setImageResource(R.drawable.snapchat);


//        mainLayout.addView(textView);

//        ConstraintSet constraintSet = new ConstraintSet();
//        constraintSet.clone(mainLayout);
//        constraintSet.connect(textView.getId(), ConstraintSet.TOP, mainLayout.getId(), ConstraintSet.TOP, 6);
//        constraintSet.connect(textView.getId(), ConstraintSet.END, mainLayout.getId(), ConstraintSet.END, 6);
//        constraintSet.constrainHeight(textView.getId(), ConstraintSet.WRAP_CONTENT);
//        constraintSet.constrainWidth(textView.getId(), ConstraintSet.WRAP_CONTENT);
//        constraintSet.applyTo(mainLayout);


        // Support different screen sizes
        // https://developer.android.com/guide/topics/large-screens/support-different-screen-sizes#java
        // https://developer.android.com/reference/android/view/WindowMetrics
        // Calculate screen dimensions to adjust ImageView size
        /*
         This retrieves information about the current window metrics, which includes information
         about the size, density, and font scale of the current window.
         */
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

        // This calculates the total width and height of the insets.
//        int insetsWidth = insets.right + insets.left;
//        int insetsHeight = insets.top + insets.bottom;

        /*
         This gets the bounds of the entire window,
         which represents the full area a window may occupy, including insets.
         */
//        final Rect bounds = metrics.getBounds();
        /*
         This calculates the size of the window excluding the insets from the total window size.
        * */
//        final Size legacySize = new Size(bounds.width() - insetsWidth,
//                bounds.height() - insetsHeight);
        /*
         This retrieves the width of the window excluding the insets,
         i.e., the width of the usable screen space.
         */
//        int width = legacySize.getWidth();

        /*
         This calculates the width of an ImageView that should take up
         half of the available window width, excluding the insets.
         */
//        int imageViewWidth = width / 7;
//        imageView.setLayoutParams(new ConstraintLayout.LayoutParams(imageViewWidth, imageViewWidth));
//        mainLayout.addView(imageView);

//        constraintSet.clone(mainLayout);
//        constraintSet.connect(imageView.getId(), ConstraintSet.TOP, textView.getId(), ConstraintSet.BOTTOM, 16);
//        constraintSet.connect(imageView.getId(), ConstraintSet.END, mainLayout.getId(), ConstraintSet.END, 20);
//        constraintSet.applyTo(mainLayout);
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
        constraintSet.connect(textView.getId(), constraintSet.TOP, mainLayout.getId(), ConstraintSet.TOP, 6);
        constraintSet.connect(textView.getId(), ConstraintSet.END, mainLayout.getId(), ConstraintSet.END, 6);
        constraintSet.constrainHeight(textView.getId(), ConstraintSet.WRAP_CONTENT);
        constraintSet.constrainWidth(textView.getId(), ConstraintSet.WRAP_CONTENT);
        constraintSet.applyTo(mainLayout);
    }
    private ImageView createConfiguredImageView(int anchorViewId) {
        // Create and configure the ImageView
        ImageView imageView = new ImageView(this);
        // Generate a unique ID for the ImageView
        imageView.setId(R.id.text_msg);
        imageView.setImageResource(R.drawable.snapchat);

        int imageSize = calculateImageViewSize();
        imageView.setLayoutParams(new ConstraintLayout.LayoutParams(imageSize,imageSize));

        return imageView;
    }

    private void applyImageViewConstraints(ImageView imageView, int anchorViewId) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(mainLayout);
        constraintSet.connect(imageView.getId(), ConstraintSet.TOP, anchorViewId, ConstraintSet.BOTTOM, 26);
        constraintSet.connect(imageView.getId(), ConstraintSet.END, mainLayout.getId(), ConstraintSet.END, 26);

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
        return usableWidth / 7;
    }
}