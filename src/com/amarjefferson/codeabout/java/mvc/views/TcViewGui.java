package com.amarjefferson.codeabout.java.mvc.views;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import com.amarjefferson.codeabout.java.classes.samples.ParseStringFI;
import com.amarjefferson.codeabout.java.mvc.data.TcConstants;
import com.amarjefferson.codeabout.java.mvc.data.TemperatureConversionData;
import com.amarjefferson.codeabout.java.mvc.views.panels.ITcTemperatureInputPanel;
import com.amarjefferson.codeabout.java.mvc.views.panels.ITcToolbarPanel;
import com.amarjefferson.codeabout.java.mvc.views.panels.TcConversionPanel;
import com.amarjefferson.codeabout.java.mvc.views.panels.TcTemperatureFieldsPanel;
import com.amarjefferson.codeabout.java.mvc.views.panels.TcToolbarPanel;

/**
 * File Name: TcViewGui.java
 *
 * Package: com.amarjefferson.codeabout.java.gui.swing
 * Class: TcViewGui
 *
 */
public class TcViewGui extends JFrame implements ITcView {
	private static final long serialVersionUID = 1L;

	private static final int DEFAULT_WIDTH = 450;
	private static final int DEFAULT_HEIGHT = 450;

	private ITcTemperatureInputPanel temperaturePanel;
	private ITcToolbarPanel toolBar;

	/**
	 * 
	 */
	public TcViewGui(boolean displayOnly) {
		this.setTitle("Temperature Converter");
		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());

		java.net.URL imageURL = getClass().getResource("/icons/settings_16.png");
		ImageIcon appIcon = createImageIcon(imageURL, "Converter");
		this.setIconImage(appIcon.getImage());

		// create component panels
		TcConversionPanel conversionPanel = new TcConversionPanel(TcConstants.TO_CELSIUS,
				                                TcConstants.TO_FAHRENHEIT, displayOnly);
		this.temperaturePanel = new TcTemperatureFieldsPanel(conversionPanel, displayOnly);
		this.toolBar = new TcToolbarPanel();

		// add component panels to frame to frame
		this.add((JToolBar)this.toolBar, BorderLayout.NORTH);
		this.add((JPanel)this.temperaturePanel, BorderLayout.CENTER);

		// make main window visible
		if(displayOnly) {
			((JToolBar)this.toolBar).setVisible(false);
		}

		setVisibility(true);
	}


	@Override
	public void setTemperatureDisplayValues(TemperatureConversionData tcData, boolean clear) {
		this.temperaturePanel.setAllFieldsLabels(tcData, clear);		
	}

	@Override
	public void displayTemperature(TemperatureConversionData tcData) {
		this.temperaturePanel.setAllFieldsLabels(tcData, false);
	}

	@Override
	public void addConversionPanelListener(ActionListener anAction) {
		this.temperaturePanel.addConversionListener(anAction);
	}


	@Override
	public void addToolbarButtonAction(Action anAction) {
		this.toolBar.setButtonAction(anAction);
	}

	@Override
	public String getInput() {
		return this.temperaturePanel.getInput();
	}

	/* (non-Javadoc)
	 * @see com.amarjefferson.codeabout.java.mvc.views.ITcView#setInput(double)
	 */
	@Override
	public void setInput(double inputValue) {
		this.temperaturePanel.setInput(inputValue);
	}

	/* (non-Javadoc)
	 * @see com.amarjefferson.codeabout.java.mvc.views.ITcView#clearOutputDisplay()
	 */
	@Override
	public void clearOutputDisplay() {
		this.temperaturePanel.clearOutput();
	}

	/* (non-Javadoc)
	 * @see com.amarjefferson.codeabout.java.mvc.views.ITcView#setVisibility(boolean)
	 */
	@Override
	public void setVisibility(boolean visibility) {
		this.setVisible(visibility);
	}

	@Override
	public void setConversionValue(String conversionString) {
		this.temperaturePanel.setConversion(conversionString);
	}

	// Create an ImageIcon from the path of an image file
	public ImageIcon createImageIcon(java.net.URL imgURL, String description) {
	//	java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
	            return new ImageIcon(imgURL, description);
			}
			else {            
			    return null;
			}
	}

}
