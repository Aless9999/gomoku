package acad.macnonline.gomoku;

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
