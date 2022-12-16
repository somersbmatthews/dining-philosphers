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
            // grabs the left one, succeeds
            leftchopstick.grab();
            System.out.println("philosopher " + (number+1) + " grabs left chopstick.");
            // grabs the right one, fails and waits forever until it is available, deadlock, circular wait condition
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
