package pr2.uebung02;

import static pr.MakeItSimple.*;

import pr.MakeItSimple.PRException;

// Uebung02 - Aufgabe 4

public class ShellSort implements SortInterface {

	/**
	 * Shell sort starts by sorting elements that are a certain number of elements
	 * apart. After it has been partially sorted, insertion sort is applied.
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
			println("~ Current Interval: " + interval + " ~");
			// go through array by comparing two elements which are [interval] elements
			// apart
			while (end < arrayLength - 1) {
				end = start + interval;
				// check whether the two elements are in the wrong order
				if (A[start] > A[end]) {
					array.swap(start, end);
					so.incsc();
				}

				array.printSwappedElementsWithRuns(start, end, so.incAndGetrc());
				so.inccc();
				start++;
			}
			// get next interval for the next run
			interval = intervals[++intervalPos];
		}

		// interval is equal to 1, therefore insertion sort will be applied
		println("~ Current Interval: 1 (Insertion sort is applied) ~ ");
		int marker = 1;
		int copyIndex, temp;
		while (marker < A.length) {
			// go through array and check whether elements from the first element to the
			// marker element is sorted
			temp = A[marker];
			copyIndex = marker - 1;
			so.incsc();

			if (A[copyIndex] <= temp)
				so.inccc();

			while (copyIndex >= 0 && A[copyIndex] > temp) {
				A[copyIndex + 1] = A[copyIndex];
				copyIndex = copyIndex - 1;
				so.incsc();
				so.inccc();
			}

			array.printWithRunAndMarker(so.incAndGetrc(), marker);

			A[copyIndex + 1] = temp;
			marker++;
		}

		// print sorted array and statistics
		println("");
		array.printArray();
		print(so.toString());

	}

}
