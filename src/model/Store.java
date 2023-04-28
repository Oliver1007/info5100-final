/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Store extends User {
    
    private String Type;

    public ArrayList<Shipment> getShipments() {
        return shipments;
    }

    public void setShipments(ArrayList<Shipment> shipments) {
        this.shipments = shipments;
    }
    private ArrayList<Shipment> shipments;

    

    @Override
    public String getType() {
        return Type;
    }

    @Override
    public void setType(String Type) {
        this.Type = Type;
    }
   
}
