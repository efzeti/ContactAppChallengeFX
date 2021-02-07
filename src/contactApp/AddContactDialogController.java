package contactApp;

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
}
