package com.amarjefferson.codeabout.java.classes.chair.chairInterfaces;

/**
 * File Name: IChair.java
 *
 * Package: com.amarjefferson.codeabout.java.classes.chair.chairInterfaces
 * Interface: IChair
 *
 */

// IChair extends Comparable
// We want all IChair implementations to be Comparable.

public interface IChair extends Comparable<IChair> {

	// Declare Colors and Styles enums in IChair
	// The enums are public static final by default
	enum styles { BASIC, MODERN, TRADITIONAL };
	enum colors {
		BLACK(0x000000), WHITE(0xFFFFFF), RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF);
		
		private colors(long aHexColor) { this.hexColor = aHexColor; }
		public long hexValue() { return hexColor; }
		
		private long hexColor;
	};
	
	// public interface functions (all public by default)
	double sit(double weightOfPerson);
	double getOff();
	double addStuff(double aWeight);
	double removeStuff(double aWeight);
	double currentLoad();
	double personWeight();
	double otherWeight();
	boolean isBroken();
	
	// make isSitting() a default method
	default boolean isSitting() {
		if(personWeight() < 0)
			return true;
		else
			return false;
	}
	
	void clearLoad();
	void refurbish();
	IChair.colors color();
	IChair setColor(IChair.colors aColor);
	IChair.styles style();
	IChair setStyle(IChair.styles aStyle);
	double capacity();
	IChair setCapacity(double limit);
	
	// make compareTo() method from Comparable<IChair> a default method
	@Override
	default int compareTo(IChair other) {
		// ensure we are comparing objects of the same class
		if(getClass() != other.getClass())
			throw new ClassCastException();
		return Double.compare(capacity(), other.capacity());
	}
}
