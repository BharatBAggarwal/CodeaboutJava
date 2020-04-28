/**
 * 
 */
package com.amarjefferson.codeabout.java.mvc.views.panels;

import java.awt.event.ActionListener;

/**
 * 
 * Project: JavaExamples
 * File Name: ITcConversionPanel.java
 *
 * Package: com.amarjefferson.codeabout.java.mvc
 * Class: ITcConversionPanel
 * Created on: Jun 29, 2016
 *
 * @author Bharat Aggarwal
 * @version 1.0
 *
 * Copyright 2016, Amar Jefferson Consulting
 * All Rights Reserved
 *
 */
public interface ITcConversionPanel {
	void addListener(ActionListener aListener);
	void setConversion(String choice);
}
