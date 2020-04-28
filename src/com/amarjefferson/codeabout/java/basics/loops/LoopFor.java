package com.amarjefferson.codeabout.java.basics.loops;
import java.util.Scanner;

/**
 * File Name: LoopFor.java
 *
 * Package: com.amarjefferson.codeabout.java.basics.loops
 * Class: LoopFor
 *
 */
public class LoopFor {

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
		for(int i = 0; i < howMany; ++i) {
			System.out.print("Input number # " +  (i+1) + ": ");
			if(aScanner.hasNextInt())
				number = aScanner.nextInt();

			sum += number;
		}
		aScanner.close();

		double average = 0.0;
		average = sum / howMany;
		System.out.println("Average is " + average);
	}
}
