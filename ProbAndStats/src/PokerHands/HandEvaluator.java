package PokerHands;
/**
 * @author DominicVerrichia
 *
 */
public class HandEvaluator {
	private Deck d;
	private Card[] hand;
	private int[] freq;

	public HandEvaluator() {
		d = new Deck();
		d.shuffle();
		hand = new Card[5];
		for(int i = 0; i < 5; i++) {
			hand[i] = d.draw();
		}
		freq = new int[13];
		for(Card c : hand) {
			freq[c.getValue() - 1]++;
		}
	}

	public void show() {
		for(Card c : hand) {
			c.show();
		}
	}

	public boolean checkPair() {
		for(int i : freq) {
			if(i == 2) {
				return true;
			}
		}
		return false;
	}

	public boolean checkThreeOfKind() {
		for(int i : freq) {
			if(i == 3) {
				return true;
			}
		}
		return false;
	}

	public boolean checkTwoPair() {
		for(int i = 0; i < freq.length; i++) {
			if(freq[i] == 2) {
				for(int j = i + 1; j < freq.length; j++) {
					if(freq[j] == 2) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean checkStraight() {
		int highCardIndex = 12;
		int lowCardIndex = 0;
		for(int i = 12; i > 0; i--) {
			if(freq[i] > 1) {
				return false;
			}
			if(freq[i] == 1) {
				highCardIndex = i;
				break;
			}
		}
		for(int i = 0; i < 13; i++) {
			if(freq[i] > 1) {
				return false;
			}
			if(freq[i] == 1) {
				lowCardIndex = i;
				break;
			}
		}

		return (freq[lowCardIndex + 1] == 1 && freq[lowCardIndex + 2] == 1 && freq[lowCardIndex + 3] == 1);
	}

	public boolean checkFullHouse() {
		boolean threeOfKind = false;
		boolean pair = false; 
		for(int i : freq) {
			if(i == 3) {
				threeOfKind = true;
			}
		}
		if(threeOfKind) {
			for(int i : freq) {
				if(i == 2) {
					pair = true;
				}
			}
		}
		return (pair && threeOfKind);
	}

	public boolean checkFlush() {
		if(hand[0].getSuit() == hand[1].getSuit()) {
			if(hand[1].getSuit() == hand[2].getSuit()) {
				if(hand[2].getSuit() == hand[3].getSuit()) {
					if(hand[3].getSuit() == hand[4].getSuit()) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean checkFourOfKind() {
		int[] freq = new int[13];
		for(Card c : hand) {
			freq[c.getValue() - 1]++;
		}
		for(int i : freq) {
			if(i == 4) {
				return true;
			}
		}
		return false;
	}

	public boolean checkStraightFlush() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean checkRoyalFlush() {

		return false;
	}



}
