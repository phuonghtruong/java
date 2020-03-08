package studentManagement;

import java.util.*;

public class main {
	private static InputReader reader;   //why putting static here ???
	
	public static void main(String[] args) {
		
		reader = new InputReader();
		
		Student s1 = new Student("001", "Zico", 32, "Santos", 3.7);
		Student s2 = new Student("002", "Daphne", 27, "Vancouver", 3.9);
		Student s3 = new Student("003", "Katy", 19, "Victory", 2.6);
		Student s4 = new Student("004", "Suzane", 45, "Perth", 3.3);
		Student s5 = new Student("005", "Brian", 30, "Burnaby", 4.2);
		
		Course c1 = new Course();
		c1.addStudent(s1);
		c1.addStudent(s2);
		c1.addStudent(s3);
		c1.addStudent(s4);
		c1.addStudent(s5);
		
		while(true) {
			c1.courseMenu();
			
			System.out.println();
			System.out.println("Enter your choice: ");
			int selection = reader.readInt();
			
			switch(selection) {
				case 1:
					System.out.println("Enter Student ID: ");
					String studentID = reader.readString();
					System.out.println("Enter Student Name: ");
					String studentName = reader.readString();
					System.out.println("Enter Student Age: ");
					int studentAge = reader.readInt();
					System.out.println("Enter student address: ");
					String studentAddress = reader.readString();
					Student newStudent = new Student(studentID, studentName,
													 studentAge, studentAddress, 0.0);
					c1.addStudent(newStudent);
					break;
				case 2:
					System.out.println("Enter student ID: ");
					studentID = reader.readString();
					c1.updateStudentScoreByID(studentID);
					break;
				case 3:
					System.out.println("Enter student ID: ");
					studentID = reader.readString();
					c1.deleteStudentByID(studentID);
					break;
				case 4:
					c1.sortStudentByName();
					break;
				case 5:
					c1.sortStudentByScore();
					break;
				case 6:
					c1.displayCourseMembers();
					break;
				case 0:
					System.exit(0);
				default:
					System.out.println("Invalid choice!!! Choose again");
					break;
			}
		}
	}
}
