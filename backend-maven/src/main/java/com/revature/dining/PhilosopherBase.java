package com.revature.dining;

import com.revature.Enum.PhilosopherState;

import java.util.concurrent.ThreadLocalRandom;

public class PhilosopherBase extends Thread {
    static final int ceilingEatingTime = 4000;
    protected int number;

    PhilosopherState state = PhilosopherState.THINKING;
    protected ChopstickBase leftchopstick;
    protected ChopstickBase rightchopstick;

    public PhilosopherBase(int num, ChopstickBase left, ChopstickBase right) {
        number = num;
        leftchopstick = left;
        rightchopstick = right;
    }

    protected void eat() {
        try {
            state = PhilosopherState.EATING;

            int eatingTime = ThreadLocalRandom.current().nextInt(0, ceilingEatingTime);
            float eatingTimeInSeconds = (float) eatingTime / 1000f;
            System.out.println("philosopher " + (number+1) + " eats for " + eatingTimeInSeconds + " seconds.");
            Thread.sleep(eatingTime);
            state = PhilosopherState.THINKING;

        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected void think(int thinkingDuration) {
        try {

            Thread.sleep(thinkingDuration);
        } catch(InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
