package com.amarjefferson.codeabout.java.javaIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.StandardOpenOption;

/**
 * File Name: FileOutput.java
 *
 * Package: com.amarjefferson.codeabout.java.javaIO
 * Class: FileOutput
 *
 */
public class FileOutput {
	public static final String END_OF_FILE = "Reached end of file : no input";

	private PrintWriter outputWriter = null;

	private String fileName = "";
	private StandardOpenOption fileOpenMode;
	private File dataFile;
	
	boolean appendData = false;

	/**
	 * 
	 */
	public FileOutput(String aFile, StandardOpenOption openMode) {
		this.fileName = aFile;
		this.fileOpenMode = openMode;

		// open file for appending data
		if(this.fileOpenMode == StandardOpenOption.APPEND)				
			this.appendData = true;   // open file for appending

		// read properties file
		try {
			// Create File object
			this.dataFile = new File(this.fileName);
			if(!this.dataFile.exists()) {
				this.dataFile.createNewFile();  // create a new file
			}

			// open Writer for output
			FileWriter fWriter = new FileWriter(this.dataFile, this.appendData);
			this.outputWriter = new PrintWriter(fWriter, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// return path of file
	public String filePath() {
		return this.dataFile.getPath();
	}

	// write data line to file
	public <T> void writeData(String label, T value) {
		if(this.outputWriter == null)
			return;
		this.outputWriter.println(label + "   :  " + value);
	}

	// write comment line to file
	public void writeLine(String aLine) {
		if(this.outputWriter == null)
			return;
		this.outputWriter.println(aLine);
	}

	// close file
	public void closeFile() {
		if(this.outputWriter != null)
			this.outputWriter.close();  // close writer
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileOutput x = null;
		
		// file append test
		x = new FileOutput("bin/files/default.txt", StandardOpenOption.APPEND);
		x.writeLine("-< ----- Appended content ----- >-");
		x.writeData("A long Value", 4356);
		x.writeData("A float Value", 4356.88);
		x.closeFile();

		// file write test
		x = new FileOutput("bin/files/newfile.txt", StandardOpenOption.WRITE);
		x.writeLine("-< ----- New content ----- >-");
		x.writeData("A long Value", 7689);
		x.writeData("A float Value", 3621.88);
		x.closeFile();
	}

}
