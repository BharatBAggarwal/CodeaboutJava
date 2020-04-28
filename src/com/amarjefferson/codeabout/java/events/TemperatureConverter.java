package com.amarjefferson.codeabout.java.events;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import com.amarjefferson.codeabout.java.mvc.data.TemperatureConversionData;
import com.amarjefferson.codeabout.java.mvc.model.TcModel;
import com.amarjefferson.codeabout.java.mvc.views.TcViewGui;

/**
 * File Name: TemperatureConverter.java
 *
 * Package: com.amarjefferson.codeabout.java.events
 * Class: TemperatureConverter
 *
 */
public class TemperatureConverter implements PropertyChangeListener {

	TcModel tcModel;
	TemperatureConversionData tcd;
	TemperatureDisplay td;
	TcViewGui tdGui;

	public TemperatureConverter() {
		tdGui = new TcViewGui(true);
		td = new TemperatureDisplay();
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
		// display value on standard output
		td.displayTemperature(tcd);
		// display values in gui
		tdGui.displayTemperature(tcd);
	}


	/**
	 * @paramargs
	 */
	public static void main(String[] args) {
		TemperatureConversionData tcd = null;
		TemperatureInput tci = new TemperatureInput();
		TcModel tcModel = new TcModel();

		TemperatureConverter tc = new TemperatureConverter();
		tcModel.addPropertyChangeListener(tc);

		while(true) {
			tcd = tci.getUserInput();
			if(tcd == null)
				break;

			// perform conversion
			tcModel.convert(tcd);
		}
	}
}
