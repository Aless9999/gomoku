package acad.macnonline.gomoku.component;

import acad.macnonline.gomoku.model.GameTable;
import acad.macnonline.gomoku.model.Sign;

/**
 * @author macnonline
 * @link http://macnonline
 */
public class ComputerMove implements Move {

    private static StrategyMoveComputer[] strategies;

    public ComputerMove(final StrategyMoveComputer[] strategies) {
        this.strategies = strategies;
    }

    @Override
    public void makeMove(final GameTable gameTable, final Sign sign) {
        for (final StrategyMoveComputer strategy : strategies) {
            if (strategy.tryMakeMove(gameTable, sign)) {
                return;

            }
        }
        throw new IllegalArgumentException("Game table not empty free cells");


    }
}
