package com.revature.simulation;

import com.revature.Enum.SimulationType;
import com.revature.dining.Chopstick;
import com.revature.dining.DijkstraPhilosopher;
import com.revature.dining.Philosopher;
import com.revature.dining.PhilosopherBase;

public class Simulation {
    static int simulationRuns = 10;
    static final int numOfPhilosophers = 5;
    private PhilosopherBase philosophers[];
    private Chopstick chopsticks[] = new Chopstick[numOfPhilosophers];;
    public Simulation(SimulationType simulationType) {
        for(int i = 0; i < numOfPhilosophers; i++) {
            chopsticks[i] = new Chopstick();
        }
        switch(simulationType) {
            case DEADLOCKED:
                philosophers         = new Philosopher[numOfPhilosophers];
                for (int i = 0; i < numOfPhilosophers; i++) {
                    philosophers[i] = new Philosopher(i, chopsticks[i], chopsticks[(i + 1) % numOfPhilosophers]);
                }
                break;
            case SOLUTION:
                philosophers         = new DijkstraPhilosopher[numOfPhilosophers];
                for (int i = 0; i < numOfPhilosophers; i++) {
                    philosophers[i] = new DijkstraPhilosopher(i, chopsticks[i], chopsticks[(i + 1) % numOfPhilosophers]);
                }
                break;
        }
    }

    public void runSimulation() {


        for (int i = 0; i < numOfPhilosophers; i++) {
            philosophers[i].start();
        }
       threadMonitor();
    }

    private void threadMonitor() {
        while (true) {
            try {
                // sleep 1 sec
                Thread.sleep(300);
                int deadLockedThreads = 0;
                for(int i = 0; i < numOfPhilosophers; i++) {
                    Thread.State threadState = philosophers[i].getState();
                    System.out.println(" The state of philosopher " + i + " is: " + threadState);
                    if(threadState ==Thread.State.WAITING ) {
                        deadLockedThreads++;
                    }
                }
                if(deadLockedThreads == 5) {
                    System.out.println("All threads are waiting, circular wait condition, DEADLOCK!");
                    break;
                }
                if(simulationRuns == 0){
                    break;
                } else {
                    simulationRuns--;
                }
                deadLockedThreads = 0;
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
    }
}
