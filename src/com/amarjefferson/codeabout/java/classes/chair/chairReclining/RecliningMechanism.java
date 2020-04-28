package com.amarjefferson.codeabout.java.classes.chair.chairReclining;

/**
 * File Name: RecliningMechanism.java
 *
 * Package: com.amarjefferson.codeabout.java.classes.chair.chairReclining
 * Class: RecliningMechanism
 *
 */
public class RecliningMechanism {
	
	public RecliningMechanism() {
		this(0);
	}
	
	public RecliningMechanism(int reclineAngle) {
		this.reclineAngle = reclineAngle;
	}

	public void setReclineAngle(int anAngle) { // set recline angle
    	this.reclineAngle = anAngle;
    }

	public int reclineAngle() {                // get recline angle
    	return this.reclineAngle;
    }

	public void reset() {                      // reset to default
    	this.reclineAngle = 0;
    }

	// instance variables
	private int reclineAngle;
}
