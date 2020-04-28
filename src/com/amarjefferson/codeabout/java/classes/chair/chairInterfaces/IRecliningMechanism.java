package com.amarjefferson.codeabout.java.classes.chair.chairInterfaces;

/**
 * File Name: IRecliningMechanism.java
 *
 * Package: com.amarjefferson.codeabout.java.classes.chair.chairInterfaces
 * Class: IRecliningMechanism
 *
 */
public interface IRecliningMechanism {
	// The variable is public static final by default
	int MECHANISM_UPRIGHT = 0;
	
	// public interface functions (all public by default)
	void setReclineAngle(int anAngle);  // set recline angle
	int reclineAngle();                 // get recline angle
	default void reset() {              // reset to default
    	setReclineAngle(MECHANISM_UPRIGHT);
	}
}
