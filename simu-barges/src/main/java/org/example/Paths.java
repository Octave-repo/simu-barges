package org.example;

/**
 * Chemins des différents fichiers JSON
 */
public enum Paths {
    DEMANDS("src/main/resources/demands.json"),
    ITINERARY("src/main/resources/itinerary.json");
    public final String value;
    Paths(String value){
        this.value = value;
    }
}
