/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atmproject;

/**
 *
 * @author abdelrhman
 */
public class Address {
    private String country;
    private String government;
    private String regoin;
    private String streetname;

    public Address() {
    }

    public Address(String country, String government, String regoin, String streetname) {
        this.country = country;
        this.government = government;
        this.regoin = regoin;
        this.streetname = streetname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGovernment() {
        return government;
    }

    public void setGovernment(String government) {
        this.government = government;
    }

    public String getRegoin() {
        return regoin;
    }

    public void setRegoin(String regoin) {
        this.regoin = regoin;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    @Override
    public String toString() {
        return "Address{" + "country=" + country + ", government=" + government + ", regoin=" + regoin + ", streetname=" + streetname + '}';
    }
    
}
