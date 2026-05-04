/******************************************************************************************************************************
 * COPYRIGHT (C) 2022 TONAL
 * The reproduction, transmission, or use of this document/file or its
 * contents is not permitted without written authorization.
 * Offenders will be liable for damages. All rights reserved.
 * ----------------------------------------------------------------------------------------------------------------------------
 * Project Name   : Calculator (Console-Based)
 * File Name      : Calculator.java
 * Author         : 
 * Date           : 
 * Version        : 
 *
 * Description    :
 * This program implements a simple calculator that performs basic arithmetic
 * operations such as addition, subtraction, multiplication, division, and exponentiation.
 * The user inputs two numbers and selects an operator, and the program displays the result.
 *
 * Features       :
 * - Supports +, -, *, /, ^ operations
 * - Uses switch expression for operation handling
 * - Accepts user input via Scanner
 *
 * Platform       : Java Console Application
 * Compiler       : Java 21
 * IDE            : Eclipse IDE for Java Developers (Version: 2026-03)
 ******************************************************************************************************************************/

package code;

import java.util.Scanner;

/*******************************************************************************************************************************
 * Class Name    : Calculator
 *
 * Description   :
 * This class contains the main method and provides functionality for performing
 * basic mathematical operations based on user input.
 *
 * Responsibilities:
 * - Accept user input (numbers and operator)
 * - Perform arithmetic operations
 * - Display result
 *
 *******************************************************************************************************************************/
public class Calculator {

    /***************************************************************************************************************************
     * Method Name  : main
     *
     * Description  :
     * Entry point of the program. Prompts the user to enter two numbers and
     * an operator, performs the selected operation, and displays the result.
     *
     * Parameters   :
     * args - Command line arguments (not used)
     *
     * Returns      :
     * void
     ***************************************************************************************************************************/
    public static void main(String[] args) {

        // Scanner object for reading user input
        @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);

        // Variables to store numbers and operator
        double num1;     // First number
        double num2;     // Second number
        char operator;   // Operator (+, -, *, /, ^)

        while(true) {
        // Prompt user for first number
        System.out.println("Enter the first number:");
        num1 = in.nextDouble();

        // Prompt user for operation
        System.out.println("Enter operation (+, -, *, /, ^):");
        operator = in.next().charAt(0);

        // Prompt user for second number
        System.out.println("Enter the second number:");
        num2 = in.nextDouble();

        // Perform operation based on user input
        switch (operator) {

            case '+' -> System.out.println("Result: " + (num1 + num2));

            case '-' -> System.out.println("Result: " + (num1 - num2));

            case '*' -> System.out.println("Result: " + (num1 * num2));

            case '/' -> {
                // Handle division by zero
                if (num2 == 0) {
                    System.out.println("Error: Division by zero is not allowed.");
                } else {
                    System.out.println("Result: " + (num1 / num2));
                }
            }

            case '^' -> System.out.println("Result: " + Math.pow(num1, num2));

            default -> System.out.println("Invalid operator!");
        }
        
        }
        
    }
}