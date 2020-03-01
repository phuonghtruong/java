/**
 * 
 */
package ca.bcit.comp1451.lesson6_LabB;

/**
 * @author Brian Truong
 * Feb. 23, 2020
 * Student.java
 */
public class Student extends Person{

	private boolean isFulltimeStudent;
	private double gpa;
	
	private static final double MAX_GPA = 100;
	
	/**
	 * Constructor
	 * @param name
	 * @param ageInYears
	 * @param isFulltimeStudent
	 * @param gpa
	 */
	public Student(String name, int ageInYears, boolean isFulltimeStudent, double gpa) {
		// TODO Auto-generated constructor stub
		super(name, ageInYears);
		setFulltimeStudent(isFulltimeStudent);
		setGPA(gpa);
	}
	/**
	 * Mutator set student status
	 * @param isFulltimeStudent
	 */
	public void setFulltimeStudent(boolean isFulltimeStudent) {
		this.isFulltimeStudent = isFulltimeStudent;
	}

	/**
	 * Mutator set GPA
	 * @param gpa
	 */
	public void setGPA(double gpa) {
		if(gpa < 0 || gpa > MAX_GPA) {
			throw new IllegalArgumentException("gpa should be in between 0 to 100");
		}
		else {
			this.gpa = gpa;
		}
	}
	/**
	 * 
	 * @return gpa
	 */
	public double getGPA() {return gpa;}
	/**
	 * 
	 * @return isFulltimeStudent
	 */
	public boolean isFulltime() {return isFulltimeStudent;}
	
	@Override
	public String toString() {
		if(isFulltime()) {
			return "This student's name is " + getName() +
					" and the age is " + getAgeInYears() + " years old." +
					" This student is a full time student with the gpa of " + getGPA();
		}
		else {
			return "this student's name is " + getName() +
					" and the age is " + getAgeInYears() + "years old." +
					" This student is a part time student with the gpa of " + getGPA();
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		long temp = Double.doubleToLongBits(gpa);
		int hash = super.hashCode();
		hash = prime * hash + (int)(temp ^ (temp >>> 32));
		return hash;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(!super.equals(obj)) return false;
		if(!(obj instanceof Student)) return false;
				
		Student other = (Student) obj;
		if(Double.doubleToLongBits(gpa) != Double.doubleToLongBits(other.gpa)) {
			return false;
		}
		return true;
	}
}
