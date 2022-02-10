package notes;
import java.util.Random;
import java.util.ArrayList;

public class MonteCarloSimulation {
	private int[] list;
	private int[] perms;
	
	public MonteCarloSimulation(int iterations) {
		Random rng = new Random();
		perms = new int[3];
		list = new int[iterations];
		perms[0] = 1;//car is behind door 1 and goats behind door 2 and 3
		perms[1] = 2;//car behind door 2 and goats behind 1 and 3
		perms[2] = 3;// car behind door 3 and goats behind 1 and 2
		
		for(int i = 0; i < iterations;i++) {
			list[i] = (perms[rng.nextInt(3)]);
		}
	}
	
	public void runSwitch() {
		
	}
	
	public void runNoSwitch() {
		
	}
	
	public static void main(String[] args) {
		MonteCarloSimulation mcs = new MonteCarloSimulation(10000);
		mcs.runSwitch();
		mcs.runNoSwitch();
	}
}
