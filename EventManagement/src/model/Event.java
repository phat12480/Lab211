/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class Event implements Serializable{
    private String name;
    private String date;
    private String location;
    private int numberAttendes;
    private String status;
    private String ID;
    private String host;
    
    
//constructors

    public Event(String name, String date, String location, int numberAttendes, String status, String ID, String host) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.numberAttendes = numberAttendes;
        this.status = status;
        this.ID = ID;
        this.host = host;
    }




    public Event() {
    }

    public Event(String ID, String name, String date, String location, int numberAttendes, String status) {
        
        this.ID = ID;
        this.name = name;
        this.date = date;
        this.location = location;
        this.numberAttendes = numberAttendes;
        this.status = status;
    }
//getter and setter

    public Event(String name, String date, String location, int numberAttendes, String status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;

    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumberAttendes() {
        return numberAttendes;
    }

    public void setNumberAttendes(int numberAttendes) {
        this.numberAttendes = numberAttendes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

//tostring    
    @Override
    public String toString() {
        return String.format("|  %-12s|  %-12s|  %-12s|    %-10s|  %-15s      |  %11s     | %11s  |",ID, name, date, location, numberAttendes, status,host );
    }
    
}
