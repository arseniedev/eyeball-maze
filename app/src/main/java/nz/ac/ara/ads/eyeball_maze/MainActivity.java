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

        // Support different screen sizes
        // https://developer.android.com/guide/topics/large-screens/support-different-screen-sizes#java
        // https://developer.android.com/reference/android/view/WindowMetrics
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


    private void applyTextViewConstraints(TextView textView) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(mainLayout);
        constraintSet.connect(textView.getId(), ConstraintSet.TOP, mainLayout.getId(), ConstraintSet.TOP, 86);
        constraintSet.connect(textView.getId(), ConstraintSet.START, mainLayout.getId(), ConstraintSet.START, 16);
        constraintSet.constrainHeight(textView.getId(), ConstraintSet.WRAP_CONTENT);
        constraintSet.constrainWidth(textView.getId(), ConstraintSet.WRAP_CONTENT);
        constraintSet.applyTo(mainLayout);
    }
    private ImageView createConfiguredImageView(int anchorViewId) {
        // Create and configure the ImageView
        ImageView imageView = new ImageView(this);
        // Generate a unique ID for the ImageView
        imageView.setId(R.id.icon);
        imageView.setImageResource(R.drawable.snapchat);

        int imageSize = calculateImageViewSize();
        imageView.setLayoutParams(new ConstraintLayout.LayoutParams(imageSize,imageSize));

        return imageView;
    }
    private void applyImageViewConstraints(ImageView imageView, int anchorViewId) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(mainLayout);
        constraintSet.connect(imageView.getId(), ConstraintSet.TOP, anchorViewId, ConstraintSet.TOP, 26);
        constraintSet.connect(imageView.getId(), ConstraintSet.START, mainLayout.getId(), ConstraintSet.START, 26);
        constraintSet.applyTo(mainLayout);
    }

    private int calculateImageViewSize() {
        WindowMetrics metrics = getWindowManager().getCurrentWindowMetrics();
        Insets insets = metrics.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.systemBars());
        Rect bounds = metrics.getBounds();

        int usableWidth = bounds.width() - insets.left - insets.right;
        return usableWidth / 7;
    }
    private TextView createConfiguredTextView() {
        TextView textView = new TextView(this);
        textView.setId(R.id.text_msg);
        textView.setText(R.string.msg);
        textView.setTextSize(12);
        return textView;
    }
}