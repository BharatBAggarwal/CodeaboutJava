
package com.amarjefferson.codeabout.java.mvc.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * File Name: AbstractModel.java
 *
 * Package: com.amarjefferson.codeabout.java.mvc.model
 * Class: AbstractModel
 *
 */
public abstract class AbstractModel {

	protected final PropertyChangeSupport propChange;

	public AbstractModel() {
		propChange = new PropertyChangeSupport(this);
	}

	// method to register listeners
	public void addPropertyChangeListener(PropertyChangeListener newListener) {
		 this.propChange.addPropertyChangeListener(newListener);
	}

	// method to deregister listeners
	public void removePropertyChangeListener(PropertyChangeListener aListener) {
		 this.propChange.removePropertyChangeListener(aListener);
	}

	// method to fire property change
	public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
		 this.propChange.firePropertyChange(propertyName, oldValue, newValue);
	}
}
