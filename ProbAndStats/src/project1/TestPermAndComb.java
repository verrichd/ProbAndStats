package project1;
/**
 * Tester for PermutationsAndCombinations that demonstrates the
 * correct functionality of each method that implicitly use the 
 * factorial method to work. Print lines describe the meaning
 * of each calculation.
 * 
 * @author DominicVerrichia
 *
 */
public class TestPermAndComb {

	public static void main(String[] args) {
		PermutationsAndCombinations<String> pc = new PermutationsAndCombinations<>();
		String[] names = {"Dom","OtherDom","ThirdDom","FourthDom", "5thDom", "6thDom"};
		int[] groupSizes = {1,2,3};
		System.out.print("Permutations of 6 Doms groups of 2: ");
		System.out.println(pc.permutations(names, 2));
		System.out.println("Combinations not respecting order (ab = ba): " + pc.combinations(names, 2));
		System.out.print("Permutations of 6 Doms groups of 3, 2, and 1: ");
		System.out.println(pc.permutations(6, groupSizes));
		int[] setSizes = {12,8};
		System.out.print("Permutations for 20 indivduals groups of 12 and 8: ");
		System.out.println(pc.permutations(20, setSizes));
		System.out.println("Possible combinations of groups of 5 out of 20 students (20 choose 5): " + pc.combinations(20, 5));
		
		
		
	}

}
