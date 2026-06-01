/**
 * ================================================================
 * Package: application
 * ================================================================
 *
 * This package contains the main classes for the JavaFX Record
 * Management System application.
 *
 * The application allows users to:
 * - Add new person records
 * - Update existing records
 * - Delete records
 * - Display records in a TableView
 * - Import records from CSV/XML files
 * - Export records to CSV/XML files
 *
 * Main Components:
 * - AppController  : Handles UI logic and user interactions
 * - Database       : Performs database operations (CRUD)
 * - PersonRecord   : Model class representing a record
 *
 * Technologies Used:
 * - JavaFX
 * - ObservableList
 * - TableView
 * - File Handling (CSV/XML)
 * - JDBC (via Database class)
 *
 * Author : Raju
 * Version: 1.0
 * ================================================================
 */
package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

/**
 * ================================================================
 * AppController Class
 * ================================================================
 *
 * This controller class manages all user interactions for the
 * JavaFX Record Management System.
 *
 * Responsibilities:
 * - Initialize UI components
 * - Handle CRUD operations
 * - Manage table data
 * - Handle file import/export
 * - Validate user input
 * - Switch tabs and forms
 *
 * Connected With:
 * - FXML UI
 * - Database class
 * - PersonRecord model
 *
 * ================================================================
 */
public class AppController {

    /* ============================================================
     * FXML UI COMPONENTS
     * ============================================================
     */

    @FXML private TextField nameField;
    @FXML private TextField ageField;
    @FXML private ComboBox<String> typeBox;
    @FXML private ToggleGroup genderGroup;
    @FXML private ComboBox<String> departmentBox;

    // Hobby selection checkboxes
    @FXML private CheckBox hobbyJava;
    @FXML private CheckBox hobbySql;
    @FXML private CheckBox hobbyDesign;

    // Contact information fields
    @FXML private TextField emailField;
    @FXML private TextField phoneField;
    @FXML private TextArea addressArea;

    // TableView for displaying records
    @FXML private TableView<PersonRecord> tableView;

    // Buttons
    @FXML private Button updateButton;
    @FXML private Button deleteSelectedButton;
    @FXML private Button editSelectedButton;

    // TabPane used for tab switching
    @FXML private TabPane tabPane;
    

    /* ============================================================
     * DATA VARIABLES
     * ============================================================
     */

    // Observable list bound to the TableView
    private ObservableList<PersonRecord> tableData;

    // Stores currently selected record
    private PersonRecord selectedRecord;

    /**
     * ============================================================
     * initialize()
     * ============================================================
     *
     * Automatically called when the FXML file is loaded.
     *
     * Tasks performed:
     * - Populate ComboBoxes
     * - Configure TableView columns
     * - Initialize ObservableList
     * - Add selection listeners
     * - Load records from database
     *
     * ============================================================
     */
    @FXML
    public void initialize() {

        // Populate person type dropdown
        typeBox.setItems(FXCollections.observableArrayList("Student","Employee"));

        // Select first value by default
        typeBox.getSelectionModel().selectFirst();

        // Populate department dropdown
        departmentBox.setItems(FXCollections.observableArrayList("Computer Science", "Finance", "Sales", "HR", "Design", "Operations"));

        // Set default department
        departmentBox.getSelectionModel().selectFirst();

        // Initialize observable list
        tableData = FXCollections.observableArrayList();

        // Bind table data to TableView
        tableView.setItems(tableData);

        /* ========================================================
         * TABLE COLUMN DEFINITIONS
         * ========================================================
         */

        // ID column
        TableColumn<PersonRecord, Integer> idCol = new TableColumn<>("ID");

        idCol.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());

        idCol.setPrefWidth(60);

        // Type column
        TableColumn<PersonRecord, String> typeCol = new TableColumn<>("Type");

        typeCol.setCellValueFactory(cellData -> cellData.getValue().typeProperty());

        typeCol.setPrefWidth(110);

        // Name column
        TableColumn<PersonRecord, String> nameCol = new TableColumn<>("Name");

        nameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        nameCol.setPrefWidth(150);

        // Age column
        TableColumn<PersonRecord, Integer> ageCol = new TableColumn<>("Age");

        ageCol.setCellValueFactory(cellData -> cellData.getValue().ageProperty().asObject());

        ageCol.setPrefWidth(70);

        // Gender column
        TableColumn<PersonRecord, String> genderCol = new TableColumn<>("Gender");

        genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));

        genderCol.setCellValueFactory(cellData -> cellData.getValue().genderProperty());

        genderCol.setPrefWidth(100);

        // Department column
        TableColumn<PersonRecord, String> deptCol = new TableColumn<>("Department");

        deptCol.setCellValueFactory(new PropertyValueFactory<>("department"));

        deptCol.setCellValueFactory(cellData -> cellData.getValue().departmentProperty());

        deptCol.setPrefWidth(130);

        // Hobbies column
        TableColumn<PersonRecord, String> hobbiesCol = new TableColumn<>("Hobbies");

        hobbiesCol.setCellValueFactory(new PropertyValueFactory<>("hobbies"));

        hobbiesCol.setCellValueFactory(cellData -> cellData.getValue().hobbiesProperty());

        hobbiesCol.setPrefWidth(140);

        // Email column
        TableColumn<PersonRecord, String> emailCol = new TableColumn<>("Email");

        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        emailCol.setCellValueFactory(cellData -> cellData.getValue().emailProperty());

        emailCol.setPrefWidth(180);

        // Phone column
        TableColumn<PersonRecord, String> phoneCol = new TableColumn<>("Phone");

        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));

        phoneCol.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());

        phoneCol.setPrefWidth(120);

        // Address column
        TableColumn<PersonRecord, String> addrCol = new TableColumn<>("Address");

        addrCol.setCellValueFactory(new PropertyValueFactory<>("address"));

        addrCol.setCellValueFactory(cellData -> cellData.getValue().addressProperty());

        addrCol.setPrefWidth(200);

        // Add all columns to the table
        tableView.getColumns().addAll(Arrays.asList(idCol, typeCol, nameCol, ageCol, genderCol, deptCol, hobbiesCol, emailCol, phoneCol, addrCol));

        /* ========================================================
         * TABLE SELECTION LISTENER
         * ========================================================
         */

        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {

                    // Store selected record
                    selectedRecord = newSel;

                    // Enable/disable buttons
                    updateButton.setDisable(newSel == null);
                    deleteSelectedButton.setDisable(newSel == null);
                    editSelectedButton.setDisable(newSel == null);
                });

        // Load records initially
        refreshTable();
    }

    /**
     * Saves a new record into the database.
     */
    @FXML
    private void saveRecord() {

        try {

            // Build record from form values
            PersonRecord record = buildRecordFromForm();

            // Insert into database
            Database.insertRecord(record);

            // Refresh table data
            refreshTable();

            // Show success message
            showAlert(AlertType.INFORMATION,"Record saved successfully.");

            // Clear form fields
            clearForm();

        } catch (Exception ex) {

            // Show error message
            showAlert(AlertType.ERROR, "Save failed: " + ex.getMessage());
        }
    }

    /**
     * Updates the selected record in the database.
     */
    @FXML
    private void updateRecord() {

        // Ensure record is selected
        if (selectedRecord == null) {

            showAlert(AlertType.WARNING, "Select a record first.");

            return;
        }

        try {

            // Build updated record
            PersonRecord record = buildRecordFromForm();

            // Preserve original ID
            record.setId(selectedRecord.getId());

            // Update database
            Database.updateRecord(record);

            // Reload table
            refreshTable();

            // Show success message
            showAlert(AlertType.INFORMATION,"Record updated successfully.");

            // Clear form
            clearForm();

        } catch (Exception ex) {

            // Show error
            showAlert(AlertType.ERROR,"Update failed: " + ex.getMessage());
        }
    }

    /**
     * Clears all input fields and resets the form.
     */
    @FXML
    private void clearForm() {

        // Reset combo boxes
        typeBox.getSelectionModel().selectFirst();

        // Clear text fields
        nameField.clear();
        ageField.clear();
        emailField.clear();
        phoneField.clear();

        // Clear text area
        addressArea.clear();

        // Uncheck hobbies
        hobbyJava.setSelected(false);
        hobbySql.setSelected(false);
        hobbyDesign.setSelected(false);

        // Clear selected record
        selectedRecord = null;

        // Disable buttons
        updateButton.setDisable(true);
        deleteSelectedButton.setDisable(true);
        editSelectedButton.setDisable(true);
    }

    /**
     * Switches to the records list tab.
     */
    @FXML
    private void switchToListTab() {

        // Select second tab
        tabPane.getSelectionModel().select(1);
    }

    /**
     * Reloads all records from database into TableView.
     */
    @FXML
    private void refreshTable() {

        // Load records
        List<PersonRecord> records = Database.loadAllRecords();

        // Update observable list
        tableData.setAll(records);

        // Disable buttons
        deleteSelectedButton.setDisable(true);
    }
    
/*
 * ---------------------------------------------------------------------------------------------------------------------------------------------------------
 * From here the Excel and CSV file import and export methods and it's helper methods have defined.
 * ---------------------------------------------------------------------------------------------------------------------------------------------------------
 */
    
    /**
     * Determines the file type (CSV or Excel XML) and delegates parsing
     * to the appropriate method.
     *
     * @param file the file selected by the user
     * @return a list of PersonRecord objects parsed from the file
     * @throws Exception if parsing fails
     */
    private List<PersonRecord> parseImportFile(File file) throws Exception {
        String lower = file.getName().toLowerCase();
        if (lower.endsWith(".csv")) {
            return readCsv(file);
        }
        return readExcelXml(file);
    }

    
    /**
     * Reads a CSV file and converts each row into a PersonRecord object.
     *
     * Expected CSV format:
     * ID,Type,Name,Age,Gender,Department,Hobbies,Email,Phone,Address
     *
     * @param file CSV file to read
     * @return list of PersonRecord objects
     * @throws Exception if parsing fails
     */
    private List<PersonRecord> readCsv(File file) throws Exception {
        List<PersonRecord> records = FXCollections.observableArrayList();

        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(file))) {
            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {
                // Skip header row
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length >= 10) {
                    PersonRecord record = new PersonRecord(
                            Integer.parseInt(parts[0].trim()),   // ID
                            parts[1].trim(),                    // Type
                            parts[2].trim(),                    // Name
                            Integer.parseInt(parts[3].trim()),  // Age
                            parts[4].trim(),                    // Gender
                            parts[5].trim(),                    // Department
                            parts[6].trim(),                    // Hobbies
                            parts[7].trim(),                    // Email
                            parts[8].trim(),                    // Phone
                            parts[9].trim()                     // Address
                    );
                    records.add(record);
                }
            }
        }
        return records;
    }

    /**
     * Reads an Excel XML file and converts each row into a PersonRecord object.
     *
     * Expected XML format:
     *
     *   ID
     *   Type
     *
     * @param file Excel XML file to read
     * @return list of PersonRecord objects
     * @throws Exception if parsing fails
     */
    private List<PersonRecord> readExcelXml(File file) throws Exception {
        List<PersonRecord> records = FXCollections.observableArrayList();

        javax.xml.parsers.DocumentBuilderFactory factory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
        javax.xml.parsers.DocumentBuilder builder = factory.newDocumentBuilder();
        org.w3c.dom.Document doc = builder.parse(file);

        org.w3c.dom.NodeList rows = doc.getElementsByTagName("Row");

        // Skip header row (index 0)
        for (int i = 1; i < rows.getLength(); i++) {
            org.w3c.dom.Node row = rows.item(i);
            org.w3c.dom.NodeList cells = row.getChildNodes();

            if (cells.getLength() >= 10) {
                PersonRecord record = new PersonRecord(
                        Integer.parseInt(cells.item(0).getTextContent().trim()), // ID
                        cells.item(1).getTextContent().trim(),                  // Type
                        cells.item(2).getTextContent().trim(),                  // Name
                        Integer.parseInt(cells.item(3).getTextContent().trim()),// Age
                        cells.item(4).getTextContent().trim(),                  // Gender
                        cells.item(5).getTextContent().trim(),                  // Department
                        cells.item(6).getTextContent().trim(),                  // Hobbies
                        cells.item(7).getTextContent().trim(),                  // Email
                        cells.item(8).getTextContent().trim(),                  // Phone
                        cells.item(9).getTextContent().trim()                   // Address
                );
                records.add(record);
            }
        }
        return records;
    }

    

    /**
     * Exports records into Excel XML format.
     */
    @FXML
    private void exportExcel() {
        try {
            List<PersonRecord> records = Database.loadAllRecords();

            FileChooser chooser = new FileChooser();
            chooser.setTitle("Export Records to Excel XML");
            chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel XML Files", "*.xml"));

            File file = chooser.showSaveDialog(tableView.getScene().getWindow());

            if (file != null) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    // Basic Excel XML structure
                    writer.write("<?xml version=\"1.0\"?>\n");
                    writer.write("<Workbook xmlns=\"urn:schemas-microsoft-com:office:spreadsheet\">\n");
                    writer.write("<Worksheet ss:Name=\"Records\">\n");
                    writer.write("<Table>\n");

                    // Header row
                    writer.write("<Row>");
                    writer.write("<Cell><Data ss:Type=\"String\">ID</Data></Cell>");
                    writer.write("<Cell><Data ss:Type=\"String\">Type</Data></Cell>");
                    writer.write("<Cell><Data ss:Type=\"String\">Name</Data></Cell>");
                    writer.write("<Cell><Data ss:Type=\"String\">Age</Data></Cell>");
                    writer.write("<Cell><Data ss:Type=\"String\">Gender</Data></Cell>");
                    writer.write("<Cell><Data ss:Type=\"String\">Department</Data></Cell>");
                    writer.write("<Cell><Data ss:Type=\"String\">Hobbies</Data></Cell>");
                    writer.write("<Cell><Data ss:Type=\"String\">Email</Data></Cell>");
                    writer.write("<Cell><Data ss:Type=\"String\">Phone</Data></Cell>");
                    writer.write("<Cell><Data ss:Type=\"String\">Address</Data></Cell>");
                    writer.write("</Row>\n");

                    // Data rows
                    for (PersonRecord record : records) {
                        writer.write("<Row>");
                        writer.write("<Cell><Data ss:Type=\"Number\">" + record.getId() + "</Data></Cell>");
                        writer.write("<Cell><Data ss:Type=\"String\">" + record.getType() + "</Data></Cell>");
                        writer.write("<Cell><Data ss:Type=\"String\">" + record.getName() + "</Data></Cell>");
                        writer.write("<Cell><Data ss:Type=\"Number\">" + record.getAge() + "</Data></Cell>");
                        writer.write("<Cell><Data ss:Type=\"String\">" + record.getGender() + "</Data></Cell>");
                        writer.write("<Cell><Data ss:Type=\"String\">" + record.getDepartment() + "</Data></Cell>");
                        writer.write("<Cell><Data ss:Type=\"String\">" + record.getHobbies() + "</Data></Cell>");
                        writer.write("<Cell><Data ss:Type=\"String\">" + record.getEmail() + "</Data></Cell>");
                        writer.write("<Cell><Data ss:Type=\"String\">" + record.getPhone() + "</Data></Cell>");
                        writer.write("<Cell><Data ss:Type=\"String\">" + record.getAddress() + "</Data></Cell>");
                        writer.write("</Row>\n");
                    }

                    writer.write("</Table>\n</Worksheet>\n</Workbook>");
                }
                showAlert(AlertType.INFORMATION, "Excel XML export completed.");
            }
        } catch (Exception ex) {
            showAlert(AlertType.ERROR, "Excel export failed: " + ex.getMessage());
        }
    }


    /**
     * Exports records into CSV file format.
     */
    @FXML
    private void exportCsv() {
        try {
            // Load records from database
            List<PersonRecord> records = Database.loadAllRecords();

            // File chooser
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Export Records to CSV");
            chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));

            File file = chooser.showSaveDialog(tableView.getScene().getWindow());

            if (file != null) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    // Write header
                    writer.write("ID,Type,Name,Age,Gender,Department,Hobbies,Email,Phone,Address");
                    writer.newLine();

                    // Write each record
                    for (PersonRecord record : records) {
                        writer.write(record.getId() + "," +
                                     record.getType() + "," +
                                     record.getName() + "," +
                                     record.getAge() + "," +
                                     record.getGender() + "," +
                                     record.getDepartment() + "," +
                                     record.getHobbies() + "," +
                                     record.getEmail() + "," +
                                     record.getPhone() + "," +
                                     record.getAddress());
                        writer.newLine();
                    }
                }
                showAlert(AlertType.INFORMATION, "CSV export completed.");
            }
        } catch (Exception ex) {
            showAlert(AlertType.ERROR, "CSV export failed: " + ex.getMessage());
        }
    }


    /**
     * Imports records from a CSV or Excel XML file into the TableView.
     */
    @FXML
    private void importFile() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Import Records from CSV or Excel");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV Files", "*.csv"),
                new FileChooser.ExtensionFilter("Excel XML Files", "*.xls", "*.xml")
        );

        File file = chooser.showOpenDialog(tableView.getScene().getWindow());

        if (file != null) {
            try {
                // Parse file into PersonRecord list
                List<PersonRecord> imported = parseImportFile(file);

                // Insert into database
                for (PersonRecord record : imported) {
                    Database.insertRecord(record);
                }

                // Refresh table view
                refreshTable();

                // Show success message
                showAlert(AlertType.INFORMATION, "Imported " + imported.size() + " record(s) successfully.");
            } catch (Exception ex) {
                showAlert(AlertType.ERROR, "Import failed: " + ex.getMessage());
            }
        }
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------------------------------------------
     * 															Ends here 
     * -----------------------------------------------------------------------------------------------------------------------------------------------------
     */


    /**
     * Loads selected record into form for editing.
     */
    @FXML
    private void editSelectedRecord() {

        // Check selection
        if (selectedRecord != null) {

            // Populate form
            fillFormFromRecord(selectedRecord);

            // Switch to form tab
            tabPane.getSelectionModel().select(0);
        }
    }

    /**
     * Deletes selected record from database.
     */
    @FXML
    private void deleteSelectedRecord() {

        // Get selected item
        PersonRecord selected = tableView.getSelectionModel().getSelectedItem();

        // Return if nothing selected
        if (selected == null)
            return;

        // Confirmation dialog
        Alert confirmation =  new Alert(AlertType.CONFIRMATION, "Delete selected record?", ButtonType.OK, ButtonType.CANCEL);

        // Wait for user response
        Optional<ButtonType> result = confirmation.showAndWait();

        // Delete if confirmed
        if (result.isPresent() && result.get() == ButtonType.OK) {

            Database.deleteRecord(selected.getId());

            refreshTable();

            showAlert(AlertType.INFORMATION,"Record deleted.");
        }
    }

    /**
     * Builds a PersonRecord object using form values.
     *
     * @return PersonRecord object
     */
    private PersonRecord buildRecordFromForm() {

        // Read name field
        String name = nameField.getText().trim();

        // Validate name
        if (name.isEmpty()) {

            throw new IllegalArgumentException("Name cannot be empty.");
        }

        int age;

        try {

            // Parse age and trim the spaces if there is any
            age = Integer.parseInt(ageField.getText().trim());

        } catch (NumberFormatException e) {

            throw new IllegalArgumentException("Age must be a number.");
        }

        // Get selected gender
        String gender = ((RadioButton)genderGroup.getSelectedToggle()).getText();

        // Build hobbies string
        String hobbies = buildHobbies();

        // Return object
        return new PersonRecord( 0,
                typeBox.getValue(),
                name,
                age,
                gender,
                departmentBox.getValue(),
                hobbies,
                emailField.getText().trim(),
                phoneField.getText().trim(),
                addressArea.getText().trim()
        );
    }

    /**
     * Creates hobbies string from selected checkboxes.
     *
     * @return hobbies string
     */
    private String buildHobbies() {

        StringBuilder sb = new StringBuilder();

        // Append selected hobbies
        if (hobbyJava.isSelected())
            sb.append("Java ");

        if (hobbySql.isSelected())
            sb.append("SQL ");

        if (hobbyDesign.isSelected())
            sb.append("Design ");

        return sb.toString().trim();
    }

    /**
     * Populates form fields using selected record data.
     *
     * @param record selected record
     */
    private void fillFormFromRecord(PersonRecord record) {

        selectedRecord = record;

        // Populate fields
        typeBox.setValue(record.getType());
        nameField.setText(record.getName());
        ageField.setText(String.valueOf(record.getAge()));
        departmentBox.setValue(record.getDepartment());

        emailField.setText(record.getEmail());
        phoneField.setText(record.getPhone());
        addressArea.setText(record.getAddress());

        // Set hobbies
        hobbyJava.setSelected(record.getHobbies().contains("Java"));

        hobbySql.setSelected(record.getHobbies().contains("SQL"));

        hobbyDesign.setSelected(record.getHobbies().contains("Design"));

        // Enable update button
        updateButton.setDisable(false);
    }

    /**
     * Displays alert dialog messages.
     *
     * @param type    alert type
     * @param message message to display
     */
    private void showAlert(AlertType type, String message) {

        // Create alert
        Alert alert = new Alert(type);

        // Set title
        alert.setTitle(type == AlertType.ERROR? "Error" : "Information");

        // No header
        alert.setHeaderText(null);

        // Set message
        alert.setContentText(message);

        // Show dialog
        alert.showAndWait();
    }
}