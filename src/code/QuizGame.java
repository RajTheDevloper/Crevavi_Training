/******************************************************************************************************************************
 * COPYRIGHT (C) 2022 TONAL
 * The reproduction, transmission, or use of this document/file or its
 * contents is not permitted without written authorization.
 * Offenders will be liable for damages. All rights reserved.
 * ----------------------------------------------------------------------------------------------------------------------------
 * Project Name   : Quiz Game (Console-Based)
 * File Name      : QuizGame.java
 * Author         : 
 * Date           : 
 * Version        : 
 *
 * Description    :
 * This program implements a simple console-based quiz game.
 * The user is presented with multiple-choice questions and must select the correct answer.
 * The program evaluates the user's responses and displays the final score at the end.
 *
 * Features       :
 * - Multiple-choice questions
 * - User input handling using Scanner
 * - Score tracking
 * - Immediate feedback (Correct/Wrong)
 *
 * Platform       : Java Console Application
 * Compiler       : Java 21
 * IDE            : Eclipse IDE for Java Developers (Version: 2026-03)
 ******************************************************************************************************************************/

package code;

import java.util.Scanner;

/*******************************************************************************************************************************
 * Class Name    : QuizGame
 *
 * Description   :
 * This class contains the main method and implements the logic for the quiz game.
 * It initializes questions, options, and answers, accepts user input, checks correctness,
 * and calculates the final score.
 *
 * Responsibilities:
 * - Store quiz questions and options
 * - Accept user input
 * - Validate answers
 * - Display results
 *
 *******************************************************************************************************************************/
public class QuizGame {

    /***************************************************************************************************************************
     * Method Name  : main
     *
     * Description  :
     * Entry point of the program. Controls the flow of the quiz game.
     * Iterates through questions, collects user answers, checks correctness,
     * and displays the final score.
     *
     * Parameters   :
     * args - Command line arguments (not used)
     *
     * Returns      :
     * void
     ***************************************************************************************************************************/
    public static void main(String[] args) {

        // Array storing quiz questions
        String[] questions = {
                "What is the main function of a router?",
                "Which part of the computer is considered the brain?",
                "What year was Facebook launched?",
                "Who is known as the father of the computer?",
                "What was the first programming language?"
        };

        // 2D array storing options for each question
        String[][] options = {
                {"1. Storing files", "2. Encrypting data", "3. Directing internet traffic", "4. Managing passwords"},
                {"1. CPU", "2. Hard Drive", "3. RAM", "4. GPU"},
                {"1. 2000", "2. 2004", "3. 2006", "4. 2008"},
                {"1. Steve Jobs", "2. Bill Gates", "3. Alan Turing", "4. Charles Babbage"},
                {"1. COBOL", "2. C", "3. Fortran", "4. Assembly"}
        };

        // Array storing correct answers (index-based, matching options)
        int[] answers = {3, 1, 2, 4, 3};

        // Variable to track user score
        int score = 0;

        // Variable to store user input
        int guess;

        // Scanner object for reading input from console
        Scanner in = new Scanner(System.in);

        // Display welcome message
        System.out.println("Welcome to the Quiz Game!");
        System.out.println("------------------------------------------------");

        // Loop through each question
        for (int i = 0; i < questions.length; i++) {

            // Display current question
            System.out.println(questions[i]);

            // Display options for the current question
            for (String option : options[i]) {
                System.out.println(option);
            }

            // Prompt user for input
            System.out.print("Enter your answer (1-4): ");
            guess = in.nextInt();

            // Check if the answer is correct
            if (guess == answers[i]) {
                System.out.println("CORRECT!");
                score++; // Increment score if correct
            } else {
                System.out.println("WRONG!");
            }

            // Add spacing for better readability
            System.out.println();
        }

        // Display final score
        System.out.printf("Your final score is: %d/%d%n", score, questions.length);

        // Close scanner to prevent resource leak
        in.close();
    }
}
