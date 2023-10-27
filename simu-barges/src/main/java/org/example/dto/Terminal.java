package org.example.dto;

public class Terminal {
    private String id;
    private int quantity;

    public Terminal(String id){
        this.id = id;
        this.quantity = 10;
    }

    public void addContainer(int  container){
        this.quantity += container;
    }
    public void removeContainer(int container){
        this.quantity -= container;
    }
    public int getQuantity(){
        return quantity;
    }
    @Override
    public String toString() {
        return id;
    }
}
