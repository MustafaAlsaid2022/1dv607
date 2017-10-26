package model;

import model.rules.*;

public class Dealer extends Player {

	private Deck m_deck;
	private AmericanNewGameStrategy m_newGameRule;
	private IHitStrategy m_hitRule;
	private boolean already_stand = false;

	public Dealer(RulesFactory a_rulesFactory) {

		m_newGameRule = (AmericanNewGameStrategy) a_rulesFactory.GetNewGameRule();
		m_hitRule = a_rulesFactory.GetHitRule();
		/*
		 * for(Card c : m_deck.GetCards()) { c.Show(true); System.out.println("" +
		 * c.GetValue() + " of " + c.GetColor()); }
		 */
	}

	public boolean NewGame(Player a_player) {
		if (m_deck == null || IsGameOver()) {
			already_stand = false;
			m_deck = new Deck();
			ClearHand();
			a_player.ClearHand();
			return m_newGameRule.NewGame(m_deck, this, a_player);
		}
		return false;
	}

	public boolean Hit(Player a_player) {
		if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {

			a_player.pickACard(m_deck,true);
			a_player.notify("The player picked another card");

			return true;
		}
		return false;
	}

	public int IsDealerWinner(Player a_player) {

		int player_score = a_player.CalcScore();
		int dealer_score = CalcScore();

		if (player_score == g_maxScore)
			return 0;

		if (dealer_score == g_maxScore)
			return 1;

		if (player_score > g_maxScore)
			return 1;

		if (dealer_score > g_maxScore)
			return 0;

		if (dealer_score == player_score)
			return 2;

		return dealer_score >= player_score ? 1 : 0;
	}

	public boolean IsGameOver() {
		if (m_deck != null && m_hitRule.DoHit(this) != true && already_stand) {
			return true;
		}
		return false;
	}

	public boolean Stand(Player m_player) {
		already_stand = true;

		if (m_deck != null) {
			this.ShowHand();

			while (m_hitRule.DoHit(this)) {
				this.pickACard(m_deck,true);
				this.notify("The dealer picked another card");
			}
		}
		return true;
	}

}