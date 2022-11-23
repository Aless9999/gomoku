package acad.macnonline.gomoku.component;

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

        if (playerType1 == null) {
            return new PlayerTypes(USER, COMPUTER);

        } else if (playerType2 == null) {
            return new PlayerTypes(USER, playerType1);
        } else {
            return new PlayerTypes(playerType1, playerType2);
        }


    }

    public static class PlayerTypes {
        private final PlayerType playerType1;
        private final PlayerType playerType2;

        public PlayerType getPlayerType1() {
            return playerType1;
        }

        public PlayerType getPlayerType2() {
            return playerType2;
        }

        private PlayerTypes(PlayerType playerType1, PlayerType playerType2) {
            this.playerType1 = playerType1;
            this.playerType2 = playerType2;
        }
    }
}
