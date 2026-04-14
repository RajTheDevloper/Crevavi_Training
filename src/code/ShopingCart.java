/******************************************************************************************************************************
 * COPYRIGHT (C) 2022 TONAL
 * The reproduction, transmission, or use of this document/file or its
 * contents is not permitted without written authorization.
 * Offenders will be liable for damages. All rights reserved.
 * ----------------------------------------------------------------------------------------------------------------------------
 * Project Name   : Shopping Cart (Console-Based)
 * File Name      : ShoppingCart.java
 * Author         : 
 * Date           : 
 * Version        : 
 *
 * Description    :
 * This program simulates a simple shopping cart system. The user enters product details
 * such as name, price, and quantity. The program calculates the total cost and applies
 * a discount if provided by the user.
 *
 * Features       :
 * - Accepts user input using Scanner
 * - Calculates subtotal and total price
 * - Applies percentage-based discount
 * - Displays formatted bill summary
 *
 * Platform       : Java Console Application
 * Compiler       : Java 21
 * IDE            : Eclipse IDE for Java Developers (Version: 2026-03)
 ******************************************************************************************************************************/

package code;

import java.util.Scanner;

/*******************************************************************************************************************************
 * Class Name    : ShoppingCart
 *
 * Description   :
 * This class contains the main method and implements a basic shopping cart system.
 * It collects product details from the user, calculates total cost, applies discount
 * if applicable, and displays the final bill.
 *
 * Responsibilities:
 * - Accept product details from user
 * - Perform price calculations
 * - Apply discount logic
 * - Display final output
 *
 *******************************************************************************************************************************/
public class ShopingCart {

    /***************************************************************************************************************************
     * Method Name  : main
     *
     * Description  :
     * Entry point of the program. Handles user interaction, input collection,
     * price calculation, discount processing, and displays the final bill.
     *
     * Parameters   :
     * args - Command line arguments (not used)
     *
     * Returns      :
     * void
     ***************************************************************************************************************************/
    public static void main(String[] args) {

        // Scanner object to read user input
        Scanner in = new Scanner(System.in);

        // Variables to store product details
        String product;     // Name of the product
        double price;       // Price per unit
        int quantity;       // Quantity of product
        char currency = '₹'; // Currency symbol
        double total;       // Total amount
        String isDiscount;  // User input for discount option
        double discount;    // Discount amount

        // Prompt user to enter product name
        System.out.println("Enter the product that you want to buy:");
        product = in.nextLine();

        // Prompt user to enter price
        System.out.println("\nEnter the price of the product:");
        price = in.nextDouble();

        // Prompt user to enter quantity
        System.out.println("\nEnter the quantity:");
        quantity = in.nextInt();

        // Clear buffer (important after nextInt())
        in.nextLine();

        // Ask if discount is applicable
        System.out.println("\nIs there any discount (Yes/No)?");
        isDiscount = in.nextLine();

        // Check if user entered "yes" (case-insensitive)
        if (isDiscount.equalsIgnoreCase("yes")) {

            // Prompt for discount percentage
            System.out.println("Enter the discount percentage:");
            double discountPercent = in.nextDouble();

            // Calculate subtotal
            total = quantity * price;

            // Calculate discount amount
            discount = (discountPercent / 100) * total;

            // Apply discount to total
            total = total - discount;

            // Display bill with discount
            System.out.println("\nSO YOU HAVE IN YOUR CART\n"
                    + "\nPRODUCT -> " + product
                    + "\nPRICE --> " + price + currency
                    + "\nSUBTOTAL --> " + (quantity * price) + currency
                    + "\n\nDISCOUNT APPLIED --> " + discountPercent + "%"
                    + "\nFINAL AMOUNT --> " + total + currency);

        } else {

            // Calculate total without discount
            total = quantity * price;

            // Display bill without discount
            System.out.println("\nSO YOU HAVE IN YOUR CART\n"
                    + "\nPRODUCT -> " + product
                    + "\nPRICE --> " + price + currency
                    + "\n\nTOTAL AMOUNT --> " + total + currency);
        }

        // Close scanner to prevent resource leak
        in.close();
    }
}