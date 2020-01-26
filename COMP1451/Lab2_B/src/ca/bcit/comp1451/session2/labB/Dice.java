/**
 * 
 */
package ca.bcit.comp1451.session2.labB;

/**
 * @author Brian Truong
 *
 */
import java.util.Random;

public class Dice {
	private int faceValue;
	private Random random;
	/**
	 * 
	 */
	public Dice() {
		random = new Random();
		faceValue = roll();
	}
	
	public int getFaceValue() {return faceValue;}
	
	public int roll() {
		int rand_value = random.nextInt(6) + 1;
		return rand_value;
	}

}

