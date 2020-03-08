/**
 * 
 */
package ca.bcit.comp1451.Lab7B;

/**
 * @author Brian Truong
 * Feb. 29, 2020
 * Driver.java
 */
import java.util.ArrayList;

public class Driver {

	private static ArrayList<Employee> listOfEmployees;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		listOfEmployees = new ArrayList<Employee>();
		
		Employee salePerson1 = new SalesEmployee("Tim", 1400, 0.6);
		Employee salePerson2 = new SalesEmployee("Diana", 1570, 0.65);
		
		Employee hourlyPerson1 = new HourlyEmployee("Howard", 25, 24);
		Employee hourlyPerson2 = new HourlyEmployee("Kristine", 27, 30);
		
		listOfEmployees.add(salePerson1);
		listOfEmployees.add(salePerson2);
		listOfEmployees.add(hourlyPerson1);
		listOfEmployees.add(hourlyPerson2);
		
		for(Employee e:listOfEmployees) {
			System.out.println(e);
			System.out.println();
		}
	}

}
