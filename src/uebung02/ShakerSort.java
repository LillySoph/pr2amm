package pr2.uebung02;

import static pr.MakeItSimple.*;

// Uebung02 - Aufgabe 1

public class ShakerSort implements SortInterface {

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
	public void sort(int[] A, StatObj so) {

		if (A == null || A.length < 1) {
			throw new PRException("Invalid Array.");
		} else if (A.length == 1) {
			throw new PRException("Array is to short. (Length: " + A.length + ")");
		}
		if (so == null) {
			throw new PRException("Invalid StatObj.");
		}

		// create array object for additional functions
		Array array = new Array(A);

		// print initial state of array (unsorted)
		array.printWithRun(so.rc);

		boolean swapped = false;
		int start = 0;
		int end = A.length - 1;

		do {
			// compare elements from left to right
			swapped = false;
			for (int i = start; i < end; i++) {
				// check whether the two elements are in the wrong order
				if (A[i] > A[i + 1]) {
					array.swap(i, i + 1);
					array.printWithHighlightedElements(i, i + 1, true);
					so.incsc();
					swapped = true;
				} else {
					array.printWithHighlightedElements(i, i + 1, false);
				}
				so.inccc();
			}
			// area size in which the elements are compared & sorted can be decreased,
			// because the last element is sorted
			end--;

			// print run and state of array
			array.printWithRun(so.incAndGetrc());

			if (swapped) {
				// compare elements from right to left
				swapped = false;
				for (int i = end - 1; i >= start; i--) {
					if (A[i] > A[i + 1]) {
						array.swap(i, i + 1);
						array.printWithHighlightedElements(i, i + 1, true);
						so.incsc();
						swapped = true;
					} else {
						array.printWithHighlightedElements(i, i + 1, false);
					}
					so.inccc();
				}
				// same as above just with the first element of the area
				start++;
				;
				// print run and state of array
				array.printWithRun(so.incAndGetrc());
			}

		} while (swapped);

		// print sorted array and statistics
		println("");
		array.printArray();
		print(so.toString());

	}

}
