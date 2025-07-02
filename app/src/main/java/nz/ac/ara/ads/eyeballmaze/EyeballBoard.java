//package nz.ac.ara.ads.eyeballmaze;
//
//import android.content.Context;
//import android.content.res.TypedArray;
//import android.graphics.Canvas;
//import android.graphics.Paint;
//import android.util.AttributeSet;
//import android.view.View;
//
//import androidx.annotation.Nullable;
//
//public class EyeballBoard extends View {
//    private final int boardColor;
//    private final int liveCellColor;
//    private final int pastCellColor;
//    private final int targetCellColor;
//
//    private final Paint paint = new Paint();
//    private int cellSize = getWidth() / 3;
//
//    public EyeballBoard(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
//
//        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.EyeballBoard, 0,0);
//
//        try {
//            boardColor  = a.getInteger(R.styleable.EyeballBoard_boardColor, 0);
//            liveCellColor  = a.getInteger(R.styleable.EyeballBoard_liveCellColor, 0);
//            pastCellColor  = a.getInteger(R.styleable.EyeballBoard_pastCellColor, 0);
//            targetCellColor  = a.getInteger(R.styleable.EyeballBoard_targetCellColor, 0);
//        } finally {
//
//        }
//    }
//
//    @Override
//    protected void onMeasure(int width, int height) {
//        super.measure(width, height);
//
//        int dimensions = Math.min(getMeasuredWidth(), getMeasuredHeight());
//
//        cellSize = dimensions / 3;
//
//        setMeasuredDimension(dimensions, dimensions);
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setAntiAlias(true);
//
//        drawGameBoard(canvas);
//    }
//
//    private void drawGameBoard(Canvas canvas) {
//        paint.setColor(boardColor);
//        paint.setStrokeWidth(16);
//        for (int c = 1; c < 3; c++) {
//            canvas.drawLine(cellSize*c, 0,cellSize*c, canvas.getWidth(), paint);
//
//        }
//        for (int r = 1; r < 3; r++) {
//            canvas.drawLine(0, cellSize*r,canvas.getWidth(), cellSize*r, paint);
//        }
//    }
//}
