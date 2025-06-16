package nz.ac.ara.lxu.androidmanualviewdemo.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Maze {
    private final ArrayList<Boolean> mazeMap;
    private int playerLocation;

    public Maze() {
        mazeMap = new ArrayList<>(Arrays.asList(true, true, true));
        playerLocation = 2;
    }

    public int getPlayerLocation() {
        return playerLocation;
    }

    public void setPlayerLocation(int playerLocation) {
        this.playerLocation = playerLocation;
    }

    public ArrayList<Boolean> getMazeMap() {
        return mazeMap;
    }
}
