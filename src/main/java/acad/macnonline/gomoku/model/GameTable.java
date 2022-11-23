package acad.macnonline.gomoku.model;

import acad.macnonline.gomoku.component.SizeTable;

/**
 * @author macnonline
 * @link <a href="http://macnonline">online</a>
 */

public class GameTable {
    SizeTable size = new SizeTable();
    private final Sign[][] table = new Sign[SizeTable.size][SizeTable.size];


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
