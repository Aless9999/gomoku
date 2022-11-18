package acad.macnonline.gomoku.component;

import acad.macnonline.gomoku.model.Cell;
import acad.macnonline.gomoku.model.GameTable;

import java.util.Random;

import static acad.macnonline.gomoku.model.Sign.O;

/**
 * @author macnonline
 * @link http://macnonline
 */
public class ComputerMove implements Move {
    @Override
    public void makeMove(GameTable gameTable) {
        final Cell[] freeCell = new Cell[49];
        int count = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (gameTable.isEmpty(new Cell(i, j))) {
                    freeCell[count++] = new Cell(i, j);
                }
            }
        }
        if (count > 0) {
            gameTable.setSign(freeCell[new Random().nextInt(count)], O);
        }


    }
}
