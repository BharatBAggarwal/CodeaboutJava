package com.amarjefferson.codeabout.java.mvc.model;

import java.beans.PropertyChangeListener;
import com.amarjefferson.codeabout.java.mvc.data.TemperatureConversionData;

/**
 * File Name: ITcModel.java
 *
 * Package: com.amarjefferson.codeabout.java.mvc
 * Class: ITcModel
 *
 */
public interface ITcModel {
	void convert(TemperatureConversionData tcData);
	TemperatureConversionData getResults();

	void addPropertyChangeListener(PropertyChangeListener newListener);
	void removePropertyChangeListener(PropertyChangeListener aListener);
	void firePropertyChange(String propertyName, Object oldValue, Object newValue);
}
