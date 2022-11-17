package acad.macnonline.gomoku;

import acad.macnonline.gomoku.component.CheckWinner;
import acad.macnonline.gomoku.component.ComputerMove;
import acad.macnonline.gomoku.component.DataPrinter;
import acad.macnonline.gomoku.component.UserMove;

/**
 * @author macnonline
 * @link http://macnonline
 */
public class Launcher {
    public static void main(String[] args) {
        Game game = new Game(new ComputerMove(),new DataPrinter(),new CheckWinner(),
                new UserMove());
        game.play();
    }
}
