package acad.macnonline.gomoku.component;

import static acad.macnonline.gomoku.component.PlayerType.COMPUTER;
import static acad.macnonline.gomoku.component.PlayerType.USER;

/**
 * @author macnonline
 * @link http://macnonline
 */
public class ParserCommandLine {


    private class PlayerTypes {
        private PlayerType playerType1;
        private PlayerType playerType2;

        public PlayerTypes(final String[] args) {
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
                    throw new IllegalArgumentException("Invalid parametr " + arg + ". Should be Computer or User.");
                }
            }
            this.playerType1 = playerType1;
            this.playerType2 = playerType2;
            if (playerType1 == null) {
                this.playerType1 = USER;
                this.playerType2 = COMPUTER;
            }


        }
    }
}
