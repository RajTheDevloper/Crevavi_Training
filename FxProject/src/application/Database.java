package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/ProjectOne";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "Test@1234";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("PostgreSQL JDBC driver not found. Add it to classpath.");
        }
    }

    public static void initialize() {
        try (Connection connection = connect(); Statement statement = connection.createStatement()) {
            String createTable = "CREATE TABLE IF NOT EXISTS person_records ("
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
            statement.execute(createTable);
        } catch (SQLException e) {
            throw new RuntimeException("Unable to initialize database", e);
        }
    }

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public static List<PersonRecord> loadAllRecords() {
        List<PersonRecord> records = new ArrayList<>();
        String query = "SELECT id, record_type, full_name, age, gender, department, hobbies, email, phone, address FROM person_records ORDER BY id";
        try (Connection connection = connect(); PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
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
                records.add(record);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Unable to load records", e);
        }
        return records;
    }

    public static PersonRecord insertRecord(PersonRecord record) {
        String insert = "INSERT INTO person_records (record_type, full_name, age, gender, department, hobbies, email, phone, address) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id";
        try (Connection connection = connect(); PreparedStatement statement = connection.prepareStatement(insert)) {
            statement.setString(1, record.getType());
            statement.setString(2, record.getName());
            statement.setInt(3, record.getAge());
            statement.setString(4, record.getGender());
            statement.setString(5, record.getDepartment());
            statement.setString(6, record.getHobbies());
            statement.setString(7, record.getEmail());
            statement.setString(8, record.getPhone());
            statement.setString(9, record.getAddress());
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    record.setId(resultSet.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Unable to insert record", e);
        }
        return record;
    }

    public static boolean updateRecord(PersonRecord record) {
        String update = "UPDATE person_records SET record_type = ?, full_name = ?, age = ?, gender = ?, department = ?, hobbies = ?, email = ?, phone = ?, address = ? WHERE id = ?";
        try (Connection connection = connect(); PreparedStatement statement = connection.prepareStatement(update)) {
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
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Unable to update record", e);
        }
    }

    public static boolean deleteRecord(int id) {
        String delete = "DELETE FROM person_records WHERE id = ?";
        try (Connection connection = connect(); PreparedStatement statement = connection.prepareStatement(delete)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Unable to delete record", e);
        }
    }
}
