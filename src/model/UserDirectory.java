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
public class UserDirectory {
    private ArrayList<User> users;
    
    private static volatile UserDirectory instance = null;

    private UserDirectory() {
        users = new ArrayList<>();
    }
    
    public static UserDirectory getInstance(){
        if(instance == null){
            synchronized(UserDirectory.class){
                if(instance == null){
                    instance = new UserDirectory();
                }
            }
        }
        return instance;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
    
    public void addUser(User u){
        this.users.add(u);
    }
    
    public void removeUser(User u){
        this.users.remove(u);
    }
}
