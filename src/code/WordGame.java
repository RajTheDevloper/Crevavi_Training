/******************************************************************************************************************************
 * COPYRIGHT (C) 2022 TONAL
 * The reproduction, transmission, or use of this document/file or its
 * contents is not permitted without written authorization.
 * Offenders will be liable for damages. All rights reserved.
 * ----------------------------------------------------------------------------------------------------------------------------
 * Project Name   : Word Game (Mad Libs Style)
 * File Name      : WordGame.java
 * Author         : [Your Name]
 * Date           : [Enter Date]
 * Version        : 1.0
 *
 * Description    :
 * This program is a simple word-based game where the user inputs different types of words
 * (adjectives and a noun). The program then uses these inputs to generate a fun and creative
 * story (similar to a Mad Libs game).
 *
 * Features       :
 * - Accepts user input using Scanner
 * - Demonstrates usage of methods and string concatenation
 * - Generates a dynamic story based on user input
 *
 * Platform       : Java Console Application
 * Compiler       : Java 21
 * IDE            : Eclipse IDE for Java Developers (Version: 2026-03)
 ******************************************************************************************************************************/

package code;

import java.util.Scanner;

/*******************************************************************************************************************************
 * Class Name    : WordGame
 *
 * Description   :
 * This class contains the main method and implements a simple interactive word game.
 * It collects user inputs (adjectives and noun) and constructs a story using those words.
 *
 * Responsibilities:
 * - Collect user input
 * - Store words in variables
 * - Generate and display a story
 *
 *******************************************************************************************************************************/
public class WordGame {

    /***************************************************************************************************************************
     * Method Name  : main
     *
     * Description  :
     * Entry point of the program. Prompts the user to enter words and generates
     * a customized story using the provided inputs.
     *
     * Parameters   :
     * args - Command line arguments (not used)
     *
     * Returns      :
     * void
     ***************************************************************************************************************************/
    public static void main(String[] args) throws Exception {

        // Variables to store user inputs
        String adjective1;
        String noun;
        String adjective2;
        String adjective3;

        // Scanner object to read input from console
        Scanner in = new Scanner(System.in);

        // Prompt user to enter words
        System.out.print("Enter an adjective (description of a place, e.g., beautiful, amazing): ");
        adjective1 = in.nextLine(); // Read first adjective

        System.out.print("Enter a noun (place name): ");
        noun = in.nextLine(); // Read noun

        System.out.print("Enter an adjective describing your feeling: ");
        adjective2 = in.nextLine(); // Read second adjective

        System.out.print("Enter another adjective about that place: ");
        adjective3 = in.nextLine(); // Read third adjective

        // Display generated story
        System.out.println("\n------- HERE IS YOUR MASTERPIECE ----------\n");

        System.out.print("Today I went to a " + adjective1 + " place ");
        System.out.println("and that place is " + noun + ".");
        System.out.println("I was " + adjective2 + " seeing that place.");
        System.out.println("And it's a " + adjective3 + " place to visit in free time.");

        // Close scanner to prevent resource leak
        in.close();
    }
}