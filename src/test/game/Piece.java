package test.game;

import test.Color;
import test.Coord;
import test.boardException.IllegalMove;
import test.boardException.IllegalPosition;

import java.util.ArrayList;

public abstract class Piece implements Movable {
    private ChessBoard board;
    protected Coord place;
    private Color color;
    private boolean isUsed;

    /**
     * @param board ChessBoard
     * @param place Coordinate
     * @param color Color
     */
    public Piece(ChessBoard board, Coord place, Color color) throws IllegalPosition {
        this.board = board;
        this.place = place;
        this.color = color;

        this.isUsed = false;

        board.setOccupation(place, this);
    }

    /**
     * @param newPlace new Position of Piece
     * @throws IllegalPosition Error throws if Place is Occupied
     * @throws IllegalMove Error throws if Move is not allowed
     */
    public void move(Coord newPlace) throws IllegalPosition, IllegalMove {

        if (getBoard().isOccupied(newPlace, this.color)) {
            throw new IllegalPosition("Place Occupied");
        }

        if (!isValideMove(newPlace)) {
            throw new IllegalMove("Move impossible");
        }

        getBoard().setOccupation(this.place, null);
        this.place = newPlace;
        this.isUsed = true;
        getBoard().setOccupation(newPlace, this);
    }

    public abstract boolean isValideMove(Coord newPos) throws IllegalPosition, IllegalMove;

    /* getter & setter */

    /**
     * @return board
     */
    public ChessBoard getBoard() {
        return board;
    }

    /**
     * @return Coordinate
     */
    public Coord getPlace() {
        return place;
    }

    /**
     * @return Color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @return Boolean
     * is Piece as move
     */
    public Boolean getIsUsed() { return isUsed; }

    /**
     * @return
     */
    public abstract ArrayList<Coord> legalMove() throws IllegalPosition;

    /**
     * @return String of all atribut
     */
    public String toString() {
        return "Piece{" +
                "board=" + board +
                ", place=" + place +
                ", color=" + color +
                '}';
    }
}
