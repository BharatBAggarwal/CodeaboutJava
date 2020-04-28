package com.amarjefferson.codeabout.java.javaIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import com.amarjefferson.codeabout.java.classes.samples.ParseStringFI;
import com.amarjefferson.codeabout.java.generics.DataValue;

/**
 * File Name: FileIoNio.java
 *
 * Package: com.amarjefferson.codeabout.java.fileIo
 * Class: FileIoNio
 *
 */
public class FileIoNio {
	private String fileName = "";
	private Path filePath = null;
	private boolean isPathValid = true;

	/**
	 * 
	 */
	public FileIoNio(String aFile) {
		this.fileName = aFile;
		try {
			// create Path object
			this.filePath = Paths.get(this.fileName);
			// if the file does not exist
			if(Files.notExists(this.filePath)) {
				Files.createFile(this.filePath);
			}
		} catch (InvalidPathException e) {
			System.err.println(e.getMessage());
			this.isPathValid = false;
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} 
	}

	// return path of file
	public String filePath() {
		if(this.isPathValid)
			return this.filePath.toAbsolutePath().toString();
		else
			return "";
	}

	// read file content as lines of text
	public List<String> asLinesOfText(boolean buffered) {
		if(buffered) {
			return readAllLinesBuffered();
		} else {
			return readAllLines();
		}
	}

	// read file content as lines of text
	private List<String> readAllLines() {
		if(!this.isPathValid) {
			return null;
		}

		// read all lines
		List<String> allLines = null;
		try {
			allLines = Files.readAllLines(this.filePath, Charset.defaultCharset());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return allLines;
	}

	// buffered read file content as lines of text
	private List<String> readAllLinesBuffered() {
		if(!this.isPathValid) {
			return null;
		}

		List<String> allLines = new ArrayList<String>();
		try(BufferedReader reader = Files.newBufferedReader(this.filePath, Charset.defaultCharset())) {
			String aLine = null;
			while ( (aLine = reader.readLine()) != null ) {
				allLines.add(aLine); 
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return allLines;
	}

	// read file content as a byte[]
	public byte[] asByteArray() {
		if(!this.isPathValid) {
			return null;
		}

		byte[] bytes = null;
		try {
			bytes = Files.readAllBytes(this.filePath);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return bytes;
	}

	// write data to file
	public <T> void writeData(String label, T value, StandardOpenOption mode) {
		if(!this.isPathValid) {
			return;
		}

//		Files.write(this.filePath, aLine.getBytes(), mode);  // write bytes
		String aLine = label + "   :  " + value;
		try(BufferedWriter writer = Files.newBufferedWriter(this.filePath, Charset.defaultCharset(), mode)) {
			writer.write(aLine, 0, aLine.length());
			writer.newLine();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	// write line to file
	public <T> void writeLine(String aLine, StandardOpenOption mode) {
		if(!this.isPathValid) {
			return;
		}

//		Files.write(this.filePath, aLine.getBytes(), mode);  // write bytes
		try(BufferedWriter writer = Files.newBufferedWriter(this.filePath, Charset.defaultCharset(), mode)) {
			writer.write(aLine, 0, aLine.length());
			writer.newLine();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// File input test
		FileIoNio x = new FileIoNio("bin/files/default.txt");
		
		byte[] bytes = x.asByteArray();
		System.out.println("bytes = [" + bytes + "]");
		

		List<String> lines = x.asLinesOfText(true);
		System.out.println("Number of lines = " + lines.size());

		// parse first line
		DataValue<Double> dataLine1 = ParseStringFI.extractDouble(lines.get(0));
		System.out.println("1 label: " + dataLine1.getLabel());  // process line
		System.out.println("1 value: " + dataLine1.getValue());  // process line

		// parse second line
		DataValue<String> dataLine2 = ParseStringFI.extractString(lines.get(1));
		System.out.println("2 label: " + dataLine2.getLabel());  // process line
		System.out.println("2 value: " + dataLine2.getValue());  // process line

		// file append test
		x.writeLine("-< ----- Appended using java.nio ----- >-", StandardOpenOption.APPEND);
		x.writeData("A long Value", 4356, StandardOpenOption.APPEND);
		x.writeData("A float Value", 4356.88, StandardOpenOption.APPEND);
		System.out.println("Appended data to file " + x.filePath());

		// file write test
		x = new FileIoNio("bin/files/newfile.txt");
		x.writeLine("-< ----- java.nio ----- >-", StandardOpenOption.TRUNCATE_EXISTING);
		x.writeData("A long Value", 4356, StandardOpenOption.APPEND);
		x.writeData("A float Value", 4356.88, StandardOpenOption.APPEND);
		System.out.println("Created new file " + x.filePath());
	}

}
