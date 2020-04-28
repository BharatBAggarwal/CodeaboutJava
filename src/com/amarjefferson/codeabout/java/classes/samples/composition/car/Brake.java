package com.amarjefferson.codeabout.java.classes.samples.composition.car;

public class Brake {
    public Brake() {

    }

    public int press(int speed, int changeBy) {
        int temp = speed - changeBy;
        if (temp < 0)
            temp = 0;
        System.out.println("Break applied: Car speed now is " + temp);
        return temp;
    }
}
