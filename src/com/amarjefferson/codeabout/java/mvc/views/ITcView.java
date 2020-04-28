package com.amarjefferson.codeabout.java.mvc.views;

import java.awt.event.ActionListener;
import javax.swing.Action;
import com.amarjefferson.codeabout.java.mvc.data.TemperatureConversionData;

/**
 * File Name: ITcView.java
 *
 * Package: com.amarjefferson.codeabout.java.mvc
 * Class: ITcView
 *
 */
public interface ITcView {
	void addConversionPanelListener(ActionListener aListener); // Set ActionListener for conversion RadioButtons
	void addToolbarButtonAction(Action anAction);  // Set action for convert action
	String getInput();                             // The raw string input in the TextField
	void setInput(double inputValue);              // The raw string input in the TextField
	void clearOutputDisplay();                     // Clears output TextArea
	void setVisibility(boolean visibility);        // Sets the visibility of the view
	void setConversionValue(String choice);
	void setTemperatureDisplayValues(TemperatureConversionData aModel, boolean clear);
	void displayTemperature(TemperatureConversionData aModel);
}
