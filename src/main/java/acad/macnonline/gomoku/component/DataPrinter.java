package acad.macnonline.gomoku.component;

import acad.macnonline.gomoku.model.GameTable;

/**
 * @author macnonline
 * @link http://macnonline
 */
public interface DataPrinter {
    void printInfoMessage(String message);

    void printErrorMessage(String message);

    void mapGame(GameTable gameTable);
}

