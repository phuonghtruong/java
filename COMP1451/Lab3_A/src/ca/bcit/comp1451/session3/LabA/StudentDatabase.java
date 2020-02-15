/**
 * 
 */
package ca.bcit.comp1451.session3.LabA;

/**
 * @author A01203138
 *
 */
import java.util.HashMap;

public class StudentDatabase {
	
	private HashMap<String, int[]> quizMarks;
	
	public static final int NUM_QUIZZES = 10;
	public static final int MIN_GRADE = 0;
	public static final int MAX_GRADE = 100;
	

	public StudentDatabase() {
		quizMarks = new HashMap<String, int[]>();		
	}
	
	private String formatName(String name) {
		String firstLetter = name.toUpperCase().substring(0, 1);
		String theRest = name.toLowerCase().substring(1);
		return firstLetter + theRest;
	}
	
	public void addStudent(String studentName) {
		int[] quizMark = new int[NUM_QUIZZES] ;
		for(int index=0;index <NUM_QUIZZES;index++ ) {
			quizMark[index]=MIN_GRADE;
		}
		if(!quizMarks.containsKey(formatName(studentName))) {
			quizMarks.put(formatName(studentName), quizMark);
		}
	}
	
	public void displayQuizzes(String student) {
		if(quizMarks.containsKey(formatName(student))) {
			for(int index=0;index<NUM_QUIZZES;index++) {
				System.out.print(quizMarks.get(formatName(student))[index] + " ");
			}
		}
	}
	
	public void changeQuizMark(String studentName, int whichQuiz, int newMark) {
		if(quizMarks.containsKey(formatName(studentName)) && 
				newMark >= MIN_GRADE && newMark <= MAX_GRADE && 
				whichQuiz >= 0 && whichQuiz < NUM_QUIZZES ) {
			quizMarks.get(formatName(studentName))[whichQuiz] = newMark;
		}
	}
	
	public void showQuizMarks() {
		for(String studentName : quizMarks.keySet()) {
			System.out.println("Quiz marks for: " + formatName(studentName));
			displayQuizzes(formatName(studentName));
			System.out.println();
		}
	}
}
