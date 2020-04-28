package com.amarjefferson.codeabout.java.classes.samples;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Function;

/**
 * File Name: ParseStringFI.java
 *
 * Package: com.amarjefferson.codeabout.java.classes.samples
 * Class: ParseStringFI
 * Extracts data value from a string of type "label : value"
 * The label is ignored
 *
 */
public class ParseStringFI {

	public <R extends Number> R extract(String aLine, Function<String, R> convert) {
		// Parse a "label : value" string. Return the value. Ignore the label.
		// Parameter aParser parses the string aLine
		R value = null;
		
		try(Scanner parseLine = new Scanner(aLine).useDelimiter(" *: *")) {
			parseLine.next();                         // skip the label
			value = convert.apply(parseLine.next());  // convert the value String
		}
		catch (InputMismatchException e) {
			System.out.println("Data type mismatch: " + e.getMessage());
		}
		catch (Exception e) {
			System.out.println("Error in extract: " + e.getMessage());
		}

		return value;
	}

	
	// Parse a float value
	// create an instance of Function<String, Float>
	private Function<String, Float> stringToFloat = new Function<String, Float>() {
		 public Float apply(String aStr) {
			return Float.parseFloat(aStr);
		}
	};

	public Float extractFloat (String aLine) {
		return extract(aLine, stringToFloat);
	}

	
	// Parse a double value
	// We will pass lambda expressions to Function<T, R> parameter
	public Double extractDouble (String aLine) {
		return extract(aLine, (inp)->Double.parseDouble(inp));
		// return extract(aLine, (inp)->strToDouble(inp));
	}


	// Parse an integer value
	// We will use method references for Function<T, R> parameter
	public Integer extractInteger (String aLine) {
		return extract(aLine, Integer::parseInt);
		//return extract(aLine, this::strToInteger);
	}


	// Parse a long value
	// We will use method references for Function<T, R> parameter
	public Long extractLong (String aLine) {
		return extract(aLine, Long::parseLong);
		// return extract(aLine, this::strToLong);
	}


	// Parse a string value
	public String extractString(String aLine) {
		String value = "";
		try(Scanner parseLine = new Scanner(aLine).useDelimiter(" *: *")) {
		parseLine.next();
		value = parseLine.next();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return value;
	}

    // Convert String to type T with error checking
	// Convert a String to Double
	public Double strToDouble(String str) {
		Double number = Double.NaN;
		if(str.isEmpty())
			return number;

		try {
			number = Double.parseDouble(str);
		}
		catch (NullPointerException e) {
			number = Double.NaN;
		}
		catch (NumberFormatException e) {
			number = Double.NaN;
		}
		return number;
	}

	// Convert a String to Float
	public Float strToFloat(String str) {
		Float number = Float.NaN;
		if(str.isEmpty())
			return number;
		
		try {
			number = Float.parseFloat(str);
	   	}
	   	catch (NullPointerException e) {
	        number = Float.NaN;
	   	}
	   	catch (NumberFormatException e) {
	   		number = Float.NaN;
	   	}

		return number;
	}

	// Convert a String to Integer
	public Integer strToInteger(String str) {
		Integer number = Integer.MIN_VALUE;
		if(str.isEmpty())
			return number;
		try {
			number = Integer.parseInt(str);
	   	}
	   	catch (NullPointerException e) {
	        number = Integer.MIN_VALUE;
	   	}
	   	catch (NumberFormatException e) {
	   		number = Integer.MIN_VALUE;
	   	}
		return number;
	}

	// Convert a String to Long
	public Long strToLong(String str) {
		Long number = Long.MIN_VALUE;
		if(str.isEmpty())
			return number;
		try {
			number = Long.parseLong(str);
	   	}
	   	catch (NullPointerException e) {
	        number = Long.MIN_VALUE;
	   	}
	   	catch (NumberFormatException e) {
	   		number = Long.MIN_VALUE;
	   	}
		return number;
	}


}
