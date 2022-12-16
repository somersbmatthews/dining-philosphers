package com.revature.dining;

import com.revature.Enum.PhilosopherState;

public class LivelockedPhilosopher extends PhilosopherBase {

    public LivelockedPhilosopher(int num, ChopstickBase left, ChopstickBase right) {
        super(num, left, right);
    }

    @Override
    public void run(){

            // the only different part of the ordered solution is these two lines
            state = PhilosopherState.HUNGRY;
            boolean rightChopstickGrabbed = false;
            boolean leftChopstickGrabbed = false;
            // if philosopher has both chopsticks, exit loop and continue
            while((rightChopstickGrabbed == true && leftChopstickGrabbed == true) == false) {
                // try to grab right chopstick, which at first succeeds
                rightChopstickGrabbed = rightchopstick.tryGrab();
                // try to grab left chopstick, will fail
                System.out.println("philosopher " + (number+1) + " tries to grab left chopstick.");
                leftChopstickGrabbed = leftchopstick.tryGrab();
                if(!leftChopstickGrabbed){
                    System.out.println("left chopstick cannot be grabbed.");
                    // so right chopstick is released
                    rightchopstick.release();
                }
                // tries to grab left chopstick, which succeeds
                leftChopstickGrabbed = leftchopstick.tryGrab();
                // tries to grab right chopstick, which fails
                System.out.println("philosopher " + (number+1) + " tries to grab right chopstick.");
                rightChopstickGrabbed = rightchopstick.tryGrab();
                if(!rightChopstickGrabbed){
                    System.out.println("right chopstick cannot be grabbed.");
                    // left chopstick is released
                    leftchopstick.release();
                }

                System.out.println("The thread for philosopher " + number + " is: " + getState());

        }
            System.out.println("we got here");
    }
}
