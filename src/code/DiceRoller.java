/******************************************************************************************************************************
 * COPYRIGHT (C) 2022 TONAL
 * The reproduction, transmission, or use of this document/file or its
 * contents is not permitted without written authorization.
 * Offenders will be liable for damages. All rights reserved.
 * ----------------------------------------------------------------------------------------------------------------------------
 * Project Name   : Dice Roller (Console-Based)
 * File Name      : DiceRoller.java
 * Author         :
 * Date           :
 * Version        : 
 *
 * Description    :
 * This program simulates rolling one or more dice. The user specifies the number of dice,
 * and the program generates random values between 1 and 6 for each die. It displays
 * both the numeric result and a visual ASCII representation of each die, along with
 * the total sum.
 *
 * Features       :
 * - Random number generation using Random class
 * - Looping to roll multiple dice
 * - ASCII art representation of dice faces
 * - Total score calculation
 *
 * Platform       : Java Console Application
 * Compiler       : Java 21
 * IDE            : Eclipse IDE for Java Developers (Version: 2026-03)
 ******************************************************************************************************************************/

package code;

import java.util.Random;
import java.util.Scanner;

/*******************************************************************************************************************************
 * Class Name    : DiceRoller
 *
 * Description   :
 * This class contains methods to simulate dice rolling.
 * It takes user input for number of dice, generates random values,
 * prints visual dice faces, and calculates the total.
 *
 * Responsibilities:
 * - Accept user input
 * - Generate random dice values
 * - Display dice visually using ASCII art
 * - Calculate total score
 *
 *******************************************************************************************************************************/
public class DiceRoller {

    /***************************************************************************************************************************
     * Method Name  : main
     *
     * Description  :
     * Entry point of the program. Prompts the user for number of dice,
     * rolls each die, displays results, and calculates total value.
     *
     * Parameters   :
     * args - Command line arguments (not used)
     *
     * Returns      :
     * void
     ***************************************************************************************************************************/
    public static void main(String[] args) {

        // Scanner for user input
        Scanner in = new Scanner(System.in);

        // Random object for generating dice values
        Random rand = new Random();

        // Number of dice to roll
        int numOfDice;

        // Total sum of all dice rolls
        int total = 0;

        // Prompt user
        System.out.println("Enter the number of dice to roll:");
        numOfDice = in.nextInt();

        // Validate input
        if (numOfDice > 0) {

            // Loop through each die
            for (int i = 0; i < numOfDice; i++) {

                // Generate random number between 1 and 6
                int roll = rand.nextInt(1, 7);

                // Print visual representation of die
                printDie(roll);

                // Display numeric result
                System.out.println("You rolled: " + roll);

                // Add to total
                total += roll;
            }

            // Display total result
            System.out.println("Total: " + total);

        } else {
            // Handle invalid input
            System.out.println("Number of dice must be greater than 0.");
        }

        // Close scanner
        in.close();
    }

    /***************************************************************************************************************************
     * Method Name  : printDie
     *
     * Description  :
     * Prints an ASCII representation of a die face based on the roll value.
     *
     * Parameters   :
     * roll - integer value between 1 and 6 representing the die face
     *
     * Returns      :
     * void
     ***************************************************************************************************************************/
    static void printDie(int roll) {

        // Multi-line string representations of dice faces
        String die1 = """
                 -------
                |       |
                |   •   |
                |       |
                 -------
                """;

        String die2 = """
                 -------
                |•      |
                |       |
                |      •|
                 -------
                """;

        String die3 = """
                 -------
                |•      |
                |   •   |
                |      •|
                 -------
                """;

        String die4 = """
                 -------
                |•     •|
                |       |
                |•     •|
                 -------
                """;

        String die5 = """
                 -------
                |•     •|
                |   •   |
                |•     •|
                 -------
                """;

        String die6 = """
                 -------
                |•     •|
                |•     •|
                |•     •|
                 -------
                """;

        // Display corresponding die face using switch expression
        switch (roll) {
            case 1 -> System.out.println(die1);
            case 2 -> System.out.println(die2);
            case 3 -> System.out.println(die3);
            case 4 -> System.out.println(die4);
            case 5 -> System.out.println(die5);
            case 6 -> System.out.println(die6);
            default -> System.out.println("Invalid roll value!");
        }
    }
}