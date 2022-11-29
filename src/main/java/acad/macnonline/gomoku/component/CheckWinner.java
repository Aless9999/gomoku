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

    static int amountCell = SizeTable.size;

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

        return isWinnerRowOrColl((i, j) -> (gameTable.getSign(new Cell(i, j)) == sign));
    }

    private boolean isWinRow(final GameTable gameTable, final Sign sign) {
        return isWinnerRowOrColl((i, j) -> (gameTable.getSign(new Cell(j, i)) == sign));
    }

    @FunctionalInterface
    private interface Lambda {
        boolean getValue(int i, int j);
    }

    private boolean isWinnerRowOrColl(Lambda lambda) {
        for (int i = 0; i < amountCell; i++) {
            int count = 0;
            for (int j = 0; j < amountCell; j++) {
                if (lambda.getValue(i, j)) {
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

        return isWinnerDiagonalDownOrUp((k, j) -> (gameTable.getSign(new Cell(k, j)) == sign));
    }

    private boolean isDiagonalDown(final GameTable gameTable, final Sign sign) {
        return isWinnerDiagonalDownOrUp((k, j) -> (gameTable.getSign(new Cell(j, k)) == sign));
    }

    @FunctionalInterface
    private interface LambdaDiagonal {
        boolean getValue(int k, int j);
    }

    private boolean isWinnerDiagonalDownOrUp(LambdaDiagonal lambdaDiagonal) {
        for (int i = 0; i < amountCell; i++) {
            int count = 0;
            int k = i;
            for (int j = 0; j < amountCell - i; j++) {

                if (lambdaDiagonal.getValue(k, j)) {
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
        for (int i = amountCell - 1; i > 0; i--) {
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
