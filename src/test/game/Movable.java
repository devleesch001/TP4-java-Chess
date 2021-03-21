package test.game;

import test.Color;
import test.Coord;
import test.boardException.IllegalMove;
import test.boardException.IllegalPosition;

import java.util.ArrayList;

public interface Movable {
    void move(Coord newPos) throws IllegalPosition, IllegalMove;
    Color getColor();
    ArrayList<Coord> legalMove() throws IllegalPosition;
}
