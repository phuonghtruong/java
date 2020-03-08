/**
 * 
 */
package ca.bcit.comp1451.session8A;

/**
 * @author A01203138
 *
 */
public class Date implements Displayable{

	private int day;
	private int month;
	private int year;
	
	private static final int START_DAY = 1;
	private static final int LAST_DAY = 31;
	private static final int START_MONTH = 1;
	private static final int LAST_MONTH = 12;
	private static final int START_YEAR = 1900;
	private static final int LAST_YEAR = 2020;
	
	/**
	 * 
	 */
	public Date(int day, int month, int year) {
		// TODO Auto-generated constructor stub
		setDay(day);
		setMonth(month);
		setYear(year);
	}

	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(int day) {
		if(day < START_DAY || day > LAST_DAY) {
			this.day =1;
		}
		else{
			this.day = day;
		}
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		if(month < START_MONTH || day > LAST_MONTH) {
			this.month = 1;
		}
		else{
			this.month = month;
		}
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		if(year < START_YEAR || day > LAST_YEAR) {
			this.year = START_YEAR;
		}
		else{
			this.year = year;
		}
	}
	
	public String getStringValue() {
		int day = getDay();
		int month = getMonth();
		int year = getYear();
		
		String strDay;
		String strMonth="";
		String strYear;
		
		if(day < 10) 
			strDay = "0"+day;
		else
			strDay = Integer.toString(day);
		
		switch(month) {
		case 1: strMonth = "January"; break;
		case 2: strMonth = "Febuary"; break;
		case 3: strMonth = "March"; break;
		case 4: strMonth = "April"; break;
		case 5: strMonth = "May"; break;
		case 6: strMonth = "June"; break;
		case 7: strMonth = "July"; break;
		case 8: strMonth = "August"; break;
		case 9: strMonth = "September"; break;
		case 10: strMonth = "October"; break;
		case 11: strMonth = "November"; break;
		case 12: strMonth = "December"; break;
		default: System.out.println("Invalid value"); break;
		}
		
		strYear = Integer.toString(year);
		
		return strDay + " " + strMonth+ " " + strYear;
	}

}
