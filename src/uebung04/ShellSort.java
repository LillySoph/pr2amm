package pr2.uebung04;

import static pr.MakeItSimple.*;

import pr.MakeItSimple.PRException;

// Uebung02 - Aufgabe 4

public class ShellSort implements SortMethod {

	/**
	 * Shell sort starts by sorting elements that are a certain number of elements
	 * apart. After it has been partially sorted, insertion sort is applied.
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

//		// create array object for additional functions
//		Array array = new Array(A);

		int[] intervals = { 9, 7, 4, 1 };
		int intervalPos = 0;
		int interval = intervals[intervalPos];

		int arrayLength = A.length;
		int start, end;

		// choose right first interval depending on array length
		while (interval > arrayLength - 1) {
			interval = intervals[++intervalPos];
		}

		while (interval > 1) {
			start = 0;
			end = 0;
			// go through array by comparing two elements which are [interval] elements
			// apart
			while (end < arrayLength - 1) {
				end = start + interval;
				// check whether the two elements are in the wrong order
				if (A[start].compareTo(A[end]) > 0) {
					swap(A,start, end);
				}
				start++;
			}
			// get next interval for the next run
			interval = intervals[++intervalPos];
		}

		// interval is equal to 1, therefore insertion sort will be applied
		int marker = 1;
		int copyIndex;
		Comparable temp;
		while (marker < A.length) {
			// go through array and check whether elements from the first element to the
			// marker element is sorted
			temp = A[marker];
			copyIndex = marker - 1;

			while (copyIndex >= 0 && A[copyIndex].compareTo(temp) > 0) {
				A[copyIndex + 1] = A[copyIndex];
				copyIndex = copyIndex - 1;
			}
			A[copyIndex + 1] = temp;
			marker++;
		}

	}
	
	private void swap(Comparable[] array, int index1, int index2) {

		Comparable tempElement = array[index2];
		array[index2] = array[index1];
		array[index1] = tempElement;

	}

}
