package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Scene1Controller {
	
	@FXML
	private TextField tfName;
	@FXML
	private Button submitButton;
	
	@FXML
	public void submit(ActionEvent e) throws IOException {
		
		String name = tfName.getText();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
		Parent root = loader.load();
		Scene2Controller s2c = loader.getController();
		s2c.display(name);
		
		Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.show();
	
	}

}
