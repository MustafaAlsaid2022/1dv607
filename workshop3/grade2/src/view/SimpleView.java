package view;

import java.util.LinkedList;
import java.util.List;

public class SimpleView implements IView {
	private List<String> buffer = new LinkedList<>();

	public void DisplayWelcomeMessage() {
		for (int i = 0; i < 50; i++) {
			System.out.print("\n");
		}
		;
		System.out.println("Hello Black Jack World");
		System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
	}

	public int GetInput() {
		try {
			int c = System.in.read();
			while (c == '\r' || c == '\n') {
				c = System.in.read();
			}
			return c;
		} catch (java.io.IOException e) {
			System.out.println("" + e);
			return 0;
		}
	}

	public void DisplayCard(model.Card a_card) {
		System.out.println("" + a_card.GetValue() + " of " + a_card.GetColor());
	}

	public void DisplayPlayerHand(Iterable<model.Card> a_hand, int a_score) {
		DisplayHand("Player", a_hand, a_score);
	}

	public void DisplayDealerHand(Iterable<model.Card> a_hand, int a_score) {
		DisplayHand("Dealer", a_hand, a_score);
	}

	private void DisplayHand(String a_name, Iterable<model.Card> a_hand, int a_score) {
		System.out.println(a_name + " Has: ");
		for (model.Card c : a_hand) {
			DisplayCard(c);
		}
		System.out.println("Score: " + a_score);
		System.out.println("");
	}

	public void DisplayGameOver(int a_dealerIsWinner) {
		System.out.println("GameOver: ");
		if (a_dealerIsWinner == 1) {
			System.out.println("Dealer Won!");
		} else if (a_dealerIsWinner == 0) {
			System.out.println("You Won!");
		} else {
			System.out.println("Equality!");
		}

	}

	@Override
	public void notify(String message) {
		this.buffer.add(message);
	}

	@Override
	public void DisplayBuffer() {
		for(String x:buffer)
			System.out.println(x);
		buffer.clear();

	}

}
