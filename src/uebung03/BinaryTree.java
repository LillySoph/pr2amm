package pr2.uebung03;

public interface BinaryTree {

	/**
	 * Insert element into binary tree.
	 * 
	 * @param val Element to be inserted
	 * @return true, if insertion was successful, otherwise false.
	 */
	public boolean insert(Element val);

	/**
	 * Insert elements from file into binary tree.
	 * 
	 * @param filename Name of file with the elements to be inserted
	 * @return true, if insertion of at least one element of file was successful,
	 *         otherwise false.
	 */
	boolean insert(String filename);

	/**
	 * Stores Elements from binary tree into file in preorder.
	 * 
	 * @param filename Name of file in which the elements are to be stored
	 * @return true, if storing of elements was successful, otherwise false.
	 */
	boolean saveToFile(String filename);

	/**
	 * Checks whether the binary tree contains a certain element.
	 * 
	 * @param val Element, that has to be checked if it is in the binary tree
	 * @return true, if binary tree contains Elements, otherwise false
	 */
	boolean contains(Element val);

	/**
	 * Counts the number of values within the binary tree.
	 * 
	 * @return number of values
	 */
	int size();

	/**
	 * Counts the height of the binary tree.
	 * 
	 * @return height
	 */
	int height();

	/**
	 * Returns the element with the biggest value within the binary tree.
	 * 
	 * @return Element with biggest value
	 */
	Element getMax();

	/**
	 * Returns the element with the smallest value within the binary tree.
	 * 
	 * @return Element with smallest value
	 */
	Element getMin();

	/**
	 * Removes a certain Element from the binary tree.
	 * 
	 * @param val Element to be removed
	 * @return true, if removal was successful, otherwise false.
	 */
	boolean remove(Element val);

	/**
	 * Returns whether binary tree is empty.
	 * 
	 * @return true, if it is empty, otherwise false.
	 */
	boolean isEmpty();

	/**
	 * Removes all elements from the binary tree.
	 */
	void clear();

	/**
	 * Insert all values from another binary tree into this tree.
	 * 
	 * @param otherTree which values are copied into this tree
	 * @return this tree with copied values from otherTree
	 */
	BinaryTree addAll(BinaryTree otherTree);

	/**
	 * Print binary tree in inorder: First the left child node, then the parent node
	 * and at last the right child node.
	 */
	void printInorder();

	/**
	 * Print binary tree in postorder: First the left child node, then the right
	 * child node and at last the parent.
	 */
	void printPostorder();

	/**
	 * Print binary tree in preorder: First the parent node, then the left child
	 * node and at last the right child node.
	 */
	void printPreorder();

	/**
	 * Print binary tree in levelorder: first the first tree level, then the second
	 * tree level, ...
	 */
	void printLevelorder();

	Object clone(); // creates a deep copy of tree

	/**
	 * Check whether this tree and the parameter tree are structurally equivalent by
	 * comparing element by element.
	 * 
	 * @param other Tree to be compared with
	 * @return true, if they are equal, otherwise false
	 */
	boolean equals(Object other);

	/**
	 * Check whether this tree and the parameter tree are equivalent in regards to
	 * their content.
	 * 
	 * @param other Tree to be compared with
	 * @return true, if their content is equal, otherwise false
	 */
	boolean equal(BinaryTree otherTree);

}