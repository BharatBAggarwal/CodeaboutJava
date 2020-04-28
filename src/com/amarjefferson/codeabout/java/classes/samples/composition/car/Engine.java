package com.amarjefferson.codeabout.java.classes.samples.composition.car;

public class Engine {
    private double size;
    private int power;
    private boolean isRunning;

    public Engine(double volume, int hp) {
        this.size = volume;
        this.power = hp;
        this.isRunning = false;
    }

    public double getSize() {
        return size;
    }

    public int getPower() {
        return power;
    }

    public void start() {
        this.isRunning = true;
        System.out.println("The engine has been started");
    }

    public void switchOff() {
        this.isRunning = false;
        System.out.println("The engine has been turned off");
    }

    @Override
    public String toString() {
        return " {Engine Size: " + size + "l, Power: " + power  + "HP}";
    }

}
