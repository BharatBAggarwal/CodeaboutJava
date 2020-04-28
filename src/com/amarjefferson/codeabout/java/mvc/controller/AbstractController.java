package com.amarjefferson.codeabout.java.mvc.controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import com.amarjefferson.codeabout.java.mvc.model.ITcModel;
import com.amarjefferson.codeabout.java.mvc.views.ITcView;

/**
 * File Name: AbstractController.java
 *
 * Package: com.amarjefferson.codeabout.java.mvc.controller
 * Class: AbstractController
 *
 */
public abstract class AbstractController implements PropertyChangeListener {

	private ArrayList<ITcModel> models;
	private ArrayList<ITcView> views;

	/**
	 * 
	 */
	public AbstractController() {
		models = new ArrayList<>();
		views = new ArrayList<>();
	}

	public void addModel(ITcModel aModel) {
		models.add(aModel);
		aModel.addPropertyChangeListener(this);
	}

	public void removeModel(ITcModel aModel) {
		models.remove(aModel);
		aModel.removePropertyChangeListener(this);
	}

	public void addView(ITcView aView) {
		views.add(aView);
	}

	public void removeView(ITcView aView) {
		views.remove(aView);
	}

	/* (non-Javadoc)
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
	}

}
