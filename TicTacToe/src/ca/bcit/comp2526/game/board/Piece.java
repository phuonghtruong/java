package ca.bcit.comp2526.game.board;

import ca.bcit.comp2526.game.Player;

public abstract class Piece<P extends Player, S>
{
    protected  final P owner;

    protected  Piece(final P p) {owner = p;}

    public P getOwner()
    {
        return owner;
    }

    public abstract S getSymbol();
}
