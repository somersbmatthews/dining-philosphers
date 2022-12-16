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
            default:
                System.out.println("simulation type required");
                break;
        }
    }
}
