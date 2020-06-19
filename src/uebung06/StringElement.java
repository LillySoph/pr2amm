package pr2.uebung06;

import static pr.MakeItSimple.*;

import pr.MakeItSimple.PRException;

public class StringElement implements Comparable {

	private String value;

	public StringElement(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return this.value + "";
	}

	@Override
	public int compareTo(Object o) {
		if (!(o instanceof StringElement))
			throw new PRException("Cannot compare StringElement to non-StringElement.");
		return this.value.compareTo(((StringElement) o).getValue());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (!(obj instanceof StringElement))
			return false;
		return (this.compareTo((StringElement) obj) == 0);
	}

	@Override
	public Object clone() {
		return new StringElement(this.value);
	}

}
