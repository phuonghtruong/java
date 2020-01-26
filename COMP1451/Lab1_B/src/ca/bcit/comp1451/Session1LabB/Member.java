/**
 * 
 */
package ca.bcit.comp1451.Session1LabB;

/**
 * @author Brian Truong
 *
 */
public class Member {

	private String firstName;
	private String lastName;
	private int monthOfJoining;
	private int yearOfJoining;
	
	public static final int FIRST_MONTH = 1;
	public static final int LAST_MONTH = 12;
	public static final int CURRENT_YEAR = 2019;
	
	public Member(String firstName, String lastName, 
			int monthOfJoining, int yearOfJoining) {
		setFirstName(firstName);
		setLastName(lastName);
		setMonthOfJoining(monthOfJoining);
		setYearOfJoining(yearOfJoining);
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		if(firstName == null || firstName.isBlank() || firstName.isEmpty()) {
			throw new IllegalArgumentException("first name cannot be null or an empty String");
		}
		else {
			this.firstName = firstName;
		}
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		if(lastName == null || lastName.isBlank() || lastName.isEmpty()) {
			throw new IllegalArgumentException("last name cannot be null or empty String");
		}
		else {
			this.lastName = lastName;
		}
	}

	/**
	 * @return the monthOfJoining
	 */
	public int getMonthOfJoining() {
		return monthOfJoining;
	}

	/**
	 * @param monthOfJoining the monthOfJoining to set
	 */
	public void setMonthOfJoining(int monthOfJoining) {
		if(monthOfJoining < FIRST_MONTH || monthOfJoining > LAST_MONTH) {
			throw new IllegalArgumentException("Invalid month of joining");
		}
		else {
			this.monthOfJoining = monthOfJoining;
		}
	}

	/**
	 * @return the yearOfJoining
	 */
	public int getYearOfJoining() {
		return yearOfJoining;
	}

	/**
	 * @param yearOfJoining the yearOfJoining to set
	 */
	public void setYearOfJoining(int yearOfJoining) {
		if(yearOfJoining < 0 || yearOfJoining > CURRENT_YEAR) {
			throw new IllegalArgumentException("Invalid year of joining");
		}
		else {
			this.yearOfJoining = yearOfJoining;
		}
	}
	
	public void displayDetails() {
		System.out.println("First Name: " + getFirstName());
		System.out.println("Last Name: " + getLastName());
		System.out.println("Month of Joining: " + getMonthOfJoining());
		System.out.println("Year of Joining: " + getYearOfJoining());
	}
}
