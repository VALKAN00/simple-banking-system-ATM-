/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atmproject;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author abdelrhman
 */
public class AtmProject {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Customer> user = new ArrayList<Customer>();
        OUTER:
        while (true) {
            System.out.println("choose: \n1 for registration \n2 for login\n3 for exit");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    System.out.println("enter the birth date :");
                    System.out.print("day : ");
                    int day = sc.nextInt();
                    System.out.print("month : ");
                    int month = sc.nextInt();
                    System.out.print("year : ");
                    int year = sc.nextInt();
                    Date$ birth = new Date$(day, month, year);
                    System.out.println("");
                    System.out.print("country : ");
                    String country = sc.next();
                    System.out.print("government : ");
                    String government = sc.next();
                    System.out.print("region : ");
                    String region = sc.next();
                    System.out.print("street name : ");
                    String street = sc.next();
                    Address add = new Address(country, government, region, street);
                    System.out.println("");
                    System.out.print("first name : ");
                    String first = sc.next();
                    System.out.print("last name : ");
                    String last = sc.next();
                    System.out.print("phone number : ");
                    String phone = sc.next();
                    System.out.print("email : ");
                    String email = sc.next();
                    System.out.print("postal code : ");
                    String postal = sc.next();
                    System.out.print("user ID : ");
                    String userid = sc.next();
                    System.out.print("password : ");
                    String password = sc.next();
                    System.out.print("set initial balance :");
                    double intialbalance = sc.nextDouble();
                    user.add(new Customer(first, last, birth, phone, email, add, postal, userid, password, intialbalance));
                    break;
                case 2:
                    System.out.println("enter userID: ");
                    String ID = sc.next();
                    System.out.println("enter password : ");
                    String pass = sc.next();
                    for (int i = 0; i < user.size(); i++) {
                        if (user.get(i).getPasword().equals(pass) && user.get(i).getUserid().equals(ID)) {
                            CustomerServices c1 = new CustomerServices(user.get(i));
                            System.out.print("choose 1 for withdraw\n       2 for deposite\n       3 for Transaction\n       4 for checkbalance\n       5 for accountdetails\n       6 for exit");
                            System.out.println("");
                            System.out.print("choose number : ");
                            int Num = sc.nextInt();
                            while (Num != 6) {
                                if (Num == 1) {
                                    System.out.print("enter the amount of mony you want to withdraw : ");
                                    double withdrawamount = sc.nextDouble();
                                    if (withdrawamount > user.get(i).getBalance()) {
                                        System.out.println("sorry you don't have this amount of money  ):");
                                    } else {
                                        System.out.println("your balance now is : " + c1.withdraw(withdrawamount));
                                        System.out.println("thanks for using our services");
                                    }

                                } else if (Num == 2) {
                                    System.out.print("enter the amount of mony you want to deposite : ");
                                    double depositeamount = sc.nextDouble();
                                    System.out.println("your balance now is : " + c1.deposite(depositeamount));
                                    System.out.println("thanks for using our services");
                                } else if (Num == 3) {
                                    System.out.print("enter the amount of mony you want to transfere : ");
                                    double transfereamount = sc.nextDouble();
                                    if (transfereamount < user.get(i).getBalance()) {
                                        System.out.println("enter ID you want to transfere money for : ");
                                        int IDnum = sc.nextInt();
                                        System.out.println("your balance now is : " + c1.Transaction(transfereamount, IDnum));
                                        System.out.println("thanks for using our services");
                                    } else {
                                        System.out.println("sorry you don't have this amount of money  ):");
                                    }

                                } else if (Num == 4) {
                                    c1.checkbalance();
                                    System.out.println("thanks for using our services");
                                } else if (Num == 5) {
                                    c1.accountdetails(user.get(i));
                                    System.out.println("thanks for using our services");
                                } else {
                                    System.out.println("worng operation try again");
                                }
                                System.out.println("choose 1 for withdraw\n       2 for deposite\n       3 for Transaction\n       4 for checkbalance\n       5 for accountdetails\n       6 for exit");
                                System.out.print("choose number : ");
                                Num = sc.nextInt();
                            }
                        }
                    }
                    break;
                case 3:
                    break OUTER;
                default:
                    System.out.println("worng operation");
                    break;
            }
        }

    }
}



