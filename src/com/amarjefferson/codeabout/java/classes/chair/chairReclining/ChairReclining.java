package com.amarjefferson.codeabout.java.classes.chair.chairReclining;

import java.util.Scanner;
import com.amarjefferson.codeabout.java.classes.chair.Chair;
import com.amarjefferson.codeabout.java.classes.chair.ChairConstants;

/**
 * File Name: ChairReclining.java
 *
 * Package: com.amarjefferson.codeabout.java.classes.chair.chairReclining
 * Class: ChairReclining
 *
 */
public class ChairReclining extends Chair {
	/**
	 *  Instance variables
	 */
	private Controls controls;
	private RecliningMechanism recliningMechanism;
	
	public static ChairReclining customChair(ChairConstants.Colors aColor, ChairConstants.Styles aStyle) {
		return new ChairReclining(aColor, aStyle);
	}

	public static ChairReclining defaultChair() {
		return new ChairReclining(ChairConstants.Colors.BLACK, ChairConstants.Styles.BASIC);
	}

	private ChairReclining() {
		this(ChairConstants.Colors.BLACK, ChairConstants.Styles.BASIC);
	}

	private ChairReclining(ChairConstants.Colors aColor, ChairConstants.Styles aStyle) {
		super(aColor, aStyle);
		recliningMechanism = new RecliningMechanism(0);
		controls = new Controls(0, recliningMechanism);
	}

	/* ************************
	 * Exposed Controls methods
	 * ************************ */
	public void reclineChair(int anAngle) {    // set recline angle
        this.controls.reclineChair(anAngle);
    }
    
    public int reclineAngle() {                // get recline angle
    	return this.controls.reclineAngle();
    }
    
    public void chairUpright() {               // set seat back in upright position
    	this.controls.chairUpright();
    }

	@Override
	public String toString() {
		String str = super.toString();
		str += "Reclining Function: " + "\n" +
			   "   Recline Angle : " + this.controls.reclineAngle() + "\n" +
               "-------------------";
		return str;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		double weightOfUser = 0.0;

		ChairReclining aChair = ChairReclining.customChair(ChairConstants.Colors.BLUE,
                                                           ChairConstants.Styles.BASIC);
		System.out.println("What is the weight of person to sit on the Chair: ");
		if (scn.hasNextDouble())
			weightOfUser = scn.nextDouble();
		aChair.sit(weightOfUser);
		System.out.println(aChair.toString());

		aChair.refurbish();                      // make the chair new again
		System.out.println(aChair.toString());
		
		aChair.setColor(ChairConstants.Colors.GREEN)
		      .setStyle(ChairConstants.Styles.MODERN)
		      .clearLoads();
		aChair.reclineChair(30);
		System.out.println(aChair.toString());
		
		aChair.setColor(ChairConstants.Colors.RED)
		      .setStyle(ChairConstants.Styles.TRADITIONAL)
		      .clearLoads();
		aChair.chairUpright();
		System.out.println(aChair.toString());
	}

}
