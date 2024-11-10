package action;

import cards.Hero;
import fileio.ActionsInput;
import game.Game;

public class UseHeroAbility implements CommandAction {
    /**
     * Prin aceasta metoda eroul isi foloseste abilitatea
     */
    public void execute(final Game game, final ActionsInput action) {
        Hero hero = game.getPlayer()[game.getPlayerIdxTurn()].getHero();
        int manaPlayer = game.getPlayer()[game.getPlayerIdxTurn()].getMana();
        if (CommandAction.errorManager.handleHeroAbilityError(hero, manaPlayer, action)) {
            return;
        }
        hero.useAbility(game, action, CommandAction.errorManager);
    }
}
