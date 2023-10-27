package org.example.manager;

import org.example.dto.DemandList;
import org.example.dto.Service;

import java.util.List;

/**
 * Gère l'ensemble de la simulation
 */
public class SimulationManager {
    private DemandList demandList;
    private List<Service> listService;
    private TimelineManager timelineManager;

    public SimulationManager(String demands, String services) {
        //Charge les deux fichiers passés en paramètres
        demandList = DemandList.createDemandsFromFile(demands);
        listService = Service.servicesFromFile(services);
        //Crée l'échéancier des évenements
        timelineManager = new TimelineManager(demandList, listService);
    }

    /**
     * Gère la simulation
     * @param displayEmptyEvent Vrai si l'on souhaite afficher les demi-journées vides
     */
    public void run(boolean displayEmptyEvent)
    {
        //Lance la simulation
        while (timelineManager.run(displayEmptyEvent)){}
        System.out.println("");
        //Affiche les statistiques de la simulation
        timelineManager.printStats();
    }
}
