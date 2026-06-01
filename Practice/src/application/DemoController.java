package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DemoController implements Initializable{
	@FXML
	private Label myLabel;
	@FXML
	private Button myButton;
	@FXML
	private Button cancelButton;
	@FXML
	private AnchorPane pane;
	@FXML
	private ChoiceBox<String> myChoiceBox;
	
	private String[] Character = {"Student", "Employee"};
	
	
	

	//event handle method linked via FXML
	@FXML
	public void SceneOne(ActionEvent e) throws IOException {
		
		if(myChoiceBox.getValue() == "Student" && myLabel.getText() == "Student"){
			
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("UserData.fxml"));
			Parent root = loader.load();
			Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
		} else if(myChoiceBox.getValue() == "Employee" && myLabel.getText() == "Employee"){
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene1.fxml"));
			Parent root = loader.load();
			Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}else {
			myLabel.setText("Please Select the character!!!! to proceed");
		}
	}
	
	//for canceling the application
	public void cancel(ActionEvent e) {
		Stage stage = (Stage) pane.getScene().getWindow();
		stage.close();
	}

	//to display the user successful registration.
	public void display() {
		myLabel.setText("Registered Successfully!!");
	}

	//for check box detailing
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		myChoiceBox.getItems().addAll(Character);
		myChoiceBox.setOnAction(this::changeLabel); //:: is a method reference operator.
		
	}
	
	//change the label through the check box values 
	public void changeLabel(ActionEvent e) {
		myLabel.setText(myChoiceBox.getValue());
	}

}
