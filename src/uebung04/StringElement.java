package pr2.uebung04;

import static pr.MakeItSimple.*;

import pr.MakeItSimple.PRException;

public class StringElement implements Comparable {

	private String value;
	/**
	 * order in which the array is to be sorted (false if ascending, true if
	 * descending)
	 */
	private boolean descendingOrder;

	/**
	 * Standard constructor
	 * 
	 * @param value
	 */
	public StringElement(String value) {
		this.value = value;
	}
	
	/**
	 * Constructor with boolean to set sorting order
	 * 
	 * @param value
	 * @param descendingOrder
	 */

	public StringElement(String value, boolean descendingOrder) {
		this.value = value;
		this.descendingOrder = descendingOrder;
	}

	public String getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return this.value + " ";
	}

	/**
	 * Compares two elements of type StringElement depending on their sorting order. 
	 * Descending order: returns -1 if this is bigger than o and 1 if this is smaller than o.
	 * Ascending order: returns 1 if this is bigger than o and -1 if this is smaller than o.
	 * Returns 0, if both are equal.
	 */
	
	@Override
	public int compareTo(Object o) {
		StringElement otherStringElement = (StringElement) o;
		if (this.descendingOrder == true && otherStringElement.descendingOrder == true) {
			return this.value.compareTo(otherStringElement.getValue()) * (-1);
		} else if (this.descendingOrder == false && otherStringElement.descendingOrder == false) {
			return this.value.compareTo(otherStringElement.getValue());
		} else {
			throw new PRException("Sorting element with ascending and descending order is not possible.");
		}
	}



}
