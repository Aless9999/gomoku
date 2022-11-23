package acad.macnonline.gomoku.component.strategies;

import acad.macnonline.gomoku.component.SizeTable;
import acad.macnonline.gomoku.component.StrategyMoveComputer;
import acad.macnonline.gomoku.model.Cell;
import acad.macnonline.gomoku.model.GameTable;
import acad.macnonline.gomoku.model.Sign;

import java.util.Random;

/**
 * @author macnonline
 * @link http://macnonline
 */
public class RandomComputerMove implements StrategyMoveComputer {
    static SizeTable size = new SizeTable();
    static int amountCell = size.size;

    @Override
    public boolean tryMakeMove(GameTable gameTable, Sign sign) {
        final Cell[] freeCell = new Cell[amountCell * amountCell];
        int count = 0;
        for (int i = 0; i < amountCell; i++) {
            for (int j = 0; j < amountCell; j++) {
                if (gameTable.isEmpty(new Cell(i, j))) {
                    freeCell[count++] = new Cell(i, j);
                }
            }
        }
        if (count > 0) {
            gameTable.setSign(freeCell[new Random().nextInt(count)], sign);
            return true;
        } else {
            throw new IllegalArgumentException("Game table not content free cells.");
        }

    }
}
