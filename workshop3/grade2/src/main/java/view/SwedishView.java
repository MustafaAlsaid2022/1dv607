package view;

import java.util.LinkedList;
import java.util.List;

public class SwedishView implements IView {
	private List<String> buffer = new LinkedList<>();
	public void DisplayWelcomeMessage() {

		for (int i = 0; i < 50; i++) {
			System.out.print("\n");
		}
		;

		System.out.println("Hej Black Jack Världen");
		System.out.println("----------------------");
		System.out.println("Skriv 'p' för att Spela, 'h' för nytt kort, 's' för att stanna 'q' för att avsluta\n");
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
		if (a_card.GetColor() == model.Card.Color.Hidden) {
			System.out.println("Dolt Kort");
		} else {
			String colors[] = { "Hjärter", "Spader", "Ruter", "Klöver" };
			String values[] = { "två", "tre", "fyra", "fem", "sex", "sju", "åtta", "nio", "tio", "knekt", "dam",
					"kung", "ess" };
			System.out.println("" + colors[a_card.GetColor().ordinal()] + " " + values[a_card.GetValue().ordinal()]);
		}
	}

	public void DisplayPlayerHand(Iterable<model.Card> a_hand, int a_score) {
		DisplayHand("Spelare", a_hand, a_score);
	}

	public void DisplayDealerHand(Iterable<model.Card> a_hand, int a_score) {
		DisplayHand("Croupier", a_hand, a_score);
	}

	public void DisplayGameOver(int a_dealerIsWinner) {
		System.out.println("Slut: ");
		if (a_dealerIsWinner == 1) {
			System.out.println("Croupiern Vann!");
		} else if (a_dealerIsWinner == 0) {
			System.out.println("Du vann!");
		} else {
			System.out.println("K�nen!");
		}
	}

	private void DisplayHand(String a_name, Iterable<model.Card> a_hand, int a_score) {
		System.out.println(a_name + " Har: " + a_score);
		for (model.Card c : a_hand) {
			DisplayCard(c);
		}
		System.out.println("Poäng: " + a_score);
		System.out.println("");
	}
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
