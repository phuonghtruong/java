/**
 * 
 */
package ca.bcit.comp1451.Session6LabA;

/**
 * @author Brian Truong
 *
 */
import java.util.ArrayList;

public class PersonCollection {
	
	private ArrayList<Person> listOfPerson;
	/**
	 * Constructor
	 */
	public PersonCollection() {
		// TODO Auto-generated constructor stub
		listOfPerson = new ArrayList<Person>();
	}
	/**
	 * Add object to ArrayList
	 * @param p
	 */
	public void loadCollection(Person p) {
		if(p != null) {
			listOfPerson.add(p);
		}
	}
	/**
	 * Display all details
	 */
	public void displayAllDetails() {
		for(Person p : listOfPerson) {
			System.out.println(p.toString());
			System.out.println();
		}
	}

}
