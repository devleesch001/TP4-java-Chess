package test;

import test.boardException.IllegalPosition;

public class Coord {
    private int x;
    private int y;

    /**
     * @param x int
     * @param y int
     * @throws IllegalPosition Error throws if Coordinate out of board
     */
    public Coord(int x, int y) throws IllegalPosition {
        super();

        this.x = x;
        this.y = y;

    }

    /**
     * @return String Coord
     */
    public String toString() {
        return "Coord{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }
}