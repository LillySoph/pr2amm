package pr2.uebung04;
import static pr.MakeItSimple.*;
public class IntElement implements Comparable {

	private Integer value;
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
	public IntElement(int value) {
		this.value = value;
	}
	

	/**
	 * Constructor with boolean to set sorting order
	 * 
	 * @param value
	 * @param descendingOrder
	 */
	public IntElement(int value, boolean descendingOrder) {
		this.value = value;
		this.descendingOrder = descendingOrder;
	}
	

	@Override
	public String toString() {
		return this.value + " ";
	}

	/**
	 * Compares two elements of type IntElement depending on their sorting order. 
	 * Descending order: returns -1 if this is bigger than o and 1 if this is smaller than o.
	 * Ascending order: returns 1 if this is bigger than o and -1 if this is smaller than o.
	 * Returns 0, if both are equal.
	 */
	@Override
	public int compareTo(Object o) {

		IntElement otherIntElement = (IntElement) o;

		if (this.descendingOrder == true && otherIntElement.descendingOrder == true) {
			if (this.value == otherIntElement.value) {
				return 0;
			} else if (this.value < otherIntElement.value) {
				return 1;
			} else {
				return -1;
			}

		} else if (this.descendingOrder == false && otherIntElement.descendingOrder == false) {
			if (this.value == otherIntElement.value) {
				return 0;
			} else if (this.value < otherIntElement.value) {
				return -1;
			} else {
				return 1;
			}
		}else {
			throw new PRException("Sorting element with ascending and descending order is not possible.");
		}
	}

}
