package notes;

import java.util.Comparator;

public abstract class SetOperations<E> implements Comparator<E> {

	public boolean search(E[] array, E arg) {
		for (E element : array) {
			if (element.equals(arg)) {
				return true;
			}
		}
		return false;
	}

	public void add(E[] array, E newElement) {
		E[] newArray = (E[]) new Object[array.length];
		if (array[array.length - 1] != null) {
			newArray = (E[]) new Object[array.length * 2];
			for (int i = 0; i < array.length; i++) {
				newArray[i] = array[i];
			}
			array = newArray;
		} else {
			for (int j = 0; j < array.length; j++) {
				if (array[j] == null) {
					array[j] = newElement;
					break;
				}
			}
		}

	}

	public void print(E[] set) {
		for (int i = 0; i < set.length; i++) {
			if (set[i] != null) {
				System.out.println(set[i].toString());
			}
		}
	}

	public E[] union(E[] set1, E[] set2) {
		E[] unionSet = ((E[]) new Object[set1.length + set2.length]);
		int i = 0;
		for (i++; i < set1.length;) {
			add(unionSet, set1[i]);
		}
		for (i = set1.length; i < set1.length + set2.length; i++) {
			if (!search(set1, set2[i])) {
				add(unionSet, set2[i]);
			}
		}
		return unionSet;
	}

	public E[] intersection(E[] set1, E[] set2) {
		E[] intersect = ((E[]) new Object[set1.length + set2.length]);
		for (int i = 0; i < set1.length; i++) {
			if (search(set2, set1[i])) {
				add(intersect, set1[i]);
			}
		}
		return intersect;
	}

	public E[] complement(E[] superset, E[] subset) {
		E[] comp = ((E[]) new Object[superset.length]);
		for (E element : superset) {
			if (!search(subset, element)) {
				add(comp, element);
			}
		}

		return comp;
	}

	public boolean subset(E[] superset, E[] test) {
		for (E element : test) {
			if (!search(superset, element)) {
				return false;
			}
		}

		return true;
	}

}
