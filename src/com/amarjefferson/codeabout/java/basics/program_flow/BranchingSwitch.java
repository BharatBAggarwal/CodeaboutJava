package com.amarjefferson.codeabout.java.basics.program_flow;
import java.util.Scanner;

/**
 * File Name: BranchingSwitch.java
 *
 * Package: com.amarjefferson.codeabout.java.basics.program_flow
 * Class: BranchingSwitch
 *
 */
public class BranchingSwitch {

	public enum Languages {CPP, CS, Java, Basic};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Languages[] choices = Languages.values();

		System.out.println("Choose your language: ");
		System.out.println("   C++ :  Enter 1");
		System.out.println("   C#  :  Enter 2");
		System.out.println("   Java:  Enter 3");
		System.out.println("   Basic: Enter 4");
		System.out.print("Enter your choice: ");

		int choice = 0;
		Scanner aScanner = new Scanner(System.in);
		if(aScanner.hasNextInt()) {
			choice = aScanner.nextInt();
			choice--;
		}
		aScanner.close();

		if(choice < 0)
			choice = 0;
		if(choice > 3)
			choice = 3;
		Languages selected = choices[choice];
		switch( selected ) {
		case CPP:
			System.out.println("I love C++");
			break;
		case Java:
			System.out.println("I love Java");
			break;
		case CS:
			System.out.println("I love C#");
		case Basic:
			System.out.println("I love Basic");
			break;
		default:
			System.out.println("I do not like programming!");
			break;
		}
	}
}
