package com.amarjefferson.codeabout.java.classes.chair;

/**
 * File Name: ChairConstants.java
 *
 * Package: com.amarjefferson.codeabout.java.classes.chair
 * Class: ChairConstants
 *
 */
public class ChairConstants {
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
