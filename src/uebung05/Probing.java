package pr2.uebung05;

public interface Probing {
	
	/**
	 * Computes value which is used to calculate a new index for storing of element.
	 * @return computed value
	 */
    public int nextNum();
    
    /**
     * Resets attributes used for probing.
     */
    public void startProbing();
    
}
