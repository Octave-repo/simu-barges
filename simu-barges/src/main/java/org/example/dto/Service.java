package org.example.dto;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Service {
    private static final AtomicInteger atom = new AtomicInteger();
    private String id;
    private Set<String> terminauxDepart;
    private Set<String> terminauxArrive;
    private List<Chemin> chemins;


    public Service (Chemin[] chemins) {
        id = "\033[4m" + "service-" + atom.getAndIncrement() + "\033[0m";
        this.chemins = Arrays.asList(chemins);
        terminauxDepart = new HashSet<>();
        terminauxArrive = new HashSet<>();
        for (Chemin c : chemins){
            terminauxDepart.add(c.getDepart());
            terminauxArrive.add(c.getArrive());
        }
    }
    public static ArrayList<Service> servicesFromFile(String path) {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Service> out = new ArrayList<>();
        try {
            Chemin[][] arrayChemin = objectMapper.readValue(new File(path), Chemin[][].class);
            for (Chemin[] c : arrayChemin)
            {
                out.add(new Service(c));
            }
            return out;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("/!\\ Une erreur est arrivée lors de la lecture du fichier: " + path);
            return null;
        }
    }

    public Chemin getValidChemin(String origine, String destination){
        for (Chemin c : chemins){
            if ((destination.equals(c.getArrive()) && origine.equals(c.getDepart()))) {
                return c;
            }
        }
        return null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<String> getTerminauxDepart() {
        return terminauxDepart;
    }

    public Set<String> getTerminauxArrive() {
        return terminauxArrive;
    }

    public List<Chemin> getChemins() {
        return chemins;
    }

    public void setChemins(List<Chemin> chemins) {
        this.chemins = chemins;
    }
}
