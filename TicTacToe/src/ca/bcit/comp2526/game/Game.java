package ca.bcit.comp2526.game;

public abstract class Game<P extends Player>
{
    protected P playerOne;
    protected P playerTwo;

    protected Game(final P playerA, final P playerb)
    {
        if(playerA == null)
        {
            throw new IllegalArgumentException("PlayerA cannot be null");
        }
        if (playerb == null)
        {
            throw new IllegalArgumentException("PlayerB cannot be null");
        }

        playerOne = playerA;
        playerTwo = playerb;
    }

    public void play()
    {
        while(!isOver())
        {
            Player currentPlayer;
            Turn turn;

            currentPlayer = getNextPlayer();
            System.out.printf(currentPlayer.getName());
            turn = getNextPlayer().takeTurn();
        }
    }

    protected abstract boolean isOver();
    protected abstract P getNextPlayer();
}
