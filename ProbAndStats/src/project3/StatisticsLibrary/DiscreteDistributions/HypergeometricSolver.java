package project3.StatisticsLibrary.DiscreteDistributions;

import java.math.BigInteger;
import java.security.InvalidParameterException;

public class HypergeometricSolver {
	private PermutationsAndCombinations pc;
	private  BigInteger n;
	private BigInteger bigN;
	private BigInteger r;
	
	public HypergeometricSolver(int total, int selected, int r) {
		Integer tot = (Integer) total;
		Integer sel = (Integer) selected;
		Integer rr = (Integer) r;
		pc = new PermutationsAndCombinations<>();
		n = new BigInteger(tot.toString());
		bigN = new BigInteger(sel.toString());
		this.r = new BigInteger(rr.toString());
		
	}
	
	public void pmf(int inputY) throws InvalidParameterException {
		Integer intY = (Integer) inputY;
		BigInteger y = new BigInteger(intY.toString());
		if(y.compareTo(r) >= 0) {
			throw new InvalidParameterException();
		}
		BigInteger nChooseY = pc.combinations(n, y);
		BigInteger numerator = nChooseY.multiply(pc.combinations(bigN.subtract(r), n.subtract(y)));
		BigInteger denominator = pc.combinations(bigN, n);
		BigInteger pmf = numerator.divide(denominator);
		System.out.println("p(" + y + ") = " + pmf.toString());
	}
	
	public void expected() {
		BigInteger exp = (n.multiply(r)).divide(bigN);
		System.out.println("Expected Value E(Y) = " + exp.toString());
	}
	
	public void variance() {
		BigInteger var = n.multiply(r.divide(bigN)) .multiply( ((bigN.subtract(r)).divide(bigN))) .multiply( ((bigN.subtract(n)).divide( (bigN.subtract(BigInteger.valueOf(1))))));
		System.out.println("Variance V(Y) = " + var.toString());
	}
}
