/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author yulon
 */
public class NumberDirectory {
    
    private ArrayList<Integer> referenceNumbers;
    private ArrayList<Integer> IDs;
    
    private static volatile NumberDirectory instance = null;

    private NumberDirectory() {
        referenceNumbers = new ArrayList<>();
        IDs = new ArrayList<>();
    }
    
    public static NumberDirectory getInstance(){
        if(instance == null){
            synchronized(NumberDirectory.class){
                if(instance == null){
                    instance = new NumberDirectory();
                }
            }
        }
        return instance;
    }

    public int generateID(){
        Random rd = new Random();
        int id = rd.nextInt(10000);
        while(IDs.contains(id)) id = rd.nextInt(10000);
        IDs.add(id);
        return id;
    }
    
    public int generateRefNum(){
        Random rd = new Random();
        int refNum = rd.nextInt(1000000);
        while(referenceNumbers.contains(refNum)) refNum = rd.nextInt(10000);
        referenceNumbers.add(refNum);
        return refNum;
    }
    
    public ArrayList<Integer> getReferenceNumbers() {
        return referenceNumbers;
    }

    public void setReferenceNumbers(ArrayList<Integer> referenceNumbers) {
        this.referenceNumbers = referenceNumbers;
    }

    public ArrayList<Integer> getIDs() {
        return IDs;
    }

    public void setIDs(ArrayList<Integer> IDs) {
        this.IDs = IDs;
    }
    
}
