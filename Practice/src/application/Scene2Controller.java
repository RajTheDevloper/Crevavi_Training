package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Scene2Controller {
	
	@FXML
	private Label Scene2Label;
	

	public void display(String userName) {
		Scene2Label.setText("HI: " + userName);
	}

}
