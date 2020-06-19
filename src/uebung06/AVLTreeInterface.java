package pr2.uebung06;

public interface AVLTreeInterface {

	/**
	 * Insert element into AVL tree.
	 * 
	 * @param val Element to be inserted
	 * @return true, if insertion was successful, otherwise false.
	 */
	public void insert(Comparable elem);

	/**
	 * Insert elements from file into AVL tree.
	 * 
	 * @param filename
	 * @param elementTyp "IntElement", "StringElement" or "Song"
	 */
	public void insert(String filename, String elementTyp);

	/**
	 * Checks whether the AVL tree contains a certain element.
	 * 
	 * @param val Element, that has to be checked if it is in the AVL tree
	 * @return true, if AVL tree contains Elements, otherwise false
	 */
	boolean contains(Comparable val);

	/**
	 * Removes a certain Element from the AVL tree.
	 * 
	 * @param val Element to be removed
	 * @return true, if removal was successful, otherwise false.
	 */
	public void remove(Comparable elem);

	/**
	 * Print AVL tree in inorder: First the left child node, then the parent node
	 * and at last the right child node.
	 */
	public void printInorder();

	/**
	 * Print AVL tree in preorder: First the parent node, then the left child node
	 * and at last the right child node.
	 */
	public void printPreorder();

	/**
	 * Print AVL tree in postorder: First the left child node, then the right child
	 * node and at last the parent.
	 */
	public void printPostorder();

	/**
	 * Print AVL tree in levelorder: first the first tree level, then the second
	 * tree level, ...
	 */
	public void printLevelorder();

	/**
	 * Counts the number of values within the AVL tree.
	 * 
	 * @return number of values
	 */
	public int size();

	/**
	 * Counts the height of the AVL tree.
	 * 
	 * @return height
	 */
	public int height();

	/**
	 * Returns the element with the biggest value within the AVL tree.
	 * 
	 * @return Element with biggest value
	 */
	public Comparable getMax();

	/**
	 * Returns the element with the smallest value within the AVL tree.
	 * 
	 * @return Element with smallest value
	 */
	public Comparable getMin();

	/**
	 * Returns whether AVL tree is empty.
	 * 
	 * @return true, if it is empty, otherwise false.
	 */
	public boolean isEmpty();

	/**
	 * Removes all elements from the AVL tree.
	 */
	public void clear();

	/**
	 * Stores Elements from AVL tree into file in preorder.
	 * 
	 * @param filename Name of file in which the elements are to be stored
	 * @return true, if storing of elements was successful, otherwise false.
	 */
	public void saveToFile(String filename);

	/**
	 * Visualize AVL tree.
	 */
	public void visualize();

}
