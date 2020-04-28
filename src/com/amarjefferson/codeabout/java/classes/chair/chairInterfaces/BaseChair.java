package com.amarjefferson.codeabout.java.classes.chair.chairInterfaces;

/**
 * File Name: BaseChair.java
 *
 * Package: com.amarjefferson.codeabout.java.classes.chair.chairInterfaces
 * Class: BaseChair
 *
 */
public class BaseChair implements IChair {

	/**
	 *  Instance variables
	 */
	private IChair.colors aColor;  // color of a chair
	private IChair.styles aStyle;  // style of a chair
	private boolean broken;        // is the chair broken?
	private boolean refurbished;   // is the chair refurbished?
	private double currentLoad;    // current total weight on chair
	private double capacity;       // weight capacity of the chair
	private double personWeight;   // weight of person sitting on chair
							       // Set to -1 when no one sitting on chair
	private double otherWeight;    // additional weight added to chair

	/**
	 *  Default Constructor
	 */
	public BaseChair() {
		this(IChair.colors.BLACK, IChair.styles.BASIC);
	}

	/**
	 * @param aColor
	 * @param aStyle
	 */
	public BaseChair(IChair.colors aColor, IChair.styles aStyle) {
		this.refurbish();
		this.refurbished = false;
		this.aColor = aColor;
		this.aStyle = aStyle;
		System.out.println(this.getClass().getSimpleName() + " : Chair(params)");
	}
 
	/**
	 * @return
	 */
	protected double setCurrentWeight() {
		if (this.personWeight < 0.0)  // if no one sitting on the chair
			this.currentLoad = this.otherWeight;
		else  // if someone is sitting on the chair
			this.currentLoad = this.personWeight + this.otherWeight;

		if (this.currentLoad > capacity) { // if total weight exceeds capacity
			this.broken = true;
		}
		return this.currentLoad;
	}

	/**
	 * @param weightOfPerson
	 * @return
	 */
	@Override
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
	@Override
	public double getOff() { // get off the chair
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
	@Override
	public double addStuff(double stuffWeight) { // add weight
		if (this.broken) { // do not add weight to a broken chair
			return this.currentLoad;
		}

		this.otherWeight += stuffWeight;
		return setCurrentWeight();
	}

	/**
	 * @param stuffWeight
	 * @return
	 */
	@Override
	public double removeStuff(double stuffWeight) { // remove weight
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
	@Override
	public double currentLoad() { // total weight on chair
		return this.currentLoad;
	}

	/**
	 * @return
	 */
	@Override
	public double personWeight()  { // person weight on chair
		return this.personWeight;
	}

	/**
	 * @return
	 */
	@Override
	public double otherWeight() { // other weight on chair
		return this.otherWeight;
	}

	/**
	 * @return
	 */
	@Override
	public boolean isBroken() { // true if broken
		return this.broken;
	}

	/**
	 * @return
	 */
	public boolean isRefurbished() { // true if broken
		return this.refurbished;
	}

	/**
	 * 
	 */
	@Override
	public void clearLoad() {  // reset all weight values
		this.currentLoad = 0.0;
		this.personWeight= -1.0;
		this.otherWeight = 0.0;
	}

	/**
	 * 
	 */
	@Override
	public void refurbish() {  // make the chair new again!
		this.aColor = IChair.colors.BLACK;
		this.aStyle = IChair.styles.BASIC;
		this.broken = false;      // set broken to false
		this.capacity = 100.0;    // set weight capacity to 100.0
		this.clearLoad();
		this.refurbished = true;  // set refurbished to true
	}

	/**
	 * @return
	 */
	@Override
	public IChair.colors color() {
		return this.aColor;
	}

	/**
	 * @param aColor
	 * @return
	 */
	@Override
	public IChair setColor(IChair.colors aColor) {
		this.aColor = aColor;
		return this;
	}

	/**
	 * @return
	 */
	@Override
	public IChair.styles style() {
		return this.aStyle;
	}

	/**
	 * @param aStyle
	 * @return
	 */
	@Override
	public IChair setStyle(IChair.styles aStyle) {
		this.aStyle = aStyle;
		return this;
	}

	/**
	 * @return
	 */
	@Override
	public double capacity() {
		return this.capacity;
	}

	/**
	 * @param limit
	 * @return
	 */
	@Override
	public IChair setCapacity(double limit) {
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
		String str = "State of Base Chair:\n" +
			         "   Color : " + this.color().name() + "\n" +
	                 "   Style : " + this.style().name() + "\n" +
		             "   Weight : " + this.currentLoad() + "\n" +
		             "   Broken? : " + this.isBroken() + "\n" +
                     "   Refurbished? : " + this.isRefurbished() + "\n" +
                     "-------------------\n";
		return str;
	}
}
