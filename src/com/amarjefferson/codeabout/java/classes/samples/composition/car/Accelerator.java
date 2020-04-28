package com.amarjefferson.codeabout.java.classes.samples.composition.car;

public class Accelerator {
    public Accelerator() {

    }

    public int press(int speed, int changeBy) {
        int temp = speed + changeBy;
        System.out.println("Accelerator pressed: Car speed now is " + temp);
        return temp;
    }

}
