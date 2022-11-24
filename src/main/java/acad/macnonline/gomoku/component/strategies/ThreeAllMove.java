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
public class ThreeAllMove implements StrategyMoveComputer {
    static int amountCell = SizeTable.size;

    @Override
    public boolean tryMakeMove(GameTable gameTable, Sign sign) {
        return
                tryMakeMoveRow(gameTable, sign) ||
                        tryMakeMoveCol(gameTable, sign) ||
                        tryMakeMovesDiagonalLeft(gameTable, sign) ||
                        tryMakeMovesDiagonalRight(gameTable, sign) ||
                        tryMakeMoveisDiagonalDown(gameTable, sign) ||
                        tryMakeMovesDiagonalUp(gameTable, sign);


    }

    private boolean tryMakeMovesDiagonalUp(GameTable gameTable, Sign sign) {

        for (int i = 0; i < amountCell; i++) {
            int count = 0;
            int k = i;
            Cell lostCell = null;
            for (int j = 0; j < amountCell - i; j++) {

                if (gameTable.getSign(new Cell(k, j)) == (sign)) {
                    lostCell = new Cell(k, j);
                    count++;
                    k++;
                    if (count == 3) {
                        if (lostCell.getRow() + 1 < amountCell && lostCell.getCol() + 1 < amountCell) {
                            if (gameTable.isEmpty(new Cell(lostCell.getRow() + 1, lostCell.getCol() + 1))) {
                                gameTable.setSign((new Cell(lostCell.getRow() + 1, lostCell.getCol() + 1)), sign);
                                return true;
                            } else if (lostCell.getRow() - 3 >= 0 && lostCell.getCol() - 3 >= 0) {
                                if (gameTable.isEmpty(new Cell(lostCell.getRow() - 3, lostCell.getCol() - 3))) {
                                    gameTable.setSign((new Cell(lostCell.getRow() - 3, lostCell.getCol() - 3)), sign);
                                    return true;
                                }
                            }
                        } else if (lostCell.getRow() - 3 >= 0 && lostCell.getCol() - 3 >= 0) {
                            if (gameTable.isEmpty(new Cell(lostCell.getRow() - 3, lostCell.getCol() - 3))) {
                                gameTable.setSign((new Cell(lostCell.getRow() - 3, lostCell.getCol() - 3)), sign);
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

    private boolean tryMakeMoveisDiagonalDown(GameTable gameTable, Sign sign) {

        for (int i = 0; i < amountCell; i++) {
            int count = 0;
            int k = i;
            Cell lostCell = null;
            for (int j = 0; j < amountCell - i; j++) {

                if (gameTable.getSign(new Cell(j, k)) == (sign)) {
                    lostCell = new Cell(j, k);
                    count++;
                    k++;
                    if (count == 3) {
                        if (lostCell.getRow() + 1 < amountCell && lostCell.getCol() + 1 < amountCell) {
                            if (gameTable.isEmpty(new Cell(lostCell.getRow() + 1, lostCell.getCol() + 1))) {
                                gameTable.setSign((new Cell(lostCell.getRow() + 1, lostCell.getCol() + 1)), sign);
                                return true;
                            } else if (lostCell.getRow() - 3 >= 0 && lostCell.getCol() - 3 >= 0) {
                                if (gameTable.isEmpty(new Cell(lostCell.getRow() - 3, lostCell.getCol() - 3))) {
                                    gameTable.setSign((new Cell(lostCell.getRow() - 3, lostCell.getCol() - 3)), sign);
                                    return true;
                                }
                            }
                        } else if (lostCell.getRow() - 3 >= 0) {
                            if (gameTable.isEmpty(new Cell(lostCell.getRow() - 3, lostCell.getCol() - 3))) {
                                gameTable.setSign((new Cell(lostCell.getRow() - 3, lostCell.getCol() - 3)), sign);
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

    private boolean tryMakeMovesDiagonalRight(GameTable gameTable, Sign sign) {
        for (int i = amountCell - 1; i > 0; i--) {
            int count = 0;
            int k = i;
            Cell lostCell = null;
            for (int j = 0; j < i; j++) {
                if (gameTable.getSign(new Cell(j, k)) == (sign)) {
                    lostCell = new Cell(j, k);
                    count++;
                    k--;

                    if (count == 3) {
                        if (lostCell.getRow() + 1 < amountCell && lostCell.getCol() + 1 < amountCell) {
                            if (gameTable.isEmpty(new Cell(lostCell.getRow() + 1, lostCell.getCol() - 1))) {
                                gameTable.setSign(new Cell(lostCell.getRow() + 1, lostCell.getCol() - 1), sign);
                                return true;
                            } else if (lostCell.getRow() - 3 >= 0 && lostCell.getCol() - 3 >= 0) {
                                if (gameTable.isEmpty(new Cell(lostCell.getRow() - 3, lostCell.getCol() + 3))) {
                                    gameTable.setSign(new Cell(lostCell.getRow() - 3, lostCell.getCol() + 3), sign);
                                    return true;
                                }
                            }
                        } else if (lostCell.getRow() - 3 >= 0 && lostCell.getCol() - 3 >= 0) {
                            if (gameTable.isEmpty(new Cell(lostCell.getRow() - 3, lostCell.getCol() + 3))) {
                                gameTable.setSign(new Cell(lostCell.getRow() - 3, lostCell.getCol() + 3), sign);
                                return true;
                            }
                        }
                    }
                } else {
                    count = 0;
                    k--;
                }
            }
        }
        return false;
    }

    private boolean tryMakeMovesDiagonalLeft(GameTable gameTable, Sign sign) {
        for (int i = 0; i < amountCell; i++) {
            int count = 0;
            int k = i;
            int x = amountCell - 1;
            Cell lostCell = null;
            for (int j = amountCell - i; j > 0; j--) {
                if (gameTable.getSign(new Cell(x, k)) == (sign)) {
                    lostCell = new Cell(x, k);
                    count++;

                    k++;
                    x--;

                    if (count == 3) {
                        if (lostCell.getRow() - 1 >= 0 && lostCell.getCol() + 1 < amountCell) {
                            if (gameTable.isEmpty(new Cell(lostCell.getRow() - 1, lostCell.getCol() + 1))) {
                                gameTable.setSign(new Cell(lostCell.getRow() - 1, lostCell.getCol() + 1), sign);
                                return true;
                            } else if (lostCell.getRow() + 3 < amountCell && lostCell.getCol() - 3 >= 0) {
                                if (gameTable.isEmpty(new Cell(lostCell.getRow() + 3, lostCell.getCol() - 3))) {
                                    gameTable.setSign((new Cell(lostCell.getRow() + 3, lostCell.getCol() - 3)), sign);
                                    return true;
                                }
                            }
                        } else if (lostCell.getRow() + 3 < amountCell && lostCell.getCol() - 3 >= 0) {
                            if (gameTable.isEmpty(new Cell(lostCell.getRow() + 3, lostCell.getCol() - 3))) {
                                gameTable.setSign((new Cell(lostCell.getRow() + 3, lostCell.getCol() - 3)), sign);
                                return true;
                            }
                        }
                    }
                } else {
                    count = 0;
                    k++;
                    x--;
                }
            }
        }
        return false;
    }

    private boolean tryMakeMoveCol(GameTable gameTable, Sign sign) {

        for (int i = 0; i < amountCell; i++) {
            int count = 0;
            Cell lostCell = null;
            for (int j = 0; j < amountCell; j++) {
                final Cell cell = new Cell(j, i);
                if (gameTable.getSign(cell) == (sign)) {
                    count++;
                    lostCell = cell;


                    if (count == 3) {
                        if (gameTable.isEmpty(lostCell)) {
                            gameTable.setSign(lostCell, sign);
                            return true;
                        } else if (lostCell.getRow() - 3 >= 0) {
                            if (gameTable.isEmpty(new Cell(lostCell.getRow() - 3, lostCell.getCol()))) {
                                gameTable.setSign((new Cell(lostCell.getRow() - 3, lostCell.getCol())), sign);
                                return true;
                            }
                        } else if (lostCell.getRow() + 1 < amountCell) {
                            if (gameTable.isEmpty(new Cell(lostCell.getRow() + 1, lostCell.getCol()))) {
                                gameTable.setSign((new Cell(lostCell.getRow() + 1, lostCell.getCol())), sign);
                                return true;

                            }
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
                if (gameTable.getSign(cell) == (sign)) {
                    count++;
                    lostCell = cell;


                    if (count == 3) {
                        if (gameTable.isEmpty(lostCell)) {
                            gameTable.setSign(lostCell, sign);
                            return true;
                        } else if (lostCell.getCol() - 3 >= 0) {
                            if (gameTable.isEmpty(new Cell(lostCell.getRow(), lostCell.getCol() - 3))) {
                                gameTable.setSign((new Cell(lostCell.getRow(), lostCell.getCol() - 3)), sign);
                                return true;
                            }
                        } else if (lostCell.getCol() + 1 < amountCell) {
                            if (gameTable.isEmpty(new Cell(lostCell.getRow(), lostCell.getCol() + 1))) {
                                gameTable.setSign((new Cell(lostCell.getRow(), lostCell.getCol() + 1)), sign);
                                return true;

                            }
                        }
                    }

                }
            }


        }
        return false;
    }
}
