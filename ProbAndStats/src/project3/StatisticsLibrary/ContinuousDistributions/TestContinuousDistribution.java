package project3.StatisticsLibrary.ContinuousDistributions;

import java.util.ArrayList;
/**
 * Demonstrates the working functionalities of ContinuousDistribution class.
 * Finds probability of random variable Y falling in a range of values. 
 * Models problem 4.19 parts a & b and problem 4.25 in the textbook. This tester 
 * demonstrates the construction of a ContinuousDistribution given lists of parameters 
 * for the coefficients and bounds as opposed to the construction using scanner input.
 *
 * @author Dominic Verrichia
 *
 */
public class TestContinuousDistribution {

	public static void main(String[] args) {
		String[] eqns = {"0","0,0.125","0,0,0.0625","1"};
		String[] bounds = {"-1000,0","0,2","2,4","4,1000"};
		ContinuousDistribution cd = new ContinuousDistribution(eqns,bounds,true);
		cd.printFunction("Y");
		cd.printDensityFunction("Y");
		System.out.println("P(1<Y<3) = " + cd.probability(1,3));
		System.out.println("E(Y) = " + cd.expected());
	}

}
