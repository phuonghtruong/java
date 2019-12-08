package studentManagement;

import java.util.Comparator;

public class Student {
	private String studentID;
	private String studentName;
	private int studentAge;
	private String studentAddress;
	private double studentGPA;
	
	public Student() {
		studentID = "unknown";
		studentName = "unknown";
		studentAge = 0;
		studentAddress = "unknown";
		studentGPA = 0.0;
	}
	
	public Student(String studentID, String studentName, int studentAge,
			       String studentAddress, double studentGPA) {
		setStudentID(studentID);
		setStudentName(studentName);
		setStudentAge(studentAge);
		setStudentAddress(studentAddress);
		setStudentGPA(studentGPA);
	}
	
	public void setStudentID(String studentID) {
		if(studentID == null) {
			throw new IllegalArgumentException("student ID can not be null");
		}
		else {
			this.studentID = studentID;
		}
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
	
	public void setStudentGPA(double studentGPA) {
		if(studentGPA < 0) {
			throw new IllegalArgumentException("student GPA can not be negative");
		}
		else {
			this.studentGPA = studentGPA;
		}
	}
	
	public double getStudentGPA() {return studentGPA;}
	
	public void displayStudentDetail() {
		System.out.println(getStudentID() + "\t" + getStudentName() + "\t" +
						   getStudentAddress() + "\t" + getStudentGPA());
	}
}


