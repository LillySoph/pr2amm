package pr2.uebung04;

import static pr.MakeItSimple.*;

// Uebung02 - Aufgabe 1

public class ShakerSort implements SortMethod {

	/**
	 * Shaker sort works similarly to the bubble sort by comparing pairs. The
	 * difference is that it is comparing in alternating directions. Like the bubble
	 * sort it starts with the first element.
	 * 
	 * @param A  Array to be sorted
	 * @param so Object with statistical data regarding the performance of the sort
	 *           algorithm
	 */
	@Override
	public void sort(Comparable[] A) {

		if (A == null || A.length < 1) {
			throw new PRException("Invalid Array.");
		} else if (A.length == 1) {
			throw new PRException("Array is to short. (Length: " + A.length + ")");
		}

//		// create array object for swap function
//		Array array = new Array(A);

		boolean swapped = false;
		int start = 0;
		int end = A.length - 1;

		do {
			// compare elements from left to right
			swapped = false;
			for (int i = start; i < end; i++) {
				// check whether the two elements are in the wrong order
				if (A[i].compareTo(A[i + 1]) > 0) {
					swap(A, i, i + 1);
					swapped = true;
				}
			}
			// area size in which the elements are compared & sorted can be decreased,
			// because the last element is sorted
			end--;

			if (swapped) {
				// compare elements from right to left
				swapped = false;
				for (int i = end - 1; i >= start; i--) {
					if (A[i].compareTo(A[i + 1]) > 0) {
						swap(A, i, i + 1);
						swapped = true;
					}
				}
				// same as above just with the first element of the area
				start++;

			}

		} while (swapped);
	}

	private void swap(Comparable[] array, int index1, int index2) {

		Comparable tempElement = array[index2];
		array[index2] = array[index1];
		array[index1] = tempElement;

	}

}
