package com.amarjefferson.codeabout.java.gui.swing;

import java.awt.EventQueue;
import com.amarjefferson.codeabout.java.mvc.controller.TcController;
import com.amarjefferson.codeabout.java.mvc.model.TcModel;
import com.amarjefferson.codeabout.java.mvc.views.TcViewMdi;

/**
 * File Name: TemperatureConverterMdi.java
 *
 * Package: com.amarjefferson.codeabout.java.mvc
 * Class: TemperatureConverterMdi
 *
 */
public class TemperatureConverterMdi {
	/**
	 * 
	 */
	public TemperatureConverterMdi() {
		new TcController(new TcModel(), new TcViewMdi());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater( () -> new TemperatureConverterMdi() );
	}

}
