package completeCrudOperationProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UserCRUDApp {

    // Method to establish connection
    public static Connection getConnection() throws Exception {
        String url = "jdbc:postgresql://localhost:5432/userdb";
        String user = "postgres"; // replace with your username
        String password = "Test@1234"; // replace with your password
        return DriverManager.getConnection(url, user, password);
    }

    // Create (Insert)
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

    // Read (Select)
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

    // Update
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

    // Delete
    public static void deleteUser(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            Scanner sc = new Scanner(System.in);
            System.err.println("Do you really want to delete your data!!");
            String ans = sc.nextLine();
            if(ans.equalsIgnoreCase("yes")) {
            	
            	pstmt.executeUpdate();
                System.out.println("User deleted!");
            }else {
            	System.err.println("not deleted!");
            	}
      
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    // Main menu
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
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    insertUser(name, email, age);
                    break;
                case 2:
                    readUsers();
                    break;
                case 3:
                    System.out.print("Enter user ID to update: ");
                    int idUpdate = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new email: ");
                    String newEmail = sc.nextLine();
                    updateUserEmail(idUpdate, newEmail);
                    break;
                case 4:
                    System.out.print("Enter user ID to delete: ");
                    int idDelete = sc.nextInt();
                    deleteUser(idDelete);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}