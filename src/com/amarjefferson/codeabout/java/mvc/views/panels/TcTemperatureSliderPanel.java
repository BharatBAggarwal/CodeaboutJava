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
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.amarjefferson.codeabout.java.mvc.data.TcConstants;
import com.amarjefferson.codeabout.java.mvc.data.TemperatureConversionData;

/**
 * 
 * Project: JavaExamples
 * File Name: TcTemperatureSliderPanel.java
 *
 * Package: com.amarjefferson.codeabout.java.mvc
 * Class: TcTemperatureSliderPanel
 * Created on: Jul 2, 2016
 *
 * @author Bharat Aggarwal
 * @version 1.0
 *
 * Copyright 2016, Amar Jefferson Consulting
 * All Rights Reserved
 *
 */
public class TcTemperatureSliderPanel extends JPanel implements ITcTemperatureInputPanel, ChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ITcConversionPanel conversionPanel;
	private JLabel lblInput;
	private JTextField txtInput;
	private JTextArea txtOutput;
	private JScrollPane scrollPane;
	private JSlider inputSlider;

	/**
	 * 
	 */
	public TcTemperatureSliderPanel(ITcConversionPanel aPanel) {
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
		// add Slider to row 2
        cmain.gridx = 0;
        cmain.gridy = 1;
        cmain.gridwidth = 1;
        cmain.insets = new Insets(5,5,5,5);
        cmain.fill = GridBagConstraints.HORIZONTAL;
        cmain.anchor = GridBagConstraints.NORTH;
        cmain.weightx = 1.0;
        cmain.weighty = 0.0;
		this.inputSlider = new JSlider(JSlider.HORIZONTAL,
				                       (int)TcConstants.MIN_TEMPERATURE,
				                       (int)TcConstants.MAX_TEMPERATURE * 10,
				                       (int)TcConstants.MIN_TEMPERATURE);
		this.inputSlider.setBackground(new Color(250, 250, 250));
		this.inputSlider.addChangeListener(this);
		//Turn on labels at major tick marks.
		this.inputSlider.setMajorTickSpacing(200);
		this.inputSlider.setMinorTickSpacing(100);
		this.inputSlider.setPaintTicks(true);
//		this.inputSlider.setPaintLabels(true);
//		this.inputSlider.setBorder(BorderFactory.createTitledBorder("Set Temperature"));
        this.inputSlider.setPreferredSize(new Dimension(150,40));
	    add(this.inputSlider, cmain);	    
	    // add JLabel
        this.txtInput = new JTextField();
        this.txtInput.setBackground(new Color(250, 250, 250));
        this.txtInput.setFocusable(false);
        this.txtInput.setEditable(false);
        this.txtInput.setPreferredSize(new Dimension(60,25));
        cmain.gridx = 1;
        cmain.gridy = 1;
        cmain.weightx = 0.0;
        cmain.anchor = GridBagConstraints.CENTER;
        cmain.fill = GridBagConstraints.VERTICAL;
        add(this.txtInput,cmain);

		// add conversion panel to row 3
		cmain.gridx = 0;
		cmain.gridy = 2;
		cmain.gridwidth = 2;
		cmain.weightx = 1.0;
		cmain.weighty = 0.0;
		cmain.anchor = GridBagConstraints.NORTH;
		cmain.fill = GridBagConstraints.HORIZONTAL;
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

	
	/* (non-Javadoc)
	 * @see javax.swing.event.ChangeListener#stateChanged(javax.swing.event.ChangeEvent)
	 */
	@Override
	public void stateChanged(ChangeEvent event) {
	    JSlider source = (JSlider)event.getSource();
	    if (!source.getValueIsAdjusting()) {
	        double temperature = (int)source.getValue()/10.0;
	        String tempStr = String.format(TcConstants.FORMAT, temperature).trim();
	        this.txtInput.setText(tempStr);
	    }
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
		this.inputSlider.setValue((int)(temperature * 10));
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


	/* (non-Javadoc)
	 * @see com.amarjefferson.codeabout.java.mvc.views.panels.ITcTemperatureInputPanel#setAllFieldsLabels(com.amarjefferson.codeabout.java.events.TemperatureConversionData, boolean)
	 */
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
	public void addConversionListener(ActionListener alistener) {
		this.conversionPanel.addListener(alistener);
	}


	/* (non-Javadoc)
	 * @see com.amarjefferson.codeabout.java.mvc.ITcMainPanel#setConversionChoice(java.lang.String)
	 */
	@Override
	public void setConversion(String choice) {
		conversionPanel.setConversion(choice);
	}

}
