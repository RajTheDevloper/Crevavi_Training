/**
 * ================================================================
 * Package: application
 * ================================================================
 *
 * This package contains all classes required for the
 * Employee / Student Management System.
 *
 * Package Responsibilities:
 * ------------------------------------------------
 * - JavaFX application management
 * - User interface control
 * - Database connectivity
 * - CRUD operations
 * - Record model management
 * - File import/export handling
 *
 * Main Classes:
 * ------------------------------------------------
 * Main           -> Launches JavaFX application
 * AppController  -> Handles UI interactions
 * Database       -> Handles database operations
 * PersonRecord   -> Represents a record entity for a person
 *
 * Database Used:
 * ------------------------------------------------
 * PostgreSQL
 *
 * Technologies:
 * ------------------------------------------------
 * - Java
 * - JavaFX
 * - JDBC
 * - PostgreSQL
 *
 * Author : Raju
 * Version: 1.0
 * ================================================================
 */
package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

/**
 * ================================================================
 * Database Class
 * ================================================================
 *
 * This utility class handles all database-related operations
 * for the Employee / Student Management System.
 *
 * Responsibilities:
 * ------------------------------------------------
 * - Establish database connection
 * - Initialize database tables
 * - Insert records
 * - Update records
 * - Delete records
 * - Retrieve records
 *
 * Database:
 * ------------------------------------------------
 * PostgreSQL
 *
 * Table Used:
 * ------------------------------------------------
 * person_records
 *
 * Features:
 * ------------------------------------------------
 * - JDBC connection management
 * - PreparedStatement usage for security
 * - Automatic resource closing using try-with-resources
 * - Exception handling
 *
 * ================================================================
 */
public class Database {

    /* ============================================================
     * DATABASE CONFIGURATION
     * ============================================================
     */

    // Database connection URL
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/ProjectOne";

    // Database user_name
    private static final String DB_USER = "postgres";

    // Database password
    private static final String DB_PASSWORD = "Test@1234";

    /* ============================================================
     * JDBC DRIVER LOADING
     * ============================================================
     */

    /**
     * Static initialization block.
     *
     * This block loads the PostgreSQL JDBC driver when the
     * Database class is loaded into memory.
     */
    static {

        try {

            // Load PostgreSQL JDBC Driver (Even if this line skipped it works fine)
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            // Display error if driver is missing
            System.err.println("PostgreSQL JDBC driver not found.");
        }
    }

    /**
     * ============================================================
     * initialize()
     * ============================================================
     *
     * Creates the database table if it does not already exist.
     *
     * Table Name:
     * ------------------------------------------------
     * person_records
     *
     * Columns:
     * ------------------------------------------------
     * id
     * record_type
     * full_name
     * age
     * gender
     * department
     * hobbies
     * email
     * phone
     * address
     *
     * ============================================================
     */
    public static void initialize() {

        // Try-with-resources automatically closes resources
        try (Connection connection = connect();
             Statement statement = connection.createStatement()) {

            /* ====================================================
             * CREATE TABLE SQL QUERY
             * ====================================================
             */

            String createTable =
                    "CREATE TABLE IF NOT EXISTS person_records ("
                    + "id SERIAL PRIMARY KEY,"
                    + "record_type VARCHAR(20),"
                    + "full_name VARCHAR(200),"
                    + "age INTEGER,"
                    + "gender VARCHAR(20),"
                    + "department VARCHAR(100),"
                    + "hobbies TEXT,"
                    + "email VARCHAR(200),"
                    + "phone VARCHAR(50),"
                    + "address TEXT"
                    + ")";

            // Execute SQL query
            statement.execute(createTable);

        } catch (SQLException e) {

            // Throw runtime exception if initialization fails
        	System.err.println(e.getMessage());
            throw new RuntimeException("Unable to initialize database", e);
        }
    }

    /**
     * ============================================================
     * connect()
     * ============================================================
     *
     * Establishes connection with PostgreSQL database.
     *
     * @return Connection object
     * @throws SQLException if connection fails
     *
     * ============================================================
     */
    public static Connection connect() throws SQLException {

        // Return database connection
        return DriverManager.getConnection( DB_URL, DB_USER, DB_PASSWORD);
    }

    /**
     * ============================================================
     * loadAllRecords()
     * ============================================================
     *
     * Retrieves all records from the database.
     *
     * Process:
     * ------------------------------------------------
     * - Execute SELECT query
     * - Read ResultSet data
     * - Convert rows into PersonRecord objects
     * - Store objects into list
     *
     * @return List of PersonRecord objects
     *
     * ============================================================
     */
    public static List<PersonRecord> loadAllRecords() {

        // Create list to store records
        List<PersonRecord> records = new ArrayList<>();

        /* ========================================================
         * SQL QUERY
         * ========================================================
         */

        String query = "SELECT id, record_type, full_name, age, "
		                + "gender, department, hobbies, email, "
		                + "phone, address "
		                + "FROM person_records "
		                + "ORDER BY id";

        try (

                // Establish connection
                Connection connection = connect();

                // Prepare SQL statement
                PreparedStatement statement = connection.prepareStatement(query);

                // Execute query
                ResultSet resultSet =
                        statement.executeQuery()
        ) {

            /* ====================================================
             * READ RESULTSET
             * ====================================================
             */

            while (resultSet.next()) {

                // Create PersonRecord object from database row
                PersonRecord record = new PersonRecord(

                        resultSet.getInt("id"),

                        resultSet.getString("record_type"),

                        resultSet.getString("full_name"),

                        resultSet.getInt("age"),

                        resultSet.getString("gender"),

                        resultSet.getString("department"),

                        resultSet.getString("hobbies"),

                        resultSet.getString("email"),

                        resultSet.getString("phone"),

                        resultSet.getString("address")
                );

                // Add record to list
                records.add(record);
            }

        } catch (SQLException e) {

            // Throw runtime exception on failure
            throw new RuntimeException("Unable to load records", e);
        }

        // Return records list
        return records;
    }

    /**
     * ============================================================
     * insertRecord()
     * ============================================================
     *
     * Inserts a new record into the database.
     *
     * PostgreSQL feature:
     * ------------------------------------------------
     * Uses RETURNING id to retrieve generated primary key.
     *
     * @param record PersonRecord object to insert
     *
     * @return inserted PersonRecord with generated ID
     *
     * ============================================================
     */
    public static PersonRecord insertRecord(PersonRecord record) {

        /* ========================================================
         * INSERT SQL QUERY
         * ========================================================
         */

        String insert ="INSERT INTO person_records "
		                + "(record_type, full_name, age, gender, "
		                + "department, hobbies, email, phone, address) "
		                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) "
		                + "RETURNING id";

        try (

                // Establish database connection
                Connection connection = connect();

                // Prepare SQL statement
                PreparedStatement statement = connection.prepareStatement(insert)
        ) {

            /* ====================================================
             * SET QUERY PARAMETERS
             * ====================================================
             */

            statement.setString(1, record.getType());

            statement.setString(2, record.getName());

            statement.setInt(3, record.getAge());

            statement.setString(4, record.getGender());

            statement.setString(5, record.getDepartment());

            statement.setString(6, record.getHobbies());

            statement.setString(7, record.getEmail());

            statement.setString(8, record.getPhone());

            statement.setString(9, record.getAddress());

            /* ====================================================
             * EXECUTE INSERT QUERY
             * ====================================================
             */

            try (ResultSet resultSet = statement.executeQuery()) {

                // Read generated ID
                if (resultSet.next()) {

                    // Set generated ID into object
                    record.setId(resultSet.getInt(1));
                }
            }

        } catch (SQLException e) {

            // Throw runtime exception on failure
            throw new RuntimeException("Unable to insert record", e);
        }

        // Return inserted record
        return record;
    }

    /**
     * ============================================================
     * updateRecord()
     * ============================================================
     *
     * Updates an existing record in the database.
     *
     * @param record Updated PersonRecord object
     *
     * @return true if update successful
     *
     * ============================================================
     */
    public static boolean updateRecord(PersonRecord record) {

        /* ========================================================
         * UPDATE SQL QUERY
         * ========================================================
         */

        String update = "UPDATE person_records "
		                + "SET record_type = ?, "
		                + "full_name = ?, "
		                + "age = ?, "
		                + "gender = ?, "
		                + "department = ?, "
		                + "hobbies = ?, "
		                + "email = ?, "
		                + "phone = ?, "
		                + "address = ? "
		                + "WHERE id = ?";

        try (

                // Open connection
                Connection connection = connect();

                // Prepare statement
                PreparedStatement statement = connection.prepareStatement(update)
        ) {

            /* ====================================================
             * SET PARAMETERS
             * ====================================================
             */

            statement.setString(1, record.getType());

            statement.setString(2, record.getName());

            statement.setInt(3, record.getAge());

            statement.setString(4, record.getGender());

            statement.setString(5, record.getDepartment());

            statement.setString(6, record.getHobbies());

            statement.setString(7, record.getEmail());

            statement.setString(8, record.getPhone());

            statement.setString(9, record.getAddress());

            statement.setInt(10, record.getId());

            // Execute update query
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {

            // Throw runtime exception
            throw new RuntimeException("Unable to update record", e);
        }
    }

    /**
     * ============================================================
     * deleteRecord()
     * ============================================================
     *
     * Deletes a record from the database using ID.
     *
     * @param id Record ID
     *
     * @return true if deletion successful
     *
     * ============================================================
     */
    public static boolean deleteRecord(int id) {

        /* ========================================================
         * DELETE SQL QUERY
         * ========================================================
         */

        String delete = "DELETE FROM person_records "
		                + "WHERE id = ?";

        try (

                // Open database connection
                Connection connection = connect();

                // Prepare SQL statement
                PreparedStatement statement = connection.prepareStatement(delete)
        ) {

            // Set ID parameter
            statement.setInt(1, id);
            
            //after deleting sets the index value to 1 again
            //SELECT setval('person_records_id_seq', (SELECT MAX(id) FROM person_records) + 1);


            // Execute delete query
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {

            // Throw runtime exception
            throw new RuntimeException("Unable to delete record", e);
        }
    }
}