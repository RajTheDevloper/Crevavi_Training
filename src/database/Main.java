package database;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Main class serves as the entry point for testing database operations
 * using the DbConnection utility class.
 * 
 * It demonstrates how to establish a connection, create a table,
 * insert rows, update records, and read data from the database.
 */
public class Main {

    /**
     * The main method executes sample database operations.
     * 
     * @param args Command-line arguments (not used here)
     * @throws ClassNotFoundException if the PostgreSQL driver class is not found
     * @throws SQLException if a database access error occurs
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Create an instance of DbConnection
        DbConnection db = new DbConnection();

        // Establish connection to the database
        Connection conn = db.db_connection();

        // Uncomment the following lines to perform specific operations:

        // Create a new table named "employees"
        // db.createTable(conn, "employees");

        // Insert a new row into "employees" table
        // db.insetRow(conn, "employees", "Raju", "Kamalanagara");

        // Update employee name from "Raju" to "Koushalya"
        // db.update_name(conn, "employees", "Koushalya", "Raju");

        // Update employee address from "Kamalanagara" to "Peenya"
        db.update_address(conn, "employees", "Peenya", "Kamalanagara");

        // Read and display all rows from "employees" table
        db.read_table(conn, "employees");
    }
}

