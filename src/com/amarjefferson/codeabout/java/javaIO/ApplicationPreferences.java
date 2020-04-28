package com.amarjefferson.codeabout.java.javaIO;

import java.util.prefs.Preferences;

/**
 * File Name: ApplicationPreferences.java
 *
 * Package: com.amarjefferson.codeabout.java.javaIO
 * Class: ApplicationPreferences
 *
 */
public class ApplicationPreferences {
	
	// define constants for keys
	private static final String dirBase = "dir.base";
	private static final String dirImages = "dir.images";
	private static final String dirInput = "dir.input";
	private static final String dirOutput = "dir.output";
	
	// define constants for default values
	private static final String NO_STRING = "Invalid Key";
	private static final boolean NO_BOOLEAN = false;
	private static final double NO_DOUBLE = Double.MIN_VALUE;
	private static final int NO_INT = Integer.MIN_VALUE;

	// enum to define preference tree
	public static enum PreferenceTree { System, User };

	private Preferences appPrefs;
	/**
	 * 
	 */
	public ApplicationPreferences(PreferenceTree aTree, String nodeName) {
		if(aTree.equals(PreferenceTree.User)) 
			appPrefs = Preferences.userRoot().node(nodeName);
		else
			appPrefs = Preferences.systemRoot().node(nodeName);
	}
	
	public String readStringPref(String key) {
		return appPrefs.get(key, NO_STRING);
	}

	public boolean readBooleanPref(String key) {
		return appPrefs.getBoolean(key, NO_BOOLEAN);
	}

	public double readDoublePref(String key) {
		return appPrefs.getDouble(key, NO_DOUBLE);
	}

	public int readIntPref(String key) {
		return appPrefs.getInt(key, NO_INT);
	}

	public void saveStringPref(String key, String value) {
		appPrefs.put(key, value);
	}

	public void saveBooleanPref(String key, boolean value) {
		appPrefs.putBoolean(key, value);
	}

	public void saveDoublePref(String key, double value) {
		appPrefs.putDouble(key, value);
	}

	public void saveIntPref(String key, int value) {
		appPrefs.putInt(key, value);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationPreferences myPrefs = new ApplicationPreferences(PreferenceTree.User,
											       ApplicationPreferences.class.getName());

		// save values in node
//		myPrefs.saveStringPref(dirBase, "bin");
//		myPrefs.saveStringPref(dirImages, "images");
//		myPrefs.saveStringPref(dirInput, "files");
//		myPrefs.saveStringPref(dirOutput, "files");

		// read values from node
		System.out.println("Key: " + dirBase + "\t - Value: " + myPrefs.readStringPref(dirBase));
		System.out.println("Key: " + dirImages + "\t - Value: " + myPrefs.readStringPref(dirImages));
		System.out.println("Key: " + dirInput + "\t - Value: " + myPrefs.readStringPref(dirInput));
		System.out.println("Key: " + dirOutput + "\t - Value: " + myPrefs.readStringPref(dirOutput));
		System.out.println("Key: " + "Hello" + "\t - Value: " + myPrefs.readStringPref("Hello"));
		
	}

}
