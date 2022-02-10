
package notes;
import java.util.Random;


public class CentralTendencyMode {
	private int[] nums;
	
	public CentralTendencyMode(int size) {
		nums = new int[size];
		Random rng = new Random();
		for(int i = 0; i < size; i++) {
			nums[i] = rng.nextInt(10) + 1;
		}
		System.out.println("Nums");
		printNums();
		
	}
	
	public CentralTendencyMode(int[] newNums) {
		nums = newNums;
	}
	
	public void printNums() {
		for(int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
	
	public double mode() throws Exception {
		Exception noMode = new Exception("No Mode");
		boolean newMode = false;
		double mode = nums[0];
		int highestCount = 0;
		int currentCount = 0;
		for(int i = 0; i < nums.length; i++) {
			for(int j = i; j < nums.length; j++) {
				if(nums[i] == nums[j]) {
					currentCount++;
				}
			}
			if(currentCount > highestCount) {
				highestCount = currentCount;
				newMode = true;
				mode = nums[i];
			}else if(highestCount == currentCount) {
				newMode = false;
			}
			currentCount = 0;
		}
		if(highestCount <= 1) {
			throw noMode;
		}else if(!newMode) {
			throw noMode;
		}
		return mode;
	}
	
	public double getSTDev(int[] numbers) {
		int n = numbers.length;
		double stdev = 0;
		double average = 0;
		for(int i = 0; i < n; i++) {
			average += numbers[i];
		}
		average = average/n;
		for(int i = 0; i < n; i++) {
		stdev = stdev + (numbers[i] - average)*(numbers[i] - average);
		}
		stdev = Math.pow(stdev/(n-1),0.5);
		
		return stdev;
	}
	
	public double getSTDev() {
		int n = nums.length;
		double stdev = 0;
		double average = 0;
		for(int i = 0; i < n; i++) {
			average += nums[i];
		}
		average = average/n;
		for(int i = 0; i < n; i++) {
		stdev = stdev + (nums[i] - average)*(nums[i] - average);
		}
		stdev = Math.pow(stdev/(n-1),0.5);
		
		return stdev;
	}
	
	public static void main(String[] args) throws Exception {
		CentralTendencyMode ct = new CentralTendencyMode(10);
		System.out.println("Mode: " + ct.mode());
		int[] newNums = {1,2,3,4,5,6,7,8,9,0};
		CentralTendencyMode ct2 = new CentralTendencyMode(newNums);
		System.out.println("Mode: " + ct2.mode());
		CentralTendencyMode ct3 = new CentralTendencyMode(10);
		System.out.println(ct3.getSTDev(newNums));
		System.out.println(ct3.getSTDev());
	}
}
