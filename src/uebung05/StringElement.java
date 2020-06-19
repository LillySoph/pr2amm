package pr2.uebung05;

public class StringElement implements Element {

	private String value;

	public StringElement(String value) {
		this.value = value;
	}
	
	public int compareTo(Element e) {
		if(e == null)
			return 1;
		if(!(e instanceof StringElement))
			return 1;
		return(this.value.compareTo(e.toString()));
	}	
	
	@Override
	public boolean equals(Object o) {
		if(o == null)
			return false;
		if(!(o instanceof StringElement))
			return false;
		return (this.compareTo((Element) o) == 0);
	}
	
	@Override
	public int hashCode() {
		return this.value.hashCode();
	}
	
	@Override
	public String toString() {
		return this.value;
	}

	public Element clone() {
		return new StringElement(this.value);
	}
	
}