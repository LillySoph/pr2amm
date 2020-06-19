package pr2.uebung06;

import graphvisualizer.*;

public class AVLTreeNode implements VisualizableOneKeyNode {

	private AVLTreeNode left;
	private AVLTreeNode right;
	private int balance = 0;
	private Comparable key;

	/**
	 * Constructor to create a new AVLTreeNode object. Sets element as the nodes
	 * value, sets left and right child node to null and sets balance to 0 first
	 * because the root has at first no child
	 * 
	 * @param elem Comparable , value to insert in AVLTreeNode
	 */
	public AVLTreeNode(Comparable elem) {
		this.key = elem;
		this.balance = 0;
		this.left = this.right = null;
	}

	/**
	 * Get left subtree node
	 * 
	 * @return left AVLTReeNode
	 */
	public AVLTreeNode getLeft() {
		return this.left;
	}

	/**
	 * Set new left subtree node
	 */
	public void setLeft(AVLTreeNode left) {
		this.left = left;
	}

	/**
	 * Get right subtree node
	 * 
	 * @return right AVLTReeNode
	 */
	public AVLTreeNode getRight() {
		return this.right;
	}

	/**
	 * Set new right subtree node
	 */
	public void setRight(AVLTreeNode right) {
		this.right = right;
	}

	/**
	 * Get balance factor of current node
	 * 
	 * @return balance
	 */
	public int getBalance() {

		return this.balance;
	}

	/**
	 * Set balance with new balance factor
	 * 
	 * @param balance int , new balance factor
	 * 
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}

	/**
	 * Get value of node
	 * 
	 * @return key Comparable
	 */
	public Comparable getValue() {
		return this.key;
	}

	/**
	 * Set new key value
	 * 
	 * @param key Comparable
	 */
	public void setValue(Comparable key) {
		this.key = key;
	}

	/**
	 * Return key and balance of node as string
	 * 
	 * @return key Comparable
	 * @return balance int
	 */
	@Override
	public String toString() {
		return this.key + "(" + this.balance + ")";
	}

	/**
	 * @return children of this node
	 */

	public VisualizableNode[] getChildren() {

		return new VisualizableNode[] { this.left, this.right };
	}

	@Override
	public Object getKey() { // Pro Knoten wird der key + der Balancefaktor beim Aufruf von visualize
								// ausgegeben
		return this.key + " (" + this.balance + ")";
	}

}
