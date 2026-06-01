package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PersonRecord {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty type = new SimpleStringProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final IntegerProperty age = new SimpleIntegerProperty();
    private final StringProperty gender = new SimpleStringProperty();
    private final StringProperty department = new SimpleStringProperty();
    private final StringProperty hobbies = new SimpleStringProperty();
    private final StringProperty email = new SimpleStringProperty();
    private final StringProperty phone = new SimpleStringProperty();
    private final StringProperty address = new SimpleStringProperty();

    public PersonRecord() {
    }

    public PersonRecord(int id, String type, String name, int age, String gender, String department, String hobbies, String email, String phone, String address) {
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

    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty typeProperty() {
        return type;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public IntegerProperty ageProperty() {
        return age;
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public StringProperty departmentProperty() {
        return department;
    }

    public StringProperty hobbiesProperty() {
        return hobbies;
    }

    public StringProperty emailProperty() {
        return email;
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public StringProperty addressProperty() {
        return address;
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getAge() {
        return age.get();
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public String getGender() {
        return gender.get();
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public String getDepartment() {
        return department.get();
    }

    public void setDepartment(String department) {
        this.department.set(department);
    }

    public String getHobbies() {
        return hobbies.get();
    }

    public void setHobbies(String hobbies) {
        this.hobbies.set(hobbies);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }
}
