package pr2.uebung03;

public class StringElement implements Element {
	private String value;

	public StringElement(String value) {
		this.value = value;
	}

	@Override
	public int compareTo(Element e) {
		StringElement stringEl = (StringElement) e;
		return this.value.compareTo(stringEl.value);
	}

	@Override
	public Element clone() {
		StringElement newElement = new StringElement(this.value);
		return newElement;
	}

	@Override
	public String toString() {
		return this.value;
	}
}