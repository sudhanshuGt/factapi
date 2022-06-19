package com.factapi.factapi.factentities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class usersData {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String ipAddress;
    private String fact;
    private String time;

    
    

    public String getIpAddress() {
        return ipAddress;
    }


    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }


    public String getFact() {
        return fact;
    }


    public void setFact(String fact) {
        this.fact = fact;
    }


    public String getTime() {
        return time;
    }


    public void setTime(String time) {
        this.time = time;
    }


    public usersData( String ipAddress, String fact, String time) {

        this.ipAddress = ipAddress;
        this.fact = fact;
        this.time = time;
    }

    public usersData(){
       
    }
    
}
