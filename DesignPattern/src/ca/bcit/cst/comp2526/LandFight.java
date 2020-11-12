package ca.bcit.cst.comp2526;

import ca.bcit.cst.comp2526.characters.Monster;
import ca.bcit.cst.comp2526.characters.Player;

public class LandFight implements Fight
{
    @Override
    public void fight(final Player player, final Monster monster) {
        player.attack(monster);
        player.defend(monster);
    }
}
