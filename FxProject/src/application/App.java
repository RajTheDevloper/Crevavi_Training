package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class App extends Application {
    private TextField nameField;
    private TextField ageField;
    private ComboBox<String> typeBox;
    private ToggleGroup genderGroup;
    private ComboBox<String> departmentBox;
    private CheckBox hobbyJava;
    private CheckBox hobbySql;
    private CheckBox hobbyDesign;
    private TextField emailField;
    private TextField phoneField;
    private TextArea addressArea;
    private TableView<PersonRecord> tableView;
    private ObservableList<PersonRecord> tableData;
    private PersonRecord selectedRecord;
    private Button updateButton;
    private Button deleteSelectedButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Database.initialize();

        BorderPane root = new BorderPane();
        TabPane tabPane = new TabPane();

        Tab formTab = new Tab("Data Entry");
        formTab.setClosable(false);
        formTab.setContent(createFormPane(tabPane));

        Tab listTab = new Tab("Saved Records");
        listTab.setClosable(false);
        listTab.setContent(createTablePane(tabPane));

        tabPane.getTabs().addAll(formTab, listTab);
        root.setCenter(tabPane);

        Scene scene = new Scene(root, 1024, 680);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Employee / Student Management");
        primaryStage.show();

        refreshTable();
    }

    private VBox createFormPane(TabPane tabPane) {
        GridPane formGrid = new GridPane();
        formGrid.setHgap(12);
        formGrid.setVgap(12);
        formGrid.setPadding(new Insets(16));

        Label typeLabel = new Label("Record Type");
        typeBox = new ComboBox<>(FXCollections.observableArrayList("Student", "Employee"));
        typeBox.setPrefWidth(280);
        typeBox.getSelectionModel().selectFirst();

        Label nameLabel = new Label("Name");
        nameField = new TextField();
        nameField.setPrefWidth(280);

        Label ageLabel = new Label("Age");
        ageField = new TextField();

        Label genderLabel = new Label("Gender");
        genderGroup = new ToggleGroup();
        RadioButton maleButton = new RadioButton("Male");
        maleButton.setToggleGroup(genderGroup);
        RadioButton femaleButton = new RadioButton("Female");
        femaleButton.setToggleGroup(genderGroup);
        RadioButton otherButton = new RadioButton("Other");
        otherButton.setToggleGroup(genderGroup);
        maleButton.setSelected(true);
        HBox genderBox = new HBox(12, maleButton, femaleButton, otherButton);

        Label departmentLabel = new Label("Department");
        departmentBox = new ComboBox<>(FXCollections.observableArrayList("Computer Science", "Finance", "Sales", "HR", "Design", "Operations"));
        departmentBox.setPrefWidth(280);
        departmentBox.getSelectionModel().selectFirst();

        Label hobbiesLabel = new Label("Hobbies / Skills");
        hobbyJava = new CheckBox("Java");
        hobbySql = new CheckBox("SQL");
        hobbyDesign = new CheckBox("Design");
        HBox hobbiesBox = new HBox(12, hobbyJava, hobbySql, hobbyDesign);

        Label emailLabel = new Label("Email");
        emailField = new TextField();
        emailField.setPrefWidth(280);

        Label phoneLabel = new Label("Phone");
        phoneField = new TextField();

        Label addressLabel = new Label("Address");
        addressArea = new TextArea();
        addressArea.setPrefRowCount(4);
        addressArea.setWrapText(true);
        addressArea.setPrefWidth(580);

        formGrid.add(typeLabel, 0, 0);
        formGrid.add(typeBox, 1, 0);
        formGrid.add(nameLabel, 0, 1);
        formGrid.add(nameField, 1, 1);
        formGrid.add(ageLabel, 0, 2);
        formGrid.add(ageField, 1, 2);
        formGrid.add(genderLabel, 0, 3);
        formGrid.add(genderBox, 1, 3);
        formGrid.add(departmentLabel, 0, 4);
        formGrid.add(departmentBox, 1, 4);
        formGrid.add(hobbiesLabel, 0, 5);
        formGrid.add(hobbiesBox, 1, 5);
        formGrid.add(emailLabel, 0, 6);
        formGrid.add(emailField, 1, 6);
        formGrid.add(phoneLabel, 0, 7);
        formGrid.add(phoneField, 1, 7);
        formGrid.add(addressLabel, 0, 8);
        formGrid.add(addressArea, 1, 8);

        Button saveButton = new Button("Save Record");
        updateButton = new Button("Update Record");
        Button clearButton = new Button("Clear");
        updateButton.setDisable(true);

        saveButton.setOnAction(event -> saveRecord());
        updateButton.setOnAction(event -> updateRecord());
        clearButton.setOnAction(event -> clearForm());

        HBox actionButtons = new HBox(12, saveButton, updateButton, clearButton);
        actionButtons.setAlignment(Pos.CENTER_LEFT);
        actionButtons.setPadding(new Insets(12, 0, 0, 0));

        Button viewSavedButton = new Button("View Saved Records");
        viewSavedButton.setOnAction(event -> tabPane.getSelectionModel().select(1));
        actionButtons.getChildren().add(viewSavedButton);

        VBox formBox = new VBox(8, formGrid, actionButtons);
        formBox.setPadding(new Insets(16));
        formBox.setStyle("-fx-background-color: #f6f8fa;");
        return formBox;
    }

    private VBox createTablePane(TabPane tabPane) {
        tableView = new TableView<>();
        tableView.setPrefHeight(460);
        tableData = FXCollections.observableArrayList();
        tableView.setItems(tableData);

        TableColumn<PersonRecord, Integer> idColumn = new TableColumn<>("ID");
//        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        idColumn.setPrefWidth(60);

        TableColumn<PersonRecord, String> typeColumn = new TableColumn<>("Type");
//        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        typeColumn.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
        typeColumn.setPrefWidth(110);

        TableColumn<PersonRecord, String> nameColumn = new TableColumn<>("Name");
//        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        nameColumn.setPrefWidth(150);

        TableColumn<PersonRecord, Integer> ageColumn = new TableColumn<>("Age");
//        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        ageColumn.setCellValueFactory(cellData -> cellData.getValue().ageProperty().asObject());
        ageColumn.setPrefWidth(70);

        TableColumn<PersonRecord, String> genderColumn = new TableColumn<>("Gender");
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        genderColumn.setCellValueFactory(cellData -> cellData.getValue().genderProperty());
        genderColumn.setPrefWidth(100);

        TableColumn<PersonRecord, String> departmentColumn = new TableColumn<>("Department");
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        departmentColumn.setCellValueFactory(cellData -> cellData.getValue().departmentProperty());
        departmentColumn.setPrefWidth(130);

        TableColumn<PersonRecord, String> hobbiesColumn = new TableColumn<>("Hobbies");
        hobbiesColumn.setCellValueFactory(new PropertyValueFactory<>("hobbies"));
        hobbiesColumn.setCellValueFactory(cellData -> cellData.getValue().hobbiesProperty());
        hobbiesColumn.setPrefWidth(140);

        TableColumn<PersonRecord, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        emailColumn.setPrefWidth(180);

        TableColumn<PersonRecord, String> phoneColumn = new TableColumn<>("Phone");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        phoneColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());
        phoneColumn.setPrefWidth(120);

        TableColumn<PersonRecord, String> addressColumn = new TableColumn<>("Address");
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        addressColumn.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
        addressColumn.setPrefWidth(200);

//        tableView.getColumns().addAll(
//        	    idColumn, typeColumn, nameColumn, ageColumn,
//        	    genderColumn, departmentColumn, hobbiesColumn,
//        	    emailColumn, phoneColumn, addressColumn
//        	);

        
        tableView.getColumns().addAll(Arrays.asList(
        	    idColumn, typeColumn, nameColumn, ageColumn,
        	    genderColumn, departmentColumn, hobbiesColumn,
        	    emailColumn, phoneColumn, addressColumn
        	));
    
        


        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            deleteSelectedButton.setDisable(newSelection == null);
        });

        Button refreshButton = new Button("Refresh");
        Button exportCsvButton = new Button("Export to CSV");
        Button exportExcelButton = new Button("Export to Excel");
        Button importButton = new Button("Import File");
        Button editSelectedButton = new Button("Edit Selected");
        deleteSelectedButton = new Button("Delete Selected");

        exportCsvButton.setOnAction(event -> exportCsv());
        exportExcelButton.setOnAction(event -> exportExcel());
        importButton.setOnAction(event -> importFile());
        refreshButton.setOnAction(event -> refreshTable());
        editSelectedButton.setOnAction(event -> {
            PersonRecord selected = tableView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                fillFormFromRecord(selected);
                tabPane.getSelectionModel().select(0);
            }
        });
        deleteSelectedButton.setOnAction(event -> deleteSelectedRecord());
        deleteSelectedButton.setDisable(true);

        HBox buttonRow = new HBox(12, refreshButton, exportCsvButton, exportExcelButton, importButton, editSelectedButton, deleteSelectedButton);
        buttonRow.setPadding(new Insets(12));

        VBox tableBox = new VBox(8, buttonRow, tableView);
        tableBox.setPadding(new Insets(16));
        tableBox.setStyle("-fx-background-color: #eef2f7;");
        return tableBox;
    }

    private void saveRecord() {
        try {
            PersonRecord record = buildRecordFromForm();
            Database.insertRecord(record);
            refreshTable();
            showAlert(AlertType.INFORMATION, "Record saved successfully.");
            clearForm();
        } catch (Exception ex) {
            showAlert(AlertType.ERROR, "Save failed: " + ex.getMessage());
        }
    }

    private void updateRecord() {
        if (selectedRecord == null || selectedRecord.getId() == 0) {
            showAlert(AlertType.WARNING, "Select a saved record first to update.");
            return;
        }
        try {
            PersonRecord record = buildRecordFromForm();
            record.setId(selectedRecord.getId());
            Database.updateRecord(record);
            refreshTable();
            showAlert(AlertType.INFORMATION, "Record updated successfully.");
            clearForm();
        } catch (Exception ex) {
            showAlert(AlertType.ERROR, "Update failed: " + ex.getMessage());
        }
    }

    private void deleteSelectedRecord() {
        PersonRecord selected = tableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert(AlertType.WARNING, "Please select a record to delete.");
            return;
        }
        Alert confirmation = new Alert(AlertType.CONFIRMATION);
        confirmation.setTitle("Delete Confirmation");
        confirmation.setHeaderText("Confirm deletion");
        confirmation.setContentText("Do you really want to delete the selected record?");
        Optional<ButtonType> result = confirmation.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Database.deleteRecord(selected.getId());
            refreshTable();
            showAlert(AlertType.INFORMATION, "Record deleted.");
        }
    }

    private void refreshTable() {
        try {
            List<PersonRecord> records = Database.loadAllRecords();
            tableData.setAll(records);
            deleteSelectedButton.setDisable(true);
        } catch (Exception ex) {
            showAlert(AlertType.ERROR, "Unable to load records: " + ex.getMessage());
        }
    }

    private void clearForm() {
        typeBox.getSelectionModel().selectFirst();
        nameField.clear();
        ageField.clear();
        ((RadioButton) genderGroup.getToggles().get(0)).setSelected(true);
        departmentBox.getSelectionModel().selectFirst();
        hobbyJava.setSelected(false);
        hobbySql.setSelected(false);
        hobbyDesign.setSelected(false);
        emailField.clear();
        phoneField.clear();
        addressArea.clear();
        selectedRecord = null;
        updateButton.setDisable(true);
    }

    private void fillFormFromRecord(PersonRecord record) {
        selectedRecord = record;
        typeBox.setValue(record.getType());
        nameField.setText(record.getName());
        ageField.setText(String.valueOf(record.getAge()));
        String gender = record.getGender();
        genderGroup.getToggles().forEach(toggle -> {
            RadioButton radio = (RadioButton) toggle;
            radio.setSelected(radio.getText().equalsIgnoreCase(gender));
        });
        departmentBox.setValue(record.getDepartment());
        String hobbies = record.getHobbies();
        hobbyJava.setSelected(hobbies != null && hobbies.contains("Java"));
        hobbySql.setSelected(hobbies != null && hobbies.contains("SQL"));
        hobbyDesign.setSelected(hobbies != null && hobbies.contains("Design"));
        emailField.setText(record.getEmail());
        phoneField.setText(record.getPhone());
        addressArea.setText(record.getAddress());
        updateButton.setDisable(false);
    }

    private PersonRecord buildRecordFromForm() {
        String name = nameField.getText().trim();
        String ageText = ageField.getText().trim();
        String email = emailField.getText().trim();
        String phone = phoneField.getText().trim();

        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        int age;
        try {
            age = Integer.parseInt(ageText);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Age must be a number.");
        }
        String gender = ((RadioButton) genderGroup.getSelectedToggle()).getText();
        String hobbies = buildHobbies();

        return new PersonRecord(
                0,
                typeBox.getValue(),
                name,
                age,
                gender,
                departmentBox.getValue(),
                hobbies,
                email,
                phone,
                addressArea.getText().trim()
        );
    }

    private String buildHobbies() {
        List<String> selected = new ArrayList<>();
        if (hobbyJava.isSelected()) selected.add("Java");
        if (hobbySql.isSelected()) selected.add("SQL");
        if (hobbyDesign.isSelected()) selected.add("Design");
        return String.join(", ", selected);
    }

    private void exportCsv() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Export Records to CSV");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File file = chooser.showSaveDialog(null);
        if (file != null) {
            try {
                writeCsv(file, Database.loadAllRecords());
                showAlert(AlertType.INFORMATION, "CSV export completed.");
            } catch (Exception ex) {
                showAlert(AlertType.ERROR, "Export failed: " + ex.getMessage());
            }
        }
    }

    private void exportExcel() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Export Records to Excel");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel XML Files", "*.xls", "*.xml"));
        File file = chooser.showSaveDialog(null);
        if (file != null) {
            try {
                writeExcelXml(file, Database.loadAllRecords());
                showAlert(AlertType.INFORMATION, "Excel export completed.");
            } catch (Exception ex) {
                showAlert(AlertType.ERROR, "Export failed: " + ex.getMessage());
            }
        }
    }

    private void importFile() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Import Records from CSV or Excel");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV Files", "*.csv"),
                new FileChooser.ExtensionFilter("Excel XML Files", "*.xls", "*.xml")
        );
        File file = chooser.showOpenDialog(null);
        if (file != null) {
            try {
                List<PersonRecord> imported = parseImportFile(file);
                for (PersonRecord record : imported) {
                    Database.insertRecord(record);
                }
                refreshTable();
                showAlert(AlertType.INFORMATION, "Imported " + imported.size() + " record(s) successfully.");
            } catch (Exception ex) {
                showAlert(AlertType.ERROR, "Import failed: " + ex.getMessage());
            }
        }
    }

    private List<PersonRecord> parseImportFile(File file) throws Exception {
        String lower = file.getName().toLowerCase();
        if (lower.endsWith(".csv")) {
            return readCsv(file);
        }
        return readExcelXml(file);
    }

    private List<PersonRecord> readCsv(File file) throws Exception {
        List<PersonRecord> records = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {
            String line = reader.readLine();
            if (line == null) {
                return records;
            }
            while ((line = reader.readLine()) != null) {
                String[] values = splitCsvLine(line);
                if (values.length < 9) {
                    continue;
                }
                records.add(new PersonRecord(
                        0,
                        values[0],
                        values[1],
                        parseInteger(values[2]),
                        values[3],
                        values[4],
                        values[5],
                        values[6],
                        values[7],
                        values[8]
                ));
            }
        }
        return records;
    }

    private List<PersonRecord> readExcelXml(File file) throws Exception {
        List<PersonRecord> records = new ArrayList<>();
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        try (InputStream input = new FileInputStream(file)) {
            Document document = builder.parse(input);
            NodeList rows = document.getElementsByTagName("Row");
            for (int i = 1; i < rows.getLength(); i++) {
                Node row = rows.item(i);
                NodeList cells = row.getChildNodes();
                List<String> values = new ArrayList<>();
                for (int j = 0; j < cells.getLength(); j++) {
                    Node cell = cells.item(j);
                    if ("Cell".equals(cell.getNodeName())) {
                        String text = "";
                        NodeList cellChildren = cell.getChildNodes();
                        for (int k = 0; k < cellChildren.getLength(); k++) {
                            Node content = cellChildren.item(k);
                            if ("Data".equals(content.getNodeName())) {
                                text = content.getTextContent();
                            }
                        }
                        values.add(text);
                    }
                }
                if (values.size() < 9) {
                    continue;
                }
                records.add(new PersonRecord(
                        0,
                        values.get(0),
                        values.get(1),
                        parseInteger(values.get(2)),
                        values.get(3),
                        values.get(4),
                        values.get(5),
                        values.get(6),
                        values.get(7),
                        values.get(8)
                ));
            }
        }
        return records;
    }

    private void writeCsv(File file, List<PersonRecord> records) throws Exception {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, StandardCharsets.UTF_8))) {
            writer.write("Type,Name,Age,Gender,Department,Hobbies,Email,Phone,Address\n");
            for (PersonRecord record : records) {
                writer.write(quoteCsv(record.getType()));
                writer.write(',');
                writer.write(quoteCsv(record.getName()));
                writer.write(',');
                writer.write(String.valueOf(record.getAge()));
                writer.write(',');
                writer.write(quoteCsv(record.getGender()));
                writer.write(',');
                writer.write(quoteCsv(record.getDepartment()));
                writer.write(',');
                writer.write(quoteCsv(record.getHobbies()));
                writer.write(',');
                writer.write(quoteCsv(record.getEmail()));
                writer.write(',');
                writer.write(quoteCsv(record.getPhone()));
                writer.write(',');
                writer.write(quoteCsv(record.getAddress()));
                writer.write('\n');
            }
        }
    }

    private void writeExcelXml(File file, List<PersonRecord> records) throws Exception {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, StandardCharsets.UTF_8))) {
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<Workbook xmlns=\"urn:schemas-microsoft-com:office:spreadsheet\" "
                    + "xmlns:o=\"urn:schemas-microsoft-com:office:office\" "
                    + "xmlns:x=\"urn:schemas-microsoft-com:office:excel\" "
                    + "xmlns:ss=\"urn:schemas-microsoft-com:office:spreadsheet\">\n");
            writer.write("  <Worksheet ss:Name=\"Records\">\n");
            writer.write("    <Table>\n");
            writer.write("      <Row>");
            writer.write(xmlCell("Type"));
            writer.write(xmlCell("Name"));
            writer.write(xmlCell("Age"));
            writer.write(xmlCell("Gender"));
            writer.write(xmlCell("Department"));
            writer.write(xmlCell("Hobbies"));
            writer.write(xmlCell("Email"));
            writer.write(xmlCell("Phone"));
            writer.write(xmlCell("Address"));
            writer.write("      </Row>\n");
            for (PersonRecord record : records) {
                writer.write("      <Row>");
                writer.write(xmlCell(record.getType()));
                writer.write(xmlCell(record.getName()));
                writer.write(xmlCell(String.valueOf(record.getAge())));
                writer.write(xmlCell(record.getGender()));
                writer.write(xmlCell(record.getDepartment()));
                writer.write(xmlCell(record.getHobbies()));
                writer.write(xmlCell(record.getEmail()));
                writer.write(xmlCell(record.getPhone()));
                writer.write(xmlCell(record.getAddress()));
                writer.write("      </Row>\n");
            }
            writer.write("    </Table>\n");
            writer.write("  </Worksheet>\n");
            writer.write("</Workbook>\n");
        }
    }

    private String xmlCell(String value) {
        return "<Cell><Data ss:Type=\"String\">" + escapeXml(value) + "</Data></Cell>";
    }

    private String quoteCsv(String value) {
        if (value == null) {
            return "";
        }
        String escaped = value.replace("\"", "\"\"");
        return "\"" + escaped + "\"";
    }

    private String[] splitCsvLine(String line) {
        List<String> columns = new ArrayList<>();
        boolean insideQuote = false;
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (ch == '"') {
                insideQuote = !insideQuote;
                continue;
            }
            if (ch == ',' && !insideQuote) {
                columns.add(buffer.toString());
                buffer.setLength(0);
            } else {
                buffer.append(ch);
            }
        }
        columns.add(buffer.toString());
        return columns.toArray(new String[0]);
    }

    private int parseInteger(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (Exception ex) {
            return 0;
        }
    }

    private String escapeXml(String value) {
        if (value == null) {
            return "";
        }
        return value.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&apos;");
    }

    private void showAlert(AlertType type, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(type == AlertType.ERROR ? "Error" : "Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
