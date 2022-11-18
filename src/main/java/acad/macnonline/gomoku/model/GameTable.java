package acad.macnonline.gomoku.model;

import static acad.macnonline.gomoku.model.Sign.EMPTY;
import static acad.macnonline.gomoku.model.Sign.O;

/**
 * @author macnonline
 * @link http://macnonline
 */
public class GameTable {
    private final Sign[][] table = {
            {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
            {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
            {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
            {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
            {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
            {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
            {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY}
    };



    public boolean isEmpty(final Cell cell){
        return table[cell.getCol()][cell.getRow()]==EMPTY;
    }

    public Sign getSign(final Cell cell){
        return table[cell.getCol()][cell.getRow()];
    }

    public void setSign(final Cell cell,final Sign sign){
        table[cell.getCol()][cell.getRow()]=sign;
    }

}
