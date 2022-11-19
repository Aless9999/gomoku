package acad.macnonline.gomoku;

import acad.macnonline.gomoku.component.CheckWinner;
import acad.macnonline.gomoku.component.DataPrinter;
import acad.macnonline.gomoku.model.GameTable;
import acad.macnonline.gomoku.model.Player;

import java.util.Random;

/**
 * @author macnonline
 * @link http://macnonline
 */
public class Game {
    GameTable gameTable = new GameTable();

    private final DataPrinter dataPrinter;
    private final CheckWinner checkWinner;
    private final Player player1;
    private final Player player2;

    public Game(DataPrinter dataPrinter, CheckWinner checkWinner, Player player1, Player player2) {
        this.dataPrinter = dataPrinter;
        this.checkWinner = checkWinner;
        this.player1 = player1;
        this.player2 = player2;
    }


    public void play() {
        if (new Random().nextBoolean()) {
            player2.getMove().makeMove(gameTable, player2.getSign());
            dataPrinter.mapGame(gameTable);
        }
        final Player[] players = {player1, player2};
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

