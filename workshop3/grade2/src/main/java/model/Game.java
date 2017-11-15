package model;

import controller.Observable;
import controller.WinCompute;

public class Game {

	private Dealer m_dealer;
	private Player m_player;
	private Observable m_obs;

	public Game(Observable o) {
		m_dealer = new Dealer(new model.rules.RulesFactory());
		m_player = new Player();

		m_obs = o;

	}

	public int ComputeRes() {
		return WinCompute.winner(m_dealer.getWinHandler(), m_player.getWinHandler());
	}

	public boolean IsGameOver() {
		return m_dealer.IsGameOver();
	}

	public boolean NewGame() {
		return m_dealer.NewGame(m_player);
	}

	public boolean Hit() {
		return m_dealer.Hit(m_player);
	}

	public boolean Stand() {
		return m_dealer.Stand(m_player);
	}

	public Iterable<Card> GetDealerHand() {
		return m_dealer.GetHand();
	}

	public Iterable<Card> GetPlayerHand() {
		return m_player.GetHand();
	}

	public int GetDealerScore() {
		return m_dealer.CalcScore();
	}

	public int GetPlayerScore() {
		return m_player.CalcScore();
	}

}