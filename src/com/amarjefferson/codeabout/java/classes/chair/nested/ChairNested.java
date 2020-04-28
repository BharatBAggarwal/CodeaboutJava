package com.amarjefferson.codeabout.java.classes.chair.nested;

public class ChairNested {
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
	 *  Default Constructor
	 */
	public ChairNested() {
		this(ChairConstants.Colors.BLACK, ChairConstants.Styles.BASIC);
	}

	/**
	 * @param aColor
	 * @param aStyle
	 */
	public ChairNested(ChairConstants.Colors aColor, ChairConstants.Styles aStyle) {
		this.initialize();
		setColor(aColor);
		setStyle(aStyle);
		className = this.getClass().getSimpleName();
		System.out.println(this.className + " : Chair(params)");
	}
 
	/**
	 * @return
	 */
	protected double setCurrentWeight() {
		if (this.personWeight < 0.0) {              // if no one sitting on the chair
			this.currentLoad = this.otherWeight;
		}
		else {                                      // if someone is sitting on the chair
			this.currentLoad = this.personWeight + this.otherWeight;
		}

		if (this.currentLoad > capacity) {          // if total weight exceeds capacity
			this.broken = true;
			System.out.println(this.className + " : Weight > capacity. The Chair broke!");
		}
		return this.currentLoad;
	}

	/**
	 * @param weightOfPerson
	 * @return
	 */
	public double sit(double weightOfPerson) {
		if (this.broken) {                 // cannot sit on a broken chair
			System.out.println(this.className + " : Cannot sit on a broken chair!");
			return this.currentLoad;
		}

		if (!(this.personWeight < 0.0)) {  // someone sitting on chair
			System.out.println(this.className + " : This chair is taken!");
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
		if (this.broken) // do not add weight to a broken chair
		{
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
			System.out.println(this.className + " : The Chair is broken!");
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
	public ChairNested setColor(ChairConstants.Colors aColor) {
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
	public ChairNested setStyle(ChairConstants.Styles aStyle) {
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
	public ChairNested setCapacity(double limit) {
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
		ChairNested chair = new ChairNested();             // use default constructor
		// Chaining of function calls.
		chair.setColor(ChairConstants.Colors.GREEN).setStyle(ChairConstants.Styles.MODERN);
		chair.sit(150.0);                      // the chair will break. Capacity = 100.0
		System.out.println(chair.toString());  // explicit use of toString()
		chair.refurbish();                     // make the chair new again
		System.out.println(chair.toString());  // explicit use of toString()

		// Use constructor with parameters
		ChairNested chair2 = new ChairNested(ChairConstants.Colors.RED, ChairConstants.Styles.MODERN);
		chair2.sit(50.0);                      // person of weight 50 sits on chair
		chair2.addStuff(25.0);                 // add 25 additional weight
		System.out.println(chair2);            // toString() method called by default
	}

	private static class ChairConstants {
		/**
		 * Enumerations
		 */
		public static enum Styles {
			BASIC, MODERN, TRADITIONAL
		};

		public static enum Colors {
			BLACK(0x000000), WHITE(0xFFFFFF), RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF);
			
			private Colors(long aHexColor) { this.hexColor = aHexColor; }
			public long hexValue() { return hexColor; }
			
			private long hexColor;
		};

	}

}
