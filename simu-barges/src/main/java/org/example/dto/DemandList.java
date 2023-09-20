package org.example.dto;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class DemandList {
    private List<Demand> list;

    public DemandList(Demand[] demands){
        list = Arrays.asList(demands);
    }
    public static DemandList createDemandsFromFile(String path){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Demand[] demands = objectMapper.readValue(new File(path), Demand[].class);
            return new DemandList(demands);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("/!\\ Une erreur est arrivée lors de la lecture du fichier: " + path);
            return null;
        }
    }

    @Override
    public String toString() {
        return "DemandList{" +
                "list=" + list +
                '}';
    }
}
