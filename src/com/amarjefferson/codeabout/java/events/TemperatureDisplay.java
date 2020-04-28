package com.amarjefferson.codeabout.java.events;

import com.amarjefferson.codeabout.java.mvc.data.TemperatureConversionData;

/**
 * File Name: TemperatureDisplay.java
 *
 * Package: com.amarjefferson.codeabout.java.events
 * Class: TemperatureDisplay
 *
 */
public class TemperatureDisplay {

	/**
	 * 
	 */
	public TemperatureDisplay() {
	}

	public void displayTemperature(TemperatureConversionData tcd) {
		System.out.println(tcd.toString());
	}
}
