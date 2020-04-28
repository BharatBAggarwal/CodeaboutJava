/**
 * 
 */
package com.amarjefferson.codeabout.java.mvc.views.panels;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.amarjefferson.codeabout.java.mvc.data.TcConstants;

/**
 * 
 * Project: JavaExamples
 * File Name: TcConversionPanel.java
 *
 * Package: com.amarjefferson.codeabout.java.gui.swing
 * Class: TcConversionPanel
 * Created on: Aug 1, 2016
 *
 * @author Bharat Aggarwal
 * @version 1.0
 *
 * Copyright 2016, Amar Jefferson Consulting
 * All Rights Reserved
 *
 */
public class TcConversionPanel extends JPanel implements ITcConversionPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JRadioButton toFahrenheit;
	private JRadioButton toCelsius;
	private String cmdToCelsius;
	private String cmdToFahrenheit;

	/**
	 * 
	 */
	public TcConversionPanel(String cmdToCelcius, String cmdToFarenheit, boolean displayOnly) {
		this.cmdToCelsius = cmdToCelcius;
		this.cmdToFahrenheit = cmdToFarenheit;
		//Create the radio buttons
		toFahrenheit = new JRadioButton(this.cmdToFahrenheit);
		toFahrenheit.setSelected(true);
		toCelsius = new JRadioButton(this.cmdToCelsius);
		// group the radio buttons
		ButtonGroup group = new ButtonGroup();
		group.add(toFahrenheit);
		group.add(toCelsius);

		// create the panel
		setLayout(new FlowLayout());
		setBackground(new Color(240, 240, 240));
		setBorder(BorderFactory.createTitledBorder("Convert"));
		// add radio buttons to panel
		add(toFahrenheit);
		add(toCelsius);
		
		if(displayOnly) {
			toFahrenheit.setEnabled(false);
			toCelsius.setEnabled(false);
		}
	}

	// add radioButtons ActionListener
	@Override
	public void addListener(ActionListener aListener) {
		toFahrenheit.addActionListener(aListener);
		toCelsius.addActionListener(aListener);		
	}

	/* (non-Javadoc)
	 * @see com.amarjefferson.codeabout.java.mvc.ITcConversionPanel#setConversionChoice(java.lang.String)
	 */
	@Override
	public void setConversion(String choice) {
		if(choice.equals(TcConstants.TO_CELSIUS)) {
			toCelsius.setSelected(true);
		} else {
			toFahrenheit.setSelected(true);
		}
	}
}
