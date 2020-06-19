package pr2.uebung04;

import static pr.MakeItSimple.*;

import pr.MakeItSimple.PRException;

//Uebung02 - Aufgabe 3
public class QuickSort implements SortMethod {

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
	public void sort(Comparable[] A) {

		if (A == null || A.length < 1) {
			return;
		}else if (A.length == 1) {
			return;
		}

		quickSort(A, 0, A.length - 1);

	}

	private Comparable[] quickSort(Comparable[] A, int start, int end) {

		if (end > start) {
			// pivot Element is now at right place
			int partitionIndex = partition(A, start, end);

//			// limit array boundary because pivot element is in the correct position
			// sort remaining unsorted elements
			quickSort(A, start, partitionIndex - 1); // Before index
			quickSort(A, partitionIndex + 1, end);// after index

		}
		
		return A;
	}

	// This function takes last element as pivot, places
	// the pivot element at its correct position in sorted array
	// and places all smaller (smaller than pivot)
	// to left of pivot and all greater elements to right of pivot

	private int partition(Comparable[] A, int start, int end) {

		int positionPivot = end;

		// firstPointer is staggered
		int firstPointer = start - 1;

		for (int secondPointer = start; secondPointer <= end - 1; secondPointer++) {
			// If current element is smaller than the pivot
			// secondPointer only picks small element
			if (A[secondPointer].compareTo(A[positionPivot]) <= 0) {
				firstPointer++;
				// place small element to left
				swap(A,firstPointer, secondPointer);
			}
		}

		// There is no element which is smaller than or equal to the pivot element,
		// so the pivot element is swapped in the correct position.

		// swaps with incremented firstPointer because firstPointer placed at the same
		// index like secondPointer
		swap(A,firstPointer + 1, positionPivot);

		// position where pivot element was sorted
		return firstPointer + 1;

	}

	private void swap(Comparable[] array, int index1, int index2) {

		Comparable tempElement = array[index2];
		array[index2] = array[index1];
		array[index1] = tempElement;

	}

}
