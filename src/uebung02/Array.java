package pr2.uebung02;

import static pr.MakeItSimple.*;

public class Array {

	int[] array;

	Array(int[] array) {
		this.array = array;
	}

	/**
	 * Swaps the positions of two elements within the array.
	 * 
	 * @param index1 index of one element to be swapped
	 * @param index2 index of the other element to be swapped
	 */
	void swap(int index1, int index2) {

		int tempElement = array[index2];
		array[index2] = array[index1];
		array[index1] = tempElement;

	}

	/**
	 * Prints the array with the current sorting run.
	 * 
	 * @param run current run
	 */
	void printWithRun(int run) {

		print("F" + run + " = ");

		for (int i = 0; i < this.array.length; i++) {
			print(" " + array[i] + " ");
		}

		println("");

	}

	/**
	 * Prints the array with two Elements highlighted differently, depending on
	 * whether they were swapped or just compared.
	 * 
	 * @param index1  index of one element
	 * @param index2  index of the other element
	 * @param swapped true, if they were swapped, false, if they were only compared
	 */
	void printWithHighlightedElements(int index1, int index2, boolean swapped) {

		print("     ");

		for (int i = 0; i < this.array.length; i++) {
			if (swapped && (i == index1 || i == index2))
				print("<" + array[i] + ">");
			else if (!swapped && (i == index1 || i == index2))
				print("(" + array[i] + ")");
			else
				print(" " + array[i] + " ");
		}

		println("");

	}

	/**
	 * Prints the array with the marker element highlighted.
	 * 
	 * @param marker index of marker element
	 */
	void printWithMarker(int marker) {

		print("     ");

		for (int i = 0; i < this.array.length; i++) {
			if (i == marker)
				print("[" + array[i] + "]");
			else
				print(" " + array[i] + " ");
		}

		println("");

	}

	/**
	 * Prints the array with the current sorting run and the marker element
	 * highlighted.
	 * 
	 * @param run    current run
	 * @param marker index of marker element
	 */
	void printWithRunAndMarker(int run, int marker) {

		print("F" + run + " = ");

		for (int i = 0; i < this.array.length; i++) {
			if (i == marker)
				print("[" + array[i] + "]");
			else
				print(" " + array[i] + " ");
		}

		println("");

	}

	/**
	 * Prints the array with the current sorting run and interval.
	 * 
	 * @param run      current run
	 * @param interval current interval
	 */
	void printWithRunAndInterval(int run, int interval) {

		println("~ Current Interval: " + interval + " ~");

		print("F" + run + " = ");

		for (int i = 0; i < this.array.length; i++) {
			print(" " + array[i] + " ");
		}

		println("");

	}

	/**
	 * Prints only the array.
	 */
	void printArray() {

		print("    [");

		for (int i = 0; i < this.array.length; i++) {
			print(" " + array[i] + " ");
		}

		print("]");
		println("");

	}
	
	/**
	 * prints array with runs
	 * @param run
	 */
	
	public void printArrayWithRuns(int run){
		
		if(run >= 0 && run < 10) {
			print("F" + run + "  " + "  =  ");
		}else if (run >= 10) {
			print("F" + run + "  " + "=  ");
		} else if (run >= 100) {
			print("F" + run + "=  ");
		}
		else 
			print("         ");

		for(int i = 0; i < this.array.length; i++) {
			print(" " + this.array[i] + " ");
		}
		println(" ");
	}
	
	
	public void printBoundaryAfterpartition(int start , int end, int run) {

		if(run >= 0) 
			print("F" + run + "  =  ");
		else 
			print("       ");

		for(int i = 0; i < this.array.length; i++) { 
			if(i == start) {
				print("["+ this.array[i] );
			}else if (i == end) {
				print("  "+ this.array[i] + "]" );
			}else {
				print(" " + this.array[i] + " ");
			}
		}
	}
	
	/**
	 * Prints the shift of an element in an array
	 * @param shiftedElement
	 * @param run
	 */

	public void printShiftedElement( int shiftedElement, int run) {
		if(run >= 0) 
			print("        ");
		else 
			print("         ");
		for(int i = 0; i < this.array.length; i++) {
			if(i == shiftedElement) {
				print("(" + this.array[i] + ")");
			} else {
				print(" " + this.array[i] + " ");

			}

		}  
		println("");	
	}
	
	public void printSwappedElementsWithRuns( int firstElement, int secondElement, int run) {

		if(run >= 0) 
			print("F" + run + "  = ");
		else 
			print("       ");

		for(int i = 0; i < this.array.length; i++) {
			if(i == firstElement) {
				print("(" + this.array[i] + ")");
			}else if( i == secondElement) {
				print("(" + this.array[i] + ")");
			}else {
				print(" " + this.array[i] + " ");
				
			}
	
		}	println("");	
		
	}
}

