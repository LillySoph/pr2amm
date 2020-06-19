package pr2.uebung02;

import static pr.MakeItSimple.*;

import pr.MakeItSimple.PRException;

//Uebung02 - Aufgabe 3
public class QuickSort implements SortInterface {

	/**
	 * QuickSort is a Divide and Conquer algorithm. It picks an element as pivot and
	 * partitions the given array around the picked pivot.
	 * 
	 * The third variant of Quick sort is similar to the second variant but it
	 * differs from the way elements are swapped. You use two offset pointers that
	 * run from left to right and swap referenced elements if the front pointer hits
	 * an element smaller than the pivot element.
	 * 
	 * @param A  : array to be sorted
	 * @param so : object with statistical data regarding the performance of the
	 *           sort algorithm
	 **/

	@Override
	public void sort(int[] A, StatObj so) {

		if (A == null || A.length < 1) {
			return;

		}else if (A.length == 1) {
			return;
		}

		if (so == null) {
			throw new PRException("Invalid StatObject.");
		}

		// helper object with additional useful methods (e.g swap, printArray)
		Array array = new Array(A);

		// print the initial state of array (unsorted)
		array.printArrayWithRuns(-1);
		println();

		quickSort(array, 0, A.length - 1, so);

		// print the final state of array (sorted)
		array.printArrayWithRuns(so.rc);

		// print statistical data
		print(so.toString());

	}

	private int[] quickSort(Array array, int start, int end, StatObj so) {

		if (end > start) {
			// pivot Element is now at right place
			int partitionIndex = partition(array, start, end, so);

			so.incrc();
			// limit array boundary because pivot element is in the correct position
			// sort remaining unsorted elements
			quickSort(array, start, partitionIndex - 1, so); // Before index
			quickSort(array, partitionIndex + 1, end, so);// after index

		}
		
		return array.array;
	}

	// This function takes last element as pivot, places
	// the pivot element at its correct position in sorted array
	// and places all smaller (smaller than pivot)
	// to left of pivot and all greater elements to right of pivot

	private int partition(Array array, int start, int end, StatObj so) {

		array.printBoundaryAfterpartition(start, end, so.rc);
		println();
		int positionPivot = end;

		// firstPointer is staggered
		int firstPointer = start - 1;

		for (int secondPointer = start; secondPointer <= end - 1; secondPointer++) {
			// If current element is smaller than the pivot
			// secondPointer only picks small element
			if (array.array[secondPointer] <= array.array[positionPivot]) {
				firstPointer++;
				// place small element to left
				array.swap(firstPointer, secondPointer);
				array.printSwappedElementsWithRuns(secondPointer, firstPointer, -1);
				so.incsc();
			}
			so.inccc();
		}

		// There is no element which is smaller than or equal to the pivot element,
		// so the pivot element is swapped in the correct position.

		// swaps with incremented firstPointer because firstPointer placed at the same
		// index like secondPointer
		array.swap(firstPointer + 1, positionPivot);
		array.printSwappedElementsWithRuns(firstPointer + 1, positionPivot, -1);

		so.incsc();

		// position where pivot element was sorted
		return firstPointer + 1;

	}

}
