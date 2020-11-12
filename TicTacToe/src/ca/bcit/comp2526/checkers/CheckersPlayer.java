package ca.bcit.comp2526.checkers;

import ca.bcit.comp2526.game.Player;
import ca.bcit.comp2526.game.Turn;

import java.awt.*;

public class CheckersPlayer extends Player
{
    private final Color color;

    public CheckersPlayer(final String nm)
    {
        super(nm);

        if(nm.toLowerCase().equals("black"))
        {
            color = Color.BLACK;
        }
        else if(nm.toLowerCase().equals("red"))
        {
            color = Color.RED;
        }
        else
        {
            throw new IllegalArgumentException(String.format("nm must be Black or Red was: \"%s\"", nm));
        }
    }

    public Color getColor()
    {
        return color;
    }

    public Turn takeTurn()
    {
        return null;
    }
}
