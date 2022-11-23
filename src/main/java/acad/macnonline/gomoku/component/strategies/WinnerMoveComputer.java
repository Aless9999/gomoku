package acad.macnonline.gomoku.component.strategies;

import acad.macnonline.gomoku.component.SizeTable;
import acad.macnonline.gomoku.component.StrategyMoveComputer;
import acad.macnonline.gomoku.model.Cell;
import acad.macnonline.gomoku.model.GameTable;
import acad.macnonline.gomoku.model.Sign;

/**
 * @author macnonline
 * @link http://macnonline
 */
public class WinnerMoveComputer implements StrategyMoveComputer {

    static int amountCell = SizeTable.size;

    @Override
    public boolean tryMakeMove(GameTable gameTable, Sign sign) {
        return tryMakeMoveRow(gameTable, sign) ||
                tryMakeMoveCol(gameTable, sign) ||
                tryMakeIsDiagonalDown(gameTable, sign) ||
                tryMakeIsDiagonalUp(gameTable, sign);


    }

    private boolean tryMakeIsDiagonalUp(GameTable gameTable, Sign sign) {
        for (int i = 0; i < amountCell; i++) {
            int count = 0;
            int k = i;
            for (int j = 0; j < amountCell - i; j++) {

                if (gameTable.getSign(new Cell(k, j)) == sign) {
                    count++;
                    k++;
                    if (count == 4) {
                        return true;
                    }
                } else {
                    count = 0;
                    k++;
                }
            }
        }
        return false;
    }

    private boolean tryMakeIsDiagonalDown(GameTable gameTable, Sign sign) {
        for (int i = 0; i < amountCell; i++) {
            int count = 0;
            int k = i;
            for (int j = 0; j < amountCell - i; j++) {

                if (gameTable.getSign(new Cell(j, k)) == sign) {
                    count++;
                    k++;
                    if (count == 4) {
                        if (k < amountCell) {
                            if (gameTable.isEmpty(new Cell(j, k))) {
                                gameTable.setSign(new Cell(j, k), sign);
                                return true;
                            } else if (gameTable.isEmpty(new Cell(j, k - 4))) {
                                gameTable.setSign(new Cell(j, k - 4), sign);
                                return true;

                            }
                        }

                    }
                } else {
                    count = 0;
                    k++;
                }
            }
        }
        return false;
    }

    private boolean tryMakeMoveCol(GameTable gameTable, Sign sign) {
        for (int i = 0; i < amountCell; i++) {
            int count = 0;
            for (int j = 0; j < amountCell; j++) {
                if (gameTable.getSign(new Cell(j, i)) == sign) {
                    count++;
                    if (count == 4 && i + 1 < amountCell) {
                        if (gameTable.isEmpty(new Cell(j, i + 1))) {
                            gameTable.setSign(new Cell(j, i + 1), sign);
                            return true;
                        } else {
                            gameTable.setSign(new Cell(j, i - 3), sign);
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
                if (gameTable.getSign(new Cell(i, j)) == sign) {
                    count++;
                    if (count == 4 && j + 1 < amountCell) {
                        if (gameTable.isEmpty(new Cell(i, j + 1))) {
                            gameTable.setSign(new Cell(i, j + 1), sign);
                            return true;
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

