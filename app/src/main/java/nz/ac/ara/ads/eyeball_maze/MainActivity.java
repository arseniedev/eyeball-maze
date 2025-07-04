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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars()).toPlatformInsets();
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get the main layout
        ConstraintLayout mainLayout = findViewById(R.id.main);

        // Create and configure the TextView
        TextView textView = new TextView(this);

        /*
        https://developer.android.com/guide/topics/resources/providing-resources#Accessing
        R class contains resource IDs for all the resources in your res/
        directory. For each type of resource, there is an R subclass, such as
        R.drawable for all drawable resources. And for each resource of that
        type, there is a static integer, for example, R.drawable.icon. This
        integer is the resource ID that you can use to retrieve your resource.

        https://developer.android.com/guide/topics/resources/more-resources#Id
        A unique resource ID defined in XML. Using the name you provide in the
        <item> element, the Android developer tools create a unique integer in
        your project's R.java class, which you can use as an identifier for an
        application resources, such as a View in your UI layout, or a unique
        integer for use in your application code, such as an ID for a dialog
        or a result code.

        Alternative: using int textViewId = View.generateViewId();
        */
        textView.setId(R.id.text_msg);
        textView.setText(R.string.msg);
        textView.setTextSize(22);
        mainLayout.addView(textView);

        // https://stackoverflow.com/questions/40275152/how-to-programmatically-add-views-and-constraints-to-a-constraintlayout
        // https://developer.android.com/reference/android/support/constraint/ConstraintSet
        // Configure constraints for the TextView
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(mainLayout);
        constraintSet.connect(textView.getId(), ConstraintSet.TOP, mainLayout.getId(), ConstraintSet.TOP, 16);
        constraintSet.connect(textView.getId(), ConstraintSet.END, mainLayout.getId(), ConstraintSet.END, 16);
        constraintSet.constrainHeight(textView.getId(), ConstraintSet.WRAP_CONTENT);
        constraintSet.constrainWidth(textView.getId(), ConstraintSet.WRAP_CONTENT);
        constraintSet.applyTo(mainLayout);

        // Create and configure the ImageView
        ImageView imageView = new ImageView(this);
        // https://developer.android.com/reference/android/view/View.html#generateViewId()
        // Generate a unique ID for the ImageView
        imageView.setId(View.generateViewId());
        imageView.setImageResource(R.drawable.snapchat);

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
        int insetsWidth = insets.right + insets.left;
        int insetsHeight = insets.top + insets.bottom;

        /*
         This gets the bounds of the entire window,
         which represents the full area a window may occupy, including insets.
         */
        final Rect bounds = metrics.getBounds();
        /*
         This calculates the size of the window excluding the insets from the total window size.
        * */
        final Size legacySize = new Size(bounds.width() - insetsWidth,
                bounds.height() - insetsHeight);
        /*
         This retrieves the width of the window excluding the insets,
         i.e., the width of the usable screen space.
         */
        int width = legacySize.getWidth();

        /*
         This calculates the width of an ImageView that should take up
         half of the available window width, excluding the insets.
         */
        int imageViewWidth = width / 2;
        imageView.setLayoutParams(new ConstraintLayout.LayoutParams(imageViewWidth, imageViewWidth));
        mainLayout.addView(imageView);

        constraintSet.clone(mainLayout);
        constraintSet.connect(imageView.getId(), ConstraintSet.TOP, textView.getId(), ConstraintSet.BOTTOM, 16);
        constraintSet.connect(imageView.getId(), ConstraintSet.END, mainLayout.getId(), ConstraintSet.END, 0);
        constraintSet.applyTo(mainLayout);
    }
}