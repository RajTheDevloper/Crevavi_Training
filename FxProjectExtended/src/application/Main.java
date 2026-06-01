/**
 * ================================================================
 * Package: application
 * ================================================================
 *
 * This package contains the main classes of the JavaFX
 * Employee / Student Management System.
 *
 * The package is responsible for:
 * - Application startup
 * - User interface management
 * - Database interaction
 * - Record handling
 * - File import/export operations
 *
 * Main Classes:
 * ------------------------------------------------
 * Main           -> Launches the JavaFX application
 * AppController  -> Handles UI events and logic
 * PersonRecord   -> Model class for records
 * Database       -> Performs CRUD database operations
 *
 * Technologies Used:
 * ------------------------------------------------
 * - Java
 * - JavaFX
 * - FXML
 * - Scene Builder
 * - JDBC
 *
 * Author :	Raju
 * Version: 1.0
 * ================================================================
 */
package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * ================================================================
 * Main Class
 * ================================================================
 *
 * This is the entry point of the JavaFX application.
 *
 * Responsibilities:
 * ------------------------------------------------
 * - Launch the JavaFX runtime
 * - Load the FXML user interface
 * - Create the main application window
 * - Configure the scene and stage
 * - Display the application to the user
 *
 * JavaFX Lifecycle:
 * ------------------------------------------------
 * 1. main() method executes
 * 2. launch(args) starts JavaFX runtime
 * 3. start() method is automatically called
 * 4. Application window is displayed
 *
 * FXML File Used:
 * ------------------------------------------------
 * App.fxml
 *
 * Window Title:
 * ------------------------------------------------
 * Employee / Student Management
 *
 * ================================================================
 */
public class Main extends Application {

    /**
     * ============================================================
     * start()
     * ============================================================
     *
     * This method is automatically called by the JavaFX runtime
     * after the application launches.
     *
     * Responsibilities:
     * ------------------------------------------------
     * - Load the FXML layout file
     * - Create the Scene object
     * - Configure the Stage (window)
     * - Display the primary application window
     *
     * @param primaryStage Main application window provided
     *                     by JavaFX runtime.
     *
     * ============================================================
     */
    @Override
    public void start(Stage primaryStage) {

        try {

            /* ====================================================
             * LOAD FXML FILE
             * ====================================================
             */

            // Load App.fxml from application package
            Parent root = FXMLLoader.load(getClass().getResource("/application/App.fxml"));

            /* ====================================================
             * CREATE SCENE
             * ====================================================
             */

            // Create scene with width = 1024 and height = 680
            Scene scene = new Scene(root, 1024, 680);

            /* ====================================================
             * CONFIGURE STAGE
             * ====================================================
             */

            // Attach scene to stage (window)
            primaryStage.setScene(scene);

            // Set window title
            primaryStage.setTitle("Employee / Student Management");

            /* ====================================================
             * DISPLAY WINDOW
             * ====================================================
             */

            // Show application window
            primaryStage.show();

        } catch (Exception e) {

            /* ====================================================
             * ERROR HANDLING
             * ====================================================
             */

            // Print exception details for debugging
            e.printStackTrace();
        }
    }

    /**
     * ============================================================
     * main()
     * ============================================================
     *
     * Main method of the application.
     *
     * This method launches the JavaFX application runtime.
     *
     * Flow:
     * ------------------------------------------------
     * 1. JVM starts execution here
     * 2. launch(args) initializes JavaFX
     * 3. JavaFX internally calls start()
     *
     * @param args Command-line arguments
     *
     * ============================================================
     */
    public static void main(String[] args) {

        // Launch JavaFX application
        launch(args);
    }
}