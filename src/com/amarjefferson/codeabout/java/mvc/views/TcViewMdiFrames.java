package com.amarjefferson.codeabout.java.mvc.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.*;
import com.amarjefferson.codeabout.java.mvc.data.TemperatureConversionData;
import com.amarjefferson.codeabout.java.mvc.views.panels.ITcTemperatureInputPanel;
import com.amarjefferson.codeabout.java.mvc.views.panels.ITcToolbarPanel;

public class TcViewMdiFrames extends JInternalFrame implements ITcView {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 400;
    
    private static int frames = 0;
    private ITcTemperatureInputPanel mainPanel;
    private ITcToolbarPanel toolbar;

    /**
     * TcViewMdiFrames Constructor
     */
    public TcViewMdiFrames(JToolBar toolbar, JPanel mainPanel) {
    	super("View " + ++frames, true, false, true, true);
    	this.mainPanel = (ITcTemperatureInputPanel)mainPanel;
    	this.toolbar = (ITcToolbarPanel)toolbar;
		// set Layout and background color
        getContentPane().setLayout(new BorderLayout());
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLocation(frames*20, frames*20);
		setBackground(new Color(240, 240, 240));

		add(toolbar, BorderLayout.NORTH);
		add(mainPanel, BorderLayout.CENTER);
        show();
    }


	/* (non-Javadoc)
	 * @see com.amarjefferson.codeabout.java.mvc.ITcView#setConversionActionListener(java.awt.event.ActionListener)
	 */
	@Override
	public void addConversionPanelListener(ActionListener aListener) {
		this.mainPanel.addConversionListener(aListener);
	}

	/* (non-Javadoc)
	 * @see com.amarjefferson.codeabout.java.mvc.ITcView#setConvertButtonAction(javax.swing.Action)
	 */
	@Override
	public void addToolbarButtonAction(Action anAction) {
		this.toolbar.setButtonAction(anAction);
	}

	/* (non-Javadoc)
	 * @see com.amarjefferson.codeabout.java.mvc.ITcView#getInput()
	 */
	@Override
	public String getInput() {
		return this.mainPanel.getInput();
	}

	/* (non-Javadoc)
	 * @see com.amarjefferson.codeabout.java.mvc.ITcView#setInput(double)
	 */
	@Override
	public void setInput(double inputValue) {
		this.mainPanel.setInput(inputValue);
	}

	/* (non-Javadoc)
	 * @see com.amarjefferson.codeabout.java.mvc.ITcView#clearOutputDisplay()
	 */
	@Override
	public void clearOutputDisplay() {
		this.mainPanel.clearOutput();
	}

	/* (non-Javadoc)
	 * @see com.amarjefferson.codeabout.java.mvc.ITcView#setVisibility(boolean)
	 */
	@Override
	public void setVisibility(boolean visibility) {
		this.setVisible(visibility);
	}

	/* (non-Javadoc)
	 * @see com.amarjefferson.codeabout.java.mvc.ITcView#setConversionChoice(java.lang.String)
	 */
	@Override
	public void setConversionValue(String choice) {
		this.mainPanel.setConversion(choice);
	}

	@Override
	public void setTemperatureDisplayValues(TemperatureConversionData aModel, boolean clear) {
		this.mainPanel.setAllFieldsLabels(aModel, clear);		
	}

	@Override
	public void displayTemperature(TemperatureConversionData aModel) {
		this.mainPanel.setAllFieldsLabels(aModel, false);
	}

}
