package controller;

import view.IView;

public class Observable {
	private IView view;
	
	public Observable(IView v) {
		this.view = v;
	}
	
	public void notify(String message) {
		view.notify(message);
	}
	
}
