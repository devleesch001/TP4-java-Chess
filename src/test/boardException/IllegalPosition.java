package test.boardException;

public class IllegalPosition extends Exception {
    /**
     * @param message String
     */
    public IllegalPosition(String message) {
        super(message);
    }
}
