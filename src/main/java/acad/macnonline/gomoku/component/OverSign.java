package acad.macnonline.gomoku.component;

import acad.macnonline.gomoku.model.Sign;

import static acad.macnonline.gomoku.model.Sign.O;
import static acad.macnonline.gomoku.model.Sign.X;

/**
 * @author macnonline
 * @link http://macnonline
 */
public class OverSign {
    protected Sign overSign(Sign sign) {
        if (sign == X) {
            return O;
        }
        return X;
    }
}
