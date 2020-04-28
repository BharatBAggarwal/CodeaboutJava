package com.amarjefferson.codeabout.java.classes.chair.chairReclining;

/**
 * File Name: Controls.java
 *
 * Package: com.amarjefferson.codeabout.java.classes.chair.chairReclining
 * Class: Controls
 *
 */
public class Controls {
	
	public Controls(int reclineAngle, RecliningMechanism aMechanism ) {
		this.aMechanism = aMechanism;
		this.reclineAngle = reclineAngle;
	}

	public void reclineChair(int anAngle) { // set recline angle
    	this.reclineAngle = anAngle;
		// operate the mechanism to set it to the same angle
		this.aMechanism.setReclineAngle(anAngle);
    }
    
    public int reclineAngle() {                 // get recline angle
    	return this.reclineAngle;
    }
    
    public void chairUpright() {           // set seat back in upright position
    	this.reclineAngle = 0;
		this.aMechanism.reset();
    }

	// instance variables
	private int reclineAngle;
	private RecliningMechanism aMechanism;
}
