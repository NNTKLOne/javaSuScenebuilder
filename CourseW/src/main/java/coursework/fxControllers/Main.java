package coursework.fxControllers;

import coursework.hibenateControllers.GenericHibernate;
import coursework.model.Client;
import coursework.model.User;
import coursework.model.Admin;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Main {
    @FXML
    public ListView<User> userListField;
    public TextField loginField;
    public TextField nameField;
    public PasswordField pswField;
    public TextField surnameField;
    public TextField addressField;
    public DatePicker bDate;
    public TextField phoneField;
    public RadioButton radioButton;

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("coursework");

    public void createNewUser() {
        Client client = new Client(loginField.getText(), pswField.getText(), nameField.getText(), surnameField.getText(), addressField.getText(), bDate.getValue());
        GenericHibernate hibernate = new GenericHibernate(entityManagerFactory);

        hibernate.create(client);
    }

    public void createNewAdmin() {
        Admin admin = new Admin(loginField.getText(), pswField.getText(), nameField.getText(), surnameField.getText(), phoneField.getText());
        GenericHibernate hibernate = new GenericHibernate(entityManagerFactory);

        hibernate.create(admin);
    }

    public void userRadioButton()
    {
        phoneField.setDisable(false);
        addressField.setDisable(true);
        bDate.setDisable(true);
    }
    public void adminRadioButton()
    {
        phoneField.setDisable(true);
        addressField.setDisable(false);
        bDate.setDisable(false);
    }

//    public void showUserList() {
//        userListField.getItems().add();
//        userfi
//    }
}
