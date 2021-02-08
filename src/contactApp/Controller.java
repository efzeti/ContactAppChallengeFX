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
    private TableView<Contact> contactsTableView;

    @FXML
    private VBox mainVBox;

    @FXML
    private ContactData contactData;

    @FXML
    public void initialize(){
        contactData = new ContactData();
        contactData.loadContacts();
        contactsTableView.setItems(contactData.getContacts());
    }


    public void deleteItem(ActionEvent event) {
        Contact contact = contactsTableView.getSelectionModel().getSelectedItem();

        if (contact == null){
            System.out.println("No item selected");
        } else {
            contactData.removeContact(contact);
        }
    }


    public void showAddDialog(ActionEvent event) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainVBox.getScene().getWindow());
        dialog.setTitle("Add new Contact");

        FXMLLoader fxmlLoader = new FXMLLoader();

        fxmlLoader.setLocation(getClass().getResource("ContactDialog.fxml"));

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

            ContactDialogController controller = fxmlLoader.getController();

            contactData.addContact(controller.getContact());
            contactData.saveContacts();


            System.out.println("OK pressed");
        } else {
            System.out.println("Cancel pressed");
        }

    }

    public void showEditDialog(ActionEvent event) {

        Contact contact = contactsTableView.getSelectionModel().getSelectedItem();

        if (contact == null){
            System.out.println("Contact is null, select proper contact");
        } else {
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.initOwner(mainVBox.getScene().getWindow());
            dialog.setTitle("Edit Contact");

            FXMLLoader fxmlLoader = new FXMLLoader();

            fxmlLoader.setLocation(getClass().getResource("ContactDialog.fxml"));

            try{
                dialog.getDialogPane().setContent(fxmlLoader.load());

            } catch (IOException e){
                System.out.println("Couldn't open the dialog");
                e.printStackTrace();
            }

            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

            ContactDialogController controller = fxmlLoader.getController();
            controller.editContact(contact);


            Optional<ButtonType> result = dialog.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK){

                contactData.removeContact(contact);
                contactData.addContact(controller.getContact());
                contactData.saveContacts();

                System.out.println("OK pressed");
            } else {
                System.out.println("Cancel pressed");
            }
        }

    }

}
