package acad.macnonline.gomoku.component;

import acad.macnonline.gomoku.model.GameTable;
import acad.macnonline.gomoku.model.Sign;

/**
 * @author macnonline
 * @link http://macnonline
 */
public interface Move {
    void makeMove(final GameTable gameTable, final Sign sign);
}
