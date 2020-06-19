package pr2.uebung02;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.lang.invoke.MethodHandles;

public class TestAllSorts {
	
	int[]F1;
	int[] F2;
	int[] F3;
	int[] F4;
	int[] F5;
	int[] F6;
	int[] F7;
	int[] F8;
	int[] F9;
	int[] F10;
	int[] F11;
	int[] F12;
	int[] F13;
	int[] F14;

	
	StatObj so;


	

	@Before
	public void prepareTest() {
		F1 = new int[] { 10, 4, 33, 44, 17, 20, 3, 2, 9, 82, 38, 67, 55, 11, 32, 23, 19, 7, 6, 14, 29 };  // zufälliges Feld
		F2 = new int[] { 10, 4, 33, 44, 17, 20, 3, 2, 9, 82, 38, 67, 55, 11, 32, 23, 19, 7, 6, 14, 29, 10, 10 }; // zufälliges Feld mit Duplikaten
		F3 = new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};  // F ist schon sortiert;
		F4 = new int [] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};  // F ist umgekehrt sortiert
		F5 = new int [] {10, 1, 9, 2, 8, 3, 7, 4, 6, 5};  // F ist alternierend, umgekehrt sortiert
		F6 = new int [] {2, 3, 4, 5, 6, 7, 8, 9, 10, 1};  // F ist fast sortiert - das kleinste Element steht ganz rechts
		F7 = new int [] {6, 7, 8, 9, 10, 1, 2, 3, 4, 5};  // F besteht aus 2 sortierten Teilfolgen
        F8 = new int [] {10, 2, 3, 4, 5, 6, 7, 8, 9, 1};  // F ist fast sortiert - nur min und max haben ihre Position vertauscht
        F9 = new int[] {1};
        F10 = new int [] {};
        F11 = new int [] {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};  // F ist fast sortiert - das größte Element steht ganz links
        F12 = new int [] { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }; // F ist sortiert - alle Elemente sind gleich
//        F13 = new int [] {10, 2, 3, 4, 5, 6, 7, 8, 9, 1};  // F ist fast sortiert - nur min und max haben ihre Position vertauscht  //doppelt
        F14 = new int [] {5, 5, 5, 5, 4, 4, 4, 5, 4, 4}; // F hat viele Duplikate

		so = new StatObj();
	}

	@Test
	public void testShakerSort1() {
		SortInterface sm = new ShakerSort();
//		sm.sort(F1, so);
//		assertThat(F1, is(new int[] { 2, 3, 4, 6, 7, 9, 10, 11, 14, 17, 19, 20, 23, 29, 32, 33, 38, 44, 55, 67, 82 }));
////		assertEquals (182, so.getcc());
//		so = new StatObj();
//		sm.sort(F2, so);
//		assertThat(F2, is(new int[] { 2, 3, 4, 6, 7, 9, 10, 10, 10, 11, 14, 17, 19, 20, 23, 29, 32, 33, 38, 44, 55, 67, 82 }));
//		assertEquals (217, so.getcc());
//		so = new StatObj();
//		sm.sort(F3, so);
//		assertThat(F3, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (9, so.getcc());
//		so = new StatObj();
//		sm.sort(F4, so);
//		assertThat(F4, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (45, so.getcc());
//		so = new StatObj();
//		sm.sort(F5, so);
//		assertThat(F5, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (42, so.getcc());
//		so = new StatObj();
//		sm.sort(F6, so);
//		assertThat(F6, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (24, so.getcc());
//		so = new StatObj();
//		sm.sort(F7, so);
//		assertThat(F7, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (45, so.getcc());
//		so = new StatObj();
//		sm.sort(F8, so);
//		assertThat(F8, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (24, so.getcc());
//		so = new StatObj();
//		sm.sort(F9, so);
//		assertThat(F9, is(new int[] { 1}));
//		assertEquals (0, so.getcc());
//		so = new StatObj();
//		sm.sort(F10, so);
//		assertThat(F10, is(new int[] {  }));
//		assertEquals (0, so.getcc());
//		so = new StatObj();
//		sm.sort(F11, so);
//		assertThat(F11, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (17, so.getcc());
//		so = new StatObj();
//		sm.sort(F12, so);
//		assertThat(F12, is(new int[] { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }));
//		assertEquals (9, so.getcc());
//		so = new StatObj();
//		sm.sort(F14, so);
//		assertThat(F14, is(new int[] { 4, 4, 4, 4, 4, 5, 5, 5, 5, 5 }));
//		assertEquals (44, so.getcc());
	}

	@Test
	public void testInsertion1() {    // Normaler Insertin Sort
		SortInterface sm = new InsertionSort();
//		sm.sort(F1, so);
//		assertThat(F1, is(new int[] { 2, 3, 4, 6, 7, 9, 10, 11, 14, 17, 19, 20, 23, 29, 32, 33, 38, 44, 55, 67, 82 }));
//		assertEquals (122, so.getcc());
//		so = new StatObj();
//		sm.sort(F2, so);
//		assertThat(F2, is(new int[] { 2, 3, 4, 6, 7, 9, 10, 10, 10, 11, 14, 17, 19, 20, 23, 29, 32, 33, 38, 44, 55, 67, 82 }));
//		assertEquals (152, so.getcc());
//		so = new StatObj();
//		sm.sort(F3, so);
//		assertThat(F3, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (9, so.getcc());
//		so = new StatObj();
//		sm.sort(F4, so);
//		assertThat(F4, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (45, so.getcc());
//		so = new StatObj();
//		sm.sort(F5, so);
//		assertThat(F5, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (33, so.getcc());
//		so = new StatObj();
//		sm.sort(F6, so);
//		assertThat(F6, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (17, so.getcc());
//		so = new StatObj();
//		sm.sort(F7, so);
//		assertThat(F7, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (33, so.getcc());
//		so = new StatObj();
//		sm.sort(F8, so);
//		assertThat(F8, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (24, so.getcc());
		so = new StatObj();
		sm.sort(F9, so);
		assertThat(F9, is(new int[] { 1}));
		assertEquals (0, so.getcc());
		so = new StatObj();
		sm.sort(F10, so);
		assertThat(F10, is(new int[] {  }));
		assertEquals (0, so.getcc());
		so = new StatObj();
		sm.sort(F11, so);
		assertThat(F11, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
		assertEquals (17, so.getcc());
		so = new StatObj();
		sm.sort(F12, so);
		assertThat(F12, is(new int[] { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }));
		assertEquals (9, so.getcc());
		so = new StatObj();
		sm.sort(F14, so);
		assertThat(F14, is(new int[] { 4, 4, 4, 4, 4, 5, 5, 5, 5, 5 }));
		assertEquals (30, so.getcc());
	}
	
	@Test
	public void testInsertionBS1() {  // Insertion Sort mit binärer Suche nach Einfügeposition
		SortInterface sm = new InsertionSort();
//		sm.sort(F1, so);
//		assertThat(F1, is(new int[] { 2, 3, 4, 6, 7, 9, 10, 11, 14, 17, 19, 20, 23, 29, 32, 33, 38, 44, 55, 67, 82 }));
//		assertEquals (64, so.getcc());
//		so = new StatObj();
//		sm.sort(F2, so);
//		assertThat(F2, is(new int[] { 2, 3, 4, 6, 7, 9, 10, 10, 10, 11, 14, 17, 19, 20, 23, 29, 32, 33, 38, 44, 55, 67, 82 }));
//		assertEquals (73, so.getcc());
//		so = new StatObj();
//		sm.sort(F3, so);
//		assertThat(F3, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (19, so.getcc());
//		so = new StatObj();
//		sm.sort(F4, so);
//		assertThat(F4, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (25, so.getcc());
//		so = new StatObj();
//		sm.sort(F5, so);
//		assertThat(F5, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (21, so.getcc());
//		so = new StatObj();
//		sm.sort(F6, so);
//		assertThat(F6, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (20, so.getcc());
//		so = new StatObj();
//		sm.sort(F7, so);
//		assertThat(F7, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (21, so.getcc());
//		so = new StatObj();
//		sm.sort(F8, so);
//		assertThat(F8, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (23, so.getcc());
		so = new StatObj();
		sm.sort(F9, so);
		assertThat(F9, is(new int[] { 1}));
		assertEquals (0, so.getcc());
		so = new StatObj();
		sm.sort(F10, so);
		assertThat(F10, is(new int[] {  }));
		assertEquals (0, so.getcc());
		so = new StatObj();
		sm.sort(F11, so);
		assertThat(F11, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
		assertEquals (22, so.getcc());
		so = new StatObj();
		sm.sort(F12, so);
		assertThat(F12, is(new int[] { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }));
		assertEquals (19, so.getcc());
		so = new StatObj();
		sm.sort(F14, so);
		assertThat(F14, is(new int[] { 4, 4, 4, 4, 4, 5, 5, 5, 5, 5 }));
		assertEquals (22, so.getcc());
	}
	
//
//	@Test
//	public void testQuick11() { // QuickSort Variante 1
//		SortInterface sm = new QuickSort1();
//		sm.sort(F1, so);
//		assertThat(F1, is(new int[] { 2, 3, 4, 6, 7, 9, 10, 11, 14, 17, 19, 20, 23, 29, 32, 33, 38, 44, 55, 67, 82 }));
//		assertEquals (122, so.getcc());
//		so = new StatObj();
//		sm.sort(F2, so);
//		assertThat(F2, is(new int[] { 2, 3, 4, 6, 7, 9, 10, 10, 10, 11, 14, 17, 19, 20, 23, 29, 32, 33, 38, 44, 55, 67, 82 }));
//		assertEquals (142, so.getcc());
//		so = new StatObj();
//		sm.sort(F3, so);
//		assertThat(F3, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (43, so.getcc());
//		so = new StatObj();
//		sm.sort(F4, so);
//		assertThat(F4, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (42, so.getcc());
//		so = new StatObj();
//		sm.sort(F5, so);
//		assertThat(F5, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (42, so.getcc());
//		so = new StatObj();
//		sm.sort(F6, so);
//		assertThat(F6, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (35, so.getcc());
//		so = new StatObj();
//		sm.sort(F7, so);
//		assertThat(F7, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (44, so.getcc());
//		so = new StatObj();
//		sm.sort(F8, so);
//		assertThat(F8, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (43, so.getcc());
//		so = new StatObj();
//		sm.sort(F9, so);
//		assertThat(F9, is(new int[] { 1}));
//		assertEquals (0, so.getcc());
//		so = new StatObj();
//		sm.sort(F10, so);
//		assertThat(F10, is(new int[] {  }));
//		assertEquals (0, so.getcc());
//		so = new StatObj();
//		sm.sort(F11, so);
//		assertThat(F11, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (36, so.getcc());
//		so = new StatObj();
//		sm.sort(F12, so);
//		assertThat(F12, is(new int[] { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }));
//		assertEquals (34, so.getcc());
//		so = new StatObj();
//		sm.sort(F14, so);
//		assertThat(F14, is(new int[] { 4, 4, 4, 4, 4, 5, 5, 5, 5, 5 }));
//		assertEquals (34, so.getcc());
//	}
//	
//	@Test
//	public void testQuick21() {   // QuickSort Variante 2
//		SortInterface sm = new QuickSort2();
//		sm.sort(F1, so);
//		assertThat(F1, is(new int[] { 2, 3, 4, 6, 7, 9, 10, 11, 14, 17, 19, 20, 23, 29, 32, 33, 38, 44, 55, 67, 82 }));
//		assertEquals (89, so.getcc());
//		so = new StatObj();
//		sm.sort(F2, so);
//		assertThat(F2, is(new int[] { 2, 3, 4, 6, 7, 9, 10, 10, 10, 11, 14, 17, 19, 20, 23, 29, 32, 33, 38, 44, 55, 67, 82 }));
//		assertEquals (119, so.getcc());
//		so = new StatObj();
//		sm.sort(F3, so);
//		assertThat(F3, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (54, so.getcc());
//		so = new StatObj();
//		sm.sort(F4, so);
//		assertThat(F4, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (58, so.getcc());
//		so = new StatObj();
//		sm.sort(F5, so);
//		assertThat(F5, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (28, so.getcc());
//		so = new StatObj();
//		sm.sort(F6, so);
//		assertThat(F6, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (62, so.getcc());
//		so = new StatObj();
//		sm.sort(F7, so);
//		assertThat(F7, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (37, so.getcc());
//		so = new StatObj();
//		sm.sort(F8, so);
//		assertThat(F8, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (54, so.getcc());
//		so = new StatObj();
//		sm.sort(F9, so);
//		assertThat(F9, is(new int[] { 1}));
//		assertEquals (0, so.getcc());
//		so = new StatObj();
//		sm.sort(F10, so);
//		assertThat(F10, is(new int[] {  }));
//		assertEquals (0, so.getcc());
//		so = new StatObj();
//		sm.sort(F11, so);
//		assertThat(F11, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (34, so.getcc());
//		so = new StatObj();
//		sm.sort(F12, so);
//		assertThat(F12, is(new int[] { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }));
//		assertEquals (54, so.getcc());
//		so = new StatObj();
//		sm.sort(F14, so);
//		assertThat(F14, is(new int[] { 4, 4, 4, 4, 4, 5, 5, 5, 5, 5 }));
//		assertEquals (34, so.getcc());
//		
//
//
//	}
	
	@Test
	public void testQuick31() { // QuickSort Variante 3
		SortInterface sm = new QuickSort();
		sm.sort(F1, so);
//		assertThat(F1, is(new int[] { 2, 3, 4, 6, 7, 9, 10, 11, 14, 17, 19, 20, 23, 29, 32, 33, 38, 44, 55, 67, 82 }));
//		assertEquals (64, so.getcc());
//		so = new StatObj();
//		sm.sort(F2, so);
//		assertThat(F2, is(new int[] { 2, 3, 4, 6, 7, 9, 10, 10, 10, 11, 14, 17, 19, 20, 23, 29, 32, 33, 38, 44, 55, 67, 82 }));
//		assertEquals (84, so.getcc());
//		so = new StatObj();
//		sm.sort(F3, so);
//		assertThat(F3, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (45, so.getcc());
//		so = new StatObj();
//		sm.sort(F4, so);
//		assertThat(F4, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (45, so.getcc());
//		so = new StatObj();
//		sm.sort(F5, so);
//		assertThat(F5, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (21, so.getcc());
//		so = new StatObj();
//		sm.sort(F6, so);
//		assertThat(F6, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (45, so.getcc());
//		so = new StatObj();
//		sm.sort(F7, so);
//		assertThat(F7, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (25, so.getcc());
//		so = new StatObj();
//		sm.sort(F8, so);
//		assertThat(F8, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (45, so.getcc());
		so = new StatObj();
		sm.sort(F9, so);
		assertThat(F9, is(new int[] { 1}));
		assertEquals (0, so.getcc());
		so = new StatObj();
		sm.sort(F10, so);
		assertThat(F10, is(new int[] {  }));
		assertEquals (0, so.getcc());
		so = new StatObj();
		sm.sort(F11, so);
		assertThat(F11, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
//		assertEquals (37, so.getcc());
		so = new StatObj();
		sm.sort(F12, so);
		assertThat(F12, is(new int[] { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }));
		assertEquals (45, so.getcc());
		so = new StatObj();
		sm.sort(F14, so);
		assertThat(F14, is(new int[] { 4, 4, 4, 4, 4, 5, 5, 5, 5, 5 }));
		assertEquals (25, so.getcc());
	}

	@Test
	public void testShellSort() {
		SortInterface sm = new ShellSort();
		sm.sort(F1, so);
		assertThat(F1, is(new int[] { 2, 3, 4, 6, 7, 9, 10, 11, 14, 17, 19, 20, 23, 29, 32, 33, 38, 44, 55, 67, 82 }));
		assertEquals (86, so.getcc());
		so = new StatObj();
		sm.sort(F2, so);
		assertThat(F2, is(new int[] { 2, 3, 4, 6, 7, 9, 10, 10, 10, 11, 14, 17, 19, 20, 23, 29, 32, 33, 38, 44, 55, 67, 82 }));
		assertEquals (106, so.getcc());
		so = new StatObj();
		sm.sort(F3, so);
		assertThat(F3, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
		assertEquals (19, so.getcc());
		so = new StatObj();
		sm.sort(F4, so);
		assertThat(F4, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
		assertEquals (22, so.getcc());
		so = new StatObj();
		sm.sort(F5, so);
		assertThat(F5, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
		assertEquals (30, so.getcc());
		so = new StatObj();
		sm.sort(F6, so);
		assertThat(F6, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
		assertEquals (26, so.getcc());
		so = new StatObj();
		sm.sort(F7, so);
		assertThat(F7, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
		assertEquals (26, so.getcc());
		so = new StatObj();
		sm.sort(F8, so);
		assertThat(F8, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
		assertEquals (19, so.getcc());
		so = new StatObj();
		sm.sort(F9, so);
		assertThat(F9, is(new int[] { 1}));
		assertEquals (0, so.getcc());
		so = new StatObj();
		sm.sort(F10, so);
		assertThat(F10, is(new int[] {  }));
		assertEquals (0, so.getcc());
		so = new StatObj();
		sm.sort(F11, so);
		assertThat(F11, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
		assertEquals (24, so.getcc());
		so = new StatObj();
		sm.sort(F12, so);
		assertThat(F12, is(new int[] { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }));
		assertEquals (19, so.getcc());
		so = new StatObj();
		sm.sort(F14, so);
		assertThat(F14, is(new int[] { 4, 4, 4, 4, 4, 5, 5, 5, 5, 5 }));
		assertEquals (21, so.getcc());

	}

}