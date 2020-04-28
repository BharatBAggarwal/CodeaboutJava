/**
 * 
 */
package com.amarjefferson.codeabout.java.mvc.views.panels;

import java.awt.event.ActionListener;

import com.amarjefferson.codeabout.java.mvc.data.TemperatureConversionData;

/**
 * 
 * Project: JavaExamples
 * File Name: ITcTemperatureInputPanel.java
 *
 * Package: com.amarjefferson.codeabout.java.mvc
 * Class: ITcTemperatureInputPanel
 * Created on: Jun 29, 2016
 *
 * @author Bharat Aggarwal
 * @version 1.0
 *
 * Copyright 2016, Amar Jefferson Consulting
 * All Rights Reserved
 *
 */
public interface ITcTemperatureInputPanel {
	void resetInput(String inputLabel);
	void setInput(double temperature);
	String getInput();
	void displayResult(String aResult);
	void clearOutput();
	public void setAllFieldsLabels(TemperatureConversionData aModel, boolean clear);
	void addConversionListener(ActionListener alistener);
	void setConversion(String choice);
}