package application;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	
	public Connection conn; // instance variable
	
	public Connection getConnection() {
		
		String dbName = "LoginFX";
		String user = "postgres";
		String password = "Test@1234";
		String url = "jdbc:postgresql://localhost:5432/" + dbName;		
		
		try {
			
			Class.forName("org.postgresql.Driver"); // this is optional as the modern JDBC auto-load drivers to the class.
			conn = DriverManager.getConnection(url, user, password);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		

		return conn;
		
	}

}
