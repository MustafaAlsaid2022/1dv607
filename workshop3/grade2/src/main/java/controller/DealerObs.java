package controller;

public class DealerObs implements ObsEntity {
	private String msg;
	@Override
	public void update(String msg) {
		this.msg = msg;
		
	}

	@Override
	public String getState() {
		String tmp = msg;
		msg = "";
		return tmp;
	}

}
