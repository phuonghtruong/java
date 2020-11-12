package ca.bcit.cst.comp2526;

import ca.bcit.cst.comp2526.characters.Level;
import ca.bcit.cst.comp2526.characters.Monster;
import ca.bcit.cst.comp2526.characters.Player;
import ca.bcit.cst.comp2526.characters.Rat;

public class Game {
    public static void main(String[] args)
    {
        final RandomMonsterFactory factoryGenerator;
        final MonsterFactory factory;
        final Monster monster;
        final Player player;
        final Fight fight;

        factoryGenerator = new RandomMonsterFactory();

        monster = createMonster(factoryGenerator);
        player = new Player("Brian");
        fight = new LandFight() ;
        play(fight, player, monster);
    }

    private static void play(final Fight fight,
                             final Player player,
                             final Monster monster)
    {
        fight.fight(player, monster);
    }
    private static Monster createMonster(RandomMonsterFactory factoryGenerator)
    {
        final MonsterFactory factory;
        final Monster monster;
        factory = factoryGenerator.create();
        monster = createMonster(factory);
        return monster;
    }
    private static Monster createMonster (final MonsterFactory factory)
    {
        final Monster monster;
        monster = factory.create();
        return monster;
    }

    private static Monster create(final Level level)
    {
        final Monster monster;

        switch(level)
        {
            case EASY:
            {
                monster = new Rat();
                break;
            }
            default:
                throw new RuntimeException();
        }
        return monster;
    }
}
