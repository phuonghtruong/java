/**
 * 
 */
package ca.bcit.comp1451.session8A;

/**
 * @author A01203138
 *
 */
public class TwelveHourClock extends Clock{

	private String meridiem;
	private int hour;
	
	/**
	 * 
	 */
	public TwelveHourClock(int hour, int minute, int second, String meridiem) {
		// TODO Auto-generated constructor stub
		super(minute, second);
		setHour(hour);
		setMeridiem(meridiem);
	}

	/**
	 * @return the meridiem
	 */
	public String getMeridiem() {
		return meridiem;
	}

	/**
	 * @param meridem the meridiem to set
	 */
	public void setMeridiem(String meridiem) {
		if("AM".equalsIgnoreCase(meridiem) || "PM".equalsIgnoreCase(meridiem))
			this.meridiem = meridiem;
		else
			this.meridiem = "AM";
	}

	/**
	 * @return the hour
	 */
	@Override
	public int getHour() {
		return hour;
	}

	/**
	 * @param hour the hour to set
	 */
	@Override
	public void setHour(int hour) {
		if(hour < 0 || hour > 11) {
			this.hour = 0;
		}
		else {
			this.hour = hour;
		}
	}

	@Override
	public String getStringValue() {
		String strHr ;
		String strMin;
		String strSec;
		
		if(getHour() < 10) 
			strHr = "0" + getHour();
		else
			strHr = Integer.toString(getHour());
		
		if(getMinute() < 10) 
			strMin = "0" + getMinute();
		else
			strMin = Integer.toString(getMinute());
		
		if(getSecond() < 10) 
			strSec = "0" + getSecond();
		else
			strSec = Integer.toString(getSecond());
		
		return strHr+":"+strMin+":"+strSec+ " " +getMeridiem();
	}
	
}
