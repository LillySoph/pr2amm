package pr2.uebung06;

import static pr.MakeItSimple.*;

public class IntElement implements Comparable {

	private Integer value;

	public IntElement(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value + "";
	}

	@Override
	public int compareTo(Object o) {
		if (!(o instanceof IntElement)) {
			throw new PRException("Cannot compare IntElement to non-IntElement.");
		}
		IntElement otherIntElement = (IntElement) o;
		if (this.value == otherIntElement.value) {
			return 0;
		} else if (this.value < otherIntElement.value) {
			return -1;
		} else {
			return 1;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof IntElement)) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		return (this.compareTo((IntElement) obj) == 0);

	}

	@Override
	public Object clone() {
		return new IntElement(this.value);
	}

}
