package project2;
import project1.PermutationsAndCombinations;

/**
 * Binomial Distribution calculates probability of a certain event occurring a 
 * given amount of times in a binomial distribution. There are two methods that 
 * return probability using the Probability Mass Function for a Binomial Distribution.
 * The second pmf method has an extra parameter so the user can easily calculate the 
 * probability of a range 'y' successes as opposed to only the exact 'y' successes.
 * There are also methods that will return the Expected Value, Variance, and Standard
 * Deviation given n, p, and q.
 * 
 * @author DominicVerrichia
 *
 */
public class BinomialDistribution {
	private PermutationsAndCombinations<Integer> pnc;
	
	public BinomialDistribution() {
		pnc = new PermutationsAndCombinations<Integer>();
	}
	
	/** 
	 * Calculates the probability mass function of a binomial distribution
	 * given the probability 'p' of the given event happening exactly 'y' amount
	 * of times with 'n' trials.
	 * 
	 * @param n is the number of trials 
	 * @param y is the number of times the desired result will occur
	 * @param p is the probability of the desired result occurring
	 * @return the probability of a given event happening exactly 'y' times
	 */
	public double pmf(int n, int y, double p) {
		
		double q = 1 - p;
		double nChooseY = pnc.combinations(n, y);
		return nChooseY * Math.pow(p, y) * Math.pow(q, n - y);
	}
	
	/** 
	 * Calculates the probability mass function of a binomial distribution
	 * given the probability 'p' of the given event happening between 'y' and
	 * 'bound' amount of times with 'n' trials. This method utilizes another 
	 * pmf method to return calculated values as this method's purpose is to 
	 * recursively handle a less than or greater than 'bound' on the parameter 'y'
	 * 
	 * @param n is the number of trials 
	 * @param y is the number of times the desired result will occurring
	 * @param bound is the bound for y used to find probability of 'y' or more/less successes
	 * @param p is the probability of the desired result occurring
	 * @return the probability of a given event happening between 'y' and 'bound' times
	 */
	
	public double pmf(int n, int y, int bound, double p) {
		
		if(y < bound) {
			return pmf(n,y,p) + pmf(n, y + 1, bound, p);			
		}else if(y > bound) {
			return pmf(n,y,p) + pmf(n,y - 1, bound, p) ;
		}
		return pmf(n,y,p);
	}
	
	/**
	 * Calculates the Expected value of Y in a binomial distribution
	 * @param n
	 * @param p
	 * @return
	 */
	public double expectedValue(int n, int p) {
		return n*p;
	}
	
	/**
	 * Calculates the variance of a binomial distribution given the amount
	 * of trials and the probability of an event happening and q is the probability
	 * of the same event not happening or (1 - p) 
	 * 
	 * @param n is the number of trials 
	 * @param p is the probability of the desired result occurring
	 * @return n * p * q which is the variance of a binomial distribution
	 */
	public double variance(int n, double p) {
		double q = 1 - p;
		return n * p * q;
	}
	
	/**
	 *  Calculates the standard deviation of a binomial distribution using 
	 *  the variance method and raising to a power of 1/2 with Math.pow
	 * @param n is the number of trials 
	 * @param p is the probability of the desired result occurring
	 * @return the square root of the variance which is standard deviation of a binomial distribution
	 */
	public double stdDev(int n, double p) {
		return Math.pow(variance(n,p) , 0.5);
	}
}
