package controller;

public class PlayerWinHandler implements WinHandler{

	protected int p_score;
	protected int max;
	
	public PlayerWinHandler(int max){
		this.max=max;
	}
	public void setScore(int score) {
		p_score=score;
	}
	
}
