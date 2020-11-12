package ca.bcit.cst.comp2526;

import ca.bcit.cst.comp2526.characters.Dragon;
import ca.bcit.cst.comp2526.characters.Monster;


public class HardMonsterFactory implements MonsterFactory
{

    @Override
    public Monster create() {
        return new Dragon();
    }
}
