package com.amarjefferson.codeabout.java.basics.loops;
import java.util.Scanner;

/**
 * File Name: LoopDo.java
 *
 * Package: com.amarjefferson.codeabout.java.basics.loops
 * Class: LoopDo
 *
 */
public class LoopDo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Choose your language: ");
		System.out.println("   C++ :  Enter 1");
		System.out.println("   C   :  Enter 2");
		System.out.println("   Java:  Enter 3");
		System.out.println("   Basic: Enter 4");

		int choice = 0;
		Scanner aScanner = new Scanner(System.in);

		do {
			System.out.print("Enter your choice: ");
			if(aScanner.hasNextInt())
				choice = aScanner.nextInt();
		} while(choice < 1 || choice > 4); // loop until correct choice is made

		aScanner.close();
		System.out.print("Your chose option " + choice);

	}

}
