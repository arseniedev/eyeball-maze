// https://stackoverflow.com/questions/29047902/how-to-add-an-image-to-the-drawable-folder-in-android-studio
// https://android--code.blogspot.co.nz/2015/09/android-how-to-get-screen-width-and.html
// https://stackoverflow.com/questions/4743116/get-screen-width-and-height
// https://stackoverflow.com/questions/3144940/set-imageview-width-and-height-programmatically

package nz.ac.ara.xul.androidmanualviewdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import nz.ac.ara.lxu.androidmanualviewdemo.model.Maze;

public class MainActivity extends AppCompatActivity {
    static final Maze MAZE = new Maze();
    final ImageView[] imageViews = new ImageView[MAZE.getMazeMap().size()];

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

        imageViews[0] = findViewById(R.id.imageView1);
        imageViews[1] = findViewById(R.id.imageView2);
        imageViews[2] = findViewById(R.id.imageView3);

        imageViews[MAZE.getPlayerLocation()].setImageResource(R.drawable.image_theseus);
    }

    public void moveLeft(View view) {
        MAZE.setPlayerLocation(Math.abs((MAZE.getPlayerLocation() - 1 + 3) % 3));

        render();
    }

    private void render() {
        for (int i = 0; i < imageViews.length; ++i) {
            if (MAZE.getMazeMap().get(i)) {
                imageViews[i].setImageResource(R.drawable.image_wall);
            }
        }
        imageViews[MAZE.getPlayerLocation()].setImageResource(R.drawable.image_theseus);
    }
}