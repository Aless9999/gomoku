package acad.macnonline.gomoku;

import acad.macnonline.gomoku.component.CheckWinner;
import acad.macnonline.gomoku.component.ComputerMove;
import acad.macnonline.gomoku.component.DataPrinter;
import acad.macnonline.gomoku.component.UserMove;
import acad.macnonline.gomoku.model.GameTable;
import acad.macnonline.gomoku.model.Player;

import java.util.Random;

import static acad.macnonline.gomoku.model.Sign.O;
import static acad.macnonline.gomoku.model.Sign.X;

/**
 * @author macnonline
 * @link http://macnonline
 */
public class Game {
    GameTable gameTable = new GameTable();

    private final ComputerMove computerMove;
    private final DataPrinter dataPrinter;
    private final CheckWinner checkWinner;
    private final UserMove userMove;

    public Game(ComputerMove computerMove, DataPrinter dataPrinter,
                CheckWinner checkWinner, UserMove userMove) {
        this.computerMove = computerMove;
        this.dataPrinter = dataPrinter;
        this.checkWinner = checkWinner;
        this.userMove = userMove;
    }

    void play() {
        if (new Random().nextBoolean()) {
//            computerMove.makeMove(gameTable);
            dataPrinter.mapGame(gameTable);
        }
        final Player[] players = {new Player(X, userMove), new Player(O, computerMove)};
        while (true) {
            for (Player player : players) {
                player.getMove().makeMove(gameTable, player.getSign());
                dataPrinter.mapGame(gameTable);
                if (checkWinner.isWin(gameTable, player)) {
                    System.out.println(player.getSign() + " is WINNER!!!");
                    System.out.println("GAME OVER!");
                    return;
                } else if (checkWinner.isDraw(gameTable)) {
                    System.out.println("Sorry is Draw");
                    System.out.println("GAME OVER!");
                    return;
                }
            }
        }
    }
}

