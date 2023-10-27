package org.example;

import org.example.manager.SimulationManager;


public class Main {
    public static void main(String[] args) {
        //Crée et lance la simulation
        SimulationManager simu = new SimulationManager(Paths.DEMANDS.value, Paths.ITINERARY.value);
        simu.run(false);
    }
}