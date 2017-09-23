package workshop2.grade2;

import workshop2.grade2.view.IView;
import workshop2.grade2.view.View;

public class App {
	
	public static void main(String[] args) {
		IView view = new View();
		view.start();
	}
}
