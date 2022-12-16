package com.revature.simulation;

import com.revature.Enum.SimulationType;
import com.revature.dining.ChopstickWithMutex;
import com.revature.dining.DijkstraPhilosopher;
import com.revature.dining.Philosopher;
import com.revature.dining.PhilosopherBase;
import sun.reflect.annotation.EnumConstantNotPresentExceptionProxy;

public class Simulation {
    int numOfPhilosophers = 5;
    private PhilosopherBase philosophers[];
    private ChopstickWithMutex chopstickWithMutexes[];
    public Simulation(SimulationType simulationType) {
        switch(simulationType) {
            case DEADLOCKED:
                philosophers         = new Philosopher[numOfPhilosophers];
                chopstickWithMutexes = new ChopstickWithMutex[numOfPhilosophers];
                break;
            case SOLUTION:
                philosophers         = new DijkstraPhilosopher[numOfPhilosophers];
                chopstickWithMutexes = new ChopstickWithMutex[numOfPhilosophers];
        }
    }

    public void runSimulation() {
        for (int i = 0; i < numOfPhilosophers; i++) {
            chopstickWithMutexes[i] = new ChopstickWithMutex();
        }

        for (int i = 0; i < numOfPhilosophers; i++) {
            philosophers[i] = new Philosopher(i, chopstickWithMutexes[i], chopstickWithMutexes[(i + 1) % numOfPhilosophers]);
            philosophers[i].start();

        }
        int simulationRuns = 10;
        while (true) {
            try {
                // sleep 1 sec
                Thread.sleep(1000);
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
//        System.exit(0);
    }
}
