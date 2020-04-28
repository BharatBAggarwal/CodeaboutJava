package com.amarjefferson.codeabout.java.classes.chair;

/**
 * File Name: ChairFactoryMethods.java
 *
 * Package: com.amarjefferson.codeabout.java.classes.chair
 * Class: ChairFactoryMethods
 *
 */
public class ChairFactoryMethods {
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
	 * Factory Method: newChair
	 * 
	 * @param aColor
	 * @param aStyle
	 * @return
	 */
	public static ChairFactoryMethods customChair(ChairConstants.Colors aColor, ChairConstants.Styles aStyle) {
		System.out.println("ChairFactoryMethods : customChair(params)");
		return new ChairFactoryMethods(aColor, aStyle);
	}

	public static ChairFactoryMethods defaultChair() {
		System.out.println("ChairFactoryMethods : defaultChair()");
		return new ChairFactoryMethods(ChairConstants.Colors.BLACK, ChairConstants.Styles.BASIC);
	}

	/**
	 *  Default Constructor
	 */
	private ChairFactoryMethods() {
		this(ChairConstants.Colors.BLACK, ChairConstants.Styles.BASIC);
	}

	/**
	 * @param aColor
	 * @param aStyle
	 */
	private ChairFactoryMethods(ChairConstants.Colors aColor, ChairConstants.Styles aStyle) {
		this.initialize();
		this.aColor = aColor;
		this.aStyle = aStyle;
		className = this.getClass().getSimpleName();
		System.out.println(this.className + " : ChairFactoryMethods(params)");
	}

	/**
	 * @return
	 */
	protected double setCurrentWeight() {
		if (this.personWeight < 0.0) {       // if no one sitting on the chair
			this.currentLoad = this.otherWeight;
		}
		else {                               // if someone is sitting on the chair
			this.currentLoad = this.personWeight + this.otherWeight;
		}

		if (this.currentLoad > capacity) {   // if total weight exceeds capacity
			this.broken = true;
		}
		return this.currentLoad;
	}

	/**
	 * @param weightOfPerson
	 * @return
	 */
	public double sit(double weightOfPerson) {
		if (this.broken || !(this.personWeight < 0.0)) {
			return this.currentLoad;
		}

		this.personWeight = weightOfPerson;
		return setCurrentWeight();
	}

	/**
	 * @return
	 */
	public double getOff() {
		if (this.broken || personWeight < 0.0) {
			return this.currentLoad;
		}

		this.personWeight = -1.0;
		return setCurrentWeight();
	}

	/**
	 * @param stuffWeight
	 * @return
	 */
	public double addStuff(double stuffWeight) {
		if (this.broken) {    // do not add weight to a broken chair
			return this.currentLoad;
		}

		this.otherWeight += stuffWeight;
		return setCurrentWeight();
	}

	/**
	 * @param stuffWeight
	 * @return
	 */
	public double removeStuff(double stuffWeight) {
		if (this.broken) {
			return this.currentLoad;
		}

		this.otherWeight -= stuffWeight;
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
	public boolean isBroken() {
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
	public ChairFactoryMethods setColor(ChairConstants.Colors aColor) {
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
	public ChairFactoryMethods setStyle(ChairConstants.Styles aStyle) {
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
	public ChairFactoryMethods setCapacity(double limit) {
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
			     "   Color : "  + this.color().name() + "\n" +
	             "   Style : "  + this.style().name() + "\n" +
	             "   Weight : " + this.currentLoad() + "\n" +
	             "   Broken? : " + this.isBroken() + "\n" +
                "   Refurbished? : " + this.isRefurbished() + "\n" +
                "-------------------\n";
		return str;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Use default factory method
		ChairFactoryMethods chair = ChairFactoryMethods.defaultChair();
		// Chaining of function calls.
		// Chain breaks at clear() because it returns void and not ChairBase
		chair.setColor(ChairConstants.Colors.GREEN).setStyle(ChairConstants.Styles.MODERN);
		chair.sit(150.0);                       // the chair will break. Capacity = 100.0
		System.out.println(chair.toString());   // explicit use of toString()
		chair.refurbish();                      // make the chair new again
		System.out.println(chair.toString());   // explicit use of toString()

		// Use factory method with parameters
		ChairFactoryMethods chair2 = ChairFactoryMethods.customChair(ChairConstants.Colors.RED, ChairConstants.Styles.MODERN);
		chair2.sit(50.0);            // person of weight 50 sits on chair
		chair2.addStuff(25.0);       // add 25 additional weight
		System.out.println(chair2);  // toString() method called by default
	}
}
