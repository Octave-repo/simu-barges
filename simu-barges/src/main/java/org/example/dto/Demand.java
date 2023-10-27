package org.example.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;
import java.util.concurrent.atomic.AtomicInteger;

public class Demand {
    private String origin;
    private String destination;
    private int startDate;
    private int endDate;
    private int quantity;
    @JsonIgnore
    private String id;
    @JsonIgnore
    private static final AtomicInteger atom = new AtomicInteger();

    public Demand() {
        this.id = "\033[4m" + "demand-" + atom.getAndIncrement() + "\033[0m";
    }

    @Override
    public String toString() {
        return "Origine: " + origin + " ; Destination: " + destination + " ; Date de départ: " + startDate
                + " ; Date d'arrivé: " + startDate + " ; Date de fin: " + " ; Quantité: " + quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }
}
