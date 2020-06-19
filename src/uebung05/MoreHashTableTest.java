package pr2.uebung05;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class MoreHashTableTest {

	HashTable htString, htSong;
	Song s;

	/* KEY: StringElement VALUE: String */
	/* PROBING: Linear */
	@Test
	public void testLPString() {
		htString = new HashTable(1, new LinearProbing());
		
		assertEquals(false, htString.contains("hallo"));
		assertEquals(false, htString.containsKey(new StringElement("H")));
		assertEquals(0, htString.size());
		
		assertNull(htString.put(new StringElement("H"), "hallo"));
		assertEquals(true, htString.contains("hallo"));
		assertEquals(true, htString.containsKey(new StringElement("H")));
		assertEquals(1, htString.size());
		
		assertEquals("hallo", htString.put(new StringElement("H"), "hola"));
		assertEquals(true, htString.contains("hola"));
		assertEquals(true, htString.containsKey(new StringElement("H")));
		assertEquals(1, htString.size());
		
		Element [] keys = {new StringElement("qwertz"), new StringElement("asdfg"), new StringElement("yxcvb"), new StringElement("tzuio"), new StringElement("fghjk"), new StringElement("cvbnm")}; 
		for(int i = 0; i < keys.length; i++) {
			assertEquals(i + 1, htString.size());
			assertNull(htString.put(keys[i], "test value :)" + i));
			assertEquals(i + 2, htString.size());
		}
		
		for(int i = 3; i < keys.length; i++) {
			assertEquals(true, htString.remove(keys[i]));
		}
		assertEquals(4, htString.size());
		
		assertEquals(false, htString.remove(new StringElement("unbekannter key")));
		
		assertNull(htString.get(new StringElement("unbekannter key")));
		for(int i = 0; i < 3; i++) {
			assertEquals("test value :)" + i, htString.get(keys[i]));
		}
	}

	/* KEY: StringElement VALUE: String */
	/* PROBING: Quadratic */
	@Test
	public void testQPString() {
		htString = new HashTable(1, new QuadraticProbing());
		
		assertEquals(false, htString.contains("hallo"));
		assertEquals(false, htString.containsKey(new StringElement("H")));
		assertEquals(0, htString.size());
		
		assertNull(htString.put(new StringElement("H"), "hallo"));
		assertEquals(true, htString.contains("hallo"));
		assertEquals(true, htString.containsKey(new StringElement("H")));
		assertEquals(1, htString.size());
		
		assertEquals("hallo", htString.put(new StringElement("H"), "hola"));
		assertEquals(true, htString.contains("hola"));
		assertEquals(true, htString.containsKey(new StringElement("H")));
		assertEquals(1, htString.size());
		
		Element [] keys = {new StringElement("qwertz"), new StringElement("asdfg"), new StringElement("yxcvb"), new StringElement("tzuio"), new StringElement("fghjk"), new StringElement("cvbnm")}; 
		for(int i = 0; i < keys.length; i++) {
			assertEquals(i + 1, htString.size());
			assertNull(htString.put(keys[i], "test value :)" + i));
			assertEquals(i + 2, htString.size());
		}
		
		for(int i = 3; i < keys.length; i++) {
			assertEquals(true, htString.remove(keys[i]));
		}
		assertEquals(4, htString.size());
		
		assertEquals(false, htString.remove(new StringElement("unbekannter key")));
		
		assertNull(htString.get(new StringElement("unbekannter key")));
		for(int i = 0; i < 3; i++) {
			assertEquals("test value :)" + i, htString.get(keys[i]));
		}
	}
	
	String[] kuenstler = new String[1];
	
	/* KEY: StringElement VALUE: SongImplementation */
	/* PROBING: Linear */
	@Test
	public void testLPSong() {
		htSong = new HashTable(1, new LinearProbing());

		htSong.printHT();
		System.out.println("- - - - - - - - - - - - - - - - - - - - - -\n");
		
		kuenstler[0] = "Die Orsons";
		Song song1 = new SongImplementation("Bessa Bessa", kuenstler, "Orsons Island");
		assertEquals(false, htSong.contains(song1));
		assertEquals(false, htSong.containsKey(new StringElement("orsons")));
		assertEquals(0, htSong.size());

		htSong.printHT();
		System.out.println("- - - - - - - - - - - - - - - - - - - - - -\n");
		
		assertNull(htSong.put(new StringElement("orsons"), song1));
		assertEquals(true, htSong.contains(song1));
		assertEquals(true, htSong.containsKey(new StringElement("orsons")));
		assertEquals(1, htSong.size());

		htSong.printHT();
		System.out.println("- - - - - - - - - - - - - - - - - - - - - -\n");
		
		Song song2 = new SongImplementation("Schneeweiß", kuenstler, "Orsons Island");
		assertEquals(song1, htSong.put(new StringElement("orsons"), song2));
		assertEquals(true, htSong.contains(song2));
		assertEquals(true, htSong.containsKey(new StringElement("orsons")));
		assertEquals(1, htSong.size());

		htSong.printHT();
		System.out.println("- - - - - - - - - - - - - - - - - - - - - -\n");
		
		String [] titel = {"Ticket hier raus", "Bang Bang", "Nach wie vor", "Letze Chance", "Wenn du stirbst", "Liebe"}; 
		kuenstler[0] = "Tarek K.I.Z";
		for(int i = 0; i < titel.length; i++) {
			assertEquals(i + 1, htSong.size());
			assertNull(htSong.put(new StringElement(titel[i]), new SongImplementation(titel[i], kuenstler, "Golem")));
			assertEquals(i + 2, htSong.size());
			
			htSong.printHT();
			System.out.println("- - - - - - - - - - - - - - - - - - - - - -\n");
			
		}
		
		for(int i = 0; i < 3; i++) {
			assertEquals(true, htSong.remove(new StringElement(titel[i])));
			System.out.println("remove: " + titel[i]);		
		}
		assertEquals(4, htSong.size());

		assertEquals(false, htSong.remove(new StringElement("unbekannter key")));

		htSong.printHT();
		System.out.println("- - - - - - - - - - - - - - - - - - - - - -\n");
		
		assertNull(htSong.get(new StringElement("unbekannter key")));
		for(int i = 3; i < titel.length; i++) {
			assertEquals(new SongImplementation(titel[i], kuenstler, "Golem"), htSong.get(new StringElement(titel[i])));

			htSong.printHT();
			System.out.println("- - - - - - - - - - - - - - - - - - - - - -\n");
		}
		
		assertNull(htSong.put(new StringElement("Bang Bang"), new SongImplementation("Bang Bang", kuenstler, "Golem")));
		htSong.printHT();
	}

	/* KEY: StringElement VALUE: SongImplementation */
	/* PROBING: Quadratic */
	@Test
	public void testQPSong() {
		htSong = new HashTable(1, new QuadraticProbing());

		kuenstler[0] = "Die Orsons";
		Song song1 = new SongImplementation("Bessa Bessa", kuenstler, "Orsons Island");
		assertEquals(false, htSong.contains(song1));
		assertEquals(false, htSong.containsKey(new StringElement("orsons")));
		assertEquals(0, htSong.size());
		
		assertNull(htSong.put(new StringElement("orsons"), song1));
		assertEquals(true, htSong.contains(song1));
		assertEquals(true, htSong.containsKey(new StringElement("orsons")));
		assertEquals(1, htSong.size());
		
		Song song2 = new SongImplementation("Schneeweiß", kuenstler, "Orsons Island");
		assertEquals(song1, htSong.put(new StringElement("orsons"), song2));
		assertEquals(true, htSong.contains(song2));
		assertEquals(true, htSong.containsKey(new StringElement("orsons")));
		assertEquals(1, htSong.size());
		
		String [] titel = {"Ticket hier raus", "Bang Bang", "Nach wie vor", "Letze Chance", "Wenn du stirbst", "Liebe"}; 
		kuenstler[0] = "Tarek K.I.Z";
		for(int i = 0; i < titel.length; i++) {
			assertEquals(i + 1, htSong.size());
			assertNull(htSong.put(new StringElement(titel[i]), new SongImplementation(titel[i], kuenstler, "Golem")));
			assertEquals(i + 2, htSong.size());
		}
		
		for(int i = 3; i < titel.length; i++) {
			assertEquals(true, htSong.remove(new StringElement(titel[i])));
		}
		assertEquals(4, htSong.size());
		
		assertEquals(false, htSong.remove(new StringElement("unbekannter key")));
		
		assertNull(htSong.get(new StringElement("unbekannter key")));
		for(int i = 0; i < 3; i++) {
			assertEquals(new SongImplementation(titel[i], kuenstler, "Golem"), htSong.get(new StringElement(titel[i])));
		}

	}

	@Test(expected = Exception.class)
	public void testDifferentTypes1() {
		htSong = new HashTable();
		assertNull(htString.put(new StringElement("H"), "hallo"));
		String[] artists = { "Die Orsons" };
		s = new SongImplementation("Bessa Bessa", artists, "Orsons Island");
		htString.put(new StringElement("song"), s);
	}

	@Test(expected = Exception.class)
	public void testDifferentTypes2() {
		htSong = new HashTable();
		String[] artists = { "Die Orsons" };
		s = new SongImplementation("Bessa Bessa", artists, "Orsons Island");
		assertNull(htSong.put(new StringElement("song"), s));
		htSong.put(new StringElement("H"), "hallo");
	}

}
