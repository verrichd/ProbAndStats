package PokerHands;

public class ProbabilitySimulation {
	private int[] results;
	private int iterations;
	
	public ProbabilitySimulation(int iterations) {
		results = new int[9];
		this.iterations = iterations;
		for(int i = 0; i < iterations; i ++){
			HandEvaluator h = new HandEvaluator();
			if(h.checkFlush()) {
				results[4]++;
			}if(h.checkFourOfKind()) {
				results[6]++;
			}if(h.checkFullHouse()) {
				results[5]++;
			}if(h.checkPair()) {
				results[0]++;
			}if(h.checkStraight()) {
				results[3]++;
			}if(h.checkThreeOfKind()) {
				results[2]++;
			}if(h.checkTwoPair()) {
				results[1]++;
			}if(h.checkStraightFlush()) {
				results[7]++;
			}if(h.checkRoyalFlush()) {
				results[8]++;
			}
		}
	}
	
	public void runSimulation() {
		String[] actual = {"42.2569%", "4.7539%","2.1128%", "0.3925%","0.1965%","0.1441%","0.02401%","0.00139%","0.000154%"};
		String[] handName = {"pair","two pair","three of a kind","straight","flush","full house","four of a kind", "straight flush", "royal flush"};
		System.out.println("Probability of a ...");
		for(int i = 0; i < results.length; i++) {
			double probability = (double) results[i] / iterations;
			probability = probability * 100;
			System.out.printf("%-15s" , handName[i] );
			System.out.println( ": " + probability + "%, Expected: " + actual[i]);
		}
	}
}
