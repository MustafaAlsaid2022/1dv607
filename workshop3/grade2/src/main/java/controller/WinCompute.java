package controller;

public abstract class WinCompute implements WinHandler {
	public static int winner(WinHandler d, WinHandler p) {
		int dres;
		int player_score = ((PlayerWinHandler)p).p_score;
		int dealer_score = ((DealerWinHandler) d).d_score;
		final int g_max_score = ((DealerWinHandler) d).max;
		
		if (player_score == g_max_score)
			dres = 0;

		if (dealer_score == g_max_score)
			dres = 1;

		if (player_score > g_max_score)
			dres = 1;

		if (dealer_score > g_max_score)
			dres = 0;

		if (dealer_score == player_score)
			dres = 2;

		return dealer_score >= player_score ? 1 : 0;
	}
}
