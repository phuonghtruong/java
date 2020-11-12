package ca.bcit.cst.comp2526.characters;

public enum Level {
    EASY(1),
    MEDIUM(5),
    HARD(10);

    private final int value;

    Level(final int val) {value = val;}

    public int getValue() {return value;}
}
