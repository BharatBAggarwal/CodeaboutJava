package com.amarjefferson.codeabout.java.mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import com.amarjefferson.codeabout.java.classes.samples.ParseStringFI;
import com.amarjefferson.codeabout.java.mvc.data.TcConstants;
import com.amarjefferson.codeabout.java.mvc.data.TemperatureConversionData;
import com.amarjefferson.codeabout.java.mvc.model.ITcModel;
import com.amarjefferson.codeabout.java.mvc.model.TcModel;
import com.amarjefferson.codeabout.java.mvc.views.ITcView;

/**
 * File Name: TcController.java
 *
 * Package: com.amarjefferson.codeabout.java.gui.swing
 * Class: TcController
 *
 */
public class TcController implements ActionListener, PropertyChangeListener {
	private java.net.URL imageURL;
	private ImageIcon iconCtoF;
	private Action actionCtoF;
	private ImageIcon iconFtoC;
	private Action actionFtoC;

	private ITcView tcView;
	private ITcModel tcModel;
	private TemperatureConversionData tcd;
	
	/**
	 * 
	 */
	public TcController(ITcModel aModel, ITcView aView) {
		// setup toolbar button actions
		this.imageURL = getClass().getResource("/icons/red-ball.gif");
		this.iconCtoF = createImageIcon(imageURL, TcConstants.TOOLTIP_CF);
		this.actionCtoF = new ConvertAction(TcConstants.TO_FAHRENHEIT, this.iconCtoF, TcConstants.TOOLTIP_CF, Integer.valueOf(KeyEvent.VK_F));

		this.imageURL = getClass().getResource("/icons/yellow-ball.gif");
		this.iconFtoC = createImageIcon(imageURL, TcConstants.TOOLTIP_FC);
		this.actionFtoC = new ConvertAction(TcConstants.TO_CELSIUS, this.iconFtoC, TcConstants.TOOLTIP_FC, Integer.valueOf(KeyEvent.VK_C));

		// setup startup values
		this.tcModel = aModel;
		this.tcd = tcModel.getResults();

		this.tcView = aView;
		this.tcView.setTemperatureDisplayValues(this.tcd, true);
		this.tcView.setVisibility(true);
		this.tcView.addConversionPanelListener(this);
		if(tcd.getConvertOp().conversionAsString().equals(TcConstants.TO_FAHRENHEIT)) {
			this.tcView.addToolbarButtonAction(this.actionCtoF);
		} else {
			this.tcView.addToolbarButtonAction(this.actionFtoC);
		}

		this.tcModel.addPropertyChangeListener(this);
}


	// define Action for convert button
	public class ConvertAction extends AbstractAction
	{
		private static final long serialVersionUID = 1L;

		public ConvertAction(String name, ImageIcon icon, String tooltip, Integer mnemonic) {
			super(name, icon);
			putValue(Action.NAME, name);
			putValue(Action.SMALL_ICON, icon);
			putValue(Action.SHORT_DESCRIPTION, tooltip);
			putValue(MNEMONIC_KEY, mnemonic);
		}

		public void actionPerformed(ActionEvent event) {
			// set conversion value
			String cmd = event.getActionCommand();
			if(cmd.equals(TcConstants.TO_FAHRENHEIT))
				tcd = new TemperatureConversionData(TcConstants.conversion.toFahrenheit);
			else
				tcd = new TemperatureConversionData(TcConstants.conversion.toCelsius);

			// set input temperature
			Double input = ParseStringFI.strToDouble(tcView.getInput());
			if(input.isNaN())
				input = TcConstants.MIN_TEMPERATURE;
			tcd.setInputValue(input);

			// perform conversion
			tcModel.convert(tcd);
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(TcConstants.TO_FAHRENHEIT)) {
			this.tcd.setConvertOp(TcConstants.conversion.toFahrenheit);
			this.tcView.setTemperatureDisplayValues(tcd, true);
			this.tcView.addToolbarButtonAction(this.actionCtoF);
		}
		else {
			this.tcd.setConvertOp(TcConstants.conversion.toCelsius);
			this.tcView.setTemperatureDisplayValues(tcd, true);
			this.tcView.addToolbarButtonAction(this.actionFtoC);
		}					
	}

	/* (non-Javadoc)
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// retrieve property values from the event object
		// String convertop = (String)evt.getPropertyName();
		// double inputValue = Double.parseDouble((String)evt.getOldValue());
		// double outputValue = Double.parseDouble((String)evt.getNewValue());

		tcModel = ((TcModel)evt.getSource());
		tcd = tcModel.getResults();
		// display values in gui
		tcView.displayTemperature(tcd);
	}

	// Create an ImageIcon from the path of an image file
	public static ImageIcon createImageIcon(java.net.URL imgURL, String description) {
	//	java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
	            return new ImageIcon(imgURL, description);
			}
			else {            
			    return null;
			}
	}
}
