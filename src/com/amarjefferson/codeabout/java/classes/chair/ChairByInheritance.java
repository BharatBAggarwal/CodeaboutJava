package com.amarjefferson.codeabout.java.classes.chair;

import java.util.Scanner;

/**
 * File Name: ChairByInheritance.java
 *
 * Package: com.amarjefferson.codeabout.java.classes.chair
 * Class: ChairByInheritance
 *
 */
public class ChairByInheritance extends Chair {
	/**
	 * static members
	 */
	private static double cumulativeWeight = 0.0;     // total user weight
	private static long numberOfUsers = 0;            // number of users
	private static long chairsConstructed = 0;        // chairs constructed
	private static long chairsBroken = 0;             // chairs broken
	private static long brokenChairsRefurbished = 0;  // broken chairs refurbished

	public static double averageWeight() {
		if (numberOfUsers == 0)
			return 0;
		else
			return cumulativeWeight / numberOfUsers;
	}

	public static long users() {
		return numberOfUsers;
	}

	public static long chairsInUse() {
		return chairsConstructed - chairsBroken + brokenChairsRefurbished;
	}

	public static long chairsConstructed() {
		return chairsConstructed;
	}

	public static long chairsBroken() {
		return chairsBroken;
	}

	public static long chairsRefurbished() {
		return brokenChairsRefurbished;
	}

	/**
	 * Factory Methods
	 * 
	 * @param aColor
	 * @param aStyle
	 * @return
	 */
	public static ChairByInheritance customChair(ChairConstants.Colors aColor, ChairConstants.Styles aStyle) {
		return new ChairByInheritance(aColor, aStyle);
	}

	public static ChairByInheritance defaultChair() {
		return new ChairByInheritance(ChairConstants.Colors.BLACK, ChairConstants.Styles.BASIC);
	}

	private ChairByInheritance() {
		this(ChairConstants.Colors.BLACK, ChairConstants.Styles.BASIC);
	}

	private ChairByInheritance(ChairConstants.Colors aColor, ChairConstants.Styles aStyle) {
		super(aColor, aStyle);
		chairsConstructed++; // increment count of chairs
		System.out.println(this.getClass().getSimpleName() + " : ChairByInheritance(params)");
	}

	@Override
	protected double setCurrentWeight() {
		super.setCurrentWeight();
		if( isBroken() )
			chairsBroken++;                 // increment count of broken chairs
		return currentLoad();
	}

	/**
	 * @param weightOfPerson
	 * @return
	 */
	@Override
	public double sit(double weightOfPerson) {
		cumulativeWeight += weightOfPerson; // add to total weight
		numberOfUsers++;  // increment the number of users
		return super.sit(weightOfPerson);
	}
	
	@Override
	public void refurbish() { // make the chair new again!
		if(isBroken())
			brokenChairsRefurbished++;
		super.refurbish();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String str = super.toString();   // instance variables output from Chair
 		
		// add static variables to output
		str += "Class Attributes:\n"
		        + "   Number of users: " + ChairByInheritance.users() + "\n"
				+ "   Average weight of users: " + ChairByInheritance.averageWeight() + "\n"
				+ "   Number of chairs Constructed: " + ChairByInheritance.chairsConstructed() + "\n"
				+ "   Number of chairs Broken: " + ChairByInheritance.chairsBroken() + "\n"
				+ "   Number of Broken chairs Refurbished: " + ChairByInheritance.chairsRefurbished() + "\n"
				+ "   Number of chairs in use: " + ChairByInheritance.chairsInUse() + "\n"
                + "-------------------";
		return str;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		double weightOfUser = 0.0;

		// Use default factory method
		ChairByInheritance chair = ChairByInheritance.defaultChair();
		// Chaining of function calls.
		// Chain breaks at clear() because it returns void and not Chair
		chair.setColor(ChairConstants.Colors.GREEN).setStyle(ChairConstants.Styles.MODERN).clearLoads();

		System.out.println("What is the weight of person to sit on the Chair: ");
		if (scn.hasNextDouble())
			weightOfUser = scn.nextDouble();
		chair.sit(weightOfUser);
		System.out.println(chair.toString());   // explicit use of toString()

		chair.refurbish();                      // make the chair new again
		System.out.println(chair.toString());   // explicit use of toString()

		// Use factory method with parameters
		ChairByInheritance chair2 = ChairByInheritance.customChair(ChairConstants.Colors.RED,
				ChairConstants.Styles.MODERN);
		chair2.sit(50.0);                       // person of weight 50 sits on chair
		chair2.addStuff(25.0);                  // add 25 additional weight
		System.out.println(chair2);             // toString() method called by default
		
		scn.close();
	}

}
