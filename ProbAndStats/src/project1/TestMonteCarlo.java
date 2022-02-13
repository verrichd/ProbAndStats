package project1;

/**
 * Tester for MonteCarloSimulation will print out simulation
 * for guess on each door both using the switching strategy and not 
 * switching for a total of 6 possibilities running 50,000 times each 
 * for the calculation of the percentages.
 * 
 * @author DominicVerrichia
 *
 */
public class TestMonteCarlo {

	public static void main(String[] args) {
		MonteCarloSimulation mcs = new MonteCarloSimulation(50000);
		mcs.runSimulation();
		
	}
}
