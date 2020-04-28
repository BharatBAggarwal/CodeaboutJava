package com.amarjefferson.codeabout.java.classes.samples;

import java.util.Scanner;

/**
 * 
 * File Name: Calculator.java
 *
 * Package: com.amarjefferson.codeabout.java.classes.exercises
 *
 * Problem Statement:
 * Build a Simple Phone
 * 
 * Class Name: Phone
 * 
 * Functions to be implemented:
 *  Make phone calls
 *     Telephone number
 *  Send text messages
 *     Telephone number
 *     Text message
 *  Take a photo
 *     Photo caption
 *
 * The phone collects the following usage data:
 *  Number of phone calls made
 *  Number of messages sent
 *  Number of photos taken
 *  Details of last phone call
 *  Details of last message sent
 *  Details of last photo taken
 *  
 * Class Use:
 * Write a main() method which creates an object of the above class
 * and calls all the methods
 */
public class Phone {

    // static class members
	public static enum Operations { CALL, SMS, PHOTO };
	
    private static int numberOfCalls = 0;
    private static int numberOfMessages = 0;
    private static int numberOfPhotos = 0;

    public static int getNumberOfCalls() {
        return numberOfCalls;
    }

    public static int getNumberOfMessages() {
        return numberOfMessages;
    }

    public static int getNumberOfPhotos() {
        return numberOfPhotos;
    }

    // instance variables
    private String phoneNumber;
    private String messageNumber;
    private String textMessage;
    private String photoCaption;
    private boolean photoTaken;
    private boolean messageSent;
    private boolean callMade;
    private Scanner scn = new Scanner(System.in);

    // constructor
    public Phone() {
        phoneNumber = "";
        textMessage = "";
        photoCaption = "";
        photoTaken = false;
        messageSent = false;
        callMade = false;
    }

    private boolean doYouWantTo(String action) {
        System.out.println("Do you want to " + action + "?");
        if(scn.hasNextBoolean())
           return scn.nextBoolean();

        return false;
    }
    
    // getters and setters
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    private void setPhoneNumber(Operations op) {
        System.out.println("Enter Phone Number:");
        
        if(op == Operations.CALL) {
            this.callMade = false;
            if(scn.hasNext())
                this.phoneNumber = scn.next();
        }
        else if (op == Operations.SMS) {
        	this.messageSent = false;
            if(scn.hasNext())
                this.messageNumber = scn.next();
        }
        
    }

    public String getTextMessage() {
        return this.textMessage;
    }

    private void setTextMessage() {
        System.out.println("Enter Text Message:");
        if(scn.hasNext())
            this.textMessage = scn.next() + scn.nextLine();
    }

    public String getPhotoCaption() {
        return this.photoCaption;
    }

    private void setPhotoCaption() {
        this.photoTaken = false;
        System.out.println("Enter Caption for Photo:");
        if(scn.hasNext())
            this.photoCaption = scn.nextLine() + scn.nextLine();
    }

   public boolean isPhotoTaken() {
        return photoTaken;
    }

    public boolean isMessageSent() {
        return messageSent;
    }

    public boolean isCallMade() {
        return callMade;
    }

    // action methods
    private void dial() {
        System.out.println("Calling " + this.phoneNumber);
        numberOfCalls++;
        this.callMade = true;
    }

    private void sms() {
        System.out.println("Sending SMS \"" + this.textMessage + "\" to " + this.phoneNumber);
        numberOfMessages++;
        this.messageSent = true;
    }

    private void click() {
        System.out.println("Taking Photo: " + this.photoCaption);
        numberOfPhotos++;
        this.photoTaken = true;
    }

    public void makeACall() {
        // making a phone call
    	if( doYouWantTo("make a phone call") ) {
    		setPhoneNumber(Operations.CALL);
    		dial();
    	}
    }

    public void sendAMessage() {
        // sending text message
    	if( doYouWantTo("send a message") ) {
    		setPhoneNumber(Operations.SMS);
    		setTextMessage();
    		sms();
    	}
    }

    public void takeAPhoto() {
        // Taking a photo
    	if( doYouWantTo("take a photo") ) {
    		setPhotoCaption();
    		click();
    	}
    }

    @Override
    public String toString() {
    	String str = "\nHistory of Phone Usage\n" +
                     "---------------------\n\n";
    	String history = "Total number of calls: " + numberOfCalls + "\n" +
    			         "Total number of messages: " + numberOfMessages + "\n" +
    			         "Total number of photos: " + numberOfPhotos + "\n\n";

    				 if(this.callMade)
    			    	 history += "Last call made to " + this.phoneNumber + "\n";
        			 if(this.messageSent)
    			    	 history += "Last message \"" + this.getTextMessage() +
    			    	            "\" sent to " + this.messageNumber + "\n";
        			 if(this.photoTaken)
    			    	 history += "Last photo taken: " + this.getPhotoCaption() + "\n";
        return str + history;
    }

    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String response = "";
        Phone myPhone = new Phone();

        while(true) {
            // make a phone call
            myPhone.makeACall();

            // send a text message
            myPhone.sendAMessage();

            // Take a photo
            myPhone.takeAPhoto();
            
            // query if the user wants to continue
            System.out.println("Continue using the phone? (y/n)");
            if(scn.hasNext())
                response = scn.nextLine();

            if(response.startsWith("n") || response.startsWith("N")) {
                scn.close();
                System.out.println(myPhone);
                break;
            }
            
            response = "";
        }
       
    }

}
