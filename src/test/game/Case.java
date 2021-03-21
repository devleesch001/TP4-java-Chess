package test.game;

public class Case{
    private Movable piece;

    /**
     * @return if case is occupied by an piece
     */
    public boolean isOccupied() {
        return piece != null;
    }

    /**
     * @param newPiece set Movable Piece
     */
    public void setPiece(Movable newPiece) {
        piece = newPiece;
    }

    /**
     * @return Movable Piece
     */
    public Movable getPiece() {
        return piece;
    }
}
