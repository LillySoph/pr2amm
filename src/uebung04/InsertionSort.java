package pr2.uebung04;

import static pr.MakeItSimple.*;

import pr.MakeItSimple.PRException;

//Uebung02 - Aufgabe 2
public class InsertionSort implements SortMethod {

	@Override
	public void sort(Comparable[] A) {

		if (A == null || A.length < 1) {
			throw new PRException("Invalid Array.");
		} else if (A.length == 1) {
			throw new PRException("Array is to short. (Length: " + A.length + ")");
		}
		
		sortWithBinarySearch(A);
	}

	/**
	 * Insertion Sort with binary search It differs from the first variant in that
	 * the insertion position for the current element is searched for using binary
	 * search in the already sorted part of the sequence.
	 * 
	 * @param array  : array object 
	 * @param so     : object with statistical data regarding the performance of the
	 *                 sort algorithm
	 */

	private Comparable[] sortWithBinarySearch(Comparable[] A) {

		for (int i = 1; i < A.length; i++) {

			// mark position where the marker element should be inserted.
			int markerPosition = i;
			Comparable markerElement = A[i];

			// find position where marker element should be inserted
			int insertionPosition = binarySearch(A, markerElement, 0, markerPosition - 1);

			while (markerPosition - 1 >= insertionPosition) {
				
				// left standing element is copied to the right.
				A[markerPosition] = A[markerPosition - 1];
				markerPosition--;
			}

			// marker element is inserted at the correct position.
			A[markerPosition] = markerElement;

		}
		return A;
	}

	// A binary search based function to find the position
	// where marker element should be inserted at sorted array
	private int binarySearch(Comparable[] A, Comparable markerElement, int startIndex, int endIndex) {

		if (startIndex <= endIndex) {

			// Halve the sorted array to see if marker element should be inserted in the
			// middle,
			// first half or second half
			int middleIndex = (startIndex + endIndex) / 2;

			// look for position where marker element should be inserted
			if (markerElement.compareTo(A[middleIndex]) <= 0) {

				// limit array boundary
				// look position in the first half
				return binarySearch(A, markerElement, startIndex, middleIndex - 1);

			} else {
				// ... in the second half
				return binarySearch(A, markerElement, middleIndex + 1, endIndex);

			}
		} else {
			return startIndex; 
		}
	}

	/**
	 * Insertion Sort The first element is already sorted and the target stack has
	 * the length 1. You start from the second element and insert it at the
	 * appropriate place in the target stack.
	 * 
	 * @param A      : array to be sorted
	 * @param so     : object with statistical data regarding the performance of the
	 *               sort algorithm
	 */

	private Comparable[] insertionSort(Comparable[] A) {
		
		for (int i = 1; i < A.length; i++) { // first element is sorted, starting at second element
			int markerPosition = i; // notice position where the selected element is inserted.
			Comparable markerElement = A[i];

			// tests if the left standing element is at the wrong place
			while (markerPosition != 0 && A[markerPosition - 1].compareTo(markerElement) > 0) {
				// left standing element is copied to the right.
				A[markerPosition] = A[markerPosition - 1];
				markerPosition--;
			}
			// marker element is inserted at the correct position.
			A[markerPosition] = markerElement;
		}
		return A;
	}

	private void swap(Comparable[] array, int index1, int index2) {

		Comparable tempElement = array[index2];
		array[index2] = array[index1];
		array[index1] = tempElement;

	}
	
}
