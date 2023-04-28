/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;

/**
 *
 * @author yulon
 */
public class Shipment {
    private String shipper;
    private String recipients;
    private int trackingNum;
    private int phoneNum;
    private int driverID;
    private String startAddress;
    private Date startDate;
    private Date arriveDate;   
    private String desAddress;
    private String packageInfo;
    private String status;
    private String shipEmail;
    private String recipientsEmail;
    private ArrayList<String[]> arrivals;

    @Override
    public String toString() {
        return trackingNum + "";
    }

    public Shipment() {
        arrivals = new ArrayList<>();
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }    

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }
    
    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }
    
    public String getDesAddress() {
        return desAddress;
    }

    public void setDesAddress(String desAddress) {
        this.desAddress = desAddress;
    }

    public int getTrackingNum() {
        return trackingNum;
    }

    public void setTrackingNum(int trackingNum) {
        this.trackingNum = trackingNum;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(Date arriveDate) {
        this.arriveDate = arriveDate;
    }


    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPackageInfo() {
        return packageInfo;
    }

    public void setPackageInfo(String packageInfo) {
        this.packageInfo = packageInfo;
    }

    public ArrayList<String[]> getArrivals() {
        return arrivals;
    }

    public void setArrivals(ArrayList<String[]> arrivals) {
        this.arrivals = arrivals;
    }
    
    public String getShipper() {
        return shipper;
    }

    public void setShipper(String shipper) {
        this.shipper = shipper;
    }

    public String getRecipients() {
        return recipients;
    }

    public void setRecipients(String recipients) {
        this.recipients = recipients;
    }

    public String getShipEmail() {
        return shipEmail;
    }

    public void setShipEmail(String shipEmail) {
        this.shipEmail = shipEmail;
    }

    public String getRecipientsEmail() {
        return recipientsEmail;
    }

    public void setRecipientsEmail(String recipientsEmail) {
        this.recipientsEmail = recipientsEmail;
    }

    public void addArrival(String[] list){
        arrivals.add(list);
    }
}
