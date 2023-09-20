package org.example.dto;

import java.sql.Timestamp;

public class Demand {
    private String origin;
    private String destination;
    private Timestamp startDate;
    private Timestamp endDate;
    private int quantity;

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

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
