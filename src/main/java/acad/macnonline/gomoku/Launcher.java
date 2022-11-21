package acad.macnonline.gomoku;

import acad.macnonline.gomoku.component.GameFactory;

/**
 * @author macnonline
 *http://macnonline
 */
public class Launcher {
    public static void main(String[] args) {
        final GameFactory gameFactory = new GameFactory(args);
        final Game game = gameFactory.create();
        game.play();
    }
}
