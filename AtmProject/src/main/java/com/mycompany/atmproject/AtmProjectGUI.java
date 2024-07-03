/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.atmproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AtmProjectGUI extends JFrame {
    private JTextField userIDField;
    private JPasswordField passwordField;
    private JTextArea outputArea;
    private JButton registerButton;
    private JButton loginButton;
    private JButton exitButton;

    private ArrayList<Customer> users;

    public AtmProjectGUI() {
        setTitle("ATM Project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);       
        
        users = new ArrayList<>();

        JPanel inputPanel = createInputPanel();
        JScrollPane outputScrollPane = createOutputScrollPane();

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(inputPanel, BorderLayout.NORTH);
        contentPane.add(outputScrollPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 10, 5, 10);

        JLabel userIDLabel = new JLabel("User ID:");
        userIDField = new JTextField(15);
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(15);
        registerButton = new JButton("Registration");
        loginButton = new JButton("Login");
        exitButton = new JButton("Exit");

        inputPanel.add(userIDLabel, gbc);
        inputPanel.add(userIDField, gbc);
        inputPanel.add(passwordLabel, gbc);
        inputPanel.add(passwordField, gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.add(registerButton, gbc);
        inputPanel.add(loginButton, gbc);
        inputPanel.add(exitButton, gbc);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                register();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });

        return inputPanel;
    }

    private JScrollPane createOutputScrollPane() {
        outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        return scrollPane;
    }

    private void register() {
        String userID = userIDField.getText();
        String password = new String(passwordField.getPassword());

        for (Customer user : users) {
            if (user.getUserid().equals(userID)) {
                JOptionPane.showMessageDialog(this, "User ID already exists. Please choose a different ID.");
                return;
            }
        }

        String[] registrationInfo = new String[]{"First Name:","Last Name:","Email:","Phone Number:","Postal Code:","Birthdate:","Address:","User ID:","Password:","Initial Balance:"};
        String[] registrationValues = new String[registrationInfo.length];

        for (int i = 0; i < registrationInfo.length; i++) {
            registrationValues[i] = JOptionPane.showInputDialog(this, registrationInfo[i]);
            if (registrationValues[i] == null) {
                return; // User canceled the registration
            }
        }

        double initialBalance;
        try {
            initialBalance = Double.parseDouble(registrationValues[registrationValues.length - 1]);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid initial balance. Registration canceled.");
            return;
        }

        Customer newCustomer = new Customer(
                registrationValues[0],
                registrationValues[1],
                registrationValues[5],
                registrationValues[3],
                registrationValues[2],
                registrationValues[6],
                registrationValues[4],
                registrationValues[7],
                registrationValues[8],
                initialBalance
        );

        users.add(newCustomer);

        outputArea.append("Registration successful.\n");
    }

    private void login() {
        String userID = userIDField.getText();
        String password = new String(passwordField.getPassword());

        for (Customer user : users) {
            if (user.getUserid().equals(userID) && user.getPasword().equals(password)) {
                outputArea.append("Login successful.\n");
                openAccountMenu(user);
                return;
            }
        }

        outputArea.append("Invalid userID or password. Please try again.\n");
    }

    private void openAccountMenu(Customer user) {
        String[] options = {"Check Balance", "Withdraw", "Deposit", "Account Details", "Logout"};
        int choice = JOptionPane.showOptionDialog(
                this,
                "Welcome, " + user.getFirstname() + " " + user.getLastname() + "! Select an option:",
                "Account Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
        );

        switch (choice) {
            case 0:
                outputArea.append("Your balance is: $" + user.getBalance() + "\n");
                break;
            case 1:
                performWithdrawal(user);
                break;
            case 2:
                performDeposit(user);
                break;
            case 3:
                showAccountDetails(user);
                break;
            case 4:
                outputArea.append("Logged out.\n");
                break;
            default:
                break;
        }
    }

    private void performWithdrawal(Customer user) {
        double currentBalance = user.getBalance();
        String withdrawalAmount = JOptionPane.showInputDialog(this, "Enter the withdrawal amount:");
        if (withdrawalAmount == null) {
            return; // User canceled the withdrawal
        }

        try {
            double amount = Double.parseDouble(withdrawalAmount);
            if (amount > 0 && amount <= currentBalance) {
                user.setBalance(currentBalance - amount);
                outputArea.append("Withdrawal successful. Updated balance: $" + user.getBalance() + "\n");
            } else {
                outputArea.append("Invalid withdrawal amount or insufficient funds.\n");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid withdrawal amount.");
        }

        openAccountMenu(user);
    }

    private void performDeposit(Customer user) {
        double currentBalance = user.getBalance();
        String depositAmount = JOptionPane.showInputDialog(this, "Enter the deposit amount:");
        if (depositAmount == null) {
            return; // User canceled the deposit
        }

        try {
            double amount = Double.parseDouble(depositAmount);
            if (amount > 0) {
                user.setBalance(currentBalance + amount);
                outputArea.append("Deposit successful. Updated balance: $" + user.getBalance() + "\n");
            } else {
                outputArea.append("Invalid deposit amount.\n");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid deposit amount.");
        }

        openAccountMenu(user);
    }

    private void showAccountDetails(Customer user) {
        outputArea.append(user.toString() + "\n");
        openAccountMenu(user);
    }

    private void exit() {
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AtmProjectGUI atmGUI = new AtmProjectGUI();
                atmGUI.setVisible(true);
            }
        });
    }
}


