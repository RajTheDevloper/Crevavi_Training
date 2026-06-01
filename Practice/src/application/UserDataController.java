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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class UserDataController implements Initializable{
	@FXML
	private Button myButton1;
	@FXML
	private ChoiceBox<String> branchChoiceBox, locationChoiceBox;
	
	
	
	@FXML
	public void Scene2Two(ActionEvent e) throws IOException {
		
		
		//alert for confirming the submission.
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("goBack");
		alert.setHeaderText("You're about to submit!");
		alert.setContentText("Check before submitting");
		
		//switch the scene back to the demo page and update the label after clicking OK on the alert menu.
		if(alert.showAndWait().get() == ButtonType.OK) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Demo.fxml"));
		Parent root = loader.load();
		DemoController dc = loader.getController();
		dc.display();
		Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		}
		
}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		branchChoiceBox.getItems().addAll("Compter Science", "Electronics", "MCA");
		locationChoiceBox.getItems().addAll("Bengaluru", "Thumakuru", "Mysore");
		branchChoiceBox.setOnAction(this::something);
		locationChoiceBox.setOnAction(this::something);
		
	}
	
	public void something(ActionEvent e){
		System.out.println(branchChoiceBox.getValue());
		System.out.println(locationChoiceBox.getValue());
	}
	
	

}
