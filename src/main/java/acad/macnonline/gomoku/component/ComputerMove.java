package acad.macnonline.gomoku.component;

import acad.macnonline.gomoku.model.Cell;
import acad.macnonline.gomoku.model.GameTable;
import acad.macnonline.gomoku.model.Sign;

import java.util.Random;

/**
 * @author macnonline
 * @link http://macnonline
 */
public class ComputerMove implements Move {
    static SizeTable size = new SizeTable();
    static int amountCell = size.size;

    @Override
    public void makeMove(final GameTable gameTable, final Sign sign) {
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
        }


    }
}
