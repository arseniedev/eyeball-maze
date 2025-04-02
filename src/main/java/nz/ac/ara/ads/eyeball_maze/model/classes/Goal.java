package nz.ac.ara.ads.eyeball_maze.model.classes;

public class Goal extends PlayableSquare {
    protected int row;
    protected int column;

    public Goal(int row, int column) {
        super();
        this.row = row;
        this.column = column;
    }
}
