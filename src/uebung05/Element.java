package pr2.uebung05;

public interface Element {
	
	/** Compares this elements value with another elements value.
	 * 
	 * @param
	 * e Other element to compare this element to.
	 * @return
	 * 0 if both elements values are equal.  
	 * != 0 if this elements value is bigger or smaller than other elements value.
	 * */
	public int compareTo(Element e);
	
	/**
	 * Clones an existing Element.
	 * @return Cloned Element
	 */
	public Element clone();	

}