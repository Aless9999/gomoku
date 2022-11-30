package acad.macnonline.gomoku.component;

import static acad.macnonline.gomoku.component.LevelGame.LEVEL1;
import static acad.macnonline.gomoku.component.LevelGame.LEVEL2;
import static acad.macnonline.gomoku.component.PlayerType.COMPUTER;
import static acad.macnonline.gomoku.component.PlayerType.USER;

/**
 * @author macnonline
 * @link http://macnonline
 */
public class ParserCommandLine {
    private final String[] args;

    public ParserCommandLine(String[] args) {
        this.args = args;
    }


    public PlayerTypes parser() {
        PlayerType playerType1 = null;
        PlayerType playerType2 = null;
        LevelGame levelGame = null;

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
            } else if (LEVEL1.name().equalsIgnoreCase(arg)) {
                levelGame = LevelGame.valueOf(arg.toUpperCase());
            } else if (LEVEL2.name().equalsIgnoreCase(arg)) {
                levelGame = LevelGame.valueOf(arg.toUpperCase());

            } else {
                throw new IllegalArgumentException("Invalid parameter " + arg + ". Should be Computer or User.");
            }
        }
        if (levelGame == null) {
            levelGame = LEVEL2;
        }

        if (playerType1 == null) {
            return new PlayerTypes(USER, COMPUTER, levelGame);

        } else if (playerType2 == null) {
            return new PlayerTypes(USER, playerType1, levelGame);
        } else {
            return new PlayerTypes(playerType1, playerType2, levelGame);
        }


    }

    public static class PlayerTypes {
        private final PlayerType playerType1;
        private final PlayerType playerType2;
        private final LevelGame levelGame;

        public PlayerTypes(PlayerType playerType1, PlayerType playerType2, LevelGame levelGame) {
            this.playerType1 = playerType1;
            this.playerType2 = playerType2;
            this.levelGame = levelGame;
        }

        public PlayerType getPlayerType1() {
            return playerType1;
        }

        public PlayerType getPlayerType2() {
            return playerType2;
        }

        public LevelGame getLevelGame() {
            return levelGame;
        }


    }
}
