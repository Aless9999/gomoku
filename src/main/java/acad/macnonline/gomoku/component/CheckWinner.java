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
    static SizeTable size = new SizeTable();
    static int amountCell = size.size;

    public boolean isDraw(GameTable gameTable) {
        for (int i = 0; i < amountCell; i++) {
            for (int j = 0; j < amountCell; j++) {
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
        for (int i = 0; i < amountCell; i++) {
            int count = 0;
            for (int j = 0; j < amountCell; j++) {
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
        for (int i = 0; i < amountCell; i++) {
            int count = 0;
            for (int j = 0; j < amountCell; j++) {
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
        for (int i = 0; i < amountCell; i++) {
            int count = 0;
            int k = i;
            for (int j = 0; j < amountCell - i; j++) {

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
        for (int i = 0; i < amountCell; i++) {
            int count = 0;
            int k = i;
            for (int j = 0; j < amountCell - i; j++) {

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
        for (int i = 0; i < amountCell; i++) {
            int count = 0;
            int k = i;
            int x = amountCell - 1;
            for (int j = amountCell - i; j > 0; j--) {
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
