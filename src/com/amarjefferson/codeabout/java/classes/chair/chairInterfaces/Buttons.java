package com.amarjefferson.codeabout.java.classes.chair.chairInterfaces;

/**
 * File Name: Buttons.java
 *
 * Package: com.amarjefferson.codeabout.java.classes.chair.chairInterfaces
 * Class: Buttons
 *
 */
public class Buttons implements IControls {
	
    /**
	 * @param reclineAngle
	 */
	public Buttons(int reclineAngle, IRecliningMechanism aRecliningMechanism) {
		this.recliningMechanism = aRecliningMechanism;
		this.reclineAngle = reclineAngle;
	}

	/* (non-Javadoc)
	 * @see com.amarjefferson.codeabout.java.interfaces.IRecliner#reclineChair(int)
	 */
	@Override
	public void reclineChair(int anAngle) {   // set recline angle
    	this.reclineAngle = anAngle;
    	this.recliningMechanism.setReclineAngle(anAngle);
    }
    
	/* (non-Javadoc)
	 * @see com.amarjefferson.codeabout.java.interfaces.IRecliner#recline()
	 */
	@Override
    public int reclineAngle() {               // get recline angle
    	return this.reclineAngle;
    }
    
	/* (non-Javadoc)
	 * @see com.amarjefferson.codeabout.java.interfaces.IRecliner#chairUpright()
	 */
	@Override
    public void chairUpright() {           // set seat back in upright position
    	IControls.super.chairUpright();
    	this.recliningMechanism.reset();
    }

	// instance variables
	private int reclineAngle;
	private IRecliningMechanism recliningMechanism;
}
