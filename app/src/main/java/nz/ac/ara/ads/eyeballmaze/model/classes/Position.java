package nz.ac.ara.ads.eyeballmaze.model.classes;

public record Position(int row, int col) {
    private static final int MAX_COLS = 20;
    private static final int MAX_ROWS = 20;
    private static final Position[][] POOL = createPool();
    private static Position[][] createPool() {
        Position[][] pool = new Position[MAX_ROWS][MAX_COLS];
        for (int r = 0; r < MAX_ROWS; r++) {
            for (int c = 0; c < MAX_COLS; c++) {
                pool[r][c] = new Position(r, c);
            }
        }
        return pool;
    }
    public static Position at(int row, int col) {
        if (row < 0 || row >= MAX_ROWS || col < 0 || col >= MAX_COLS) {
            throw new IndexOutOfBoundsException("Position out of bounds: " + row + "," + col);
        }
        return POOL[row][col];
    }

}