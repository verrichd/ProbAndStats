package project1;
/**
 * Has methods to return the integer amount of possible permutations
 * in a group of given size or provided an array of generic objects. 
 * There are multiple versions of the same two methods to accommodate multiple
 * types of input as mentioned like an array of objects or just raw size specifications
 * There is an internal factorial method to avoid the need to reach out to the java Math 
 * library. It uses simple recursion to find the factorial of a given integer. All methods 
 * return long values since factorial numbers in this application can grow quickly. It is 
 * recommended to not exceed groups or array sizes of 20 to avoid running into overflow issues.
 * 
 *  * @author DominicVerrichia
 *
 */
public class PermutationsAndCombinations<E> {

	/**
	 * recursively finds the factorial of a given integer (common symbol '!')
	 * this method is called in every other method in this class.
	 * @param n integer
	 * @return factorial of n
	 */
	public long factorial(int n) {
		if(n == 1) {
			return 1;
		}else if(n == 0) {
			return 1;
		}else {
			return n*factorial(n-1);
		}
	}
	
	/**
	 * Calculates the number of permutations of an array of objects 
	 * given a specified size of each subgroup where the order of the
	 * elements in each subgroup counts as a new configuration. (ab != ba)
	 * @param someArray of objects represents the entire group
	 * @param subGroupSize represents the size of each subgroup (they are all the same size in this case)
	 * @return the number of possibilities to arrange the group of objects into these subgroups
	 */
	public long permutations(E[] someArray, int subGroupSize) {
		int size = someArray.length;
		return  factorial(size)/factorial(size - subGroupSize);
	}
	
	/**
	 * Calculates the number of permutations given a specified size of a group of
	 * people as well as the size of each subgroup where the order of the
	 * elements in each subgroup counts as a new configuration. (ab != ba)
	 * 
	 * @param someArraySize the integer size of the total group
	 * @param subGroupSize the size of each subgroup
	 * @return the number of possibilities to arrange the group of objects into these subgroups
	 */
	public long permutations(int someArraySize, int subGroupSize) {
		return  factorial(someArraySize)/factorial(someArraySize - subGroupSize);
	}
	
	/**
	 * Calculates the number of permutations given a specified size of a group of
	 * people as well as an array of different subgroup sizes where the order of the
	 * elements in each subgroup counts as a new configuration. (ab != ba)
	 * 
	 * @param someArraySize the integer size of the total group
	 * @param groupSizes the array of sizes of each subgroup
	 * @return the number of possibilities to arrange the group of objects into these subgroups
	 */
	public long permutations(int someArraySize, int[] groupSizes) {
		long denominator = 1;
		for(int i : groupSizes) {
			denominator = denominator * factorial(i);
		}
		return factorial(someArraySize)/denominator;
	}
	/**
	 * Calculates the number of combinations of an array of objects 
	 * given a specified size of each subgroup where the order of the
	 * elements in each subgroup does not matter. (ab = ba) AKA number
	 * of possible subsets
	 * @param someSet of objects represents the entire set
	 * @param sizeOfSubsets represents the size of each subset (they are all the same size in this case)
	 * @return the number subsets given a specified size of each subset
	 */
	public long combinations(E[] someSet, int sizeOfSubsets) {
		int size = someSet.length;
		return factorial(size)/(factorial(sizeOfSubsets)*factorial(size - sizeOfSubsets));
	}
	
	/**
	 * Calculates the number of combinations of a number representing 
	 * the size of a set given a specified size of each subgroup where
	 *  the order of the elements in each subgroup does not matter. 
	 * (ab = ba) AKA number of possible subsets or (n choose r)
	 * @param someSet of objects represents the entire set
	 * @param sizeOfSubsets represents the size of each subset (they are all the same size in this case)
	 * @return the number subsets given a specified size of each subset
	 */
	public long combinations(int someSetSize, int sizeOfSubsets) {
		return factorial(someSetSize)/(factorial(sizeOfSubsets)*factorial(someSetSize - sizeOfSubsets));
	}
	
}
