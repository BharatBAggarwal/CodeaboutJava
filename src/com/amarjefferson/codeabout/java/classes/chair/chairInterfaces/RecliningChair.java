package com.amarjefferson.codeabout.java.classes.chair.chairInterfaces;

import java.util.Scanner;

/**
 * File Name: RecliningChair.java
 *
 * Package: com.amarjefferson.codeabout.java.classes.chair.chairInterfaces
 * Class: RecliningChair
 *
 */
public class RecliningChair extends BaseChair implements IControls {

	/**
	 *  Instance variables
	 */
	private IControls chairControls;

	/**
	 * Default Factory Method: defaultChair
	 * 
	 */
	public static RecliningChair defaultChair() {
		return new RecliningChair();
	}

	/**
	 * Factory Method: styledChair
	 * 
	 * @param aColor
	 * @param aStyle
	 * @return
	 */
	public static RecliningChair styledChair(IChair.colors aColor, IChair.styles aStyle) {
		return new RecliningChair(aColor, aStyle);
	}

	/**
	 * Factory Method: controlsChair
	 * 
	 * @param aRecliner
	 * @param aMechanism
	 * @return
	 */
	public static RecliningChair controlsChair(IControls aRecliner) {
		return new RecliningChair(aRecliner);
	}

	/**
	 * Factory Method: customChair
	 * 
	 * @param aRecliner
	 * @param aMechanism
	 * @param aColor
	 * @param aStyle
	 * @return
	 */
	public static RecliningChair customChair(IControls aRecliner,
		                                     IChair.colors aColor, IChair.styles aStyle) {
		return new RecliningChair(aRecliner, aColor, aStyle);
	}

	/**
	 *  Default Constructor
	 */
	private RecliningChair() {
		this(new Buttons(IControls.SEATBACK_UPRIGHT, new EasyRecline(IRecliningMechanism.MECHANISM_UPRIGHT)),
			 IChair.colors.BLACK,
			 IChair.styles.BASIC);
	}

	/**
	 * @param aColor
	 * @param aStyle
	 */
	private RecliningChair(IChair.colors aColor, IChair.styles aStyle) {
		this(new Buttons(IControls.SEATBACK_UPRIGHT, new EasyRecline(IRecliningMechanism.MECHANISM_UPRIGHT)),
			 aColor,
			 aStyle);
	}

	/**
	 * @param aRecliner
	 * @param aMechanism
	 */
	private RecliningChair(IControls aRecliner) {
		this(aRecliner,
			 IChair.colors.BLACK,
			 IChair.styles.BASIC);
	}

	/**
	 * @param aRecliner
	 * @param aMechanism
	 * @param aColor
	 * @param aStyle
	 */
	private RecliningChair(IControls aRecliner, IChair.colors aColor, IChair.styles aStyle) {
		super(aColor, aStyle);
		chairControls = aRecliner;
	}

	/* ************************
	 * New methods
	 * ************************ */

	public void setControls(IControls aControl) {
		this.chairControls = aControl;
	}

	/* ************************
	 * IControls methods
	 * ************************ */
	@Override
	public void reclineChair(int anAngle) { // set recline angle
    	this.chairControls.reclineChair(anAngle);
    }
    
	@Override
    public int reclineAngle() {                 // get recline angle
    	return this.chairControls.reclineAngle();
    }
    
	@Override
    public void chairUpright() {           // set seat back in upright position
    	this.chairControls.chairUpright();
    }

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String str = super.toString();
		str += "Reclining Mechanism: " + "\n" +
		       "   Recline Angle : " + this.chairControls.reclineAngle() + "\n" +
        "-------------------";
		return str;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		double weightOfUser = 0.0;

		// create a reclining chair and assign to an IChair variable
		IChair aChair = RecliningChair.styledChair(IChair.colors.BLUE, IChair.styles.BASIC);
		// Only IChair functions avaliable through aChair
		System.out.println("What is the weight of person to sit on the Chair: ");
		if (scn.hasNextDouble())
			weightOfUser = scn.nextDouble();
		aChair.sit(weightOfUser);
		System.out.println(aChair.toString());

		aChair.refurbish();                      // make the chair new again
		System.out.println(aChair.toString());

		// Explicit cast to RecliningChair to access RecliningChair functions
		((RecliningChair)aChair).reclineChair(30);
		System.out.println(aChair.toString());
		((RecliningChair)aChair).chairUpright();
		System.out.println("Recline Angle = " + ((RecliningChair)aChair).reclineAngle() + "\n");
		
		// change the controls from Buttons to Lever
		((RecliningChair)aChair).setControls(new Lever(40, new EasyRecline()));
		aChair.setColor(IChair.colors.RED)
	      .setStyle(IChair.styles.TRADITIONAL)
	      .setCapacity(50)
	      .clearLoad();
		System.out.println(aChair.toString());

		// test Comparable<T> interface
		IChair other = new RecliningChair();
		String str = "Comparing Chairs:\n" +
				     "   This capacity: " + aChair.capacity() + "\n" +
		             "   Other capacity " + other.capacity() + "\n" +
		             "   compareTo(other): " + ((aChair.compareTo(other) > 0) ? "Other Before this" : "Other After this") + "\n";
		System.out.println(str);
	}
}
