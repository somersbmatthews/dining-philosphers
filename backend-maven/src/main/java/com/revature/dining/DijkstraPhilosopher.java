package com.revature.dining;

import com.revature.Enum.PhilosopherState;

import java.util.concurrent.ThreadLocalRandom;

public class DijkstraPhilosopher extends PhilosopherBase {

    public DijkstraPhilosopher(int num, ChopstickBase left, ChopstickBase right) {
        super(num, left, right);
    }

    @Override
    public void run(){
        while (true) {
            // the only different part of the dijkstra's solution is these two lines
            int thinkingTime = ThreadLocalRandom.current().nextInt(0, 3000);
            think(thinkingTime);
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
