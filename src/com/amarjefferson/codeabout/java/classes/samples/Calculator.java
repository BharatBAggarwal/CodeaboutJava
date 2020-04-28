package com.amarjefferson.codeabout.java.classes.samples;
import java.util.Scanner;

/**
 * 
 * File Name: Calculator.java
 *
 * Package: com.amarjefferson.codeabout.java.classes.exercises
 *
 * Problem Statement:
 * Build a Simple Calculator
 * 
 * Class Name: Calculator
 * 
 * Data Members:
 * double op1         // operand 1
 * double op2         // operand 2
 * double result      // result
 * 
 * Member Functions:
 * Default constructor
 * Parameterized constructor
 * double add()
 * double subtract()
 * double multiply()
 * double divide()
 * double sin()
 * double cos()
 * double floor()
 * double ceil()
 * double max()
 * double min()
 * double getOp1()
 * double getOp2()
 * void setOp1(double value1)
 * void setOp2(double value 2)
 * void clear()
 * 
 * Display results using the following format:
 * Result: Divide(10.0, 4.0) = 2.5
 * 
 * Class Use:
 * Write a main() method which creates an object of the above class
 * and calls all the methods
 */
public class Calculator {
	private double operand1,        // operand 1
	               operand2,        // operand 2
	               result;          // result
	private String operation;
	private String firstLabel;
	private String secondLabel;
	private boolean singleOperand;
	private Scanner scn = new Scanner(System.in);
	
	Calculator() {                                       
		this(0.0, 0.0);
	}          

	Calculator(double value1, double value2) { 
		clear();
		this.operand1 = value1;
		this.operand2 = value2;
	}                                         

	public double add() {                                    
		this.operation = "Add";
		firstLabel = "first number";
		secondLabel = "number to add";
		this.singleOperand = false;
		inputOperands();
		this.result = this.operand1 + this.operand2;                  
		return this.result;  
	}

	public double subtract() {
		this.operation = "Subtract";
		this.singleOperand = false;
		firstLabel = "first number";
		secondLabel = "number to subtract";
		inputOperands();
		this.result = this.operand1 - this.operand2;                  
		return this.result;  
	}

	public double multiply() {
		this.operation = "Multiply";
		this.singleOperand = false;
		firstLabel = "first number";
		secondLabel = "number to multiply with";
		inputOperands();
		this.result = this.operand1 * this.operand2;
		return this.result;                  
	}

	public double divide() {
		this.operation = "Divide";
		this.singleOperand = false;
		firstLabel = "first number";
		secondLabel = "number to divide with";
		inputOperands();
		this.result = this.operand1 / this.operand2;
		return this.result;                  
	}

	public double sin() {
		this.operation = "sin";
		this.singleOperand = true;
		firstLabel = "angle in Degrees";
		secondLabel = "";
		inputOperands();
		this.result = Math.sin(Math.toRadians(this.operand1));
		return this.result;                  
	}

	public double cos() {
		this.operation = "cos";
		this.singleOperand = true;
		firstLabel = "angle in Degrees";
		secondLabel = "";
		inputOperands();
		this.result = Math.cos(Math.toRadians(this.operand1));
		return this.result;                  
	}

	public double floor() {
		this.operation = "floor";
		this.singleOperand = true;
		firstLabel = "a double number";
		secondLabel = "";
		inputOperands();
		this.result = Math.floor(this.operand1);
		return this.result;                  
	}

	public double ceil() {
		this.operation = "ceil";
		this.singleOperand = true;
		firstLabel = "a double number";
		secondLabel = "";
		inputOperands();
		this.result = Math.ceil(this.operand1);
		return this.result;                  
	}

	public double max() {
		this.operation = "max";
		this.singleOperand = false;
		firstLabel = "first number";
		secondLabel = "second number";
		inputOperands();
		this.result = Math.max(this.operand1, this.operand2);
		return this.result;                  
	}

	public double min() {
		this.operation = "min";
		this.singleOperand = false;
		firstLabel = "first number";
		secondLabel = "second number";
		inputOperands();
		this.result = Math.min(this.operand1, this.operand2);
		return this.result;                  
	}

	public void clear() {
		this.operand1 = 0.0;
		this.operand2 = 0.0;
		this.result = 0.0;
		this.operation = "None";
		this.singleOperand = false;
		firstLabel = "";
		secondLabel = "";
	}
	
	public void inputOperands() {
		this.result = 0.0;

		System.out.println("Calculator - " + this.operation + ":\n");
		System.out.println("Enter " + this.firstLabel + ":");
		if(this.scn.hasNextDouble()) {
			this.operand1 = scn.nextDouble();
		}

		if(this.singleOperand) {
			this.operand2 = 0.0;
			return;
		}
		
		System.out.println("Enter " + this.secondLabel + ":");
		if(this.scn.hasNextDouble()) {
			this.operand2 = scn.nextDouble();
		}
	}
	
	@Override
	public String toString() {
		String str = "Result: " + this.operation + "(" + this.operand1;

		if(!this.singleOperand)
			str += ", " + this.operand2;

		str += ") = " + this.result;
		return str;
	}

	public static void main(String[] args) {   
		Calculator myCalc = new Calculator();

		Scanner scn = new Scanner(System.in);
		int choice = 0;
		while(true) {
			System.out.println("MENU OPTIONS");
			System.out.println("************");
			System.out.println("Press 0. To Exit");
			System.out.println("Press 1. To add two numbers");
			System.out.println("Press 2. To subtract two numbers");
			System.out.println("Press 3. To multiply two numbers");
			System.out.println("Press 4. To divide two numbers");
			System.out.println("Press 5. To calculate sin of an angle");
			System.out.println("Press 6. To calculate cos of an angle");
			System.out.println("Press 7. To find the floor of a given value");
			System.out.println("Press 8. To find the ceil of a given value");
			System.out.println("Press 9. To find the maximum of two values");
			System.out.println("Press 10. To find the minimum of two values");
			System.out.println("Enter Your Choice");

			if(scn.hasNextInt())
				choice = scn.nextInt();

			switch(choice ) {

			case 0:
				scn.close();
				return;

			case 1:
				myCalc.add();
				break;		

			case 2:
				myCalc.subtract();
				break;		

			case 3:
				myCalc.multiply();
				break;		

			case 4:
				myCalc.divide();
				break;		

			case 5:
				myCalc.sin();
				break;		

			case 6:
				myCalc.cos();
				break;		

			case 7:
				myCalc.floor();
				break;		

			case 8:
				myCalc.ceil();
				break;		

			case 9:
				myCalc.max();
				break;		

			case 10:
				myCalc.min();
				break;		
			}
			System.out.println(myCalc);
		}
	}  
}

