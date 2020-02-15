package studentManagement;

import java.util.*;
import java.lang.*;

//class Student;

public class Course {
	private ArrayList<Student> studentList;
	
	public Course() {
		studentList = new ArrayList<Student>();
	}

	public void addStudent(Student student) {
		if(student != null) {
			studentList.add(student);
		}
	}
	
	public void editStudentByID(String studentID) {
		for(Student student : studentList) {
			if(student.getStudentID().equalsIgnoreCase(studentID)) {
				System.out.println("Select information you want to change below");
				System.out.println("1. Student Name");
				System.out.println("2. Student Age");
				System.out.println("3. Student Address");
				System.out.println("4. Student GPA");
				
				Scanner input1 = new Scanner(System.in);
				int choice = input1.nextInt();
				switch (choice) {
					case 1:
						System.out.println("Enter new student name: ");
						String newStudentName = input1.nextLine();
						student.setStudentName(newStudentName);
						break;
					case 2:
						System.out.println("Enter new student age: ");
						int newStudentAge = input1.nextInt();
						student.setStudentAge(newStudentAge);
						break;
					case 3:
						System.out.println("Enter new student address: ");
						String newStudentAddress = input1.nextLine();
						student.setStudentAddress(newStudentAddress);
						break;
					case 4:
						System.out.println("Enter new student GPA: ");
						double newStudentGPA = input1.nextDouble();
						student.setStudentGPA(newStudentGPA);
						break;
					default:
						System.out.println("Invalid choice!!! Please re-select");
				}
			}
		}
	}
	
	public void deleteStudentByID(String studentID) {
		Iterator<Student> iter = studentList.iterator();
        while(iter.hasNext()){
            Student student = iter.next();
            if(student.getStudentID()== studentID){
                iter.remove();
            }
        }
	}
	
	public static class Comparators{
		public static Comparator<Student> NAME = new Comparator<Student>(){
		@Override
			public int compare(Student s1, Student s2)
	    	{
	        	return s1.getStudentName().compareTo(s2.getStudentName());
	    	}
		};

		public static Comparator<Student> GPA = new Comparator<Student>(){
		@Override
			public int compare(Student s1, Student s2)
	    	{
				if (s1.getStudentGPA() < s2.getStudentGPA()) return -1;
				if (s1.getStudentGPA() > s2.getStudentGPA()) return 1;
				return 0;
	    	}
		};
	}
	public void displayCourseMembers() {
		System.out.println("***** List of Students *****");
		System.out.println("============================");
		for(Student student:studentList) {
			student.displayStudentDetail();
		}
	}
	
	
	
	
	public static void main(String[] args) {
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
		
		System.out.println("/**********************************/");
		System.out.println("1. Add student.");
		System.out.println("2. Edit student by id.");
		System.out.println("3. Delete student by id.");
		System.out.println("4. Sort student by gpa.");
		System.out.println("5. Sort student by name.");
		System.out.println("6. Show student.");
		System.out.println("0. Exit.");
		System.out.println("/**********************************/");
		
		System.out.println();
		System.out.println("Enter your choice: ");
		Scanner input1 = new Scanner(System.in);
		int choice = input1.nextInt();
		
		switch(choice) {
			case 1:
				break;
			case 2:
				System.out.println("Enter student ID: ");
				String studentID = input1.nextLine();
				c1.editStudentByID(studentID);
				break;
			case 3:
				System.out.println("Enter student ID: ");
				studentID = input1.nextLine();
				c1.deleteStudentByID(studentID);
				break;
			case 4:
				Collections.sort(c1.studentList, Course.Comparators.NAME);
				break;
			case 5:
				Collections.sort(c1.studentList, Course.Comparators.GPA);
				break;
			case 6:
				c1.displayCourseMembers();
				break;
			case 0:
				System.exit(0);
		}
		
	}
}



