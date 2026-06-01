/**
 * This package contains JavaFX model classes used in the application.
 *
 * The classes inside this package represent data entities and provide
 * JavaFX properties for UI binding and observable data handling.
 * 
 *
 *
 * Main Features:
 * 
 * JavaFX Property Binding
 * Observable Data Models
 *Encapsulation of Record Information
 *
 * @author Raju
 * @version 1.0
 */
package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * The {@code PersonRecord} class represents a person entity used in the application.
 *
 * This class is designed using JavaFX Properties so that the data can be
 * easily bound to JavaFX UI controls such as TableView, TextField, and Labels.
 *
 * The class stores information related to a person including:
 *     ID
 *     Type
 *     Name
 *     Age
 *     Gender
 *     Department
 *     Hobbies
 *     Email
 *     Phone
 *     Address
 *
 * JavaFX properties are used to support:
 *     Data Binding
 *     Observable Changes
 *     UI Synchronization
 *
 * @author YourName
 * @version 1.0
 */
public class PersonRecord {

    /** Stores the unique ID of the person. */
    private final IntegerProperty id = new SimpleIntegerProperty();

    /** Stores the type/category of the person. */
    private final StringProperty type = new SimpleStringProperty();

    /** Stores the full name of the person. */
    private final StringProperty name = new SimpleStringProperty();

    /** Stores the age of the person. */
    private final IntegerProperty age = new SimpleIntegerProperty();

    /** Stores the gender of the person. */
    private final StringProperty gender = new SimpleStringProperty();

    /** Stores the department associated with the person. */
    private final StringProperty department = new SimpleStringProperty();

    /** Stores hobbies or interests of the person. */
    private final StringProperty hobbies = new SimpleStringProperty();

    /** Stores the email address of the person. */
    private final StringProperty email = new SimpleStringProperty();

    /** Stores the phone number of the person. */
    private final StringProperty phone = new SimpleStringProperty();

    /** Stores the residential address of the person. */
    private final StringProperty address = new SimpleStringProperty();

    /**
     * Default constructor for the {@code PersonRecord} class.
     *
     * Initializes an empty person record object.
     */
    public PersonRecord() {
    }

    /**
     * Parameterized constructor used to initialize all fields of the person record.
     *
     * @param id         Unique identification number
     * @param type       Type/category of person
     * @param name       Full name of the person
     * @param age        Age of the person
     * @param gender     Gender of the person
     * @param department Department name
     * @param hobbies    Hobbies or interests
     * @param email      Email address
     * @param phone      Phone number
     * @param address    Residential address
     */
    public PersonRecord(int id, String type, String name, int age,
                        String gender, String department, String hobbies,
                        String email, String phone, String address) {

        // Assigning values to JavaFX properties
        this.id.set(id);
        this.type.set(type);
        this.name.set(name);
        this.age.set(age);
        this.gender.set(gender);
        this.department.set(department);
        this.hobbies.set(hobbies);
        this.email.set(email);
        this.phone.set(phone);
        this.address.set(address);
    }

    /**
     * Returns the ID property.
     *
     * @return IntegerProperty representing the person's ID
     */
    public IntegerProperty idProperty() {
        return id;
    }

    /**
     * Returns the type property.
     *
     * @return StringProperty representing the person's type
     */
    public StringProperty typeProperty() {
        return type;
    }

    /**
     * Returns the name property.
     *
     * @return StringProperty representing the person's name
     */
    public StringProperty nameProperty() {
        return name;
    }

    /**
     * Returns the age property.
     *
     * @return IntegerProperty representing the person's age
     */
    public IntegerProperty ageProperty() {
        return age;
    }

    /**
     * Returns the gender property.
     *
     * @return StringProperty representing the person's gender
     */
    public StringProperty genderProperty() {
        return gender;
    }

    /**
     * Returns the department property.
     *
     * @return StringProperty representing the department
     */
    public StringProperty departmentProperty() {
        return department;
    }

    /**
     * Returns the hobbies property.
     *
     * @return StringProperty representing hobbies
     */
    public StringProperty hobbiesProperty() {
        return hobbies;
    }

    /**
     * Returns the email property.
     *
     * @return StringProperty representing email address
     */
    public StringProperty emailProperty() {
        return email;
    }

    /**
     * Returns the phone property.
     *
     * @return StringProperty representing phone number
     */
    public StringProperty phoneProperty() {
        return phone;
    }

    /**
     * Returns the address property.
     *
     * @return StringProperty representing address
     */
    public StringProperty addressProperty() {
        return address;
    }

    /**
     * Gets the person's ID.
     *
     * @return person's ID
     */
    public int getId() {
        return id.get();
    }

    /**
     * Sets the person's ID.
     *
     * @param id unique identification number
     */
    public void setId(int id) {
        this.id.set(id);
    }

    /**
     * Gets the person's type.
     *
     * @return person type
     */
    public String getType() {
        return type.get();
    }

    /**
     * Sets the person's type.
     *
     * @param type type/category of the person
     */
    public void setType(String type) {
        this.type.set(type);
    }

    /**
     * Gets the person's name.
     *
     * @return person's name
     */
    public String getName() {
        return name.get();
    }

    /**
     * Sets the person's name.
     *
     * @param name full name of the person
     */
    public void setName(String name) {
        this.name.set(name);
    }

    /**
     * Gets the person's age.
     *
     * @return person's age
     */
    public int getAge() {
        return age.get();
    }

    /**
     * Sets the person's age.
     *
     * @param age age of the person
     */
    public void setAge(int age) {
        this.age.set(age);
    }

    /**
     * Gets the person's gender.
     *
     * @return person's gender
     */
    public String getGender() {
        return gender.get();
    }

    /**
     * Sets the person's gender.
     *
     * @param gender gender of the person
     */
    public void setGender(String gender) {
        this.gender.set(gender);
    }

    /**
     * Gets the department name.
     *
     * @return department name
     */
    public String getDepartment() {
        return department.get();
    }

    /**
     * Sets the department name.
     *
     * @param department department associated with the person
     */
    public void setDepartment(String department) {
        this.department.set(department);
    }

    /**
     * Gets the hobbies of the person.
     *
     * @return hobbies/interests
     */
    public String getHobbies() {
        return hobbies.get();
    }

    /**
     * Sets hobbies for the person.
     *
     * @param hobbies hobbies or interests
     */
    public void setHobbies(String hobbies) {
        this.hobbies.set(hobbies);
    }

    /**
     * Gets the email address.
     *
     * @return email address
     */
    public String getEmail() {
        return email.get();
    }

    /**
     * Sets the email address.
     *
     * @param email person's email address
     */
    public void setEmail(String email) {
        this.email.set(email);
    }

    /**
     * Gets the phone number.
     *
     * @return phone number
     */
    public String getPhone() {
        return phone.get();
    }

    /**
     * Sets the phone number.
     *
     * @param phone person's phone number
     */
    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    /**
     * Gets the address.
     *
     * @return residential address
     */
    public String getAddress() {
        return address.get();
    }

    /**
     * Sets the address.
     *
     * @param address residential address
     */
    public void setAddress(String address) {
        this.address.set(address);
    }
}
