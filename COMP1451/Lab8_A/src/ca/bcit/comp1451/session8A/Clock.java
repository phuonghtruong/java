/**
 * 
 */
package ca.bcit.comp1451.session8A;

/**
 * @author A01203138
 *
 */
public abstract class Clock implements Displayable {

	private int minute;
	private int second;
	
	private static final int MAX_MIN = 59;
	private static final int MAX_SECOND = 59;
	/**
	 * 
	 */
	public Clock(int minute, int second) {
		// TODO Auto-generated constructor stub
		setMinute(minute);
		setSecond(second);
	}
	/**
	 * @return the minute
	 */
	public abstract void setHour(int hour);
	public abstract int getHour();
	
	public int getMinute() {
		return minute;
	}
	/**
	 * @param minute the minute to set
	 */
	public void setMinute(int minute) {
		if(minute < 0 || minute > MAX_MIN) {
			throw new IllegalArgumentException("Minutes must be in range of 0 to 59");
		}
		else {
			this.minute = minute;
		}
	}
	/**
	 * @return the second
	 */
	public int getSecond() {
		return second;
	}
	/**
	 * @param second the second to set
	 */
	public void setSecond(int second) {
		if(second < 0 || second > MAX_SECOND) {
			throw new IllegalArgumentException("second must be in range of 0 to 59");
		}
		else {
			this.second = second;
		}
	}

	
}
