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
            // if both are true, exit loop and continue
            while((rightChopstickGrabbed == true && leftChopstickGrabbed == true) == false) {
                System.out.println("philosopher " + (number+1) + " grabs left chopstick.");

                leftChopstickGrabbed = leftchopstick.tryGrab();
                if(!leftChopstickGrabbed){
                    System.out.println("left chopstick cannot be grabbed.");
                    rightchopstick.release();
                }

//                leftChopstickGrabbed = false;
//                System.out.println("philosopher " + (number+1) + " grabs right chopstick.");
                rightChopstickGrabbed = rightchopstick.tryGrab();
                if(!rightChopstickGrabbed){
                    System.out.println("right chopstick cannot be grabbed.");
                   leftchopstick.release();
                }
                System.out.println("The thread for philosopher " + number + " is: " + getState());

        }
            System.out.println("we got here");
    }
}
