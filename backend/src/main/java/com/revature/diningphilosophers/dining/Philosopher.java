package com.revature.diningphilosophers.dining;

import java.util.concurrent.ThreadLocalRandom;

public class Philosopher extends Thread {
    public int number;
    public Chopstick leftchopstick;
    public Chopstick rightchopstick;

    Philosopher(int num, Chopstick left, Chopstick right) {
        number = num;
        leftchopstick = left;
        rightchopstick = right;
    }

    public void run(){

        while (true) {
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

    void eat() {
        try {
            int sleepTime = ThreadLocalRandom.current().nextInt(0, 1000);
            System.out.println("philosopher " + (number+1) + " eats for " + sleepTime);
            Thread.sleep(sleepTime);
        }
        catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
