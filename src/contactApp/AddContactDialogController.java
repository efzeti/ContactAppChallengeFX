package contactApp;

import contactApp.model.Contact;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddContactDialogController {

    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField phoneTextField;
    @FXML
    private TextField notesTextField;

    public String getFirstName() {
        return firstNameTextField.getText();
    }

    public String getLastName() {
        return lastNameTextField.getText();
    }

    public String getPhone() {
        return phoneTextField.getText();
    }

    public String getNotes() {
        return notesTextField.getText();
    }

    public Contact getContact(){
        String firstname = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String phone = phoneTextField.getText();
        String notes = notesTextField.getText();

        return new Contact(firstname, lastName, phone, notes);
    }
}
