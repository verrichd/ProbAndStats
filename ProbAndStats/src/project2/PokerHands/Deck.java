package project2.PokerHands;
/**
* @author DominicVerrichia
*
*/
import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> deck;

	public Deck() {
		deck = new ArrayList<>();
		String[] suits = {"Spade", "Heart", "Club", "Diamond"};
		for(String suit : suits) {
			for(int i = 1; i <= 13; i++) {
				deck.add(new Card(i , suit));
			}
		}
	}

	public ArrayList<Card> getDeck(){
		return deck;
	}
	
	public void showDeck() {
		for(Card c : deck) {
			c.show();
		}
	}

	public void shuffle() {
		Random rng = new Random();
		ArrayList<Card> newDeck = new ArrayList<>();
		for(int i = 52; i > 0; i--) {
			newDeck.add(deck.remove(rng.nextInt(i)));
		}
		deck = newDeck;
	}
	
	public Card draw() {
		return deck.remove(0);
	}
}
