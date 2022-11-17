package acad.macnonline.gomoku.model;

import static acad.macnonline.gomoku.model.Sign.EMPTY;

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



    public boolean isEmpty(Cell cell){
        return table[cell.getCol()][cell.getRow()]==EMPTY;
    }

    public Sign getSign(Cell cell){
        return table[cell.getCol()][cell.getRow()];
    }

    public void setSign(Cell cell,Sign sign){
        table[cell.getCol()][cell.getRow()]=sign;
    }

}
