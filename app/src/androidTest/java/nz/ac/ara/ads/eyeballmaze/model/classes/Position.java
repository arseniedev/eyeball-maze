package nz.ac.ara.ads.eyeballmaze.model.classes;

public class Position {
    public int row;
    public int column;
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