package acad.macnonline.gomoku.model;

import acad.macnonline.gomoku.component.Move;

/**
 * @author macnonline
 * @link http://macnonline
 */
public final class Player {
    private final Sign sign;
    private final Move move;


    public Player(Sign sign, Move move) {
        this.sign = sign;
        this.move = move;
    }

    public Sign getSign() {
        return sign;
    }

    public Move getMove() {
        return move;
    }
}
