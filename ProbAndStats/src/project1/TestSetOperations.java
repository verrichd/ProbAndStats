package project1;
/**
 * Tester class for SetOperations demonstrating its use 
 * on strings specifically in finding shared words when
 * comparing two sentences (intersection) and finding 
 * words unique to each sentence or String array.
 * 
 * @author Dominic Verrichia
 * 
 *
 */

public class TestSetOperations {

	public static void main(String[] args) throws Exception {
		SetOperations<String> st = new SetOperations<>();
		String[] first = {"this","is","the","first","half"};
		String[] second = {"and","this","is","the","second","half"};
		String[] superSet = {"this","is","the","first","half","and","second"};
		Object[] union = st.union(first, second);
		Object[] intersect = st.intersection(first, second);
		Object[] comp = st.complement(superSet, first);
		System.out.print("Set 1: ");
		st.print(first);
		System.out.print("Set 2: ");
		st.print(second);
		System.out.print("Union: ");
		st.print(union);
		System.out.print("Intersect: ");
		st.print(intersect);
		System.out.print("Complement (Set 1): ");
		st.print(comp);
		
	}

}
