package pr2.uebung03;

public class IntElement implements Element {
	private Integer value;

	public IntElement(int value) {
		this.value = value;
	}

	@Override
	public int compareTo(Element e) {
		IntElement el = (IntElement) e;
		if (value == el.value) {
			return 0;
		} else if (value < el.value) {
			return -1;
		} else {
			return 1;
		}

	}

	@Override
	public Element clone() {
		return new IntElement(this.value);
	}

	@Override
	public String toString() {
		return this.value + "";
	}

}