/******************************************************************************************************************************
 * COPYRIGHT (C) 2022 TONAL
 * The reproduction, transmission, or use of this document/file or its
 * contents is not permitted without written authorization.
 * Offenders will be liable for damages. All rights reserved.
 * ----------------------------------------------------------------------------------------------------------------------------
 * Project Name   : Banking System (Console-Based)
 * File Name      : Banking.java
 * Author         : [Your Name]
 * Date           : [Enter Date]
 * Version        : 1.0
 *
 * Description    :
 * This program simulates a simple banking system. It allows the user to:
 * - View account balance (with password authentication)
 * - Deposit money
 * - Withdraw money
 * - Exit the system
 *
 * The program uses loops, conditional statements, and methods to manage operations.
 *
 * Features       :
 * - Menu-driven interface
 * - Balance tracking
 * - Deposit and withdrawal functionality
 * - Password-protected balance viewing
 *
 * Platform       : Java Console Application
 * Compiler       : Java 21
 * IDE            : Eclipse IDE for Java Developers (Version: 2026-03)
 ******************************************************************************************************************************/

package code;

import java.util.Scanner;

/*******************************************************************************************************************************
 * Class Name    : Banking
 *
 * Description   :
 * This class implements a simple banking system with basic operations such as
 * checking balance, depositing money, and withdrawing money.
 *
 * Responsibilities:
 * - Maintain account balance
 * - Provide menu-based interaction
 * - Handle deposit and withdrawal operations
 * - Validate user inputs
 *
 *******************************************************************************************************************************/
public class Banking {

    // Static variable to store account balance
    static double balance = 0;

    // Scanner object for user input
    static Scanner in = new Scanner(System.in);

    /***************************************************************************************************************************
     * Method Name  : main
     *
     * Description  :
     * Entry point of the program. Displays menu options repeatedly and performs
     * operations based on user choice.
     *
     * Parameters   :
     * args - Command line arguments (not used)
     *
     * Returns      :
     * void
     *
     * Throws       :
     * Exception - Due to Thread.sleep()
     ***************************************************************************************************************************/
    public static void main(String[] args) throws Exception {

        int choice;              // Stores user menu choice
        boolean isRunning = true; // Controls loop execution

        // Main menu loop
        while (isRunning) {

            // Delay for better user experience
            Thread.sleep(2000);

            // Display menu
            System.out.println("------------------------------------------");
            System.out.println("LOCAL BANK");
            System.out.println("------------------------------------------");
            System.out.println("1. Show Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. EXIT");
            System.out.println("------------------------------------------");

            // Get user choice
            System.out.println("\nEnter your choice (1 - 4):");
            choice = in.nextInt();

            // Perform operation based on choice
            switch (choice) {

                case 1 -> {
                    // Ask for password before showing balance
                    System.out.println("Enter the password to show balance:");
                    String password = in.next();
                    showBalance(password);
                }

                case 2 -> {
                    // Deposit money and update balance
                    balance += deposit();
                    System.out.printf("Current balance: %.2f%n%n", balance);
                }

                case 3 -> {
                    // Withdraw money
                    withdraw(balance);
                }

                case 4 -> {
                    // Exit the system
                    isRunning = false;
                }

                default -> System.out.println("Invalid entry!");
            }
        }

        // Exit message
        System.out.println("----------------------------------------------------------");
        System.out.println("Thank you for banking with us!");

        // Close scanner
        in.close();
    }

    /***************************************************************************************************************************
     * Method Name  : showBalance
     *
     * Description  :
     * Displays the current balance after validating the password.
     *
     * Parameters   :
     * password - User-entered password
     *
     * Returns      :
     * void
     ***************************************************************************************************************************/
    static void showBalance(String password) {

        // Check password
        if (password.equals("Raju@1234")) {
            System.out.println("Current balance: " + balance);
        } else {
            System.err.println("Incorrect password! Access denied.");
        }
    }

    /***************************************************************************************************************************
     * Method Name  : deposit
     *
     * Description  :
     * Accepts an amount from the user and returns it to be added to balance.
     *
     * Parameters   :
     * none
     *
     * Returns      :
     * double - amount to deposit
     ***************************************************************************************************************************/
    static double deposit() {

        System.out.println("Enter amount to deposit:");
        double amount = in.nextDouble();

        // Validate amount
        if (amount < 0) {
            System.out.println("Amount cannot be negative!");
            return 0;
        }

        return amount;
    }

    /***************************************************************************************************************************
     * Method Name  : withdraw
     *
     * Description  :
     * Withdraws a specified amount from the current balance after validation.
     *
     * Parameters   :
     * curBalance - Current available balance
     *
     * Returns      :
     * void
     ***************************************************************************************************************************/
    static void withdraw(double curBalance) {

        System.out.println("Enter amount to withdraw:");
        double amount = in.nextDouble();

        // Validate withdrawal conditions
        if (amount < 0) {
            System.out.println("Amount cannot be negative!");
        } else if (amount > curBalance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.printf("Current balance: %.2f%n", balance);
        }
    }
}