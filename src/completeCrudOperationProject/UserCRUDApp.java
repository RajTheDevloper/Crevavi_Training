package completeCrudOperationProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * The UserCRUDApp class demonstrates a complete CRUD (Create, Read, Update, Delete)
 * application using JDBC with PostgreSQL. It provides methods to insert, read,
 * update, and delete user records from a database table named <code>users</code>.
 */
public class UserCRUDApp {

    /**
     * Establishes a connection to the PostgreSQL database.
     *
     * @return a Connection object to the database
     * @throws Exception if a database access error occurs
     */
    public static Connection getConnection() throws Exception {
        String url = "jdbc:postgresql://localhost:5432/userdb";
        String user = "postgres"; // replace with your username
        String password = "Test@1234"; // replace with your password
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * Inserts a new user record into the database.
     *
     * @param name  the user's name
     * @param email the user's email
     * @param age   the user's age
     */
    public static void insertUser(String name, String email, int age) {
        String sql = "INSERT INTO users (name, email, age) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setInt(3, age);
            pstmt.executeUpdate();
            System.out.println("User inserted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads and displays all user records from the database.
     */
    public static void readUsers() {
        String sql = "SELECT * FROM users";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("ID | Name | Email | Age");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                                   rs.getString("name") + " | " +
                                   rs.getString("email") + " | " +
                                   rs.getInt("age"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates the email of a user based on their ID.
     *
     * @param id       the user's ID
     * @param newEmail the new email to set
     */
    public static void updateUserEmail(int id, String newEmail) {
        String sql = "UPDATE users SET email = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newEmail);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println("User email updated!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes a user record from the database based on their ID.
     * Prompts the user for confirmation before deletion.
     *
     * @param id the user's ID
     */
    @SuppressWarnings("resource")
    public static void deleteUser(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            Scanner sc = new Scanner(System.in);
            System.err.println("Do you really want to delete your data!!");
            String ans = sc.nextLine();
            if (ans.equalsIgnoreCase("yes")) {
                pstmt.executeUpdate();
                System.out.println("User deleted!");
            } else {
                System.err.println("Not deleted!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * The entry point of the program. Displays a menu for CRUD operations
     * and executes the corresponding methods based on user input.
     *
     * @param args command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- User CRUD Menu ---");
            System.out.println("1. Insert User");
            System.out.println("2. View Users");
            System.out.println("3. Update User Email");
            System.out.println("4. Delete User");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "INSERT":
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    insertUser(name, email, age);
                    break;
                case "View":
                    readUsers();
                    break;
                case "Update":
                    System.out.print("Enter user ID to update: ");
                    int idUpdate = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new email: ");
                    String newEmail = sc.nextLine();
                    updateUserEmail(idUpdate, newEmail);
                    break;
                case "Delete":
                    System.out.print("Enter user ID to delete: ");
                    int idDelete = sc.nextInt();
                    deleteUser(idDelete);
                    break;
                case "Exit":
                    System.out.println("Exiting...");
                    System.exit(0);
                    sc.close();
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
