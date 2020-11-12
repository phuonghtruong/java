package ca.bcit.comp2526.checkers;

import ca.bcit.comp2526.game.board.Piece;

import java.awt.*;

public class CheckersPiece extends Piece <CheckersPlayer, Color>
{
    public CheckersPiece(final CheckersPlayer p) { super(p);}

    @Override
    public Color getSymbol()
    {
        final Color name;

        name = owner.getColor();

        return name;
    }
}
