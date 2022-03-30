package project2.PokerHands;

import java.util.Arrays;

/**
 * HandEvaluator has a Deck of Card objects as well as a Card array 
 * named hand> At construction, a new Deck is initialized and shuffled
 * using the methods of the Deck class. Then the hand is initialized using
 * the draw method from deck five times. The integer array 'freq' represents the 
 * frequency of each card face value 0 through 12 as they appear in the hand. This method is
 * called in multiple methods that check for certain poker hands. Every poker hand
 * is evaluated by a method including one pair, two pair, three of a kind, straight,
 * flush, full house, four of a kind, straight flush, and royal flush are in this class.
 * 
 * @author DominicVerrichia
 *
 */
public class HandEvaluator {
	private Deck d;
	private Card[] hand;
	private int[] freq;

	/**
	 * Initializes the three global fields by creating a new
	 * Deck, shuffling it, and populating hand with the top 5
	 * Cards in the Deck. The freq integer array is then populated
	 * based on the contents of hand.
	 */
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

	/**
	 * Used in testing process prints freq array using
	 * toString method from Arrays in Java API to ensure 
	 * the freq array was populated correctly during construction.
	 */
	public void printFreq() {
		System.out.println(Arrays.toString(freq));
	}

	/**
	 * Used in testing process to show the contents of
	 * hand for comparison to method results making use
	 * of the show method in the Card class.
	 */
	public void show() {
		for(Card c : hand) {
			c.show();
		}
	}

	/**
	 * Returns true if the best possible poker hand is a 
	 * pair of cards. First the method checks any of the higher
	 * ranked hands that contain a pair are satisfied. This includes
	 * three of a kind, two pair, full house, and four of a kind. If
	 * any higher ranked method passes, this method will return false.
	 * Provided all higher ranked methods fail, this method will check 
	 * if any element in the freq array is exactly 2. This indicates the
	 * presence of a pair of the same number card.
	 * @return
	 */
	public boolean checkPair() {
		if(checkThreeOfKind() || checkTwoPair() || checkFullHouse() || checkFourOfKind()) {
			return false; 
		}
		for(int i : freq) {
			if(i == 2) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Determines whether a hand is a unique three of a kind meaning
	 * it is not part of a higher ranked hand such as the four of a kind
	 * or full house. This is done by traversing the freq array searching
	 * for a value of exactly 3. This indicates the presence of 3 of the 
	 * same value card. The method will return false in the presence of a 
	 * full house or four of a kind since they rank higher while satisfying
	 * a three of a kind condition.
	 * 
	 * @return true if three of a kind is the highest ranked hand
	 */
	public boolean checkThreeOfKind() {
		if(checkFullHouse() || checkFourOfKind()) {
			return false; 
		}
		for(int i : freq) {
			if(i == 3) {
				return true;
			}
		}
		return false;
	}

	/** 
	 * Determines whether a hand is a unique two pair meaning
	 * it is not part of a higher ranked hand such as the four of a kind
	 * or full house. This is done by traversing the freq array searching
	 * for a value of two and provided a value of two is found, the remaining
	 * freq elements are searched for another two. This indicates the presence
	 * of two distinct pairs of the same value card. The method will return 
	 * false in the presence of a full house or four of a kind since they rank
	 * higher while satisfying the two pair condition.
	 * 
	 * @return true if two pair is the highest ranked hand
	 */
	public boolean checkTwoPair() {
		if(checkFourOfKind() || checkFullHouse()) {
			return false; 
		}
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

	/**
	 * Returns true if all five cards in hand are sequential by first
	 * checking whether freq[0] is 1 which means there is one ace in the 
	 * hand. There are two options that result in a straight when an ace is
	 * present. When this conditional is met, the method will return true if
	 * either condition for high straight or low straight is met. That means freq 
	 * in positions from 0 through 4 were exactly 1 (low straight) [OR] (high straight)
	 * freq at positions 9 through 12 were all exactly 1. After checking for the 
	 * special case with the Ace card, the method iterates through freq[1] through freq[9]
	 * checking for the frequency of cards at position i, i+1, i+2, i+3, and i+4 to be
	 * exactly 1 which would indicate the presence of a straight.
	 * 
	 * @return true when hand contains 5 cards with sequential face values
	 */
	public boolean checkStraight() {
		if(freq[0] == 1) {
			return (freq[1] == 1 && freq[2] == 1 && freq[3] == 1 && freq[4] == 1) || 
					(freq[12] == 1 && freq[11] == 1 && freq[10] == 1 && freq[9] == 1);
		}
		for(int i = 1; i < 10; i++) {
			if(freq[i] == 1) {
				return (freq[i + 1] == 1 && freq[i + 2] == 1 && freq[i + 3] == 1 && freq[i + 4] == 1);
			}
		}
		return false;
	}

	/**
	 * Determines whether hand consists of three cards of the same value
	 * and the other two cards are a pair. This method has two local variables
	 * that indicate whether a pair or three of a kind are present (i.e. a value in freq is
	 * exactly 2 or 3, respectively). 
	 * 
	 * @return true when both threeOfKind and pair boolean values are true
	 */
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

	/**
	 * Determines whether each card in the hand is of the same
	 * suit with use of the Card method getSuit. With use of four
	 * nested if statements, each card is effectively compared to
	 * the first card in the hand. At any point if a card is different
	 * from the rest, the method will return false.
	 * 
	 * @return true when all five Cards in hand are the same suit
	 */
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

	/**
	 * Determines whether four of the same value Card are in 
	 * the hand. This occurs only when freq contains a 4 as one
	 * of its values indicating the same value card appeared four 
	 * times. 
	 * 
	 * @return true if there are four of the same value card in hand
	 */
	public boolean checkFourOfKind() {
		for(int i : freq) {
			if(i == 4) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Determines whether a hand is a special type of straight where
	 * the conditions for the straight and flush are both true. This
	 * method simply returns true when both are true and false otherwise.
	 * 
	 * @return true when a hand is a straight flush
	 */
	public boolean checkStraightFlush() {
		return checkStraight() && checkFlush();
	}

	/**
	 * Determines whether a hand is the most rare hand the Royal Flush
	 * which is the strongest possible hand in poker. This is the Ace high
	 * straight flush (10, Jack, Queen, King, Ace of the same suit). This 
	 * method first checks whether the hand contains an ace with use of 
	 * freq[0] and then returns true only if the values of freq at 
	 * indices 9 through 12 are all exactly 1 and the checkFlush method is true.
	 * 
	 * @return true when hand is the high straight and a flush (Royal Flush)
	 */
	public boolean checkRoyalFlush() {
		if(freq[0] == 1) {
			return (freq[12] == 1 && freq[11] == 1 && freq[10] == 1 && freq[9] == 1) && checkFlush();
		}
		return false;
	}

	

}
