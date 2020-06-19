package pr2.uebung03;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryTreeBigTest {

	MyBinaryTree tree = new MyBinaryTree(); 
	MyBinaryTree tree2 = new MyBinaryTree();
	
	@Test
	public void removeLeaf() {
		
		int[] intArray = {30, 15, 50, 5, 20, 40, 70, 1, 7, 18, 35, 60, 80, 3, 38};
		insertFromArray(intArray);
		
		assertEquals(15, tree.size());
		assertEquals(5, tree.height());
		
		assertEquals(true, tree.remove(new IntElement(3)));
		assertEquals(14, tree.size());
		assertEquals(5, tree.height());
		
		assertEquals(true, tree.remove(new IntElement(18)));
		assertEquals(13, tree.size());
		assertEquals(5, tree.height());
		
		assertEquals(true, tree.remove(new IntElement(38)));
		assertEquals(12, tree.size());
		assertEquals(4, tree.height());
		
		assertEquals(true, tree.remove(new IntElement(60)));
		assertEquals(11, tree.size());
		assertEquals(4, tree.height());
		
		assertEquals(true, tree.remove(new IntElement(80)));
		assertEquals(10, tree.size());
		assertEquals(4, tree.height());
		
	}
	
	@Test
	public void removeRootAsOnlyNode() {
			
		assertEquals(true, tree.insert(new IntElement(5)));
//		assertEquals(true, tree.isRoot(new IntElement(5)));
		assertEquals(1, tree.size());
		assertEquals(1, tree.height());
		
		assertEquals(false, tree.remove(new IntElement(4)));
		assertEquals(true, tree.remove(new IntElement(5)));
		assertEquals(0, tree.size());
		assertEquals(0, tree.height());
		
	}
	
	@Test
	public void removeWithOneSubTree() {
		
		int[] intArray = {30, 15, 5, 1, 7, 3, 20};
		insertFromArray(intArray);
		
		assertEquals(7, tree.size());
		assertEquals(5, tree.height());
		assertEquals(true, tree.remove(new IntElement(30)));
		
//		assertEquals(true, tree.isRoot(new IntElement(15)));
		assertEquals(6, tree.size());
		assertEquals(4, tree.height());
		
		tree.clear();
		
		int[] intArray2 = {30, 50, 40, 70, 60, 80,};
		insertFromArray(intArray2);
		
		assertEquals(6, tree.size());
		assertEquals(4, tree.height());
		assertEquals(true, tree.remove(new IntElement(30)));
		
//		assertEquals(true, tree.isRoot(new IntElement(50)));
		assertEquals(5, tree.size());
		assertEquals(3, tree.height());
		
	}
	
	@Test
	public void removeRootWithTwoChildNodes() {
		
		int[] intArray = {30, 15, 50, 5, 20, 40, 70, 1, 7, 18, 35, 60, 80, 3, 38};
		insertFromArray(intArray);
		
		assertEquals(15, tree.size());
		assertEquals(5, tree.height());
		assertEquals(true, tree.remove(new IntElement(30)));
		
//		assertEquals(true, tree.isRoot(new IntElement(35)));
		assertEquals(14, tree.size());
		assertEquals(5, tree.height());
		
	}
	
	@Test
	public void removeNodeWithOneChildNode() {
		
		int[] intArray = {30, 15, 50, 5, 20, 40, 70, 1, 7, 18, 35, 60, 80, 3, 38};
		insertFromArray(intArray);
		
		assertEquals(15, tree.size());
		assertEquals(5, tree.height());
		
		assertEquals(true, tree.remove(new IntElement(1)));
		assertEquals(14, tree.size());
		assertEquals(5, tree.height());
		
		assertEquals(true, tree.remove(new IntElement(20)));
		assertEquals(13, tree.size());
		assertEquals(5, tree.height());
		
		assertEquals(true, tree.remove(new IntElement(35)));
		assertEquals(12, tree.size());
		assertEquals(4, tree.height());
		
	}
	
	@Test
	public void removeNodeWithTwoChildNodes() {
		int[] intArray = {30, 15, 50, 5, 20, 40, 70, 1, 7, 18, 35, 60, 80, 3, 38};
		insertFromArray(intArray);
		
		assertEquals(15, tree.size());
		assertEquals(5, tree.height());
		
		assertEquals(true, tree.remove(new IntElement(5)));
		assertEquals(14, tree.size());
		assertEquals(5, tree.height());
		
		assertEquals(true, tree.remove(new IntElement(70)));
		assertEquals(13, tree.size());
		assertEquals(5, tree.height());

		assertEquals(true, tree.remove(new IntElement(15)));
		assertEquals(12, tree.size());
		assertEquals(5, tree.height());
		
		assertEquals(true, tree.remove(new IntElement(50)));
		assertEquals(11, tree.size());
		assertEquals(5, tree.height());
	}
	
	@Test
	public void equalsBigPP() {
		int[] intArray = {30, 15, 50, 5, 20, 40, 70, 1, 7, 18, 35, 60, 80, 3, 38};
		insertFromArray(intArray);
		
		int[] intArray2 = {30, 20, 50, 5, 15, 40, 70, 1, 7, 18, 35, 60, 80, 3, 38};
		insertFromArray2(intArray2);
		
		tree.printPreorder();
		System.out.println("");
		tree2.printPreorder();
		
		assertEquals(true, tree.equal(tree2));
		assertEquals(false, tree.equals(tree2));
		
	}
	
	void insertFromArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			tree.insert(new IntElement(array[i]));
		}
	}
	
	void insertFromArray2(int[] array) {
		for(int i = 0; i < array.length; i++) {
			tree2.insert(new IntElement(array[i]));
		}
	}
	
	void insertFromArray(String[] array) {
		for(String string : array) {
			tree.insert(new StringElement(string));
		}
	}

	/* Methode für die Tests in MyBinaryTree einfügen:
		public boolean isRoot(IntElement element) {
		return (this.root.getElement().compareTo(element) == 0);
	}
	*/
}
