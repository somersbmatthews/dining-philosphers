package com.revature.dining;

import com.revature.Enum.PhilosopherState;

import java.util.concurrent.ThreadLocalRandom;

public class OrderedPhilosopher extends PhilosopherBase {

    public OrderedPhilosopher(int num, ChopstickBase left, ChopstickBase right) {
        super(num, left, right);
    }

    @Override
    public void run(){
        while (true) {
            // the only different part of the ordered solution is these two lines
            try {
                Thread.sleep(1000 * number); // starts in order of number id
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            state = PhilosopherState.HUNGRY;
            leftchopstick.grab();
            System.out.println("philosopher " + (number+1) + " grabs left chopstick.");
            rightchopstick.grab();
            System.out.println("philosopher " + (number+1) + " grabs right chopstick.");
            eat();
            leftchopstick.release();
            System.out.println("philosopher " + (number+1) + " releases left chopstick.");
            rightchopstick.release();
            System.out.println("philosopher " + (number+1) + " releases right chopstick.");
        }
    }
}
