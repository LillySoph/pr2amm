package pr2.uebung04;

import static pr.MakeItSimple.*;

public class SortsMain {

	public enum SortingMethod {
		ShellSort, ShakerSort, QuickSort, InsertionSort
	}

	/**
	 * Reads integers from file and stores them as IntElements in an array.
	 * 
	 * @param filename file with integers
	 * @return array with elements of type IntElements
	 */
	public static Comparable[] fillArrayWithIntElementsFromFile(String filename, boolean flippedOrder) {

		// read file content and store into array
		int[] intValues = readIntegerArray(filename);

		// create array with comparable elements
		Comparable[] intElements = new Comparable[intValues.length];

		// store new integer element in song array
		for (int i = 0; i < intValues.length; i++) {
			intElements[i] = new IntElement(intValues[i], flippedOrder);
		}
		return intElements;
	}

	/**
	 * Reads strings from file and stores them as StringElements in an array.
	 * 
	 * @param filename file with strings
	 * @return array with elements of type StringElement
	 */
	public static Comparable[] fillArrayWithStringElementsFromFile(String filename, boolean flippedOrder) {

		// read file content and store into array
		String[] stringValues = readStringArray(filename);

		// create array with comparable elements
		Comparable[] stringElements = new Comparable[stringValues.length];

		// store new string element in song array
		for (int i = 0; i < stringValues.length; i++) {
			stringElements[i] = new StringElement(stringValues[i], flippedOrder);
		}
		return stringElements;

	}

	/**
	 * Reads song strings from file and stores them as SongImplementation elements
	 * in an array.
	 * 
	 * @param filename file with songs
	 * @return array with elements of type SongImplementation
	 */
	public static Comparable[] fillArrayWithSongsFromFile(String filename, boolean flippedOrder) {

		// read file content and store into array
		String[] songs = readStringArray(filename);

		// create array with comparable elements
		Comparable[] allSongs = new Comparable[songs.length];
		int j = 0;

		// split file content and store new song element in song array
		for (String songString : songs) {
			String[] parts = songString.split(";");
			String[] artists = new String[parts.length - 2];
			for (int i = 2; i < parts.length; i++) {
				artists[i - 2] = parts[i];
			}
			allSongs[j++] = new SongImplementation(parts[0], artists, parts[1], flippedOrder);
		}
		return allSongs;
	}

	/**
	 * Prints the parameter comparable array seperated by comma.
	 * 
	 * @param array
	 */
	private static void printArray(Comparable[] array) {
		int arrayLength = array.length;
		for (int i = 0; i < arrayLength; i++) {
			print(array[i]);
		}
	}
	/**
	 * Sorts an array with comparable elements with the given sorting method.
	 * @param sm Sorting method
	 * @param array Comparable array
	 */
	public static void sortArray(SortingMethod sm, Comparable[] array) {
		SortMethod sorter = null;
		if(sm == SortingMethod.ShellSort) {
			sorter = new ShellSort();
		} else if(sm == SortingMethod.ShakerSort){
			sorter = new ShakerSort();
		} else if(sm == SortingMethod.QuickSort){
			sorter = new QuickSort();
		} else{
			sorter = new InsertionSort();
		}
		sorter.sort(array);
	}

	public static void main(String[] args) throws Exception {

		boolean active = true;
		while (active) {
			Comparable[] array = null;

			// choose sorting order for array
			println("Do you want your array to be sorted in ascending order or descending order? ");
			print("Please type in [asc] or [desc]: ");
			String orderAsString = readString();
			boolean flippedOrder;
			if (orderAsString.equals("ascending") || orderAsString.equals("asc")) {
				orderAsString = "ascending";
				flippedOrder = false;
			} else {
				orderAsString = "descending";
				flippedOrder = true;
			}
			
			// choose type of elements which are stored in array
			println("\nDo you want your array to contain song elements, string elements or integer elements? ");
			print("Please type in [song], [string] or [int]: ");
			String type = readString();

			// choose whether to enter all elements or reads them from file
			println("\nDo you want to read the array elements from file or enter the array elements?");
			print("Please type in [file] or [enter]: ");
			String source = readString();

			// read from file, method is called depending on element type
			if (source.equals("file")) {
				print("\nPlease enter the file name: ");
				String filename = readString();
				if (type.equals("int"))
					array = fillArrayWithIntElementsFromFile(filename, flippedOrder);
				else if (type.equals("string"))
					array = fillArrayWithStringElementsFromFile(filename, flippedOrder);
				else
					array = fillArrayWithSongsFromFile(filename, flippedOrder);
			}

			// enter elements, enter size of array and elements
			else {
				int size = 0;
				while (size < 1) {
					print("\nPlease type in the size of your array: ");
					size = readInt();
					if (size < 1)
						println("Invalid input for array size.");
					else
						array = new Comparable[size];
					int index = 0;
					if (type.equals("int")) {
						while (index < size) {
							print("Please enter a integer for array[" + index + "]: ");
							Integer element = (Integer) readInt();
							array[index] = new IntElement(element, flippedOrder);
							index++;
						}
					} else if (type.equals("string")) {
						while (index < size) {
							print("Please enter a string for array[" + index + "]: ");
							String element = readString();
							array[index] = new StringElement(element, flippedOrder);
							index++;
						}
					} else {
						while (index < size) {
							println("Song for array[" + index + "]");
							print("Song title: ");
							String song = readString();
							print("Please enter the number of artists: ");
							int numberOfArtists = readInt();
							String[] artists = new String[numberOfArtists];
							String artist;
							int i = 0;
							while (i < numberOfArtists) {
								print("Artist " + i + 1 + "/" + numberOfArtists + ": ");
								artist = readString();
								artists[i++] = artist;
							}
							print("Album name: ");
							String album = readString();
							array[index] = new SongImplementation(song, artists, album, flippedOrder);
							index++;
						}
					}
				}
			}
			
			// print array before sorting
			println("------------------------------------------------------------------------");
			println("Here is your " + type + " array:");
			println("------------------------------------------------------------------------");
			printArray(array);
			
			boolean sortingActive = true;
			while (sortingActive) {
				Comparable[] clone = array.clone();
				// choose sorting method
				println("\nHow do you want to sort your array?:");
				print("Type in [1] for ShellSort, [2] for ShakerSort, [3] for QuickSort or [4] for InsertionSort (or [0] to exit): ");
				int sortingMethod = readInt();

				// sort array
				String methodAsString = "";
				if (sortingMethod == 1) {
					sortArray(SortingMethod.ShellSort, clone);
					methodAsString = "Shell Sort";
				} else if (sortingMethod == 2) {
					sortArray(SortingMethod.ShakerSort, clone);
					methodAsString = "Shaker Sort";
				} else if (sortingMethod == 3) {
					sortArray(SortingMethod.QuickSort, clone);
					methodAsString = "Quick Sort";
				} else if (sortingMethod == 4){
					sortArray(SortingMethod.InsertionSort, clone);
					methodAsString = "Insertion Sort";
				} else {
					sortingActive = false;
					break;
				}
				
				// print array after sorting
				println("------------------------------------------------------------------------");
				println("Here is your " + type + " array sorted in " + orderAsString + " order with "+ methodAsString +":");
				println("------------------------------------------------------------------------");
				printArray(clone);

			}

			// exit menu or repeat array sorting
			print("\nType in [exit] to exit the menu, otherwise press enter: ");
			String decision = readString();
			if (decision.equals("exit")) {
				println("Goodbye");
				active = false;
			}
		}
	}
}