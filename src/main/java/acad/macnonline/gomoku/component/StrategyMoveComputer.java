package acad.macnonline.gomoku.component;

import acad.macnonline.gomoku.model.GameTable;
import acad.macnonline.gomoku.model.Sign;

/**
 * @author macnonline
 * @link http://macnonline
 */
public interface StrategyMoveComputer {

    boolean tryMakeMove(GameTable gameTable, Sign sign);
}
