/**
 * 
 */
package ca.bcit.comp1451.lesson6_LabB;

/**
 * @author Brian Truong
 * Feb. 23, 2020
 * PersonCollection.java
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
	
	public void testEquality() {
		Person s1 = new Student("Brian", 30, true, 3.5);
		Person s2 = new Student("Brian", 23, true, 3.5);
		
		System.out.println(s1.toString());
		System.out.println(s2.toString());
		System.out.println();
		if(s1.equals(s2)){
			System.out.println("HashCode Student 1: " + s1.hashCode());
			System.out.println("HashCode Student 2: " + s2.hashCode());
			System.out.println("Result : Equal");			
		}
		else {
			System.out.println("HashCode Student 1: " + s1.hashCode());
			System.out.println("HashCode Student 2: " + s2.hashCode());
			System.out.println("Result : Not equal");
		}
		
		System.out.println();
		Person e1 = new Employee("Wayu", 34, 30.5, 42);
		Person e2 = new Employee("Wayu", 34, 35.8, 42);
		
		System.out.println(e1.toString());
		System.out.println(e2.toString());		
		System.out.println();
		if(e1.equals(e2)){
			System.out.println("HashCode Employee 1: " + e1.hashCode());
			System.out.println("HashCode Employee 2: " + e2.hashCode());
			System.out.println("Result : Equal");
		}
		else {
			System.out.println("HashCode Employee 1: " + e1.hashCode());
			System.out.println("HashCode Employee 2: " + e2.hashCode());
			System.out.println("Result : Not equal");
		}
	}

}