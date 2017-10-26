package model.rules;

import model.Player;

class BasicHitStrategy implements IHitStrategy {
	private final int g_hitLimit = 17;

	public boolean DoHit(Player a_dealer) {
		int score = a_dealer.CalcScore();

		if (score < g_hitLimit)
			return true;
		else if (score == g_hitLimit && a_dealer.hadAnAce()) // soft 17
			return true;
		
		return false;
	}

}