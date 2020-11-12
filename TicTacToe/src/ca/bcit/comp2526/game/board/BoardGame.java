package ca.bcit.comp2526.game.board;

import ca.bcit.comp2526.checkers.CheckersPlayer;
import ca.bcit.comp2526.game.Game;
import ca.bcit.comp2526.game.Player;

public abstract class BoardGame<P extends Player>
    extends Game<P>
{
    private P currentPlayer;

    protected BoardGame(final P playerA,
                        final P playerb) {
        super(playerA, playerb);
    }

    protected P getNextPlayer()
    {
        final P nextPlayer;

        if(currentPlayer == playerOne)
        {
            nextPlayer = playerTwo;
        }
        else if(currentPlayer == playerTwo)
        {
            nextPlayer = playerOne;
        }
        else
        {
            nextPlayer = playerOne;
        }
        currentPlayer = nextPlayer;

        return nextPlayer;
    }
}
