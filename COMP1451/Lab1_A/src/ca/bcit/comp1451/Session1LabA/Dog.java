/**
 * 
 */
package ca.bcit.comp1451.Session1LabA;

/**
 * @author A01203138
 *
 */
public class Dog {
	private String name;
	private String breed;
	private int ageInYears;
	
	public Dog(String name, String breed, int ageInYears) {
		setName(name);
		setBreed(breed);
		setAgeInYears(ageInYears);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		if(name == null || name.isBlank() || name.isEmpty()) {
			throw new IllegalArgumentException("Name cannot be null or an empty String");
		}
		else {
			this.name = name;
		}
	}

	/**
	 * @return the breed
	 */
	public String getBreed() {
		return breed;
	}

	/**
	 * @param breed the breed to set
	 */
	public void setBreed(String breed) {
		if(breed == null || breed.isBlank() || breed.isEmpty()) {
			throw new IllegalArgumentException("Breed cannot be null or an empty String");
		}
		else {
			this.breed = breed;
		}
	}

	/**
	 * @return the ageInYears
	 */
	public int getAgeInYears() {
		return ageInYears;
	}

	/**
	 * @param ageInYears the ageInYears to set
	 */
	public void setAgeInYears(int ageInYears) {
		if(ageInYears <= 0) {
			throw new IllegalArgumentException("Age cannot be 0 or less");
		}
		else {
			this.ageInYears = ageInYears;
		}
	}
	
	public void displayDetails() {
		System.out.println("Dog name: " + getName());
		System.out.println("Dog breed: " + getBreed());
		System.out.println("Dog age: " + getAgeInYears());
	}
	

}
