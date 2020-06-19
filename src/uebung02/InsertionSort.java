package pr2.uebung02;

import static pr.MakeItSimple.*;

import pr.MakeItSimple.PRException;

//Uebung02 - Aufgabe 2
public class InsertionSort implements SortInterface {

	@Override
	public void sort(int[] A, StatObj so) {

		if (A == null || A.length < 1) {
			throw new PRException("Invalid Array.");

		} else if (A.length == 1) {
			throw new PRException("Array is to short. (Length: " + A.length + ")");
		}

		if (so == null) {
			throw new PRException("Invalid StatObject.");
		}

		// array object with additional methods (e.g swap, printArray)
		Array array = new Array(A);

		sortWithBinarySearch(array, so);

		// print the final state of array (sorted)
		println();
		array.printArrayWithRuns(-1);

		// print statistical data
		print(so.toString());
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

	private int[] sortWithBinarySearch(Array array, StatObj so) {

		array.printArrayWithRuns(so.rc);

		for (int i = 1; i < array.array.length; i++) {

			// mark position where the marker element should be inserted.
			int markerPosition = i;
			int markerElement = array.array[i];

			// find position where marker element should be inserted
			int insertionPosition = binarySearch(array, markerElement, 0, markerPosition - 1, so);

			while (markerPosition - 1 >= insertionPosition) {
				
				// left standing element is copied to the right.
				array.array[markerPosition] = array.array[markerPosition - 1];
				array.printShiftedElement(markerPosition, -1);

				so.incsc();
				markerPosition--;

				array.printArrayWithRuns(-1);
			}

			// marker element is inserted at the correct position.
			array.array[markerPosition] = markerElement;
			array.printShiftedElement(markerPosition, -1);
			so.incsc();
			so.incrc();
			array.printArrayWithRuns(so.rc);

		}
		return array.array;
	}

	// A binary search based function to find the position
	// where marker element should be inserted at sorted array
	private int binarySearch(Array array, int markerElement, int startIndex, int endIndex, StatObj so) {

		if (startIndex <= endIndex) {

			// Halve the sorted array to see if marker element should be inserted in the
			// middle,
			// first half or second half
			int middleIndex = (startIndex + endIndex) / 2;

			// look for position where marker element should be inserted
			if (markerElement <= array.array[middleIndex]) {
				so.inccc();

				// limit array boundary
				// look position in the first half
				return binarySearch(array, markerElement, startIndex, middleIndex - 1, so);

			} else {
				so.inccc();
				// ... in the second half
				return binarySearch(array, markerElement, middleIndex + 1, endIndex, so);

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

	private int[] insertionSort(Array array, StatObj so) {
		
		array.printArrayWithRuns(so.rc);
		
		for (int i = 1; i < array.array.length; i++) { // first element is sorted, starting at second element
			int markerPosition = i; // notice position where the selected element is inserted.
			int markerElement = array.array[i];

			if (array.array[markerPosition - 1] <= markerElement) {
				so.inccc();
			}

			// tests if the left standing element is at the wrong place
			while (markerPosition != 0 && array.array[markerPosition - 1] > markerElement) {
				// left standing element is copied to the right.
				array.array[markerPosition] = array.array[markerPosition - 1];
				array.printShiftedElement(markerPosition, -1);
				markerPosition--;
				so.incsc();
				so.inccc();
			}
			// marker element is inserted at the correct position.
			array.array[markerPosition] = markerElement;
			so.incsc();
			so.incrc();
			array.printArrayWithRuns(so.rc);
		}
		return array.array;
	}

}
