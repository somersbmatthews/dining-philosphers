package com.revature.dining;

import com.revature.Enum.PhilosopherState;

public class DijkstraPhilosopher extends PhilosopherBase {

    public DijkstraPhilosopher(int num, ChopstickBase left, ChopstickBase right) {
        super(num, left, right);
    }

    @Override
    public void run(){
        while (true) {
            state = PhilosopherState.HUNGRY;
            boolean leftChopstickGrabbed = false;
            boolean rightChopstickGrabbed = false;
            while(!(leftChopstickGrabbed && rightChopstickGrabbed)) {
                if(leftchopstick.tryGrab()) {
                     leftChopstickGrabbed = true;
                    System.out.println("philosopher " + (number+1) + " grabs left chopstick.");
                }
                if(rightchopstick.tryGrab()) {
                    rightChopstickGrabbed = true;
                    System.out.println("philosopher " + (number+1) + " grabs right chopstick.");
                }
            }
            eat();
            leftchopstick.release();
            System.out.println("philosopher " + (number+1) + " releases left chopstick.");
            rightchopstick.release();
            System.out.println("philosopher " + (number+1) + " releases right chopstick.");
        }
    }
}
