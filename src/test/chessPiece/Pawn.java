package test.chessPiece;

import test.Color;
import test.Coord;
import test.boardException.IllegalMove;
import test.boardException.IllegalPosition;
import test.game.ChessBoard;
import test.game.Piece;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    /**
     * @param board ChessBoard
     * @param place Coordinate
     * @param color Color
     */
    public Pawn(ChessBoard board, Coord place, Color color) throws IllegalPosition {
        super(board, place, color);
    }

    /**
     * @param newPlace Coordinate
     * @return Boolean
     */
    public boolean isValideMove(Coord newPlace) throws IllegalPosition {
        Coord diff = new Coord(Math.abs(newPlace.getX() - place.getX()), newPlace.getY() - place.getY());

        if ((diff.getY() == 1 && this.getColor() == Color.WHITE) || (diff.getY() == -1 && this.getColor() == Color.BLACK)) {
            if (diff.getX() == 0) {
                return !getBoard().isOccupied(newPlace);
            } else if (diff.getX() == 1) {
                return getBoard().isOccupied(newPlace);
            }
        } else return (!this.getIsUsed() && diff.getX() == 0 && (diff.getY() == 2 && this.getColor() == Color.WHITE) || (diff.getY() == -2 && this.getColor() == Color.BLACK));

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

        if (getColor() == Color.WHITE) {
            if (y + 1 < 8) {
                Coord toHelp = new Coord(x, y + 1);
                System.out.println(getBoard().isOccupied(toHelp));
                if (!getBoard().isOccupied(toHelp)){
                    moveList.add(toHelp);
                }
            }

            if (x - 1 >= 0 && y + 1 < 8) {
                Coord toHelp = new Coord(x - 1, y + 1);
                if (getBoard().isOccupied(toHelp, Color.BLACK)){
                    moveList.add(toHelp);
                }
            }


            if (x + 1 < 8 && y + 1 < 8) {
                Coord toHelp = new Coord(x + 1, y + 1);
                if (getBoard().isOccupied(toHelp, Color.BLACK)){
                    moveList.add(toHelp);
                }
            }

            if (!getIsUsed() && y + 2 < 8) {
                Coord toHelp = new Coord(x, y + 2);
                if (!getBoard().isOccupied(toHelp)){
                    moveList.add(toHelp);
                }
            }
        } else if (getColor() == Color.BLACK) {

            if (y - 1 >= 0) {
                Coord toHelp = new Coord(x, y - 1);
                if (!getBoard().isOccupied(toHelp)){
                    moveList.add(toHelp);
                }
            }

            if (x - 1 >= 0 && y - 1 >= 0) {
                Coord toHelp = new Coord(x - 1, y - 1);
                if (getBoard().isOccupied(toHelp, Color.WHITE)){
                    moveList.add(toHelp);
                }
            }

            if (x + 1 < 8 && y - 1 > 0) {
                Coord toHelp = new Coord(x + 1, y - 1);
                if (getBoard().isOccupied(toHelp, Color.WHITE)){
                    moveList.add(toHelp);
                }
            }

            if (!getIsUsed() && y - 2 >= 0) {
                Coord toHelp = new Coord(x, y - 2);
                if (!getBoard().isOccupied(toHelp)){
                    moveList.add(toHelp);
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
            return "WPaw";
        } else {
            return "BPaw";
        }
    }
}
