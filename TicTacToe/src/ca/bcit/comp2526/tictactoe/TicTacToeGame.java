package ca.bcit.comp2526.tictactoe;

import ca.bcit.comp2526.game.board.BoardGame;

import java.util.Random;

public class TicTacToeGame
    extends BoardGame<TicTacToePlayer>
{

    protected TicTacToeGame()
    {
        this(new TicTacToePlayer("X"),
                new TicTacToePlayer("O"));
    }

    protected TicTacToeGame(final TicTacToePlayer playerA,
                            final TicTacToePlayer playerB)
    {
        super(playerA, playerB);
    }

    protected boolean isOver()
    {
        final Random random;

        random = new Random();
        return random.nextBoolean();

    }

}
