/**
 * 
 */
package com.amarjefferson.codeabout.java.mvc.views.panels;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.border.EtchedBorder;

/**
 * 
 * Project: JavaExamples
 * File Name: TcToolbarPanel.java
 *
 * Package: com.amarjefferson.codeabout.java.gui.swing
 * Class: TcToolbarPanel
 * Created on: Aug 1, 2016
 *
 * @author Bharat Aggarwal
 * @version 1.0
 *
 * Copyright 2016, Amar Jefferson Consulting
 * All Rights Reserved
 *
 */
public class TcToolbarPanel extends JToolBar  implements ITcToolbarPanel {
	private static final long serialVersionUID = 1L;

	private JButton btnConvert;

	/**
	 * 
	 */
	public TcToolbarPanel() {
		setLayout(new FlowLayout());
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		setBackground(new Color(240, 240, 240));

		addSeparator();
		// create button for toolbar
		btnConvert = new JButton("Default");
		btnConvert.setFocusable(false);
		add(this.btnConvert);
		addSeparator();
	}

	// change button Action
	@Override
	public void setButtonAction(Action anAction) {
		btnConvert.setAction(anAction);
	}
}
