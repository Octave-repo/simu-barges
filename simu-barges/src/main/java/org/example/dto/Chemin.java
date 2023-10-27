package org.example.dto;

public class Chemin {
    private String depart;
    private String arrive;

    private int duree;

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getArrive() {
        return arrive;
    }

    public void setArrive(String arrive) {
        this.arrive = arrive;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    @Override
    public String toString() {
        return "Chemin{" +
                "depart='" + depart + '\'' +
                ", arrive='" + arrive + '\'' +
                ", duree=" + duree +
                '}';
    }
}
