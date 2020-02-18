package studentManagement;

import java.util.*;

//class Student;

public class Course {
	ArrayList<Student> studentList;
	private InputReader reader;
	private String courseName;
	private String courseID;
	private double courseCredits;
	

	public Course() {
		studentList = new ArrayList<Student>();
		courseName = "unknown";
		courseID = "unknown";
	}
	
	public Course(String courseName, String courseID) {
		studentList = new ArrayList<Student>();
		setCourseName(courseName);
		setCourseID(courseID);
	}

	public void setCourseName(String courseName) {
		if(courseName == null) {
			throw new IllegalArgumentException("Course Name can not be null");
		}
		else {
			this.courseName = courseName;
		}
	}
	
	public void setCourseID(String courseID) {
		if(courseID == null) {
			throw new IllegalArgumentException("Course ID can not be null");
		}
		else {
			this.courseID = courseID;
		}		
	}
	
	public String getCourseName() {return courseName;}
	
	public String getCourseID() {return courseID;}
	
	public boolean isRegistered(String studentID) {
		boolean statusRegistration = false;
		for(Student student:studentList) {
			if(student.getStudentID().equalsIgnoreCase(studentID)) {
				statusRegistration = true;
			}
		}
		return statusRegistration;
	}
	
	public void addStudent(Student student) {
		if(student != null) {
			if(isRegistered(student.getStudentID())) {
				System.out.println("Already registered and in the course list!!!");
			}
			else {
				studentList.add(student);
				System.out.println("Added Successfully!!!");
			}
		}
	}
	
	public void updateStudentScoreByID(String studentID) {
		for(Student student : studentList) {
			if(student.getStudentID().equalsIgnoreCase(studentID)) {
				System.out.println("The current score: " + student.getStudentScore());
				System.out.println("Enter new score: ");
				double newStudentScore = reader.readDouble();
				student.setStudentScore(newStudentScore);
						
			}
		}
	}
	
	public void deleteStudentByID(String studentID) {
		boolean isDetected = false;
		Iterator<Student> iter = studentList.iterator();
        while(iter.hasNext()){
            Student student = iter.next();
            if(student.getStudentID().equalsIgnoreCase(studentID)){
                iter.remove();
                isDetected = true;
            }
        }
        if(isDetected) System.out.println("Student ID: " + studentID + " is deleted sucessfully !!!");
        else System.out.println("The requested student ID is not found !!!");
	}
	
	public static class Comparators{
		// Sort by Name
		public static Comparator<Student> NAME = new Comparator<Student>(){
		@Override
			public int compare(Student s1, Student s2)
	    	{
	        	return s1.getStudentName().toLowerCase().compareTo(s2.getStudentName().toLowerCase());
	    	}
		};
		// Sort by score
		public static Comparator<Student> SCORE = new Comparator<Student>(){
		@Override
			public int compare(Student s1, Student s2)
	    	{
				if (s1.getStudentScore() < s2.getStudentScore()) return -1;
				if (s1.getStudentScore() > s2.getStudentScore()) return 1;
				return 0;
	    	}
		};
	}
	
	public void sortStudentByName() {
		Collections.sort(studentList, Comparators.NAME);
	}

	public void sortStudentByScore() {
		Collections.sort(studentList, Comparators.SCORE);
	}
	
	public void displayStudentByID(String studentID) {
		for(Student student:studentList) {
			if(student.getStudentID().equalsIgnoreCase(studentID)) {
				student.displayStudentDetail();
			}
		}
	}

	public void displayCourseMembers() {
		System.out.println("***** List of Students *****");
		System.out.println("============================");
		for(Student student:studentList) {
			student.displayStudentDetail();
		}
	}

	public void courseMenu() {
		System.out.println("/**********************************/");
		System.out.println("1. Add student.");
		System.out.println("2. Update student score by id.");
		System.out.println("3. Delete student by id.");
		System.out.println("4. Sort student by name.");
		System.out.println("5. Sort student by score.");
		System.out.println("6. Show students list.");
		System.out.println("0. Exit.");
		System.out.println("/**********************************/");
	}
	
}



