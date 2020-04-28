package com.amarjefferson.codeabout.java.gui.javafx;

/**
 * File Name: CalculatorFxModel.java
 *
 * Package: com.amarjefferson.codeabout.java.gui.javafx
 * Class: CalculatorFxModel
 *
 */
public class CalculatorFxModel {
	private double number1;
	private double number2;
	private double result;
	private String symbol;
	private String alertHeader;


	/**
	 * 
	 */
	public CalculatorFxModel() {
		clear();
	}


	public void clear() {
		number1 = Double.MIN_VALUE;
		number2 = Double.MIN_VALUE;
		result = Double.MIN_VALUE;
		symbol = "";
		alertHeader = "";
	}


	// check input strings
	public boolean checkInput(String anInput, String field) {
		boolean isOk = true;
		double aNumber;

		if(anInput.isEmpty()) {
            alertHeader = "Field " + field + " is empty";
            return false;
		}

		try {
        	aNumber = Double.parseDouble(anInput);
        } catch (NullPointerException e) {
            alertHeader = "Field " + field + " is null";
        	isOk = false;
        } catch (NumberFormatException e) {
            alertHeader = "The input in " + field + " is not a valid number";
        	isOk = false;
        } 

		return isOk;
	}


	public CalculatorFxModel add() {
		symbol = "+";
		result = number1 + number2;
		return this;
	}
	

	public CalculatorFxModel subtract() {
		symbol = "-";
		result = number1 - number2;
		return this;
	}

	
	public CalculatorFxModel multiply() {
		symbol = "*";
		result = number1 * number2;
		return this;
	}

	
	public CalculatorFxModel divide() {
		symbol= "/";
		result = number1 / number2;
		return this;
	}

	/**
	 * @return the alertHeader
	 */
	public String getAlertHeader() {
		return alertHeader;
	}

	
	/**
	 * @return the number1
	 */
	public double getNumber1() {
		return number1;
	}


	/**
	 * @param number1 the number1 to set
	 */
	public void setNumber1(double number1) {
		this.number1 = number1;
	}


	/**
	 * @return the number2
	 */
	public double getNumber2() {
		return number2;
	}


	/**
	 * @param number2 the number2 to set
	 */
	public void setNumber2(double number2) {
		this.number2 = number2;
	}


	/**
	 * @return the result
	 */
	public double getResult() {
		return result;
	}


	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}


	public String resultAsString() {
	      return String.format("%15.2f", result).trim();
	}


	public String number1AsString() {
	      return String.format("%10.2f", number1).trim();
	}


	public String number2AsString() {
	      return String.format("%10.2f", number2).trim();
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String str = number1AsString() + " " + getSymbol() + " " +
	                 number2AsString() + " = " + resultAsString();
		return str;
	}

}
