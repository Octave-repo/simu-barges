package org.example.manager;

import org.example.dto.Chemin;
import org.example.dto.Demand;
import org.example.dto.DemandList;
import org.example.dto.Service;
import org.example.events.Event;
import org.example.events.EventList;
import org.example.events.LoadingEvent;
import org.example.events.UnloadingEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * Gère l'échéancier des événements
 */
public class TimelineManager {
    private ArrayList<EventList> eventLists;
    //Représente le 't' actuel
    private int t;
    private int accepted;
    private int notEnoughTime;
    private int noService;
    private int totalDemands;
    private TerminalManager terminalManager;

    /**
     * Ajout un événement dans l'échéhancier
     * @param n événement à ajouter
     */
    private void addNewEventList(int n) {
        if (eventLists.size() <= n) {
            for (int i = eventLists.size(); i <= n; i++) {
                eventLists.add(null);
            }
        }

        if (eventLists.get(n) == null) {
            eventLists.set(n, new EventList());
        }
    }

    /**
     * Crée les événements en fonction d'une demande
     * @param demand la demande
     * @param service le service utilisé par la demande
     */
    private void addEvents(Demand demand, Service service){
        String destination = demand.getDestination();
        String origine = demand.getOrigin();
        Chemin chemin = service.getValidChemin(origine, destination);
        if (chemin == null){
            System.out.println("Aucun chemin valable dans le service: " + service.getId() +
                    " pour la demande : " + demand.getId());
            noService++;
            return;
        }
        int depart = demand.getStartDate();
        //On estime que la simulation est en demi-journée
        int arrive = depart + chemin.getDuree() * 2;
        if (arrive > demand.getEndDate()){
            System.out.println("La demande : " + demand.getId() + " ne pourra pas être satisfaite par manque de temps.");
            notEnoughTime++;
        } else {
            accepted++;
            addNewEventList(depart);
            eventLists.get(depart).getEvents().add(new LoadingEvent(demand.getQuantity(), demand.getOrigin(),
                    terminalManager));
            addNewEventList(arrive);
            eventLists.get(arrive).getEvents().add(new UnloadingEvent(demand.getQuantity(), demand.getDestination(),
                    terminalManager));
        }
    }
    public TimelineManager(DemandList demandList, List<Service> listService){
        t = 0;
        noService = 0;
        notEnoughTime = 0;
        eventLists = new ArrayList<>();
        List<Demand> list = demandList.getList();
        totalDemands = list.size();
        terminalManager = new TerminalManager();

        for (Demand d : list){
            String destination = d.getDestination();
            String origine = d.getOrigin();
            Service service = null;
            for (Service s : listService){
                Set<String> terminauxDepart = s.getTerminauxDepart();
                Set<String> terminauxArrive = s.getTerminauxArrive();
                terminalManager.addTerminals(terminauxDepart);
                terminalManager.addTerminals(terminauxArrive);
                if (terminauxArrive.contains(destination) && terminauxDepart.contains(origine)){
                    service = s;
                    break;
                }
            }
            if (service !=null){
                addEvents(d, service);
            } else {
                noService++;
                System.out.println("Aucun service disponible pour la demande: " + d.getId());
            }
        }
    }

    /**
     * Affiche les statistiques de la simulation
     */
    public void printStats(){
        double tauxAcceptation = (double) accepted / totalDemands * 100;
        double tauxNoService = (double) noService / (noService + notEnoughTime) * 100;
        double tauxNoTime = (double) notEnoughTime / (noService + notEnoughTime) * 100;
        System.out.println("Taux d'acceptation: " + tauxAcceptation +"%");
        System.out.println("Parmis les refus: ");
        System.out.println("- Aucun service: " + tauxNoService +"%" );
        System.out.println("- Pas suffisament de temps: " + tauxNoTime +"%" );
        System.out.println("\nEtat des conteneurs à la fin de la simulation:");
        terminalManager.displayStats();
    }

    /**
     * Execute les événements de l'échéancier
     * @param displayEmptyEvent si vrai, on affiche les événements "vide"
     * @return si la simulation est terminée ou non
     */
    public boolean run(boolean displayEmptyEvent){
        if (t >= eventLists.size()){
            System.out.println("\nPlus aucun évenement disponible.");
            return false;
        }
        EventList events = eventLists.get(t);
        if (events == null){
            if (displayEmptyEvent)
                System.out.println("Aucun evenement disponible au temps t: " + t);
            t++;
            return true;
        }
        List<Event> list = eventLists.get(t).getEvents();
        System.out.println("\nEvenements au temps t: " + t);
        System.out.println("----------------------------");
        for (Event event : list)
        {
            event.run();
        }
        t++;
        return true;
    }
}
