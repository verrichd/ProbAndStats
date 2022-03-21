package project2;

import project1.PermutationsAndCombinations;

/**
 * Has method pmf to solve for probability of an event occurring exactly y times
 * using the gamma value from construction or most recently updated. Gamma is the 
 * average value of occurrences of the desired event over a long period of time.
 * Using this average, the pmf method will return the probability of the desired 
 * event occurring as little as zero times or infinitely higher inputs. Both gamma
 * and y must be positive to return proper results. There is no logical case where 
 * the average number of occurrences (gamma) will be less than zero. Likewise, the 
 * tested amount of occurrences y cannot be negative. 
 * 
 * @author DominicVerrichia
 *
 */
public class PoissonDistrubution {
	private PermutationsAndCombinations pc;
	private double gamma;
	
	/**
	 * Constructs a PoissanDistribution based on the average occurrence 
	 * of desired events over a long time period. Global fields gamma
	 * and PermutaionsAndCombinations are initiated with the parameter 
	 * and Object Construction, respectively.
	 * @param inputGamma is the average number of desired events
	 */
	public PoissonDistrubution(double inputGamma) {
		pc = new PermutationsAndCombinations();
		gamma = inputGamma;
	}
	
	/**
	 * Allows the user to change gamma for an existing PoissanDistribution
	 * as opposed to constructing a new one.
	 * 
	 * @param newGamma is the new average number of desired results. 
	 */
	public void setGamma(double newGamma) {
		gamma = newGamma;
	}
	
	/**
	 * @precondition y and gamma are both positive
	 * 
	 * Uses the Poisson Distribution Probability Mass Function to calculate
	 * the probability which will always fall between 0 and 1 provided the 
	 * input and global variable y and gamma are both positive.
	 * 
	 * @param y is the amount of times the desired event will occur
	 * @return the probability of the desired event occurring exactly y times
	 * @post probability is between 0 and 1
	 */
	public double pmf(int y) {
		double numerator = Math.pow(gamma, y) * Math.exp(-1 * gamma);
		long denom = pc.factorial(y);
		System.out.println("The probability p(" + y + ") = " + numerator / denom);
		return numerator / denom;
	}
	
	/**
	 * The expected value in a Poissan Distribution is always gamma
	 * @return gamma
	 */
	public double expected() {
		System.out.println("The expected value E(Y) = gamma = " + gamma);
		return gamma;
	}
	
	/**
	 * The variance in a Poissan Distribution is always gamma
	 * @return gamma
	 */
	public double variance() {
		System.out.println("The variance V(Y) = gamma = " + gamma);
		return gamma;
	}
}
