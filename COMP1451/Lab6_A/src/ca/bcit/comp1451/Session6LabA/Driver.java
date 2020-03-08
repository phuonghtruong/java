/**
 * 
 */
package ca.bcit.comp1451.Session6LabA;

/**
 * @author Brian Truong
 *
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

		pc1.displayAllDetails();
	}

}
