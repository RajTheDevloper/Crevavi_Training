module LoginFormExtended {
	requires javafx.controls;
	requires java.xml;
	requires java.sql;
	
	opens application to javafx.graphics, javafx.fxml;
}
