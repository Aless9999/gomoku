package acad.macnonline.gomoku.component;

import acad.macnonline.gomoku.model.Cell;
import acad.macnonline.gomoku.model.GameTable;
import acad.macnonline.gomoku.model.Sign;

/**
 * @author macnonline
 * @link http://macnonline
 */
public class UserMove implements Move {
    private final UserInputReader userInputReader;

    public UserMove(UserInputReader userInputReader) {
        this.userInputReader = userInputReader;
    }

    @Override
    public void makeMove(final GameTable gameTable, final Sign sign) {
        final Cell cell = userInputReader.getUserInput();
        if (gameTable.isEmpty(cell)) {
            gameTable.setSign(cell, sign);
        }
    }
}

