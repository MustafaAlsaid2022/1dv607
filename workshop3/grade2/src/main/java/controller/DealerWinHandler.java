package controller;

public class DealerWinHandler implements WinHandler{
	public DealerWinHandler(int max){
		this.max=max;
	}
	protected int max;
	protected int d_score;
	public void setScore(int score) {
		d_score=score;
	}
	
}
