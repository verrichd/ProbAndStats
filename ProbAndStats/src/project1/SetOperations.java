package project1;

/**
 * SetOperations has methods that return the union and 
 * intersection of two sets, and the complement of one set
 * provided a superset is given
 * 
 * @author Dominic Verrichia
 *
 * @param <E> is any object that is Comparable
 */
public class SetOperations<E> {
	
	/**
	 * searches an Object array for a specified element 
	 * that considers a null search argument as false. This method
	 * is used in almost every method in this class.
	 * 
	 * @param superSet is the array to be searched
	 * @param element2 is the target for search, can be null
	 * @return if the array contains the argument
	 */
	public boolean search(Object[] superSet, Object element2) {
		for(Object element : superSet) {
			if(element == null) {
				return false;
			}
			if(element.equals(element2)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Adds an element to an Array while checking for size to 
	 * ensure there is enough room to complete the add. This method
	 * is used in the union and intersection methods when creating
	 * a the resultant array.
	 * 
	 * @param array is the array that will have a new element
	 * @param newElement is the element to be inserted
	 * @return the updated array with the added element
	 */
	public Object[] add(Object[] array, Object newElement) {
		Object[] newArray = array;
		if(array[array.length - 1] != null) {
			newArray =  new Object[array.length * 2]; 
			for(int i = 0; i < array.length; i++) {
				newArray[i] = array[i];
			}
			newArray[array.length] = newElement;
			return newArray;
			
		}else {
			for(int j = 0; j < newArray.length; j++) {
				if(newArray[j] == null) {
				newArray[j] = newElement;
				return  newArray;
				}
			}	
		}
		return newArray;
	}
	
	/**
	 * Prints a set of Objects with a space in between each element
	 * including brackets at the beginning and end.
	 * 
	 * @param set to be printed 
	 */
	public void print(Object[] set) {
		System.out.print("{");
		for(int i = 0; i < set.length; i++) {
			if(set[i] != null) {
				System.out.print(set[i].toString() +  " ");
			}
		}
		System.out.println("}");
			}
	
	/**
	 * will accept two arrays and calculate which elements
	 * are in the union of the two sets as per standard set 
	 * operations. This will account for double values and only
	 * add those once to hold true to the actual operation. 
	 * This method uses a loop along with the internal methods
	 * search and add to perform the task.
	 * 
	 * @param set1
	 * @param set2
	 * @return the union of two sets of the same type
	 */
	public E[] union(E[] set1, E[] set2) {
		E[] unionSet = set1;
	
		for(int j= 0; j < set2.length; j++) {
			if(!search(set1,set2[j])) {
				unionSet =   (E[]) add(unionSet, set2[j]);
			}
		}
		return unionSet;
	}
	
	/**
	 * will accept two arrays and calculate which elements
	 * are in the intersection of the two sets as per standard set 
	 * operations. This is the same thing as only retaining the values
	 * that are in both sets. This method uses a loop along with the 
	 * internal methods search and add to perform the task.
	 * 
	 * @param set1
	 * @param set2
	 * @return the intersection of two sets of the same type
	 */
	public E[] intersection(E[] set1, E[] set2) {
		E[] intersect = ((E[])new Object[set1.length + set2.length]);
		for(int i = 0; i < set1.length; i++) {
			if(search(set2, set1[i])) {
				intersect =  (E[]) add(intersect, set1[i]);
			}
		}
		return intersect;
	}
	
	/**
	 * This will return the complement of a given set provided there
	 * is a superSet given as well. That is, if the first argument superset
	 * does not contain all of the second argument sub, the method will throw 
	 * an exception.
	 * @param superSet the set that contains at the very least sub
	 * @param sub is the set that will be used to calculate its complement
	 * @return the complement of sub
	 * @throws Exception provided there is no superset subset relationship between the arguments
	 */
	public E[] complement(E[] superSet, E[] sub) throws Exception{
		Exception notSubset = new Exception("Not a Super/Subset relationship. Cannot Determine a complement.");
		if(!subset(superSet,sub)) {
			throw notSubset;
		}
		E[] comp = superSet;
		for(int i = 0; i < comp.length; i++) {
			if(search(sub, comp[i])) {  
				comp[i] = null;
			}
		}
		
		return comp;
	}
	
	/**
	 * Tells whether two classes have a superset subset relationship.
	 * Important to note that order is important for the arguments even 
	 * though they are the same type. This returns true for a superset relationship
	 * in a single direction. It will NOT return true in the presence of a relationship,
	 * the superset MUST be the first argument and the subclass the second. Otherwise 
	 * this method would not serve its purpose in the complement method or on its own. 
	 *
	 * @param superSet 
	 * @param sub
	 * @return true if the first argument superSet contains every element in sub.
	 */
	public boolean subset(Object[] superSet, Object[] sub) { 
		for(Object element : sub) {
			if(!search(superSet, element)) {
				return false;
			}
		}
		
		return true;
	}

	
}
