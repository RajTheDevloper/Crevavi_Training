package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginFormController {
	@FXML
	private TextField usernameTextfield;
	@FXML
	private TextField passwordPasswordfield;
	@FXML
	private Button loginButton;
	@FXML
	private Button cancelButton;
	@FXML
	private Label loginMessageLabel;

	public void loginButtonOnAction(ActionEvent e) throws IOException {

		if (usernameTextfield.getText().isBlank() == false && passwordPasswordfield.getText().isBlank() == false) {
			loginMessageLabel.setText("you tried to login!!!!");
			validateLogin();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("SignInForm.fxml"));
			Parent root = loader.load();
			Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
			

		} else {
			loginMessageLabel.setText("Please enter the details");
		}
	}
	

	public void cancelButtonOnAction(ActionEvent e) {
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.close();
	}
	
	

	
	public void validateLogin() {
		
		DatabaseConnection connect = new DatabaseConnection();
		
		Connection conn = connect.getConnection();
		
		String query = "SELECT COUNT(1) FROM useraccount WHERE userName = '" + usernameTextfield.getText() + "' AND password = '" + passwordPasswordfield.getText() + "';";
		
		try {
				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(query);
				
				while(rs.next()) {
					if(rs.getInt(1) == 1) {
						loginMessageLabel.setText("WELCOME!");
						
					}else {
						loginMessageLabel.setText("Invalid login, please try again!");
					}
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
