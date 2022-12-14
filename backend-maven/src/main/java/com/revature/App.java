package com.revature;

import com.revature.Enum.SimulationType;
import com.revature.simulation.Simulation;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        switch(args[0]) {
            case "deadlock":
                Simulation circularWaitSimulation = new Simulation(SimulationType.DEADLOCKED);

                circularWaitSimulation.runSimulation();
                break;
            case "solution":
                Simulation deadlockSimulation = new Simulation(SimulationType.SOLUTION);

                deadlockSimulation.runSimulation();
                break;
            case "ordered":
                Simulation orderedSolution = new Simulation(SimulationType.ORDERED);

                orderedSolution.runSimulation();
                break;
            case "livelock":
                Simulation livelockSimulation = new Simulation(SimulationType.LIVELOCK);

               livelockSimulation.runSimulation();
                break;
            default:
                System.out.println("simulation type required");
                break;
        }
    }
}
