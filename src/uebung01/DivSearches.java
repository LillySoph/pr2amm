package pr2.uebung01;

public class DivSearches {
	
	public final static int NO_KEY = -1;

	/**
	 * a) Lineare Suche, wobei immer das gesamte Array durchsucht wird 
	 * und der Index des letzten gefundenen Wertes zuruckgegeben wird.
	 */
	static int  sequentialSearchL(int [] array, int key) {

		for(int i = array.length-1; i >= 0; i--) {
			if(array[i] == key ) {
				return i;
			}
		}
		return  NO_KEY;
	}
	
	/**
	 * b) Lineare Suche, wobei immer das gesamte Array durchsucht wird 
	 * und der Index des ersten gefundenen Wertes zuruckgegeben wird.
	 *
	 */
	static int  sequentialSearchF (int [] array, int key) {

		for(int i = 0; i < array.length; i++) {
			if(array[i] == key ) {	
				return i;
			}	
		}
		return  NO_KEY;

	}
	/** c)*/
	static int binarySearchRec(int [] array, int key) {

		return binarySearchRecHelper(array,key,0,array.length-1);
	}

	/** Hilfmethode für binarySearchRec, da laut JUnit 2 Parameter für binarySearch vorgegeben sind
	*/
	
	private static int binarySearchRecHelper (int [] array, int key, int start, int end) {

		if  (start <= end) {
			int middle = (start + end) / 2;
			if(array[middle] == key) {
				return middle;
			}else if( key < array[middle]) {
				end = middle-1;
				return binarySearchRecHelper(array,key,start,end);
			}else {
				start = middle+1;
				return binarySearchRecHelper(array, key,start, end);
			}
		}
		return NO_KEY;

	}

	/** d) */
	static int binarySearch (int [] array, int key) {

		int start = 0, end = array.length-1;

		while (start <= end) {
			int middle = (start + end) / 2;
			if(array[middle] == key ) {
				return middle;
			} else if (key < array[middle]) {
				end = middle -1;
			} else
				start = middle +1;
		}
		return NO_KEY;

	}

}