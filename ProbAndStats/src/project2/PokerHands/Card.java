package project2.PokerHands;

public class Card {
	private String suit;
	private int value;
	
	public Card(int val, String newSuit) {
		suit = newSuit;
		value = val;
	}

	public String getSuit() {
		return suit;
	}

	public int getValue() {
		return value;
	}
	
	public void show() {
		String newValue = value + "";
		if(value == 1) {
			newValue = "Ace";
		}else if(value == 11) {
			newValue = "Jack";
		}else if(value == 12) {
			newValue = "Queen";
		}else if(value == 13) {
			newValue = "King";
		}
		System.out.println(newValue + " of " + suit);
	}
}
