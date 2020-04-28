package com.amarjefferson.codeabout.java.classes.chair.chairInterfaces;

/**
 * File Name: EasyRecline.java
 *
 * Package: com.amarjefferson.codeabout.java.classes.chair.chairInterfaces
 * Class: EasyRecline
 *
 */
public class EasyRecline implements IRecliningMechanism {
	
	/**
	 * @param
	 */
	public EasyRecline() {
		this(IRecliningMechanism.MECHANISM_UPRIGHT);
	}
	
	/**
	 * @param reclineAngle
	 */
	public EasyRecline(int reclineAngle) {
		this.reclineAngle = reclineAngle;
	}

	@Override
	public void setReclineAngle(int anAngle) {  // set recline angle
    	this.reclineAngle = anAngle;
    }

	@Override
	public int reclineAngle() {                 // get recline angle
    	return this.reclineAngle;
    }

	// instance variables
	private int reclineAngle;
}
