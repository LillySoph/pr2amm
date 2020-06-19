package pr2.uebung03;

// helper class for MyBinaryTree

public class TreeNode {

	private Element elem;
	private TreeNode left;
	private TreeNode right;

	public TreeNode() {
	}

	/**
	 * Constructor to create a new TreeNode object. Sets element as the nodes value
	 * and sets left and right child node to null.
	 * 
	 * @param elem New TreeNodes value
	 */
	public TreeNode(Element elem) {
		this.elem = elem;
		this.left = this.right = null;
	}

	/**
	 * Returns left subtree node.
	 */
	public TreeNode getLeft() {
		return this.left;
	}

	/**
	 * Returns right subtree node.
	 */
	public TreeNode getRight() {
		return this.right;
	}
	
	/**
	 * Returns the element of the tree node.
	 */
	public Element getElement() {
		return this.elem;
	}
	
	/**
	 * Sets e as the element of the tree node.
	 */
	public void setElement(Element e) {
		this.elem = e;

	}

	/**
	 * Sets nodeLeft as left child node of tree node.
	 */
	public void setLeft(TreeNode nodeLeft) {
		this.left = nodeLeft;
	}

	/**
	 * Sets nodeRight as right child node of tree node.
	 */
	public void setRight(TreeNode nodeRight) {
		this.right = nodeRight;
	}
	
}
