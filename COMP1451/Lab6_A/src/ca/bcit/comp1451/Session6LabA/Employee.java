package ca.bcit.comp1451.Session6LabA;

/**
 * @author Brian Truong
 *
 */

public class Employee extends Person{
	private double hourlyRate;
	private int numberWorkHoursPerWeek;
	
	private static final int MAX_HOURS_PER_WEEK = 80;
	
	/**
	 * Constructor
	 * @param name
	 * @param ageInYears
	 * @param hourlyRate
	 * @param numberWorkHoursPerWeek
	 */
	public Employee(String name, int ageInYears, double hourlyRate, int numberWorkHoursPerWeek) {
		super(name, ageInYears);
		setHourlyRate(hourlyRate);
		setNumberWorkHoursPerWeek(numberWorkHoursPerWeek);
	}
	
	/**
	 * Mutator set hourly rate
	 * @param hourlyRate
	 */
	public void setHourlyRate(double hourlyRate) {
		if(hourlyRate <= 0) {
			throw new IllegalArgumentException("hourly rate cannot be negative or zero");
		}
		else {
			this.hourlyRate = hourlyRate;
		}
	}
	/**
	 * 
	 * @return hourlyRate
	 */
	public double getHourlyRate() {return hourlyRate;}
	
	/**
	 * Mutator set number working hours per week
	 * @param numberWorkHoursPerWeek
	 */
	public void setNumberWorkHoursPerWeek(int numberWorkHoursPerWeek) {
		if(numberWorkHoursPerWeek <= 0 || numberWorkHoursPerWeek > MAX_HOURS_PER_WEEK) {
			throw new IllegalArgumentException("Number work hours per week should be positive and less than 80");
		}
	}
	
	/**
	 * 
	 * @return numberWorkHoursPerWeek
	 */
	public int getNumberWorkHoursPerWeek() {return numberWorkHoursPerWeek;}
	
	@Override
	public String toString() {
		if(getNumberWorkHoursPerWeek() >= 40) {
			return "This employee's name is " + getName() +
					" and the age is " + getAgeInYears() + " years old. This employee is a full time employee.";
		}
		else {
			return "This employee's name is " + getName() +
					" and the age is " + getAgeInYears() + " years old. This employee is a part time employee.";
		}
	}
	
}
