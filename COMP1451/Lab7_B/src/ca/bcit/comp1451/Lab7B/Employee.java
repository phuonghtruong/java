/**
 * 
 */
package ca.bcit.comp1451.Lab7B;

/**
 * @author Brian Truong
 * Feb. 29, 2020
 * Employee.java
 */
public abstract class Employee {

	private String name;
	/**
	 * Constructor
	 * @param name
	 */
	public Employee(String name) {
		// TODO Auto-generated constructor stub
		setName(name);
	}
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		if(name == null || name.isBlank() || name.isEmpty()) {
			throw new IllegalArgumentException("Name cannot be null or empty String");
		}
		else {
			this.name = name;
		}
	}
	/**
	 * 
	 * @return name
	 */
	public String getName() {return name;}
	
	@Override
	public String toString() {
		return "Employee Name: " + getName();
	}
	
	public abstract double calculatePay() ;
	
}
