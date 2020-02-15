/**
 * 
 */
package ca.bcit.comp1451.session3.LabB;

/**
 * @author Brian Truong
 *
 */
public class Driver {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Utilities u1 = new Utilities();
		u1.populateHashMap();
		u1.displayCollection();
		System.out.println();
		u1.getCount("the");
		System.out.println();
		u1.displayTheWord(3);
		System.out.println();
		u1.removeWord("the");
		u1.displayCollection();		

	}

}
