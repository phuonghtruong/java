package ca.bcit.cst.comp2526;

import ca.bcit.cst.comp2526.characters.Monster;

import java.security.SecureRandom;
import java.util.Random;

public class RandomMonsterFactory
{
    private static final Random RANDOM;

    static
    {
        RANDOM = new SecureRandom();
    }
    public MonsterFactory create()
    {
        final int value;
        final MonsterFactory factory;

        value = RANDOM.nextInt(100) + 1;

        if(value < 33)
        {
            factory = new EasyMonsterFactory();
        }
        else if (value < 66)
        {
            factory = new MediumMonsterFactory();
        }
        else
        {
            factory = new HardMonsterFactory();
        }
        return factory;
    }
}
