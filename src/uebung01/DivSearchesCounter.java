package pr2.uebung01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import static pr.MakeItSimple.*;

public class DivSearchesCounter {

	static int sequentialSearchL(int[] array, int key) {

		int counter = 0;

		if (array == null || array.length == 0) {
			return -1;
		}

		for (int i = array.length - 1; i >= 0; i--) {
			counter++;
			if (array[i] == key)
				return counter;
		}
		return counter * (-1);

	}

	static int sequentialSearchF(int[] array, int key) {

		int counter = 0;

		if (array == null || array.length == 0) {
			return -1;
		}
		
		for (int i = 0; i < array.length; i++) {
			counter++;
			if (array[i] == key)
				return counter;
		}
		return counter * (-1);
	}

	static int binarySearchRec(int[] array, int key) {

		int counter = 0;
		int bottom = 0;
		int top = array.length - 1;
		return binarySearchRecHelper(array, key, bottom, top, counter);

	}

	static int binarySearchRecHelper(int[] array, int key, int bottom, int top, int counter) {

		int middle = (bottom + top) / 2;

		if (bottom > top) {
			return counter * (-1);
		}
		
		if (array[middle] == key) {
			counter++;
			return counter;
		} else if (key < array[middle]) {
			counter++;
			top = middle - 1;
			return binarySearchRecHelper(array, key, bottom, top, counter);
		} else {
			counter++;
			bottom = middle + 1;
			return binarySearchRecHelper(array, key, bottom, top, counter);
		}

	}

	static int binarySearchRecExtCounter(int[] array, int key) {

		int counter = 0;
		int bottom = 0;
		int top = array.length - 1;
		return binarySearchRecHelperExtCounter(array, key, bottom, top, counter);

	}

	static int binarySearchRecHelperExtCounter(int[] array, int key, int bottom, int top, int counter) {

		int middle = (bottom + top) / 2;
		if (bottom > top) {
			return counter * (-1);
		}
		if (array[middle] == key) {
			counter++;
			return counter;
		} else if (key < array[middle]) {
			counter += 2;
			top = middle - 1;
			return binarySearchRecHelperExtCounter(array, key, bottom, top, counter);
		} else {
			counter += 2;
			bottom = middle + 1;
			return binarySearchRecHelperExtCounter(array, key, bottom, top, counter);
		}

	}

	static int binarySearch(int[] array, int key) {

		int bottom = 0;
		int top = array.length - 1;
		int counter = 0;

		while (bottom <= top) {
			int middle = (bottom + top) / 2;
			if (array[middle] == key) {
				counter++;
				return counter;
			} else if (key < array[middle]) {
				counter++;
				top = middle - 1;
			} else {
				counter++;
				bottom = middle + 1;
			}
		}
		return counter * (-1);

	}

	static int binarySearchExtCounter(int[] array, int key) {

		int bottom = 0;
		int top = array.length - 1;
		int counter = 0;

		while (bottom <= top) {
			int middle = (bottom + top) / 2;
			if (array[middle] == key) {
				counter++;
				return counter;
			} else if (key < array[middle]) {
				counter += 2;
				top = middle - 1;
			} else {
				counter += 2;
				bottom = middle + 1;
			}
		}
		return counter * (-1);

	}

	static void selectionSort(int[] array) {
		int marker = array.length - 1;
		while (marker > 0) {
			int max = 0;
			for (int i = 1; i <= marker; i++)
				if (array[i] > array[max])
					max = i;
			swap(array, marker, max);
			marker--;
		}
	}

	static void swap(int[] array, int first, int second) {
		int tmp = array[first];
		array[first] = array[second];
		array[second] = tmp;
	}
	
	static void listInFile(ArrayList<Integer> list, int name, File myFile, int numberOfMisses, int rounds) {

		int numberOfHits = rounds - numberOfMisses;
		
		try {
			FileWriter writer = new FileWriter(myFile, true);

			writer.append("\n      Suchverfahren mit Array-Größe " + name + "\n");
			writer.append("------------------------------------------------\n");
			writer.append("            ERFOLGREICH ("+numberOfHits+"/"+rounds+")\n");
			writer.append("------------------------------------------------\n");
			writer.append(" Sequentielle Suche (Letzter Treffer)    | " + list.get(0) + "\n");
			writer.append(" Sequentielle Suche (Erster Treffer)     | " + list.get(1) + "\n");
			writer.append(" Binäre Suche (Rekursiv) Suchschritte    | " + list.get(2) + "\n");
			writer.append(" Binäre Suche (Iterativ) Suchschritte    | " + list.get(3) + "\n");
			writer.append(" Binäre Suche (Rekursiv) Schlüsselvergl. | " + list.get(4) + "\n");
			writer.append(" Binäre Suche (Iterativ) Schlüsselvergl. | " + list.get(5) + "\n");
			writer.append("------------------------------------------------\n");
			writer.append("             ERFOLGLOS ("+numberOfMisses+"/"+rounds+")\n");
			writer.append("------------------------------------------------\n");
			writer.append(" Sequentielle Suche (Letzter Treffer)    | " + list.get(6) + "\n");
			writer.append(" Sequentielle Suche (Erster Treffer)     | " + list.get(7) + "\n");
			writer.append(" Binäre Suche (Rekursiv) Suchschritte    | " + list.get(8) + "\n");
			writer.append(" Binäre Suche (Iterativ) Suchschritte    | " + list.get(9) + "\n");
			writer.append(" Binäre Suche (Rekursiv) Schlüsselvergl. | " + list.get(10) + "\n");
			writer.append(" Binäre Suche (Iterativ) Schlüsselvergl. | " + list.get(11) + "\n\n");
			
			writer.close();
		} catch (IOException e) {
			println("An error occurred.");
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		String filePath = "stats.txt";
		File myFile = new File(filePath);
		String fileName = "stats.txt";
		
		try {
			if (myFile.createNewFile()) {
				println("File created: " + myFile.getName());
			} else {
				println("File already exists.");
			}
			FileWriter writer = new FileWriter(myFile, true);
			writer.append("--------------------------------------------------------------\n");
			writer.append("  2000 Testdurchläufe mit 3 Array-Größen (1024, 2048, 4096)   \n");
			writer.append("--------------------------------------------------------------\n");
			writer.close();
		} catch (IOException e) {
			println("An error occurred.");
			e.printStackTrace();
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();

		int maxTestNumber = 2000;
		int currentTestNumber = maxTestNumber;
		int arrayLength = 1024;
		int misses = 0;
		int currentRound = 1;
		int maxRounds = 3;

		// Pro Runde werden 2000 Test mit jeweils zufällig generierten Arrays und Keys gemacht, 
		// die Ergebnisse werden in einer Liste gespeichert und am Ende werden die Mittelwert 
		// ermittelt und in eine generierte Textdatei geschrieben.
		// Wird der key nicht im array gefunden, wird der Zähler als negative Zahl von der Methode zurückgegeben.
		
		while (currentRound <= maxRounds) {

			int sequentialSearchLHit = 0;
			int sequentialSearchFHit = 0;
			int binarySearchRecHit = 0;
			int binarySearchHit = 0;
			int binarySearchRecExtCounterHit = 0;
			int binarySearchExtCounterHit = 0;

			int sequentialSearchLMiss = 0;
			int sequentialSearchFMiss = 0;
			int binarySearchRecMiss = 0;
			int binarySearchMiss = 0;
			int binarySearchRecExtCounterMiss = 0;
			int binarySearchExtCounterMiss = 0;

			while (currentTestNumber > 0) {

				// hier wird der key und das array generiert, die Zahlen sind so gewählt, 
				// damit circa gleichviele Tests erfolgreich und erfolglos verlaufen:
				
				int testKey = (int) (Math.random() * arrayLength + (arrayLength / 3) + 1);

				int[] testArray = new int[arrayLength];
				for (int i = 0; i < arrayLength; i++) {
					testArray[i] = (int) (Math.random() * arrayLength + (arrayLength / 2)) + 1;
				}

				if (sequentialSearchL(testArray, testKey) > 0)
					sequentialSearchLHit += sequentialSearchL(testArray, testKey);
				else {
					misses++;
					sequentialSearchLMiss += (sequentialSearchL(testArray, testKey) * (-1));
				}

				if (sequentialSearchF(testArray, testKey) > 0)
					sequentialSearchFHit += sequentialSearchF(testArray, testKey);
				else
					sequentialSearchFMiss += (sequentialSearchF(testArray, testKey) * (-1));
				

				selectionSort(testArray);

				if (binarySearchRec(testArray, testKey) > 0)
					binarySearchRecHit += binarySearchRec(testArray, testKey);
				else 
					binarySearchRecMiss += (binarySearchRec(testArray, testKey) * (-1));
				

				if (binarySearchRecExtCounter(testArray, testKey) > 0)
					binarySearchRecExtCounterHit += binarySearchRecExtCounter(testArray, testKey);
				else
					binarySearchRecExtCounterMiss += (binarySearchRecExtCounter(testArray, testKey) * (-1));

				if (binarySearch(testArray, testKey) > 0)
					binarySearchHit += binarySearch(testArray, testKey);
				else 
					binarySearchMiss += (binarySearch(testArray, testKey) * (-1));
				

				if (binarySearchExtCounter(testArray, testKey) > 0)
					binarySearchExtCounterHit += binarySearchExtCounter(testArray, testKey);
				else
					binarySearchExtCounterMiss += (binarySearchExtCounter(testArray, testKey) * (-1));

				currentTestNumber--;
			}

			list.add(sequentialSearchLHit / (maxTestNumber - misses));
			list.add(sequentialSearchFHit / (maxTestNumber - misses));
			list.add(binarySearchRecHit / (maxTestNumber - misses));
			list.add(binarySearchHit / (maxTestNumber - misses));
			list.add(binarySearchRecExtCounterHit / (maxTestNumber - misses));
			list.add(binarySearchExtCounterHit / (maxTestNumber - misses));

			list.add(sequentialSearchLMiss / misses);
			list.add(sequentialSearchFMiss / misses);
			list.add(binarySearchRecMiss / misses);
			list.add(binarySearchMiss / misses);
			list.add(binarySearchRecExtCounterMiss / misses);
			list.add(binarySearchExtCounterMiss / misses);

			listInFile(list, arrayLength, myFile, misses, maxTestNumber);

			println("Erfolgreich von " +maxTestNumber+ " Tests: " +(maxTestNumber - misses)+ " (Array-Größe: " +arrayLength+ ")");
			
			misses = 0;
			currentTestNumber = maxTestNumber;
			list.clear();
			arrayLength *= 2;
			currentRound++;

		}

		try {
		FileWriter writer = new FileWriter(myFile, true);
		
		writer.append("\n");
		writer.append("                           | Sequenzielle Suche  | Binäre Suche\n");
		writer.append("---------------------------|---------------------|-------------------\n");
		writer.append("bester Fall                |  1 Vergleich        | 1 Vergleich\n");
		writer.append("schlechterter Fall         |  n Vergleiche       | log2(n) Vergleiche\n");
		writer.append("Erfolgreich (Durchschnitt) |  2/n Vergleiche     | log2(n) Vergleiche\n");
		writer.append("Erfolglos (Durchschnitt)   |  n Vergleiche       | log2(n) Vergleiche\n");

		writer.close();
		
		} catch (IOException e) {
			println("An error occurred.");
			e.printStackTrace();
		}
		
		print("Es wurde erfolgreich in die Textdatei geschrieben.");
	}

}
