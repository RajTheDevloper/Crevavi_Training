/******************************************************************************************************************************
 * COPYRIGHT (C) 2022 TONAL
 * The reproduction, transmission, or use of this document/file or its
 * contents is not permitted without written authorization.
 * Offenders will be liable for damages. All rights reserved.
 * ----------------------------------------------------------------------------------------------------------------------------
 * Project Name   : Number Guessing Game
 * File Name      : NumberGuessGame.java
 * Author         : [Your Name]
 * Date           : [Enter Date]
 * Version        : 1.0
 *
 * Description    :
 * This program implements a number guessing game where the system generates
 * a random number between 1 and 100. The user attempts to guess the number.
 * After each guess, feedback is provided (too high / too low), and the program
 * continues until the correct number is guessed.
 *
 * Features       :
 * - Random number generation using Random class
 * - Looping using do-while
 * - Attempt counter
 * - User feedback for each guess
 *
 * Platform       : Java Console Application
 * Compiler       : Java 21
 * IDE            : Eclipse IDE for Java Developers (Version: 2026-03)
 ******************************************************************************************************************************/

package code;

import java.util.Random;
import java.util.Scanner;

/*******************************************************************************************************************************
 * Class Name    : NumberGuessGame
 *
 * Description   :
 * This class contains the main method and implements a number guessing game.
 * It generates a random number and allows the user to guess it with hints
 * until the correct number is found.
 *
 * Responsibilities:
 * - Generate a random number
 * - Accept user guesses
 * - Provide feedback (high/low)
 * - Track number of attempts
 *
 *******************************************************************************************************************************/
public class NmberGessGame {

    /***************************************************************************************************************************
     * Method Name  : main
     *
     * Description  :
     * Entry point of the program. Controls the game loop, processes user input,
     * compares guesses with the generated number, and displays the result.
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

        // Scanner object to read user input
        Scanner in = new Scanner(System.in);

        // Random object to generate random numbers
        Random randNum = new Random();

        // Generate a random number between 1 and 100 (inclusive)
        int randomNumber = randNum.nextInt(1, 101);

        // Variable to store user's guess
        int guess;

        // Counter to track number of attempts
        int attempt = 0;

        // Game loop continues until the correct guess is made
        do {
            // Pause for better user experience
            Thread.sleep(800);

            // Prompt user to guess
            System.out.println("Guess the number between 1 - 100:");
            guess = in.nextInt();

            // Increment attempt counter
            attempt++;

            // Check guess and provide feedback
            if (guess < randomNumber) {
                System.out.println("**** Too low ****");
            } else if (guess > randomNumber) {
                System.out.println("**** Too high ****");
            } else {
                System.out.println("You got it!");
                System.out.println("Number of attempts --> " + attempt);
            }

        } while (guess != randomNumber);

        // Close scanner to prevent resource leak
        in.close();
    }
}