package ca.bcit.comp2526.tictactoe;

import ca.bcit.comp2526.game.board.Piece;

public class TicTacToePiece
    extends Piece<TicTacToePlayer, String>
{
    public TicTacToePiece(final TicTacToePlayer p)
    {
        super(p);
    }

    @Override
    public String getSymbol()
    {
        final String name;
        name = owner.getName();
        return name;
    }
}
