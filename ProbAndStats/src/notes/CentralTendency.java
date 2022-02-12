
package notes;
import java.util.Random;
import java.util.Arrays;
/**
 * CentralTendency has methods that return the statistical measurements
 * of central tendency including mean, median, mode, and standard deviation
 * 
 * There are two constructors for this object, one that accepts an integer to determine the size
 * of a then randomly filled array of integers and the other accepts a user generated integer array
 * 
 * The method printNums is used in the random array constructor to provide context for the calculations
 * 
 * @author DominicVerrichia
 *
 */
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
	
	public void printNums() {
		System.out.print("Numbers in the array: {");
		for(int i = 0; i < nums.length; i++) {
			if(i == nums.length - 1) {
				System.out.println(nums[i] + "}");
			}else {
			System.out.print(nums[i] + ",");
			}
		}
	}
	
	/**
	 * mean calculates the typical average of the integer array
	 * by adding every element and dividing by the amount of elements
	 * @return
	 */
	public double mean() {
		double sum = 0;
		for(int i : nums) {
		 sum = sum + i;
		}
		return sum/nums.length;
	}
	
	 /**
	  * median will return the middle element in an array of odd length
	  * but will return the average of the middle two values in an even 
	  * length array
	  * 
	  * @return middle value of the integer array
	  */
	public double median() {
		Arrays.sort(nums);
		if(nums.length % 2 == 1) {
			return nums[nums.length/2];
		}
		double median = nums[nums.length/2] + nums[(nums.length/2) - 1] / 2;
		
		return median;
		
	}
	
	/**
	 * mode will return the most occurring number in the array 
	 * and will throw an exception when there is not one singular number 
	 * that occurs more than the rest
	 * @return the mode of an integer array
	 * @throws Exception when there is no mode
	 */
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
	
	/**
	 * variance returns the variance of an integer set with internal 
	 * use of the mean method to calculate the sum of the squares of
	 * each element's distance from the average
	 * @return variance as described by the statistical method
	 */
	public double getVar() {
		int n = nums.length;
		double var = 0;
		double average = mean();
		for(int i = 0; i < n; i++) {
		var = var + (nums[i] - average)*(nums[i] - average);
		}
		
		return var/(nums.length-1);
	}
	
	/**
	 * getSTDev returns the standard deviation of the integer array
	 * with use of the variance method. This method takes advantage of 
	 * the relationship between variance and standard deviation 
	 * 
	 *  That is variance = (standard deviation)^2
	 *  
	 * @return standard deviation by calculating variance then taking square root
	 */
	public double getSTDev() {
		return Math.pow(getVar(),0.5);
	}
	
	
	
}
