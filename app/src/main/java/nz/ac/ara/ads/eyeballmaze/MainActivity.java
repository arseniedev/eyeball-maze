package nz.ac.ara.ads.eyeballmaze;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import nz.ac.ara.ads.eyeballmaze.model.classes.Game;
import nz.ac.ara.ads.eyeballmaze.model.classes.Square;
import java.util.HashMap;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    static final Game GAME = new Game();
    private int moveCount = 0;
//    private TextView cu
    final ImageView[] imageViews = new ImageView[GAME.getLevelCount()];



    ImageView[][] cellGridImages = new ImageView[7][8];
//    HashMap<ImageView, Square> newSquareCellMap = new HashMap<>();

//    private int pastCellColmnRow = -1;

//    private HashMap<Integer, Bitmap> selectedCell = new HashMap<>();

//    private final int[] cellGridIds = {
//            R.id.cellGrid0,  R.id.cellGrid1,  R.id.cellGrid2,  R.id.cellGrid3,
//            R.id.cellGrid4,  R.id.cellGrid5,  R.id.cellGrid6,  R.id.cellGrid7,
//            R.id.cellGrid7,  R.id.cellGrid8,  R.id.cellGrid9, R.id.cellGrid10,
//            R.id.cellGrid11, R.id.cellGrid12, R.id.cellGrid13, R.id.cellGrid14,
//            R.id.cellGrid15, R.id.cellGrid16, R.id.cellGrid17, R.id.cellGrid18,
//            R.id.cellGrid19, R.id.cellGrid20, R.id.cellGrid21, R.id.cellGrid22
//    };

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
}