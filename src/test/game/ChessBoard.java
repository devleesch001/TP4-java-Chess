package test.game;

import test.Color;
import test.boardException.IllegalPosition;
import test.Coord;

/**
 * @author Alexis DEVLEESCHAUWER alexis@devleeschauwer.fr
 */
public class ChessBoard {
    private Case[][] cases;
    private static ChessBoard cb = null;

    /**
     * @return number of Instance
     */
    public ChessBoard getInstance() {
        if (cb == null) {
            cb = new ChessBoard();
        }
        return cb;
    }

    public ChessBoard() {
        this.cases = new Case[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.cases[i][j] = new Case();
            }
        }
    }

    /**
     * @param pos Coordinate to check
     * @param color Color to check
     * @return Boolean
     * if case is occupied by an piece of same color
     */
    public boolean isOccupied(Coord pos, Color color) {
        if (this.cases[pos.getX()][pos.getY()].isOccupied()) {
            return color == this.cases[pos.getX()][pos.getY()].getPiece().getColor();
        }

        return false;
    }

    /**
     * @param pos Coordinate to check
     * @return Boolean
     * if case is occupied by an piece
     */
    public boolean isOccupied(Coord pos) {
        return this.cases[pos.getX()][pos.getY()].isOccupied();
    }



    /**
     * @param pos Coordinate
     * @param piece boolean of new status occupied
     */
    public void setOccupation(Coord pos, Movable piece) throws IllegalPosition {
        if (pos.getX() < 0 || pos.getX() > 7 || pos.getY() < 0 || pos.getY() > 7) {
            throw new IllegalPosition("Out of board");
        } else {
            cases[pos.getX()][pos.getY()].setPiece(piece);
        }
    }

    /**
     * Print with good design
     */
    public void smartPrint() {
        System.out.println();
        for (int i = 7; i >= 0; i--) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < 8; j++) {
                if (this.cases[j][i].getPiece() == null) {
                    System.out.print("---- ");
                } else {
                    System.out.print(this.cases[j][i].getPiece() + " ");
                }
            }
            System.out.println("");
        }

        for (int i = 0; i < 9; i++) {
            System.out.print(i + "    ");
        }

        System.out.println("");
    }

    /* getter setter */

    /**
     * @param place Coordinate
     * @return case at Coordinate
     */
    public Case getCase(Coord place) {
        return cases[place.getX()][place.getY()];
    }

    /**
     * @param cases set case
     */
    public void setCases(Case[][] cases) {
        this.cases = cases;
    }
}
