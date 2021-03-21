package test.boardException;

public class IllegalMove extends Exception {

    /**
     * @param message String
     */
    public IllegalMove(String message) {
        super(message);
    }
}
