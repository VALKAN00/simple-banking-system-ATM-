/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atmproject;

/**
 *
 * @author abdelrhman
 */
public class Customer {
    private String firstname;   
    private String lastname;
    private String birthdate; 
    private Date$ birthdate$; 
    private String phonenumber;
    private String email;
    private String address;
    private Address address$;
    private String postalcode;
    private String userid;
    private String pasword;
    protected double balance;

    public Customer() {
    }

    public Customer(String firstname, String lastname, Date$ birthdate$, String phonenumber, String email, Address address$, String postalcode, String userid, String pasword, double balance) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate$ = birthdate$;
        this.phonenumber = phonenumber;
        this.email = email;
        this.address$ = address$;
        this.postalcode = postalcode;
        this.userid = userid;
        this.pasword = pasword;
        this.balance = balance;
    }

    public Customer(String firstName, String lastName, String email1, String userID, String password) {
    this.firstname=firstName;
    this.lastname=lastName;
    this.email=email1;
    this.userid=userID;
    this.pasword=password;
    }
    
    
    public Customer(String firstname, String lastname, String birthdate, String phonenumber, String email, String address, String postalcode, String userid, String pasword,double balance) {
        this.firstname = firstname;        
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.phonenumber = phonenumber;
        this.email = email;
        this.address = address;
        this.postalcode = postalcode;
        this.userid = userid;
        this.pasword = pasword;
        this.balance=balance;
    }

   

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    

    @Override
    public String toString() {
        return  "First name : " + firstname  + ", Last name : " + lastname + ", Birth date : " + birthdate + ", Phone number : " + phonenumber + ", Email : " + email + ", Address : " + address + ", Postal code : " + postalcode + ", User ID : " + userid + ", Pasword : " + pasword ;
    }



    

    

    
    
}
