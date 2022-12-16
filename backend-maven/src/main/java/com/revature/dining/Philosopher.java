package com.revature.dining;

import com.revature.Enum.PhilosopherState;

import java.util.concurrent.ThreadLocalRandom;

public class Philosopher extends PhilosopherBase {


    public Philosopher(int num, ChopstickBase left, ChopstickBase right) {
        super(num, left, right);
    }

    @Override
    public void run(){
        while (true) {

            state = PhilosopherState.HUNGRY;

            leftchopstick.grab();
            System.out.println("philosopher " + (number+1) + " grabs left chopstick.");

            rightchopstick.grab();
            System.out.println("philosopher " + (number+1) + " grabs right chopstick.");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            eat();
            leftchopstick.release();
            System.out.println("philosopher " + (number+1) + " releases left chopstick.");
            rightchopstick.release();
            System.out.println("philosopher " + (number+1) + " releases right chopstick.");
        }
    }





}
