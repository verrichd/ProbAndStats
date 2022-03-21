package project2.Distributions;

public class GeometricDistrubution {
	
	private double p;
	private double q;
	
	public GeometricDistrubution(double prob) {
		p = prob;
		q = 1 - prob;
	}
	
	public void pmf(int y) {
		double pmf = Math.pow(q, y - 1) * p;
		System.out.println("The probability of the " + y + " try is: " + pmf);
	}
	
	public void expected() {
		double exp = 1/p;
		System.out.println("The expected value is: " + exp);
	}
	
	public void variance() {
		double var = (1-p) / (p*p);
		System.out.println("The varience is: " + var);
	}
}
