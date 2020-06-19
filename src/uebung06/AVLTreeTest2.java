package pr2.uebung06;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AVLTreeTest2 {

	AVLTreeI tree = new AVLTreeI();
	int[] t1content = { 5, 3, 11, 1, 7, 6, 9 };
	int[] t2content = { 12, 7, 30, 5, 10, 15, 35, 3, 6, 8, 11, 20, 33, 40 };

	@Test
	public void insertTest1() {

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		tree.insert(new IntElement(5));
		tree.printPreorder();

		String expected2 = "5(0) ";
		assertEquals(expected2, outContent.toString());

		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		tree.insert(new IntElement(3));
		tree.printPreorder();

		String expected3 = "5(1) 3(0) ";
		assertEquals(expected3, outContent.toString());

		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		tree.insert(new IntElement(11));
		tree.printPreorder();

		String expected4 = "5(0) 3(0) 11(0) ";
		assertEquals(expected4, outContent.toString());

		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		tree.insert(new IntElement(1));
		tree.printPreorder();

		String expected5 = "5(1) 3(1) 1(0) 11(0) ";
		assertEquals(expected5, outContent.toString());

		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		tree.insert(new IntElement(7));
		tree.printPreorder();

		String expected6 = "5(0) 3(1) 1(0) 11(1) 7(0) ";
		assertEquals(expected6, outContent.toString());

		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		tree.insert(new IntElement(6));
		tree.printPreorder();

		String expected7 = "5(0) 3(1) 1(0) 7(0) 6(0) 11(0) ";
		assertEquals(expected7, outContent.toString());

		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		tree.insert(new IntElement(9));
		tree.printPreorder();

		String expected8 = "5(-1) 3(1) 1(0) 7(-1) 6(0) 11(1) 9(0) ";
		assertEquals(expected8, outContent.toString());

		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

	}

	@Test
	public void removeTest1() {

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		for (int i = 0; i < t1content.length; i++) {
			tree.insert(new IntElement(t1content[i]));
		}

		tree.remove(new IntElement(1));
		tree.printPreorder();

		String expectedi1 = "7(0) 5(0) 3(0) 6(0) 11(1) 9(0) ";
		assertEquals(expectedi1, outContent.toString());

		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		tree.remove(new IntElement(11));
		tree.printPreorder();

		String expectedi2 = "7(1) 5(0) 3(0) 6(0) 9(0) ";
		assertEquals(expectedi2, outContent.toString());

		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		// remove root node
		tree.remove(new IntElement(7));
		tree.printPreorder();

		String expectedi3 = "5(-1) 3(0) 9(1) 6(0) ";
		assertEquals(expectedi3, outContent.toString());

		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		tree.remove(new IntElement(9));
		tree.printPreorder();

		String expectedi4 = "5(0) 3(0) 6(0) ";
		assertEquals(expectedi4, outContent.toString());
	}

	@Test
	public void insertTest2() {
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		tree.insert(new IntElement(12));
		tree.printPreorder();

		String expected1 = "12(0) ";
		assertEquals(expected1, outContent.toString());

		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		tree.insert(new IntElement(7));
		tree.printPreorder();

		String expected2 = "12(1) 7(0) ";
		assertEquals(expected2, outContent.toString());

		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		tree.insert(new IntElement(30));
		tree.printPreorder();

		String expected3 = "12(0) 7(0) 30(0) ";
		assertEquals(expected3, outContent.toString());

		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		tree.insert(new IntElement(5));
		tree.printPreorder();

		String expected4 = "12(1) 7(1) 5(0) 30(0) ";
		assertEquals(expected4, outContent.toString());

		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		tree.insert(new IntElement(10));
		tree.printPreorder();

		String expected5 = "12(1) 7(0) 5(0) 10(0) 30(0) ";
		assertEquals(expected5, outContent.toString());

		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		tree.insert(new IntElement(15));
		tree.printPreorder();

		String expected6 = "12(0) 7(0) 5(0) 10(0) 30(1) 15(0) ";
		assertEquals(expected6, outContent.toString());

		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		tree.insert(new IntElement(35));
		tree.printPreorder();

		String expected7 = "12(0) 7(0) 5(0) 10(0) 30(0) 15(0) 35(0) ";
		assertEquals(expected7, outContent.toString());

		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		tree.insert(new IntElement(3));
		tree.printPreorder();

		String expected8 = "12(1) 7(1) 5(1) 3(0) 10(0) 30(0) 15(0) 35(0) ";
		assertEquals(expected8, outContent.toString());

		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		tree.insert(new IntElement(6));
		tree.printPreorder();

		String expected9 = "12(1) 7(1) 5(0) 3(0) 6(0) 10(0) 30(0) 15(0) 35(0) ";
		assertEquals(expected9, outContent.toString());

		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		tree.insert(new IntElement(8));
		tree.printPreorder();

		String expected10 = "12(1) 7(0) 5(0) 3(0) 6(0) 10(1) 8(0) 30(0) 15(0) 35(0) ";
		assertEquals(expected10, outContent.toString());

		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		tree.insert(new IntElement(11));
		tree.printPreorder();

		String expected11 = "12(1) 7(0) 5(0) 3(0) 6(0) 10(0) 8(0) 11(0) 30(0) 15(0) 35(0) ";
		assertEquals(expected11, outContent.toString());

		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		tree.insert(new IntElement(20));
		tree.printPreorder();

		String expected12 = "12(0) 7(0) 5(0) 3(0) 6(0) 10(0) 8(0) 11(0) 30(1) 15(-1) 20(0) 35(0) ";
		assertEquals(expected12, outContent.toString());

		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		tree.insert(new IntElement(33));
		tree.printPreorder();

		String expected13 = "12(0) 7(0) 5(0) 3(0) 6(0) 10(0) 8(0) 11(0) 30(0) 15(-1) 20(0) 35(1) 33(0) ";
		assertEquals(expected13, outContent.toString());

		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		tree.insert(new IntElement(40));
		tree.printPreorder();

		String expected14 = "12(0) 7(0) 5(0) 3(0) 6(0) 10(0) 8(0) 11(0) 30(0) 15(-1) 20(0) 35(0) 33(0) 40(0) ";
		assertEquals(expected14, outContent.toString());
		
	}

	@Test
	public void removeTest2() {

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		for (int i = 0; i < t2content.length; i++) {
			tree.insert(new IntElement(t2content[i]));
		}

		tree.remove(new IntElement(8));
		tree.printPreorder();

		String expectedi1 = "12(0) 7(0) 5(0) 3(0) 6(0) 10(-1) 11(0) 30(0) 15(-1) 20(0) 35(0) 33(0) 40(0) ";
		assertEquals(expectedi1, outContent.toString());

		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		tree.remove(new IntElement(7));
		tree.printPreorder();

		String expectedi2 = "12(0) 10(1) 5(0) 3(0) 6(0) 11(0) 30(0) 15(-1) 20(0) 35(0) 33(0) 40(0) ";
		assertEquals(expectedi2, outContent.toString());

		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		// remove root node
		tree.remove(new IntElement(35));
		tree.printPreorder();

		String expectedi3 = "12(0) 10(1) 5(0) 3(0) 6(0) 11(0) 30(0) 15(-1) 20(0) 40(1) 33(0) ";
		assertEquals(expectedi3, outContent.toString());

		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		tree.remove(new IntElement(15));
		tree.printPreorder();

		String expectedi4 = "12(0) 10(1) 5(0) 3(0) 6(0) 11(0) 30(-1) 20(0) 40(1) 33(0) ";
		assertEquals(expectedi4, outContent.toString());
		
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		tree.remove(new IntElement(30));
		tree.printPreorder();

		String expectedi5 = "12(1) 10(1) 5(0) 3(0) 6(0) 11(0) 33(0) 20(0) 40(0) ";
		assertEquals(expectedi5, outContent.toString());
		
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		tree.remove(new IntElement(12));
		tree.printPreorder();

		String expectedi6 = "20(1) 10(1) 5(0) 3(0) 6(0) 11(0) 33(-1) 40(0) ";
		assertEquals(expectedi6, outContent.toString());
		
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		tree.remove(new IntElement(40));
		tree.printPreorder();

		String expectedi7 = "10(0) 5(0) 3(0) 6(0) 20(0) 11(0) 33(0) ";
		assertEquals(expectedi7, outContent.toString());
		
	}

}
