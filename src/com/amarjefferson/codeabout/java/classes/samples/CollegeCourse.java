package com.amarjefferson.codeabout.java.classes.samples;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * File Name: CollegeCourse.java
 *
 * Package: com.amarjefferson.codeabout.java.classes.collegeCourse
 * 
 * Problem Statement:
 * Calculate Average marks for a college course
 * 
 * Class Name: CollegeCourse
 * 
 * Data Members:
 *   Course number (up to 10 characters)
 *   Name of the course (up to 60 characters)
 *   Number of students (maximum 100)
 *   Marks for all the students (marks are double values)
 *
 * The class has to perform the following actions:
 *   Input the course number
 *   Input the course name
 *   Input the number of students
 *   Input marks for all the students
 *   Calculate the average marks
 *
 * Class Use:
 * 
 * Write a main program that creates an object of class CollegeCourse and uses the member functions of the class to do the following:
 * 1.	Inputs the course number
 * 2.	Inputs the course name
 * 3.	Inputs the number of students
 * 4.	Inputs the marks for all the students
 * 5.	Calculates the average marks for the class
 * 6.	Prints a report using the format shown below:
 * Course Report
 * -------------
 * Course: CSE 101 - Introducing Java
 * Number of Students: 5
 * Class Average:   57.80
 * 
*/
public class CollegeCourse {
	
	private String courseNumber;
	private String courseName;
	private int studentCount;
	private List<Double> marks;     // marks array
	private boolean areMarksInput;  // have the marks been input
	private Scanner aScanner;
	
	public CollegeCourse() {
	this("Welcome 101", "Orientation", 10);
	}

	public CollegeCourse(String number, String name, int students) {
		// create a Scanner for input
		this.courseNumber = number;
		this.courseName = name;
		this.studentCount = students;
		this.marks = new ArrayList<>();         // marks array
		this.areMarksInput = false;             // have the marks been input
		this.aScanner = new Scanner(System.in);
	}

	/**
	 * @param courseNumber the name to set
	 */
	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	/**
	 * @return the number
	 */
	public String courseNumber() {
		return this.courseNumber;
	}
	
	public void inputCourseNumber() {
		String str = "";
		while(true) {
			str = "";
			// input course number
			System.out.println("Input course number (up to 10 characters): ");
			if(this.aScanner.hasNextLine()) {
				str = this.aScanner.nextLine();
			}
			// check if name is valid
			if(str.isEmpty() || str.length() > 10) {
				System.out.println("The specified course number is not valid");
				continue;
			} else {
				this.setCourseNumber(str);
				break;
			}
		}
	}

	/**
	 * @return the name
	 */
	public String courseName() {
		return this.courseName;
	}

	/**
	 * @param courseName the name to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public void inputCourseName() {
		String str = "";
		while(true) {
			str = "";
			// input name of course
			System.out.println("Input name of course (up to 60 characters): ");
			if(this.aScanner.hasNextLine()) {
				str = this.aScanner.nextLine();
			}
			// check if name is valid
			if(str.isEmpty() || str.length() > 60) {
				System.out.println("The specified course name is not valid");
				continue;
			} else {
				this.setCourseName(str);
				break;
			}
		}
	}
	
	/**
	 * @return the studentCount
	 */
	public int getStudentCount() {
		return this.studentCount;
	}

	/**
	 * @param studentCount the studentCount to set
	 */
	public void setStudentCount(int count) {
		this.studentCount = count;
	}

	public void inputStudentCount() {
		int count = 0;
		while(true) {
			count = 0;
			// input name of course
			System.out.println("Input number of students (1 - 100): ");
			if(this.aScanner.hasNextInt()) {
				count = this.aScanner.nextInt();
			}
			// check if name is valid
			if(count < 1 || count > 100) {
				System.out.println("The specified number of students is not valid");
				continue;
			} else {
				this.setStudentCount(count);
				break;
			}
		}		
	}

	public List<Double> getAllMarks() {
		return marks;
	}

	public void addScore(double aScore) {
		marks.add(aScore);
	}

	/**
	 * @param marks the marks to set
	 */
	public void inputMarks() {
		if(this.studentCount < 1) {
			System.out.println("There are no students in the class!");
			return;
		}
		
		double temp = 0.0;
		marks.clear();
		this.areMarksInput = false;
		
		for(int i = 0; i < this.studentCount; i++ ) {
			System.out.println("Input marks for student " + (i+1) + ": " );
			if(this.aScanner.hasNextDouble()) {
				temp = this.aScanner.nextDouble();
			} 
			addScore(temp);
		}
		
		this.areMarksInput = true;		
	}
	
	public double average() {
		if(!this.areMarksInput) {
			System.out.println("Marks have not been input!");
			return 0.0;
		}
		
		double sum  = 0.0;
		for( double score : marks ) {
			sum = sum + score;
		}
	
		return sum/studentCount;
		
		// using Java 8 Streams
//		return marks.stream().mapToDouble(t -> t.doubleValue()).average().getAsDouble();
	}

	@Override
	public String toString() {
		String str = "Course Report\n-------------\n";
		str += "Course: " + this.courseNumber + " - " + this.courseName + "\n" +
		       "Number of Students: " + this.studentCount + "\n" +
		       String.format("Class Average: %7.2f%n", this.average()) + "\n";
		return str;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CollegeCourse myCourse = new CollegeCourse();
		myCourse.inputCourseNumber();
		myCourse.inputCourseName();
		myCourse.inputStudentCount();
		myCourse.inputMarks();
		System.out.println(myCourse);
	}
}
