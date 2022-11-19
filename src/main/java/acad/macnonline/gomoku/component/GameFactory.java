package acad.macnonline.gomoku.component;

import acad.macnonline.gomoku.Game;
import acad.macnonline.gomoku.model.Player;

import static acad.macnonline.gomoku.component.PlayerType.COMPUTER;
import static acad.macnonline.gomoku.component.PlayerType.USER;
import static acad.macnonline.gomoku.model.Sign.O;
import static acad.macnonline.gomoku.model.Sign.X;

/**
 * @author macnonline
 * @link http://macnonline
 */
public class GameFactory {
    private PlayerType playerType1;
    private PlayerType playerType2;

    public GameFactory(final String[] args) {
        PlayerType playerType1 = null;
        PlayerType playerType2 = null;

        for (String arg : args) {
            if (USER.name().equalsIgnoreCase(arg)) {
                if (playerType1 == null) {
                    playerType1 = PlayerType.valueOf(arg.toUpperCase());
                } else {
                    playerType2 = PlayerType.valueOf((arg.toUpperCase()));
                }

            } else if (COMPUTER.name().equalsIgnoreCase(arg)) {
                if (playerType1 == null) {
                    playerType1 = PlayerType.valueOf(arg.toUpperCase());
                } else {
                    playerType2 = PlayerType.valueOf(arg.toUpperCase());
                }
            } else {
                throw new IllegalArgumentException("Invalid parameter " + arg + ". Should be Computer or User.");
            }
        }
        this.playerType1 = playerType1;
        this.playerType2 = playerType2;
        if (playerType1 == null) {
            this.playerType1 = USER;
            this.playerType2 = COMPUTER;
        }


    }


    public Game create() {
        Player player1;
        Player player2;

        if (playerType1 == USER) {
            player1 = new Player(X, new UserMove());
        } else {
            player1 = new Player(O, new ComputerMove());
        }
        if (playerType2 == COMPUTER) {
            player2 = new Player(O, new ComputerMove());
        } else {
            player2 = new Player(X, new UserMove());
        }

        Game game = new Game(new DataPrinter(), new CheckWinner(),

                player1, player2);


        return game;
    }

}
