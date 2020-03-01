/**
 * 
 */
package ca.bcit.comp1451.lesson6_LabB;

/**
 * @author Brian Truong
 * Feb. 23, 2020
 * Person.java
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
	
	@Override
	public int hashCode() {		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		
		Person other = (Person) obj;
		if(name == null) {
			if(other.name != null)
				return false;
		}
		else if(!name.equals(other.name))
			return false;
		return true;
	}

}