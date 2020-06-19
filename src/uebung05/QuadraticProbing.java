package pr2.uebung05;

public class QuadraticProbing implements Probing {

	private int factor = 1;
	private boolean signed = true;
	
	QuadraticProbing() {
		
	}
	
	@Override
	public int nextNum() {
		/* compute value */
		int value = factor * factor;
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
