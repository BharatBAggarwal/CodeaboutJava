package com.amarjefferson.codeabout.java.basics.program_flow;
import java.util.Scanner;

/**
 * File Name: BranchingIf.java
 *
 * Package: com.amarjefferson.codeabout.java.basics.program_flow
 * Class: BranchingIf
 *
 */
public class BranchingIf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Choose your language: ");
		System.out.println("   C++ :  Enter 1");
		System.out.println("   C   :  Enter 2");
		System.out.println("   Java:  Enter 3");
		System.out.println("   Basic: Enter 4");
		System.out.print("Enter your choice: ");

		int choice = 0;
		Scanner aScanner = new Scanner(System.in);
		if(aScanner.hasNextInt())
			choice = aScanner.nextInt();
		aScanner.close();

		if (choice == 1) {
			System.out.println("I love C++");
		}
		else if (choice == 2) {
			System.out.println("I love C");
		}
		else if (choice == 3) {
			System.out.println("I love Java");
		}
		else if (choice == 4) {
			System.out.println("I love Basic");
		}
		else {
			System.out.println("I do not like programming!");
		}
	}
}
