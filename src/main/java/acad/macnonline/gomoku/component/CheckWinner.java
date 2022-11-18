package acad.macnonline.gomoku.component;

import acad.macnonline.gomoku.model.Cell;
import acad.macnonline.gomoku.model.GameTable;
import acad.macnonline.gomoku.model.Sign;

import static acad.macnonline.gomoku.model.Sign.O;

/**
 * @author macnonline
 * @link http://macnonline
 */
public class CheckWinner {
    public boolean isDraw(GameTable gameTable) {
        return false;
    }

    ;

    public boolean isWin(GameTable gameTable) {
        return winnerForRow(gameTable) ||
                winnerForCol(gameTable) ||
                winnerForLeftDiagonal(gameTable) ||
                winnerForRichtDiagonal(gameTable);
    }

    private boolean winnerForRichtDiagonal(GameTable gameTable) {
        return gameTable.getSign(new Cell(0, 0)) == gameTable.getSign(new Cell(1, 1)) &&
                gameTable.getSign(new Cell(1, 1)) == gameTable.getSign(new Cell(2, 2)) &&
                gameTable.getSign(new Cell(2, 2)) == gameTable.getSign(new Cell(3, 3)) &&
                gameTable.getSign(new Cell(3, 3)) == gameTable.getSign(new Cell(4, 4)) &&
                gameTable.getSign(new Cell(4, 4)) == O;

    }

    private boolean winnerForLeftDiagonal(GameTable gameTable) {
        return gameTable.getSign(new Cell(4, 0)) == gameTable.getSign(new Cell(3, 1)) &&
                gameTable.getSign(new Cell(3, 1)) == gameTable.getSign(new Cell(2, 2)) &&
                gameTable.getSign(new Cell(2, 2)) == gameTable.getSign(new Cell(1, 3)) &&
                gameTable.getSign(new Cell(1, 3)) == gameTable.getSign(new Cell(0, 4)) &&
                gameTable.getSign(new Cell(0, 4)) == O;
    }

    private boolean winnerForCol(GameTable gameTable) {

        for (int i = 0; i < 7; i++) {
            int count = 0;
            for (int j = 0; j < 7; j++) {
                if (gameTable.getSign(new Cell(i, j)) == O) {
                    count++;
                    if(count==5){
                        return true;
                    }
                }else {
                    count = 0;
                }
            }
        }
        return false;
    }

    private boolean winnerForRow(GameTable gameTable) { for (int i = 0; i < 7; i++) {
        int count = 0;
        for (int j = 0; j < 7; j++) {
            if (gameTable.getSign(new Cell(j, i)) == O) {
                count++;
                if(count==5){
                    return true;
                }
            }else {
                count = 0;
            }
        }
    }
        return false;
    }
}
