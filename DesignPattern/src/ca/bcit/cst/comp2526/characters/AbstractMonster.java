package ca.bcit.cst.comp2526.characters;

public class AbstractMonster implements Monster{
    private final Level level;
    private final MonsterType type;

    protected AbstractMonster(final Level lvl,
                              final MonsterType ty)
    {
        level = lvl;
        type = ty;
    }

    public Level getLevel() {return level;}

    public MonsterType getType() { return type;}

    @Override
    public String toString()
    {
        return String.format("%s (%d)", type.getName(), level.getValue());
    }
}
