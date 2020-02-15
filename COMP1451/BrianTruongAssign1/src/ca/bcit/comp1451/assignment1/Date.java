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
	 * 
	 */
	public Date(int day, int month, int year) {
		// TODO Auto-generated constructor stub
		setDay(day);
		setMonth(month);
		setYear(year);
		hashmap = new HashMap<Integer,String>();
		populateHashMap();
	}
	
	public void populateHashMap() {
		for(int index=0; index < MAX_MONTHS; index++) {
			hashmap.put(index+1, MONTH_IN_NAME[index]);
		}
	}

	public void setDay(int day) {
		 if(day >= 1 && day <= MAX_DAYS) {
			 this.day = day;
		 }
		 else {
			 this.day = 1;
		 }
	}
	
	public int getDay() {return day;}
	
	public void setMonth(int month) {
		 if(month >= 1 && month <= MAX_MONTHS) {
			 this.month = month;
		 }
		 else {
			 this.month = 1;
		 }
	}
	
	public int getMonth() {return month;}
	
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
	
	public int getYear() {return year;}
	
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
