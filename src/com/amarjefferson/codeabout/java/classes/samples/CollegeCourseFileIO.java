package com.amarjefferson.codeabout.java.classes.samples;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

import com.amarjefferson.codeabout.java.javaIO.ApplicationProperties;
import com.amarjefferson.codeabout.java.javaIO.ParseStringScanner;

/**
 * File Name: CollegeCourseFileIO.java
 *
 * Package: com.amarjefferson.codeabout.java.classes.collegeCourse
 * Class: CollegeCourseFileIO
 *
 * Problem Statement:
 * Write a class named CollegeCourseFIleIO
 * 
 * The class should extend the CollegeCourse class to add file input and output:
 * Read data from a file
 * Save data to a file
 *
 * The same file is used for both input and output
 *   
 * File format:
 *      -< ------ Course Report Card ------ >-
 *      - File Name: demo.txt
 *      - Default Input for CollegeCourseFileIO Class
 *      - on 2016-06-24 at 17:09:33.147
 *      -< --------- Course Input --------- >-
 *      Course Number                : AJC-101
 *      Course Name                  : My favorite course
 *      Number of Students (Max 100) : 1
 *      -< ---------- Marks List ---------- >-
 *      Student 1  :  100.0
 *      -< ------------ Output ------------ >-
 *      Class average         : 100.0
 *      -< ---------- End of File --------- >-
 *   
 * Class Use:
 * 
 * Write a main program that uses all inherited CollegeCourse functions
 * and saves data to a user specified file using the above format
 */

public class CollegeCourseFileIO extends CollegeCourse {
	public static final String DEFAULT_DATA_FILE = "def$inp$.in$";
	public static final String PROPERTIES_FILE = "config.properties";
	
	private ApplicationProperties props = null;
	private boolean defaultFileRead = true;
	private Scanner consoleInput = null;
	private ParseStringScanner aParser = null;
	
	/**
	 * 
	 */
	public CollegeCourseFileIO() {
		try {
			// read properties file
			this.props = new ApplicationProperties(PROPERTIES_FILE);
			// get default values from file
			this.readDataFromFile(DEFAULT_DATA_FILE);
			defaultFileRead = true;
		} catch (IOException e) {
			// data not read from default file
			defaultFileRead = false;
			e.printStackTrace();
		}

		// create a Scanner for input
		this.consoleInput = new Scanner(System.in);
		
		// create parse object for input strings
		this.aParser = new ParseStringScanner();
	}

	public String inputFilename() {
		String str = "";
		while(true) {
			str = "";
			// input name of course
			System.out.println("Input name of data file (example: myfile.txt):");
			if(this.consoleInput.hasNextLine()) {
				str = this.consoleInput.nextLine();
			}
			// check if name is valid
			if(str.isEmpty() || str.length() > 60) {
				System.out.println("The specified file name is not valid");
				continue;
			} else {
				break;
			}
		}
		return str;
	}

	private String prepareInput(String fileName) {
		String str;
		str =  "-< ------ Course Report Card ------ >-\n";
		str += "-< File Name: " + fileName + "\n";
		str += "-< Created by CollegeCourseFileIO Class\n";
		str += "-< on " + java.time.LocalDate.now().toString();
		str += " at " + java.time.LocalTime.now().toString() + "\n";
		str += "-< --------- Course Input --------- >-\n";
		str += "Course Number                : " + this.courseNumber() +"\n";
		str += "Course Name                  : " + this.courseName() +"\n";
		str += "Number of Students (Max 100) : " + this.getStudentCount() + "\n";
		str += "-< ---------- Marks List ---------- >-\n";
		int i = 0;
		List<Double> marks = getAllMarks();
		for(Double aResult : marks) {
			i++;
			str += "Student " + i + "  :  " + aResult.doubleValue() + "\n";
		}
		return str;
	}

	private String prepareOutput() {
		String str;
		str  = "-< ------------ Output ------------ >-\n";
		Formatter fmt = new Formatter();
		fmt.format("Class average         : %7.2f", this.average());
		str += fmt.toString() + "\n";
		fmt.close();
		str += "-< ---------- End of File --------- >-";
		return str;
	}

	public void saveDataToFile(String fileName, boolean isOutputFile) {
		File aDataFile = new File(this.props.getOutputDir(true) +  fileName);  // output file
		try (FileWriter fWriter = new FileWriter(aDataFile);) {  // overwrite content
			// write to file
			String str = prepareInput(fileName);    // String containing input
			if(isOutputFile) {
				str = str + prepareOutput();    // Add output if isOutput is true
			}
			fWriter.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readDataFromFile(String fileName) {
		File dataFile = new File(this.props.getInputDir(true) +  fileName);
		try ( Scanner aScanner = new Scanner(dataFile);) {
			// skip 5 comment lines at top of file
			aScanner.nextLine();
			aScanner.nextLine();
			aScanner.nextLine();
			aScanner.nextLine();
			aScanner.nextLine();

			// read 3 lines of data
			setCourseNumber(aParser.extractString(aScanner.nextLine()));
			setCourseName(aParser.extractString(aScanner.nextLine()));
			setStudentCount(aParser.extractInt(aScanner.nextLine()));

			// skip comment line
			aScanner.nextLine();

			// read marks
			double aMark;
			for(int i = 0; i < getStudentCount(); i++) {
				aMark = aParser.extractDouble(aScanner.nextLine());
				addScore(aMark);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CollegeCourseFileIO myCourse = new CollegeCourseFileIO();
		// change default values read from file
		myCourse.inputCourseNumber();
		myCourse.inputCourseName();
		myCourse.inputStudentCount();
		myCourse.inputMarks();
		System.out.println(myCourse);
		// save data in file
		String filename = myCourse.inputFilename();
		myCourse.saveDataToFile(filename, true);
		System.out.println("Data saved to file " + filename);
	}

}
