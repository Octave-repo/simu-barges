package org.example;

import org.example.dto.DemandList;

public class Main {
    //Teste la création / le format d'une demande
    public static void testerCreationDemandes(){
        DemandList list = DemandList.createDemandsFromFile("src/main/resources/demands.json");
        System.out.println(list.toString());
    }
    public static void main(String[] args) {
        testerCreationDemandes();

    }
}