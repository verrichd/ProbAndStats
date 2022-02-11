package notes;

public class TestCentralTendencies {
	public static void main(String[] args) throws Exception {
		int[] numbers = {5,7,8,2,8,4,9,1,6};
		CentralTendency ct = new CentralTendency(numbers);
		System.out.println("Mean: " + ct.mean() + " Expected: 5.55556");
		System.out.println("Median: " + ct.median() + " Expected: 6");
		System.out.println("Mode: " + ct.mode() + " Expected: 8");
		System.out.println("Stnd Dev: " + ct.getSTDev() + " Expected: 2.78886");
		System.out.println("Variance: " + ct.getVar() + " Expected: 7.77778");
			
	}
}
