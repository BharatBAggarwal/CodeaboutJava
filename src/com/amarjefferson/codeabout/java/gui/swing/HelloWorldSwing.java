package com.amarjefferson.codeabout.java.gui.swing;

import java.awt.Color;
import javax.swing.*;        

/**
 * File Name: HelloWorldSwing.java
 *
 * Package: com.amarjefferson.codeabout.java.gui.swing
 * Class: HelloWorldSwing
 *
 */


public class HelloWorldSwing {

	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 200;


	/**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowMainWindow() {
        //Create and set up the window.
        JFrame frame = new JFrame("HelloWorld - Swing");
        frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add the "Hello World" label.
        JLabel label = new JLabel("Hello World!");
        frame.getContentPane().setBackground(new Color(240, 240, 240));
        frame.getContentPane().add(label);

        //Display the window.
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        javax.swing.SwingUtilities.invokeLater(() -> createAndShowMainWindow());
    }

}
