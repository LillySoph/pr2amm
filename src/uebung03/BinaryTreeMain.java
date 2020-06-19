package pr2.uebung03;

import static pr.MakeItSimple.print;
import static pr.MakeItSimple.println;
import static pr.MakeItSimple.readInt;
import static pr.MakeItSimple.readString;

public class BinaryTreeMain {
	
	public static void main(String[] args) {
		
		String[] facts = { "A node can have one, two or no child nodes.",
				"The root node is the first node of the tree.",
				"An unbalanced tree is a tree where the leaves don't have the same depth.",
				"The binary tree is the most used tree in computer science.",
				"Another name for the binary tree is 2-nary tree.",
				"The way the tree is shaped depends on the order the elements were inserted.",
				"Traveling through a binary tree is called traversal.",
				"Nodes which have a right and a left child are sometimes called full nodes.",
				"Nodes which have no child nodes are called leaves.",
				"Every node has a parent except for the root node." };
		
		BinaryTree[] trees = new BinaryTree[4];
		int treesLength = trees.length;
		for (int i = 0; i < treesLength; i++) {
			trees[i] = new MyBinaryTree();
		}

		boolean active;
		println("Do you want your binary trees to contain [int] or [string] elements? ");
		String decision = readString().toLowerCase();
		String elementType;
		
		if (decision.equals("string")) {
			elementType = "StringElements";
			active = true;
		} else {
			elementType = "IntElements";
			active = true;
		}
		int treeIndex = 0;
		while (active) {

			BinaryTree currentTree = trees[treeIndex];
			println("");
			println("****   MENU   ****");

			for (int i = 0; i < treesLength; i++) {
				if (i == treeIndex)
					print(">> Tree[" + i + "] <<");
				else
					print("   Tree[" + i + "]   ");
			}
			println("");
			println("[1]  Insert Element");
			println("[2]  Insert Elements From File");
			println("[3]  Remove Element");
			println("[4]  Print Binary Tree");
			println("[5]  Get Size And Height");
			println("[6]  Get Max And Min Element");
			println("[7]  Look For Element");
			println("[8]  Clear Binary Tree");
			println("[9]  Save To File");
			println("[10] Clone Binary Tree");
			println("[11] Change Current Tree");
			println("[12] Compare Two Binary Trees");
			println("[42] Random Binary Tree Fact");
			println("[0]  Exit Menu");
			int menu = readInt();

			// Insert StringElement
			if (menu == 1 && elementType.equals("StringElements")) {
				decision = "";
				while (!decision.equals("menu")) {
					print("Enter the string value that you want to insert: ");
					String value = readString();
					if (currentTree.insert(new StringElement(value)))
						println("Insertion was successful.");
					else
						println("Dublicates are not allowed.");
					println("Press enter to insert another element. Otherwise enter [menu].");
					decision = readString();
				}
			}
			// Insert IntElement
			else if (menu == 1 && elementType.equals("IntElements")) {
				decision = "";
				while (!decision.equals("menu")) {
					print("Enter the int value that you want to insert: ");
					int value = readInt();
					if (currentTree.insert(new IntElement(value)))
						println("Insertion was successful.");
					else
						println("Dublicates are not allowed.");
					println("Press enter to insert another element. Otherwise enter [menu].");
					decision = readString();
				}
			}
			// Insert Elements From File
			else if (menu == 2) {
				print("Enter the name of the file: ");
				String filename = readString();
				if (currentTree.insert(filename))
					println("Insertion from file " + filename + " was successful.");
				else
					println("Something went wrong.");
			}
			// Remove Elements
			else if (menu == 3) {
				if (currentTree.isEmpty()) {
					println("Tree is empty.");
				} else {
					decision = "";
					while (!decision.equals("menu")) {
						Element element;
						if (elementType.equals("IntElements")) {
							print("Enter the int value that you want to remove: ");
							int value = readInt();
							element = new IntElement(value);
						} else {
							print("Enter the string value that you want to remove: ");
							String value = readString();
							element = new StringElement(value);
						}
						if (!currentTree.contains(element))
							println("Tree does not contain the element " + element.toString() + ".");
						else if (currentTree.remove(element))
							println("Removal of " + element.toString() + " was successful.");
						else
							println("Something went wrong.");
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
						println("Enter [in]order, [pre]order, [post]order or [level]order to print the tree. ");
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
						} else if (print.equals("level") || print.equals("Level")) {
							print("Levelorder: ");
							currentTree.printLevelorder();
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
					Element minElement = currentTree.getMin();
					Element maxElement = currentTree.getMax();
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
					Element element;

					if (elementType.equals("StringElements")) {
						print("Enter the string value you are looking for: ");
						String value = readString();
						element = new StringElement(value);
					} else {
						print("Enter the int value you are looking for: ");
						int value = readInt();
						element = new IntElement(value);
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
					if (currentTree.saveToFile(filename))
						println("Saving to file " + filename + " was successful.");
					else
						println("Something went wrong.");
				}
			}
			// Clone
			else if (menu == 10) {
				println("Chose one of the following tree indices for the clone of Tree[" + treeIndex + "]: ");
				for (int i = 0; i < treesLength; i++) {
					if (i != treeIndex) {
						print("Tree[" + i + "]  ");
					}
				}
				int cloneIndex = readInt();
				if (cloneIndex != treeIndex && cloneIndex < treesLength && cloneIndex >= 0) {
					trees[cloneIndex] = (MyBinaryTree) trees[treeIndex].clone();
					println("Tree[" + treeIndex + "] was succesfully cloned into Tree[" + cloneIndex + "]");
				} else {
					println("Invalid index.");
				}

			}
			// Change Current Tree
			else if (menu == 11) {
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
			// Compare
			else if (menu == 12) {
				println("Chose one of the following indices to compare Tree[" + treeIndex + "] with: ");
				for (int i = 0; i < treesLength; i++) {
					if (i != treeIndex) {
						print("Tree[" + i + "]  ");
					}
				}
				int compareIndex = readInt();
				if (compareIndex != treeIndex && compareIndex < treesLength && compareIndex >= 0) {
					if (trees[treeIndex].equal(trees[compareIndex]))
						println("++ Tree[" + treeIndex + "] & Tree[" + compareIndex + "] have the same content. ++");
					else
						println("-- Tree[" + treeIndex + "] & Tree[" + compareIndex + "] don't have the same content. --");

					if (trees[treeIndex].equals(trees[compareIndex]))
						println("++ Tree[" + treeIndex + "] & Tree[" + compareIndex
								+ "] have the same content and structure. ++");
					else
						println("-- Tree[" + treeIndex + "] & Tree[" + compareIndex
								+ "] don't have the same content and structure. --");
				} else {
					println("Invalid index.");
				}
			}
			// Fandom Fact
			else if (menu == 42) {
				println("Here is your random binary tree fact my friend:");
				int randomNumber = (int) (Math.random() * facts.length);
				println(facts[randomNumber]);
			}
			// Exit Menu
			else if (menu == 0) {
				active = false;
				println("Goodbye for now my friend.");
			}
			// Wrong Number
			else {
				println("I am sorry my friend. This number does not exist here. Please choose something else.");
			}
		}
	}
}