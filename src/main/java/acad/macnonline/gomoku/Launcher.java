package acad.macnonline.gomoku;

import acad.macnonline.gomoku.component.CheckWinner;
import acad.macnonline.gomoku.component.ComputerMove;
import acad.macnonline.gomoku.component.DataPrinter;
import acad.macnonline.gomoku.component.UserMove;
import acad.macnonline.gomoku.model.Player;
import acad.macnonline.gomoku.model.Sign;

/**
 * @author macnonline
 * @link http://macnonline
 */
public class Launcher {
    public static void main(String[] args) {
        Game game = new Game(new DataPrinter(), new CheckWinner(),
                new Player(Sign.O, new ComputerMove()),
                new Player(Sign.X, new UserMove())
        );
        game.play();
    }
}
