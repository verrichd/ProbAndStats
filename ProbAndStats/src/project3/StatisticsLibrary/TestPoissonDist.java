package project3.StatisticsLibrary;

/**
 * Example 3.19:
 * Suppose that a random system of police patrol is devised so that a patrol officer
 * may visit a given beat location Y = 0, 1, 2, 3,... times per half hour period, with
 * each location being visited an average of once per time period. Assume that Y possesses, 
 * approximately, a Poisson probability distribution. Calculate the probability
 * that the patrol officer will miss a given location during a half hour period. What is
 * the probability that it will be visited once? Twice? At least once?
 * 
 * Solution: For this example the time period is a half hour, and the mean number of visits per
 * half hour interval is gamma = 1.
 * 
 * @author DominicVerrichia
 *
 */
public class TestPoissonDist {

	public static void main(String[] args) {
		PoissonDistrubution pd = new PoissonDistrubution(1);
		System.out.print("Expected: 0.368 "); pd.pmf(0);
		System.out.print("Expected: 0.368 "); pd.pmf(1);
		System.out.print("Expected: 0.184 "); pd.pmf(2);
		pd.expected();
		pd.variance();
	}

}
