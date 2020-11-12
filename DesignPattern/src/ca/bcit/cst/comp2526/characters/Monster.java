package ca.bcit.cst.comp2526.characters;

public interface Monster extends GameCharacter {
    Level getLevel();
    MonsterType getType();
}
