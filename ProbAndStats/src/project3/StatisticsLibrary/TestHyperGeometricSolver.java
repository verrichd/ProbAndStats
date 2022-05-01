package project3.StatisticsLibrary;

public class TestHyperGeometricSolver {
	public static void main(String[] args) {
		HypergeometricSolver hg = new HypergeometricSolver(20, 10, 5);
		hg.pmf(5);
		hg.expected();
		hg.variance();
	}
	
}
