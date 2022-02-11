
package notes;
import java.util.Random;
import java.util.Arrays;

public class CentralTendency {
	private int[] nums;
	
	public CentralTendency(int size) {
		nums = new int[size];
		Random rng = new Random();
		for(int i = 0; i < size; i++) {
			nums[i] = rng.nextInt(10) + 1;
		}
		System.out.println("Nums");
		printNums();
		
	}
	
	public CentralTendency(int[] newNums) {
		nums = newNums;
	}
	
	public double mean() {
		double sum = 0;
		for(int i : nums) {
		 sum = sum + i;
		}
		return sum/nums.length;
	}
	
	public double mean(int[] numbers) {
		double sum = 0;
		for(int i : numbers) {
		 sum = sum + i;
		}
		return sum/numbers.length;
	}
	
	public int[] sortNums(int[] numbers) {
		 int min = numbers[0];
		 int minIndex = 0;
		for(int j = 0; j < numbers.length; j++) {
			for(int i = 0; i < numbers.length; i++) {
				if(numbers[i] < min) {
				 min = numbers[i];
				 minIndex = i;
				}
			}
		   int temp = numbers[j];
		   numbers[j] = numbers[minIndex];
		   numbers[minIndex] = temp; 
		   
		}
		return numbers;
	 }
	 
	public double median() {
		/*int targetIndex = nums.length/2;
		int[] sorted = new int[nums.length/2];
		if(nums.length % 2 == 1) {
			for(int i = 0; i < targetIndex; i++) {
				int smallest = nums[0];
				for(int j = i; j < nums.length; j++) {
					
				}
			}
		}else {
		
		}
		
		int[] middleTwo = {nums[nums.length/2],nums[(nums.length/2) - 1]};
		return mean(middleTwo);
		*/
		Arrays.sort(nums);
		if(nums.length % 2 == 1) {
			return nums[nums.length/2];
		}
		
		int[] middleTwo = {nums[nums.length/2],nums[(nums.length/2) - 1]};
		return mean(middleTwo);
		
	}
	
	
	public void printNums() {
		for(int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
	
	public int mode() throws Exception {
		Exception noMode = new Exception("No Mode");
		boolean newMode = false;
		int mode = nums[0];
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
	
	public double getVar(int[] numbers) {
		int n = numbers.length;
		double var = 0;
		double average = 0;
		for(int i = 0; i < n; i++) {
			average += numbers[i];
		}
		average = average/n;
		for(int i = 0; i < n; i++) {
		var = var + (numbers[i] - average)*(numbers[i] - average);
		}
		
		return var/(numbers.length-1);
	}
	
	public double getVar() {
		int n = nums.length;
		double var = 0;
		double average = mean();
		for(int i = 0; i < n; i++) {
		var = var + (nums[i] - average)*(nums[i] - average);
		}
		
		return var/nums.length-1;
	}
	
	public double getSTDev() {
		return Math.pow(getVar(),0.5);
	}
	
	public double getSTDev(int[] numbers) {
		return Math.pow(getVar(numbers),0.5);
	}
	
	
}
