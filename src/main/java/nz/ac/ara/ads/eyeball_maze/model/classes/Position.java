package nz.ac.ara.ads.eyeball_maze.model.classes;

public class Position {
    protected int row;
    protected int column;
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }
}
