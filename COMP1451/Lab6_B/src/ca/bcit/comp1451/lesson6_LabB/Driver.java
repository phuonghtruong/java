/**
 * 
 */
package ca.bcit.comp1451.lesson6_LabB;

/**
 * @author Brian Truong
 * Feb. 23, 2020
 * Driver.java
 */
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonCollection pc1 = new PersonCollection();
		
		Person e1 = new Employee("Wayu", 34, 35.8, 42);
		Person s1 = new Student("Kobe", 23, true, 3.5);
		
		pc1.loadCollection(s1);
		pc1.loadCollection(e1);

		//pc1.displayAllDetails();
		pc1.testEquality();
	}

}