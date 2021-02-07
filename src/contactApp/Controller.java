package contactApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableView;
import contactApp.model.Contact;
import contactApp.model.ContactData;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Optional;

public class Controller {

    @FXML
    public TableView<Contact> contactsTableView;

    @FXML
    public VBox mainVBox;

    @FXML
    ContactData contactData = new ContactData();

    @FXML
    public void initialize(){
        contactData.addContact(new Contact("a","b","1","c"));
        contactsTableView.setItems(contactData.getContacts());
    }


    public void deleteItem(ActionEvent event) {
    }


    public void showAddDialog(ActionEvent event) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainVBox.getScene().getWindow());
        dialog.setTitle("Add new Contact");

        FXMLLoader fxmlLoader = new FXMLLoader();

        fxmlLoader.setLocation(getClass().getResource("addContactDialog.fxml"));

        try{
            dialog.getDialogPane().setContent(fxmlLoader.load());

        } catch (IOException e){
            System.out.println("Couldn't open the dialog");
            e.printStackTrace();
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK){

            AddContactDialogController controller = fxmlLoader.getController();

            contactData.addContact(new Contact(controller.getFirstName(),controller.getLastName(),controller.getPhone(),controller.getNotes()));


            System.out.println("OK pressed");
        } else {
            System.out.println("Cancel pressed");
        }

    }

    public void showEditDialog(ActionEvent event) {
    }
}
