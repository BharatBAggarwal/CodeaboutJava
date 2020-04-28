package com.amarjefferson.codeabout.java.mvc.data;

/**
 * File Name: TcConstants.java
 *
 * Package: com.amarjefferson.codeabout.java.events
 * Class: TcConstants
 *
 */
public class TcConstants {
	/**
	 * 
	 */
	public static final String FORMAT = "%7.1f";                 // format for temperature value
	public static final String TO_FAHRENHEIT = "To Fahrenheit";  // conversion
	public static final String TO_CELSIUS = "To Celsius";        // conversion
	public static final String FAHRENHEIT = "Fahrenheit";        // field label
	public static final String CELSIUS = "Celsius";              // field label
	public static final String DEG_C = "\u00B0C";                // units label
	public static final String DEG_F = "\u00B0F";                // units label
	public static final double MIN_TEMPERATURE = 0.0;
	public static final double MAX_TEMPERATURE = 500.0;
	public static final String TOOLTIP_CF = "C to F";
	public static final String TOOLTIP_FC = "F to C";
	
	public static enum conversion {
		toFahrenheit(TO_FAHRENHEIT, CELSIUS, DEG_C, FAHRENHEIT, DEG_F, TOOLTIP_CF),
		toCelsius(TO_CELSIUS, FAHRENHEIT, DEG_F, CELSIUS, DEG_C, TOOLTIP_FC);

		private String conversion;
		private String inputFieldLabel;
		private String inputUnitLabel;
		private String outputFieldLabel;
		private String outputUnitLabel;
		private String tooltip;
		
		private conversion(String aConversion, String inpLabel, String inpUnitLabel,
				           String outLabel, String outUnitLabel, String aTooltip) {
			this.conversion = aConversion;
			this.inputFieldLabel = inpLabel;
			this.inputUnitLabel = inpUnitLabel;
			this.outputFieldLabel = outLabel;
			this.outputUnitLabel = outUnitLabel;
			this.tooltip = aTooltip;
		}

		public String conversionAsString() { return this.conversion; }
		public String inputFieldLabel() { return this.inputFieldLabel; }
		public String inputUnitLabel() { return this.inputUnitLabel; }
		public String outputFieldLabel() { return this.outputFieldLabel; }
		public String outputUnitLabel() { return this.outputUnitLabel; }
		public String tooltip() { return this.tooltip; }
	};

}
