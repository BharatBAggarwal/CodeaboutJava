/**
 * 
 */
package com.amarjefferson.codeabout.java.mvc.views.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.amarjefferson.codeabout.java.mvc.data.TcConstants;
import com.amarjefferson.codeabout.java.mvc.data.TemperatureConversionData;

/**
 * 
 * Project: JavaExamples
 * File Name: TcTemperatureFieldsPanel.java
 *
 * Package: com.amarjefferson.codeabout.java.gui.swing
 * Class: TcTemperatureFieldsPanel
 * Created on: Aug 1, 2016
 *
 * @author Bharat Aggarwal
 * @version 1.0
 *
 * Copyright 2016, Amar Jefferson Consulting
 * All Rights Reserved
 *
 */
public class TcTemperatureFieldsPanel extends JPanel implements ITcTemperatureInputPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ITcConversionPanel conversionPanel;
	private JLabel lblInput;
	private JTextField txtInput;
	private JTextArea txtOutput;
	private JScrollPane scrollPane;

	/**
	 * 
	 */
	public TcTemperatureFieldsPanel(ITcConversionPanel aPanel, boolean displayOnly) {
		this.conversionPanel = aPanel;
		// set Layout and background color
		setLayout(new GridBagLayout());
		setBackground(new Color(240, 240, 240));

		// add components to main panel
		GridBagConstraints cmain = new GridBagConstraints();
		cmain.insets = new Insets(5,5,5,5);
		cmain.fill = GridBagConstraints.HORIZONTAL;
		
		// add input Label to row 1
		this.lblInput = new JLabel("  ");
		cmain.gridx = 0;
		cmain.gridy = 0;
		cmain.gridwidth = 1;
		cmain.weightx = 0.0;
		cmain.weighty = 0.0;
		add(this.lblInput, cmain);
		// add input TextField to row 2
		this.txtInput = new JTextField();
		this.txtInput.setBackground(new Color(255, 255, 240));
		this.txtInput.setPreferredSize(new Dimension(75,25));
		if(displayOnly) {
			this.txtInput.setEditable(false);
			this.txtInput.setFocusable(false);
		}
		cmain.gridx = 0;
		cmain.gridy = 1;
		cmain.gridwidth = 2;
		cmain.weightx = 1.0;
		cmain.weighty = 0.0;
		add(this.txtInput,cmain);

		// add conversion panel to row 3
		cmain.gridx = 0;
		cmain.gridy = 2;
		cmain.gridwidth = 2;
		cmain.weightx = 1.0;
		cmain.weighty = 0.0;
		cmain.anchor = GridBagConstraints.NORTH;
		add((JPanel)aPanel, cmain);

		// add output TextArea to fourth row
		cmain.gridx = 0;
		cmain.gridy = 3;
		cmain.gridwidth = 2;
		cmain.weightx = 1.0;
		cmain.weighty = 1.0;
		cmain.anchor = GridBagConstraints.NORTH;
		cmain.fill = GridBagConstraints.BOTH;
		this.txtOutput = new JTextArea();
		this.txtOutput.setBackground(new Color(250, 250, 250));
		this.txtOutput.setFocusable(false);
		this.txtOutput.setEditable(false);
        this.scrollPane = new JScrollPane(txtOutput);
        this.scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.scrollPane.setPreferredSize(new Dimension(75,150));
		this.scrollPane.setBorder(BorderFactory.createTitledBorder("Conversion History"));
        add(this.scrollPane,cmain);
	}

	
	// reset main panel Labels
	@Override
	public void resetInput(String inputLabel) {
		this.lblInput.setText(inputLabel);
		setInput(TcConstants.MIN_TEMPERATURE);
	}

	// get input from TextField
	@Override
	public void setInput(double temperature) {
		this.txtInput.setText(Double.toString(temperature));
	}

	// get input from TextField
	@Override
	public String getInput() {
		return txtInput.getText();
	}


	// display result in TextArea
	@Override
	public void displayResult(String aResult) {
		txtOutput.setText(aResult+ "\n" + txtOutput.getText());
	}


	// clear output TextArea
	@Override
	public void clearOutput() {
		this.txtOutput.setText("");
	}


	// reset main panel Labels and TextFields
	@Override
	public void setAllFieldsLabels(TemperatureConversionData aModel, boolean clear) {
		if(clear) {
			resetInput(aModel.getInputLabel());
		} else {
			resetInput(aModel.getInputLabel());
			setInput(aModel.getInputValue());
			displayResult(aModel.toString());
		}

		setConversion(aModel.getConvertOp().conversionAsString());
	}


	/* (non-Javadoc)
	 * @see com.amarjefferson.codeabout.java.mvc.ITcMainPanel#conversionPanelListener(java.awt.event.ActionListener)
	 */
	@Override
	public void addConversionListener(ActionListener aListener) {
		conversionPanel.addListener(aListener);
	}


	/* (non-Javadoc)
	 * @see com.amarjefferson.codeabout.java.mvc.ITcMainPanel#setConversionChoice(java.lang.String)
	 */
	@Override
	public void setConversion(String choice) {
		conversionPanel.setConversion(choice);
	}

}
