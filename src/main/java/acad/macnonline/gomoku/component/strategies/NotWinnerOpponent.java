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
public class NotWinnerOpponent extends OverSign implements StrategyMoveComputer {
    static int amountCell = SizeTable.size;

    @Override
    public boolean tryMakeMove(GameTable gameTable, Sign sign) {
        return tryMakeMoveRow(gameTable, sign) ||
                tryMakeMoveCol(gameTable, sign);
    }

    private boolean tryMakeMoveCol(GameTable gameTable, Sign sign) {
        for (int i = 0; i < amountCell; i++) {
            int count = 0;
            for (int j = 0; j < amountCell; j++) {
                if (gameTable.getSign(new Cell(j, i)) == overSign(sign)) {
                    count++;
                    if (count == 4) {
                        if (j + 1 < amountCell) {
                            if (gameTable.isEmpty(new Cell(j + 1, i))) {
                                gameTable.setSign(new Cell(j + 1, i), sign);
                                return true;
                            } else if (j - 4 >= 0) {
                                if (gameTable.isEmpty(new Cell(j - 4, i))) {
                                    gameTable.setSign(new Cell(j - 4, i), sign);
                                    return true;
                                }
                            }

                        } else if (j - 4 >= 0) {
                            if (gameTable.isEmpty(new Cell(j - 4, i))) {
                                gameTable.setSign(new Cell(j - 4, i), sign);
                                return true;
                            }
                        }

                    }
                } else {
                    count = 0;
                }
            }
        }
        return false;

    }

    private boolean tryMakeMoveRow(GameTable gameTable, Sign sign) {
        for (int i = 0; i < amountCell; i++) {
            int count = 0;
            for (int j = 0; j < amountCell; j++) {
                if (gameTable.getSign(new Cell(i, j)) == overSign(sign)) {

                    count++;
                    if (count == 3) {
                        if (j + 1 < amountCell) {
                            if (gameTable.isEmpty(new Cell(i, j + 1))) {
                                gameTable.setSign(new Cell(i, j + 1), sign);
                                return true;
                            } else if (j - 3 >= 0) {
                                if (gameTable.isEmpty(new Cell(i, j - 3))) {
                                    gameTable.setSign(new Cell(i, j - 3), sign);
                                    return true;
                                }
                            }

                        } else if (j - 3 >= 0) {
                            if (gameTable.isEmpty(new Cell(i, j - 3))) {
                                gameTable.setSign(new Cell(i, j - 3), sign);
                                return true;
                            }
                        }

                    }
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }


}