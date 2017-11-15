package model;

import controller.DealerObs;
import controller.DealerWinHandler;
import controller.ObsEntity;
import controller.Observable;
import controller.PlayerObs;
import model.rules.*;

public class Dealer extends Player {

	private Observable obs;
	private ObsEntity player_obs;
	private ObsEntity dealer_obs;
	private Deck m_deck;
	private INewGameStrategy m_newGameRule;
	private IHitStrategy m_hitRule;
	private boolean already_stand = false;

	public Dealer(RulesFactory a_rulesFactory) {

		m_newGameRule = a_rulesFactory.GetNewGameRule();
		m_hitRule = a_rulesFactory.GetHitRule();
		m_win_handler = new DealerWinHandler(this.g_maxScore);
		dealer_obs = new DealerObs();
		player_obs = new PlayerObs();
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
			player_obs.update("The player picked another card");

			return true;
		}
		return false;
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
				dealer_obs.update("The dealer picked another card");
			}
		}
		return true;
	}

}