/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author yulon
 */
public class ShipmentDirectory {
    private ArrayList<Shipment> shipment;
    
    private static volatile ShipmentDirectory instance = null;

    private ShipmentDirectory() {
        shipment = new ArrayList<>();
    }
    
    public static ShipmentDirectory getInstance(){
        if(instance == null){
            synchronized(ShipmentDirectory.class){
                if(instance == null){
                    instance = new ShipmentDirectory();
                }
            }
        }
        return instance;
    }
    
    public ArrayList<Shipment> getShipment() {
        return shipment;
    }

    public void setShipment(ArrayList<Shipment> Shipment) {
        this.shipment = Shipment;
    }
    
    public void addShipment(Shipment ship){
        this.shipment.add(ship);
    }
}
