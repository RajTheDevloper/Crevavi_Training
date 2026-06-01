package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public void start(Stage stage) {
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Demo.fxml"));
			Parent root = loader.load();
		
			Scene scene = new Scene(root);
			
			//loading the css file to the FXML document this is one method another method is to add css file external through the scene builder.
//			String css = this.getClass().getResource("application.css").toExternalForm();
//			scene.getStylesheets().add(css);
			
			
			
			stage.setScene(scene);
//			stage.setScene(new Scene(root));
			stage.setTitle("learning");
			stage.show();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}