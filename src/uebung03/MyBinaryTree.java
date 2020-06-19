package pr2.uebung03;

import static pr.MakeItSimple.*;

import java.util.LinkedList;
import java.util.Queue;

class MyBinaryTree implements BinaryTree {

	private TreeNode root;

	@Override
	public boolean insert(Element val) {

		// create new node with parameter element
		TreeNode newNode = new TreeNode(val);

		// binary tree is empty, the new element becomes its root
		if (this.isEmpty()) {
			root = newNode;
			return true;
		}

		// else, iterate through tree to find right position to insert the new element
		TreeNode currentNode = root;

		while (currentNode != null) {
			// new value is bigger than current, go to right child
			if (val.compareTo(currentNode.getElement()) > 0) {
				// insert element if right child is empty
				if (currentNode.getRight() == null) {
					currentNode.setRight(newNode);
					return true;
				}
				currentNode = currentNode.getRight();
			}

			// new value is smaller than current, go to left child
			else if (val.compareTo(currentNode.getElement()) < 0) {
				// insert element if left child is empty
				if (currentNode.getLeft() == null) {
					currentNode.setLeft(newNode);
					return true;
				}
				currentNode = currentNode.getLeft();
			}

			// values are equal: the insertion is impossible
			else {
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean insert(String filename) {
		if(filename == null)
			return false;
		String[] fileContentAsString = readStringArray(filename);
		boolean canBeStoredInIntArray = canBeStoredInIntArray(fileContentAsString);
		boolean successfulInsertion = false;
		
		// file contains strings
		if (!canBeStoredInIntArray) {
			for (int i = 0; i < fileContentAsString.length; i++) {
				Element fileElement = new StringElement(fileContentAsString[i]);

				// if insert of (at least one) element was successful
				if (this.insert(fileElement))
					successfulInsertion = true;
			}
			return successfulInsertion;
		}

		// file only contains integers
		else if (canBeStoredInIntArray) {
			int[] fileContentAsInt = readIntegerArray(filename);
			for (int i = 0; i < fileContentAsInt.length; i++) {
				Element fileElement = new IntElement(fileContentAsInt[i]);

				// insert of (at least one) element was successful
				if (this.insert(fileElement))
					successfulInsertion = true;
			}
			return successfulInsertion;
		}
		return successfulInsertion;
	}

	/**
	 * Checks whether content of string array can be stored in integer array.
	 * 
	 * @param array string array to be checked
	 * @return true, if storing in integer array is possible, otherwise return false
	 */
	private boolean canBeStoredInIntArray(String[] array) {
		for (int i = 0; i < array[0].length(); i++) {
			if ((array[0].charAt(i) < '0' || array[0].charAt(i) > '9') && array[0].charAt(i) != ' ')
				return false;
		}
		return true;
	}
	
	/**
	 * Stores Elements from binary tree into file in preorder.
	 * 
	 * @param filename Name of file in which the elements are to be stored
	 * @return true, if storing of elements was successful, otherwise false.
	 */
	@Override
	public boolean saveToFile(String filename) {
		if (this.isEmpty() || filename == null) {
			return false;
		} else {
			String[] array = new String[this.size()];
			saveElementsInArrayPreorder(this.root, array, 0);
			// writes the numbers from the array separately and closes the file
			saveStringArray(array, filename);
			// elements are saved
			return true;
		}
	}

	/**
	 * helper method to store elements from binary tree into an array by using
	 * preorder traversal
	 * 
	 * @param node
	 * @param array
	 * @param position
	 */
	private int saveElementsInArrayPreorder(TreeNode node, String[] array, int position) {
		// checks if node has no children, add into array
		if (node == null) {
			return position;
		} else {
			array[position++] = node.getElement().toString();
			// visits left subtree
			position = saveElementsInArrayPreorder(node.getLeft(), array, position);
			// visits right subtree
			position = saveElementsInArrayPreorder(node.getRight(), array, position);
			// go to next node
			return position;
		}
	}

	@Override
	public boolean contains(Element val) {
		TreeNode child = root;
		// checks if tree is not empty
		while (child != null) {
			// if both elements are equal
			if (val.compareTo(child.getElement()) == 0) {
				return true;
			} else if (val.compareTo(child.getElement()) < 0) {
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
			return getSizeRecursive(this.root);
		}
	}

	/**
	 * recursive helper method to sum the nodes in tree
	 * 
	 * @param node
	 * @return size of tree
	 */
	private int getSizeRecursive(TreeNode node) {
		int sumOfNodes = 0;
		// test if tree is empty
		if (node == null) {
			// there is no node to count
			return 0;
		} else {
			// one node exists
			sumOfNodes += 1;
			// first, counts left-standing nodes in subtree
			int nodeLeft = getSizeRecursive(node.getLeft());
			// second, counts right-standing nodes in subtree
			int nodeRight = getSizeRecursive(node.getRight());
			// sum all nodes in left subtree
			sumOfNodes += nodeLeft;
			// sum all nodes in right subtree
			sumOfNodes += nodeRight;
			return sumOfNodes;
		}
	}

	@Override
	public int height() {
		if (this.isEmpty())
			return 0;
		else if (root.getLeft() == null && root.getRight() == null)
			return 1;
		return getHeight(this.root) + 1;
	}

	/**
	 * Counts height of left and right subtree and returns the bigger value.
	 * 
	 * @param node
	 * @return
	 */
	private int getHeight(TreeNode node) {
		if (node == null || (node.getRight() == null && node.getLeft() == null))
			return 0;
		return (max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1);
	}

	/**
	 * Compares two int values.
	 * 
	 * @param firstInt
	 * @param secondInt
	 * @return the bigger int value
	 */
	private int max(int firstInt, int secondInt) {
		if (firstInt > secondInt)
			return firstInt;
		else
			return secondInt;
	}

	@Override
	public Element getMax() {
		TreeNode maxNode = root;
		// check if tree is empty
		if (this.isEmpty()) {
			return null;
		}
		// search right-standing node with max value in right subtree
		while (maxNode.getRight() != null) {
			maxNode = maxNode.getRight();
		}
		// found node with max value
		return maxNode.getElement();
	}

	@Override
	public Element getMin() {
		TreeNode minNode = root;
		if (this.isEmpty()) {
			return null;
		}
		// search left-standing node with min value in left subtree
		while (minNode.getLeft() != null) {
			minNode = minNode.getLeft();
		}
		// found node with min value
		return minNode.getElement();
	}
	
	@Override
	public boolean remove(Element val) {
		// find tree node with element val
		TreeNode removeNode = findNodeWith(val);

		// tree is empty or does not contain element
		if (removeNode == null)
			return false;

		// look for node to replace removeNode with
		TreeNode replaceNode = getReplaceNode(removeNode);

		// removeNode has no child nodes
		if (replaceNode == null) {
			removeNodeWithoutChild(removeNode);
			return true;
		}
		// removeNode has two child nodes
		else if (removeNode.getLeft() != null && removeNode.getRight() != null) {
			removeFullNode(replaceNode, removeNode);
			return true;
		}
		// removeNode only has one child node
		else  {
			removeNodeWithOneChild(replaceNode, removeNode);
			return true;
		}
	}

	/**
	 * Helper method for remove method. Finds node to replace the parameter node.
	 * 
	 * @param removeNode node to be removed
	 * @return If node only has one child node, return child node. If node has no
	 *         child nodes, return null. If node has two child nodes, return
	 *         smallest node in right sub tree.
	 */
	private TreeNode getReplaceNode(TreeNode removeNode) {
		TreeNode rightChild = removeNode.getRight();
		TreeNode leftChild = removeNode.getLeft();
		// node has no child nodes
		if (rightChild == null && leftChild == null)
			return null;
		// node has only a left child node
		else if (rightChild == null)
			return leftChild;
		// node has only a right child node
		else if (leftChild == null)
			return rightChild;
		// node has two child nodes
		TreeNode replaceNode = rightChild;
		while (replaceNode.getLeft() != null) {
			replaceNode = replaceNode.getLeft();
		}
		return replaceNode;
	}

	/**
	 * Helper method to remove nodes with no child nodes.
	 * 
	 * @param removeNode Tree node to be removed
	 */
	private void removeNodeWithoutChild(TreeNode removeNode) {
		// node to be deleted is root
		if (removeNode == this.root) {
			this.clear();
			return;
		}
		// else delete reference from parent to node
		TreeNode parentOfNode = getParentOf(removeNode);
		boolean isLeftChild = (parentOfNode.getLeft() == removeNode);
		if (isLeftChild)
			parentOfNode.setLeft(null);
		else
			parentOfNode.setRight(null);
	}

	/**
	 * Helper method to remove nodes with two child nodes.
	 * 
	 * @param replaceNode Tree node to replace node
	 * @param removeNode        Tree node to be removed
	 */
	private void removeFullNode(TreeNode replaceNode, TreeNode removeNode) {
		// temporarely store child and parent of replace node
		TreeNode childOfReplace = replaceNode.getRight();
		TreeNode parentOfReplace = getParentOf(replaceNode);

		// get parent of node to be deleted
		TreeNode parentOfNode = getParentOf(removeNode);

		// child nodes from node become child nodes of replace node
		// except if replace node is direct child of node
		TreeNode leftChildOfNode = removeNode.getLeft();
		TreeNode rightChildOfNode = removeNode.getRight();
		if (replaceNode != leftChildOfNode)
			replaceNode.setLeft(leftChildOfNode);
		if (replaceNode != rightChildOfNode)
			replaceNode.setRight(rightChildOfNode);

		// move replace node to place of node
		if (removeNode == this.root)
			this.root = replaceNode;
		else if (parentOfNode.getRight() == removeNode)
			parentOfNode.setRight(replaceNode);
		else
			parentOfNode.setLeft(replaceNode);

		// overwrite duplicate reference to replace node with reference to its child
		// except if replace node is direct child of node
		boolean isDirectChild = (parentOfReplace == removeNode);
		if (!isDirectChild)
			parentOfReplace.setLeft(childOfReplace);
	}

	/**
	 * Helper method to remove nodes with one child node.
	 * 
	 * @param child Tree node that is only child of node
	 * @param removeNode  Tree node to be removed
	 */
	private void removeNodeWithOneChild(TreeNode child, TreeNode removeNode) {
		// node to be deleted is root
		if (removeNode == this.root) {
			this.root = child;
			return;
		}
		
		// else overwrite reference from parent to node with reference to only child
		TreeNode parentOfNode = getParentOf(removeNode);
		boolean isLeftChild = (parentOfNode.getLeft() == removeNode);
		if (isLeftChild)
			parentOfNode.setLeft(child);
		else
			parentOfNode.setRight(child);
	}

	/**
	 * Finds tree node with parameter element.
	 * 
	 * @param val element to be found
	 * @return tree node with searched element or null, if tree does not contain
	 *         element.
	 */
	private TreeNode findNodeWith(Element val) {
		// checks if tree contains element
		if (!this.contains(val)) {
			return null;
		}
		// iterate through binary tree to find tree node with element
		TreeNode currentNode = this.root;
		while (true) {
			if (currentNode == null)
				return null;
			if (currentNode.getElement().compareTo(val) == 0)
				return currentNode;
			else if (currentNode.getElement().compareTo(val) > 0)
				currentNode = currentNode.getLeft();
			else
				currentNode = currentNode.getRight();
		}
	}

	/**
	 * Looks for parent node of parameter child node.
	 * 
	 * @param childNode
	 * @return parent node or null, if child node is root
	 */
	
	private TreeNode getParentOf(TreeNode childNode) {
		TreeNode parentNode = this.root;
		// root has no parent node
		if (childNode == root)
			return null;
		// iterate through binary tree to find the parent node
		while (parentNode.getLeft() != childNode && parentNode.getRight() != childNode) {
			if (childNode.getElement().compareTo(parentNode.getElement()) < 0) {
				parentNode = parentNode.getLeft();
			} else {
				parentNode = parentNode.getRight();
			}
		}
		return parentNode;
	}

	@Override
	public boolean isEmpty() {
		return this.root == null;
	}

	@Override
	public void clear() {
		this.root = null;
	}

	@Override
	public BinaryTree addAll(BinaryTree otherTree) {
		MyBinaryTree otherBinaryTree = (MyBinaryTree) otherTree;
		// trees contain elements from different types
		if (!this.isFromSameTypeThan(otherBinaryTree)) {
			return null;
		}
		// insert elements from parameter tree into this tree in preorder
		else {
			this.insertInPreorder(otherBinaryTree.root);
			return this;
		}
	}

	/**
	 * Recursive method to insert elements to this tree in preorder
	 * 
	 * @param node start node, often root from other tree
	 */
	private void insertInPreorder(TreeNode node) {
		// reached end of (sub) tree
		if (node == null)
			return;
		// insert node element to this tree
		this.insert(node.getElement());
		// call method recursively to reach subtrees
		insertInPreorder(node.getLeft());
		insertInPreorder(node.getRight());
	}
	

	/**
	 * Checks if both trees contain the same type of elements.
	 * 
	 * @param otherTree
	 * @return true, if they contain the same type of elements or at least one is
	 *         empty, otherwise false.
	 */
	private boolean isFromSameTypeThan(MyBinaryTree otherTree) {
		// one or both trees contain no elements or both contain only StringElements or
		// only IntElements
		if (otherTree.root == null || this.root == null
				|| (this.root.getElement() instanceof StringElement
						&& otherTree.root.getElement() instanceof StringElement)
				|| (this.root.getElement() instanceof IntElement
						&& otherTree.root.getElement() instanceof IntElement)) {
			return true;
		}
		// they contain different types of elements
		else {
			return false;
		}
	}
	
	@Override
	public void printInorder() {
		if (this.isEmpty()) {
			return;
		} else {
			recursiveInorder(this.root);
		}
	}

	/**
	 * recursive helper method for printInorder
	 * 
	 * @param node
	 */

	private void recursiveInorder(TreeNode node) {
		// parent node has a child node
		if (node != null) {
			// visit nodes in left subtree
			recursiveInorder(node.getLeft());
			// print visited nodes
			print(node.getElement().toString() + " ");
			// visit nodes in right subtree
			recursiveInorder(node.getRight());
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
	
	/**
	 * recursive helper method for printPostorder
	 * 
	 * @param AVLTreeNode node
	 */
	private void recursivePostorder(TreeNode node) {

		if (node != null) {
			// visit nodes in left subtree
			recursivePostorder(node.getLeft());
			// visit nodes in right subtree
			recursivePostorder(node.getRight());
			// print visited nodes
			print(node.getElement().toString() + " ");
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

	/**
	 * recursive helper method for printPreorder
	 * 
	 * @param AVLTreeNode node
	 */
	private void recursivePreorder(TreeNode node) {

		if (node != null) {
			// print visited nodes
			print(node.getElement().toString() + " ");
			// visit left subtree
			recursivePreorder(node.getLeft());
			// visit right subtree
			recursivePreorder(node.getRight());

		}
	}
	
	@Override
	public void printLevelorder() {
		if (this.isEmpty()) {
			return;
		} else {
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			TreeNode node = this.root;

			while (node != null) {
				print(node.getElement().toString() + " ");
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

	@Override
	public boolean equal(BinaryTree otherTree) {
		MyBinaryTree otherBinaryTree = (MyBinaryTree) otherTree;
		// both trees are empty
		if (this.isEmpty() && otherBinaryTree.isEmpty())
			return true;

		// compare sizes of both binary trees
		if (this.size() != otherBinaryTree.size())
			return false;

		// check content
		if (!this.containsAllElementsOf(otherBinaryTree))
			return false;
		return true;
	}

	/**
	 * Checks if this and other tree have the same content, by storing each content
	 * in an string array in inorder and comparing the array string by string.
	 * 
	 * @param other
	 * @return true, if both are equivalent regarding their content, otherwise false
	 */
	private boolean containsAllElementsOf(MyBinaryTree other) {
		int treeSize = this.size();

		String[] thisArray = new String[treeSize];
		String[] otherArray = new String[treeSize];

		this.saveInInorder(this.root, thisArray);
		other.saveInInorder(other.root, otherArray);

		for (int i = 0; i < treeSize; i++) {
			if (!thisArray[i].equals(otherArray[i]))
				return false;
		}
		return true;
	}

	/**
	 * Store elements from tree as strings in string array in inorder.
	 * 
	 * @param node  start node, often the tree root
	 * @param array empty array to store elements as strings in
	 */
	private void saveInInorder(TreeNode node, String[] array) {
		// call method recursively to reach left subtree
		if (node.getLeft() != null)
			saveInInorder(node.getLeft(), array);
		int index = freeSlotIn(array);
		// get free slot within array
		if (index != -1 && node != null)
			array[index] = node.getElement().toString();
		// reached end of (sub) tree or array is full
		else
			return;
		// call method recursively to reach right subtree
		if (node.getRight() != null)
			saveInInorder(node.getRight(), array);
	}
	
	@Override
	public boolean equals(Object other) {
		MyBinaryTree otherBinaryTree = (MyBinaryTree) other;
		// check if both trees are empty
		if (this.isEmpty() && otherBinaryTree.isEmpty())
			return true;
		// check if same size
		if (this.size() != otherBinaryTree.size())
			return false;
		// check if same height
		if (this.height() != otherBinaryTree.height())
			return false;
		// check if same content and structure
		if (!this.sameStructureLike(otherBinaryTree))
			return false;
		return true;
	}

	/**
	 * Checks if this and other tree have the same content and structure, by storing
	 * each content in an string array in preorder and comparing the array string by
	 * string.
	 * 
	 * @param other
	 * @return true, if both are equivalent regarding their content and structure,
	 *         otherwise false
	 */
	private boolean sameStructureLike(MyBinaryTree other) {
		int treeSize = this.size();
		String[] thisArray = new String[treeSize];
		String[] otherArray = new String[treeSize];
		this.saveInPreorder(this.root, thisArray);
		other.saveInPreorder(other.root, otherArray);
		for (int i = 0; i < treeSize; i++) {
			if (!thisArray[i].equals(otherArray[i]))
				return false;
		}
		return true;
	}

	/**
	 * Store elements from tree as strings in string array in preorder.
	 * 
	 * @param node  start node, often the tree root
	 * @param array empty array to store elements as strings in
	 */
	private void saveInPreorder(TreeNode node, String[] array) {
		// get free slot within array
		int index = freeSlotIn(array);
		// store element as string in array
		if (index != -1 && node != null) {
			array[index] = node.getElement().toString();
		}
		// reached end of (sub) tree or array is full
		else
			return;
		// call method recursively to reach all nodes within tree
		saveInPreorder(node.getLeft(), array);
		saveInPreorder(node.getRight(), array);
	}
	
	/**
	 * find first free slot in array.
	 * 
	 * @param array string array
	 * @return index of first free slot
	 */
	private int freeSlotIn(String[] array) {
		// find spot in array with null
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null)
				return i;
		}
		return -1;
	}
	
	/**
	 * creates a deep copy of tree
	 */
	@Override
	public BinaryTree clone() {
		BinaryTree cloneTree = new MyBinaryTree();
		cloneTree.addAll(this);
		return cloneTree;
	}

}
