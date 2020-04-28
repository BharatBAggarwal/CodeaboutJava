
package com.amarjefferson.codeabout.java.gui.swing;

import java.awt.EventQueue;
import com.amarjefferson.codeabout.java.mvc.controller.TcController;
import com.amarjefferson.codeabout.java.mvc.model.TcModel;
import com.amarjefferson.codeabout.java.mvc.views.TcViewGui;

/**
 * File Name: TempertureDisplayGUI.java
 *
 * Package: com.amarjefferson.codeabout.gui.swing
 * Class: TemperatureConverterGui
 *
 */
public class TemperatureConverterGui {
	/**
	 * 
	 */
	public TemperatureConverterGui(boolean displayOnly) {
			new TcController(new TcModel(),
					            new TcViewGui(displayOnly));
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater( () -> new TemperatureConverterGui(false) );
	}

}
