import controller.Observable;
import controller.PlayGame;
import controller.WinHandler;
import model.Game;
import view.IView;
import view.SimpleView;

public class Program {

	public static void main(String[] a_args) {
		IView v = new SimpleView(); // new SwedishView();
		Observable o = new Observable(v);	
		Game g = new Game(o);		
		PlayGame ctrl = new PlayGame();

		while (ctrl.Play(g, v))
			;
	}
}