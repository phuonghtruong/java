package ca.bcit.cst.comp2526.characters;

public class Player implements GameCharacter{
    private final String name;
    private int level;

    {
        level = 1;
    }
    public Player(final String nm)
    {
        name = nm;
    }

    public void attack(final Monster monster)
    {
        System.out.printf("Attachking a level %d %s%n",
                monster.getLevel().getValue(),
                monster.getType().getName());
    }

    public void defend(final Monster monster)
    {
        System.out.printf("Defending against a level %d %s%n",
                monster.getLevel().getValue(),
                monster.getType().getName());
    }
}
