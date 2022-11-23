package acad.macnonline.gomoku.component.strategies;

import acad.macnonline.gomoku.component.OverSign;
import acad.macnonline.gomoku.component.SizeTable;
import acad.macnonline.gomoku.component.StrategyMoveComputer;
import acad.macnonline.gomoku.model.Cell;
import acad.macnonline.gomoku.model.GameTable;
import acad.macnonline.gomoku.model.Sign;

/**
 * @author macnonline
 * @link http://macnonline
 */
public class SearchThreeSignOpponent extends OverSign implements StrategyMoveComputer {
    static int amountCell = SizeTable.size;

    @Override
    public boolean tryMakeMove(GameTable gameTable, Sign sign) {
        return tryMakeMoveRow(gameTable, sign) ||
                tryMakeMoveCol(gameTable, sign);


    }

    private boolean tryMakeMoveCol(GameTable gameTable, Sign sign) {

        for (int i = 0; i < amountCell; i++) {
            int count = 0;
            Cell lostCell = null;
            for (int j = 0; j < amountCell; j++) {
                final Cell cell = new Cell(j, i);
                if (gameTable.getSign(cell) == overSign(sign)) {
                    count++;
                    lostCell = cell;

                }
                if (count == 3) {
                    if (gameTable.isEmpty(lostCell)) {
                        gameTable.setSign(lostCell, sign);
                        return true;
                    } else if (lostCell.getRow() - 3 >= 0) {
                        if (gameTable.isEmpty(new Cell(lostCell.getRow() - 3, lostCell.getCol()))) {
                            gameTable.setSign((new Cell(lostCell.getRow() - 3, lostCell.getCol())), sign);
                            return true;
                        }
                    } else if (lostCell.getRow() < amountCell) {
                        if (gameTable.isEmpty(new Cell(lostCell.getRow() + 1, lostCell.getCol()))) {
                            gameTable.setSign((new Cell(lostCell.getRow() + 1, lostCell.getCol())), sign);
                            return true;

                        }
                    }
                }

            }
        }
        return false;
    }


    private boolean tryMakeMoveRow(GameTable gameTable, Sign sign) {
        for (int i = 0; i < amountCell; i++) {
            int count = 0;
            Cell lostCell = null;
            for (int j = 0; j < amountCell; j++) {
                final Cell cell = new Cell(i, j);
                if (gameTable.getSign(cell) == overSign(sign)) {
                    count++;
                    lostCell = cell;

                }
                if (count == 3) {
                    if (gameTable.isEmpty(lostCell)) {
                        gameTable.setSign(lostCell, sign);
                        return true;
                    } else if (lostCell.getCol() - 1 <= 0) {
                        if (gameTable.isEmpty(new Cell(lostCell.getRow(), lostCell.getCol() - 3))) {
                            gameTable.setSign((new Cell(lostCell.getRow(), lostCell.getCol() - 3)), sign);
                            return true;
                        }
                    } else if (lostCell.getCol() > amountCell) {
                        if (gameTable.isEmpty(new Cell(lostCell.getRow(), lostCell.getCol() + 1))) {
                            gameTable.setSign((new Cell(lostCell.getRow(), lostCell.getCol() + 1)), sign);
                            return true;

                        }
                    }
                }

            }
        }
        return false;
    }
}
