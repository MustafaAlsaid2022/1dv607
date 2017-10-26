package model.rules;

import model.Deck;
import model.Dealer;
import model.Player;
import model.Card;

class InternationalNewGameStrategy implements INewGameStrategy {

	public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
		a_player.pickACard(a_deck, true);

		a_dealer.pickACard(a_deck, true);

		a_player.pickACard(a_deck, true);

		return true;
	}
}