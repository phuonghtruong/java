package studentManagement;

import java.util.*;

public class Student {
	ArrayList<Course> registeredCourses;
	private String studentID;
	private String studentName;
	private int studentAge;
	private String studentAddress;
	private double studentScore;
	
	public static double totalRegisteredCredits = 0;
	public static int totalNumRegisteredCourses = 0;
	public static int id = 10000;
	public static final int maxNumRegisteredCourses = 5;
	public static final double maxRegisteredCredits = 15;
	

	public Student() {
		studentID = "unknown";
		studentName = "unknown";
		studentAge = 0;
		studentAddress = "unknown";
		studentScore = 0.0;
	}
	
	public Student(String studentName, int studentAge,
			       String studentAddress, double studentScore) {
		setStudentID();
		setStudentName(studentName);
		setStudentAge(studentAge);
		setStudentAddress(studentAddress);
		setStudentScore(studentScore);
	}
	
	public void setStudentID() {
		id++;
		studentID = "BCIT" + id;
	}
	
	public String getStudentID() {return studentID;}
	
	public void setStudentName(String studentName) {
		if(studentName == null) {
			throw new IllegalArgumentException("student name can not be null");
		}
		else {
			this.studentName = studentName;
		}
	}
	
	public String getStudentName() {return studentName;}
	
	public void setStudentAge(int studentAge) {
		if(studentAge < 0) {
			throw new IllegalArgumentException("student age can not be negative");
		}
		else {
			this.studentAge = studentAge;
		}
	}
	
	public int getStudentAge() {return studentAge;}
	
	public void setStudentAddress(String studentAddress) {
		if(studentAddress == null) {
			throw new IllegalArgumentException("student address can not be null");
		}
		else {
			this.studentAddress = studentAddress;
		}		
	}
	
	public String getStudentAddress() {return studentAddress;}
	
	public void setStudentScore(double studentScore) {
		if(studentScore < 0) {
			throw new IllegalArgumentException("student score can not be negative");
		}
		else {
			this.studentScore = studentScore;
		}
	}
	
	public double getStudentScore() {return studentScore;}
	
	public void registerCourse(String courseID) {
		if(totalRegisteredCredits > maxRegisteredCredits || 
				totalNumRegisteredCourses + 1 > maxNumRegisteredCourses) {
			
		}
	}

	public void withdrawCourse(String courseID) {
		
	}
	public void displayStudentDetail() {
		System.out.println(getStudentID() + "\t" + getStudentName() + "\t" +
						   getStudentAddress() + "\t\t" + getStudentScore());
	}
}


