package project3.StatisticsLibrary.ContinuousDistributions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.integration.SimpsonIntegrator;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
/**
 * ContinuousDistribution models the probability of a continuous random variable 
 * described by either a Distribution function or density function. During construction,
 * there is a boolean parameter to determine this option. There are two constructors for 
 * this class that either accept Lists of input for the coefficients and bounds in a piecewise
 * defined function or prompts this input using the Scanner. There are two print methods for 
 * displaying the distribution function (if applicable) and density function denoted by 'F' 
 * for the distribution function and 'f' for the density function. 
 * 
 * @author Dominic Verrichia
 *
 */
public class ContinuousDistribution {
	private HashMap<UnivariateFunction,double[]> piecewise;
	private SimpsonIntegrator it;
	private boolean distributionFunction;
	
	/**
	 * Constructs a Continuous Distribution using a Scanner for input of 
	 * the coefficients and bounds of each piece to the function.
	 */
	public ContinuousDistribution() {
		it = new SimpsonIntegrator();
		piecewise = new HashMap<>();
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter 0 for Distribution Function and 1 for Density Function:");
		String t = scn.nextLine();
		distributionFunction = t.equals("0");
		while(true) {
			
			System.out.println("Function coefficents:(by power of variable in ascending order separated by a comma)");
			System.out.println("Enter 'q' after finished entering all functions");

			String input = scn.nextLine();
			if(input.equals("q")) {
				scn.close();
				return;
			}else {
				PolynomialFunction f = new PolynomialFunction(csvToArray(input));
				System.out.println("Enter Bounds:(separated by comma)");
				String limits = scn.nextLine();
				piecewise.put(f,csvToArray(limits));
			}
		}
	}

	/**
	 * Constructs a ContinuousDistribution using two String arrays that represent the coefficients of 
	 * a piecewise defined function in the order x^0, x^1, x^2... and the piece bounds. Whether the
	 * bounds are inclusive or exclusive does not matter in this Distribution as the probability is the 
	 * same regardless.
	 * @param listOfCoefficients sorted in ascending order by power of x
	 * @param pieceBounds inclusion/exclusion does not matter
	 * @param distFunct true when inputting a Distribution Function, false when Density Function
	 */
	public ContinuousDistribution(String[] listOfCoefficients,String[] pieceBounds,boolean distFunct) {
		distributionFunction = distFunct;
		it = new SimpsonIntegrator();
		piecewise = new HashMap<>();
		ArrayList<double[]> limits = new ArrayList<>();
		ArrayList<double[]> functions = new ArrayList<>();
		for(String f : listOfCoefficients) {
			functions.add(ContinuousDistribution.csvToArray(f));
		}
		for(String b : pieceBounds) {
			limits.add(ContinuousDistribution.csvToArray(b));
		}
		for(int i = 0; i < limits.size(); i++) {
			UnivariateFunction f = new PolynomialFunction(functions.get(i));
			piecewise.put(f,limits.get(i));
		}
	}
	/**
	 * Provided a distribution function is given at construction, the method getDensityFunction will return a
	 * HashMap of a UnivariateFunction and a double array (same type as global variable piecewise) without
	 * changing piecewise. This method is used in probability, expected, and variance.
	 * @return the probability density function of this ContinuousDistribution
	 */
	public HashMap<UnivariateFunction,double[]> getDensityFunction(){
		if(!distributionFunction) {
			return piecewise;
		}
		HashMap<UnivariateFunction,double[]> density = new HashMap<>();
		Set<Entry<UnivariateFunction, double[]>> functions = piecewise.entrySet();
		for(Entry<UnivariateFunction, double[]> piece : functions) {
			density.put(((PolynomialFunction) piece.getKey()).polynomialDerivative(), piece.getValue());
		}
		return density;
	}
	/**
	 * The utility method csvToArray is used to convert a String
	 * of comma separated values into an array of doubles for use 
	 * in construction of PolynomialFunction objects.
	 * @param input must be in the order from lowest power coefficient to highest, i.e. (x^0,x^1,x^2...)
	 * @return array of double values representing coefficients of function
	 */
	public static double[] csvToArray(String input) {
		String[] strings = input.split(",");
		double[] numbers = new double[strings.length];
		for(int i = 0; i < strings.length;i++) {
			numbers[i] = Double.parseDouble(strings[i]);
		}
		return numbers;
	}
	
	/**
	 * Prints the Distribution function if applicable, or the density function if the
	 * distribution function was not given at construction.
	 * @param var is the name of the random variable, typically 'y', for display purposes.
	 */
	public void printFunction(String var) {
		Set<Entry<UnivariateFunction, double[]>> functions = piecewise.entrySet();
		if(distributionFunction) {
			System.out.println("F(" + var + ") = ");
		}else {
			System.out.println("f(" + var + ") = ");
		}
		for(Entry<UnivariateFunction, double[]> piece : functions) {
			System.out.printf("%20s",piece.getKey() + "   ,");
			System.out.printf("%5s%n", Arrays.toString(piece.getValue()));
		}
	}
	
	/**
	 * Prints the density function using the getDensityFunction which will return
	 * the proper density function regardless of the boolean distributionFunction
	 * assigned at construction.
	 * @param var is the continuous random variable, typically 'y', for display purposes.
	 */
	public void printDensityFunction(String var) {
		Set<Entry<UnivariateFunction, double[]>> functions = getDensityFunction().entrySet();
		System.out.println("f(" + var + ") = ");
		for(Entry<UnivariateFunction, double[]> piece : functions) {
			System.out.printf("%20s",((PolynomialFunction) piece.getKey()) + "   ,");
			System.out.printf("%5s%n", Arrays.toString(piece.getValue()));
		}
	}

	/**
	 * Computes the probability of the random variable Y falling between the two given points
	 * a and b. Note this is a sum of integrals on the intersection of the interval [a,b] and 
	 * the domain of each piece in the density function.
	 * 
	 * @param a is the lower bound of the interval
	 * @param b is the upper bound of the interval
	 * @return a decimal value between 0 and 1 representing the probability of 'Y' falling between a and b
	 */
	public double probability(double a, double b) {
		double sum = 0;
		Set<Entry<UnivariateFunction, double[]>> functions = getDensityFunction().entrySet();
		for(Entry<UnivariateFunction, double[]> piece : functions) {
			double lower = Math.min(piece.getValue()[0], piece.getValue()[1]);
			double upper = Math.max(piece.getValue()[0], piece.getValue()[1]);
			if((a > lower && a < upper) || (b > lower && b < upper)) {
				if(a > lower) { lower = a;}
				if(b < upper) { upper = b;}
				sum += it.integrate(100, piece.getKey(), lower, upper);	
			}
		}
		return sum;
	}

	/**
	 * Calculates the expected value of the ContinousDistribution using the density function
	 * from the method getDensityFunction. This is a sum of integrals iterated over the Set of 
	 * Entry objects in the piecewise HashMap. Note the Entry Set was used because it is an
	 * iterable version of the HashMap. 
	 * @return the expected value of the ContinuousDistribution
	 */
	public double expected() {
		double sum = 0;
		double[] coeffs = {0,1};
		PolynomialFunction y = new PolynomialFunction(coeffs);
		Set<Entry<UnivariateFunction, double[]>> functions = getDensityFunction().entrySet();
		for(Entry<UnivariateFunction, double[]> piece : functions) {
			PolynomialFunction yTimesF = ((PolynomialFunction) piece.getKey()).multiply(y);
			double lower = Math.min(piece.getValue()[0], piece.getValue()[1]);
			double upper = Math.max(piece.getValue()[0], piece.getValue()[1]);
			sum += it.integrate(100, yTimesF, lower, upper);
		}
		return sum;
	}

	/**
	 * Calculates the variance of the ContinousDistribution using the density function
	 * from the method getDensityFunction. This is a sum of integrals iterated over the Set of 
	 * Entry objects in the piecewise HashMap. Note the Entry Set was used because it is an
	 * iterable version of the HashMap. The only difference in this method from expected is the
	 * addition of an extra '.multiply(y) in the PolynomialFunction yTimesF since we are calculating
	 * by definition, the Expected value of y^2*f(y).
	 * @return The variance of the ContinuousDistribution or expected(y^2)
	 */
	public double variance() {
		double sum = 0;
		double[] coeffs = {0,1};
		PolynomialFunction y = new PolynomialFunction(coeffs);
		Set<Entry<UnivariateFunction, double[]>> functions = getDensityFunction().entrySet();
		for(Entry<UnivariateFunction, double[]> piece : functions) {
			PolynomialFunction yTimesF = ((PolynomialFunction) piece.getKey()).multiply(y).multiply(y);
			double lower = Math.min(piece.getValue()[0], piece.getValue()[1]);
			double upper = Math.max(piece.getValue()[0], piece.getValue()[1]);
			sum += it.integrate(100, yTimesF, lower, upper);
		}
		return sum;
	}
}
