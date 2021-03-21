package test.chessPiece;

import test.Color;
import test.Coord;
import test.boardException.IllegalMove;
import test.boardException.IllegalPosition;
import test.game.ChessBoard;
import test.game.Piece;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {

    /**
     * @param board ChessBoard
     * @param place Coordinate
     * @param color Color
     */
    public Bishop(ChessBoard board, Coord place, Color color) throws IllegalPosition {
        super(board, place, color);
    }

    /**
     * @param newPlace
     * @return
     * @throws IllegalPosition
     */
    public boolean isValideMove(Coord newPlace) throws IllegalPosition {
        Coord diff = new Coord(newPlace.getX() - place.getX(), newPlace.getY() - place.getY());

        if (!isLegalPos(newPlace)) {
            return false;
        }

        int dX = Integer.signum(diff.getX());
        int dY = Integer.signum(diff.getY());

//        System.out.println(dX + " " + dY);

        int x = place.getX();
        int y = place.getY();

//        System.out.println(x + " " + y);

        try {
            while (x != newPlace.getX() - dX || y != newPlace.getY() - dY) {
                x += dX;
                y += dY;

//                System.out.println(x + " " + y);

                if (getBoard().isOccupied(new Coord(x, y))) {
                    return false;
                }
            }
        } catch (IllegalPosition e) {
            return false;
        }

        return true;
    }

    /**
     * @return List of possible move
     */
    @Override
    public ArrayList<Coord> legalMove() throws IllegalPosition {

        ArrayList<Coord> moveList = new ArrayList<Coord>();

        for (int i = 0; i < 4; i++) {
            int x = place.getX();
            int y = place.getY();

            int dX;
            int dY;

            if (i == 0) {
                dX = 1;
                dY = 1;
            } else if (i == 1) {
                dX = -1;
                dY = -1;
            } else if (i == 2) {
                dX = 1;
                dY = -1;
            } else {
                dX = -1;
                dY = 1;
            }

            x += dX;
            y += dY;

            Coord toHelp = new Coord(x, y);
            while ((x >= 0 && x < 8 && y >= 0 && y < 8) && !getBoard().isOccupied(new Coord(x, y))) {
                moveList.add(toHelp);

                x += dX;
                y += dY;

                toHelp = new Coord(x, y);
            }

            if ((x >= 0 && x < 8 && y >= 0 && y < 8) && getBoard().isOccupied(toHelp, getColor() != Color.WHITE ? Color.WHITE : Color.BLACK)) {
                moveList.add(toHelp);
            }

        }

        return moveList;
    }

    /**
     * @param newPlace
     * @return legal pos
     * @throws IllegalPosition
     */
    private boolean isLegalPos(Coord newPlace) throws IllegalPosition {
        Coord diff = new Coord(newPlace.getX() - place.getX(), newPlace.getY() - place.getY());

        if (Math.abs(diff.getX()) != Math.abs(diff.getY()) || Math.abs(diff.getX()) == 0) {
            return false;
        }

        return true;
    }

    /**
     * @return Return Compact formated name
     */
    public String toString() {
        if (this.getColor() == Color.WHITE) {
            return "WBis";
        } else {
            return "BBis";
        }
    }
}
