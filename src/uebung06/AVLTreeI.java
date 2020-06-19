package pr2.uebung06;

import static pr.MakeItSimple.*;
import graphvisualizer.TreeVisualizer;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTreeI implements AVLTreeInterface {

	private AVLTreeNode root;

	public AVLTreeI() {

	}

	public AVLTreeI(Comparable value) {
		this.root = new AVLTreeNode(value);
	}

	@Override
	public void insert(Comparable elem) {
		// cannot insert null node
		if (elem == null)
			return;

		// binary tree is empty, the new element becomes its root
		AVLTreeNode newNode = new AVLTreeNode(elem);
		if (this.isEmpty()) {
			this.root = newNode;
			return;
		}

		// call recursive method to insert node
		insertRecursively(newNode, this.root);
	}

	@Override
	public void insert(String filename, String elementTyp) {
		if (filename == null || elementTyp == null || (!elementTyp.equals("IntElement")
				&& !elementTyp.equals("StringElement") && !elementTyp.equals("Song"))) {
			println("Invalid filename or element type.");
			return;
		}
		// read file content into array and insert elements into tree
		int[] fileContentAsIntegers;
		String[] fileContentAsStrings;
		if (elementTyp.equals("IntElement")) {
			fileContentAsIntegers = readIntegerArray(filename);
			for (int i = 0; i < fileContentAsIntegers.length; i++) {
				insert(new IntElement(fileContentAsIntegers[i]));
			}
		} else {
			fileContentAsStrings = readStringArray(filename);
			if (elementTyp.equals("Song")) {
				String title, album;
				String[] artists;
				// file content must be split into title, artists and album
				for (int i = 0; i < fileContentAsStrings.length; i++) {
					String[] song = fileContentAsStrings[i].split(";");
					title = song[0];
					album = song[1];
					artists = new String[song.length - 2];
					for (int j = 0; j < artists.length; j++) {
						artists[j] = song[j + 2];
					}
					insert(new SongImplementation(title, artists, album));
				}
			} else {
				for (int i = 0; i < fileContentAsStrings.length; i++) {
					insert(new StringElement(fileContentAsStrings[i]));
				}
			}
		}
	}

	@Override
	public void remove(Comparable elem) {
		// cannot remove null node and node that is not in tree
		if (elem == null || !this.contains(elem))
			return;

		// call recursive method to remove node
		removeRecursively(new AVLTreeNode(elem), this.root, false);
	}

	/**
	 * Insert new element recursively. Updates balance value of node to balance out
	 * tree if necessary.
	 * 
	 * @param newNode     node to be inserted
	 * @param currentNode node to start the recursion with (root)
	 */
	private void insertRecursively(AVLTreeNode newNode, AVLTreeNode currentNode) {
		int comparison = (newNode.getValue()).compareTo(currentNode.getValue());
		// check for dublicate
		if (comparison == 0) {
			return;
		}
		// go to left subtree
		else if (comparison < 0) {
			// call recursive method with left child node & update balance of current node
			if (currentNode.getLeft() != null) {
				insertRecursively(newNode, currentNode.getLeft());
			}
			// set new node as left child of node & update balance of current node
			else {
				currentNode.setLeft(newNode);
			}
		}
		// go to right subtree
		else {
			// call recursive method with right child node & update balance of current node
			if (currentNode.getRight() != null) {
				insertRecursively(newNode, currentNode.getRight());
			}
			// set new node as right child of node & update balance of current node
			else {
				currentNode.setRight(newNode);
			}
		}
		// update balance & rebalance tree if neccessary
		updateBalance(currentNode);
		if (isImbalanced(currentNode)) {
			rebalanceTree(currentNode);
		}
	}

	/**
	 * Remove element recursively. First looks for the remove node and then, if
	 * necessary, the replace node. Removes node and updates balance value of node
	 * to balance out tree if necessary.
	 * 
	 * @param removeNode      node to be removed
	 * @param currentNode     node to start the recursion with (root)
	 * @param findReplaceNode false: looks for remove node, true: looks for replace
	 *                        node
	 */
	private void removeRecursively(AVLTreeNode removeNode, AVLTreeNode currentNode, boolean findReplaceNode) {
		// compare current node with remove node
		int comparison = (removeNode.getValue()).compareTo(currentNode.getValue());

		// find node to replace remove node
		if (findReplaceNode) {
			// looking of replace node
			if (currentNode.getLeft() != null) {
				removeRecursively(removeNode, currentNode.getLeft(), findReplaceNode);
			}
			// replace node was found : remove and replace node
			else {
				AVLTreeNode replaceNode = currentNode;
				Comparable valueOfReplace = replaceNode.getValue();
				AVLTreeNode childOfReplace = replaceNode.getRight();
				// copy value of replace node to remove node
				removeNode.setValue(valueOfReplace);
				// replace node has no child node
				if (childOfReplace == null) {
					// eliminate duplicate reference to replace node
					AVLTreeNode parentOfReplace = getParentOf(replaceNode);
					if (parentOfReplace.getLeft() == replaceNode)
						parentOfReplace.setLeft(null);
					else
						parentOfReplace.setRight(null);
				}
				// replace node has right child nodes
				else {
					// copy value of child to replace node
					replaceNode.setValue(childOfReplace.getValue());
					// copy references to child nodes of child to replace node
					replaceNode.setLeft(childOfReplace.getLeft());
					replaceNode.setRight(childOfReplace.getRight());
				}
			}
		}
		// remove node is found
		else if (comparison == 0) {
			removeNode = currentNode;
			AVLTreeNode leftChild = removeNode.getLeft();
			AVLTreeNode rightChild = removeNode.getRight();
			// remove node has two child nodes
			if (leftChild != null && rightChild != null) {
				findReplaceNode = true;
				removeRecursively(removeNode, currentNode.getRight(), findReplaceNode);
			}
			// remove node has no child nodes
			else if (leftChild == null && rightChild == null) {
				if (removeNode == root) {
					clear();
				} else {
					AVLTreeNode parentOfNode = getParentOf(removeNode);
					if (parentOfNode.getLeft() == removeNode)
						parentOfNode.setLeft(null);
					else
						parentOfNode.setRight(null);
				}
			}
			// remove node only has left child node
			else if (leftChild != null) {
				removeNode.setValue(leftChild.getValue());
				removeNode.setLeft(leftChild.getLeft());
				removeNode.setRight(leftChild.getRight());
			}
			// remove node only has right child node
			else {
				removeNode.setValue(rightChild.getValue());
				removeNode.setLeft(rightChild.getLeft());
				removeNode.setRight(rightChild.getRight());
			}
			// go to left subtree to look for remove node
		} else if (comparison < 0) {
			// call recursive method with left child node
			if (currentNode.getLeft() != null)
				removeRecursively(removeNode, currentNode.getLeft(), findReplaceNode);
		}
		// go to right subtree to look for remove node
		else {
			// call recursive method with right child node
			if (currentNode.getRight() != null)
				removeRecursively(removeNode, currentNode.getRight(), findReplaceNode);
		}
		// update balance value of curent node & rebalance tree if necessary
		if (currentNode != null) {
			updateBalance(currentNode);
			if (isImbalanced(currentNode))
				rebalanceTree(currentNode);
		}
	}

	/**
	 * Checks whether the node is imbalanced, meaning a balance over 1 or under -1.
	 * 
	 * @param node
	 * @return true, if node is imbalanced, else false
	 */
	private boolean isImbalanced(AVLTreeNode node) {
		return (Math.abs(node.getBalance()) > 1);
	}

	/**
	 * Updates balance of given tree node.
	 * 
	 * @param node
	 */
	private void updateBalance(AVLTreeNode node) {
		int leftHeight = 0;
		int rightHeight = 0;
		int balance;
		if (node == null)
			return;

		if (node.getLeft() != null)
			leftHeight = 1 + getHeightRecursively(node.getLeft());

		if (node.getRight() != null)
			rightHeight = 1 + getHeightRecursively(node.getRight());

		balance = leftHeight - rightHeight;
		node.setBalance(balance);
	}

	/**
	 * Returns parent node of given tree node.
	 * 
	 * @param node
	 * @return null, if node is root, else parent node
	 */
	private AVLTreeNode getParentOf(AVLTreeNode node) {
		AVLTreeNode parentNode = this.root;
		// root has no parent node
		if (node == root)
			return null;
		// iterate through binary tree to find the parent node
		while (parentNode.getLeft() != node && parentNode.getRight() != node) {
			if (node.getValue().compareTo(parentNode.getValue()) < 0) {
				parentNode = parentNode.getLeft();
			} else {
				parentNode = parentNode.getRight();
			}
		}
		return parentNode;
	}

	/**
	 * Rebalances tree by applying rotation.
	 * 
	 * @param imbalancedNode
	 */
	private void rebalanceTree(AVLTreeNode node) {
		int balance = node.getBalance();
		AVLTreeNode balancedNode = null;
		// left left case / left right case
		if (balance > 1) {

			// left rotation
			if (node.getLeft().getLeft() == null
					|| getHeightRecursively(node.getLeft().getRight()) > getHeightRecursively(node.getLeft().getLeft()))
				node.setLeft(rotateLeft(node.getLeft()));

			// right rotation
			balancedNode = rotateRight(node);
		}

		// right right case / right left case
		else if (balance < -1) {

			// right rotation
			if (node.getRight().getRight() == null || getHeightRecursively(
					node.getRight().getLeft()) > getHeightRecursively(node.getRight().getRight()))
				node.setRight(rotateRight(node.getRight()));

			// left rotation
			balancedNode = rotateLeft(node);
		}

		// balanced node replaces old node
		if (node == root) {
			root = balancedNode;
		} else {
			AVLTreeNode parentOfNode = getParentOf(node);
			if (parentOfNode.getLeft() == node)
				parentOfNode.setLeft(balancedNode);
			else
				parentOfNode.setRight(balancedNode);
		}
	}

	/**
	 * Rotates node with its right child. Returns right child with node as right
	 * child.
	 * 
	 * @param node
	 * @return
	 */
	public AVLTreeNode rotateLeft(AVLTreeNode node) {
		// rotate nodes
		AVLTreeNode rightChild = node.getRight();
		node.setRight(rightChild.getLeft());
		rightChild.setLeft(node);
		// update balance
		updateBalance(rightChild);
		updateBalance(node);
		updateBalance(node.getRight());
		return rightChild;
	}

	/**
	 * Rotates node with its left child. Returns right child with node as right
	 * child.
	 * 
	 * @param node
	 * @return
	 */
	public AVLTreeNode rotateRight(AVLTreeNode node) {
		// rotate nodes
		AVLTreeNode leftChild = node.getLeft();
		node.setLeft(leftChild.getRight());
		leftChild.setRight(node);
		// update balance
		updateBalance(leftChild);
		updateBalance(node);
		updateBalance(node.getLeft());
		return leftChild;
	}

	/* METHODS TO PRINT TREE */

	@Override
	public void printInorder() {
		if (this.isEmpty()) {
			return;
		} else {
			recursiveInorder(this.root);
		}
	}

	@Override
	public void printPreorder() {
		if (this.isEmpty()) {
			return;
		} else {
			recursivePreorder(this.root);
		}
	}

	@Override
	public void printPostorder() {
		if (this.isEmpty()) {
			return;
		} else {
			recursivePostorder(this.root);
		}
	}

	@Override
	public void printLevelorder() {
		if (this.isEmpty()) {
			return;
		} else {
			Queue<AVLTreeNode> queue = new LinkedList<AVLTreeNode>();
			AVLTreeNode node = this.root;

			while (node != null) {
				print(node.toString() + " ");
				if (node.getLeft() != null) {
					queue.add(node.getLeft());
				}
				if (node.getRight() != null) {
					queue.add(node.getRight());
				}
				node = queue.poll();
			}
		}
	}

	/* HELPER METHODS TO PRINT TREE */

	/* HELPER METHODS TO PRINT TREES */

	/**
	 * * Recursive method to print tree in inorder
	 * 
	 * @param node
	 */
	private void recursiveInorder(AVLTreeNode node) {
		if (node != null) {
			// visit nodes in left subtree
			recursiveInorder(node.getLeft());
			// print visited nodes
			print(node.toString() + " ");
			// visit nodes in right subtree
			recursiveInorder(node.getRight());
		}
	}

	/**
	 * Recursive method to print tree in preorder
	 * 
	 * @param node
	 */
	private void recursivePreorder(AVLTreeNode node) {
		if (node != null) {
			// print visited nodes
			print(node.toString() + " ");
			// visit left subtree
			recursivePreorder(node.getLeft());
			// visit right subtree
			recursivePreorder(node.getRight());
		}
	}

	/**
	 * Recursive method to print tree in postorder
	 * 
	 * @param node
	 */
	private void recursivePostorder(AVLTreeNode node) {
		if (node != null) {
			// visit nodes in left subtree
			recursivePostorder(node.getLeft());
			// visit nodes in right subtree
			recursivePostorder(node.getRight());
			// print visited nodes
			print(node.toString() + " ");
		}
	}

	/* METHODS TO GET INFORMATION ABOUT TREE */

	@Override
	public boolean contains(Comparable val) {
		AVLTreeNode child = root;
		// checks if tree is not empty
		while (child != null) {
			// if both elements are equal
			if (val.compareTo(child.getValue()) == 0) {
				return true;
			} else if (val.compareTo(child.getValue()) < 0) {
				// element value is smaller, search in the left subtree
				child = child.getLeft();
			} else {
				// element value is greater, search in right subtree
				child = child.getRight();
			}
		}
		return false;
	}

	@Override
	public int size() {
		if (this.isEmpty()) {
			return 0;
		} else {
			return getSizeRecursively(this.root);
		}
	}

	@Override
	public int height() {
		if (this.isEmpty())
			return 0;
		else if (root.getLeft() == null && root.getRight() == null)
			return 1;
		return getHeightRecursively(this.root) + 1;
	}

	@Override
	public Comparable getMax() {
		AVLTreeNode maxNode = root;
		// check if tree is empty
		if (this.isEmpty()) {
			return null;
		}
		// search right-standing node with max value in right subtree
		while (maxNode.getRight() != null) {
			maxNode = maxNode.getRight();
		}
		// found node with max value
		return maxNode.getValue();
	}

	@Override
	public Comparable getMin() {
		AVLTreeNode minNode = root;
		if (this.isEmpty()) {
			return null;
		}
		// search left-standing node with min value in left subtree
		while (minNode.getLeft() != null) {
			minNode = minNode.getLeft();
		}
		// found node with min value
		return minNode.getValue();
	}

	@Override
	public boolean isEmpty() {
		return this.root == null;
	}

	@Override
	public void clear() {
		this.root = null;
	}

	/* HELPTER METHODS TO GET INFORMATION ABOUT TREE */

	/**
	 * Recursive method to count elements in tree.
	 * 
	 * @param node
	 * @return
	 */
	private int getSizeRecursively(AVLTreeNode node) {
		int sumOfNodes = 0;
		// test if tree is empty
		if (node == null) {
			// there is no node to count
			return 0;
		} else {
			// one node exists
			sumOfNodes += 1;
			// first, counts left-standing nodes in subtree
			int nodeLeft = getSizeRecursively(node.getLeft());
			// second, counts right-standing nodes in subtree
			int nodeRight = getSizeRecursively(node.getRight());
			// sum all nodes in left subtree
			sumOfNodes += nodeLeft;
			// sum all nodes in right subtree
			sumOfNodes += nodeRight;
			return sumOfNodes;
		}
	}

	/**
	 * Recursive method to count height of tree.
	 * 
	 * @param node
	 * @return
	 */
	private int getHeightRecursively(AVLTreeNode node) {
		if (node == null || (node.getRight() == null && node.getLeft() == null))
			return 0;
		return (max(getHeightRecursively(node.getLeft()), getHeightRecursively(node.getRight())) + 1);
	}

	/**
	 * Compares two int values and returns the bigger one.
	 * 
	 * @param firstInt
	 * @param secondInt
	 * @return
	 */
	private int max(int firstInt, int secondInt) {
		if (firstInt > secondInt)
			return firstInt;
		else
			return secondInt;
	}

	/* METHOD TO SAVE TREE IN FILE */

	@Override
	public void saveToFile(String filename) {

	}

	/* VISUALIZE TREE */

	@Override
	public void visualize() {
		TreeVisualizer tv = new TreeVisualizer(2);
		tv.draw(this.root);
	}
}
