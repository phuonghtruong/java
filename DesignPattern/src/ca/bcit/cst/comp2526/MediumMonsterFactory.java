package ca.bcit.cst.comp2526;

import ca.bcit.cst.comp2526.characters.Monster;
import ca.bcit.cst.comp2526.characters.Skeleton;

public class MediumMonsterFactory implements MonsterFactory
{

    @Override
    public Monster create() {
        return new Skeleton();
    }
}
