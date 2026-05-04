/**
 * DbConnection class provides utility methods to connect to a PostgreSQL database,
 * create tables, insert rows, read data, and update records.
 * 
 * It uses JDBC for database connectivity and operations.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
    
    // Database configuration
    private String db_name = "Practice";
    private String url = "jdbc:postgresql://localhost:5432/" + db_name;
    private String user_name = "postgres";
    private String pass = "Test@1234";

    Connection conn = null;

    /**
     * Establishes a connection to the PostgreSQL database.
     * 
     * @return Connection object if successful, null otherwise.
     */
    public Connection db_connection() {
        try {
            Class.forName("org.postgresql.Driver"); // Load PostgreSQL driver
            conn = DriverManager.getConnection(url, user_name, pass); // Establish connection
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }

        if (conn != null)
            System.out.println("Connection successful!!");
        else
            System.out.println("Connection failed!!");

        return conn;
    }

    /**
     * Creates a new table with the given name.
     * The table contains empid (Primary Key), name, and address columns.
     * 
     * @param conn       Active database connection
     * @param table_name Name of the table to be created
     */
    public void createTable(Connection conn, String table_name) {
        Statement statement;
        try {
            String query = "CREATE TABLE " + table_name +
                           "(empid SERIAL, name VARCHAR(20), address VARCHAR(200), PRIMARY KEY(empid));";
            statement = conn.createStatement();
            statement.executeUpdate(query); // Use executeUpdate for DDL
            System.out.println("Table created!!");
        } catch (Exception e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }

    /**
     * Inserts a new row into the specified table.
     * 
     * @param conn       Active database connection
     * @param table_name Name of the table
     * @param name       Employee name
     * @param address    Employee address
     */
    public void insetRow(Connection conn, String table_name, String name, String address) {
        Statement statement;
        try {
            String query = String.format("INSERT INTO %s(name, address) VALUES ('%s', '%s');", table_name, name, address);
            statement = conn.createStatement();
            statement.executeUpdate(query); // Use executeUpdate for INSERT
            System.out.println("Row inserted!");
        } catch (Exception e) {
            System.out.println("Error inserting row: " + e.getMessage());
        }
    }

    /**
     * Reads and prints all rows from the specified table.
     * 
     * @param conn       Active database connection
     * @param table_name Name of the table
     */
    public void read_table(Connection conn, String table_name) {
        Statement statement;
        ResultSet rs;
        try {
            String query = String.format("SELECT * FROM %s;", table_name);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);

            while (rs.next()) {
                System.out.print(rs.getString("empid") + " ");
                System.out.print(rs.getString("name") + " ");
                System.out.println(rs.getString("address") + " ");
            }
        } catch (Exception e) {
            System.out.println("Error reading table: " + e.getMessage());
        }
    }

    /**
     * Updates the name of an employee in the specified table.
     * 
     * @param conn       Active database connection
     * @param table_name Name of the table
     * @param new_name   New name to be set
     * @param old_name   Existing name to be replaced
     */
    public void update_name(Connection conn, String table_name, String new_name, String old_name) {
        Statement statement;
        try {
            String query = String.format("UPDATE %s SET name='%s' WHERE name='%s';", table_name, new_name, old_name);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("The name has been updated!");
        } catch (Exception e) {
            System.out.println("Error updating name: " + e.getMessage());
        }
    }

    /**
     * Updates the address of an employee in the specified table.
     * 
     * @param conn       Active database connection
     * @param table_name Name of the table
     * @param new_addr   New address to be set
     * @param old_addr   Existing address to be replaced
     */
    public void update_address(Connection conn, String table_name, String new_addr, String old_addr) {
        Statement statement;
        try {
            String query = String.format("UPDATE %s SET address='%s' WHERE address='%s';", table_name, new_addr, old_addr);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("The address has been updated!");
        } catch (Exception e) {
            System.out.println("Error updating address: " + e.getMessage());
        }
    }
}
