package com.amarjefferson.codeabout.java.classes.samples.composition.car;

public class Car {
	String model;
    private Engine engine;
    private Accelerator accelerator;
    private Brake brake;

    private int speed;

    public Car() {
        this("Economy Car", new Engine(1.1, 100));
    }

    public Car(String modelName, Engine anEngine) {
    	this.model = modelName;
        this.engine = anEngine;
        this.accelerator = new Accelerator();
        this.brake = new Brake();
        this.speed = 0;
    }

    public int getSpeed() {
        return speed;
    }

    public void start() {
        engine.start();
    }

    public void turnOff() {
        engine.switchOff();
    }

    public void accelerate(int increaseBy) {
        this.speed = accelerator.press(this.speed, increaseBy);
    }

    public void slowDown(int decreaseBy) {
        this.speed = brake.press(this.speed, decreaseBy);
    }

    @Override
    public String toString() {
        return "Car: " + model + engine;
    }

    public static void main(String[] args) {
        Engine myEngine = new Engine(3.2, 150);
        Car myCar = new Car("Ford Endeavor", myEngine);
        System.out.println(myCar);
        myCar.start();
        myCar.accelerate(10);
        myCar.slowDown(5);
        myCar.turnOff();
    }
}

