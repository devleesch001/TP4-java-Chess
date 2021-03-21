package test.chessPiece;

import test.Color;
import test.Coord;
import test.boardException.IllegalMove;
import test.boardException.IllegalPosition;
import test.game.ChessBoard;
import test.game.Piece;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

    /**
     * @param board ChessBoard
     * @param place Coordinate
     * @param color Color
     */
    public Knight(ChessBoard board, Coord place, Color color) throws IllegalPosition {
        super(board, place, color);
    }

    /**
     * @param newPlace
     * @return
     */
    public boolean isValideMove(Coord newPlace) throws IllegalPosition {
        Coord diff = new Coord(Math.abs(place.getX() - newPlace.getX()), Math.abs(place.getY() - newPlace.getY()));

        if ((diff.getX() == 2 && diff.getY() == 1) || (diff.getX() == 1 && diff.getY() == 2)) {
            return true;
        }

        return false;
    }

    /**
     * @return List of possible move
     */
    @Override
    public ArrayList<Coord> legalMove() throws IllegalPosition {

        ArrayList<Coord> moveList = new ArrayList<Coord>();

        int x = place.getX();
        int y = place.getY();

        Coord toHelp = new Coord(x, y);

        if (x + 2 < 8 && y + 1 < 8) {
            toHelp = new Coord(x + 2, y + 1);
            if (!getBoard().isOccupied(toHelp) || getBoard().isOccupied(toHelp, getColor() != Color.WHITE ? Color.WHITE : Color.BLACK)) {
                moveList.add(toHelp);
            }
        }

        if (x + 2 < 8 && y - 1 >= 0) {
            toHelp = new Coord(x + 2, y - 1);
            if (!getBoard().isOccupied(toHelp) || getBoard().isOccupied(toHelp, getColor() != Color.WHITE ? Color.WHITE : Color.BLACK)) {
                moveList.add(toHelp);
            }
        }

        if (x + 1 < 8 && y + 2 < 8) {
            toHelp = new Coord(x + 1, y + 2);
            if (!getBoard().isOccupied(toHelp) || getBoard().isOccupied(toHelp, getColor() != Color.WHITE ? Color.WHITE : Color.BLACK)) {
                moveList.add(toHelp);
            }
        }

        if (x + 1 < 8 && y - 2 >= 0) {
            toHelp = new Coord(x + 1, y - 2);
            if (!getBoard().isOccupied(toHelp) || getBoard().isOccupied(toHelp, getColor() != Color.WHITE ? Color.WHITE : Color.BLACK)) {
                moveList.add(toHelp);
            }
        }

        if (x - 2 >= 0 && y + 1 < 8) {
            toHelp = new Coord(x - 2, y + 1);
            if (!getBoard().isOccupied(toHelp) || getBoard().isOccupied(toHelp, getColor() != Color.WHITE ? Color.WHITE : Color.BLACK)) {
                moveList.add(toHelp);
            }
        }

        if (x - 2 >= 0 && y - 1 >= 0) {
            toHelp = new Coord(x - 2, y - 1);
            if (!getBoard().isOccupied(toHelp) || getBoard().isOccupied(toHelp, getColor() != Color.WHITE ? Color.WHITE : Color.BLACK)) {
                moveList.add(toHelp);
            }
        }

        if (x - 1 >= 0 && y + 2 < 8) {
            toHelp = new Coord(x - 1, y + 2);
            if (!getBoard().isOccupied(toHelp) || getBoard().isOccupied(toHelp, getColor() != Color.WHITE ? Color.WHITE : Color.BLACK)) {
                moveList.add(toHelp);
            }
        }

        if (x - 1 >= 0 && y - 2 >= 0) {
            toHelp = new Coord(x - 1, y - 2);
            if (!getBoard().isOccupied(toHelp) || getBoard().isOccupied(toHelp, getColor() != Color.WHITE ? Color.WHITE : Color.BLACK)) {
                moveList.add(toHelp);
            }
        }

        return moveList;
    }

    /**
     * @return Return Compact formated name
     */
    public String toString() {
        if (this.getColor() == Color.WHITE) {
            return "WKni";
        } else {
            return "BKni";
        }
    }
}
