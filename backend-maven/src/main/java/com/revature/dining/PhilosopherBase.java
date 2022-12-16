package com.revature.dining;

import com.revature.Enum.PhilosopherState;

import java.util.concurrent.ThreadLocalRandom;

public class PhilosopherBase extends Thread {
    static final int ceilingEatingTime = 4000;
    public int number;

    PhilosopherState state = PhilosopherState.THINKING;
    public ChopstickBase leftchopstick;
    public ChopstickBase rightchopstick;

    public PhilosopherBase(int num, ChopstickBase left, ChopstickBase right) {
        number = num;
        leftchopstick = left;
        rightchopstick = right;
    }

    void eat() {
        try {
            state = PhilosopherState.EATING;

            int eatingTime = ThreadLocalRandom.current().nextInt(0, ceilingEatingTime);
            System.out.println("philosopher " + (number+1) + " eats for " + eatingTime/1000 + " seconds.");
            Thread.sleep(eatingTime);
            state = PhilosopherState.THINKING;

        }
        catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
