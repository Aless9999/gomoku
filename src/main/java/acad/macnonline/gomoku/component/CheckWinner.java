package acad.macnonline.gomoku.component;

import acad.macnonline.gomoku.model.Cell;
import acad.macnonline.gomoku.model.GameTable;

import static acad.macnonline.gomoku.model.Sign.O;

/**
 * @author macnonline
 * @link http://macnonline
 */
public class CheckWinner {
    public boolean isDraw(GameTable gameTable) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (gameTable.isEmpty(new Cell(i, j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isWin(GameTable gameTable) {
        return isDiagonalDown(gameTable) ||
                isDiagonalUp(gameTable) ||
                isDiagonalLeft(gameTable) ||
                isDiagonalRight(gameTable) ||
                isWinRow(gameTable) ||
                isWinCol(gameTable);
    }

    boolean isWinCol(GameTable gameTable) {
        for (int i = 0; i < 7; i++) {
            int count = 0;
            for (int j = 0; j < 7; j++) {
                if (gameTable.getSign(new Cell(i, j)) == O) {
                    count++;
                    if (count == 5) {
                        return true;
                    }

                } else {
                    count = 0;

                }
            }

        }
        return false;
    }

    boolean isWinRow(GameTable gameTable) {
        for (int i = 0; i < 7; i++) {
            int count = 0;
            for (int j = 0; j < 7; j++) {
                if (gameTable.getSign(new Cell(j, i)) == O) {
                    count++;
                    if (count == 5) {
                        return true;
                    }

                } else {
                    count = 0;

                }
            }

        }
        return false;
    }

    boolean isDiagonalUp(GameTable gameTable) {
        for (int i = 0; i < 7; i++) {
            int count = 0;
            int k = i;
            for (int j = 0; j < 7 - i; j++) {

                if (gameTable.getSign(new Cell(k, j)) == O) {
                    count++;
                    k++;
                    if (count == 5) {
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

    boolean isDiagonalDown(GameTable gameTable) {
        for (int i = 0; i < 7; i++) {
            int count = 0;
            int k = i;
            for (int j = 0; j < 7 - i; j++) {

                if (gameTable.getSign(new Cell(j, k)) == O) {
                    count++;
                    k++;
                    if (count == 5) {
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

    boolean isDiagonalRight(GameTable gameTable) {
        for (int i = 6; i > 0; i--) {
            int count = 0;
            int k = i;
            for (int j = 0; j < i; j++) {
                if (gameTable.getSign(new Cell(j, k)) == O) {
                    count++;
                    k--;
                    if (count == 5) {
                        return true;
                    }
                } else {
                    count = 0;
                    k--;
                }
            }
        }
        return false;
    }

    boolean isDiagonalLeft(GameTable gameTable) {
        for (int i = 0; i < 7; i++) {
            int count = 0;
            int k = i;
            int x = 6;
            for (int j = 7 - i; j > 0; j--) {
                if (gameTable.getSign(new Cell(x, k)) == O) {
                    count++;
                    k++;
                    x--;

                    if (count == 5) {
                        return true;
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
}
