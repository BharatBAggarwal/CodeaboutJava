package com.amarjefferson.codeabout.java.classes.samples;

/**
 * 
 * File Name: VoltageSupply.java
 *
 * Package: com.amarjefferson.codeabout.java.classes.exercises
 * Class: VoltageSupply
 *
 * Problem Statement:
 * 
 * Write a class named VoltageSupply that will be used to simulate voltage supplies.
 * The voltage supplies have four properties:
 *    A name of up to 20 characters (truncate longer names)
 *    A voltage setting
 *    The minimum voltage supplied
 *    The maximum voltage supplied
 *    
 * The minimum and the maximum voltage values for the voltage supply should be set
 * in the constructor to 100 and 500, respectively.
 * 
 * If the user tries to set the voltage to a value outside the range, the current
 * voltage setting should not be change and an error message printed on the screen.
 * 
 * Write a main program that creates at least two objects of type VoltageSupply
 * and sets them to different voltages. Ask the objects what their voltage settings
 * are and print their answers on the screen.
 *
 * Problem based on Chapter 9 of
 * "Scientific and Engineering C++:
 * An Introduction with Advanced Techniques and Examples"
 * by J.J. Barton and L.R. Nackman
 */
public class VoltageSupply {
	public static int MAX_NAME_LENGTH = 20;
	private String name;
	private double voltage;
	private double minVoltage;
	private double maxVoltage;

	public VoltageSupply() {
		this("Default Voltage Supply", 0.0);
	}
	
	/**
	 * @param name
	 */
	public VoltageSupply(String name) {
		this(name, 0.0);
	}

	/**
	 * @param name
	 * @param voltage
	 */
	public VoltageSupply(String name, double voltage) {
		this.minVoltage = 100.0;
		this.maxVoltage = 500.0;
		
		// make sure initial voltage in range
		this.voltage = voltage;
		if(voltage < this.minVoltage) {
			this.voltage = this.minVoltage;
		}
		
		if(voltage > this.maxVoltage) {
			this.voltage = this.maxVoltage;
		}

		setName(name);
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		if(name.length() > MAX_NAME_LENGTH) {
			name = name.substring(0, MAX_NAME_LENGTH - 1);
			System.out.println("The specified name is longer than 20 characters \n" +
		                       "Using truncated value: " + name);
		}
		this.name = name;
	}

	/**
	 * @return the voltage
	 */
	public double getVoltage() {
		return this.voltage;
	}

	/**
	 * @param voltage the voltage to set
	 */
	public void setVoltage(double voltage) {
		if( voltage >  this.maxVoltage || voltage < minVoltage) {
			System.out.println("Specified voltage should be between " + minVoltage +
			                   " and " + maxVoltage + "\n" + this.name +
			                   " setting of " + this.voltage + " volts not changed to "
			                   + voltage);
			return;
		}
		this.voltage = voltage;
	}

	public void displayMessage(String str) {
		// display result in message box
		System.out.println(str);
		}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "VoltageSupply " + this.name + " @ " + this.voltage + " volts";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		VoltageSupply supply1 = new VoltageSupply();  // using default constructor		
		supply1.displayMessage(supply1.toString());   // display supply1
		supply1.setVoltage(450.0);                    // set voltage of supply1
		supply1.displayMessage(supply1.toString());   // display supply1

		VoltageSupply supply2 = new VoltageSupply("Supply 2", 300.0);
		supply2.displayMessage(supply2.toString());   // display supply2
		supply2.setVoltage(90.0);                     // set supply2 voltage less than minVoltage
		supply2.displayMessage(supply2.toString());   // display supply2
	}
}
