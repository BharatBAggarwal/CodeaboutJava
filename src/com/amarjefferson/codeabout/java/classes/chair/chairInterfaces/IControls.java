package com.amarjefferson.codeabout.java.classes.chair.chairInterfaces;

/**
 * File Name: IControls.java
 *
 * Package: com.amarjefferson.codeabout.java.classes.chair.chairInterfaces
 * Class: IControls
 *
 */
public interface IControls {
	// The variable is public static final by default
	int SEATBACK_UPRIGHT = 0;          // define constant
	
	// public interface functions (all public by default)
    void reclineChair(int anAngle);    // set recline angle
    int reclineAngle();                // get recline angle
    default void chairUpright() {      // set seat back in upright position
    	reclineChair(SEATBACK_UPRIGHT);
    }
}
