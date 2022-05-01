package project3.StatisticsLibrary;

/**
 * This tester will be used to find the answers to textbook exercise 3.43 
 * alongside the expected answers taken from the solutions in the book.
 * 
 * Below is problem 3.43 from the textbook
 * 
 * 3.43) Many utility companies promote energy conservation by offering discount rates to consumers
 * who keep their energy usage below certain established subsidy standards. A recent EPA report
 * notes that 70% of the island residents of Puerto Rico have reduced their electricity usage
 * sufficiently to qualify for discounted rates. If five residential subscribers are randomly selected
 * from San Juan, Puerto Rico, find the probability of each of the following events:
 * 
 * a All five qualify for the favorable rates.
 * b At least four qualify for the favorable rates
 * 
 * @author DominicVerrichia
 *
 */
public class TestBinomialDistribution {

	public static void main(String[] args) {
		BinomialDistribution bnd = new BinomialDistribution();
		System.out.println("a) Probability all 5 qualified: " + String.format("%.4f",bnd.pmf(5, 5, 0.7)) + " Expected: 0.1681");
		System.out.println("b) Probability at least 4 qualified: " + String.format("%.4f",bnd.pmf(5, 4, 5, 0.7)) + " Expected: 0.5282");
		
	}

}
