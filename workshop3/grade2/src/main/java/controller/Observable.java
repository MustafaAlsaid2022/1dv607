package controller;

import view.IView;

public class Observable {
	private IView view;

	public Observable(IView v) {
		this.view = v;
	}

	public void notify(ObsEntity dealer, ObsEntity player) {
		String d = dealer.getState(), p = player.getState();
		if (d != "")
			view.notify(d);
		if (p != null)
			view.notify(p);
	}

}
