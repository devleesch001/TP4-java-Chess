package test.chessPiece;

import sun.font.CoreMetrics;
import test.Color;
import test.Coord;
import test.boardException.IllegalPosition;
import test.game.ChessBoard;
import test.game.Piece;

import java.util.ArrayList;

public class King extends Piece {

    /**
     * @param board ChessBoard
     * @param place Coordinate
     * @param color Color
     */
    public King(ChessBoard board, Coord place, Color color) throws IllegalPosition {
        super(board, place, color);
    }

    /**
     * @param newPlace place
     * @return Boolean
     * @throws IllegalPosition if in illegale potion
     */
    public boolean isValideMove(Coord newPlace) throws IllegalPosition {
        Coord diff = new Coord(place.getX() - newPlace.getX(), place.getY() - newPlace.getY());

        if (Math.abs(diff.getX()) > 1 || Math.abs(diff.getY()) > 1 || (Math.abs(diff.getX())) == 0 && Math.abs(diff.getY()) == 0) {
            return false;
        }

        if (getBoard().isOccupied(newPlace)) {
            return false;
        }

        return true;
    }

    /**
     * @return List of possible move
     */
    @Override
    public ArrayList<Coord> legalMove() throws IllegalPosition {

        ArrayList<Coord> moveList = new ArrayList<>();

        int x = place.getX();
        int y = place.getY();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                Coord toHelp = new Coord(x - i - 1, y - j - 1);
                if (toHelp.getX() >= 0 && toHelp.getX() < 8 && toHelp.getY() >= 0 && toHelp.getY() < 8 && (toHelp.getY() != 0 && toHelp.getX() != 0)) {
                    if (!getBoard().isOccupied(toHelp) || getBoard().isOccupied(toHelp, getColor() != Color.WHITE ? Color.WHITE : Color.BLACK)) {
                        moveList.add(toHelp);
                    }
                }
            }
        }


        return moveList;
    }

    /**
     * @return Return Compact formated name
     */
    public String toString() {
        if (this.getColor() == Color.WHITE) {
            return "WKin";
        } else {
            return "BKin";
        }
    }
}
