/**
 * 
 */
package ca.bcit.comp1451.assignment1;

/**
 * @author Brian Truong
 *
 */

import java.util.HashMap;
import java.util.Calendar;

public class Date {

	private int day;
	private int month;
	private int year;
	private HashMap<Integer, String> hashmap;
	
	private static final int MAX_DAYS = 31;
	private static final int MAX_MONTHS = 12;
	private static final int INIT_YEAR = 1900;
	private static final String[] MONTH_IN_NAME = {
			"January",
			"Feburary",
			"March",
			"April",
			"May",
			"June",
			"July",
			"August",
			"September",
			"October",
			"November",
			"December"
	};

	/**
	 * Constructor with 3 params
	 * @param day
	 * @param month
	 * @param year
	 */
	public Date(int day, int month, int year) {
		// TODO Auto-generated constructor stub
		setDay(day);
		setMonth(month);
		setYear(year);
		hashmap = new HashMap<Integer,String>();
		populateHashMap();
	}
	
	/**
	 * populate hash map
	 */
	public void populateHashMap() {
		for(int index=0; index < MAX_MONTHS; index++) {
			hashmap.put(index+1, MONTH_IN_NAME[index]);
		}
	}

	/**
	 * 
	 * @param day
	 */
	public void setDay(int day) {
		 if(day >= 1 && day <= MAX_DAYS) {
			 this.day = day;
		 }
		 else {
			 this.day = 1;
		 }
	}
	/**
	 * 
	 * @return day
	 */
	public int getDay() {return day;}
	/**
	 * 
	 * @param month
	 */
	public void setMonth(int month) {
		 if(month >= 1 && month <= MAX_MONTHS) {
			 this.month = month;
		 }
		 else {
			 this.month = 1;
		 }
	}
	/**
	 * 
	 * @return month
	 */
	public int getMonth() {return month;}
	/**
	 * 
	 * @param year
	 */
	public void setYear(int year) {
		if(year >= INIT_YEAR && year <= Calendar.getInstance().get(Calendar.YEAR))
		{
			 this.year = year;
		}
		 else 
		 {
			 this.year = INIT_YEAR;
		 }
	}
	/**
	 * 
	 * @return year
	 */
	public int getYear() {return year;}
	
	/**
	 * 
	 * @return date with format
	 */
	public String displayDate() {
		String dateFormat = null;
		String dayInString = null;
		String monthInString = null;
		String yearInString = null;
		
		if(getDay() > 0 && getDay() < 10) {
			dayInString = "0" + Integer.toString(getDay());
		}
		else {
			dayInString = Integer.toString(getDay());
		}
		monthInString = MONTH_IN_NAME[getMonth() - 1];
		yearInString = Integer.toString(getYear());

		dateFormat = dayInString + "/" + monthInString + "/" + yearInString;
		return dateFormat;
	}
}
