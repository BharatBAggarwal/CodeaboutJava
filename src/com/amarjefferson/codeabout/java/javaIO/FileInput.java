package com.amarjefferson.codeabout.java.javaIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

import com.amarjefferson.codeabout.java.classes.samples.ParseStringFI;
import com.amarjefferson.codeabout.java.generics.DataValue;

/**
 * File Name: FileInput.java
 *
 * Package: com.amarjefferson.codeabout.java.javaIO
 * Class: FileInput
 *
 */
public class FileInput {
	public static final String END_OF_FILE = "Reached end of file : no more input";

	private Scanner inputScanner;
	private String fileName = "";
	private File dataFile;
	private boolean fileExists;
	private String lineOfData = "";

	/**
	 * 
	 */
	public FileInput(String aFile, StandardOpenOption openMode) {
		this.fileName = aFile;
		this.fileExists = false;
		this.inputScanner = null;
		
		openFile();
	}

	// read next line of input
	public void openFile() {
		try {
			// Create File object
			this.dataFile = new File(this.fileName);
			if(!this.dataFile.exists()) {
				throw new FileNotFoundException("Could not find the file " + this.dataFile.getPath());
			}

			// open Scanner for input
			this.fileExists = true;
			this.inputScanner = new Scanner(this.dataFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}

	// read next line of input
	public String readLine() {
		if(!this.fileExists)
			return "The file " + this.fileName + " does not exist";

		if(this.inputScanner.hasNextLine()) {
			this.lineOfData = this.inputScanner.nextLine();
		}
		else {
			this.lineOfData = END_OF_FILE;
		}
		return this.lineOfData;
	}

	// return path of file
	public String filePath() {
		if(this.fileExists)
			return this.dataFile.getPath();
		else
			return "The file " + this.fileName + " does not exist";
	}

	public boolean existsFile() {
		return this.fileExists;
	}
	
	// close file
	public void closeFile() {
		if(this.inputScanner != null)
			this.inputScanner.close();  // close scanner
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// File input test
		FileInput x = new FileInput("bin/files/default.txt", StandardOpenOption.READ);
		if(!x.existsFile()) {
			System.out.println(x.filePath());
			return;
		}
		
		String aLine = "";
		ParseStringFI aParser = new ParseStringFI();
		// parse first line
		aLine = x.readLine();
		System.out.println("Data: " + aLine);
		System.out.println("label: " + dataLine1.getLabel());         // process line
		System.out.println("value: " + aParser.extractDouble(aLine) + "\n");  // process line

		// parse second line
		aLine = x.readLine();
		System.out.println("Data: " + aLine);
		DataValue<String> dataLine2 = ParseStringFI.extractString(aLine);
		System.out.println("label: " + dataLine2.getLabel());         // process line
		System.out.println("value: " + dataLine2.getValue() + "\n");  // process line

		// parse third line
		aLine = x.readLine();
		System.out.println("Data: " + aLine);
		DataValue<Long> dataLine3 = ParseStringFI.extractLong(aLine);
		System.out.println("label: " + dataLine3.getLabel());         // process line
		System.out.println("value: " + dataLine3.getValue() + "\n");  // process line

		// parse fourth line
		aLine = x.readLine();
		System.out.println("Data: " + aLine);
		DataValue<Float> dataLine4 = ParseStringFI.extractFloat(aLine);
		System.out.println("label: " + dataLine4.getLabel());         // process line
		System.out.println("value: " + dataLine4.getValue() + "\n");  // process line
		x.closeFile();
	}

}
