/**
 * 
 */
package ca.bcit.comp1451.Session6LabA;

/**
 * @author Brian Truong
 *
 */
public class Person {
	
	private String name;
	private int ageInYears;
	
	/**
	 * Constructor
	 * @param name
	 * @param ageInYears
	 */
	public Person(String name, int ageInYears) {
		setName(name);
		setAgeInYears(ageInYears);
	}
	
	/**
	 * Mutator set name
	 * @param name
	 */
	public void setName(String name) {
		if(name == null || name.isBlank() || name.isEmpty()) {
			throw new IllegalArgumentException("name cannot be null or empty string");
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
	
	/**
	 * Mutator set age in years
	 * @param ageInYears
	 */
	public void setAgeInYears(int ageInYears) {
		if(ageInYears <= 0) {
			throw new IllegalArgumentException("Age cannot be zero or negative");
		}
		else {
			this.ageInYears = ageInYears;
		}
	}
	/**
	 * 
	 * @return ageInYears
	 */
	public int getAgeInYears() {return ageInYears;}
	
	@Override
	public String toString() {		
		return "Name is " + getName() +" and age is "+ getAgeInYears() + " years";
	}

}
