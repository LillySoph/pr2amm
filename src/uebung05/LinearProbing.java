package pr2.uebung05;

public class LinearProbing implements Probing {
	
	private int factor = 1;
	private boolean signed = true;
	static final private int jump = 1;
	
	LinearProbing() {
		
	}
	
	@Override
	public int nextNum() {
		/* compute value */
		int value = factor * jump;
		/* return signed or unsigned value & invert sign boolean */
		if(signed) {
			signed = false;
			return value * (-1);
		} else {
			signed = true;
			factor++;
			return value;
		}
	}

	@Override
	public void startProbing() {
		factor = 1;
		signed = true;
	}

}
