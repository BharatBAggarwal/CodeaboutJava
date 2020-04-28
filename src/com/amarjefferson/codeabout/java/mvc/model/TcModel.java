package com.amarjefferson.codeabout.java.mvc.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import com.amarjefferson.codeabout.java.mvc.data.TcConstants;
import com.amarjefferson.codeabout.java.mvc.data.TemperatureConversionData;

/**
 * File Name: TcModel.java
 *
 * Package: com.amarjefferson.codeabout.java.events
 * Class: TcModel
 *
 */
public class TcModel implements ITcModel {

	private final PropertyChangeSupport propChange;
	private TemperatureConversionData tcd;

	/**
	 * 
	 */
	public TcModel() {
		propChange = new PropertyChangeSupport(this);
		tcd = new TemperatureConversionData(TcConstants.conversion.toFahrenheit);
		convert(tcd);
	}

	/**
	 * 
	 */

	/* (non-Javadoc)
	 * @see com.amarjefferson.codeabout.java.mvc.model.ITcModel#convert(com.amarjefferson.codeabout.java.mvc.data.TemperatureConversionData)
	 */
	@Override
	public void convert(TemperatureConversionData tcData) {
		double outputValue;
		tcd = tcData;

		if(tcd.getConvertOp().equals(TcConstants.conversion.toFahrenheit))
			outputValue = tcd.getInputValue() * 1.8 + 32.0;
		else
			outputValue = (tcd.getInputValue() - 32.0) / 1.8;
		
		tcd.setOutputValue(outputValue);
		firePropertyChange(tcd.getConvertOp().conversionAsString(),
				           tcd.inputAsString(), tcd.outputAsString());
	}

	/**
	 * @return the inputValue
	 */
	@Override
	public TemperatureConversionData getResults() {
		return tcd;
	}


	@Override
	public String toString() {
		return tcd.toString();
	}


	// method to register listeners
	@Override
	public void addPropertyChangeListener(PropertyChangeListener newListener) {
		 this.propChange.addPropertyChangeListener(newListener);
	}

	// method to deregister listeners
	@Override
	public void removePropertyChangeListener(PropertyChangeListener aListener) {
		 this.propChange.removePropertyChangeListener(aListener);
	}

	// method to fire property change
	@Override
	public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
		 this.propChange.firePropertyChange(propertyName, oldValue, newValue);
	}

}
