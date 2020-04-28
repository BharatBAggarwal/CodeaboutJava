package com.amarjefferson.codeabout.java.mvc.data;

/**
 * File Name: TemperatureConversionData.java
 *
 * Package: com.amarjefferson.codeabout.java.events
 * Class: TemperatureConversionData
 *
 */
public class TemperatureConversionData {

	private Double inputValue;
	private Double outputValue;
	private TcConstants.conversion convertOp;
	
	/**
	 * 
	 */
	public TemperatureConversionData(TcConstants.conversion convertOp) {
		setConvertOp(convertOp);
		this.inputValue = Double.NaN;
		this.outputValue = Double.NaN;
	}

	/**
	 * @return the convertOp
	 */
	public TcConstants.conversion getConvertOp() {
		return convertOp;
	}

	/**
	 * @param convertOp the convertOp to set
	 */
	public void setConvertOp(TcConstants.conversion convertOp) {
		this.convertOp = convertOp;
	}

	/**
	 * @return the inputValue
	 */
	public Double getInputValue() {
		return inputValue;
	}

	/**
	 * @param inputValue the inputValue to set
	 */
	public void setInputValue(Double inputValue) {
		this.inputValue = inputValue;
	}

	/**
	 * @return the outputValue
	 */
	public Double getOutputValue() {
		return outputValue;
	}

	/**
	 * @param outputValue the outputValue to set
	 */
	public void setOutputValue(Double outputValue) {
		this.outputValue = outputValue;
	}

	/**
	 * @return the inputValue
	 */
	public String inputAsString() {
		return String.format(TcConstants.FORMAT, this.inputValue).trim();
	}


	/**
	 * @return the outputValue
	 */
	public String outputAsString() {
		return String.format(TcConstants.FORMAT, this.outputValue).trim();
	}

	/**
	 * @return the inputLabel
	 */
	public String getInputLabel() {
		return this.convertOp.inputFieldLabel();
	}

	/**
	 * @return the inputUnitLabel
	 */
	public String getInputUnitLabel() {
		return convertOp.inputUnitLabel();
	}

	/**
	 * @return the outputLabel
	 */
	public String getOutputLabel() {
		return convertOp.outputFieldLabel();
	}

	/**
	 * @return the outputUnitLabel
	 */
	public String getOutputUnitLabel() {
		return convertOp.outputUnitLabel();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String result = "[" + getConvertOp().conversionAsString() + "]  " +
				inputAsString() + getInputUnitLabel() + " to " +
				outputAsString() + getOutputUnitLabel();
		return result;
	}
}
