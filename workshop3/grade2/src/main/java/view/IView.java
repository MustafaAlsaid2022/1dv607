package view;

public interface IView {


	void DisplayWelcomeMessage();

	int GetInput();

	void DisplayCard(model.Card a_card);

	void DisplayPlayerHand(Iterable<model.Card> a_hand, int a_score);

	void DisplayDealerHand(Iterable<model.Card> a_hand, int a_score);

	void DisplayGameOver(int a_dealerIsWinner);

	void notify(String message);

	void DisplayBuffer();
}