/**
 * 
 */
package ca.bcit.comp1451.session3.LabA;

/**
 * @author A01203138
 *
 */
public class Driver {

	public static void main(String[] args) {

		StudentDatabase s1 = new StudentDatabase();  
		
		s1.addStudent("Collen");
		s1.addStudent("Bill");
		s1.addStudent("Brian");
		
		s1.displayQuizzes("collen");
		System.out.println();
		s1.changeQuizMark("bILl", 5, 8);
		s1.showQuizMarks();
	}

}
