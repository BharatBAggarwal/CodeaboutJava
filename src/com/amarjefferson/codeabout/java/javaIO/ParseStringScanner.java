package com.amarjefferson.codeabout.java.javaIO;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * File Name: ParseStringScanner.java
 *
 * Package: com.amarjefferson.codeabout.java.javaIO
 * Class: ParseStringScanner
 * Extracts data value from a string of type "label : value"
 * The label is ignored
 *
 */
public class ParseStringScanner {

	public double extractDouble(String aLine) {
		double value = 0.0D;
		try(Scanner parseLine = new Scanner(aLine).useDelimiter(" *: *")) {
		parseLine.next();
		value = parseLine.nextDouble();
		}
		catch (InputMismatchException e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return value;
	}

	public float extractFloat(String aLine) {
		float value = 0.0F;
		try(Scanner parseLine = new Scanner(aLine).useDelimiter(" *: *")) {
		parseLine.next();
		value = parseLine.nextFloat();
		}
		catch (InputMismatchException e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return value;
	}

	public long extractLong(String aLine) {
		long value = 0L;
		try(Scanner parseLine = new Scanner(aLine).useDelimiter(" *: *")) {
		parseLine.next();
		value = parseLine.nextLong();
		}
		catch (InputMismatchException e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return value;
	}

	public int extractInt(String aLine) {
		int value = 0;
		try(Scanner parseLine = new Scanner(aLine).useDelimiter(" *: *")) {
		parseLine.next();
		value = parseLine.nextInt();
		}
		catch (InputMismatchException e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return value;
	}

	public String extractString(String aLine) {
		String value = "";
		try(Scanner parseLine = new Scanner(aLine).useDelimiter(" *: *")) {
		parseLine.next();
		value = parseLine.next();
		}
		catch (InputMismatchException e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return value;
	}

}
