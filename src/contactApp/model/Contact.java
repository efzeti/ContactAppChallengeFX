package contactApp.model;

public class Contact {

    private String firstName;
    private String lastName;
    private String phone;
    private String notes;

    public Contact() {
    }

    public Contact(String firstName, String lastName, String phoneNumber, String notes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phoneNumber;
        this.notes = notes;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
