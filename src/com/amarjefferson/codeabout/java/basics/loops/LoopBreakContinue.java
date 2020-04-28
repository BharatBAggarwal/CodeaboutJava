package com.amarjefferson.codeabout.java.basics.loops;
import java.util.Scanner;

/**
 * File Name: LoopBreakContinue.java
 *
 * Package: com.amarjefferson.codeabout.java..basics.loops
 * Class: LoopBreakContinue
 *
 */
public class LoopBreakContinue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int howMany = 0;         // how many numbers to input
		Scanner aScanner = new Scanner(System.in);

		System.out.print("How many numbers? ");
		if(aScanner.hasNextInt())
			howMany = aScanner.nextInt();

		double number = 0.0;
		double sum = 0.0;
		int numbersUsed = 0;     // numbers used in average calculations
		for(int i = 0; i < howMany; ++i) {
			System.out.println("Enter -9999 to stop further input");
			System.out.print("Input number # " +  (i+1) + ": ");
			if(aScanner.hasNextInt())
				number = aScanner.nextInt();

			if(number == -9999)
				break;       // end loop and calculate average

			// do not add numbers between 10 and 20 (both inclusive)
			if(number >= 10 && number <= 20) {
				System.out.println("Number " + number + " not used");
				continue;     // go to top of loop
			}

			numbersUsed++;   // count of numbers used
			sum += number;
		}
		aScanner.close();

		double average = 0.0;
		average = sum / numbersUsed;
		System.out.println("Average of " + numbersUsed + " numbers is " + average);
	}

}
