package com.amarjefferson.codeabout.java.classes.chair;

import java.util.Scanner;

/**
 * File Name: ChairClassVariables.java
 *
 * Package: com.amarjefferson.codeabout.java.classes.chair Class:
 * ChairClassVariables
 *
 */
public class ChairClassVariables {
	/**
	 * static members
	 */
	private static double cumulativeWeight = 0.0;     // total user weight
	private static long numberOfUsers = 0;            // number of users
	private static long chairsConstructed = 0;        // chairs in use
	private static long chairsBroken = 0;             // chairs in use
	private static long brokenChairsRefurbished = 0;  // chairs in use

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
	 *  Instance variables
	 */
	private ChairConstants.Colors aColor;  // color of a chair
	private ChairConstants.Styles aStyle;  // style of a chair
	private boolean broken;                // is the chair broken?
	private boolean refurbished;           // is the chair refurbished?
	private double currentLoad;            // current total weight on chair
	private double capacity;               // weight capacity of the chair
	private double personWeight;           // weight of person sitting on chair
							               // Set to -1 when no one sitting on chair
	private double otherWeight;            // additional weight added to chair
	private String className;              // name of class

	/**
	 * Factory Methods
	 * 
	 * @param aColor
	 * @param aStyle
	 * @return
	 */
	public static ChairClassVariables customChair(ChairConstants.Colors aColor, ChairConstants.Styles aStyle) {
		return new ChairClassVariables(aColor, aStyle);
	}

	public static ChairClassVariables defaultChair() {
		return new ChairClassVariables(ChairConstants.Colors.BLACK, ChairConstants.Styles.BASIC);
	}

	/**
	 * Default Constructor
	 */
	private ChairClassVariables() {
		this(ChairConstants.Colors.BLACK, ChairConstants.Styles.BASIC);
	}

	/**
	 * @param aColor
	 * @param aStyle
	 */
	private ChairClassVariables(ChairConstants.Colors aColor, ChairConstants.Styles aStyle) {
		this.initialize();
		this.aColor = aColor;
		this.aStyle = aStyle;

		chairsConstructed++; // increment count of chairs
	}

	/**
	 * @return
	 */
	protected double setCurrentWeight() {
		if (this.personWeight < 0.0) {      // if no one sitting on the chair
			this.currentLoad = this.otherWeight;
		}
		else {                              // if someone is sitting on the chair
			this.currentLoad = this.personWeight + this.otherWeight;
		}

		if (this.currentLoad > capacity) {  // if total weight exceeds capacity
			this.broken = true;
			chairsBroken++;                 // increment count of broken chairs
		}
		return this.currentLoad;
	}

	/**
	 * @param weightOfPerson
	 * @return
	 */
	public double sit(double weightOfPerson) {
		// Do nothing if chair is broken or some one already sitting on chair
		if (this.broken || !(this.personWeight < 0.0)) {
			return this.currentLoad;
		}

		this.personWeight = weightOfPerson;

		cumulativeWeight += this.personWeight; // add to total weight
		numberOfUsers++; // increment the number of users

		return setCurrentWeight();
	}

	/**
	 * @return
	 */
	public double getOff() {
		// Do nothing if chair is broken or no one sitting on chair
		if (this.broken || personWeight < 0.0) {
			return this.currentLoad;
		}

		this.personWeight = -1.0;
		return setCurrentWeight();
	}

	/**
	 * @param aWeight
	 * @return
	 */
	public double addStuff(double aWeight) {
		if (this.broken) {
			return this.currentLoad;
		}

		this.otherWeight += aWeight;
		return setCurrentWeight();
	}

	/**
	 * @param aWeight
	 * @return
	 */
	public double removeStuff(double aWeight) {
		if (this.broken) {
			return this.currentLoad;
		}

		this.otherWeight -= aWeight;
		if (this.otherWeight < 0.0) {
			this.otherWeight = 0.0;
		}

		return this.setCurrentWeight();
	}

	/**
	 * @return
	 */
	public double currentLoad() {
		return this.currentLoad;
	}

	/**
	 * @return
	 */
	public double personWeight() {
		return this.personWeight;
	}

	/**
	 * @return
	 */
	public double otherWeight() {
		return this.otherWeight;
	}

	/**
	 * @return
	 */
	public boolean isBroken() // true if broken
	{
		return this.broken;
	}

	/**
	 * @return
	 */
	protected void setBroken(boolean isBroken) {
		this.broken = isBroken;
	}

	/**
	 * @return
	 */
	public boolean isRefurbished() // true if broken
	{
		return this.refurbished;
	}

	/**
	 * @return
	 */
	protected void setRefurbished(boolean isRefurbished) {
		this.refurbished = isRefurbished;
	}

	/**
	 * @return
	 */
	public boolean isSitting() {
		if (this.personWeight < 0.0)
			return false;
		else
			return true;
	}

	/**
	 * 
	 * 
	 */
	public void clearLoads() {
		this.currentLoad = 0.0;
		this.personWeight= -1.0;
		this.otherWeight = 0.0;
	}

	protected void initialize() {
		this.aColor = ChairConstants.Colors.BLACK;
		this.aStyle = ChairConstants.Styles.BASIC;
		this.broken = false;      // set broken to false
		this.capacity = 100.0;    // set weight capacity to 100.0
	}

	/**
	 * 
	 */
	public void refurbish() {
		if (this.broken)
			brokenChairsRefurbished++;
		
		this.initialize();
		this.clearLoads();
		this.refurbished = true;  // set refurbished to true
	}


	/**
	 * @return
	 */
	public ChairConstants.Colors color() {
		return this.aColor;
	}

	/**
	 * @param aColor
	 * @return
	 */
	public ChairClassVariables setColor(ChairConstants.Colors aColor) {
		this.aColor = aColor;
		return this;
	}

	/**
	 * @return
	 */
	public ChairConstants.Styles style() {
		return this.aStyle;
	}

	/**
	 * @param aStyle
	 * @return
	 */
	public ChairClassVariables setStyle(ChairConstants.Styles aStyle) {
		this.aStyle = aStyle;
		return this;
	}

	/**
	 * @return
	 */
	public double capacity() {
		return this.capacity;
	}

	/**
	 * @param limit
	 * @return
	 */
	public ChairClassVariables setCapacity(double limit) {
		this.capacity = limit;
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String str = "State of the Chair:\n" +
				     "   Color : " + this.color().name() + "\n" +
	                 "   Style : " + this.style().name() + "\n" +
	                 "   Weight : " + this.currentLoad() + "\n" +
	                 "   Broken? : " + this.isBroken() + "\n" +
	                 "   Refurbished? : " + this.isRefurbished() + "\n" +
		             "...................\n";

		// add static variables to output
		str += "Class Attributes:\n"
		        + "   Number of users: " + ChairClassVariables.users() + "\n"
				+ "   Average weight of users: " + ChairClassVariables.averageWeight() + "\n"
				+ "   Number of chairs Constructed: " + ChairClassVariables.chairsConstructed() + "\n"
				+ "   Number of chairs Broken: " + ChairClassVariables.chairsBroken() + "\n"
				+ "   Number of Broken chairs Refurbished: " + ChairClassVariables.chairsRefurbished() + "\n"
				+ "   Number of chairs in use: " + ChairClassVariables.chairsInUse() + "\n"
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
		ChairClassVariables chair = ChairClassVariables.defaultChair();
		// Chaining of function calls.
		// Chain breaks at clear() because it returns void and not Chair
		chair.setColor(ChairConstants.Colors.GREEN).setStyle(ChairConstants.Styles.MODERN);

		System.out.println("What is the weight of person to sit on the Chair: ");
		if (scn.hasNextDouble())
			weightOfUser = scn.nextDouble();
		chair.sit(weightOfUser);
		System.out.println(chair.toString());   // explicit use of toString()

		chair.refurbish();                      // make the chair new again
		System.out.println(chair.toString());   // explicit use of toString()

		// Use factory method with parameters
		ChairClassVariables chair2 = ChairClassVariables.customChair(ChairConstants.Colors.RED,
				ChairConstants.Styles.MODERN);
		chair2.sit(50.0);                       // person of weight 50 sits on chair
		chair2.addStuff(25.0);                  // add 25 additional weight
		System.out.println(chair2);             // toString() method called by default
		
		scn.close();
	}

}
