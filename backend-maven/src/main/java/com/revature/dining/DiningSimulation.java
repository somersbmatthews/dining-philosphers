package com.revature.dining;

public class DiningSimulation {
    int numOfPhilosophers = 5;
    Philosopher philosophers[] = new Philosopher[numOfPhilosophers];
    Chopstick chopsticks[] = new Chopstick[numOfPhilosophers];

    public void runSimulation() {
        for (int i = 0; i < numOfPhilosophers; i++) {
            chopsticks[i] = new Chopstick();
        }

        for (int i = 0; i < numOfPhilosophers; i++) {
            philosophers[i] = new Philosopher(i, chopsticks[i], chopsticks[(i + 1) % numOfPhilosophers]);
            philosophers[i].start();

        }

        while (true) {
            try {
                // sleep 1 sec
                Thread.sleep(1000);

//                for(int i = 0; i < numOfPhilosophers; i++) {
//                    System.out.println(" The state of philosopher " + i + " is: " + philosophers[i].getState().toString());
//                }
                // check for deadlock
                boolean deadlock = true;
                for (Chopstick f : chopsticks) {
                    if (f.isFree()) {
                        deadlock = false;
                        break;
                    }
                }
                if (deadlock) {
                    Thread.sleep(1000);
                    System.out.println("Everyone Eats");
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }

        System.out.println("Exit The Program!");
        System.exit(0);
    }
}
