package acad.macnonline.gomoku.component;

import acad.macnonline.gomoku.Game;
import acad.macnonline.gomoku.component.strategies.*;
import acad.macnonline.gomoku.model.Player;

import static acad.macnonline.gomoku.component.LevelGame.LEVEL2;
import static acad.macnonline.gomoku.component.PlayerType.COMPUTER;
import static acad.macnonline.gomoku.component.PlayerType.USER;
import static acad.macnonline.gomoku.model.Sign.O;
import static acad.macnonline.gomoku.model.Sign.X;

/**
 * @author macnonline
 * @link http://macnonline
 */
public class GameFactory {
    private final PlayerType playerType1;
    private final PlayerType playerType2;
    private final LevelGame levelGame;

    public GameFactory(final String[] args) {
        final ParserCommandLine parser = new ParserCommandLine(args);
        ParserCommandLine.PlayerTypes playerTypes = parser.parser();

        this.playerType1 = playerTypes.getPlayerType1();
        this.playerType2 = playerTypes.getPlayerType2();
        this.levelGame = playerTypes.getLevelGame();
    }


    public Game create() {
        final StrategyMoveComputer[] strategies;

        if (levelGame == LEVEL2) {
            strategies = new StrategyMoveComputer[]{
                    new WinnerMoveComputer(),
                    new NotWinnerOpponent(),
                    new SearchThreeSignOpponent(),
                    new ThreeAllMove(),
                    new TooAllMove(),
                    new OneAllMove(),
                    new RandomComputerMove()
            };
        } else {
            strategies = new StrategyMoveComputer[]{new RandomComputerMove()};
        }

        final GameWindow gameWindow = new GameWindow();
        Player player1;
        Player player2;

        if (playerType1 == USER) {
            player1 = new Player(X, new UserMove(gameWindow));
        } else {
            player1 = new Player(X, new ComputerMove(strategies));
        }
        if (playerType2 == COMPUTER) {
            player2 = new Player(O, new ComputerMove(strategies));
        } else {
            player2 = new Player(O, new UserMove(gameWindow));
        }
        return new Game(gameWindow, new CheckWinner(),

                player1, player2);
    }
}
