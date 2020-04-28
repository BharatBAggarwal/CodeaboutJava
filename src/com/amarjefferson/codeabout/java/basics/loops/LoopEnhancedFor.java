
package com.amarjefferson.codeabout.java.basics.loops;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * File Name: LoopEnhancedFor.java
 *
 * Package: com.amarjefferson.codeabout.java.basics.loops
 * Class: LoopEnhancedFor
 *
 */
public class LoopEnhancedFor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int howMany = 0;         // how many numbers to input
		Scanner aScanner = new Scanner(System.in);

		System.out.print("How many numbers (max 100)? ");
		if(aScanner.hasNextInt())
			howMany = aScanner.nextInt();

		if(howMany > 100) {
			System.out.print("Count of numbers set to 100");
			howMany = 100;
		}

		// create and initialize numbers ArrayList
		ArrayList<Integer> numbers = new ArrayList<Integer>();

		// input and store values in numbers ArrayList
		int temp = 0;
		for(int i = 0; i < howMany; ++i) {
			System.out.println("Enter -9999 to stop further input");
			System.out.print("Input number # " +  (i+1) + ": ");
			if(aScanner.hasNextInt())
				temp = aScanner.nextInt();

			if(temp == -9999)
				break;       // end loop and calculate average

			// do not store numbers between 10 and 20 (both inclusive)
			if(temp >= 10 && temp <= 20) {
				System.out.println("Number " + temp + " not used");
				continue;     // go to top of loop
			}

			numbers.add(temp);
		}
		aScanner.close();

		// calculate average
		double sum = 0.0;
		double average = 0.0;
		for(double aNumber : numbers) {
			sum += aNumber;
		}

		average = sum / numbers.size();
		System.out.println("Average of " + numbers.size() + " numbers is " + average);
	}

}
