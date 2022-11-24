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
                tryMakeMoveCol(gameTable, sign) ||
                tryMakeMoveIsDiagonalUp(gameTable, sign) ||
                tryMakeMoveIsDiagonalDown(gameTable, sign) ||
                tryMakeMovesDiagonalRight(gameTable, sign) ||
                tryMakeMovesDiagonalLeft(gameTable, sign);
    }

    private boolean tryMakeMovesDiagonalLeft(GameTable gameTable, Sign sign) {

        Cell lostCell = null;
        for (int i = 0; i < amountCell; i++) {
            int count = 0;
            int k = i;
            int x = amountCell - 1;

            for (int j = amountCell - i; j > 0; j--) {
                if (gameTable.getSign(new Cell(x, k)) == overSign(sign)) {
                    lostCell = new Cell(x, k);
                    count++;

                    k++;
                    x--;

                    if (count == 4) {
                        if (lostCell.getRow() - 1 >= 0 && lostCell.getCol() + 1 < amountCell) {
                            if (gameTable.isEmpty(new Cell(lostCell.getRow() - 1, lostCell.getCol() + 1))) {
                                gameTable.setSign(new Cell(lostCell.getRow() - 1, lostCell.getCol() + 1), sign);
                                return true;
                            } else if (lostCell.getRow() + 4 < amountCell && lostCell.getCol() - 4 >= 0) {
                                if (gameTable.isEmpty(new Cell(lostCell.getRow() + 4, lostCell.getCol() - 4))) {
                                    gameTable.setSign((new Cell(lostCell.getRow() + 4, lostCell.getCol() - 4)), sign);
                                    return true;
                                }
                            }
                        } else if (lostCell.getRow() + 4 < amountCell && lostCell.getCol() - 4 >= 0) {
                            if (gameTable.isEmpty(new Cell(lostCell.getRow() + 4, lostCell.getCol() - 4))) {
                                gameTable.setSign((new Cell(lostCell.getRow() + 4, lostCell.getCol() - 4)), sign);
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

    private boolean tryMakeMovesDiagonalRight(GameTable gameTable, Sign sign) {
        Cell lostCell = null;
        for (int i = amountCell - 1; i > 0; i--) {
            int count = 0;
            int k = i;

            for (int j = 0; j < i; j++) {
                if (gameTable.getSign(new Cell(j, k)) == overSign(sign)) {
                    lostCell = new Cell(j, k);
                    count++;
                    k--;

                    if (count == 4) {
                        if (lostCell.getRow() + 1 < amountCell && lostCell.getCol() + 1 < amountCell) {
                            if (gameTable.isEmpty(new Cell(lostCell.getRow() + 1, lostCell.getCol() - 1))) {
                                gameTable.setSign(new Cell(lostCell.getRow() + 1, lostCell.getCol() - 1), sign);
                                return true;
                            } else if (lostCell.getRow() - 4 >= 0 && lostCell.getCol() - 4 >= 0) {
                                if (gameTable.isEmpty(new Cell(lostCell.getRow() - 4, lostCell.getCol() + 4))) {
                                    gameTable.setSign(new Cell(lostCell.getRow() - 4, lostCell.getCol() + 4), sign);
                                    return true;
                                }
                            }
                        } else if (lostCell.getRow() - 4 >= 0 && lostCell.getCol() - 4 >= 0) {
                            if (gameTable.isEmpty(new Cell(lostCell.getRow() - 4, lostCell.getCol() + 4))) {
                                gameTable.setSign(new Cell(lostCell.getRow() - 4, lostCell.getCol() + 4), sign);
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

    private boolean tryMakeMoveIsDiagonalDown(GameTable gameTable, Sign sign) {
        Cell lostCell = null;
        for (int i = 0; i < amountCell; i++) {
            int count = 0;
            int k = i;
            for (int j = 0; j < amountCell - i; j++) {

                if (gameTable.getSign(new Cell(j, k)) == overSign(sign)) {
                    lostCell = new Cell(j, k);
                    count++;
                    k++;
                    if (count == 4) {
                        if (lostCell.getRow() + 1 < amountCell && lostCell.getCol() + 1 < amountCell) {
                            if (gameTable.isEmpty(new Cell(lostCell.getRow() + 1, lostCell.getCol() + 1))) {
                                gameTable.setSign((new Cell(lostCell.getRow() + 1, lostCell.getCol() + 1)), sign);
                                return true;
                            } else if (lostCell.getRow() - 4 >= 0 && lostCell.getCol() - 4 >= 0) {
                                if (gameTable.isEmpty(new Cell(lostCell.getRow() - 4, lostCell.getCol() - 4))) {
                                    gameTable.setSign((new Cell(lostCell.getRow() - 4, lostCell.getCol() - 4)), sign);
                                    return true;
                                }
                            }
                        } else if (lostCell.getRow() - 4 >= 0) {
                            if (gameTable.isEmpty(new Cell(lostCell.getRow() - 4, lostCell.getCol() - 4))) {
                                gameTable.setSign((new Cell(lostCell.getRow() - 4, lostCell.getCol() - 4)), sign);
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

    private boolean tryMakeMoveIsDiagonalUp(GameTable gameTable, Sign sign) {
        Cell lostCell = null;
        for (int i = 0; i < amountCell; i++) {
            int count = 0;
            int k = i;
            for (int j = 0; j < amountCell - i; j++) {

                if (gameTable.getSign(new Cell(k, j)) == overSign(sign)) {
                    lostCell = new Cell(k, j);
                    count++;
                    k++;
                    if (count == 4) {
                        if (lostCell.getRow() + 1 < amountCell && lostCell.getCol() + 1 < amountCell) {
                            if (gameTable.isEmpty(new Cell(lostCell.getRow() + 1, lostCell.getCol() + 1))) {
                                gameTable.setSign((new Cell(lostCell.getRow() + 1, lostCell.getCol() + 1)), sign);
                                return true;
                            } else if (lostCell.getRow() - 4 >= 0 && lostCell.getCol() - 4 >= 0) {
                                if (gameTable.isEmpty(new Cell(lostCell.getRow() - 4, lostCell.getCol() - 4))) {
                                    gameTable.setSign((new Cell(lostCell.getRow() - 4, lostCell.getCol() - 4)), sign);
                                    return true;
                                }
                            }
                        } else if (lostCell.getRow() - 4 >= 0 && lostCell.getCol() - 4 >= 0) {
                            if (gameTable.isEmpty(new Cell(lostCell.getRow() - 4, lostCell.getCol() - 4))) {
                                gameTable.setSign((new Cell(lostCell.getRow() - 4, lostCell.getCol() - 4)), sign);
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
                    if (count == 4) {
                        if (j + 1 < amountCell) {
                            if (gameTable.isEmpty(new Cell(i, j + 1))) {
                                gameTable.setSign(new Cell(i, j + 1), sign);
                                return true;
                            } else if (j - 4 >= 0) {
                                if (gameTable.isEmpty(new Cell(i, j - 4))) {
                                    gameTable.setSign(new Cell(i, j - 4), sign);
                                    return true;
                                }
                            }

                        } else if (j - 4 >= 0) {
                            if (gameTable.isEmpty(new Cell(i, j - 4))) {
                                gameTable.setSign(new Cell(i, j - 4), sign);
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