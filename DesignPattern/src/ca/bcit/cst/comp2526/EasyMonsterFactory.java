package ca.bcit.cst.comp2526;

import ca.bcit.cst.comp2526.characters.Monster;
import ca.bcit.cst.comp2526.characters.Rat;

public class EasyMonsterFactory implements MonsterFactory
{

    @Override
    public Monster create() {
        return new Rat();
    }
}
