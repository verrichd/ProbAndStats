package project3.StatisticsLibrary.DiscreteDistributions;

public class TestGeometricSolver {
	public static void main( String[] args){
		GeometricDistrubution gs = new GeometricDistrubution(0.143);
		gs.pmf(3);
		gs.expected();
		gs.variance();
		
	}
}	
