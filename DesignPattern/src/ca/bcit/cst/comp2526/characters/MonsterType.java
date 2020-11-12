package ca.bcit.cst.comp2526.characters;

public enum MonsterType {
    RAT("Rat"),
    SKELETON("Skeleton"),
    DRAGON("Dragon");

    private final String name;

    MonsterType (final String nm) { name = nm;}

    public String getName() {return name;}

    public MonsterType from(final String name)
    {
        final MonsterType type;

        switch (name)
        {
            case "Rat":
                type = RAT;
                break;
            case "Skeleton":
                type = SKELETON;
                break;
            case "Dragon":
                type = DRAGON;
                break;
            default:
                throw new RuntimeException();
        }
        return type;
    }
}
