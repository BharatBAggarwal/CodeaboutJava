package com.amarjefferson.codeabout.java.generics;

public class DataValueBounded <T extends Number> {

	/**
	 * File Name: DataValues.java
	 *
	 * Package: com.amarjefferson.codeabout.java.generics
	 * Class: DataValueBounded
	 *
	 */

	private T value;
	private String label;
	private String classT;

	public DataValueBounded(T value, String str) {
		this.value = value;
		this.label = str;
		this.classT = this.value.getClass().getName();
	}

	public String getClassT() {
		return this.classT;
	}

	public T getValue() {
		return this.value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
