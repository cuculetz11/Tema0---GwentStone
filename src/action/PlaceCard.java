package action;

import cards.Minion;
import fileio.ActionsInput;
import game.Game;
import game.GameTable;
import players.Player;

public class PlaceCard implements CommandAction {
    /**
     * Prin aceasta metoda se pune o carte pe masa
     * @param game jocul actiual
     * @param action actiunea de la input
     */
    public void execute(final Game game, final ActionsInput action) {
        int handIdx = action.getHandIdx();
        Player p = game.getPlayer()[game.getPlayerIdxTurn()];
        Minion card = p.getHand().get(handIdx);
        if (CommandAction.errorManager.handlePlaceCardError(p, card, handIdx,
                game.getPlayerIdxTurn())) {
            return;
        }
        if (card.isFront()) {
            GameTable.getInstance().getPlayerFrontRow()[game.getPlayerIdxTurn()].add(card);
        } else {
            GameTable.getInstance().getPlayerBackRow()[game.getPlayerIdxTurn()].add(card);
        }
        p.getHand().remove(handIdx);
        p.setMana(p.getMana() - card.getMana());
    }
}
