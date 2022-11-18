package acad.macnonline.gomoku.component;

import acad.macnonline.gomoku.model.Cell;
import acad.macnonline.gomoku.model.GameTable;
import acad.macnonline.gomoku.model.Player;
import acad.macnonline.gomoku.model.Sign;


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

    public boolean isWin(final GameTable gameTable, final Player player) {
        return isDiagonalDown(gameTable, player.getSign()) ||
                isDiagonalUp(gameTable, player.getSign()) ||
                isDiagonalLeft(gameTable, player.getSign()) ||
                isDiagonalRight(gameTable, player.getSign()) ||
                isWinRow(gameTable, player.getSign()) ||
                isWinCol(gameTable, player.getSign());
    }

    private boolean isWinCol(final GameTable gameTable, final Sign sign) {
        for (int i = 0; i < 7; i++) {
            int count = 0;
            for (int j = 0; j < 7; j++) {
                if (gameTable.getSign(new Cell(i, j)) == sign) {
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

    private boolean isWinRow(final GameTable gameTable, final Sign sign) {
        for (int i = 0; i < 7; i++) {
            int count = 0;
            for (int j = 0; j < 7; j++) {
                if (gameTable.getSign(new Cell(j, i)) == sign) {
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

    private boolean isDiagonalUp(final GameTable gameTable, final Sign sign) {
        for (int i = 0; i < 7; i++) {
            int count = 0;
            int k = i;
            for (int j = 0; j < 7 - i; j++) {

                if (gameTable.getSign(new Cell(k, j)) == sign) {
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

    private boolean isDiagonalDown(final GameTable gameTable, final Sign sign) {
        for (int i = 0; i < 7; i++) {
            int count = 0;
            int k = i;
            for (int j = 0; j < 7 - i; j++) {

                if (gameTable.getSign(new Cell(j, k)) == sign) {
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

    private boolean isDiagonalRight(final GameTable gameTable, final Sign sign) {
        for (int i = 6; i > 0; i--) {
            int count = 0;
            int k = i;
            for (int j = 0; j < i; j++) {
                if (gameTable.getSign(new Cell(j, k)) == sign) {
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

    private boolean isDiagonalLeft(final GameTable gameTable, final Sign sign) {
        for (int i = 0; i < 7; i++) {
            int count = 0;
            int k = i;
            int x = 6;
            for (int j = 7 - i; j > 0; j--) {
                if (gameTable.getSign(new Cell(x, k)) == sign) {
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
