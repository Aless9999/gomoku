package acad.macnonline.gomoku.model;

import acad.macnonline.gomoku.component.SizeTable;

/**
 * @author macnonline
 * @link http://macnonline
 */

public class GameTable {
    SizeTable size = new SizeTable();
    private final Sign[][] table = new Sign[size.size][size.size];


    public boolean isEmpty(final Cell cell) {
        return table[cell.getCol()][cell.getRow()] == null;
    }

    public Sign getSign(final Cell cell) {
        return table[cell.getCol()][cell.getRow()];
    }

    public void setSign(final Cell cell,final Sign sign){
        table[cell.getCol()][cell.getRow()]=sign;
    }

}
