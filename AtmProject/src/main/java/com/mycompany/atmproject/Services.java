/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.atmproject;

/**
 *
 * @author abdelrhman
 */
public interface Services {
    
    double withdraw(double amount);
    double deposite(double amount);
    double Transaction(double amount,int transferID);
    void checkbalance();
    void accountdetails(Customer user);
}
