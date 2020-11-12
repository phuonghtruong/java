package ca.bcit.comp2526.checkers;

import ca.bcit.comp2526.game.Player;
import ca.bcit.comp2526.game.board.BoardGame;
import ca.bcit.comp2526.tictactoe.TicTacToePlayer;

import java.util.Random;

public class CheckersGame
    extends BoardGame<CheckersPlayer>
{
    protected CheckersGame()
    {
        this(new CheckersPlayer("Red"),
                new CheckersPlayer("Black"));
    }

    protected CheckersGame(final CheckersPlayer playerA,
                            final CheckersPlayer playerB)
    {
        super(playerA, playerB);
    }

    @Override
    protected boolean isOver()
    {
        final Random random;

        random = new Random();
        return random.nextBoolean();

    }
}
