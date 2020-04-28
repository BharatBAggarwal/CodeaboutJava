
package com.amarjefferson.codeabout.java.mvc.views;

import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.amarjefferson.codeabout.java.classes.samples.ParseStringFI;
import com.amarjefferson.codeabout.java.mvc.data.TcConstants;
import com.amarjefferson.codeabout.java.mvc.data.TemperatureConversionData;
import com.amarjefferson.codeabout.java.mvc.views.panels.ITcConversionPanel;
import com.amarjefferson.codeabout.java.mvc.views.panels.ITcTemperatureInputPanel;
import com.amarjefferson.codeabout.java.mvc.views.panels.TcConversionPanel;
import com.amarjefferson.codeabout.java.mvc.views.panels.TcTemperatureFieldsPanel;
import com.amarjefferson.codeabout.java.mvc.views.panels.TcTemperatureSliderPanel;
import com.amarjefferson.codeabout.java.mvc.views.panels.TcToolbarPanel;


/**
 * File Name: TcViewMdi.java
 *
 * Package: com.amarjefferson.codeabout.java.mvc
 * Class: TcViewMdi
 *
 */
public class TcViewMdi extends JFrame implements ITcView {
	private static final long serialVersionUID = 1L;

	private static final int DEFAULT_WIDTH = 600;
	private static final int DEFAULT_HEIGHT = 500;

	private java.net.URL imageURL;
	private ImageIcon appIcon;

	private ITcConversionPanel conversionPanel1;
	private ITcConversionPanel conversionPanel2;
	private ITcTemperatureInputPanel mainPanel;
	private List<ITcTemperatureInputPanel> mainPanels = new ArrayList<ITcTemperatureInputPanel>();
	
	private JDesktopPane desktop;
	private TcViewMdiFrames frame;
	private List<TcViewMdiFrames> internalViews = new ArrayList<TcViewMdiFrames>();

	/**
	 * @throws HeadlessException
	 */
	public TcViewMdi() {
		setTitle("Temperature Converter");
		imageURL = getClass().getResource("/images/CandF.jpeg");
		appIcon = createImageIcon(imageURL, "Converter");
		setIconImage(this.appIcon.getImage());
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        desktop = new JDesktopPane();
        add(desktop);

        // create all available mainFrames
		// setup conversion panel
		conversionPanel1 = new TcConversionPanel(TcConstants.TO_CELSIUS, TcConstants.TO_FAHRENHEIT, false);
		mainPanel = new TcTemperatureFieldsPanel(conversionPanel1, false);
		mainPanel.resetInput(TcConstants.CELSIUS);
		mainPanels.add(mainPanel);
		
		// setup conversion panel
		conversionPanel2 = new TcConversionPanel(TcConstants.TO_CELSIUS, TcConstants.TO_FAHRENHEIT, false);
		mainPanel = new TcTemperatureSliderPanel(conversionPanel2);
		mainPanel.resetInput(TcConstants.CELSIUS);
		mainPanels.add(mainPanel);
		
		createInternalFrames();
	}

	public void createInternalFrames() {
		int layer = 0;
		TcToolbarPanel toolbar;

		for(ITcTemperatureInputPanel aPanel : mainPanels) {
			// create toolbar
			toolbar = new TcToolbarPanel();
			// create main panels
			frame = new TcViewMdiFrames(toolbar, (JPanel)aPanel);
	        desktop.add(frame, ++layer);
	        internalViews.add(frame);
		}
	}

	// get input String
	@Override
	public String getInput() {
		TcViewMdiFrames frame = (TcViewMdiFrames)desktop.getSelectedFrame();
		return frame.getInput();
	}

	// set visibility
	@Override
	public void setVisibility(boolean visibility) {
		this.setVisible(visibility);
	}

	/* (non-Javadoc)
	 * @see com.amarjefferson.codeabout.java.mvc.ITcView#setConversionActionListener(java.awt.event.ActionListener)
	 */
	@Override
	public void addConversionPanelListener(ActionListener aListener) {
		for(TcViewMdiFrames aView : internalViews) {
			aView.addConversionPanelListener(aListener);
		}
	}

	/* (non-Javadoc)
	 * @see com.amarjefferson.codeabout.java.mvc.ITcView#setConvertButtonAction(javax.swing.Action)
	 */
	@Override
	public void addToolbarButtonAction(Action anAction) {
		for(TcViewMdiFrames aView : internalViews) {
			aView.addToolbarButtonAction(anAction);
		}
	}

	/* (non-Javadoc)
	 * @see com.amarjefferson.codeabout.java.mvc.ITcView#setInput(double)
	 */
	@Override
	public void setInput(double inputValue) {
		for(TcViewMdiFrames aView : internalViews) {
			aView.setInput(inputValue);
		}
	}

	/* (non-Javadoc)
	 * @see com.amarjefferson.codeabout.java.mvc.ITcView#clearOutputDisplay()
	 */
	@Override
	public void clearOutputDisplay() {
		for(TcViewMdiFrames aView : internalViews) {
			aView.clearOutputDisplay();
		}
	}

	/* (non-Javadoc)
	 * @see com.amarjefferson.codeabout.java.mvc.ITcView#setConversionChoice(java.lang.String)
	 */
	@Override
	public void setConversionValue(String choice) {
		for(TcViewMdiFrames aView : internalViews) {
			aView.setConversionValue(choice);
		}
	}

	@Override
	public void setTemperatureDisplayValues(TemperatureConversionData aModel, boolean clear) {
		for(TcViewMdiFrames aView : internalViews) {
			aView.setTemperatureDisplayValues(aModel, clear);
		}
	}

	@Override
	public void displayTemperature(TemperatureConversionData aModel) {
		for(TcViewMdiFrames aView : internalViews) {
			aView.displayTemperature(aModel);
		}
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
