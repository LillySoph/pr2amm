package pr2.uebung05;

import static pr.MakeItSimple.*;

public class HashTable {

	/* 2 dimensional array stores all keys and values */
	private Object[][] hashtable;
	private int keys = 0;
	private int values = 1;

	/* type of elements in hash table */
	private Object element;

	/* type of probing used in hash table */
	private Probing probing;

	private int size;
	private int numberOfElementsStored = 0;
	private int numberOfElementsMarkedAsRemoved = 0;
	private int numberOfCollisions = 0;
	private Element removeMarker = new StringElement("REMOVED");

	/**
	 * Returns the number of collisions of the hash table.
	 * 
	 * @return number of collisions
	 */
	public int getStat() {
		return this.numberOfCollisions;
	}

	/**
	 * Returns size of hash table, number of collisions, number of elements stored
	 * and number of elements marked as removed.
	 */
	public String getFullStat() {
		return "Size of hash table  :       " + this.size + "\nNumber Of Collisions:       " + this.numberOfCollisions
				+ "\nElements Stored:            " + this.numberOfElementsStored + "\nElements Marked As Removed: "
				+ this.numberOfElementsMarkedAsRemoved;
	}

	/**
	 * Creates an empty hash table with size 10 and linear probing.
	 */
	public HashTable() {
		this.size = 10;
		this.hashtable = new Object[2][size];
		this.probing = new LinearProbing();
	}

	/**
	 * Creates an empty user-defined hash table.
	 * 
	 * @param size    size of hash table
	 * @param probing linear probing or quadratic probing
	 */
	HashTable(int size, Probing probing) {
		if (size < 1)
			throw new PRException("Invalid hash table size.");
		this.size = size;
		this.hashtable = new Object[2][size];
		this.probing = probing;
	}

	/**
	 * Computes the hash index of a given key.
	 * 
	 * @param key key of element
	 * @return hash value
	 */
	private int hashfunction(Object key) {
		return Math.abs((key.hashCode() % this.size));
//		if (hashindex < 0)
//			return hashindex * (-1);
//		else
//			return hashindex;
	}

	/**
	 * Inserts new element in hash table. Overwrites old value if key already exists
	 * in hash table. Overwrites remove marker with new element.
	 * 
	 * @param key   key of element
	 * @param value value of element
	 * @return if key did not exist return null, else return old value.
	 */
	public Object put(Object key, Object value) {
		// is first element of table: set element as standard type
		if (isEmpty()) {
			this.element = value;
		}
		// check element type of element to be put into table
		else if (this.element.getClass() != value.getClass()) {
			throw new PRException("Cannot store different types of elements in hash table.");
		}

		// check whether rehashing must be applied
		if (this.numberOfElementsStored >= (this.size * 0.75))
			reHash();

		// calculate index of element
		int index;
		if (this.containsKey(key))
			index = getIndex(key);
		else
			index = getIndexForNewElement(key);

		// slot is empty or marked as removed
		if (hashtable[keys][index] == null || hashtable[keys][index].equals(removeMarker)) {
			hashtable[keys][index] = key;
			hashtable[values][index] = value;
			numberOfElementsStored++;
			if (hashtable[keys][index].equals(removeMarker)) 
				numberOfElementsMarkedAsRemoved--;
			return null;
		}

		// key already exists: overwrite old value
		else {
			Object oldValue = this.hashtable[values][index];
			this.hashtable[values][index] = value;
			return oldValue;
		}
	}

	/**
	 * Finds index for a given key. Returns hash index, if its slot is free or
	 * filled with same key. Otherwise uses probing to find index for new element.
	 * 
	 * @param key key of element
	 * @return index index for storing element
	 */
	private int getIndex(Object key) {

		// get hash index of key
		int index = this.hashfunction(key);

		// slot is empty or holds same key
		if (hashtable[keys][index] == null || hashtable[keys][index].equals(key))
			return index;

		// reset probing values
		probing.startProbing();
		int newIndex;

		// look for index of slot that is empty or holds same key
		do {
			numberOfCollisions++;
			int n = probing.nextNum();
			newIndex = (index + n) % size;
			if (newIndex < 0)
				newIndex *= (-1);
		} while (hashtable[keys][newIndex] != null && !(key.equals(hashtable[keys][newIndex])));

		return newIndex;
	}

	/**
	 * Finds index for a given key. Returns hash index, if its slot is free, is
	 * marked as removed or filled with same key. Otherwise uses probing to find
	 * index for new element.
	 * 
	 * @param key
	 * @return
	 */
	private int getIndexForNewElement(Object key) {

		// get hash index of key
		int index = this.hashfunction(key);

		// slot is empty, is marked as removed or holds same key
		if (hashtable[keys][index] == null || hashtable[keys][index].equals(removeMarker)
				|| hashtable[keys][index].equals(key))
			return index;

		// reset probing values
		probing.startProbing();
		int newIndex;

		// look for index of slot that is empty, marked as removed or holds same key
		do {
			numberOfCollisions++;
			int n = probing.nextNum();
			newIndex = (index + n) % size;
			if (newIndex < 0)
				newIndex *= (-1);
		} while (hashtable[keys][newIndex] != null && !(hashtable[keys][newIndex].equals(removeMarker))
				&& !(hashtable[keys][newIndex].equals(key)));

		return newIndex;
	}

	/**
	 * Looks for the given key in the hash table.
	 * 
	 * @param key key of element
	 * @return null, if key is not in hash table, otherwise its related value.
	 */
	public Object get(Object key) {
		// check whether key is in hash table
		if (!containsKey(key))
			return null;

		// get values of key
		return hashtable[values][getIndex(key)];
	}

	/**
	 * Checks whether value is stored in hash table.
	 * 
	 * @param value value of element
	 * @return true if value exists in hash table otherwise false
	 */
	public boolean contains(Object value) {
		// iterate through hash table to find value
		for (int i = 0; i < this.size; i++) {
			if (value.equals(hashtable[values][i]))
				return true;
		}
		return false;
	}

	/**
	 * Checks whether key is stored in hash table.
	 * 
	 * @param key key of element
	 * @return true if key exists in hash table otherwise false
	 */
	public boolean containsKey(Object key) {
		// iterate through hash table to find key
		for (int i = 0; i < this.size; i++) {
			if (key.equals(hashtable[keys][i]))
				return true;
		}
		return false;
	}

	/**
	 * Checks whether hash table does not contain any elements.
	 * 
	 * @return true if empty otherwise false
	 */
	public boolean isEmpty() {
		return (numberOfElementsStored == 0);
	}

	/**
	 * Gets the number of elements stored in the hash table.
	 * 
	 * @return
	 */
	public int size() {
		return numberOfElementsStored;
	}

	/**
	 * Removes all elements from the hash table.
	 */
	public void clear() {
		// creates new array and resets stats
		hashtable = new Object[2][size];
		numberOfElementsStored = 0;
		numberOfElementsMarkedAsRemoved = 0;
		numberOfCollisions = 0;
	}

	/**
	 * Marks an element with given key as removed.
	 * 
	 * @param key key of element
	 * @return false if element does not exist, otherwise true
	 */
	public boolean remove(Object key) {
		// element to be removed does not exist
		if (!containsKey(key))
			return false;
		int hashIndex = getIndex(key);

		// mark element in hash table as removed
		hashtable[keys][hashIndex] = removeMarker;
		hashtable[values][hashIndex] = null;
		numberOfElementsMarkedAsRemoved++;
		numberOfElementsStored--;
		return true;

	}

	/**
	 * Doubles the size of the hash table and removes elements that are marked as
	 * removed.
	 */
	public void reHash() {
		// copy elements from hashtable
		Object[][] copy = new Object[2][numberOfElementsStored];
		for (int i = 0, j = 0; i < size; i++) {
			if (hashtable[keys][i] != null && !hashtable[keys][i].equals(removeMarker)) {
				copy[keys][j] = hashtable[keys][i];
				copy[values][j] = hashtable[values][i];
				j++;
			}
		}
		// create new hash table
		numberOfElementsStored = 0;
		numberOfElementsMarkedAsRemoved = 0;
		this.size *= 2;
		hashtable = new Object[2][size];
		// copy elements into new hash table
		for (int i = 0; i < copy[keys].length; i++) {
			put(copy[keys][i], copy[values][i]);
		}
	}

	/**
	 * Prints the hash table into the console.
	 */
	public void printHT() {
		for (int i = 0; i < size; i++) {
			System.out.println("---------------------------------------------------------------------");
			if (hashtable[values][i] == null && hashtable[keys][i] == null)
				println(i + ":  EMPTY");
			else if (hashtable[keys][i].equals(removeMarker))
				println(i + ":  MARKED AS REMOVED");
			else
				println(i + ": " + hashtable[keys][i] + " | " + hashtable[values][i] + " ");
			System.out.println("---------------------------------------------------------------------\n");
		}
	}

}
