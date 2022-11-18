package acad.macnonline.gomoku;

import acad.macnonline.gomoku.component.*;
import acad.macnonline.gomoku.model.GameTable;

import java.util.Random;

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
            computerMove.makeMove(gameTable);
            dataPrinter.mapGame(gameTable);
        }
        final Move[] moves = {userMove, computerMove};

        while (true) {
            for (Move move : moves) {
                move.makeMove(gameTable);
                dataPrinter.mapGame(gameTable);
                if (checkWinner.isWin(gameTable)) {
                    System.out.println("Computer is Win");
                    return;
                } else if (checkWinner.isDraw(gameTable)) {
                    System.out.println("Sorry is Draw");
                    return;
                }
            }
        }
    }
}

