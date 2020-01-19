/**
 * 
 */
package ca.bcit.comp1451.Session1LabA;

/**
 * @author A01203138
 *
 */

import java.util.*;

public class Kennel {
	private ArrayList<Dog> dogList;
	
	public Kennel() {
		dogList = new ArrayList<Dog>();
	}
	
	public void addDog(Dog theDog) {
		if(theDog != null) {
			dogList.add(theDog);
		}
	}
	
	public void displayDogs() {
		for(Dog dog:dogList) {
			dog.displayDetails();
		}
	}
	
	public void adopt(String name) {
		Iterator<Dog> it = dogList.iterator();
		boolean isFound = false;
		while(it.hasNext()) {
			Dog dog = it.next();
			if(dog.getName().equalsIgnoreCase(name)) {
				isFound = true;
				it.remove();				
			}
		}
		if(!isFound) {
			System.out.println("Invalid name");
		}
	}
	

}
