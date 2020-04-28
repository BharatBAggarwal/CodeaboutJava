package com.amarjefferson.codeabout.java.events;

import java.util.Scanner;
import com.amarjefferson.codeabout.java.mvc.data.TcConstants;
import com.amarjefferson.codeabout.java.mvc.data.TemperatureConversionData;

/**
 * File Name: TemperatureInput.java
 *
 * Package: com.amarjefferson.codeabout.java.events
 * Class: TemperatureInput
 *
 */
public class TemperatureInput {
	TemperatureConversionData tcd;
	Scanner aScanner;

	/**
	 * 
	 */
	public TemperatureInput() {
		aScanner = new Scanner(System.in);
	}

	public TemperatureConversionData getUserInput() {
		double input = 0.0;
		int op = 0;

			// input operation
			System.out.println("Input operation (1 = to \u00B0F - 2 = to \u00B0C - 3 = exit): ");
			if(aScanner.hasNextInt()) {
				op = aScanner.nextInt();
			}

			if(op > 2) { // stop if op greater than 2
				aScanner.close();
				return null;
			}

			if(op < 1)  // default to celcius to fahrenheit conversion if op < 1
				op = 1;

			// input temperature
			if(op == 1) {
				System.out.println("Input Temperature in \u00B0C:");
				tcd = new TemperatureConversionData(TcConstants.conversion.toFahrenheit);
			}
			else {
				System.out.println("Input Temperature in \u00B0F:");
				tcd = new TemperatureConversionData(TcConstants.conversion.toCelsius);
			}

			if(aScanner.hasNextDouble()) {
				input = aScanner.nextDouble();
				tcd.setInputValue(input);
			}
			return tcd;
		}
}
