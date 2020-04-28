package com.amarjefferson.codeabout.java.generics;

/**
 * File Name: DataValues.java
 *
 * Package: com.amarjefferson.codeabout.java.generics
 * Class: DataValues
 *
 */
public class DataValue<T> {

	private T value;
	private String label;
	private String classT;

	public DataValue(T value, String str) {
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
