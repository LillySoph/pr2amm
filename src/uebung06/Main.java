package pr2.uebung06;

import static pr.MakeItSimple.*;

public class Main {

	public static void main(String[] args) {

		AVLTreeInterface[] trees = new AVLTreeI[4];
		int treesLength = trees.length;
		for (int i = 0; i < treesLength; i++) {
			trees[i] = new AVLTreeI();
		}

		boolean active;
		println("Do you want your AVL trees to contain [int], [string] or [song] elements? ");
		String decision = readString().toLowerCase();
		String elementType;

		if (decision.equals("string")) {
			elementType = "StringElement";
			active = true;
		} else if (decision.equals("int")) {
			elementType = "IntElement";
			active = true;
		} else {
			elementType = "Song";
			active = true;
		}
		int treeIndex = 0;
		while (active) {

			AVLTreeInterface currentTree = trees[treeIndex];
			println("");
			println("* * * * * * * *   M A I N   M E N U   * * * * * * * *");

			for (int i = 0; i < treesLength; i++) {
				if (i == treeIndex)
					print(">> Tree[" + i + "] <<");
				else
					print("   Tree[" + i + "]   ");
			}
			println("\n --> Element type: " + elementType);
			println("[1]  Insert Element      [2]  Insert Elements From File");
			println("[3]  Remove Element      [4]  Print AVL Tree");
			println("[5]  Get Size And Height [6]  Get Max And Min Element");
			println("[7]  Look For Element    [8]  Clear AVL Tree");
			println("[9]  Save To File        [10] Change Current Tree");
			println("[11] Visualize           [0]  EXIT\n");
			int menu = readInt();

			// Insert StringElement
			if (menu == 1 && elementType.equals("StringElement")) {
				decision = "";
				while (!decision.equals("menu")) {
					print("Enter the string value that you want to insert: ");
					String value = readString();
					currentTree.insert(new StringElement(value));
					println("Press enter to insert another element. Otherwise enter [menu].");
					decision = readString();
				}
			}
			// Insert IntElement
			else if (menu == 1 && elementType.equals("IntElement")) {
				decision = "";
				while (!decision.equals("menu")) {
					print("Enter the int value that you want to insert: ");
					int value = readInt();
					currentTree.insert(new IntElement(value));
					println("Press enter to insert another element. Otherwise enter [menu].");
					decision = readString();
				}
			}
			// Insert Song
			else if (menu == 1 && elementType.equals("Song")) {
				decision = "";
				while (!decision.equals("menu")) {
					print("\nEnter the song titel: ");
					String titel = readString();
					print("\nEnter the number of artists: ");
					String[] artists = new String[readInt()];
					for (int i = 0; i < artists.length; i++) {
						print("\nEnter artist " + (i + 1) + ": ");
						artists[i] = readString();
					}
					print("\nEnter the album name: ");
					String album = readString();
					currentTree.insert(new SongImplementation(titel, artists, album));
					println("Press enter to insert another element. Otherwise enter [menu].");
					decision = readString();
				}
			}
			// Insert Elements From File
			else if (menu == 2) {
				print("Enter the name of the file: ");
				String filename = readString();
				currentTree.insert(filename, elementType);
			}
			// Remove Elements
			else if (menu == 3) {
				if (currentTree.isEmpty()) {
					println("Tree is empty.");
				} else {
					decision = "";
					while (!decision.equals("menu")) {
						Comparable element;
						if (elementType.equals("IntElement")) {
							print("Enter the int value that you want to remove: ");
							int value = readInt();
							element = new IntElement(value);
						} else if (elementType.equals("StringElement")) {
							print("Enter the string value that you want to remove: ");
							String value = readString();
							element = new StringElement(value);
						} else {
							println("Enter the song that you want to remove: ");
							print("\nEnter the song titel: ");
							String titel = readString();
							print("\nEnter the number of artists: ");
							String[] artists = new String[readInt()];
							for (int i = 0; i < artists.length; i++) {
								print("\nEnter artist " + (i + 1) + ": ");
								artists[i] = readString();
							}
							print("\nEnter the album name: ");
							String album = readString();
							element = new SongImplementation(titel, artists, album);
						}
						if (!currentTree.contains(element))
							println("Tree does not contain the element " + element.toString() + ".");
						currentTree.remove(element);
						println("Press enter to remove another element. Otherwise enter [menu].");
						decision = readString();
					}
				}
			}
			// Print Tree
			else if (menu == 4) {
				if (currentTree.isEmpty()) {
					println("Tree is empty.");
				} else {
					String print = "";
					while (!print.equals("menu")) {
						println("Enter [in]order, [pre]order or [post]order to print the tree. ");
						print = readString();
						if (print.equals("in") || print.equals("In")) {
							print("Inorder: ");
							currentTree.printInorder();
							println("");
						} else if (print.equals("pre") || print.equals("Pre")) {
							print("Preorder: ");
							currentTree.printPreorder();
							println("");
						} else if (print.equals("post") || print.equals("Post")) {
							print("Postorder: ");
							currentTree.printPostorder();
							println("");
						}
						println("Press enter to print the tree again. Otherwise enter [menu]. ");
						print = readString();
					}
				}
			}
			// Get Size & Height
			else if (menu == 5) {
				int size = currentTree.size();
				if (size == 0) {
					println("Tree is empty.");
				} else {
					println("Size:   " + size);
					println("Height: " + currentTree.height());
				}
			}
			// Get Max & Min Element
			else if (menu == 6) {
				int size = currentTree.size();
				if (size == 0) {
					println("Tree is empty.");
				} else {
					Comparable minElement = currentTree.getMin();
					Comparable maxElement = currentTree.getMax();
					if (size == 1 && minElement.compareTo(maxElement) == 0) {
						println("Element only contains one element which is the max and min element at the same time: "
								+ currentTree.getMin());
					} else {
						println("Max element: " + minElement);
						println("Min element: " + maxElement);
					}
				}
			}
			// Look for Element
			else if (menu == 7) {
				if (currentTree.isEmpty()) {
					println("Tree is empty.");
				} else {
					Comparable element;

					if (elementType.equals("StringElement")) {
						print("Enter the string value you are looking for: ");
						String value = readString();
						element = new StringElement(value);
					} else if (elementType.equals("IntElement")) {
						print("Enter the int value you are looking for: ");
						int value = readInt();
						element = new IntElement(value);
					} else {
						println("Enter the song you are looking for: ");
						print("\nEnter the song titel: ");
						String titel = readString();
						print("\nEnter the number of artists: ");
						String[] artists = new String[readInt()];
						for (int i = 0; i < artists.length; i++) {
							print("\nEnter artist " + (i + 1) + ": ");
							artists[i] = readString();
						}
						print("\nEnter the album name: ");
						String album = readString();
						element = new SongImplementation(titel, artists, album);
					}
					if (currentTree.contains(element))
						println("Tree does contain the element  " + element.toString() + ".");
					else
						println("Tree does not contain the element  " + element.toString() + ".");
				}
			}
			// Clear Tree
			else if (menu == 8) {
				if (currentTree.isEmpty()) {
					println("Tree is already empty.");
				} else {
					println("Tree was cleared.");
					currentTree.clear();
				}
			}
			// Save Tree To File
			else if (menu == 9) {
				if (currentTree.isEmpty()) {
					println("Tree is empty.");
				} else {
					print("Enter the name of the file: ");
					String filename = readString();
					currentTree.saveToFile(filename);
				}
			}
			// Change Current Tree
			else if (menu == 10) {
				println("You are currently working with Tree[" + treeIndex
						+ "]. Chose one of the following indices to change the current tree: ");
				for (int i = 0; i < treesLength; i++) {
					if (i != treeIndex) {
						print("Tree[" + i + "]  ");
					}
				}
				int newIndex = readInt();
				if (newIndex != treeIndex && newIndex < treesLength && newIndex >= 0) {
					treeIndex = newIndex;
					println("You are now working with Tree[" + treeIndex + "]");
				} else {
					println("Invalid index.");
				}
			}
			// Visualize tree
			else if (menu == 11) {
				currentTree.visualize();
			}
			// Exit Menu
			else if (menu == 0) {
				active = false;
				println("Goodbye.");
			}
		}
	}
}